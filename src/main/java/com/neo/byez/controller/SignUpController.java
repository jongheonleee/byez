package com.neo.byez.controller;


import com.neo.byez.domain.UserDto;
import com.neo.byez.service.MailService;
import com.neo.byez.service.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
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
@RequestMapping("/register")
public class SignUpController {
    // 생성자 주입
    // 주입받은 객체가 변하지 않거나(불변성 보장), 반드시 객체 주입이 필요한 경우
    private UserServiceImpl userService;
    private MailService mailService;
    private BCryptPasswordEncoder passwordEncoder; // for PWD 암호화

    @Autowired // 애너테이션 생략 가능
    public SignUpController(UserServiceImpl userService, MailService mailService, BCryptPasswordEncoder passwordEncoder) {
        this.userService = userService;
        this.mailService = mailService;
        this.passwordEncoder = passwordEncoder;
    }

    @InitBinder
    public void checkDataFormat(WebDataBinder binder) {
        binder.setValidator(new SignUpValidator());
    }

    // 1. 회원가입 버튼 클릭 시 본 Controller 로 이동
    @GetMapping("/verify")
    public String verify() {
        return "requestEmailForm";
    }

    // 1.1. 이메일로 본인 인증 절차 진행
    // 1.1.1. 입력받은 이메일 주소로 인증번호 전송
    // 1.1.1.2. 메일 전송 실패 시 메일 입력 페이지로 다시 이동
    // 1.1.1.3. 메일 전송 성공 시 인증번호 입력 페이지로 이동
    String randomMailKey = ""; // 메일로 전송한 인증번호 저장
    @PostMapping("/send")
    public String sendEmailToNonMember(String email, Model model) {
        randomMailKey = mailService.sendMailToNonMember(email);
        if (randomMailKey == null) {
            String failToSendMsg = "메일 전송에 실패하였습니다. 메일주소를 다시 입력해주세요.";
            model.addAttribute("failMsg", failToSendMsg);
            return "requestEmailForm";
        } else {
            return "selfVerification";
        }
    }

    // 1.1.2. 인증 번호 비교하여 본인 인증 성공/실패 확인
    // 1.1.2.1. 본인 인증 실패 시 selfVerification.jsp (인증 번호 입력 페이지) 로 이동
    // 1.1.2.2. 본인 인증 성공 시 register.jsp (회원가입 정보 입력 페이지) 로 이동
    @PostMapping("/verification")
    public String verifyAuthenticationCode(String mail_key, Model model) {
        // randomMailKey: 메일로 전송한 인증번호
        // userInput: 고객으로부터 입력받은 인증번호
        String userInput = mail_key;
        if (!userInput.equals(randomMailKey)) {
            String mismatchMsg = "인증번호가 일치하지 않습니다. 다시 입력하십시오.";
            model.addAttribute("failMsg", mismatchMsg);
            return "selfVerification";
        } else {
            return "register";
        }
    }

    // 2. 고객 기본정보 입력 후 본 Controller 로 form 전송
    // 2.1. 고객이 입력한 데이터 유효성 검증 (SignUpValidator)
    @PostMapping("/save")
    public String saveCustInfo(@Valid UserDto userDto, BindingResult result, Model model) {
        if (result.hasErrors()) {
            List<ObjectError> errorMsgs = result.getAllErrors();
            model.addAttribute("errorMsg", errorMsgs.get(0).getCode());
            return "register";
        }

        // 입력란에서 비밀번호 및 비밀번호 확인용으로 2개 받아옴.
        // split() 메서드로 , 기준으로 나눠서 저장
        // Validator 에서 2개의 비밀번호 일치여부 확인 완료
        String pwd1 = userDto.getPwd().split(",")[0];

        // DB에 저장할 데이터가 저장된 userDto에 하나의 pwd 값만 저장
        userDto.setPwd(pwd1);

        // PWD : 아이디 값 포함 불가
        if (pwd1.contains(userDto.getId())) {
            model.addAttribute("errorMsg", PASSWORD_CONTAINS_ID.getMessage());
            return "register";
        }

        String password = passwordEncoder.encode(userDto.getPwd());
        userDto.setPwd(password);

        // 3. 회원가입 완료
        // 3.1. 입력받은 데이터 DB 저장
        // 3.2. 회원가입 성공 시
        // 3.2.1. 로그인 화면(/login/form)으로 이동
        if (userService.saveCustJoinInfo(userDto) == 1) {
            return "redirect:/login/form";
        }
        // 3.3. 회원가입 실패 시
        // 3.3.1. 회원가입 페이지(register)로 이동
        else {
            model.addAttribute("errorMsg", DUPLICATED_ID.getMessage());
            return "register";
        }
    }
}