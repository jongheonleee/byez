<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html lang="ko">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>BYEZ</title>
    <link rel="stylesheet" href="css/nav.css">
    <link rel="stylesheet" href="css/addrEditForm.css?after">
    <link rel="stylesheet" href="/css/footer.css">
    <link rel="stylesheet" href="css/quick.css">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.6.0/css/all.min.css" integrity="sha512-Kc323vGBEqzTmouAECnVceyQqyqdsSiqLQISBL29aUW4U/M7pSPA/gEUZQqv1cwx4OnYxTxve5UMg5GT6L4JJg==" crossorigin="anonymous" referrerpolicy="no-referrer" />
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
                <span>배송 주소록 관리</span>
            </p>
            <p>배송 주소록 관리</p>
        </div>
        <jsp:include page="/WEB-INF/views/include/aside.jsp"/>
        <div class="content">
            <p class="table_title">
                <span>&nbsp;</span>
            </p>
            <form action="editAddress" method="post" onsubmit="return validateForm()">
                <input type="hidden" id="seq" name="seq" value="${address.seq}">
                <table class="editTable">
                    <tr>
                        <th scope="row">*배송지명</th>
                        <td>
                            <input type="text" id="nick" name="nick" class="addrNameInput" value="${address.nick}">
                        </td>
                    </tr>
                    <tr>
                        <th scope="row">*성명</th>
                        <td>
                            <input type="text" id="recipient" name="recipient" class="userNameInput" value="${address.recipient}">
                        </td>
                    </tr>
                    <tr>
                        <th scope="row">*주소</th>
                        <td>
                            <input type="text" id="sample6_postcode" name="zpcd" class="zpcdInput" value="${address.zpcd}" readonly>
                            <a href="#" class="addr_search_btn" onclick="sample6_execDaumPostcode()">주소찾기</a><br>
                            <input type="text" id="sample6_address" name="mainAddr" class="mainAddrInput" value="${address.mainAddr}" readonly><br>
                            <input type="text" id="sample6_detailAddress" name="detailAddr" class="detailAddrInput" value="${address.detailAddr}">
                            <input type="text" id="sample6_extraAddress" style="display: none;"> <!-- 숨김 처리 -->
                        </td>
                    </tr>
                    <tr>
                        <th scope="row">일반전화</th>
                        <td>
                            <input type="text" id="telNum" name="telNum" class="telNumInput" value="${address.telNum}">
                        </td>
                    </tr>
                    <tr>
                        <th scope="row">*휴대전화</th>
                        <td>
                            <input type="text" id="mobileNum" name="mobileNum" class="mobileNumInput" value="${address.mobileNum}">
                        </td>
                    </tr>
                </table>
                <input type="submit" value="등록" class="edit_address_btn">
                <a href="myAddrList" class="cancle_btn">취소</a>
            </form>
        </div>
    </div>

</section>
<jsp:include page="/WEB-INF/views/include/footer.jsp"/>
<jsp:include page="/WEB-INF/views/include/quick.jsp"/>
<script src="/js/jquery-3.6.4.min.js"></script>
<script src="/js/nav.js"></script>
<script src="//t1.daumcdn.net/mapjsapi/bundle/postcode/prod/postcode.v2.js"></script>
<script>

    <c:if test="${not empty error}">
    alert("${error}");
    </c:if>

    function validateForm() {
        var nick = document.getElementById("nick").value;
        var recipient = document.getElementById("recipient").value;
        var zpcd = document.getElementById("sample6_postcode").value;
        var mainAddr = document.getElementById("sample6_address").value;
        var detailAddr = document.getElementById("sample6_detailAddress").value;
        var mobileNum = document.getElementById("mobileNum").value;
        var telNum = document.getElementById("telNum").value;

        // 배송지명이 비어 있는지 확인
        if (nick.trim() === "") {
            alert("배송지명을 입력하세요.");
            return false;
        }

        // 배송지명의 길이 확인
        if (nick.trim().length > 50) {
            alert("배송지명은 최대 50자까지 입력 가능합니다.");
            return false;
        }

        // 성명 필드가 최소 2글자 이상의 문자열인지 확인
        if (recipient.trim().length < 2) {
            alert("성명을 최소 2글자 이상 입력하세요.");
            return false;
        }

        // 성명의 길이 확인
        if (recipient.trim().length > 10) {
            alert("성명은 최대 10자까지 입력 가능합니다.");
            return false;
        }

        // 우편번호가 비어 있는지 확인
        if (zpcd.trim() === "" || mainAddr.trim() === "") {
            alert("주소 찾기 버튼을 눌러 주소를 입력하세요.");
            return false;
        }

        // 우편번호가 5 또는 6자리인지 확인
        var zpcdPattern = /^\d{5,6}$/;
        if (!zpcdPattern.test(zpcd.trim())) {
            alert("우편번호는 5자리 또는 6자리 숫자여야 합니다.");
            return false;
        }

        // 상세주소가 비어 있는지 확인
        if (detailAddr.trim() === "") {
            alert("상세주소를 입력하세요.");
            return false;
        }

        // 휴대전화가 비어 있는지 확인
        if (mobileNum.trim() === "") {
            alert("휴대전화를 입력하세요.");
            return false;
        }

        // 휴대전화 번호의 형식을 검증
        var mobilePattern = /^01(?:0|1|[6-9])\d{3,4}\d{4}$/;
        if (!mobilePattern.test(mobileNum.trim())) {
            alert("올바른 휴대전화 번호 형식이 아닙니다. (숫자만 입력)");
            return false;
        }

        // 전화번호가 비어있는지 확인
        if (telNum.trim() === "") {
            return true; // 값이 비어있으면 검증을 수행하지 않음
        }

        // 전화번호 패턴을 정의
        var telPattern = /^(|\d{2,3}\d{3,4}\d{4})$/;

        // 전화번호 패턴과 일치하는지 확인
        if (!telPattern.test(telNum.trim())) {
            alert("올바른 전화번호 형식이 아닙니다. (숫자만 입력)");
        }

        // 모든 검증이 통과되면 true 반환하여 폼 제출
        return true;
    }

    function sample6_execDaumPostcode() {
        new daum.Postcode({
            oncomplete: function (data) {
                var addr = '';
                var extraAddr = '';

                if (data.userSelectedType === 'R') {
                    addr = data.roadAddress;
                } else {
                    addr = data.jibunAddress;
                }

                if (data.userSelectedType === 'R') {
                    if (data.bname !== '' && /[동|로|가]$/g.test(data.bname)) {
                        extraAddr += data.bname;
                    }
                    if (data.buildingName !== '' && data.apartment === 'Y') {
                        extraAddr += (extraAddr !== '' ? ', ' + data.buildingName : data.buildingName);
                    }
                    if (extraAddr !== '') {
                        extraAddr = ' (' + extraAddr + ')';
                    }
                    document.getElementById("sample6_extraAddress").value = extraAddr;
                } else {
                    document.getElementById("sample6_extraAddress").value = '';
                }

                document.getElementById('sample6_postcode').value = data.zonecode;
                document.getElementById("sample6_address").value = addr;
                document.getElementById("sample6_detailAddress").focus();
            }
        }).open();
    }
</script>
</body>
</html>