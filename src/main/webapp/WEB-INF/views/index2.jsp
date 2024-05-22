<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"  pageEncoding="UTF-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html lang="ko">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>BYEZ</title>
    <link rel="stylesheet" href="/css/nav.css">
    <link rel="stylesheet" href="/css/index.css">
    <link rel="stylesheet" href="/css/tab.css">
    <link rel="stylesheet" href="/css/footer.css">
    <link rel="stylesheet" href="/css/quick.css">
    <script src="https://kit.fontawesome.com/f0e73cfa04.js" crossorigin="anonymous"></script>
    <link rel="preconnect" href="https://fonts.googleapis.com">
    <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
    <link href="https://fonts.googleapis.com/css2?family=Noto+Sans+KR:wght@100..900&display=swap" rel="stylesheet">
</head>
<body>
<%@include file="../views/include/nav.jsp"%>
<section>
    <div class="wrapper">
        <p>위클리 베스트</p>
        <!-- 탭 메뉴 -->
        <ul class="tab_menu">
            <li><a href="#tab1-1">여성</a></li>
            <li><a href="#tab1-2">남성</a></li>
            <li><a href="#tab1-3">혼성</a></li>
        </ul>
        <!-- 탭 콘텐츠 -->
        <div class="≈">
            <div id="tab1-1" class="tab_content">
                <div class="tab_c_arti">
                    <ul class="weekly_best">
                        <c:forEach  var="board" items="${boardList}">
                            <li><a href="/goods/${board.num}">
                                <img src="${board.main_img}" alt="">
                            </a>
                                <p class="item_name">
                                    <span>${board.name}</span>
                                </p>
                                <p class="sales_price"><fmt:formatNumber value="${board.price}" pattern="#,###"/></p>
                                <p class="discounted_price"><fmt:formatNumber value="${board.disc_price}" pattern="#,###"/></p>

                                <ul class="col">
                                    <c:forEach var="color" items="${board.colors}">
                                        <li style="background-color: ${color}; display: inline"></li>
                                    </c:forEach>
                                </ul>

                                <div class="wrap-star">
                                    <div class='star-rating'>
                                        <span style="width: ${20 * board.review_rate}%"></span>
                                    </div>
                                </div>

                                <i class="fa-solid fa-heart" style="color: red;"></i>
                                <span class="like_cnt">${board.like_cnt}</span>
                                <p class="review_cnt">리뷰수 <span>${board.review_cnt}</span></p>
                                <div class="sex">${board.cust_type}</div>
                            </li>
                        </c:forEach>
                    </ul>
                </div>
            </div>
            <div id="tab1-2" class="tab_content">
                <div class="tab_c_arti">
                    <ul class="weekly_best">
                        <c:forEach  var="board" items="${boardList2}">
                            <li><a href="/goods/${board.num}">
                                <img src="${board.main_img}" alt="">
                            </a>
                                <p class="item_name">
                                    <span>${board.name}</span>
                                </p>
                                <p class="sales_price"><fmt:formatNumber value="${board.price}" pattern="#,###"/></p>
                                <p class="discounted_price"><fmt:formatNumber value="${board.disc_price}" pattern="#,###"/></p>

                                <ul class="col">
                                    <c:forEach var="color" items="${board.colors}">
                                        <li style="background-color: ${color}; display: inline"></li>
                                    </c:forEach>
                                </ul>


                                <div class="wrap-star">
                                    <div class='star-rating'>
                                        <span style="width: ${20 * board.review_rate}%"></span>
                                    </div>
                                </div>


                                <i class="fa-solid fa-heart" style="color: red;"></i>
                                <span class="like_cnt">${board.like_cnt}</span>
                                <p class="review_cnt">리뷰수 <span>${board.review_cnt}</span></p>
                                <div class="sex">${board.cust_type}</div>
                            </li>
                        </c:forEach>
                    </ul>
                </div>
            </div>
            <div id="tab1-3" class="tab_content">
                <div class="tab_c_arti">
                    <ul class="weekly_best">
                        <c:forEach  var="board" items="${boardList3}">
                            <li><a href="/goods/${board.num}">
                                <img src="${board.main_img}" alt="">
                            </a>
                                <p class="item_name">
                                    <span>${board.name}</span>
                                </p>
                                <p class="sales_price"><fmt:formatNumber value="${board.price}" pattern="#,###"/></p>
                                <p class="discounted_price"><fmt:formatNumber value="${board.disc_price}" pattern="#,###"/></p>

                                <ul class="col">
                                    <c:forEach var="color" items="${board.colors}">
                                        <li style="background-color: ${color}; display: inline"></li>
                                    </c:forEach>
                                </ul>

                                <div class="wrap-star">
                                    <div class='star-rating'>
                                        <span style="width: ${20 * board.review_rate}%"></span>
                                    </div>
                                </div>

                                <i class="fa-solid fa-heart" style="color: red;"></i>
                                <span class="like_cnt">${board.like_cnt}</span>
                                <p class="review_cnt">리뷰수 <span>${board.review_cnt}</span></p>
                                <div class="sex">${board.cust_type}</div>
                            </li>
                        </c:forEach>
                    </ul>
                </div>
            </div>
        </div>
    </div>
</section>
<%@include file="../views/include/footer.jsp"%>
<%@include file="../views/include/quick.jsp"%>
<script src="/js/jquery-3.6.4.min.js"></script>
<script src="/js/nav.js?after"></script>
<script src="/js/tab.js"></script>
</body>
</html>