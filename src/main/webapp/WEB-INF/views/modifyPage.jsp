<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>비밀번호 변경 페이지</title>
</head>
<body>

<form action="/find/modify" method="GET">
    아이디(id): <input type="text" value="${id}" id="id2" name="id" readonly>
    변경할 비밀번호: <input type="password" id="pwd1" name="pwd" required>
    비밀번호 재확인: <input type="password" id="pwd2" name="pwd" oninput="checkPwdMatch();" required>
    <input type="submit" value="변경">
</form>

${incorrectPwdMsg}

<div id="error-msg"></div>

</body>

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
