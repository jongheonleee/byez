package com.neo.byez.domain;

import java.util.Date;
import java.util.Objects;

public class ReviewDto {
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



    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ReviewDto reviewDto = (ReviewDto) o;
        return Objects.equals(ord_num, reviewDto.ord_num) && Objects.equals(id, reviewDto.id) && Objects.equals(item_num, reviewDto.item_num) && Objects.equals(title, reviewDto.title) && Objects.equals(writer, reviewDto.writer) && Objects.equals(content, reviewDto.content) && Objects.equals(reg_id, reviewDto.reg_id) && Objects.equals(up_id, reviewDto.up_id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(ord_num, id, item_num, title, writer, content, reg_id, up_id);
    }

    public ReviewDto(String ord_num, String id, String item_num, String title, String writer, String content, Integer score, String reg_id, String up_id){
        this.ord_num=ord_num;
        this.id=id;
        this.item_num=item_num;
        this.title=title;
        this.writer=writer;
        this.content=content;
        this.score=score;
        this.reg_id=reg_id;
        this.up_id=up_id;
    };

    public ReviewDto(){}


    @Override
    public String toString() {
        return "ReviewDto{" +
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
                '}';
    }

    public Integer getReview_num() {
        return review_num;
    }

    public void setReview_num(Integer review_num) {
        this.review_num = review_num;
    }

    public String getOrd_num() {
        return ord_num;
    }

    public void setOrd_num(String ord_num) {
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
}

