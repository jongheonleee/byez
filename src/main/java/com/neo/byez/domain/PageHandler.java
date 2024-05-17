package com.neo.byez.domain;

import org.springframework.stereotype.Component;

@Component
public class PageHandler {

    Integer totalCnt; //총 게시물수
    Integer pageSize = 10; //한 페이지의 크기
    Integer totalPage; // 전체 페이지 갯수
    Integer naviSize = 10; // 페이지 네비게이션의 크기
    Integer naviStart = 1; // 페이지 네비게이션의 첫번째 페이지
    Integer naviEnd;        //네비게이션 마지막 페이지
    Integer curPage; // 현재 페이지
    boolean showPrev; //이전페이지로 이동하는 링크를 보여줄 것인지
    boolean showNext; //다음페이지로 이동하는 링크를 보여줄 것인지

    public PageHandler(){
    }

    public PageHandler(Integer totalCnt, Integer curPage){
        this(totalCnt,curPage,10);
    }

    //페이징 계산하는데 필요한 3가지
    public PageHandler(Integer totalCnt, Integer curPage, Integer pageSize){
        this.totalCnt = totalCnt;
        this.curPage = curPage;
        this.pageSize = pageSize;


        totalPage = totalCnt/ pageSize + (totalCnt%pageSize == 0 ? 0:1);
        //153개의 게시물이 있다면 153/10 15에 153%10했을때 나머지가 0이 아니니 1을 더해서 총 16페이지가 된다.

        naviStart = ((curPage -1) / naviSize) * naviSize + 1;

        naviEnd = (naviStart + naviSize -1);
        naviEnd = naviEnd > totalPage ? totalPage : naviEnd;
        showPrev = naviStart != 1;
        showNext = naviEnd != totalPage;

    }

    @Override
    public String toString() {
        return "PageHandler [totalCnt=" + totalCnt + ", pageSize=" + pageSize + ", totalPage=" + totalPage + ", naviSize="
                + naviSize + ", naviStart=" + naviStart + ", naviEnd=" + naviEnd + ", curPage=" + curPage + "]";
    }

    public Integer getTotalCnt() {
        return totalCnt;
    }

    public void setTotalCnt(Integer totalCnt) {
        this.totalCnt = totalCnt;
    }

    public Integer getPageSize() {
        return pageSize;
    }

    public boolean isShowPrev() {
        return showPrev;
    }

    public void setShowPrev(boolean showPrev) {
        this.showPrev = showPrev;
    }

    public boolean isShowNext() {
        return showNext;
    }

    public void setShowNext(boolean showNext) {
        this.showNext = showNext;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }

    public Integer getTotalPage() {
        return totalPage;
    }

    public void setTotalPage(Integer totalPage) {
        this.totalPage = totalPage;
    }

    public Integer getNaviSize() {
        return naviSize;
    }

    public void setNaviSize(Integer naviSize) {
        this.naviSize = naviSize;
    }

    public Integer getNaviStart() {
        return naviStart;
    }

    public void setNaviStart(Integer naviStart) {
        this.naviStart = naviStart;
    }

    public Integer getNaviEnd() {
        return naviEnd;
    }

    public void setNaviEnd(Integer naviEnd) {
        this.naviEnd = naviEnd;
    }

    public Integer getPage() {
        return curPage;
    }

    public Integer getCurPage() {
        return curPage;
    }

    public void setCurPage(Integer curPage) {
        this.curPage = curPage;
    }

    public void setPage(Integer curPage) {
        this.curPage = curPage;
    }


}