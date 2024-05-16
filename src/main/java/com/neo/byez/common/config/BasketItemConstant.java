package com.neo.byez.common.config;

public enum BasketItemConstant {

    MIN_SEQ(0),

    MIN_PRICE(0),
    MAX_PRICE(1_000_000_000),
    MIN_QTY(1),
    MAX_QTY(50_000);


    private final Integer setting;

    BasketItemConstant(Integer setting) {
        this.setting = setting;
    }

    public Integer getSetting() {
        return setting;
    }
}
