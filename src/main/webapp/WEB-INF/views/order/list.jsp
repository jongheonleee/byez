
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>

<html>
<head>
    <title>주문 내역</title>
    <h2>주문 내역</h2>
    <script src="https://code.jquery.com/jquery-1.11.3.js"></script>
</head>
<body>

<table border = 1>
    <thead>
    <h3>주문상품정보</h3>
    <tr>
        <th>주문일자</th>
        <th>주문번호</th>
        <th>상품명</th>
        <th>수량</th>
        <th>주문금액</th>
        <th>주문상태</th>
    </tr>
    </thead>

<%--    <c:if test="${empty message}">--%>
    <tbody>
    <c:forEach var="orderDetailDto" items="${limitList}">
        <tr>
            <td>${orderDetailDto.ord_date}
                <input type="hidden" name="ord_date" value="${orderDetailDto.ord_date}">
            </td>
            <td>${orderDetailDto.ord_num}
                <form action = "/order/cancel" method="post">
                    <input type="hidden" name="ord_num" value="${orderDetailDto.ord_num}">
                <c:if test="${orderDetailDto.ord_state == '주문완료'  }">
                <input type="submit" class="cancel_button" value="취소">
                </c:if>
                </form>
                <form action = "/refund" method="post">
                    <input type="hidden" name="ord_num" value="${orderDetailDto.ord_num}">
                    <c:if test="${orderDetailDto.ord_state == '배송완료' || '배송중'|| '교환완료'  }">
                        <input type="submit" class="refund_button" value="반품">
                    </c:if>
                </form>
                <form action = "/exchange" method="post">
                    <input type="hidden" name="seq" value="${orderDetailDto.seq}">
                    <input type="hidden" name="ord_num" value="${orderDetailDto.ord_num}">
                    <input type="hidden" name="item_num" value="${orderDetailDto.item_num}">
                    <input type="hidden" name="opt1" value="${orderDetailDto.opt1}">
                    <input type="hidden" name="opt2" value="${orderDetailDto.opt2}">

                    <c:if test="${orderDetailDto.ord_state == '배송완료' || '배송중'|| '교환완료'  }">
                        <input type="submit" class="exchange_button" value="교환">
                    </c:if>
                </form>
            </td>
            <td>${orderDetailDto.item_name} - 옵션 : ${orderDetailDto.opt1}/${orderDetailDto.opt2}</td>
            <td>${orderDetailDto.item_qty}</td>
<%--            <td>${OrdDetailDto.item_qty * OrdDetailDto.price}</td>--%>
            <td>${orderDetailDto.item_price}</td>
            <td>${orderDetailDto.ord_state}
                <form action = "/confirmPurchase" method = "post">
<%--           hidden타입의 주문상태를 담아둔다--%>
                    <input type="hidden" name="ord_num" value="${orderDetailDto.ord_num}">
                    <c:if test="${orderDetailDto.ord_state == '배송완료' || '교환완료'  }">
                        <input type="submit" id="confirm_button" value="구매확정">
                        <input type = "hidden" name="ord_state" value="구매확정">
                        <input type = "hidden" name="state_code" value="CPS">
                    </c:if>
                </form>
            </td>
        </tr>
    </c:forEach>
    </tbody>
</table>

<br>
<c:if test="${ph.showPrev}">
    <a href = list?curPage=${ph.naviStart-1}><<</a> &nbsp;
    <a href = list?curPage=${ph.curPage-1}><</a>
</c:if>

<c:forEach var="ph" begin="${ph.naviStart}" end="${ph.naviEnd}" varStatus="status">
    <a id = "${status.index}" href="list?curPage=${status.index}" style="font-size: 20px">${status.index}</a>
</c:forEach>

<c:if test="${ph.showNext}">
    <a href = /list?curPage=${ph.curPage+1}>></a> &nbsp;
    <a href = /list?curPage=${ph.naviEnd+1}>>></a>
</c:if>

<c:if test="${not empty message}">
    <p>${message}</p>
</c:if>

<script>
    $("#${ph.curPage}").css("color", "#f141a2")
    $("#${ph.curPage}").css("font-weight", "bold")
    $("#${ph.curPage}").css("font-size", "25px")
    $("#${ph.curPage}").css("text-align", "center")

    document.getElementById("confirm_button").onclick = function () {
        let confirmPurchase = confirm("구매확정 후에는 교환,반품이 불가합니다")
        if (confirmPurchase) {
            alert("구매 확정되었습니다.");
        }else return false;
    }
</script>
</body>
</html>
