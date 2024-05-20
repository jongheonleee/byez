<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" language="java" %>
<html>
<title>[BYEZ] 비밀번호 찾기</title>

<link rel="stylesheet" href="/css/nav.css">
<link rel="stylesheet" href="/css/findPwdForm.css">
<link rel="stylesheet" href="/css/footer.css">
<link rel="stylesheet" href="/css/quick.css">
<script src="https://kit.fontawesome.com/f0e73cfa04.js" crossorigin="anonymous"></script>
<link rel="preconnect" href="https://fonts.googleapis.com">
<link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
<link href="https://fonts.googleapis.com/css2?family=Noto+Sans+KR:wght@100..900&display=swap" rel="stylesheet">

<body>

<%@include file="../../views/include/nav.jsp"%>

<section>
    <div class="wrapper">
        <p>
            <a href="main.html"><span>home</span></a>
            <span>></span>
            <a href="/login/form"><span>login</span></a>
        </p>

        <div class="find-pwd-input">
            <h1>비밀번호 찾기</h1>
            <h3>회원가입 시 입력한 아이디 및 이메일 주소를 입력하십시오.</h3>

            <ul class="submit-email">
                <li>
                    아이디: <input type="text" id="findPwd-id" name="id" placeholder="아이디를 입력하십시오." oninput="checkIdFormat()" required>
                </li>
                <div id="id-format-error-msg"></div>
                <li>
                    이메일: <input type="email" id="findPwd-email" name="email" placeholder="byez@example.com" oninput="checkEmailFormat(this.value)" required>
                    <button type="submit" id="sendEmailBtn">인증 요청</button>
                </li>
                <div id="email-format-error-msg"></div>
                <ul class="verify-email" id="verificationDiv">
                    <li>
                        인증번호: <input type="text" id="verificationCode" name="mail_key" required>
                        <button type="button" id="verifyCodeBtn">인증</button>
                    </li>
                </ul>
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

<script>
    function checkIdFormat() {
        let id = document.getElementById('findPwd-id').value;
        let pattern = new RegExp('^[A-Za-z0-9]+$')
        let msg = document.getElementById('id-format-error-msg');

        if (id.length > 0 && id.length < 3 || id.length > 20) {
            msg.innerHTML = "아이디는 3자 이상, 20자 이하로 입력해주세요.";
        } else if(id.length > 0 && !id.match(pattern)) {
            msg.innerHTML = "아이디는 영문자와 숫자만 사용 가능합니다."
        } else {
            msg.innerHTML = "";
        }
    }

    // 이메일 유효성 검증
    function checkEmailFormat(inputValue) {
        let emailPattern = /^[a-zA-Z0-9._-]+@[a-zA-Z0-9.-]+\.[a-zA-Z]{2,3}$/i;
        let sendEmailBtn = document.getElementById("sendEmailBtn");
        let msg = document.getElementById("email-format-error-msg");

        if (inputValue.length > 0 && !emailPattern.test(inputValue)) {
            msg.innerHTML = "잘못된 이메일 형식입니다.";
            sendEmailBtn.disabled = true;
        } else {
            msg.innerHTML = ""
            sendEmailBtn.disabled = false;
        }
    }


</script>

<script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
<script type="text/javascript">
    $(document).ready(function() {
        // 1. '인증번호 전송' 버튼 클릭
        $("#sendEmailBtn").click(function () {
            let id = $("#findPwd-id").val();
            let email = $("#findPwd-email").val();

            $.ajax({
                url: "/find/verify2",
                type: "POST",
                data: {id: id, email: email},
                success: function (response) {
                    $("#verificationDiv").show();
                    alert("인증번호 전송에 성공했습니다.");
                },
                error: function (xhr, status, error) {
                    console.error("메일 전송 실패:", error);
                    alert(xhr.responseText);
                }
            });
        });

        // 2. '인증하기' 버튼 클릭
        $("#verifyCodeBtn").click(function() {
            let id = $("#findPwd-id").val();
            let verificationCode = $("#verificationCode").val();

            $.ajax({
                url: "/find/findPwd",
                type: "POST",
                data: { id: id, verificationCode: verificationCode },
                success: function(response) {
                    alert("본인인증 완료");
                    window.location.href = "/find/move";
                },
                error: function(xhr, status, error) {
                    console.error("인증 실패:", error);
                    alert(xhr.responseText);
                }
            });
        });
    });
