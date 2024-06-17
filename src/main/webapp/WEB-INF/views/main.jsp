<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<body>

<div class="index-container">
    <a id="title" href="/">SUPAO</a>
    <a href="/">WOMAN</a>
    <a href="/">MAN</a>
    <a href="/">KIDS</a>
    <c:if test="${sessionScope.loginState == null}">
        <a href="/login/form">LOGIN</a>
    </c:if>
    <c:if test="${sessionScope.loginState != null}">
        <a href="/login/out">LOGOUT</a>
        <a href="/mypage/modifyPage">회원정보 수정</a>
        <a href="/mypage/withdrawalReason">탈퇴 사유</a>
    </c:if>
    <a href="/register/verify">SIGN UP</a>
</div>

<div class="login-state">
    <c:if test="${empty userName}">
        <h3>로그인이 필요합니다.</h3>
    </c:if>
    <c:if test="${not empty sessionScope}">
        <h3>${sessionScope.userName}님이 접속하셨습니다.</h3>
    </c:if>
</div>

<h1>Main Page</h1>

</body>
</html>
