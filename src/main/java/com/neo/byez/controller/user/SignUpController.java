package com.neo.byez.controller.user;

import com.neo.byez.common.validator.DataValidator;
import com.neo.byez.common.validator.SignUpValidator;
import com.neo.byez.dao.item.BasketDaoImpl;
import com.neo.byez.domain.user.UserDto;
import com.neo.byez.service.CustCouponsServiceImpl;
import com.neo.byez.service.user.MailService;
import com.neo.byez.service.user.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

import static com.neo.byez.common.message.ValidatorMessage.*;

@Controller
@RequestMapping(value = "/register", produces = "application/text;charset=UTF-8")
public class SignUpController {
    // 생성자 주입
    // 주입받은 객체가 변하지 않거나(불변성 보장), 반드시 객체 주입이 필요한 경우
    private UserServiceImpl userService;
    private MailService mailService;
    private BCryptPasswordEncoder passwordEncoder; // for PWD 암호화
    private DataValidator dataValidator;
    private CustCouponsServiceImpl custCouponsService;

    @Autowired // 애너테이션 생략 가능
    public SignUpController(UserServiceImpl userService, MailService mailService, BCryptPasswordEncoder passwordEncoder, DataValidator dataValidator, CustCouponsServiceImpl custCouponsService) {
        this.userService = userService;
        this.mailService = mailService;
        this.passwordEncoder = passwordEncoder;
        this.dataValidator = dataValidator;
        this.custCouponsService = custCouponsService;
    }

    @InitBinder
    public void checkDataFormat(WebDataBinder binder) {
        binder.setValidator(new SignUpValidator());
    }

    // 1. 회원가입 버튼 클릭 시 본 Controller 로 이동
    @GetMapping("/verify")
    public String verify() {
        return "/user/requestEmailForm";
    }

    String randomMailKey = ""; // 메일로 전송한 인증번호 저장

    // 1.1. 이메일로 본인 인증 절차 진행
    // 1.1.1. 입력받은 이메일 주소로 인증번호 전송
    // 1.1.1.2. 메일 전송 실패 시 다시 시도
    // 1.1.1.3. 메일 전송 성공 시 인증번호 입력란 출력
    @PostMapping("/send")
    @ResponseBody
    public ResponseEntity<String> sendVerificationEmail(String email) {
        UserDto userDto = new UserDto();
        userDto.setEmail(email);

        try {
            if (userService.findUserId(userDto) != null) {
                return new ResponseEntity<>("해당 이메일은 이미 사용 중입니다.", HttpStatus.BAD_REQUEST);
            } else {
                randomMailKey = mailService.sendMailToNonMember(email); // 이메일 주소로 인증번호 전송
                return new ResponseEntity<>("인증번호 전송 성공", HttpStatus.OK);
            }
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>("인증번호 전송에 실패했습니다.", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    // 1.1.2. 인증 번호 비교하여 본인 인증 성공/실패 확인
    // 1.1.2.1. 본인 인증 실패 시 다시 시도
    // 1.1.2.2. 본인 인증 성공 시 register_old.jsp (회원가입 정보 입력 페이지) 로 이동
    @PostMapping("/verifyEmail")
    public ResponseEntity<String> verifyEmailAuthCode(String verificationCode) {
        try {
            if (verificationCode.equals(randomMailKey)) {
                return new ResponseEntity<>("인증번호가 일치합니다.", HttpStatus.OK);
            } else {
                return new ResponseEntity<>("잘못된 인증번호를 입력하셨습니다.", HttpStatus.INTERNAL_SERVER_ERROR);
            }
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>("인증 실패", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

//    // @SessionAttribute 활용 위해 추가
//    @ModelAttribute("userDto")
//    public UserDto userDto() {
//        return new UserDto();
//    }

    @GetMapping("/form")
    public String moveToRegisterForm() {
        return "/user/register";
    }

    // ID 중복확인
    @PostMapping("/checkDuplicatedId")
    @ResponseBody
    public ResponseEntity<String> checkDuplicatedId (String id) {
        try {
            if (!dataValidator.validateOfID(id)) {
                return new ResponseEntity<>(dataValidator.getWrongIdFormat(), HttpStatus.BAD_REQUEST);
            } else if (userService.checkDuplicatedId(id) != null) {
                return new ResponseEntity<>(DUPLICATED_ID.getMessage(), HttpStatus.BAD_REQUEST);
            } else {
                return new ResponseEntity<>("사용가능한 아이디입니다.", HttpStatus.OK);
            }
        } catch (Exception e) {
            return new ResponseEntity<>("오류 발생!", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    // 2. 고객 기본정보 입력 후 본 Controller 로 form 전송
    // 2.1. 고객이 입력한 데이터 유효성 검증 (SignUpValidator)
    @PostMapping("/save")
    public String saveCustInfo(@Valid @ModelAttribute("userDto") UserDto userDto, BindingResult result, Model model) throws Exception {
        if (result.hasErrors()) {
            List<ObjectError> errorMsgs = result.getAllErrors();
            model.addAttribute("errorMsg", errorMsgs.get(0).getCode());
            return "/user/register";
        }

          // ajax 로 처리 완료
          // 입력된 아이디가 이미 DB에 저장된 아이디인 경우, 중복된 아이디임을 메세지로 출력
//        if (userService.checkDuplicatedId(userDto.getId()) != null) {
//            model.addAttribute("errorMsg", DUPLICATED_ID.getMessage());
//            return "/user/register";
//        }

        // 입력란에서 비밀번호 및 비밀번호 확인용으로 2개 받아옴.
        // split() 메서드로 , 기준으로 나눠서 저장
        // Validator 에서 2개의 비밀번호 일치여부 확인 완료
        String pwd1 = userDto.getPwd().split(",")[0];

        // DB에 저장할 데이터가 저장된 userDto에 하나의 pwd 값만 저장
        userDto.setPwd(pwd1);

        // PWD : 아이디 값 포함 불가
        if (pwd1.contains(userDto.getId())) {
            model.addAttribute("errorMsg", PASSWORD_CONTAINS_ID.getMessage());
            return "/user/register";
        }

        String password = passwordEncoder.encode(userDto.getPwd());
        userDto.setPwd(password);

        // 3. 회원가입 완료
        // 3.1. 입력받은 데이터 DB 저장
        // 3.2. 회원가입 성공 시
        // 3.2.1. 로그인 화면(/login/form)으로 이동
        if (userService.saveCustJoinInfo(userDto) == 1) {
            // 신규 고객 쿠폰 임시로 추가 - 진우 (+ 예외 선언)
            custCouponsService.grantCouponToUser(userDto.getId(),"신규 고객 쿠폰");
            return "redirect:/login/form";
        }
        // 3.3. 회원가입 실패 시
        // 3.3.1. 회원가입 페이지(register)로 이동
        else {
            model.addAttribute("errorMsg", "잘못 입력하셨습니다. 다시 작성해주세요.");
            return "/user/register";
        }
    }
}