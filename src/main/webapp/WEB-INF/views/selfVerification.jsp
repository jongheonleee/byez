<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>인증번호 확인</title>
</head>
<body>

<c:if test="${not empty failMsg}">
    ${failMsg}
</c:if>

<h3>이메일로 받은 인증번호를 입력하세요.</h3>
<form action="/register/verification" method="POST">
    인증번호: <input type="text" name="mail_key">
    <input type="submit" value="전송">
</form>
</body>
</html>
