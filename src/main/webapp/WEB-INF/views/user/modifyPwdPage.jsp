<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" language="java" %>
<html>

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>BYEZ | 비밀번호 변경</title>
    <link rel="stylesheet" href="/css/modifyPwdPage.css?after?after?after?after?after">
    <script src="https://kit.fontawesome.com/f0e73cfa04.js" crossorigin="anonymous"></script>
    <link rel="preconnect" href="https://fonts.googleapis.com">
    <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
    <link href="https://fonts.googleapis.com/css2?family=Noto+Sans+KR:wght@100..900&display=swap" rel="stylesheet">
    <link rel="icon" href="/img/favicon-32x32_2.png">
</head>

<body>
    <section>
        <div class="wrapper">
            <form action="/find/modify" method="GET">
                <div class="input-new-pwd">
                    <div class="title">
                        <a href="/">
                            <img src="/img/logo1.png" alt="메인로고" class="main-logo">
                        </a>
                    </div>
                    <table>
                        <tr>
                            <td>
                                <span>아이디</span>
                            </td>
                            <td>
                                <input type="text" value="${id}" id="id2" name="id" readonly>
                            </td>
                        </tr>
                    </table>
                    <table>
                        <tr>
                            <td>
                                <span>변경할 비밀번호</span>
                            </td>
                            <td>
                                <input type="password" id="pwd1" name="pwd" maxlength="20" required>
                            </td>
                        </tr>
                    </table>
                    <table>
                        <tr>
                            <td>
                                <span>비밀번호 재확인</span>
                            </td>
                            <td>
                                <input type="password" id="pwd2" name="pwd" maxlength="20" oninput="checkPwdMatch();" required>
                            </td>
                        </tr>
                    </table>
                    <div class="error-msg">
                        <p>${incorrectPwdMsg}</p>
                    </div>
                    <div class="send-button">
                        <button onclick="location.href='/'">취소</button>
                        <input type="submit" value="비밀번호 변경">
                    </div>
                </div>
            </form>
        </div>
    </section>
</body>

<script src="/js/jquery-3.6.4.min.js"></script>

<script>
    function checkPwdMatch() {
        let pwd1 = document.getElementById('pwd1').value;
        let pwd2 = document.getElementById('pwd2').value;
        let errorMsg = document.getElementById('error-msg');

        if (pwd1 !== pwd2) {
            errorMsg.innerHTML = "비밀번호가 일치하지 않습니다."
        } else {
            errorMsg.innerHTML = "";
        }
    }
</script>

</html>
