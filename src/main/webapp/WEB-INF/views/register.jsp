<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<style>
    h2 { margin: 20px; }
    h4 {
        margin: 20px;
        color: red;
    }
    #register-form {
        padding: 10px;
        margin: 20px;
        border-color: gray;
        border-style: solid;
        border-width: 2px;
        width: 650px;
        height: 600px;
    }
    a, div > a:visited, div > a:hover,  div > a:focus,  div > a:active {
        justify-items: center;
        text-decoration: none;
        color: black;
    }
    #match-error-msg, #pwd-length-error-msg, #id-error-msg, #birth-error-msg, #name-error-msg, #number-error-msg { color: red }
</style>
<body>
<h2>회원가입</h2>
<h4>*필수입력 항목</h4>

<div id="register-form">
<h3>기본정보</h3>
    <c:if test="${not empty errorMsg}">${errorMsg}</c:if>

    <form action="/register/save" method="POST">

        *이름: <input type="text" id="name" name="name" maxlength="6" required oninput="checkNameFormat()"><br>
            <div id="name-error-msg"></div><br>
        성별: <input type="radio" name="sex" value="M"> M  <input type="radio" name="sex" value="F"> F <br><br>
        *아이디: <input type="text" id="id" name="id" maxlength="20" placeholder="3자리 이상 입력하세요." oninput="checkIdFormat()" required><br>
            <div id="id-error-msg"></div><br>
        비밀번호는 영문, 숫자, 특수문자를 최소 1개 이상 포함하여 8자 이상 20자 이하로 입력해주세요.<br>
        *비밀번호: <input type="password" id="pwd1" name="pwd" maxlength="20" oninput="checkPwdLength()" required><br>
            <c:if test="${not empty wrongPwdMsg}">${wrongPwdMsg}</c:if>
            <div id="pwd-length-error-msg"></div><br>
        *비밀번호 확인: <input type="password" id="pwd2" name="pwd" oninput="checkPwdMatch()" required><br>
            <div id="match-error-msg"></div><br>
        생년월일: <input type="text" id="birth1" name="bef_birth" placeholder="8자리로 입력하세요." maxlength="8" oninput="checkBirthFormat()">
        - <input type="text" id="birth2" name="af_birth" maxlength="1"><br>
            <div id="birth-error-msg"></div><br>
        전화번호: <input type="text" id="tel_num" name="tel_num" placeholder="-제외한 숫자만 입력하십시오." oninput="restrictToNumbers(this.value)"><br><br>
        핸드폰 번호: <input type="text" id="mobile_num" name="mobile_num" placeholder="-제외한 숫자만 입력하십시오." oninput="restrictToNumbers(this.value)"><br><br>
            <div id="number-error-msg"></div><br>
        *E-mail: <input type="email" name="email" required><br><br>

        <input type="submit" value="제출">

    </form>
    <button><a href="/">가입취소</a></button>
</div>
</body>

<script>
    function checkNameFormat() {
        let id = document.getElementById('name').value;
        let msg = document.getElementById('name-error-msg');
        let pattern = new RegExp('^[\s,ㄱ-ㅎ가-힣]+$');

        if (id.length > 0 && !id.match(pattern)) {
            msg.innerHTML = "이름은 한글만 입력 가능합니다.";
        } else {
            msg.innerHTML = "";
        }
    }

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
        let pwd1 = document.getElementById('pwd1').value;
        let msg = document.getElementById('pwd-length-error-msg');

        if (pwd1.length > 0 && pwd1.length < 8 || pwd1.length > 20) {
            msg.innerHTML = "비밀번호가 8자리보다 작거나 20자리가 넘게 입력되었습니다."
        } else {
            msg.innerHTML = "";
        }
    }

    function checkPwdMatch() {
        let pwd1 = document.getElementById('pwd1').value;
        let pwd2 = document.getElementById('pwd2').value;
        let msg = document.getElementById('match-error-msg');

        if (pwd1 !== pwd2) {
            msg.innerHTML = "비밀번호가 일치하지 않습니다."
        } else {
            msg.innerHTML = "";
        }
    }

    function checkBirthFormat() {
        let birth1 = document.getElementById('birth1').value;
        let birth2 = document.getElementById('birth2');
        let pattern = new RegExp('^[0-9]+$')

        let msg = document.getElementById('birth-error-msg');

        if (birth1.length > 0 && !birth1.match(pattern)) {
            msg.innerHTML = "숫자만 입력 가능합니다.";
        } else if (birth1.length > 0 && birth1.length !== 8) {
            msg.innerHTML = "생년월일은 8자리로 입력해주세요.";
        } else if (birth1.length === 8) {
            birth2.focus();
        } else {
            msg.innerHTML = "";
        }
    }

    function restrictToNumbers(inputValue) {
        let pattern = new RegExp('^[0-9]+$');
        let msg = document.getElementById('number-error-msg')

        if (inputValue.length > 0 && !inputValue.match(pattern)) {
            msg.innerHTML = "전화번호 또는 핸드폰 번호는 숫자만 입력 가능합니다."
        } else {
            msg.innerHTML = "";
        }
    }
</script>

</html>