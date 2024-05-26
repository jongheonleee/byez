<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" language="java" %>

<!DOCTYPE html>
<html lang="ko">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>BYEZ</title>
    <link rel="stylesheet" href="/css/nav.css">
    <link rel="stylesheet" href="/css/withdrawalReason.css">
    <link rel="stylesheet" href="/css/footer.css">
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
        <p>
            <a href="main.html"><span>home</span></a>
            <span>></span>
            <!-- 마이페이지로 이동  -->
            <a href="/mypage/index"><span>mypage</span></a>
        </p>
        <div class="withdrawal-form">
            <p>탈퇴 사유 선택</p>

            <ul class="input-reason">
                <li><label><input type="checkbox" onclick="toggleCheckbox(this)"> 구매할만한 상품이 없음.</label></li>
                <label><input type="checkbox" onclick="toggleCheckbox(this)"> 개인정보 유출이 우려됨.</label><br>
                <label><input type="checkbox" onclick="toggleCheckbox(this)"> 재가입 예정임.</label> <br>
                <label><input type="checkbox" onclick="toggleCheckbox(this)"> 교환/반품/환불이 불편함.</label> <br>
                <label><input type="checkbox" onclick="toggleCheckbox(this)"> 쇼핑 기능이 어려움.</label> <br>
                <label><input type="checkbox" onclick="toggleCheckbox(this)"> 상품의 배송이 느림.</label> <br>
                <label><input type="checkbox" onclick="toggleCheckbox(this)"> 교환/반품/환불이 불편함.</label> <br>
            </ul>
            <div class="button-items">
                <button onclick="location.href='/'">탈퇴 취소</button>
                <button onclick="location.href='/mypage/withdrawal'">다음</button>
            </div>
        </div>
    </div>
</section>
<jsp:include page="/WEB-INF/views/include/footer.jsp"/>
<jsp:include page="/WEB-INF/views/include/quick.jsp"/>
</body>

<script src="/js/jquery-3.6.4.min.js"></script>
<script src="/js/nav.js"></script>

</html>
