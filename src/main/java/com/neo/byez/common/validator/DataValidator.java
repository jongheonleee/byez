package com.neo.byez.common.validator;


import static com.neo.byez.common.message.ValidatorMessage.*;

import org.springframework.stereotype.Component;


@Component
public class DataValidator {
    private String wrongIdFormat;
    private String wrongPwdFormat;
    private String wrongEmailFormat;

    DataValidator(){
        this.wrongIdFormat = "";
        this.wrongPwdFormat = "";
        this.wrongEmailFormat = "";
    }

    DataValidator(String wrongIdFormat, String wrongPwdFormat, String wrongEmailFormat) {
        this.wrongIdFormat = wrongIdFormat;
        this.wrongPwdFormat = wrongPwdFormat;
        this.wrongEmailFormat = wrongEmailFormat;
    }

    // 아이디 - 유효성 검증 메서드
    public boolean validateOfID(String id) {
        if (id.isEmpty() || id.isBlank()) {
            wrongIdFormat = ID_LENGTH_OUT_OF_BOUNDS.getMessage();
            return false;
        } else if (id.contains(" ") || !id.matches("^[a-zA-Z0-9]*")) {
            wrongIdFormat = INVALID_ID_FORMAT.getMessage();
            return false;
        } else if (id.length() < 3 || id.length() > 20) {
            wrongIdFormat = ID_LENGTH_OUT_OF_BOUNDS.getMessage();
            return false;
        }
        return true;
    }

    // 비밀번호 - 유효성 검증 메서드
    public boolean validateOfPwd(String pwd) {

        // PWD : 입력 안한 경우
        if (pwd.isEmpty() || pwd.isBlank()) {
            wrongPwdFormat = PASSWORD_MISSING.getMessage();
            return false;
        }
        // PWD : 공백(띄어쓰기) 허용 안함
        else if(pwd.contains(" ")) {
            wrongPwdFormat = INVALID_PASSWORD_FORMAT.getMessage();
            return false;
        }

        // PWD : 지정된 글자수 범위를 벗어난 경우 (8자 이상, 20자 이하)
        else if (pwd.length() < 8 || pwd.length() > 20) {
            wrongPwdFormat = PASSWORD_LENGTH_OUT_OF_BOUNDS.getMessage();
            return false;
        }
        // PWD : 영문, 숫자, 특수문자 조합 (cf. 특수문자 종류 제한 없음)
        else if (!pwd.matches("^(?=.*[a-zA-Z])((?=.*\\d)|(?=.*\\W)).{8,20}+$")) {
            wrongPwdFormat = INVALID_PASSWORD_FORMAT.getMessage();
            return false;
        }
        // PWD : 4자리 이상의 연속적인 숫자 제한
        else {
            for (int i = 0; i < pwd.length() - 3; i++) {
                char a = pwd.charAt(i);
                char b = pwd.charAt(i + 1);
                char c = pwd.charAt(i + 2);
                char d = pwd.charAt(i + 3);

                if (a + 1 == b && b + 1 == c && c + 1 == d) {
                    wrongPwdFormat = SEQUENTIAL_CHARACTERS.getMessage();
                    return false;
                }
            }
        }

        return true;
    }

    // 이메일 - 유효성 검증 메서드
    public boolean validateOfEmail(String email) {
        if (email.isEmpty() || email.isBlank()) {
            wrongEmailFormat = EMAIL_MISSING.getMessage();
            return false;
        } else if (!email.matches("[a-z0-9._%+-]+@[a-z0-9.-]+\\.[a-z]{2,6}")) {
            wrongEmailFormat = INVALID_EMAIL_FORMAT.getMessage();
            return false;
        }
        return true;
    }

    public String getWrongIdFormat() {
        return wrongIdFormat;
    }

    public String getWrongPwdFormat() {
        return wrongPwdFormat;
    }

    public String getWrongEmailFormat() {
        return wrongEmailFormat;
    }

}