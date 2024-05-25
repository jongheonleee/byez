package com.neo.byez.domain.item;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

// 메인 페이지, 베스트 페이지, 위시 리스트에서 활용
public class ItemDto {
    private String num;
    private String name;
    private String item_type;
    private String cust_type;
    private int price;
    private int disc_price;
    private String main_img;
    private int review_cnt;
    private double review_rate;
    private int like_cnt;
    private String col; // red,blue,black ,,, 
    private Date reg_date;
    private String reg_id;
    private Date up_date;
    private String up_id;

    public ItemDto() {

    }

    public ItemDto(String num, String name, String item_type, String cust_type, int price,
            int disc_price, String main_img, int review_cnt, double review_rate, int like_cnt,
            String col, Date reg_date, String reg_id, Date up_date, String up_id) {
        this.num = num;
        this.name = name;
        this.item_type = item_type;
        this.cust_type = cust_type;
        this.price = price;
        this.disc_price = disc_price;
        this.main_img = main_img;
        this.review_cnt = review_cnt;
        this.review_rate = review_rate;
        this.like_cnt = like_cnt;
        this.col = col;
        this.reg_date = reg_date;
        this.reg_id = reg_id;
        this.up_date = up_date;
        this.up_id = up_id;
    }

    public ItemDto(String num, String name, String item_type, String cust_type, int price,
            int disc_price, String main_img, int review_cnt, double review_rate, int like_cnt,
            String col) {
        this.num = num;
        this.name = name;
        this.item_type = item_type;
        this.cust_type = cust_type;
        this.price = price;
        this.disc_price = disc_price;
        this.main_img = main_img;
        this.review_cnt = review_cnt;
        this.review_rate = review_rate;
        this.like_cnt = like_cnt;
        this.col = col;
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

    public String getItem_type() {
        return item_type;
    }

    public void setItem_type(String item_type) {
        this.item_type = item_type;
    }

    public String getCust_type() {
        return cust_type;
    }

    public void setCust_type(String cust_type) {
        this.cust_type = cust_type;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getDisc_price() {
        return disc_price;
    }

    public void setDisc_price(int disc_price) {
        this.disc_price = disc_price;
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

    public double getReview_rate() {
        return review_rate;
    }

    public void setReview_rate(double review_rate) {
        this.review_rate = review_rate;
    }

    public int getLike_cnt() {
        return like_cnt;
    }

    public void setLike_cnt(int like_cnt) {
        this.like_cnt = like_cnt;
    }

    public String getCol() {
        return col;
    }

    public void setCol(String col) {
        this.col = col;
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

    public List<String> getColors() {
        // 파싱 
        String[] cols = col.split("/");
        // 반환
        return Arrays.asList(cols);
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        ItemDto itemDto = (ItemDto) o;
        return price == itemDto.price && disc_price == itemDto.disc_price
                && review_cnt == itemDto.review_cnt
                && Double.compare(itemDto.review_rate, review_rate) == 0
                && like_cnt == itemDto.like_cnt && num.equals(itemDto.num) && name.equals(
                itemDto.name)
                && item_type.equals(itemDto.item_type) && cust_type.equals(itemDto.cust_type)
                && main_img.equals(itemDto.main_img) && col.equals(itemDto.col);
    }

    @Override
    public int hashCode() {
        return Objects.hash(num, name, item_type, cust_type, price, disc_price, main_img,
                review_cnt,
                review_rate, like_cnt, col);
    }

    @Override
    public String toString() {
        return "ItemDto{" +
                "num='" + num + '\'' +
                ", name='" + name + '\'' +
                ", item_type='" + item_type + '\'' +
                ", cust_type='" + cust_type + '\'' +
                ", price=" + price +
                ", disc_price=" + disc_price +
                ", main_img='" + main_img + '\'' +
                ", review_cnt=" + review_cnt +
                ", review_rate=" + review_rate +
                ", like_cnt=" + like_cnt +
                ", col='" + col + '\'' +
                '}';
    }
}
