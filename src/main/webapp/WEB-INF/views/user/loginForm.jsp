<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>BYEZ|로그인</title>
    <link rel="stylesheet" href="/css/loginForm.css?after?after">
    <link rel="preconnect" href="https://fonts.googleapis.com">
    <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
    <link href="https://fonts.googleapis.com/css2?family=Noto+Sans+KR:wght@100..900&display=swap" rel="stylesheet">
    <link rel="icon" href="/img/favicon-32x32_2.png">
</head>

<body>

<form action="/login/in?prevPage=${prevPage}" method="POST">
    <div class="title">
        <a href="/">
            <img src="/img/logo1.png" alt="메인로고" class="main-logo">
        </a>
    </div>
    <div class="login-msg">
        <c:if test="${not empty memberShipCheckMsg}">
            ${memberShipCheckMsg}
        </c:if>
        <c:if test="${not empty notMatchMsg}">
            ${notMatchMsg}
        </c:if>
    </div>
    <section class="input-class">
        <div class="input-field">
            <span>ID</span>
            <input type="text" id="id" name="id" value="${cookie['id'].value}" maxlength="20" placeholder="아이디를 입력해주세요." oninput="checkIdFormat()">
        </div>
        <div class="id-error-msg"></div><br>
        <div class="input-field">
            <span>PASSWORD</span>
            <input type="password" id="pwd" name="pwd" placeholder="비밀번호를 입력해주세요." oninput="checkPwdLength()">
        </div>
    </section>
    <div class="error-msg">
        ${errorMsg}
    </div>

    <div class="pwd-length-error-msg"></div><br>
    <div class="additional-function">
        <label><input type="checkbox" name="rememberId" ${cookie['id'] != null ? 'checked' : ''}> 아이디 저장</label>
        <span>
                <a href="/find/findIdForm">아이디 찾기</a> |
                <a href="/find/findPwdForm">비밀번호 찾기</a>
        </span>
    </div>
    <input type="submit" value="Login">
</form>

<%--  회원가입  --%>
<div class="sign-up-button">
    <span>byez 쇼핑몰의 회원이 아니신가요?</span>
    <button onclick="location.href='/register/verify'">Sign Up</button>

    <%-- 간편 로그인 --%>
    <div class="sns-button">
        <%--REST API key (=client_id): 873c82dfa901cd280c11ee222e944826--%>
        <a href="https://kauth.kakao.com/oauth/authorize?response_type=code&client_id=873c82dfa901cd280c11ee222e944826&redirect_uri=http://localhost:8080/kakaoLogin">
            <img src="/img/kakao.png" alt="Kakao 로그인" class="login-logo">
        </a>
        <a href="#">
            <img src="/img/naver.png" alt="Naver 로그인" class="login-logo">
        </a>
        <a href="#">
            <img src="/img/google.png" alt="Google 로그인" class="login-logo">
        </a>
        <a href="#">
            <img src="/img/facebook.png" alt="Facebook 로그인" class="login-logo">
        </a>
    </div>
</div>

</body>

<script>
    function checkIdFormat() {
        let id = document.getElementById('id').value;
        let msg = document.getElementById('id-error-msg');
        let pattern = new RegExp('^[A-Za-z0-9]+$')

        if (id.length > 0 && id.length < 3 || id.length > 20) {
            msg.innerHTML = "아이디는 3자 이상, 20자 이하로 입력해주세요.";
        } else if(id.length > 0 && !id.match(pattern)) {
            msg.innerHTML = "아이디는 영문자와 숫자만 사용 가능합니다."
        } else {
            msg.innerHTML = "";
        }
    }

    function checkPwdLength() {
        let pwd = document.getElementById('pwd').value;
        let msg = document.getElementById('pwd-length-error-msg');

        if (pwd.length > 0 && pwd.length < 8 || pwd.length > 20) {
            msg.innerHTML = "비밀번호가 8자리보다 작거나 20자리가 넘게 입력되었습니다."
        } else {
            msg.innerHTML = "";
        }
    }
</script>

</html>
