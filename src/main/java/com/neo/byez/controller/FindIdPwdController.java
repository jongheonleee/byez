package com.neo.byez.controller;

import com.neo.byez.domain.UserDto;
import com.neo.byez.service.MailService;
import com.neo.byez.service.UserServiceImpl;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/find")
public class FindIdPwdController {

    private UserServiceImpl userService;
    private MailService mailService;
    private BCryptPasswordEncoder passwordEncoder;
    private DataValidator dataValidator; // 유효성 검증

    public FindIdPwdController(UserServiceImpl userService, MailService mailService,
                               BCryptPasswordEncoder passwordEncoder, DataValidator dataValidator) {
        this.userService = userService;
        this.mailService = mailService;
        this.passwordEncoder = passwordEncoder;
        this.dataValidator = dataValidator;
    }

    // 아이디, 비밀번호 찾기 화면으로 이동
    @GetMapping("/authorize")
    public String findIdAndPwd() {
        return "findIdAndPwdPage";
    }

    // 아이디 찾기 화면으로 이동
    @GetMapping("/findIdForm")
    public String findIdForm() {
        return "findIdForm";
    }

    // findIdForm -> 인증번호 입력 화면으로 이동
    // 이메일 입력 받아서 userDto 객체에 담아 parameter 값으로 전달 받음
    @PostMapping("/verify")
    public String verifyEmail(UserDto userDto, Model model) throws Exception {

        // 1. 입력된 이메일 유효성 검증
        // 1.1. DataValidator 클래스 내 validateOfEmail() 메서드 활용
        // 1.1.1. 올바른 형식의 이메일인지 확인
        String email = userDto.getEmail();
        if (!dataValidator.validateOfEmail(email)) {
            model.addAttribute("wrongFormat", dataValidator.getWrongEmailFormat());
        }

        // 2. 입력 받은 이메일을 조회하여 해당 고객 아이디 존재여부 확인
        // 2.1. ID 존재하는 경우
        // 2.1.1. 이메일이 저장된 dto 객체에 아이디 추가 저장
        // 2.1.2. 새롭게 생성한 인증번호 이메일로 전송 및 DB에 저장
        // 2.1.3. 아이디와 이메일 정보 저장된 객체를 모델 객체에 담아서 인증번호 입력 화면으로 이동
        if (userService.findUserId(userDto) != null) {
            UserDto foundIdDto = userService.findUserId(userDto);
            mailService.sendMailToUser(foundIdDto);
            model.addAttribute("userDto", foundIdDto);
            return "verificationCode";
        }
        // 2.2. ID 존재하지 않는 경우
        // 2.2.1. NotFoundException 예외 처리하여 예외 메세지를 유저에게 보여줌
        // 2.2.2. 그 외 예외 발생 시 오류 페이지로 이동
        else {
            model.addAttribute("nonMemberMsg", "아이디를 찾을 수 없습니다.");
            return "findIdForm";
        }
    }

    @GetMapping("/findId")
    public String findId(String email, String mail_key, Model model) throws Exception {
        UserDto userDto = new UserDto();
        userDto.setEmail(email);

        // 아이디 찾아서 아이디로 조회한 고객 컬럼에 인증번호 저장
        String foundId = userService.findUserId(userDto).getId();
        userDto.setId(foundId);

        // DB에 저장한 인증번호와 고객이 입력한 인증번호 비교
        String mailKeyOfDB = userService.getCustLoginInfo(foundId).getMail_key();
        if (!mail_key.equals(mailKeyOfDB)) {
            model.addAttribute("userDto", userDto);
            model.addAttribute("incorrectCodeMsg", "입력하신 인증번호가 일치하지 않습니다.");
            return "verificationCode";
        } else {
            model.addAttribute("id", userDto.getId());
            return "findIdResult";
        }
    }

    // 비밀번호 찾기
    @GetMapping("/findPwdForm")
    public String findPwdForm() {
        return "findPwdForm";
    }

