package com.neo.byez.domain.item;

import java.util.Date;
import java.util.Objects;

public class ItemPriceDto {

    private String num;
    private double disc_rate;
    private int period;
    private Date start_date;
    private Date end_date;
    private String remark;
    private Date reg_date;
    private String reg_id;
    private Date up_date;
    private String up_id;

    public ItemPriceDto() {}

    public ItemPriceDto(String num, int period, double disc_rate, Date start_date, Date end_date, String remark,
            Date reg_date, String reg_id, Date up_date, String up_id) {
        this.num = num;
        this.period = period;
        this.disc_rate = disc_rate;
        this.start_date = start_date;
        this.end_date = end_date;
        this.remark = remark;
        this.reg_date = reg_date;
        this.reg_id = reg_id;
        this.up_date = up_date;
        this.up_id = up_id;
    }

    public ItemPriceDto(String num, double disc_rate, int period, Date start_date, Date end_date,
            String remark) {
        this.num = num;
        this.disc_rate = disc_rate;
        this.period = period;
        this.start_date = start_date;
        this.end_date = end_date;
        this.remark = remark;
    }

    public ItemPriceDto(String num, double disc_rate, int period, String remark) {
        this.num = num;
        this.disc_rate = disc_rate;
        this.period = period;
        this.remark = remark;
    }

    public String getNum() {
        return num;
    }

    public void setNum(String num) {
        this.num = num;
    }

    public double getDisc_rate() {
        return disc_rate;
    }

    public void setDisc_rate(double disc_rate) {
        this.disc_rate = disc_rate;
    }

    public Date getStart_date() {
        return start_date;
    }

    public void setStart_date(Date start_date) {
        this.start_date = start_date;
    }

    public Date getEnd_date() {
        return end_date;
    }

    public void setEnd_date(Date end_date) {
        this.end_date = end_date;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
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

    public int getPeriod() {
        return period;
    }

    public void setPeriod(int period) {
        this.period = period;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        ItemPriceDto that = (ItemPriceDto) o;
        return Double.compare(that.disc_rate, disc_rate) == 0 && num.equals(that.num);
    }

    @Override
    public int hashCode() {
        return Objects.hash(num, disc_rate);
    }

    @Override
    public String toString() {
        return "ItemPriceDto{" +
                "num='" + num + '\'' +
                ", disc_rate=" + disc_rate +
                ", period=" + period +
                ", start_date=" + start_date +
                ", end_date=" + end_date +
                ", remark='" + remark + '\'' +
                ", reg_date=" + reg_date +
                ", reg_id='" + reg_id + '\'' +
                ", up_date=" + up_date +
                ", up_id='" + up_id + '\'' +
                '}';
    }
}
