<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>이메일 입력창</title>
</head>
<body>

<h2>이메일 본인인증을 위한 개인 이메일 주소 입력란</h2>

<h3>인증번호를 받을 이메일을 입력해주세요.</h3>

<c:if test="${not empty failMsg}">
    ${failMsg}
</c:if>

<form action="/register/send" method="POST">
    E-mail: <input type="email" name="email" placeholder="이메일 형식으로 입력해주세요.">
    <input type="submit" value="전송">
</form>

</body>
</html>
