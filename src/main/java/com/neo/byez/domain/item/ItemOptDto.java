package com.neo.byez.domain.item;

import java.util.Objects;

public class ItemOptDto {
    private String num;
    private String code;
    private String new_code;
    private String reg_date;
    private String reg_id;
    private String up_date;
    private String up_id;

    public ItemOptDto() {
    }

    public ItemOptDto(String num, String code, String reg_date, String reg_id, String up_date,
            String up_id) {
        this.num = num;
        this.code = code;
        this.reg_date = reg_date;
        this.reg_id = reg_id;
        this.up_date = up_date;
        this.up_id = up_id;
    }

    public ItemOptDto(String num, String code) {
        this.num = num;
        this.code = code;
    }

    public String getNum() {
        return num;
    }

    public String getNew_code() {
        return new_code;
    }

    public void setNew_code(String new_code) {
        this.new_code = new_code;
    }

    public void setNum(String num) {
        this.num = num;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getReg_date() {
        return reg_date;
    }

    public void setReg_date(String reg_date) {
        this.reg_date = reg_date;
    }

    public String getReg_id() {
        return reg_id;
    }

    public void setReg_id(String reg_id) {
        this.reg_id = reg_id;
    }

    public String getUp_date() {
        return up_date;
    }

    public void setUp_date(String up_date) {
        this.up_date = up_date;
    }

    public String getUp_id() {
        return up_id;
    }

    public void setUp_id(String up_id) {
        this.up_id = up_id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        ItemOptDto that = (ItemOptDto) o;
        return num.equals(that.num) && Objects.equals(code, that.code);
    }

    @Override
    public int hashCode() {
        return Objects.hash(num, code);
    }
}
