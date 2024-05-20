package com.neo.byez.controller.user;

import com.neo.byez.common.validator.DataValidator;
import com.neo.byez.common.message.ValidatorMessage;
import com.neo.byez.domain.user.UserDto;
import com.neo.byez.service.user.MailService;
import com.neo.byez.service.user.UserServiceImpl;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping(value = "/find", produces = "application/text;charset=UTF-8")
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
        return "/user/findIdAndPwdPage";
    }

    // 아이디 찾기 화면으로 이동
    @GetMapping("/findIdForm")
    public String findIdForm() {
        return "/user/findIdForm";
    }

    // findIdForm -> 인증번호 입력 화면으로 이동
    // 이메일 입력 받아서 userDto 객체에 담아 parameter 값으로 전달 받음
    @PostMapping("/verify")
    @ResponseBody
    public ResponseEntity<String> sendVerificationEmail(String email) {
        // 1. 입력된 이메일 유효성 검증
        // 1.1. DataValidator 클래스 내 validateOfEmail() 메서드 활용
        // 1.1.1. 올바른 형식의 이메일인지 확인
        if (!dataValidator.validateOfEmail(email)) {
            return new ResponseEntity<>(dataValidator.getWrongEmailFormat(), HttpStatus.BAD_REQUEST);
        }

        // 2. 입력 받은 이메일을 조회하여 해당 고객 아이디 존재여부 확인
        // 2.1. ID 존재하는 경우
        // 2.1.1. 이메일이 저장된 dto 객체에 아이디 추가 저장
        // 2.1.2. 새롭게 생성한 인증번호 이메일로 전송 및 DB에 저장
        // 2.1.3. 아이디와 이메일 정보 저장된 객체를 모델 객체에 담아서 인증번호 입력 화면으로 이동
        UserDto userDto = new UserDto();
        userDto.setEmail(email);
        if (userService.findUserId(userDto) != null) {
            UserDto foundIdDto = userService.findUserId(userDto);
            mailService.sendMailToUser(foundIdDto);
            return new ResponseEntity<>("인증번호 전송 성공", HttpStatus.OK);
        }
        // 2.2. ID 존재하지 않는 경우
        // 2.2.1. NotFoundException 예외 처리하여 예외 메세지를 유저에게 보여줌
        // 2.2.2. 그 외 예외 발생 시 오류 페이지로 이동
        else {
            return new ResponseEntity<>("아이디를 찾을 수 없습니다.", HttpStatus.BAD_REQUEST);
        }
    }

    String foundId; // 조회된 아이디
    @PostMapping("findId")
    public ResponseEntity<String> verifyFindIdEmail(String email, String verificationCode) {
        UserDto userDto = new UserDto();
        userDto.setEmail(email);

        // 아이디 찾아서 아이디로 조회한 고객 컬럼에 인증번호 저장
        foundId = userService.findUserId(userDto).getId();
        userDto.setId(foundId);

        // DB에 저장한 인증번호와 고객이 입력한 인증번호 비교
        String mailKeyOfDB = userService.getCustLoginInfo(foundId).getMail_key();
        if (!verificationCode.equals(mailKeyOfDB)) {
            return new ResponseEntity<>("입력하신 인증번호가 일치하지 않습니다.", HttpStatus.BAD_REQUEST);
        } else {
            return new ResponseEntity<>("본인인증 성공", HttpStatus.OK);
        }
    }

    @GetMapping("myId")
    public String findIdResult(Model model) {
        model.addAttribute("id", foundId);
        return "/user/findIdResult";
    }

    // 비밀번호 찾기
    @GetMapping("/findPwdForm")
    public String findPwdForm() {
        return "/user/findPwdForm";
    }

    @PostMapping("/verify2")
    @ResponseBody
    public ResponseEntity<String> sendVerificationEmail(String id, String email) {
        try {
            // 1. ID, Email 유효성 검증
            if (!dataValidator.validateOfID(id)) {
                return new ResponseEntity<>(dataValidator.getWrongIdFormat(), HttpStatus.BAD_REQUEST);
            } else if (!dataValidator.validateOfEmail(email)) {
                return new ResponseEntity<>(dataValidator.getWrongEmailFormat(), HttpStatus.BAD_REQUEST);
            }

            // 2. 입력된 ID 조회 가능 여부 확인
            // 2.1. ID 조회 불가능
            // 2.1.1. 비밀번호 찾기 화면에서 오류 메세지 출력
            String userEmail;
            if (userService.getCustLoginInfo(id) != null) {
                userEmail = userService.getCustLoginInfo(id).getEmail();
            } else {
                return new ResponseEntity<>("존재하지 않는 아이디입니다.", HttpStatus.BAD_REQUEST);
            }

            // 2.1. ID 조회 가능
            // 2.1.1. ID로 조회한 DB에 저장된 이메일과 고객이 입력한 이메일 일치여부 확인
            // 2.1.1.1. 일치 시 인증 메일 전송
            // 2.1.1.2. 일치 시 메일 인증번호 입력 절차 진행
            UserDto userDto = new UserDto();
            userDto.setId(id);
            userDto.setEmail(email);

            if (userEmail.equals(email)) {
                mailService.sendMailToUser(userDto);
                return new ResponseEntity<>("인증번호 전송 성공", HttpStatus.OK);
            }

            // 2.2. ID 조회 불가능
            // 2.2.1. 오류메세지 모델 객체에 담아서 다시 비밀번호 찾기 페이지로 이동
            else {
                return new ResponseEntity<>("아이디 또는 이메일을 다시 확인하십시오.", HttpStatus.BAD_REQUEST);
            }
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>("인증번호 전송에 실패했습니다.", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    // 1. 인증번호 일치여부 확인
    // 1.1. 일치 시 비밀번호 변경 화면으로 이동
    // 1.2. 불일치 시 인증번호 확인 화면으로 이동

    // 인증번호 일치 시 userId 저장하여 변경된 비밀번호 저장 시 활용
    String userId;
    @PostMapping("/findPwd")
    @ResponseBody
    public ResponseEntity<String> verifyFindPwdEmail(String id, String verificationCode) {
        // DB에 저장한 인증번호와 고객이 입력한 인증번호 비교
        // 일치 시 비밀번호 변경에 대한 인증번호 입력란 활성화
        try {
            String mailKeyOfDB = userService.getCustLoginInfo(id).getMail_key();
            if (!verificationCode.equals(mailKeyOfDB)) {
                return new ResponseEntity<>("잘못된 인증번호를 입력하셨습니다.", HttpStatus.INTERNAL_SERVER_ERROR);
            } else {
                userId = id;
                return new ResponseEntity<>("인증번호가 일치합니다.", HttpStatus.OK);
            }
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>("인증 실패", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/move")
    public String moveToModifyPwdPage(Model model) {
        model.addAttribute("id", userId);
        return "/user/modifyPwdPage";
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
        // 1.1. 유효성 검증
        // 1.1.1. 입력하지 않은 경우 OR 공백 입력한 경우
        // 1.1.2. 지정된 글자수 범위 벗어난 경우 (8 ~ 20자)
        // 1.1.3. 영문, 숫자, 특수문자 조합 아닌 경우
        // 1.1.4. 4자리 이상 연속되는 숫자 입력한 경우
        // 1.1.5. 비밀번호에 아이디 포함된 경우
        // 1.2.  비밀번호 변경 페이지로 다시 이동
        if (!dataValidator.validateOfPwd(rawPwd)) {
            model.addAttribute("id", id);
            model.addAttribute("incorrectPwdMsg", dataValidator.getWrongPwdFormat());
            return "/user/modifyPwdPage";
        }

        else if (rawPwd.contains(id)) {
            model.addAttribute("id", id);
            model.addAttribute("incorrectPwdMsg", ValidatorMessage.PASSWORD_CONTAINS_ID.getMessage());
            return "/user/modifyPwdPage";
        }

        // 2. 비밀번호/비밀번호 재확인
        // 2.1. 동일한 비밀번호 입력여부 확인
        // 2.2. 비밀번호 불일치 시 비밀번호 변경 페이지로 다시 이동
        else if(!pwd1.equals(pwd2)) {
            model.addAttribute("id", id);
            model.addAttribute("incorrectPwdMsg", "비밀번호가 일치하지 않습니다. 다시 입력하십시오.");
            return "/user/modifyPwdPage";
        }

        // 3. 변경 전/후 비밀번호 비교 (암호화된 비밀번호로 비교)
        // 3.1. 변경 전 비밀번호와 동일한 비밀번호 입력한 경우
        // 3.1.1. 비밀번호 재변경 하도록 비밀번호 변경 페이지로 이동
        else if (authenticatePwd(rawPwd, dbPwd)) {
            model.addAttribute("id", id);
            model.addAttribute("incorrectPwdMsg", "이전 비밀번호와 동일합니다. 다시 입력하십시오.");
            return "/user/modifyPwdPage";
        }

        // 4. 비밀번호 업데이트
        // 4.1. 아이디를 통해 특정 고객 조회
        // 4.2. 변경하고자 하는 비밀번호를 암호화하여 업데이트
        // 4.3. 로그인 페이지로 이동
        String encodedPwd = passwordEncoder.encode(rawPwd);
        userService.modifyUserPwd(id, encodedPwd);
        model.addAttribute("id", id);
        return "/user/loginForm";
    }

    // 암호화 전후 비밀번호 비교
    public boolean authenticatePwd(String rawPwd, String encodedPwd) {
        return passwordEncoder.matches(rawPwd, encodedPwd);
    }
}