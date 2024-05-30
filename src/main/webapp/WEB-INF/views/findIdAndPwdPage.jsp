<%--<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>아이디 및 비밀번호 찾기</title>
    <link rel="icon" href="/img/favicon-32x32_2.png">
</head>
<body>
    <form action="/find/findIdForm" method="GET">
        <input type="submit" value="아이디 찾기">
    </form>
    <form action="/find/findPwdForm" method="GET">
        <input type="submit" value="비밀번호 찾기">
    </form>
</body>
</html>
