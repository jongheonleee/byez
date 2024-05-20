package com.neo.byez.domain.user;

import java.sql.Timestamp;

public class UserInfoHistDto {

    private String chg_code;
    private String id;
    private String bef_info;
    private String af_info;
    private Timestamp chg_date;
    private Timestamp reg_date;
    private String reg_id;
    private Timestamp up_date;
    private String up_id;

    public UserInfoHistDto() {}

    // 변경한 고객정보 DB에 저장(INSERT) 시 사용할 DTO 객체 생성자
    public UserInfoHistDto(String id, String chg_code, String bef_info, String af_info, String reg_id, String up_id) {
        this.id = id;
        this.chg_code = chg_code;
        this.bef_info = bef_info;
        this.af_info = af_info;
        this.reg_id = reg_id;
        this.up_id = up_id;
    }

    // 고객정보 변경이력 조회(SELECT) 시 사용할 DTO 객체 생성자
    public UserInfoHistDto(String id, String chg_code, String bef_info, String af_info, Timestamp chg_date) {
        this.chg_code = chg_code;
        this.id = id;
        this.bef_info = bef_info;
        this.af_info = af_info;
        this.chg_date = chg_date;
    }

    public String getChg_code() {
        return chg_code;
    }

    public void setChg_code(String chg_code) {
        this.chg_code = chg_code;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getBef_info() {
        return bef_info;
    }

    public void setBef_info(String bef_info) {
        this.bef_info = bef_info;
    }

    public String getAf_info() {
        return af_info;
    }

    public void setAf_info(String af_info) {
        this.af_info = af_info;
    }

    public Timestamp getChg_date() {
        return chg_date;
    }

    public void setChg_date(Timestamp chg_date) {
        this.chg_date = chg_date;
    }

    public Timestamp getReg_date() {
        return reg_date;
    }

    public void setReg_date(Timestamp reg_date) {
        this.reg_date = reg_date;
    }

    public String getReg_id() {
        return reg_id;
    }

    public void setReg_id(String reg_id) {
        this.reg_id = reg_id;
    }

    public Timestamp getUp_date() {
        return up_date;
    }

    public void setUp_date(Timestamp up_date) {
        this.up_date = up_date;
    }

    public String getUp_id() {
        return up_id;
    }

    public void setUp_id(String up_id) {
        this.up_id = up_id;
    }

}
