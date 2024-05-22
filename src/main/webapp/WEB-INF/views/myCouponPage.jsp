<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page language="java" contentType="text/html; charset=utf-8" %>
<!DOCTYPE html>
<html lang="ko">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>BYEZ</title>
    <link rel="stylesheet" href="css/nav.css">
    <link rel="stylesheet" href="css/myCouponPage.css">
    <link rel="stylesheet" href="css/footer.css">
    <link rel="stylesheet" href="css/quick.css">
    <script src="https://kit.fontawesome.com/f0e73cfa04.js" crossorigin="anonymous"></script>
    <link rel="preconnect" href="https://fonts.googleapis.com">
    <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
    <link href="https://fonts.googleapis.com/css2?family=Noto+Sans+KR:wght@100..900&display=swap" rel="stylesheet">
</head>
<body>
<jsp:include page="/WEB-INF/views/include/nav.jsp"/>
<section>
    <div class="wrapper">
        <div class="title">
            <p>
                <a href="/"><span>home</span></a>
                <span>></span>
                <a href="myCouponPage"><span>마이쿠폰</span></a>
            </p>
            <p>마이쿠폰</p>
        </div>
        <jsp:include page="/WEB-INF/views/include/aside.jsp"/>
        <div class="content">
            <p class="table_title">마이 쿠폰 목록
                <span>(사용가능 쿠폰 : <span>${coupons.size()}</span>장)</span>
            </p>
            <c:set var="limitDate" value="2500-01-01" />
            <table>
                <thead>
                <tr>
                    <th scope="col">번호</th>
                    <th scope="col">쿠폰명</th>
                    <th scope="col">쿠폰 혜택</th>
                    <th scope="col">최소주문금액</th>
                    <th scope="col">만료일</th>
                </tr>
                </thead>
                <tbody>
                <c:forEach items="${coupons}" var="coupon" varStatus="loop">
                    <tr>
                        <td>${loop.index + 1}</td>
                        <td>${coupon.couponDto.name}</td>
                        <td>
                            <c:choose>
                                <c:when test="${coupon.couponDto.discType eq 'PER'}">
                                    ${coupon.couponDto.prmo}% (최대 ${coupon.couponDto.maxDiscPrice}원 할인)
                                </c:when>
                                <c:otherwise>
                                    -${coupon.couponDto.prmo} (최대 ${coupon.couponDto.maxDiscPrice}원 할인)
                                </c:otherwise>
                            </c:choose>
                        </td>
                        <td>
                            <c:choose>
                                <c:when test="${coupon.couponDto.minPayPrice == 0 or empty coupon.couponDto.minPayPrice}">
                                    제한 없음
                                </c:when>
                                <c:otherwise>
                                    ${coupon.couponDto.minPayPrice}
                                </c:otherwise>
                            </c:choose>
                        </td>
                        <td>
                            <c:choose>
                                <c:when test="${coupon.custCouponsDto.expDate >= limitDate}"> <!-- 3000년 이상인 경우 -->
                                    제한 없음
                                </c:when>
                                <c:otherwise>
                                    <fmt:parseDate var="parsedDate" value="${coupon.custCouponsDto.expDate}" pattern="yyyy-MM-dd" />
                                    <fmt:formatDate value="${parsedDate}" pattern="yyyy-MM-dd"/>
                                </c:otherwise>
                            </c:choose>
                        </td>
                    </tr>
                </c:forEach>
                </tbody>
            </table>
        </div>
    </div>
</section>
<footer>
    <div class="wrapper">
        <p>© 2024 spao-copymachine. All rights not reserved.</p>
    </div>
</footer>
<div class="quick">
    <a href="#none" onclick="jQuery('html,body').animate({scrollTop:0},'slow')">
        <img src="img/quick_up.png" alt="">
    </a>
    <a href="#none" onclick="jQuery('html,body').animate({scrollTop:$(document).height()},'slow');">
        <img src="img/quick_down.png" alt="">
    </a>
</div>
<script src="js/jquery-3.6.4.min.js"></script>
<script src="js/nav.js"></script>
</body>
</html>