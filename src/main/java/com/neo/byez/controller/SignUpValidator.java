package com.neo.byez.controller;

import com.neo.byez.domain.UserDto;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import static com.neo.byez.constant.ValidatorMessage.*;

public class SignUpValidator implements Validator {

    // 검증하려는 객체가 UserDto 타입인지 확인
    // clazz 가 UserDto 또는 그 자손인지 확인
    @Override
    public boolean supports(Class<?> clazz) {
        return UserDto.class.isAssignableFrom(clazz);
    }

    // target: 검사 대상 객체, errors: 에러코드 설정 위한 객체
    // 사용자가 입력한 데이터가 UserDto 객체로 바인딩 되기 전
    // UserValidator 를 사용하여 유효성 검사 시행
    // if the value is empty or just contains whitespace.
    // => given field / given error code / message
    @Override
    public void validate(Object target, Errors errors) {
        UserDto userDto = (UserDto) target;

        validateName(userDto.getName(), errors);
        validateId(userDto.getId(), errors);
        validatePwd(userDto.getPwd(), errors);
        validateEmail(userDto.getEmail(), errors);

        // 추가
        if (userDto.getEmail() != null) {
            validateEmail(userDto.getEmail(), errors);
        }

        if (userDto.getBef_birth() != null) {
            validateBefBirth(userDto.getBef_birth(), errors);
        }

        if (userDto.getAf_birth() != null) {
            validateAfBirth(userDto.getAf_birth(), errors);
        }

        if (userDto.getTel_num() != null) {
            validateTelNum(userDto.getTel_num(), errors);
        }

        if (userDto.getMobile_num() != null) {
            validateMobileNum(userDto.getMobile_num(), errors);
        }
    }

    // 이름 유효성 검증
    // 2.1.1. 이름
    // 2.1.1.1. 2자 이상의 한글만 허용 (한글 이외 입력 불가)
    public void validateName(String name, Errors errors) {
        // Name : 입력하지 않았거나 공백 들어간 경우
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "name", NAME_MISSING.getMessage());

        // Name : 2자 이상 입력하지 않은 경우
        if (name.length() < 2) {
            errors.rejectValue("name", NAME_LENGTH_OUT_OF_BOUNDS.getMessage());
        }

