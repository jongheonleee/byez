<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jstl/core_rt" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt_rt" %>
<%@ page session="true"%><html>
<head>
    <title>Title</title>
    <link rel="icon" href="/img/favicon-32x32_2.png">
</head>
<body>

<div id="orderItemList">
    <table>
        <thead>
        <th class="td1">주문아이디</th>
        <th class="td2">상품번호</th>
        <th class="td3">수량</th>
        <th class="td4">가격</th>
        </thead>

        <tbody>
        <c:forEach var="orderItemDto" items="${list}">
            <tr>
                <td>${orderItemDto.seq}</td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
</div>
</body>
</html>
