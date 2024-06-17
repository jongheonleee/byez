<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>login page</title>
</head>

<style>
    * { box-sizing: border-box; }
    form {
        border: solid black 3px;
        padding: 10px;
        width:500px;
        height:600px;
        display: flex;
        flex-direction: column;
        align-items:center;
        position : absolute;
        top: 50%;
        left: 50%;
        transform: translate(-50%, -50%) ;
    }
    .title {
        text-align: center;
        color: darkblue;
        font-weight: bold;
        font-size: 35px;
    }
    .input-field {
        justify-content: center;
        width: 400px;
        height: 40px;
        border : 1px solid rgb(89,117,196);
        padding: 0 10px;
        margin-bottom: 10px;
        line-height: 40px;
    }
    #id, #pwd {
        width: 250px;
        height: 30px;
        border: none;
        background: transparent;
    }
    #id:focus, #pwd:focus { outline: none; }
    #login-msg {
        height: 30px;
        text-align:center;
        font-size:15px;
        color:red;
        margin-bottom: 20px;
    }
    #error-msg {
        font-size:15px;
        margin-bottom: 20px;
    }
    input::placeholder { font-size: 15px; }
    input[type=checkbox] {
        text-align: right;
        margin: 10px;
    }
    input[type=submit] {
        width: 400px;
        height: 50px;
        color: whitesmoke;
        font-size: 20px;
        font-weight: bold;
        background-color: darkblue;
    }
    input[type=submit]:hover {
        background-color: yellow;
        color: black;
        font-weight: bold;
        font-size: 23px;
    }
    #simple-sign-up-in {
        margin: 20px;
    }
    #find-id-and-pwd {
        font-size: 15px;
        /*우측 정렬이 안됨...*/
        float: right;
    }
    a, div > a:visited, div > a:hover,  div > a:focus,  div > a:active {
        text-align: right;
        margin: 10px;
        text-decoration: none;
        color: black;
        font-family: Arial, Sans-serif, serif;
        font-weight: bold;
        font-size: 20px;
    }
    span {
        margin: 20px 5px 5px 0;
        font-family: Arial, Sans-serif, Serif;
        font-weight: bold;
    }
    #id-error-msg, #pwd-length-error-msg { color: red }
</style>

<body>
<form action="/login/in" method="POST">
    <div class = title><h3>Login</h3></div>
    <div id="login-msg">
        <c:if test="${not empty memberShipCheckMsg}">
            <h5>${memberShipCheckMsg}</h5>
        </c:if>
        <c:if test="${not empty notMatchMsg}">
            <h5>${notMatchMsg}</h5>
        </c:if>
    </div>
    <div id="error-msg">
        ${errorMsg}
    </div>
    <div class="input-field">ID: <input type="text" id="id" name="id" value="${cookie['id'].value}" maxlength="20" placeholder="ID (20자리 이하의 영문 아이디)" oninput="checkIdFormat()"></div>
        <div id="id-error-msg"></div><br>
    <div class="input-field">PASSWORD: <input type="password" id="pwd" name="pwd" placeholder="PASSWORD" oninput="checkPwdLength()"></div>
        <div id="pwd-length-error-msg"></div><br>
    <label><input type="checkbox" name="rememberId" ${cookie['id'] != null ? 'checked' : ''}>아이디 저장</label>

    <a id="find-id-and-pwd" href="/find/authorize">아이디/비밀번호 찾기</a>
    <input type="submit" value="Login">

        <%--  회원가입  --%>
<%--    <span>SUPAO 쇼핑몰의 회원이 아니신가요?</span>--%>
<%--    <input type="submit" value="Sign up">--%>

    <div id="simple-sign-up-in">--------- 간편 가입 및 로그인 ----------</div>
    <%--REST API key (=client_id): 873c82dfa901cd280c11ee222e944826--%>
    <a href="https://kauth.kakao.com/oauth/authorize?response_type=code&client_id=873c82dfa901cd280c11ee222e944826&redirect_uri=http://localhost:8080/kakaoLogin">
        <img src="../image/kakao_login_logo.png" alt="Kakao 로그인">
    </a>
</form>
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
