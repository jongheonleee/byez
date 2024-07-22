<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Verification Code</title>
    <link rel="preconnect" href="https://fonts.googleapis.com">
    <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
    <link href="https://fonts.googleapis.com/css2?family=Noto+Sans+KR:wght@100..900&display=swap" rel="stylesheet">
    <link rel="icon" href="/img/favicon-32x32_2.png">
</head>
<body>

<h1>인증번호 입력</h1>

<c:if test="${empty findPwd}">
    <form action="/find/findId" method="GET">
</c:if>

<c:if test="${not empty findPwd}">
    <form action="/find/findPwd" method="GET">
        아이디: <input type="text" name="id" value="${userDto.getId()}" readonly><br>
</c:if>

        이메일: <input type="text" name="email" value="${userDto.getEmail()}" readonly><br>
        인증번호: <input type="text" name="mail_key" placeholder="인증번호를 입력해주세요." required>
        <input type="submit" value="제출">

    </form>

        <c:if test="${not empty incorrectCodeMsg}">
            <h4>${incorrectCodeMsg}</h4>
        </c:if>

<h4>이메일을 받지 못한 경우 아래의 버튼을 눌러 다시 이메일을 입력해주세요.</h4>

    <c:if test="${empty findPwd}">
        <form action="/find/findIdForm" method="GET">
            <input type="submit" value="Back">
        </form>
    </c:if>

    <c:if test="${not empty findPwd}">
        <form action="/find/findPwdForm" method="GET">
            <input type="submit" value="Back">
        </form>
    </c:if>

</body>
</html>
