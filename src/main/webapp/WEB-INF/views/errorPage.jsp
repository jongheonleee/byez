<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Error Page</title>
</head>
<body>

<h2>비정상 종료</h2>
  ${errorMsg}

<h4>메인화면으로 이동</h4>
<button><a href="/">HOME</a></button>
<%--<form action="<c:url value="/"/>" method="GET">--%>
<%--    <input type="submit" value="HOME">--%>
<%--</form>--%>

</body>
</html>
