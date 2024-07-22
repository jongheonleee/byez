<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"  pageEncoding="UTF-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>BYEZ</title>
    <link rel="stylesheet" href="/css/nav.css">
    <link rel="stylesheet" href="/css/like.css?after">
    <link rel="stylesheet" href="/css/footer.css">
    <link rel="stylesheet" href="/css/quick.css">
    <link rel="stylesheet" href="/css/aside.css">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.6.0/css/all.min.css" integrity="sha512-Kc323vGBEqzTmouAECnVceyQqyqdsSiqLQISBL29aUW4U/M7pSPA/gEUZQqv1cwx4OnYxTxve5UMg5GT6L4JJg==" crossorigin="anonymous" referrerpolicy="no-referrer" />
    <link rel="preconnect" href="https://fonts.googleapis.com">
    <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
    <link href="https://fonts.googleapis.com/css2?family=Noto+Sans+KR:wght@100..900&display=swap" rel="stylesheet">
    <link rel="icon" href="/img/favicon-32x32_2.png">
</head>
<body>
<jsp:include page="/WEB-INF/views/include/nav.jsp"/>

<section>
    <div class="wrapper">
        <div class="title">
            <p>
                <a href="/"><span>home</span></a>
                <span>></span>
                <span>위시 리스트</span>
            </p>
            <p>위시 리스트</p>
        </div>

        <jsp:include page="/WEB-INF/views/include/aside.jsp"/>

        <hr>
        <div class="content">
            <ul class="wishList">
                <c:if test="${list.size() == 0}">
                    <li></li>
                    <li id = "none">
                        <p>위시리스트에 담긴 상품이 없습니다.</p>
                    </li>
                </c:if>

                <c:if test="${list.size() > 0}">
                    <c:forEach var="likeItemDto" items="${list}">
                        <li class = "likeItemInfo">
                            <a href="/goods/${likeItemDto.num}">
                                <div style="background-image: url(/img/${likeItemDto.main_img});">
                                </div>
                            </a>
                            <ul class="itemInfo">
                                <li class="itemName">${likeItemDto.name}</li>
                                <li>
                                    <del class="sales_price"><fmt:formatNumber value="${likeItemDto.price}" pattern="#,###"/>원</del>
                                    <span class="sales_price"><fmt:formatNumber value="${likeItemDto.disc_price}" pattern="#,###"/>원</span>
                                    <span class="textStyle"><fmt:formatNumber value="${likeItemDto.disc_rate * 100}" pattern="#,###"/>%</span>
                                </li>
                                <li class="textStyle">
                                    <i class="fa-solid fa-heart"></i>
                                    <span>${likeItemDto.like_cnt}</span>
                                </li>
                                <li>리뷰수 : ${likeItemDto.review_cnt}</li>
                            </ul>
                            <input type="checkbox" class ="checkBox" data-id="${likeItemDto.id}" data-num="${likeItemDto.num}">
                        </li>
                    </c:forEach>
                </c:if>
            </ul>


            <!-- 버튼 및 페이징 -->
            <div class="btnPaging">
<%--                                <div class="editBtnBox">--%>
                                    <c:if test="${list.size() > 0}">
                                        <button class="modifyBtn">편집</button>
                                        <button class="btnStyle deleteBtn" style="display: none">삭제</button>
                                        <button class="btnStyle cancelBtn" style="display: none">취소</button>
                                    </c:if>
<%--                                </div>--%>
                <!-- 이전 페이지 버튼 -->
                <c:if test="${ph.showPrev}">
                    <a href="<c:url value='/like${ph.getQueryString(ph.beginPage-1)}' />">&lt;</a>
                </c:if>

                <!-- 네비 숫자 -->
                <c:forEach var="i" begin="${ph.beginPage}" end="${ph.endPage}">
                    <a class="page ${i==ph.sc.page? "paging-active" : ""}" href="<c:url value="/like${type}${ph.getQueryString(i)}"/>">${i}</a>
                </c:forEach>

                <!-- 이후 페이지 버튼 -->
                <c:if test="${ph.showNext}">
                    <a href="<c:url value='/like${type}${ph.getQueryString(ph.endPage+1)}' />">&gt;</a>
                </c:if>
            </div>
<%--            <div class="editBtnBox">--%>
<%--                <c:if test="${list.size() > 0}">--%>
<%--                    <button class="modifyBtn">편집</button>--%>
<%--                    <button class="btnStyle deleteBtn" style="display: none">삭제</button>--%>
<%--                    <button class="btnStyle cancelBtn" style="display: none">취소</button>--%>
<%--                </c:if>--%>
<%--            </div>--%>
        </div>
        <hr>
    </div>

    <form action="/like/add" method="post" class="addLikeForm">

    </form>

    <%--            <button class="modifyLikeBtn">변경</button>--%>
    <form action="/like/modify" method="post" class="modifyLikeForm">

    </form>

    <%--            <button class="removeLikeBtn">삭제</button>--%>
    <form action="/like/remove/several" method="get" class="removeSeveralLikeForm">
    </form>

    <form action="/like/remove" method="get" class="removeLikeForm">
    </form>
</section>
<jsp:include page="/WEB-INF/views/include/footer.jsp"/>
<jsp:include page="/WEB-INF/views/include/quick.jsp"/>
<script type="text/javascript" src="http://code.jquery.com/jquery-3.5.1.min.js"></script>
<script src="/js/nav.js"></script>
<script src="/js/like.js"></script>
<script src="/js/aside.js"></script>
</body>
</html>
