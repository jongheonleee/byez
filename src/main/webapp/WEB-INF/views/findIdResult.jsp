<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>

<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <title>BYEZ</title>
  <link rel="stylesheet" href="/css/nav.css">
  <link rel="stylesheet" href="/css/findIdResult.css">
  <link rel="stylesheet" href="/css/footer.css">
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
    <p>
      <a href="/"><span>home</span></a>
      <span>></span>
      <a href="best.html"><span>best 50</span></a>
    </p>

    <div class="find-id-result">
      <h1>아이디 조회 결과</h1>
      <h3>조회된 아이디는 다음과 같습니다.</h3>
      <ul class="show-cust-id">
        <li>
          <!-- <%-- 앞 4자리는 그대로 출력  --%> -->
          <!-- <%-- 5번째부터는 * 으로 출력 --%> -->
          ${fn:substring(id, 0, 4)}
          <c:forEach begin="5" end="${id.length()}" step="1">
            *
          </c:forEach>
        </li>
      </ul>
      <ul class="submit-button">
        <li>
          <form action="/" method="GET">
            <input type="submit" value="HOME" class="find-result-btn-login">
          </form>
        </li>
        <li>
          <form action="/login/form" method="GET">
            <input type="submit" value="LOGIN" class="find-result-btn-login">
          </form>
        </li>
      </ul>
    </div>
  </div>
</section>
<footer>
  <div class="wrapper">
    <p>© 2024 spao-copymachine. All rights not reserved.</p>
  </div>
</footer>
<div class="quick">
  <a href="#none" onclick="jQuery('html,body').animate({scrollTop:0},'slow')">
    <img src="/img/quick_up.png" alt="">
  </a>
  <a href="#none" onclick="jQuery('html,body').animate({scrollTop:$(document).height()},'slow');">
    <img src="/img/quick_down.png" alt="">
  </a>
</div>
</body>

<script src="/js/jquery-3.6.4.min.js"></script>
<script src="/js/nav.js"></script>

</html>
