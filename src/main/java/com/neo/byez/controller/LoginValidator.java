package com.neo.byez.controller;

import com.neo.byez.domain.UserDto;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import static com.neo.byez.common.message.ValidatorMessage.*;

public class LoginValidator implements Validator {
    // 검증하려는 객체가 UserDto 타입인지 확인
    // clazz 가 UserDto 또는 그 자손인지 확인
    @Override
    public boolean supports(Class<?> clazz) {
        return UserDto.class.isAssignableFrom(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        UserDto userDto = (UserDto)target;

        // 각 필드의 유효성 검증
        if (userDto.getId() != null) {
            validateId(userDto.getId(), errors);
        }

        if (userDto.getPwd() != null) {
            validatePwd(userDto.getPwd(), errors);
        }
    }

    public void validateId(String id, Errors errors) {
        // ID : 입력하지 않았거나 공백 들어간 경우
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "id", ID_MISSING.getMessage());

        // ID : 지정된 글자수 범위를 벗어난 경우 (3자 이상, 20자 이하)
        if (id.length() < 3 || id.length() > 20) {
            errors.rejectValue("id", ID_LENGTH_OUT_OF_BOUNDS.getMessage());
        }

        // ID : 한글, 특수문자 사용 허용 안함 (알파벳, 숫자만 허용)
        if (!id.matches("^[a-zA-Z0-9]*")) {
            errors.rejectValue("id", INVALID_ID_FORMAT.getMessage());
        }
    }

    public void validatePwd(String pwd, Errors errors) {
        // PWD : 입력하지 않았거나 공백 들어간 경우
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "pwd", PASSWORD_MISSING.getMessage());

        // PWD : 지정된 글자수 범위를 벗어난 경우 (8자 이상, 20자 이하)
        if (pwd.length() < 8 || pwd.length() > 20) {
            errors.rejectValue("pwd", PASSWORD_LENGTH_OUT_OF_BOUNDS.getMessage());
        }

        // PWD : 영문, 숫자, 특수문자 조합 (cf. 특수문자 종류 제한 없음)
        if (!pwd.matches("^(?=.*[a-zA-Z])((?=.*\\d)|(?=.*\\W)).{8,20}+$")) {
            errors.rejectValue("pwd", INVALID_PASSWORD_FORMAT.getMessage());
        }

        // PWD : 4자리 이상의 연속적인 숫자 제한
        for (int i = 0; i < pwd.length()-3; i++) {
            char a = pwd.charAt(i);
            char b = pwd.charAt(i+1);
            char c = pwd.charAt(i+2);
            char d = pwd.charAt(i+3);

            if (a+1 == b && b+1 == c && c+1 == d) {
                errors.rejectValue("pwd", SEQUENTIAL_CHARACTERS.getMessage());
                break;
            }
        }
    }
}