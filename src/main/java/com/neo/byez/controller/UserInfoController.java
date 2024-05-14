package com.neo.byez.controller;

import com.neo.byez.domain.UserDto;
import com.neo.byez.service.MailService;
import com.neo.byez.service.UserInfoHistServiceImpl;
import com.neo.byez.service.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Controller
@RequestMapping(value = "/mypage", produces = "application/text;charset=UTF-8")
public class UserInfoController {
    private UserServiceImpl userService;
    private MailService mailService;
    private BCryptPasswordEncoder passwordEncoder; // for PWD 암호화
    private DataValidator dataValidator;
    private UserInfoHistServiceImpl userInfoHistService;

    @Autowired
    public UserInfoController(UserServiceImpl userService, MailService mailService, UserInfoHistServiceImpl userInfoHistService,
                              BCryptPasswordEncoder passwordEncoder, DataValidator dataValidator) {
        this.userService = userService;
        this.mailService = mailService;
        this.userInfoHistService = userInfoHistService;
        this.passwordEncoder = passwordEncoder;
        this.dataValidator = dataValidator;
    }

    @InitBinder
    public void checkDataFormat(WebDataBinder binder) {
        binder.setValidator(new LoginValidator());
    }

    @GetMapping("/modifyPage")
    public String moveToModifyPage(HttpServletRequest request, Model model) {
        HttpSession session = request.getSession();
        String id = (String) session.getAttribute("userId");
        model.addAttribute("userDto", userService.getCustLoginInfo(id));
        return "userInfo";
    }

    // * 비밀번호 변경
    // 1. 현재 비밀번호 일치 여부 확인
    // 1.1. 현재 비밀번호 일치하는 경우
    // 1.1.1. 변경된 비밀번호 고객 정보에 저장 및 비밀번호 변경이력 추가
    // 1.2. 현재 비밀번호 일치하지 않은 경우
    // 1.2.1. 기존 화면에서 오류메세지 출력
    @PostMapping("/modifyPwd")
    public ResponseEntity<String> modifyPwd(String id, String pwd, String newPwd) {
        try {
            if (!dataValidator.validateOfPwd(newPwd)) {
                return new ResponseEntity<>(dataValidator.getWrongPwdFormat(), HttpStatus.BAD_REQUEST);
            }

            if (userService.checkPwdMatch(id, pwd)) {
                String encodedPwd = passwordEncoder.encode(newPwd);
                userService.modifyUserPwd(id, encodedPwd);
                return new ResponseEntity<>("비밀번호 변경 성공!", HttpStatus.OK);
            } else {
                return new ResponseEntity<>("비밀번호가 틀렸습니다.", HttpStatus.BAD_REQUEST);
            }
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>("비밀번호 변경에 실패했습니다.", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    // @ 이메일 변경
    // 1. 새로운 이메일 주소 중복 여부 확인
    // 1.1. 중복된 이메일인 경우
    // 1.1.1. 오류메세지 출력
    // 1.2. 중복되지 않은 이메일인 경우
    // 1.2.1. 새로운 이메일 주소로 인증번호 전송
    @PostMapping(value = "/sendEmailVerification")
    @ResponseBody
    public ResponseEntity<String> sendVerificationEmail(String id, String newEmail) {
        UserDto userDto = new UserDto();
        userDto.setEmail(newEmail);
        try {
            if (userService.findUserId(userDto) != null) {
                return new ResponseEntity<>("해당 이메일은 이미 사용 중입니다.", HttpStatus.BAD_REQUEST);
            } else {
                String validationCode = mailService.sendMailToNonMember(newEmail); // 새로운 이메일 주소로 인증번호 전송
                String email = userService.getCustLoginInfo(id).getEmail(); // 기존 이메일 주소

                // 고객 정보에 메일 인증번호 저장
                // 인증번호 저장 시 필요한 값: email, id, mail_key
                UserDto userDtoToSaveMailKey = new UserDto();
                userDtoToSaveMailKey.setEmail(email);
                userDtoToSaveMailKey.setId(id);
                userDtoToSaveMailKey.setMail_key(validationCode);
                userService.saveCustMailKey(userDtoToSaveMailKey);

                return new ResponseEntity<>("인증번호 전송 성공", HttpStatus.OK);
            }
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>("인증번호 전송에 실패했습니다.", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    // 1. 사용자가 입력한 인증번호가 메일로 전송된 인증번호와 일치하는지 확인
    // 1.1. 일치하는 경우
    // 1.1.1. 변경된 메일 주소를 고객 정보에 저장
    // 1.1.2. 메일 주소 변경이력 저장
    // 1.2. 일치하지 않는 경우
    // 1.2.1. 기존 화면에서 불일치에 대한 오류 메세지 출력
    @PostMapping("/verifyEmail")
    public ResponseEntity<String> verifyEmail(String id, String newEmail, String verificationCode) {
        try {
            String dbMailKey = userService.getCustLoginInfo(id).getMail_key();
            if (verificationCode.equals(dbMailKey)) {
                userService.modifyUserEmail(id, newEmail); // 이메일 변경
                return new ResponseEntity<>("인증번호가 일치합니다.", HttpStatus.OK);
            } else {
                return new ResponseEntity<>("잘못된 인증번호를 입력하셨습니다.", HttpStatus.INTERNAL_SERVER_ERROR);
            }
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>("인증 실패", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
