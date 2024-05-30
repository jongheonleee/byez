<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>BYEZ</title>
    <link rel="stylesheet" href="/css/nav.css">
    <link rel="stylesheet" href="/css/withdrawalForm.css">
    <link rel="stylesheet" href="/css/footer.css?after?after">
    <link rel="stylesheet" href="/css/aside.css?after">
    <link rel="stylesheet" href="/css/quick.css">
    <script src="https://kit.fontawesome.com/f0e73cfa04.js" crossorigin="anonymous"></script>
    <link rel="preconnect" href="https://fonts.googleapis.com">
    <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
    <link href="https://fonts.googleapis.com/css2?family=Noto+Sans+KR:wght@100..900&display=swap" rel="stylesheet">
    <link rel="icon" href="/img/favicon-32x32_2.png">
</head>
<body>
    <jsp:include page="/WEB-INF/views/include/nav.jsp"/>
    <section>
        <div class="wrapper">
            <div class="title">
                <p>
                    <a href="/"><span>home</span></a>
                    <span>></span>
                    <span>회원탈퇴</span>
                </p>
                <p>회원탈퇴</p>
            </div>

            <jsp:include page="/WEB-INF/views/include/aside.jsp"/>

            <form action="/mypage/inactive" method="POST" class="withdrawal-wrapper">
                <div class="content">
                    <p class="table_title">
                        탈퇴 진행
                    </p>

                        <table>
                            <tr>
                                <td>
                                    <p>비밀번호 입력 및 탈퇴 처리 여부에 동의해주십시오.</p>
                                </td>
                            </tr>
                            <tr>
                                <td>
                                    <div class="password-box">
                                        <span>PASSWORD</span>
                                        <input type="password" id="pwd" name="pwd" maxlength="20" placeholder="비밀번호를 입력해주세요." oninput="checkPwdLength()" required>
                                    </div>
                                    <p id="pwd-length-error-msg"></p>
                                </td>
                            </tr>
                            <tr>
                                <td>
                                    <div class="withdrawal-notice">
                                        <p>탈퇴 안내사항</p>
                                        <p>
                                            - 동일한 본인 이메일으로 30일 이후에 재가입 가능함.<br>
                                            - 회원 탈퇴 즉시 아이디는 복구 및 재사용 불가하며, 모든 회원정보는 30일간 보관됨.<br>
                                            - 회원탈퇴 후 30일 이내 탈퇴 취소 요청 시 탈퇴 취소 가능함.
                                        </p>
                                    </div>
                                </td>
                            </tr>
                            <tr>
                                <td>
                                    <label>
                                        <input type="checkbox" id="agree" class="agree" name="agree" onchange="checkAgreeWithdrawal()">
                                        <span>유의사항을 모두 확인하였으며, 이에 동의함.</span>
                                    </label>
                                </td>
                            </tr>
                        </table>
                        <div class="button-items">
                            <button onclick="location.href='/'">취소</button>
                            <input type="submit" value="탈퇴" id="withdrawalButton" disabled>
                        </div>
                </div>
            </form>
        </div>
    </section>
    <jsp:include page="/WEB-INF/views/include/footer.jsp"/>
    <jsp:include page="/WEB-INF/views/include/quick.jsp"/>
</body>

<script src="/js/jquery-3.6.4.min.js"></script>
<script src="/js/nav.js"></script>
<script src="/js/aside.js"></script>

<script>
    window.onload = function() {
        const errorMsg = "${errorMsg}";
        if (errorMsg) {
            alert(errorMsg);
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

    function checkAgreeWithdrawal() {
        let checkBox = document.getElementById("agree");
        let withdrawalButton = document.getElementById("withdrawalButton");

        if (checkBox.checked === true) {
            withdrawalButton.disabled = false;
        } else {
            withdrawalButton.disabled = true;
        }
    }
</script>

<script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>

</html>