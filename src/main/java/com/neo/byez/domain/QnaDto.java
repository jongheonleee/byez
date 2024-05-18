package com.neo.byez.domain;

import java.util.Date;
import java.util.Objects;
import java.util.SimpleTimeZone;

public class QnaDto {
    private int seq_num;
    private int cate_num;
    private String cust_id;
    private String staff_id;
    private String qna_title;
    private String qna_writer;
    private String qna_content;
    private String res_title;
    private String res_writer;
    private String res_content;
    private String res_state;
    private Date reg_date;
    private String reg_id;
    private Date up_date;
    private String up_id;

    public QnaDto(String cust_id, String qna_writer, Integer cate_num, String qna_title, String qna_content) {
        this.cust_id = cust_id;
        this.qna_writer = qna_writer;
        this.cate_num = cate_num;
        this.qna_title = qna_title;
        this.qna_content = qna_content;
    }

    public QnaDto() {
    }

    @Override
    public boolean equals(Object obj) {
        QnaDto real = (QnaDto) obj;
        return this.cate_num == real.cate_num &&
                Objects.equals(this.qna_writer, real.qna_writer) &&
                Objects.equals(this.qna_title, real.qna_title) &&
                Objects.equals(this.qna_content, real.qna_content) &&
                Objects.equals(this.res_writer, real.res_writer) &&
                Objects.equals(this.res_title, real.res_title) &&
                Objects.equals(this.res_content, real.res_content) &&
                Objects.equals(this.res_state, real.res_state);
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }

    public int getSeq_num() {
        return seq_num;
    }

    public void setSeq_num(int seq_num) {
        this.seq_num = seq_num;
    }

    public int getCate_num() {
        return cate_num;
    }

    public void setCate_num(int cate_num) {
        this.cate_num = cate_num;
    }

    public String getCust_id() {
        return cust_id;
    }

    public void setCust_id(String cust_id) {
        this.cust_id = cust_id;
    }

    public String getStaff_id() {
        return staff_id;
    }

    public void setStaff_id(String staff_id) {
        this.staff_id = staff_id;
    }

    public String getQna_title() {
        return qna_title;
    }

    public void setQna_title(String qna_title) {
        this.qna_title = qna_title;
    }

    public String getQna_writer() {
        return qna_writer;
    }

    public void setQna_writer(String qna_writer) {
        this.qna_writer = qna_writer;
    }

    public String getQna_content() {
        return qna_content;
    }

    public void setQna_content(String qna_content) {
        this.qna_content = qna_content;
    }

    public String getRes_title() {
        return res_title;
    }

    public void setRes_title(String res_title) {
        this.res_title = res_title;
    }

    public String getRes_writer() {
        return res_writer;
    }

    public void setRes_writer(String res_writer) {
        this.res_writer = res_writer;
    }

    public String getRes_content() {
        return res_content;
    }

    public void setRes_content(String res_content) {
        this.res_content = res_content;
    }

    public String getRes_state() {
        return res_state;
    }

    public void setRes_state(String res_state) {
        this.res_state = res_state;
    }

    public Date getReg_date() {
        return reg_date;
    }

    public void setReg_date(Date reg_date) {
        this.reg_date = reg_date;
    }

    public String getReg_id() {
        return reg_id;
    }

    public void setReg_id(String reg_id) {
        this.reg_id = reg_id;
    }

    public Date getUp_date() {
        return up_date;
    }

    public void setUp_date(Date up_date) {
        this.up_date = up_date;
    }

    public String getUp_id() {
        return up_id;
    }

    public void setUp_id(String up_id) {
        this.up_id = up_id;
    }

    @Override
    public String toString() {
        return "QnaDto{" +
                "seq_num=" + seq_num +
                ", cate_num=" + cate_num +
                ", cust_id='" + cust_id + '\'' +
                ", staff_id='" + staff_id + '\'' +
                ", qna_title='" + qna_title + '\'' +
                ", qna_writer='" + qna_writer + '\'' +
                ", qna_content='" + qna_content + '\'' +
                ", res_title='" + res_title + '\'' +
                ", res_writer='" + res_writer + '\'' +
                ", res_content='" + res_content + '\'' +
                ", res_state='" + res_state + '\'' +
                ", reg_date=" + reg_date +
                ", reg_id='" + reg_id + '\'' +
                ", up_date=" + up_date +
                ", up_id='" + up_id + '\'' +
                '}';
    }
}

