<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>BYEZ|회원가입 본인인증</title>
    <link rel="stylesheet" href="/css/requestEmailForm.css">
    <link rel="preconnect" href="https://fonts.googleapis.com">
    <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
    <link href="https://fonts.googleapis.com/css2?family=Noto+Sans+KR:wght@100..900&display=swap" rel="stylesheet">
    <link rel="icon" href="/img/favicon-32x32_2.png">
</head>

<body>
    <div class="wrapper">
        <div class="title">
            <a href="/">
                <img src="/img/logo1.png" alt="메인로고" class="main-logo">
            </a>
        </div>
        <div class="content">
            <div class="error-msg">
                <p id="email-format-error-msg"></p>
            </div>
            <table>
                <tr>
                    <td>
                        <input type="email" id="email" name="email" oninput="checkEmailFormat(this.value)"  placeholder="이메일을 입력해주세요." required>
                    </td>
                    <td>
                        <button id="sendEmailBtn" disabled>전송</button>
                    </td>
                </tr>
            </table>
            <div class="input-verification-code" id="verificationDiv" onclick="showVerifyEmailForm()">
                <table>
                    <tr>
                        <td>
                            <input type="text" id="verificationCode" name="mail_key" placeholder="인증번호를 입력해주세요." required>
                        </td>
                        <td>
                            <button id="verifyCodeBtn">인증</button>
                        </td>
                    </tr>
                </table>
                <p>인증번호를 받지 못하셨다면, 다시 전송 버튼을 클릭하십시오.</p>
            </div>

        </div>
    </div>
</body>

<script>
    window.onload = function() {
        // showAlert가 true인 경우에만 알림창 뜸
        let showAlert = "<%= request.getAttribute("showAlert") %>";
        if (showAlert === "true") {
            alert('연결된 SNS 계정이 없습니다. 회원가입을 진행해 주세요.');
        }
    }

    function showVerifyEmailForm() {
        let verificationCodeInput = document.getElementById("verificationDiv");
        verificationCodeInput.style.display = "block"; // 인증번호 입력란 보이도록 변경
    }

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
        }
        else {
            msg.innerHTML = ""
            sendEmailBtn.disabled = false;
        }
    }
</script>

<script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
<script type="text/javascript">

    // 1. '인증번호 전송' 버튼 클릭
    $(document).ready(function() {
        $("#sendEmailBtn").click(function() {
           let email = $("#email").val();

            $.ajax({
                url: "/register/send",
                type: "POST",
                data: { email: email },
                success: function (response) {
                    $("#verificationDiv").show();
                    alert("인증번호 전송 성공")
                },
                error: function (xhr, status, error) {
                    console.error("메일 전송 실패:", error);
                    alert(xhr.responseText);
                }
            });
        });

        // 2. '인증하기' 버튼 클릭
        $("#verifyCodeBtn").click(function() {
            let verificationCode = $("input[name='mail_key']").val();
            console.log($("input[name='mail_key']").val());
            $.ajax({
                url: "/register/verifyEmail",
                type: "POST",
                data: { verificationCode: verificationCode },
                success: function(response) {
                    alert("본인인증 완료");
                    window.location.href = "/register/form";
                },
                error: function(xhr, status, error) {
                    console.error("인증 실패: ", error);
                    alert(xhr.responseText);
                }
            });
        });
    });

</script>

</html>