    @PostMapping("/verify2")
    public String verifyIdAndEmail(UserDto userDto, Model model) throws Exception {
        String inputId = userDto.getId();
        String inputEmail = userDto.getEmail();

        // 1. ID, Email 유효성 검증
        if (!dataValidator.validateOfID(inputId)) {
            model.addAttribute("wrongIdFormat", dataValidator.getWrongIdFormat());
            return "findPwdForm";
        } else if (!dataValidator.validateOfEmail(inputEmail)) {
            model.addAttribute("wrongEmailFormat", dataValidator.getWrongEmailFormat());
            return "findPwdForm";
        }

        // 2. 입력된 ID 조회 가능 여부 확인
        // 2.1. ID 조회 불가능
        // 2.1.1. 오류 메세지 모델 객체에 담아서 비밀번호 찾기 화면으로 이동
        String userEmail;
        if (userService.getCustLoginInfo(inputId) != null) {
            userEmail = userService.getCustLoginInfo(inputId).getEmail();
        } else {
            model.addAttribute("memberShipCheckMsg", "존재하지 않는 아이디입니다.");
            return "findPwdForm";
        }

        // 2.1. ID 조회 가능
        // 2.1.1. ID로 조회한 DB에 저장된 이메일과 고객이 입력한 이메일 일치여부 확인
        // 2.1.1.1. 일치 시 인증 메일 전송
        // 2.1.1.2. 일치 시 id, email 값을 모델 객체에 담아서 메일인증 페이지로 보냄
        if (userEmail.equals(inputEmail)) {
            mailService.sendMailToUser(userDto);
            // 아이디, 비밀번호 찾기 페이지 구분을 위해 findPwd 속성 및 값 생성하여 model 객체에 담아 전달해줌.
            model.addAttribute("findPwd", "findPwd");
            model.addAttribute("userDto", userDto);
            return "verificationCode";
        }

        // 2.2. ID 조회 불가능
        // 2.2.1. 오류메세지 모델 객체에 담아서 다시 비밀번호 찾기 페이지로 이동
        else {
            model.addAttribute("wrongIdOrEmailMsg", "아이디 또는 이메일을 다시 확인하십시오.");
            return "findPwdForm";
        }
    }

    // 1. 인증번호 일치여부 확인
    // 1.1. 일치 시 비밀번호 변경 화면으로 이동
    // 1.2. 불일치 시 인증번호 확인 화면으로 이동
    @GetMapping("/findPwd")
    public String findPwd(UserDto userDto, Model model) throws Exception {
        String id = userDto.getId();
        String mail_key = userDto.getMail_key();

        // DB에 저장한 인증번호와 고객이 입력한 인증번호 비교
        String mailKeyOfDB = userService.getCustLoginInfo(id).getMail_key();
        if (!mail_key.equals(mailKeyOfDB)) {
            model.addAttribute("userDto", userDto);
            model.addAttribute("incorrectCodeMsg", "입력하신 인증번호가 일치하지 않습니다.");
            // 비밀번호 변경에 대한 인증번호 입력 페이지 활성화
            model.addAttribute("findPwd", "findPwd");
            return "verificationCode";
        } else {
            model.addAttribute("id", id);
            return "modifyPage";
        }
    }

    @GetMapping("/modify")
    public String modifyUserPwd(UserDto userDto, Model model) throws Exception {
        String id = userDto.getId();
        String pwd1 = userDto.getPwd().split(",")[0];
        String pwd2 = userDto.getPwd().split(",")[1];

        // DB 에서 조회한 기존 비밀번호
        String dbPwd = userService.getCustLoginInfo(id).getPwd();
        // 변경하려는 비밀번호
        String rawPwd = pwd1;

        // 1. 비밀번호 입력 여부 확인
        // 1.1. 입력하지 않은 경우 OR 공백 입력한 경우
        // 1.1.2.  비밀번호 변경 페이지로 다시 이동
        if (!dataValidator.validateOfPwd(pwd1) || !dataValidator.validateOfPwd(pwd2)) {
            model.addAttribute("id", id);
            model.addAttribute("incorrectPwdMsg", dataValidator.getWrongPwdFormat());
            return "modifyPage";
        }

        // 2. 비밀번호/비밀번호 재확인
        // 2.1. 동일한 비밀번호 입력여부 확인
        // 2.2. 비밀번호 불일치 시 비밀번호 변경 페이지로 다시 이동
        else if(!pwd1.equals(pwd2)) {
            model.addAttribute("id", id);
            model.addAttribute("incorrectPwdMsg", "비밀번호가 일치하지 않습니다. 다시 입력하십시오.");
            return "modifyPage";
        }

        // 3. 변경 전/후 비밀번호 비교 (암호화된 비밀번호로 비교)
        // 3.1. 변경 전 비밀번호와 동일한 비밀번호 입력한 경우
        // 3.1.1. 비밀번호 재변경 하도록 비밀번호 변경 페이지로 이동
        else if (authenticatePwd(rawPwd, dbPwd)) {
            model.addAttribute("id", id);
            model.addAttribute("incorrectPwdMsg", "이전 비밀번호와 동일합니다. 다시 입력하십시오.");
            return "modifyPage";
        }

        // 4. 비밀번호 업데이트
        // 4.1. 아이디를 통해 특정 고객 조회
        // 4.2. 변경하고자 하는 비밀번호를 암호화하여 업데이트
        // 4.3. 로그인 페이지로 이동
        String encodedPwd = passwordEncoder.encode(rawPwd);
        userService.modifyUserPwd(id, encodedPwd);
        model.addAttribute("id", id);
        return "loginForm";
    }

    // 암호화 전후 비밀번호 비교
    public boolean authenticatePwd(String rawPwd, String encodedPwd) {
        return passwordEncoder.matches(rawPwd, encodedPwd);
    }
}