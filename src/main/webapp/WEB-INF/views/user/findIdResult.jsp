<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" language="java" %>
<html>

<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <title>BYEZ|아이디 조회결과</title>

  <link rel="stylesheet" href="/css/findIdResult.css?after?after">
  <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.6.0/css/all.min.css" integrity="sha512-Kc323vGBEqzTmouAECnVceyQqyqdsSiqLQISBL29aUW4U/M7pSPA/gEUZQqv1cwx4OnYxTxve5UMg5GT6L4JJg==" crossorigin="anonymous" referrerpolicy="no-referrer" />
  <link rel="preconnect" href="https://fonts.googleapis.com">
  <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
  <link href="https://fonts.googleapis.com/css2?family=Noto+Sans+KR:wght@100..900&display=swap" rel="stylesheet">
  <link rel="icon" href="/img/favicon-32x32_2.png">
</head>

<body>

    <div class="wrapper">

      <div class="result-wrapper">
        <div class="title">
          <a href="/">
            <img src="/img/logo1.png" alt="메인로고" class="main-logo">
          </a>
        </div>
        <div class="content">
          <p>조회된 아이디는 다음과 같습니다.</p>

          <p class="show-cust-id">
            ${fn:substring(id, 0, 2)}
            <c:forEach begin="3" end="${id.length()}" step="1">
              *
            </c:forEach>
          </p>

          <div class="send-button">
            <button onclick="location.href='/'">HOME</button>
            <button onclick="location.href='/login/form'">LOGIN</button>
          </div>
        </div>
      </div>
    </div>
</body>

<script src="/js/jquery-3.6.4.min.js"></script>

</html>
