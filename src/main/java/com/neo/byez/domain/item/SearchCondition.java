package com.neo.byez.domain.item;

import org.springframework.web.util.UriComponentsBuilder;

public class SearchCondition {
    private Integer page = 1;
    private Integer pageSize = 12;
    private String option = "NT";
    private String nameKeyword = "";
    private String typeKeyword = "";
    private String custKeyword = "";

    public SearchCondition() {}

    public SearchCondition(Integer page, Integer pageSize) {
        this(page, pageSize, "NT", "", "", "");
    }

    public SearchCondition(Integer page, Integer pageSize, String option, String nameKeyword,
            String typeKeyword, String custKeyword) {
        this.page = page;
        this.pageSize = pageSize;
        this.option = option;
        this.nameKeyword = nameKeyword;
        this.typeKeyword = typeKeyword;
        this.custKeyword = custKeyword;
    }

    // ?page=1&pageSize=12&option=A&nameKeyword=주앙옴므남자아우터&typeKeyword=0101&custKeyword=M
    public String getQueryString() {
        return UriComponentsBuilder.newInstance()
                .queryParam("page", page)
                .queryParam("pageSize", pageSize)
                .queryParam("option", option)
                .queryParam("nameKeyword", nameKeyword)
                .queryParam("typeKeyword", typeKeyword)
                .queryParam("custKeyword", custKeyword)
                .build()
                .toString();
    }

    public Integer getPage() {
        return page;
    }

    public void setPage(int page) {
        this.page = page;
    }

    public Integer getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public String getOption() {
        return option;
    }

    public void setOption(String option) {
        this.option = option;
    }

    public String getNameKeyword() {
        return nameKeyword;
    }

    public void setNameKeyword(String nameKeyword) {
        this.nameKeyword = nameKeyword;
    }

    public String getTypeKeyword() {
        return typeKeyword;
    }

    public void setTypeKeyword(String typeKeyword) {
        this.typeKeyword = typeKeyword;
    }

    public String getCustKeyword() {
        return custKeyword;
    }

    public void setCustKeyword(String custKeyword) {
        this.custKeyword = custKeyword;
    }

    public Integer getOffset() {
        return (page-1)*pageSize;
    }

    public void checkOption() {
        if (nameKeyword.length() > 0 && typeKeyword.length() > 0 && custKeyword.length() > 0) {
            option = "A";
        } else if (nameKeyword.length() > 0 && custKeyword.length() > 0) {
            option = "NC";
        } else if (typeKeyword.length() > 0 && custKeyword.length() > 0) {
            option = "TC";
        } else if (nameKeyword.length() > 0 && typeKeyword.length() > 0){
            option = "NT";
        } else {
            option = "T";
        }
    }
    @Override
    public String toString() {
        return "SearchCondition{" +
                "page=" + page +
                ", pageSize=" + pageSize +
                ", option='" + option + '\'' +
                ", nameKeyword='" + nameKeyword + '\'' +
                ", typeKeyword='" + typeKeyword + '\'' +
                ", custKeyword='" + custKeyword + '\'' +
                '}';
    }
}
