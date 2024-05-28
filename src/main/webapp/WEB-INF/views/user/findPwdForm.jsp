<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" language="java" %>
<html>
<head>
<title>BYEZ | 비밀번호 찾기</title>
<link rel="stylesheet" href="/css/findPwdForm.css?after?after">
<script src="https://kit.fontawesome.com/f0e73cfa04.js" crossorigin="anonymous"></script>
<link rel="preconnect" href="https://fonts.googleapis.com">
<link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
<link href="https://fonts.googleapis.com/css2?family=Noto+Sans+KR:wght@100..900&display=swap" rel="stylesheet">
</head>

<body>

<div class="wrapper">

    <div class="find-pwd-input-wrapper">
        <div class="title">
            <a href="/">
                <img src="/img/logo1.png" alt="메인로고" class="main-logo">
            </a>
        </div>
        <div class="content">
            <table>
                <tr>
                    <td>
                        <input type="text" id="findPwd-id" name="id" placeholder="아이디를 입력해주세요." oninput="checkIdFormat()" required>
                    </td>
                </tr>
            </table>
            <div class="error-msg">
                <p id="id-format-error-msg"></p>
            </div>

            <table>
                <tr>
                    <td>
                        <input type="email" id="findPwd-email" name="email" placeholder="이메일을 입력해주세요." oninput="checkEmailFormat(this.value)" required>
                    </td>
                    <td>
                        <button type="submit" id="sendEmailBtn" disabled>전송</button>
                    </td>
                </tr>
            </table>
            <div class="error-msg">
                <p id="email-format-error-msg"></p>
            </div>

            <div class="input-verification-code" id="verificationDiv">
                <table>
                    <tr>
                        <td>
                            <input type="text" id="verificationCode" name="mail_key" placeholder="인증번호를 입력해주세요." required>
                        </td>
                        <td>
                            <button type="button" id="verifyCodeBtn">인증</button>
                        </td>
                    </tr>
                </table>
                <p>인증번호를 받지 못하셨다면, 다시 전송 버튼을 클릭하십시오.</p>
            </div>

        </div>
    </div>
</div>
</body>

<script src="/js/jquery-3.6.4.min.js"></script>

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
        } else if (inputValue.length === 0) {
            msg.innerHTML = ""
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
