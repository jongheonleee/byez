<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" language="java" %>
<html>

<head>
    <title>BYEZ|아이디 찾기</title>
    <link rel="stylesheet" href="/css/findIdForm.css?after?after">
    <script src="https://kit.fontawesome.com/f0e73cfa04.js" crossorigin="anonymous"></script>
    <link rel="preconnect" href="https://fonts.googleapis.com">
    <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
    <link href="https://fonts.googleapis.com/css2?family=Noto+Sans+KR:wght@100..900&display=swap" rel="stylesheet">
    <link rel="icon" href="/img/favicon-32x32_2.png">
</head>

<body>
    <div class="wrapper">
        <div class="find-id-input-wrapper">
            <div class="title">
                <a href="/">
                    <img src="/img/logo1.png" alt="메인로고" class="main-logo">
                </a>
            </div>
            <div class="content">
                <div class="error-msg">
                    <p id="wrong-email-format-msg"></p>
                </div>
                <table>
                    <tr>
                        <td>
                            <input type="email" id="findId-email" name="email" placeholder="이메일을 입력해주세요." oninput="checkEmailFormat(this.value)" required>
                        </td>
                        <td>
                            <button type="button" id="sendEmailBtn" disabled>전송</button>
                        </td>
                    </tr>
                </table>

                <div class="input-verification-code" id="verificationDiv">
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
    </div>
</body>

<script>
    function checkEmailFormat(inputValue) {
        let pattern = new RegExp('^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}$')
        let msg = document.getElementById('wrong-email-format-msg');
        // let sendEmailBtn = document.getElementById('sendEmailBtn');

        if(inputValue.length > 0 && !inputValue.match(pattern)) {
            msg.innerHTML = "이메일 형식이 올바르지 않습니다.";
            sendEmailBtn.disabled = true;
        } else if (inputValue.length == 0) {
            msg.innerHTML = "";
            sendEmailBtn.disabled = true;
        }
        else {
            msg.innerHTML = "";
            sendEmailBtn.disabled = false;
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
