<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%--<c:set var="path" value="${pageContext.request.contextPath}"/>--%>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>BYEZ</title>

    <link rel="stylesheet" href="/css/nav.css">
    <link rel="stylesheet" href="/css/mypage.css">
    <link rel="stylesheet" href="/css/footer.css?after?after">
    <link rel="stylesheet" href="/css/quick.css">
    <script src="https://kit.fontawesome.com/f0e73cfa04.js" crossorigin="anonymous"></script>
    <link rel="preconnect" href="https://fonts.googleapis.com">
    <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
    <link href="https://fonts.googleapis.com/css2?family=Noto+Sans+KR:wght@100..900&display=swap" rel="stylesheet">
</head>
<body>
<jsp:include page="/WEB-INF/views/include/nav.jsp"/>
<section>
    <div class="wrapper">
        <div class="title">
            <p>
                <a href="/"><span>home</span></a>
                <span>></span>
                <a href="/mypage/index"><span>마이페이지</span></a>
            </p>
            <p>마이쿠폰</p>
        </div>
        <jsp:include page="/WEB-INF/views/include/aside.jsp"/>
        <div class="content">
            <p class="table_title">마이 쿠폰 목록
                <span>(사용가능 쿠폰 : <span>12</span>장)</span>
            </p>
            <table>
                <tr>
                    <th scope="col">날짜</th>
                    <th scope="col">이름</th>
                    <th scope="col">성별</th>
                </tr>
                <tr>
                    <td>11/15</td>
                    <td>김우직</td>
                    <td>남</td>
                </tr>
                <tr>
                    <td>11/14</td>
                    <td>박수진</td>
                    <td>여</td>
                </tr>
            </table>
        </div>
    </div>
</section>
<jsp:include page="/WEB-INF/views/include/footer.jsp"/>
<jsp:include page="/WEB-INF/views/include/quick.jsp"/>
<script src="/js/jquery-3.6.4.min.js"></script>
<script src="/js/nav.js"></script>
</body>
</html>