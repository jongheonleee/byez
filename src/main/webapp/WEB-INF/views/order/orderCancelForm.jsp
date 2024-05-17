<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <title>Title</title>
    <h2>취소 신청</h2>
</head>
<body>
<form action="<c:url value="/cancelOrder"/>" method = "post">
<table border = 1>
    <thead>
    <h3>상품정보</h3>
    <tr>
        <th>주문일자</th>
        <th>주문번호</th>
        <th>상품명</th>
        <th>수량</th>
        <th>주문금액</th>
        <th>주문상태</th>
    </tr>
    </thead>
    <tbody>

    <c:forEach var="orderDetailDto" items="${cancelList}">
        <tr>
            <td>${orderDetailDto.ord_date}</td>
            <td>${orderDetailDto.ord_num}</td>
            <td>${orderDetailDto.item_name} - 옵션 : ${orderDetailDto.opt1}/${orderDetailDto.opt2}</td>
            <td>${orderDetailDto.item_qty}</td>
            <td>${orderDetailDto.item_price}</td>
            <td>${orderDetailDto.ord_state}</td>
        </tr>
    </c:forEach>
    </tbody>
</table>


<h3>취소사유</h3>
<%--사유선택 <form action="submitReason" method="post">--%>
    <select name="reason_code" id="reason">
        <option  value="" selected="selected" >선택하세요</option>
        <option  value="CNS1" >고객변심</option>
        <option  value="CNS2" >서비스불만족</option>
        <option  value="SPL2" >배송지연</option>
        <option  value="ETC" >기타</option>
    </select>

    상세 사유: <textarea name="reason_detail" rows="4" cols="50">${OrdEtcReqDto.reason_detail}</textarea>

    <input type="hidden" name="ord_num" value="${ord_num}">
    <input type="hidden" name="type_code" value="C">
    <input type="hidden" name="state_code" value="CNL1">
    <input type="hidden" name="ord_state" value="주문취소">
    <input type = "submit" id = "cancelBtn" value = "취소신청" >
</form>
<script>
    document.getElementById("cancelBtn").onclick = function () {
        let reasonCode = document.getElementById("reason").value;
        if(reasonCode === ""){
            alert("취소사유를 선택해주세요")
            return false;
        }
        let cancelConfirm = confirm("정말 취소하시겠습니까?")
        if (cancelConfirm) {
            alert("주문 취소되었습니다.");
        }return false;
    }
</script>
</body>
</html>
