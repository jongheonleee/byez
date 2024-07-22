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
    <link rel="stylesheet" href="/css/discount.css?after?after?after">
    <link rel="stylesheet" href="/css/footer.css">
    <link rel="stylesheet" href="/css/quick.css">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.6.0/css/all.min.css" integrity="sha512-Kc323vGBEqzTmouAECnVceyQqyqdsSiqLQISBL29aUW4U/M7pSPA/gEUZQqv1cwx4OnYxTxve5UMg5GT6L4JJg==" crossorigin="anonymous" referrerpolicy="no-referrer" />
    <link rel="preconnect" href="https://fonts.googleapis.com">
    <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
    <link href="https://fonts.googleapis.com/css2?family=Noto+Sans+KR:wght@100..900&display=swap" rel="stylesheet">
    <link rel="icon" href="/img/favicon-32x32_2.png">
</head>
<body>
<jsp:include page="/WEB-INF/views/include/nav.jsp"/>
<section>
    <%--    <div class="wrapper">--%>
    <%--    </div>--%>
</section>
<section>
    <p>SALE</p>
    <p>BYEZ 제품을 착한 가격으로 만나보세요</p>
</section>
<section>
    <div class="wrapper">
        <p>
            <a href="/"><span>home</span></a>
            <span>></span>
            <span>할인 상품</span>
        </p>
        <ul class="remoteBtn">
            <li><a href="#sweatshirt">
                <span>맨투맨/스웨트셔츠</span>
                <i class="fa-solid fa-angle-right"></i>
            </a></li>
            <li><a href="#hood">
                <span>후드/집업</span>
                <i class="fa-solid fa-angle-right"></i>
            </a></li>
            <li><a href="#fleese">
                <span>폴리스/덤블</span>
                <i class="fa-solid fa-angle-right"></i>
            </a></li>
            <li><a href="#blazer">
                <span>블레이저</span>
                <i class="fa-solid fa-angle-right"></i>
            </a></li>
            <li><a href="#slacks">
                <span>슬랙스</span>
                <i class="fa-solid fa-angle-right"></i>
            </a></li>
            <li><a href="#pants">
                <span>팬츠</span>
                <i class="fa-solid fa-angle-right"></i>
            </a></li>
        </ul>
        <div class="items" id="sweatshirt">
            <p>맨투맨/스웨트셔츠</p>
            <ul class="weekly_best">
                <c:forEach var="itemDto" items="${list1}">
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
        </div>
        <div class="items" id="hood">
            <p>후드/집업</p>
            <ul class="weekly_best">
                <c:forEach var="itemDto" items="${list2}">
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
        </div>
        <div class="items" id="fleese">
            <p>폴리스/덤블</p>
            <ul class="weekly_best">
                <c:forEach var="itemDto" items="${list3}">
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
        </div>
        <div class="items" id="blazer">
            <p>블레이저</p>
            <ul class="weekly_best">
                <c:forEach var="itemDto" items="${list4}">
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
        </div>
        <div class="items" id="slacks">
            <p>슬랙스</p>
            <ul class="weekly_best">
                <c:forEach var="itemDto" items="${list5}">
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
        </div>
        <div class="items" id="pants">
            <p>팬츠</p>
            <ul class="weekly_best">
                <c:forEach var="itemDto" items="${list6}">
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
        </div>
    </div>
</section>
<jsp:include page="/WEB-INF/views/include/footer.jsp"/>
<jsp:include page="/WEB-INF/views/include/quick.jsp"/>
<script src="/js/jquery-3.6.4.min.js"></script>
<script src="/js/nav.js?after?after"></script>
<script>
    $(document).ready(function() {
        $('a[href^="#"]').on('click', function(event) {
            event.preventDefault(); // 기본 동작 방지

            var target = this.hash; // 클릭된 링크의 해시 값(타겟 섹션 ID)
            var $target = $(target); // 타겟 섹션을 jQuery 객체로 저장

            $('html, body').animate({
                scrollTop: $target.offset().top // 타겟 섹션의 세로 위치로 스크롤
            }, 'slow', function() {
                window.location.hash = target; // 스크롤 완료 후 URL 해시 값 업데이트
            });
        });
    });
</script>
</body>
</html>
