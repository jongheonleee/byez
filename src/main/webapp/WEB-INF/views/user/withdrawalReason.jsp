<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>BYEZ</title>
    <link rel="stylesheet" href="/css/nav.css">
    <link rel="stylesheet" href="/css/withdrawalReason.css">
    <link rel="stylesheet" href="/css/footer.css?after?after">
    <link rel="stylesheet" href="/css/aside.css?after">
    <link rel="stylesheet" href="/css/quick.css">
    <script src="https://kit.fontawesome.com/f0e73cfa04.js" crossorigin="anonymous"></script>
    <link rel="preconnect" href="https://fonts.googleapis.com">
    <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
    <link href="https://fonts.googleapis.com/css2?family=Noto+Sans+KR:wght@100..900&display=swap" rel="stylesheet">
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
            <div class="content">
                <p class="table_title">
                    탈퇴 사유
                </p>
                <table>
                    <tr>
                        <td>
                            <label><input type="checkbox" class="withdrawal-reason" onclick="toggleCheckbox(this)">구매할만한 상품이 없음.</label>
                        </td>
                    </tr>
                    <tr>
                        <td>
                            <label><input type="checkbox" class="withdrawal-reason" onclick="toggleCheckbox(this)">개인정보 유출이 우려됨.</label>
                        </td>
                    </tr>
                    <tr>
                        <td>
                            <label><input type="checkbox" class="withdrawal-reason" onclick="toggleCheckbox(this)">재가입 예정임.</label>
                        </td>
                    </tr>
                    <tr>
                        <td>
                            <label><input type="checkbox" class="withdrawal-reason" onclick="toggleCheckbox(this)">교환/반품/환불이 불편함.</label>
                        </td>
                    </tr>
                    <tr>
                        <td>
                            <label><input type="checkbox" class="withdrawal-reason" onclick="toggleCheckbox(this)">쇼핑 기능이 어려움.</label>
                        </td>
                    </tr>
                    <tr>
                        <td>
                            <label><input type="checkbox" class="withdrawal-reason" onclick="toggleCheckbox(this)">상품의 배송이 느림.</label>
                        </td>
                    </tr>
                    <tr>
                        <td>
                            <label><input type="checkbox" class="withdrawal-reason" onclick="toggleCheckbox(this)">교환/반품/환불이 불편함.</label>
                        </td>
                    </tr>
                </table>

                <div class="button-items">
                    <button onclick="location.href='/'" class="cancel-button">탈퇴 취소</button>
                    <button onclick="location.href='/mypage/withdrawal'" class="next-button" disabled>다음</button>
                </div>
            </div>
        </div>
    </section>
    <jsp:include page="/WEB-INF/views/include/footer.jsp"/>
    <jsp:include page="/WEB-INF/views/include/quick.jsp"/>
</body>

<script src="/js/jquery-3.6.4.min.js"></script>
<script src="/js/nav.js"></script>
<script src="/js/aside.js"></script>
<script>

    function toggleCheckbox(element) {
        const checkboxes = document.querySelectorAll('.withdrawal-reason');
        const nextButton = document.querySelector('.button-items button:nth-child(2)');
        let isChecked = false;

        checkboxes.forEach(checkbox => {
            if (checkbox.checked) {
                isChecked = true;
            }
        });

        nextButton.disabled = !isChecked;
    }
</script>

<script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>

</html>