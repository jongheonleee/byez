package com.neo.byez.domain;

public class PageHandlerBin {
    private int bno;
    private int cnt;
    private int size = 10;
    private int total_cnt;

    public int getBno() {
        return bno;
    }

    public void setBno(int bno) {
        this.bno = bno;
    }

    public int getCnt() {
        return cnt;
    }

    public void setCnt(int cnt) {
        this.cnt = cnt;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public int getTotal_cnt() {
        return total_cnt;
    }

    public void setTotal_cnt(int total_cnt) {
        this.total_cnt = total_cnt;
    }

    public int getPage_size() {
        return page_size;
    }

    public void setPage_size(int page_size) {
        this.page_size = page_size;
    }

    public int getPage() {
        return page;
    }

    public void setPage(int page) {
        this.page = page;
    }

    public int getTotalPage() {
        return totalPage;
    }

    public void setTotalPage(int totalPage) {
        this.totalPage = totalPage;
    }

    public int getStartPage() {
        return startPage;
    }

    public void setStartPage(int startPage) {
        this.startPage = startPage;
    }

    public int getEndPage() {
        return endPage;
    }

    public void setEndPage(int endPage) {
        this.endPage = endPage;
    }

    private int page_size = 10;
    private int page;
    private int totalPage;
    private int startPage;
    private int endPage;

    public PageHandlerBin(Integer total_cnt) {
        this.total_cnt = total_cnt;
        this.totalPage  = (total_cnt % 10 == 0 ? total_cnt / 10 : total_cnt / 10 + 1);
    }

    public void pageHandle(Integer page) {
        if(page<=0){page=1;}
        startPage = (page%page_size==0?((page/page_size)-1) * page_size + 1:page/page_size*page_size+1);
        endPage = (startPage + page_size) > totalPage ? totalPage : startPage + (page_size-1);
    }
}