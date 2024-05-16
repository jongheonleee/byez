package com.neo.byez.domain.item;

import java.util.Date;
import java.util.Objects;

public class LikeItemDto {
    private String id;
    private String num;
    private String name;
    private String type;
    private int price;
    private Integer disc_price;
    private String item_comt;
    private String main_img;
    private int review_cnt;
    private int like_cnt;
    private String state_code;
    private String comt;
    private Date reg_date;
    private String reg_id;
    private Date up_date;
    private String up_id;

    public LikeItemDto() {}

    public LikeItemDto(String id, String num, String name, String type, int price,
            Integer disc_price,
            String item_comt, String main_img, int review_cnt, int like_cnt, String state_code,
            String comt, Date reg_date, String reg_id, Date up_date, String up_id) {
        this.id = id;
        this.num = num;
        this.name = name;
        this.type = type;
        this.price = price;
        this.disc_price = disc_price;
        this.item_comt = item_comt;
        this.main_img = main_img;
        this.review_cnt = review_cnt;
        this.like_cnt = like_cnt;
        this.state_code = state_code;
        this.comt = comt;
        this.reg_date = reg_date;
        this.reg_id = reg_id;
        this.up_date = up_date;
        this.up_id = up_id;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNum() {
        return num;
    }

    public void setNum(String num) {
        this.num = num;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public Integer getDisc_price() {
        return disc_price;
    }

    public void setDisc_price(Integer disc_price) {
        this.disc_price = disc_price;
    }

    public String getItem_comt() {
        return item_comt;
    }

    public void setItem_comt(String item_comt) {
        this.item_comt = item_comt;
    }

    public String getMain_img() {
        return main_img;
    }

    public void setMain_img(String main_img) {
        this.main_img = main_img;
    }

    public int getReview_cnt() {
        return review_cnt;
    }

    public void setReview_cnt(int review_cnt) {
        this.review_cnt = review_cnt;
    }

    public int getLike_cnt() {
        return like_cnt;
    }

    public void setLike_cnt(int like_cnt) {
        this.like_cnt = like_cnt;
    }

    public String getState_code() {
        return state_code;
    }

    public void setState_code(String state_code) {
        this.state_code = state_code;
    }

    public String getComt() {
        return comt;
    }

    public void setComt(String comt) {
        this.comt = comt;
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
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        LikeItemDto that = (LikeItemDto) o;
        return id.equals(that.id)
                && num.equals(that.num)
                && name.equals(that.name)
                && type.equals(that.type);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, num, name, type);
    }

    @Override
    public String toString() {
        return "LikeItemDto{" +
                "id='" + id + '\'' +
                ", num='" + num + '\'' +
                ", name='" + name + '\'' +
                ", type='" + type + '\'' +
                ", price=" + price +
                ", disc_price=" + disc_price +
                ", item_comt='" + item_comt + '\'' +
                ", main_img='" + main_img + '\'' +
                ", review_cnt=" + review_cnt +
                ", like_cnt=" + like_cnt +
                ", state_code='" + state_code + '\'' +
                ", comt='" + comt + '\'' +
                ", reg_date=" + reg_date +
                ", reg_id='" + reg_id + '\'' +
                ", up_date=" + up_date +
                ", up_id='" + up_id + '\'' +
                '}';
    }
}
