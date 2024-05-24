package com.neo.byez.domain.item;

import org.springframework.web.util.UriComponentsBuilder;

public class PageHandler {
    private SearchCondition sc;
    private int totalCnt;
    private int naviSize = 10;
    private int totalPage;
    private int beginPage;
    private int endPage;
    private boolean showPrev;
    private boolean showNext;

    public PageHandler(Integer totalCnt, Integer page) {
        this(totalCnt, new SearchCondition(page, 12));
    }

    public PageHandler(int totalCnt, int page, int pageSize) {
        this(totalCnt, new SearchCondition(page, pageSize));
    }

    public PageHandler(int totalCnt, SearchCondition sc) {
        this.totalCnt = totalCnt;
        this.sc = sc;

        calculate(totalCnt, sc);
    }

    private void calculate(Integer totalCnt, SearchCondition sc) {
        // 계산
        this.totalPage = totalCnt / sc.getPageSize() + (totalCnt % sc.getPageSize() == 0 ? 0 : 1);
        this.sc.setPage(Math.min(sc.getPage(), totalPage));
        this.beginPage = (sc.getPage()-1)/ naviSize * naviSize + 1;
        this.endPage = Math.min(beginPage+(naviSize-1), totalPage);
        this.showPrev = beginPage != 1;
        this.showNext = endPage != totalPage;
    }

    // ?page=1&pageSize=12&option=A&nameKeyword=주앙옴므남자아우터&typeKeyword=0101&custKeyword=M
    public String getQueryString() {
        return getQueryString(this.sc.getPage());
    }

    public String getQueryString(int page) {
        return UriComponentsBuilder.newInstance()
                .queryParam("page", page)
                .queryParam("pageSize", sc.getPageSize())
                .queryParam("option", sc.getOption())
                .queryParam("nameKeyword", sc.getNameKeyword())
                .queryParam("typeKeyword", sc.getTypeKeyword())
                .queryParam("custKeyword", sc.getCustKeyword())
                .build()
                .toString();
    }

    public void print() {
        // [PREV] 1 2 3 4 5 6 ... 10 [NEXT]
        // 이전 버튼
//        System.out.print(showPrev ? "[PREV] " : "");

        // navi 숫자
        for (int i=beginPage; i<=endPage; i++) {
            System.out.print(i + " ");
        }

        // 다음 버튼
        System.out.print(showNext ? "[NEXT]" : "");
    }

    public SearchCondition getSc() {
        return sc;
    }

    public void setSc(SearchCondition sc) {
        this.sc = sc;
    }

    public int getTotalCnt() {
        return totalCnt;
    }

    public void setTotalCnt(int totalCnt) {
        this.totalCnt = totalCnt;
    }

    public int getNaviSize() {
        return naviSize;
    }

    public void setNaviSize(int naviSize) {
        this.naviSize = naviSize;
    }

    public int getTotalPage() {
        return totalPage;
    }

    public void setTotalPage(int totalPage) {
        this.totalPage = totalPage;
    }

    public int getBeginPage() {
        return beginPage;
    }

    public void setBeginPage(int beginPage) {
        this.beginPage = beginPage;
    }

    public int getEndPage() {
        return endPage;
    }

    public void setEndPage(int endPage) {
        this.endPage = endPage;
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
}
