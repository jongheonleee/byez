package com.neo.byez.domain.order;

import java.util.Objects;

public class EtcListRequestDto {
    private String userId;
    private Integer curPage;
    private Integer pageSize;

    public EtcListRequestDto(){

    }
    public EtcListRequestDto(String userId, Integer curPage, Integer pageSize) {
        this.userId = userId;
        this.curPage = curPage;
        this.pageSize = pageSize;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public Integer getCurPage() {
        return curPage;
    }

    public void setCurPage(Integer curPage) {
        this.curPage = curPage;
    }

    public Integer getPageSize() {
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        EtcListRequestDto that = (EtcListRequestDto) o;
        return Objects.equals(userId, that.userId) && Objects.equals(curPage, that.curPage) && Objects.equals(pageSize, that.pageSize);
    }

    @Override
    public int hashCode() {
        return Objects.hash(userId, curPage, pageSize);
    }

    @Override
    public String toString() {
        return "EtcListRequestDto{" +
                "userId='" + userId + '\'' +
                ", curPage=" + curPage +
                ", pageSize=" + pageSize +
                '}';
    }
}
