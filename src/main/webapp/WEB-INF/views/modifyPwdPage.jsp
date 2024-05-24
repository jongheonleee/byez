<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>BYEZ</title>
    <link rel="stylesheet" href="/css/nav.css">
    <link rel="stylesheet" href="/css/modifyPwdPage.css">
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
            <p>
                <a href="/"><span>home</span></a>
                <span>></span>
                <a href="best.html"><span>best 50</span></a>
            </p>

            <form action="/find/modify" method="GET">
                <div class="input-new-pwd">
                    <h1>비밀번호 변경</h1>
                    <h3>새로운 비밀번호를 설정하십시오.</h3>
                    <ul class="input-id-pwd">
                        <li>
                            아이디(id): <input type="text" value="${id}" id="id2" name="id" readonly>
                        </li>
                        <li>
                            변경할 비밀번호: <input type="password" id="pwd1" name="pwd" required>

                        </li>
                        <li>
                            비밀번호 재확인: <input type="password" id="pwd2" name="pwd" oninput="checkPwdMatch();" required>
                        </li>
                        <li class="error-msg">
                            ${incorrectPwdMsg}
                        </li>
                        <li>
                            <input type="submit" value="비밀번호 변경">
                        </li>
                    </ul>
                </div>
            </form>
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
<script src="/js/aside.js"></script>

<script>
    function checkPwdMatch() {
        let pwd1 = document.getElementById('pwd1').value;
        let pwd2 = document.getElementById('pwd2').value;
        let errorMsg = document.getElementById('error-msg');

        if (pwd1 !== pwd2) {
            errorMsg.innerHTML = "비밀번호가 일치하지 않습니다."
        } else {
            errorMsg.innerHTML = "";
        }
    }
</script>

</html>
