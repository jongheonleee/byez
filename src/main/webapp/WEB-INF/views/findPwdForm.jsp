<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<style>
    #id-error-msg { color: red }
</style>
<body>
<div class="find-title">
    <h2>비밀번호 찾기</h2>
</div>

<div class="find-notice">
    <h3>아이디와 이메일을 입력해주세요.</h3>
</div>

<c:if test="${not empty wrongIdOrEmailMsg}">
    ${wrongIdOrEmailMsg}
</c:if>

<c:if test="${not empty memberShipCheckMsg}">
    ${memberShipCheckMsg}
</c:if>

<div id="check-format">
    <c:if test="${not empty wrongIdFormat}">
        ${wrongIdFormat}
    </c:if>
    <c:if test="${not empty wrongEmailFormat}">
        ${wrongEmailFormat}
    </c:if>
</div>

<form action="/find/verify2" method="POST">
    아이디: <input type="text" id="findPwd-Id" name="id" placeholder="아이디를 입력하십시오." oninput="checkIdFormat()" required>
        <div id="id-error-msg"></div><br>
    인증번호를 받을 이메일을 입력하십시오.
    이메일: <input type="email" id="findPwd-email" name="email" placeholder="이메일 형식에 맞추어 입력하십시오." required>
    <div class="find-btn-box">
        <button type="submit" id="findId-next-btn">인증 요청</button>
    </div>
</form>
</body>
<script>
    function checkIdFormat() {
        let id = document.getElementById('findPwd-Id').value;
        let pattern = new RegExp('^[A-Za-z0-9]+$')
        let msg = document.getElementById('id-error-msg');

        if (id.length > 0 && id.length < 3 || id.length > 20) {
            msg.innerHTML = "아이디는 3자 이상, 20자 이하로 입력해주세요.";
        } else if(id.length > 0 && !id.match(pattern)) {
            msg.innerHTML = "아이디는 영문자와 숫자만 사용 가능합니다."
        } else {
            msg.innerHTML = "";
        }
    }
</script>
</html>
