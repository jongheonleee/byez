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
    <link rel="stylesheet" href="/css/category.css?after?after">
    <link rel="stylesheet" href="/css/footer.css?after?after">
    <link rel="stylesheet" href="/css/quick.css">
    <script src="https://kit.fontawesome.com/f0e73cfa04.js" crossorigin="anonymous"></script>
    <link rel="preconnect" href="https://fonts.googleapis.com">
    <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
    <link href="https://fonts.googleapis.com/css2?family=Noto+Sans+KR:wght@100..900&display=swap" rel="stylesheet">
</head>
<body>
<jsp:include page="/WEB-INF/views/include/nav.jsp"/>
<section>
    <div class="wrapper">
        <div class="filter">
            <div class="filter_wrapper">
                <p>FILTER</p>
                <!-- <button class="accordion">
                    <span>구분</span>
                    <i class="fa-solid fa-chevron-down"></i>
                </button>
                <div class="panel">
                    <div>
                        <button class="type">남성</button>
                        <button class="type">여성</button>
                        <button class="type">혼성</button>
                    </div>
                </div> -->
                <button class="accordion">
                    <span>가격</span>
                    <i class="fa-solid fa-chevron-down"></i>
                </button>
                <div class="panel">
                    <div class="price_search">
                        <input type="text">
                        <span>~</span>
                        <input type="text">
                        <button type="submit">검색</button>
                    </div>
                </div>

                <button class="accordion">
                    <span>아이템</span>
                    <i class="fa-solid fa-chevron-down"></i>
                </button>
                <div class="panel">
                    <div>
                        <button class="item">맨투맨/스웨트셔츠</button>
                        <button class="item">후드/집업</button>
                        <button class="item">니트/스웨터</button>
                        <button class="item">셔츠/블라우스</button>
                        <button class="item">긴팔 티셔츠</button>
                        <button class="item">반팔 티셔츠</button>
                        <button class="item">슬리브리스</button>
                        <button class="item">패딩/다운</button>
                        <button class="item">폴리스/덤블</button>
                        <button class="item">자켓/점퍼</button>
                        <button class="item">블레이저</button>
                        <button class="item">가디건</button>
                        <button class="item">바람막이</button>
                        <button class="item">슬랙스</button>
                        <button class="item">트레이닝/스웨트셔츠</button>
                        <button class="item">팬츠</button>
                        <button class="item">숏츠</button>
                        <button class="item">스커트</button>
                        <button class="item">운동화</button>
                        <button class="item">구두</button>
                        <button class="item">로퍼</button>
                        <button class="item">힐</button>
                        <button class="item">부츠</button>
                        <button class="item">슬리퍼</button>
                        <button class="item">샌달</button>
                    </div>
                </div>

                <button class="accordion">
                    <span>색상</span>
                    <i class="fa-solid fa-chevron-down"></i>
                </button>
                <div class="panel">
                    <div>
                        <button class="color" style="background-color: black;"></button>
                        <button class="color" style="background-color: lightgray;"></button>
                        <button class="color" style="background-color: gray;"></button>
                        <button class="color" style="background-color: darkgray;"></button>
                        <button class="color" style="background-color: navy;"></button>
                        <button class="color" style="background-color: ivory;"></button>
                        <button class="color" style="background-color: khaki;"></button>
                        <button class="color" style="background-color: beige;"></button>
                        <button class="color" style="background-color: white;"></button>
                        <button class="color" style="background-color: blue;"></button>
                        <button class="color" style="background-color: sandybrown;"></button>
                        <button class="color" style="background-color: skyblue;"></button>
                        <button class="color" style="background-color:brown;"></button>
                        <button class="color" style="background-color: green;"></button>
                        <button class="color" style="background-color: darkgreen;"></button>
                        <button class="color" style="background-color: pink;"></button>
                        <button class="color" style="background-color: aquamarine;"></button>
                        <button class="color" style="background-color: olive;"></button>
                        <button class="color" style="background-color: lightpink;"></button>
                        <button class="color" style="background-color: lavender;"></button>
                        <button class="color" style="background-color: purple;"></button>
                        <button class="color" style="background-color: red;"></button>
                        <button class="color" style="background-color: orange;"></button>
                        <button class="color" style="background-color: darkred;"></button>
                        <button class="color" style="background-color: yellow;"></button>
                        <button class="color" style="background-color: lightyellow;"></button>
                        <button class="color" style="background-color: lightgreen;"></button>
                        <button class="color" style="background-color: silver;"></button>
                        <button class="color" style="background-color: gold;"></button>

                    </div>
                </div>

                <button class="accordion">
                    <span>결과 내 검색</span>
                    <i class="fa-solid fa-chevron-down"></i>
                </button>
                <div class="panel">
                    <div class="detail_search">
                        <input type="text">
                        <button type="submit">검색</button>
                    </div>
                </div>
            </div>
        </div>

        <div class="content">
            <p>
                <a href="/"><span>home</span></a>
                <span>></span>
                <span>혼성</span>
                <!-- <span>></span>
                <a href="category.html"><span>상의</span></a>
                <span>></span>
                <a href="category.html"><span>맨투맨/스웨트셔츠</span></a> -->
            </p>
            <p>혼성</p>
            <div class="category">
                <ul>
                    <li><a href="/item/categories/0301">상의</a></li>
                    <li><a href="/item/categories/0302">아우터</a></li>
                    <li><a href="/item/categories/0303">하의</a></li>
                    <li><a href="/item/categories/0304">신발</a></li>
                    <li><a href="/item/categories/0305">액세사리</a></li>
                </ul>
                <div>
                    <div class="item_num">
                        <p>
                            <span>${searchCnt}</span> 개
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
            <ul class="filter_con">
                <!-- <li><a href="#">
                    <i class="fa-solid fa-rotate-right"></i>
                    <span>필터 초기화</span>
                </a></li>
                <li>
                    <span>구분 : <span>여성</span></span>
                    <i class="fa-solid fa-xmark"></i>
                </li>
                <li>
                    <span>가격 :
                        <span>20,000</span>
                        <span>~</span>
                        <span>30,000</span>
                    </span>
                    <i class="fa-solid fa-xmark"></i>
                </li>
                <li>
                    <span>아이템 :
                        <span>패딩</span>
                    </span>
                    <i class="fa-solid fa-xmark"></i>
                </li>
                <li>
                    <span>아이템 :
                        <span>패딩</span>
                    </span>
                    <i class="fa-solid fa-xmark"></i>
                </li>
                <li>
                    <span>아이템 :
                        <span>패딩</span>
                    </span>
                    <i class="fa-solid fa-xmark"></i>
                </li>
                <li>
                    <span>아이템 :
                        <span>패딩</span>
                    </span>
                    <i class="fa-solid fa-xmark"></i>
                </li>
                <li>
                    <span>아이템 :
                        <span>패딩</span>
                    </span>
                    <i class="fa-solid fa-xmark"></i>
                </li>
                <li>
                    <span>아이템 :
                        <span>패딩</span>
                    </span>
                    <i class="fa-solid fa-xmark"></i>
                </li>
                <li>
                    <span>
                        <div class="filter_con_col" style="background-color: red;"></div>
                        <i class="fa-solid fa-xmark"></i>
                    </span>
                </li>
                <li>
                    <span>
                        <div class="filter_con_col" style="background-color: blue;"></div>
                        <i class="fa-solid fa-xmark"></i>
                    </span>
                </li>
                <li>
                    <span>결과 내 검색 :
                        <span>옷!!</span>
                    </span>
                    <i class="fa-solid fa-xmark"></i>
                </li> -->
            </ul>
            <ul class="weekly_best">
                <c:forEach var="itemDto" items="${list}">
                    <li>
                        <a href="/goods/${itemDto.num}">
                            <img src="/img/${itemDto.main_img}" alt="">
                        </a>
                        <p class="item_name">
                            <span>${itemDto.name}</span>
                        </p>
                        <p class="sales_price"><fmt:formatNumber value="${itemDto.price}" pattern="#,###"/></p>
                        <p class="discounted_price"><fmt:formatNumber value="${itemDto.disc_price}" pattern="#,###"/></p>
                        <ul class="col">
                            <c:forEach var="color" items="${itemDto.colors}">
                                <li style="background-color: ${color}; display: inline"></li>
                            </c:forEach>
                        </ul>
                        <div class="wrap-star">
                            <div class='star-rating'>
                                <span style="width: ${20 * itemDto.review_rate}%"></span>
                            </div>
                        </div>
                        <i class="fa-solid fa-heart" style="color: red;"></i>
                        <span class="like_cnt">${itemDto.like_cnt}</span>
                        <p class="review_cnt">리뷰수 <span>${itemDto.review_cnt}</span></p>
                        <div class="sex">${itemDto.cust_type}</div>
                    </li>
                </c:forEach>
            </ul>
            <div class="paging">
                <!-- 이전 페이지 버튼 -->
                <c:if test="${ph.showPrev}">
                    <a href="<c:url value='/item/categories/${type}${ph.getQueryString(ph.beginPage-1)}' />">&lt;</a>
                </c:if>

                <!-- 네비 숫자 -->
                <c:forEach var="i" begin="${ph.beginPage}" end="${ph.endPage}">
                    <a class="page ${i==ph.sc.page? "paging-active" : ""}" href="<c:url value="/item/categories/${type}${ph.getQueryString(i)}"/>">${i}</a>
                </c:forEach>

                <!-- 이후 페이지 버튼 -->
                <c:if test="${ph.showNext}">
                    <a href="<c:url value='/item/categories/${type}${ph.getQueryString(ph.endPage+1)}' />">&gt;</a>
                </c:if>
            </div>
        </div>
    </div>
</section>
<jsp:include page="/WEB-INF/views/include/footer.jsp"/>
<jsp:include page="/WEB-INF/views/include/quick.jsp"/>
<script src="/js/jquery-3.6.4.min.js"></script>
<script src="/js/nav.js?after?after?after?after?after"></script>
<script src="/js/sort.js"></script>
<script src="/js/accordion.js"></script>
</body>
</html>