package com.neo.byez.domain;

import java.util.Date;

public class ReviewItemJoinDto {
    private Integer review_num;
    private String ord_num;
    private String id;
    private String item_num;
    private String title;
    private String writer;
    private String content;
    private Integer score;
    private Integer like_cnt;
    private Date reg_date;
    private String reg_id;
    private Date up_date;
    private String up_id;
    private String item_name;
    private String opt1;
    private String opt2;
    private String opt3;
    private String opt4;
    private String opt5;
    private String main_img;
    public ReviewItemJoinDto(){}

    public Integer getReview_num() {
        return review_num;
    }

    public void setReview_num(Integer review_num) {
        this.review_num = review_num;
    }

    public String getOrder_num() {
        return ord_num;
    }

    public void setOrder_num(String ord_num) {
        this.ord_num = ord_num;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getItem_num() {
        return item_num;
    }

    public void setItem_num(String item_num) {
        this.item_num = item_num;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getWriter() {
        return writer;
    }

    public void setWriter(String writer) {
        this.writer = writer;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Integer getScore() {
        return score;
    }

    public void setScore(Integer score) {
        this.score = score;
    }

    public Integer getLike_cnt() {
        return like_cnt;
    }

    public void setLike_cnt(Integer like_cnt) {
        this.like_cnt = like_cnt;
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

    public String getItem_name() {
        return item_name;
    }

    public void setItem_name(String item_name) {
        this.item_name = item_name;
    }

    public String getOpt1() {
        return opt1;
    }

    public void setOpt1(String opt1) {
        this.opt1 = opt1;
    }

    public String getOpt2() {
        return opt2;
    }

    public void setOpt2(String opt2) {
        this.opt2 = opt2;
    }

    public String getOpt3() {
        return opt3;
    }

    public void setOpt3(String opt3) {
        this.opt3 = opt3;
    }

    public String getOpt4() {
        return opt4;
    }

    public void setOpt4(String opt4) {
        this.opt4 = opt4;
    }

    public String getOpt5() {
        return opt5;
    }

    public void setOpt5(String opt5) {
        this.opt5 = opt5;
    }

    public String getOrd_num() {
        return ord_num;
    }

    public void setOrd_num(String ord_num) {
        this.ord_num = ord_num;
    }

    public String getMain_img() {
        return main_img;
    }

    public void setMain_img(String main_img) {
        this.main_img = main_img;
    }

    @Override
    public String toString() {
        return "ReviewItemJoinDto{" +
                "review_num=" + review_num +
                ", ord_num='" + ord_num + '\'' +
                ", id='" + id + '\'' +
                ", item_num='" + item_num + '\'' +
                ", title='" + title + '\'' +
                ", writer='" + writer + '\'' +
                ", content='" + content + '\'' +
                ", score=" + score +
                ", like_cnt=" + like_cnt +
                ", reg_date=" + reg_date +
                ", reg_id='" + reg_id + '\'' +
                ", up_date=" + up_date +
                ", up_id='" + up_id + '\'' +
                ", item_name='" + item_name + '\'' +
                ", opt1='" + opt1 + '\'' +
                ", opt2='" + opt2 + '\'' +
                ", opt3='" + opt3 + '\'' +
                ", opt4='" + opt4 + '\'' +
                ", opt5='" + opt5 + '\'' +
                ", main_img='" + main_img + '\'' +
                '}';
    }
}

