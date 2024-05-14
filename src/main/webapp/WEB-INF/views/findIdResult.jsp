<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>아이디 찾기 결과</title>
</head>
<body>
<h4 class="find-title">아이디 찾기 결과입니다.</h4>
<c:choose>
    <c:when test="${empty id}">
        등록된 아이디가 없습니다. <br>
        입력한 정보를 다시 한 번 확인해주세요.
    </c:when>

    <c:otherwise>
        <div>
            <%-- 앞 4자리는 그대로 출력  --%>
            ${fn:substring(id, 0, 4)}
            <%-- 5번째부터는 * 으로 출력 --%>
            <c:forEach begin="5" end="${id.length()}" step="1">
                *
            </c:forEach>
        </div>
    </c:otherwise>
</c:choose>

<form action="/" method="GET">
    <input type="submit" value="HOME" class="find-result-btn-login">
</form>
<form action="/login/form" method="GET">
    <input type="submit" value="LOGIN" class="find-result-btn-login">
</form>

</body>
</html>