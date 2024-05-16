package com.neo.byez.common.validator;


import static com.neo.byez.common.config.BasketItemConstant.*;

import com.neo.byez.domain.item.BasketItemDto;
import com.neo.byez.domain.item.BasketItemDtos;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

public class BasketItemValidator implements Validator {

    @Override
    public boolean supports(Class<?> clazz) {
        return BasketItemDto.class.isAssignableFrom(clazz) || BasketItemDtos.class.isAssignableFrom(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        if (target instanceof BasketItemDto) {
            BasketItemDto dto = (BasketItemDto) target;

            // 일련번호 -> 널, 음수, 0 인지 확인
            // 아이디 -> 널, 특수문자, 널, 공백 포함 확인
            // 상품명 -> 널, 빈문자, 길이 1이상
            // 상품번호 -> 널, 지정한 형식이 맞는지 확인
            // 가격 -> 0이상인지 확인
            // 수량 -> 0이상인지 확인
            // 사이즈(옵션1) -> 지정한 형식이 맞는지 확인
            // 색상(옵션2) -> 지정한 형식이 맞는지 확인
            valid(dto, errors);
        } else if (target instanceof BasketItemDtos) {
            BasketItemDtos dtos = (BasketItemDtos) target;

            for (BasketItemDto dto : dtos.getOrders()) {
                valid(dto, errors);
            }
        }

    }

    private void valid(BasketItemDto dto, Errors errors) {
        if (isInvalidSeq(dto.getSeq())) {
            errors.rejectValue("seq", "invalidSeq", "잘못된 시퀀스 번호입니다.");
        }

        if (isInvalidId(dto.getId())) {
            errors.rejectValue("id", "invalidId", "잘못된 아이디입니다.");
        }

        if (isInvalidName(dto.getName())) {
            errors.rejectValue("name", "invalidName", "잘못된 상품명입니다.");
        }

        if (isInvalidNum(dto.getNum())) {
            errors.rejectValue("num", "invalidNum", "잘못된 상품번호입니다.");
        }

        if (isInvalidPrice(dto.getPrice())) {
            errors.rejectValue("price", "invalidPrice", "잘못된 상품 가격입니다.");
        }

        if (isInvalidQty(dto.getQty())) {
            errors.rejectValue("qty", "invalidQty", "잘못된 상품 수량입니다.");
        }

        if (isInvalidSizeCode(dto.getOpt1())) {
            errors.rejectValue("size", "invalidSize", "잘못된 상품 사이즈입니다.");
        }

        if (isInvalidColorCode(dto.getOpt2())) {
            errors.rejectValue("color", "invalidColor", "잘못된 상품 색상입니다.");
        }

    }

    private boolean isInvalidSeq(int seq) {
        return seq <= MIN_SEQ.getSetting();
    }

    // 글자 숫자 이외의 문자 허용 안함
    private boolean isInvalidId(String id) {
        for (char ch : id.toCharArray()) {
            if (!(Character.isLetter(ch) || Character.isDigit(ch))) {
                return true;
            }
        }
        return false;
    }

    // 글자 숫자 이외의 문자 허용 안함
    private boolean isInvalidNum(String num) {
        for (char ch : num.toCharArray()) {
            if (!(Character.isLetter(ch) || Character.isDigit(ch))) {
                return true;
            }
        }
        return false;
    }

    private boolean isInvalidName(String name) {
        return false;
    }

    // 0부터 10억 범위를 벗어남
    private boolean isInvalidPrice(int price) {
        return !(MIN_PRICE.getSetting() <= price && price <= MAX_PRICE.getSetting());
    }

    // 0부터 1만개 범위를 벗어남
    private boolean isInvalidQty(int qty) {
        return !(MIN_QTY.getSetting() <= qty && qty <= MAX_QTY.getSetting());
    }

    // 사이즈 코드는 COL01, 250, 31 등으로 나뉨
    private boolean isInvalidSizeCode(String code) {
        return false;
//        return !store.isSizeCode(code);
    }

    private boolean isInvalidColorCode(String code) {
        return false;
//        return !store.isColorCode(code);
    }
}
