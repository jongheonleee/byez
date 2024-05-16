package com.neo.byez.common.message;

public enum ErrorMessage {

    NOT_LOGIN("로그인이 되어있지 않습니다. 로그인해주세요!"),
    ITEM_SELECT_FAIL("징바구니 상품 목록 조회를 실패했습니다."),
    ITEM_REGISTER_FAIL("상품 등록에 실패했습니다."),
    ITEM_UPDATE_FAIL("상품 옵션 변경에 실패했습니다."),
    ITEM_REMOVE_FAIL("상품 삭제에 실패했습니다."),
    ITEM_ALREADY_EXIST("해당 상품은 장바구니에 이미 담겨있습니다.");

    private final String message;

    ErrorMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
