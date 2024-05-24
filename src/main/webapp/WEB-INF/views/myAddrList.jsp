<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="ko">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>BYEZ</title>
    <link rel="stylesheet" href="css/nav.css">
    <link rel="stylesheet" href="css/myAddrList.css">
    <link rel="stylesheet" href="/css/footer.css?after?after">
    <link rel="stylesheet" href="/css/aside.css?after">
    <link rel="stylesheet" href="css/quick.css">
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
                <a href="myAddrList"><span>배송 주소록 관리</span></a>
            </p>
            <p>배송 주소록 관리</p>
        </div>
        <jsp:include page="/WEB-INF/views/include/aside.jsp"/>
        <div class="content">
            <p class="table_title">
                <span>(총 배송지 수 : <span>${addresses.size()}</span>)</span>
            </p>
            <table>
                <thead>
                <tr>
                    <th>배송지명</th>
                    <th>수령인</th>
                    <th>일반전화</th>
                    <th>휴대전화</th>
                    <th>주소</th>
                    <th>수정</th>
                    <th>삭제</th>
                </tr>
                </thead>
                <tbody>
                <c:forEach items="${addresses}" var="address">
                    <tr>
                        <td>${address.nick}</td>
                        <td>${address.recipient}</td>
                        <td>
                            <c:choose>
                                <c:when test="${empty address.telNum}">
                                    -
                                </c:when>
                                <c:otherwise>
                                    ${address.telNum}
                                </c:otherwise>
                            </c:choose>
                        </td>
                        <td>${address.mobileNum}</td>
                        <td>(${address.zpcd})${address.mainAddr} ${address.detailAddr}</td>
                        <td><a href="#" class="edit_btn" onclick="goAddrEditForm(${address.seq})">수정</a></td>
                        <td><a href="#" class="delete_btn" onclick="deleteAddress(${address.seq})">삭제</a></td>
                    </tr>
                </c:forEach>
                </tbody>
            </table>
            <div class="btn_wrapper"> <!-- 버튼을 감싸는 div -->
                <a href="addrRegisterForm" class="add_address_btn">배송지등록</a>
            </div>
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
<script src="/js/jquery-3.6.4.min.js"></script>
<script src="/js/nav.js"></script>
<script src="/js/aside.js"></script>
<script>
    function goAddrEditForm(seq) {
        window.location.href = 'addrEditForm?seq=' + seq;
    }


    function deleteAddress(seq) {
        var confirmDelete = confirm("정말로 삭제하시겠습니까?");
        if (confirmDelete) {
            window.location.href = 'deleteAddress?seq=' + seq;
        }
    }
</script>
</body>
</html>