</script>

</html>
<%--    <div class="find-title">--%>
<%--        <h2>비밀번호 찾기</h2>--%>
<%--    </div>--%>

<%--    <div class="find-notice">--%>
<%--        <h3>아이디와 이메일을 입력해주세요.</h3>--%>
<%--    </div>--%>

<%--    <ul class="submit-email">--%>
<%--        <li>--%>
<%--            아이디: <input type="text" id="findPwd-id" name="id" placeholder="아이디를 입력하십시오." oninput="checkIdFormat()" required>--%>
<%--        </li>--%>
<%--        <li>--%>
<%--            회원가입 시 입력한 이메일 주소를 입력하십시오.--%>
<%--            이메일: <input type="email" id="findPwd-email" name="email" placeholder="byez@example.com" required>--%>
<%--            <button type="submit" id="sendEmailBtn">인증 요청</button>--%>
<%--        </li>--%>
<%--    </ul>--%>

<%--    <div id="verificationDiv">--%>
<%--        인증번호: <input type="text" id="verificationCode" name="mail_key" required>--%>
<%--        <button type="button" id="verifyCodeBtn">인증</button>--%>
<%--    </div>--%>

<%--</body>--%>
<%--<script>--%>
<%--    function checkIdFormat() {--%>
<%--        let id = document.getElementById('findPwd-Id').value;--%>
<%--        let pattern = new RegExp('^[A-Za-z0-9]+$')--%>
<%--        let msg = document.getElementById('id-error-msg');--%>

<%--        if (id.length > 0 && id.length < 3 || id.length > 20) {--%>
<%--            msg.innerHTML = "아이디는 3자 이상, 20자 이하로 입력해주세요.";--%>
<%--        } else if(id.length > 0 && !id.match(pattern)) {--%>
<%--            msg.innerHTML = "아이디는 영문자와 숫자만 사용 가능합니다."--%>
<%--        } else {--%>
<%--            msg.innerHTML = "";--%>
<%--        }--%>
<%--    }--%>
<%--</script>--%>

<%--<script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>--%>
<%--<script type="text/javascript">--%>
<%--    $(document).ready(function() {--%>
<%--        // 1. '인증번호 전송' 버튼 클릭--%>
<%--        $("#sendEmailBtn").click(function () {--%>
<%--            let id = $("#findPwd-id").val();--%>
<%--            let email = $("#findPwd-email").val();--%>

<%--            $.ajax({--%>
<%--                url: "/find/verify2",--%>
<%--                type: "POST",--%>
<%--                data: {id: id, email: email},--%>
<%--                success: function (response) {--%>
<%--                    $("#verificationDiv").show();--%>
<%--                    alert("인증번호 전송에 성공했습니다.");--%>
<%--                },--%>
<%--                error: function (xhr, status, error) {--%>
<%--                    console.error("메일 전송 실패:", error);--%>
<%--                    alert(xhr.responseText);--%>
<%--                }--%>
<%--            });--%>
<%--        });--%>

<%--        // 2. '인증하기' 버튼 클릭--%>
<%--        $("#verifyCodeBtn").click(function() {--%>
<%--            let id = $("#findPwd-id").val();--%>
<%--            // let email = $("#findPwd-email").val();--%>
<%--            let verificationCode = $("#verificationCode").val();--%>

<%--            $.ajax({--%>
<%--                url: "/find/findPwd",--%>
<%--                type: "POST",--%>
<%--                data: { id: id, verificationCode: verificationCode },--%>
<%--                success: function(response) {--%>
<%--                    alert("본인인증 완료");--%>
<%--                    window.location.href = "/find/move";--%>
<%--                },--%>
<%--                error: function(xhr, status, error) {--%>
<%--                    console.error("인증 실패:", error);--%>
<%--                    alert(xhr.responseText);--%>
<%--                }--%>
<%--            });--%>
<%--        });--%>
<%--    });--%>
<%--</script>--%>

