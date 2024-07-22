<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>고객 정보</title>
    <link rel="icon" href="/img/favicon-32x32_2.png">
</head>
<body>
<div class="user-info">
    아이디: ${userDto.id} <br>
    비밀번호: <button type="button" onclick="showPwdChangeInput()">비밀번호 변경</button><br>
        <div id="pwdChangeInput" style="display: none;">
            * 현재 비밀번호: <input type="password" id="pwd" name="pwd" oninput="checkPwdLength()"><br>
            <div id="pwd-length-error-msg"></div>
            * 새 비밀번호: <input type="password" id="newPwd1" name="pwd"><br>
            * 비밀번호 확인: <input type="password" id="newPwd2" name="pwd" oninput="checkPwdMatch()"><br>
            <div id="match-error-msg"></div>
            <div id="wrong-pwd-format-msg">${wrongFormat}</div>
        </div>
        <button type="button" id="saveNewPwdBtn">저장</button><br>
    이름: ${userDto.name}<br>
    생년월일: ${userDto.bef_birth}<br>
    휴대폰번호: ${userDto.mobile_num}<br>
    주소:

    이메일: ${userDto.email} <button type="button" onclick="showEmailChangeInput()">이메일 변경</button>
        <div id="emailChangeInput" style="display: none;">
            * 변경할 이메일 주소: <input type="email" id="newEmail" name="email">
            <button type="button" id="sendEmailBtn">인증번호 전송</button>

            <div id="verificationDiv" style="display:none;">
                * 인증 번호: <input type="text" id="VerificationCode" name="mail_key" required>
                <button type="button" id="verifyCodeBtn">인증</button>
            </div>
        </div>
</div>

<a href="/">메인 화면으로 이동</a>

</body>

<script>
    function checkPwdLength() {
        let pwd = document.getElementById('pwd').value;
        let msg = document.getElementById('pwd-length-error-msg');

        if (pwd.length > 0 && pwd.length < 8 || pwd.length > 20) {
            msg.innerHTML = "비밀번호가 8자리보다 작거나 20자리가 넘게 입력되었습니다."
        } else {
            msg.innerHTML = "";
        }
    }

    function checkPwdMatch() {
        let pwd1 = document.getElementById('newPwd1').value;
        let pwd2 = document.getElementById('newPwd2').value;
        let msg = document.getElementById('match-error-msg');
        let saveBtn = document.getElementById('saveNewPwdBtn');

        if (pwd1 !== pwd2) {
            msg.innerHTML = "비밀번호가 일치하지 않습니다."
            saveBtn.disabled = true;
        } else {
            msg.innerHTML = "";
            saveBtn.disabled = false;
        }
    }

    function showPwdChangeInput() {
        let pwdChangeInput = document.getElementById("pwdChangeInput");
        pwdChangeInput.style.display = "block"; // 입력란을 보이도록 변경
    }

    function showEmailChangeInput() {
        let emailChangeInput = document.getElementById("emailChangeInput");
        emailChangeInput.style.display = "block"; // 입력란을 보이도록 변경
    }
</script>

<script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>

<script type="text/javascript">
    var userDto = {
        id: "${userDto.id}",
        name: "${userDto.name}",
        bef_birth: "${userDto.bef_birth}",
        mobile_num: "${userDto.mobile_num}",
        email: "${userDto.email}"
    };

    // 1. 비밀번호 변경
    $(document).ready(function () {
        // 1.1. '저장' 버튼 클릭
        $("#saveNewPwdBtn").click(function() {
            let id = userDto.id;
            let pwd = $("#pwd").val();
            let newPwd = $("#newPwd2").val();

            // 1.1.1. AJAX 활용하여 현재 비밀번호 및 변경할 비밀번호 controller 에 넘겨줌.
            // 1.1.2. 현재 비밀번호 정확히 입력한 경우
            // 1.1.2.1. 변경된 비밀번호 고객 정보에 저장 및 변경이력 저장
            // 1.1.3. 현재 비밀번호 잘못 입력한 경우
            // 1.1.3.1. 기존 화면에서 오류메세지 출력
            $.ajax({
                url: "<c:url value='/mypage/modifyPwd'/>",
                type: "POST",
                data: { id: id, pwd: pwd, newPwd: newPwd },
                success: function (response) {
                    alert("비밀번호 변경 성공!");
                },
                error: function (xhr, status, error) {
                    alert(xhr.responseText);
                }
            });
        });
    });

    // 2. 이메일 인증
    $(document).ready(function() {

        // 2.1. '인증번호 전송' 버튼 클릭
        $("#sendEmailBtn").click(function() {
            let id = userDto.id;
            let newEmail = $("#newEmail").val();

            // 2.1.1. AJAX 활용하여 이메일 전송 요청
            // 2.1.2.1. 변경할 새로운 이메일 주소를 controller 에 넘겨줌.
            // 2.1.2.2. 이메일 전송 성공 시 인증번호 입력란 출력
            // 2.1.2.3. 이메일 전송 실패 시 오류 메세지 출력
            $.ajax({
                url: "<c:url value='/mypage/sendEmailVerification'/>",
                type: "POST",
                data: { id: id, newEmail: newEmail },
                success: function (response) {
                    $("#verificationDiv").show();
                    alert("인증번호 전송에 성공하였습니다.");
                },
                error: function (xhr, status, error) {
                    console.error("Error sending email:", error);
                    alert(xhr.responseText);
                }
            });
        });

        // 2.2. '인증하기' 버튼 클릭
        $("#verifyCodeBtn").click(function() {
            let id = userDto.id;
            let newEmail = $("#newEmail").val();
            let verificationCode = $("input[name='mail_key']").val();

            // 2.2.1. AJAX 활용하여 인증번호 입력 결과 확인
            // 2.2.2. 인증번호 일치 시
            // 2.2.2.1. 고객정보에서 이메일 변경하여 저장 및 변경이력 추가
            // 2.2.3. 인증번호 불일치 시
            // 2.2.3.1. 기존 화면에서 오류메세지 출력
            $.ajax({
                url: "<c:url value='/mypage/verifyEmail'/>",
                type: "POST",
                data: { id: id, newEmail: newEmail, verificationCode: verificationCode },
                success: function(response) {
                    alert("이메일 변경 성공!");
                },
                error: function(xhr, status, error) {
                    console.error("Error verifying code:", error);
                    alert(xhr.responseText);
                }
            });
        });
    });

</script>

</html>