        // Name : 한글만 입력 가능
        if (!name.matches(".*[ㄱ-ㅎㅏ-ㅣ가-힣]+.*")) {
            errors.rejectValue("name", INVALID_NAME_FORMAT.getMessage());
        }
    }

    // 아이디 유효성 검증
    // 2.1.2. 아이디
    // 2.1.2.1. 중복확인 -> Controller 에서 확인
    // 2.1.2.2. 3자 이상, 20자 이하의 영문, 숫자 조합만 허용 (한글, 특수문자 입력 불가)
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

    // 비밀번호 유효성 검증
    // 2.1.3. 비밀번호
    // 2.1.3.1. 8자 ~ 20자 이내로 입력
    // 2.1.3.2. 영문, 숫자, 특수문자 3종 조합 (cf. 특수문자 종류 제한 없음)
    // 2.1.3.3. 4자리 이상의 연속적인 숫자 불가
    // 2.1.3.4. 아이디 값 포함 불가 -> controller 단에서 체크
    // 2.1.3.5. 생년월일, 전화번호 포함 불가 -> controller 단에서 체크
    // 2.1.3.6. 비밀번호 추가 입력란을 통해 비밀번호 재확인 -> controller 단에서 체크
    public void validatePwd(String pwd, Errors errors) {
        String pwd1 = pwd.split(",")[0];
        String pwd2 = pwd.split(",")[1];

        // 비밀번호(pwd1) 및 비밀번호 확인(pwd2) 값 동일하게 입력했는지 확인
        if (!pwd1.equals(pwd2)) {
            errors.rejectValue("pwd", MISMATCHED_PASSWORD.getMessage());
        }

        // PWD : 입력하지 않았거나 공백 들어간 경우
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "pwd", PASSWORD_MISSING.getMessage());

        // PWD : 지정된 글자수 범위를 벗어난 경우 (8자 이상, 20자 이하)
        if (pwd1.length() < 8 || pwd1.length() > 20) {
            errors.rejectValue("pwd", PASSWORD_LENGTH_OUT_OF_BOUNDS.getMessage());
        }

        // PWD : 4자리 이상의 연속적인 숫자 제한
        for (int i = 0; i < pwd1.length() - 3; i++) {
            char a = pwd1.charAt(i);
            char b = pwd1.charAt(i + 1);
            char c = pwd1.charAt(i + 2);
            char d = pwd1.charAt(i + 3);

            if (a + 1 == b && b + 1 == c && c + 1 == d) {
                errors.rejectValue("pwd", SEQUENTIAL_CHARACTERS.getMessage());
                break;
            }
        }

        // PWD : 영문, 숫자, 특수문자 조합 (cf. 특수문자 종류 제한 없음)
        if (!pwd1.matches("^(?=.*?[A-Za-z])(?=.*?[0-9])(?=.*?[~!@#$%^ &*()_+.,?]).{8,20}$")) {
            errors.rejectValue("pwd", INVALID_PASSWORD_FORMAT.getMessage());
        }
    }

    // 이메일 유효성 검증
    // 2.1.6. 이메일 (필수 입력 - NOT NULL 으로 수정 완료)
    // 2.1.6.1. front 단에서 input type = email 설정
    // 2.1.6.2. @, . 포함한 올바른 형식의 이메일인지 확인
    public void validateEmail(String email, Errors errors) {

        // Email : 입력하지 않았거나 공백 들어간 경우
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "email", EMAIL_MISSING.getMessage());

        // Email: 한글 작성 제한
        if(email.matches(".*[ㄱ-ㅎㅏ-ㅣ가-힣]+.*")) {
            errors.rejectValue("email", INVALID_EMAIL_FORMAT.getMessage());
        }

        // Email: format 제한
        if(!(email.contains("@") && email.contains("."))) {
            errors.rejectValue("email", WRONG_EMAIL_FORMAT.getMessage());
        }
    }

    // 생년월일 - 유효성 검증 메서드
    // 앞자리(bef_birth): 8자리 제한
    // 앞자리(bef_birth): 년,월,일 확인
    public void validateBefBirth(Integer bef_birth, Errors errors) {
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "bef_birth", BEFORE_BIRTH_INCLUDE_WHITESPACE.getMessage());

        // 입력받은 값의 길이와 잘라낸 부분 값을 비교하기 위해 String 타입으로 변환
        String befBirthStr = bef_birth.toString();

        if (befBirthStr.length() != 8) {
            errors.rejectValue("bef_birth", BIRTH_LENGTH_OUT_OF_BOUNDS.getMessage());
        }

        if (befBirthStr.length() == 8) {
            String year = befBirthStr.substring(0,4);
            String month = befBirthStr.substring(4, 6);
            String day = befBirthStr.substring(6);

            int intYear = Integer.parseInt(year);
            int intMonth = Integer.parseInt(month);
            int intDay = Integer.parseInt(day);

            if (!(intYear >= 1900 && intYear <= 9999 && intMonth >= 1 && intMonth <= 12 && intDay >= 1 && intDay <= 31)) {
                errors.rejectValue("bef_birth", INVALID_BEFORE_BIRTH_FORMAT.getMessage());
            }
        }
    }

    // 생년월일 - 유효성 검증 메서드
    // 뒷자리(af_birth): 1, 2, 3, 4 만 입력 가능
    public void validateAfBirth(Integer af_birth, Errors errors) {
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "af_birth", AFTER_BIRTH_INCLUDE_WHITESPACE.getMessage());

        if (af_birth < 1 || af_birth > 4) {
            errors.rejectValue("af_birth", INVALID_AFTER_BIRTH_FORMAT.getMessage());
        }
    }

    // 전화번호 - 유효성 검증 메서드
    // 숫자만 허용
    public void validateTelNum(Integer tel_num, Errors errors) {

        String telNumStr = tel_num.toString();
        if (!telNumStr.matches("^[0-9]*$")) {
            errors.rejectValue("tel_num", INVALID_TEL_NUMBER_FORMAT.getMessage());
        }
    }

    // 핸드폰번호 - 유효성 검증 메서드
    // 숫자만 허용
    public void validateMobileNum(Integer mobile_num, Errors errors) {
        String telNumStr = mobile_num.toString();
        if (!telNumStr.matches("^[0-9]*$")) {
            errors.rejectValue("tel_num", INVALID_MOBILE_NUMBER_FORMAT.getMessage());
        }
    }
}


