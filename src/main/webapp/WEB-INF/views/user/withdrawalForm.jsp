<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" language="java" %>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>BYEZ</title>
    <link rel="stylesheet" href="/css/nav.css">
    <link rel="stylesheet" href="/css/withdrawalForm.css?after">
    <link rel="stylesheet" href="/css/footer.css">
    <link rel="stylesheet" href="/css/quick.css">
    <script src="https://kit.fontawesome.com/f0e73cfa04.js" crossorigin="anonymous"></script>
    <link rel="preconnect" href="https://fonts.googleapis.com">
    <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
    <link href="https://fonts.googleapis.com/css2?family=Noto+Sans+KR:wght@100..900&display=swap" rel="stylesheet">
</head>

<body>

    <%@include file="../../views/include/nav.jsp"%>

    <section>
        <div class="wrapper">
            <p>
                <a href="main.html"><span>home</span></a>
                <span>></span>
                <a href="/mypage/index"><span>mypage</span></a>
            </p>

            <div class="withdrawal-form">
                <p class="title">회원탈퇴</p>
                <p>비밀번호 입력 및 탈퇴 처리 여부에 동의해주십시오.</p>
                <form action="/mypage/inactive" method="POST">
                    <ul class="submit-pwd-agree">
                        <li class="check-pwd">
                            비밀번호 확인: <input type="password" id="pwd" name="pwd" oninput="checkPwdLength()" required>
                        </li>
                        <li class="pwd-length-error-msg">
                            <div id="pwd-length-error-msg"></div>
                            <p class="error-msg">${errorMsg}</p>
                        </li>

                        <div class="notice">
                            <p>탈퇴 안내사항</p>
                            <p>
                                - 동일한 본인 이메일으로 30일 이후에 재가입 가능함.<br>
                                - 회원 탈퇴 즉시 아이디는 복구 및 재사용 불가하며, 모든 회원정보는 30일간 보관됨.<br>
                                - 회원탈퇴 후 30일 이내 탈퇴 취소 요청 시 탈퇴 취소 가능함.
                            </p>
                        </div>

                        <li class="check-agree">
                            <div>
                                <label>
                                    <input type="checkbox" id="agree" class="agree" name="agree" onchange="checkAgreeWithdrawal()">
                                    유의사항을 모두 확인하였으며, 이에 동의함.
                                </label>
                            </div>
                        </li>
                    </ul>
                    <li class="submit-button">
                        <button><a href="/">취소</a></button>
                        <input type="submit" value="탈퇴" id="withdrawalButton" disabled>
                    </li>
                </form>
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

</html>
