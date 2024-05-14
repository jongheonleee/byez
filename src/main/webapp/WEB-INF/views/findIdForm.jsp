<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>아이디 찾기</title>
</head>
<style>
    #check-format {
        color: red;
        padding: 20px 0;
    }
</style>
<body>
<div class="find-title">
    <h2>아이디 찾기</h2>
</div>

<div class="find-content">
    <h3>가입 시 등록하신 이메일을 입력해주세요.</h3>
</div>

<%-- 아이디 찾을 수 없음에 대한 오류메세지 출력 --%>
<c:if test="${not empty nonMemberMsg}">
    ${nonMemberMsg}
</c:if>

<div id="check-format">
    <c:if test="${not empty wrongFormat}">
        ${wrongFormat}
    </c:if>
</div>

<form action="/find/verify" method="POST">
    이메일: <input type="email" id="findId-email" name="email" placeholder="이메일 형식으로 입력해주세요." required>
    <div class="find-btn-box">
        <button type="submit" id="findId-next-btn">인증 요청</button>
    </div>
</form>

</body>
</html>
