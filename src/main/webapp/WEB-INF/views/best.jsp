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
    <link rel="stylesheet" href="/css/best.css">
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
        <p>
            <a href="/"><span>home</span></a>
            <span>></span>
            <span>best 50</span>
        </p>
        <p>전체보기</p>
        <div class="category">
            <ul>
                <li><a href="#">전체보기</a></li>
                <li><a href="#">여성</a></li>
                <li><a href="#">남성</a></li>
                <li><a href="#">혼성</a></li>
            </ul>
            <div>
                <div class="item_num">
                    <p>
                        <span>7</span> 개
                    </p>
                </div>
                <div class="sort">
                    <p><span>신상품</span> <i class="fa-solid fa-angle-down"></i></p>
                    <ul class="order">
                        <li><a href="#">신상품</a></li>
                        <li><a href="#">상품명</a></li>
                        <li><a href="#">낮은가격</a></li>
                        <li><a href="#">높은가격</a></li>
                        <li><a href="#">제조사</a></li>
                        <li><a href="#">인기상품</a></li>
                        <li><a href="#">사용후기</a></li>
                        <li><a href="#">조회수</a></li>
                        <li><a href="#">좋아요</a></li>
                    </ul>
                </div>
            </div>
        </div>
        <ul class="weekly_best">
            <li>
                <a href="#">
                    <img src="/img/203.jpeg" alt="">
                </a>
                <p class="item_name">
                    <span>플리스 자켓_RAE4TC3002DGR</span>
                </p>
                <p class="sales_price">90,000</p>
                <p class="discounted_price">80,000</p>
                <ul class="col">
                    <li style="background-color: black;"></li>
                    <li style="background-color: lightgray;"></li>
                    <li style="background-color: gray;"></li>
                    <li style="background-color: darkgray;"></li>
                    <li style="background-color: navy;"></li>
                </ul>
                <div class="stars">
                    <i class="fa-solid fa-star"></i>
                    <i class="fa-solid fa-star"></i>
                    <i class="fa-solid fa-star"></i>
                    <i class="fa-solid fa-star"></i>
                    <i class="fa-solid fa-star"></i>
                </div>
                <i class="fa-solid fa-heart" style="color: red;"></i>
                <span class="like_cnt">30</span>
                <p class="review_cnt">리뷰수 <span>10</span></p>
                <div class="sex">여성용</div>
            </li>
            <li>
                <a href="#">
                    <img src="/img/111.jpeg" alt="">
                </a>
                <p class="item_name">
                    <span>사이드 트랙원턱 스웨트팬츠 네이비</span>
                </p>
                <p class="sales_price">30,000</p>
                <p class="discounted_price">20,000</p>
                <ul class="col">

                    <li style="background-color: skyblue;"></li>
                    <li style="background-color: skyblue;"></li>
                    <li style="background-color: brown;"></li>
                    <li style="background-color: green;"></li>
                </ul>
                <div class="stars">
                    <i class="fa-solid fa-star"></i>
                    <i class="fa-solid fa-star"></i>
                    <i class="fa-solid fa-star"></i>
                    <i class="fa-solid fa-star"></i>
                    <i class="fa-solid fa-star"></i>
                </div>
                <i class="fa-solid fa-heart" style="color: red;"></i>
                <span class="like_cnt">310</span>
                <p class="review_cnt">리뷰수 <span>1000</span></p>
                <div class="sex">남성용</div>
            </li>
            <li>
                <a href="#">
                    <img src="/img/205.jpeg" alt="">
                </a>
                <p class="item_name">
                    <span>[COOL] 칼라 나시 카디건 세트_SPCKE37W92 [COOL] 칼라 나시 카디건 세트_SPCKE37</span>
                </p>
                <p class="sales_price">37,000</p>
                <p class="discounted_price">28,000</p>
                <ul class="col">
                    <li style="background-color: black;"></li>
                    <li style="background-color: lightgray;"></li>

                    <li style="background-color: beige;"></li>
                    <li style="background-color: white;"></li>
                    <li style="background-color: blue;"></li>

                    <li style="background-color: brown;"></li>
                    <li style="background-color: green;"></li>
                </ul>
                <div class="stars">
                    <i class="fa-solid fa-star"></i>
                    <i class="fa-solid fa-star"></i>
                    <i class="fa-solid fa-star"></i>
                    <i class="fa-solid fa-star"></i>
                    <i class="fa-solid fa-star"></i>
                </div>
                <i class="fa-solid fa-heart" style="color: red;"></i>
                <span class="like_cnt">900</span>
                <p class="review_cnt">리뷰수 <span>1014</span></p>
                <div class="sex">여성용</div>
            </li>
            <li>
                <a href="#">
                    <img src="/img/208.jpeg" alt="">
                </a>
                <p class="item_name">
                    <span>Classic Flower MTM [Black]</span>
                </p>
                <p class="sales_price">39,000</p>
                <p class="discounted_price">38,000</p>
                <ul class="col">
                    <li style="background-color: black;"></li>
                    <li style="background-color: ivory;"></li>
                    <li style="background-color: beige;"></li>
                    <li style="background-color: green;"></li>
                </ul>
                <div class="stars">
                    <i class="fa-solid fa-star"></i>
                    <i class="fa-solid fa-star"></i>
                    <i class="fa-solid fa-star"></i>
                    <i class="fa-solid fa-star"></i>
                    <i class="fa-solid fa-star"></i>
                </div>
                <i class="fa-solid fa-heart" style="color: red;"></i>
                <span class="like_cnt">200</span>
                <p class="review_cnt">리뷰수 <span>990</span></p>
                <div class="sex">남성용</div>
            </li>
            <li>
                <a href="#">
                    <img src="/img/114.jpeg" alt="">
                </a>
                <p class="item_name">
                    <span>마이너드 맨투맨 오트밀 MJMT7612</span>
                </p>
                <p class="sales_price">50,000</p>
                <p class="discounted_price">40,000</p>
                <ul class="col">
                    <li style="background-color: darkgray;"></li>
                    <li style="background-color: khaki;"></li>
                    <li style="background-color: beige;"></li>
                    <li style="background-color: white;"></li>
                </ul>
                <div class="stars">
                    <i class="fa-solid fa-star"></i>
                    <i class="fa-solid fa-star"></i>
                    <i class="fa-solid fa-star"></i>
                    <i class="fa-solid fa-star"></i>
                    <i class="fa-solid fa-star"></i>
                </div>
                <i class="fa-solid fa-heart" style="color: red;"></i>
                <span class="like_cnt">2030</span>
                <p class="review_cnt">리뷰수 <span>190</span></p>
                <div class="sex">여성용</div>
            </li>
            <li>
                <a href="#">
                    <img src="/img/113.jpeg" alt="">
                </a>
                <p class="item_name">
                    <span>웰던 맨투맨 마운틴그린 STMT3466</span>
                </p>
                <p class="sales_price">20,000</p>
                <p class="discounted_price">12,000</p>
                <ul class="col">
                    <li style="background-color: khaki;"></li>
                    <li style="background-color: beige;"></li>
                    <li style="background-color: skyblue;"></li>
                    <li style="background-color: skyblue;"></li>
                    <li style="background-color: brown;"></li>
                </ul>
                <div class="stars">
                    <i class="fa-solid fa-star"></i>
                    <i class="fa-solid fa-star"></i>
                    <i class="fa-solid fa-star"></i>
                    <i class="fa-solid fa-star"></i>
                    <i class="fa-solid fa-star"></i>
                </div>
                <i class="fa-solid fa-heart" style="color: red;"></i>
                <span class="like_cnt">30</span>
                <p class="review_cnt">리뷰수 <span>10</span></p>
                <div class="sex">여성용</div>
            </li>
            <li>
                <a href="#">
                    <img src="/img/202.jpeg" alt="">
                </a>
                <p class="item_name">
                    <span>LW 스트레이트 슬랙스</span>
                </p>
                <p class="sales_price">33,000</p>
                <p class="discounted_price">23,000</p>
                <ul class="col">

                    <li style="background-color: ivory;"></li>
                    <li style="background-color: khaki;"></li>
                    <li style="background-color: beige;"></li>
                    <li style="background-color: skyblue;"></li>
                    <li style="background-color: brown;"></li>
                    <li style="background-color: green;"></li>
                </ul>
                <div class="stars">
                    <i class="fa-solid fa-star"></i>
                    <i class="fa-solid fa-star"></i>
                    <i class="fa-solid fa-star"></i>
                    <i class="fa-solid fa-star"></i>
                    <i class="fa-solid fa-star"></i>
                </div>
                <i class="fa-solid fa-heart" style="color: red;"></i>
                <span class="like_cnt">3330</span>
                <p class="review_cnt">리뷰수 <span>100</span></p>
                <div class="sex">혼성</div>
            </li>
        </ul>
    </div>
</section>
<jsp:include page="/WEB-INF/views/include/footer.jsp"/>
<jsp:include page="/WEB-INF/views/include/quick.jsp"/>
<script src="/js/jquery-3.6.4.min.js"></script>
<script src="/js/nav.js"></script>
<script src="/js/sort.js"></script>
</body>
</html>