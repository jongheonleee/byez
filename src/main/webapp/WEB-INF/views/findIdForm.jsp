<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>

<head>
    <title>[BYEZ] 아이디 찾기</title>
</head>

<link rel="stylesheet" href="/css/nav.css">
<link rel="stylesheet" href="/css/findIdForm.css">
<link rel="stylesheet" href="/css/footer.css">
<link rel="stylesheet" href="/css/quick.css">
<script src="https://kit.fontawesome.com/f0e73cfa04.js" crossorigin="anonymous"></script>
<link rel="preconnect" href="https://fonts.googleapis.com">
<link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
<link href="https://fonts.googleapis.com/css2?family=Noto+Sans+KR:wght@100..900&display=swap" rel="stylesheet">

<body>
    <jsp:include page="/WEB-INF/views/include/nav.jsp"/>
    <section>
        <div class="wrapper">
            <p>
                <a href="main.html"><span>home</span></a>
                <span>></span>
                <a href="best.html"><span>best 50</span></a>
            </p>

            <div class="find-id-input">
                <h1>아이디 찾기</h1>
                <h3>회원가입 시 등록한 아이디를 입력하십시오.</h3>

                <ul class="submit-email">
                    <li>
                        이메일: <input type="email" id="findId-email" name="email" placeholder="byez@example.com" oninput="checkEmailFormat(this.value)" required>
                        <button type="button" id="sendEmailBtn">인증번호 전송</button>
                        <div id="wrong-email-format-msg"></div>
                    </li>

                </ul>

                <ul id="verificationDiv">
                    <li>
                        <h5>이메일을 받지 못한 경우 다시 인증번호 전송 버튼을 누르십시오.</h5>
                    </li>
                    <li>
                        인증번호: <input type="text" id="verificationCode" name="mail_key" required>
                        <button type="button" id="verifyCodeBtn">인증</button>
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

<script>
    function checkEmailFormat(inputValue) {
        let pattern = new RegExp('[a-z0-9._%+-]+@[a-z0-9.-]+\.[a-z]{2,}$')
        let msg = document.getElementById('wrong-email-format-msg');
        // let sendEmailBtn = document.getElementById('sendEmailBtn');

        if(inputValue.length > 0 && !inputValue.match(pattern)) {
            msg.innerHTML = "이메일 형식이 올바르지 않습니다.";
            // sendEmailBtn.disabled = true;
        } else {
            msg.innerHTML = "";
            // sendEmailBtn.disabled = false;
        }
    }
</script>


<script src="/js/jquery-3.6.4.min.js"></script>
<script src="/js/nav.js"></script>

<script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
<script type="text/javascript">
    $(document).ready(function() {

        // 1. '인증번호 전송' 버튼 클릭
        $("#sendEmailBtn").click(function () {
            let email = $("#findId-email").val();

            $.ajax({
                url: "/find/verify",
                type: "POST",
                data: {email: email},
                success: function (response) {
                    $("#verificationDiv").css('visibility', 'visible');
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
            let email = $("#findId-email").val();
            let verificationCode = $("input[name='mail_key']").val();

            $.ajax({
                url: "/find/findId",
                type: "POST",
                data: { email: email, verificationCode: verificationCode },
                success: function(response) {
                    alert("본인인증 완료");
                    window.location.href = "/find/myId";
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
