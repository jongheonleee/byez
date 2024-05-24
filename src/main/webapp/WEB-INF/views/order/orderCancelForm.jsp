<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"  pageEncoding="UTF-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html lang="ko">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>BYEZ</title>
    <link rel="stylesheet" href="/css/nav.css">
    <link rel="stylesheet" href="/css/ordEtcReq.css">
    <link rel="stylesheet" href="/css/footer.css?after?after">
    <link rel="stylesheet" href="/css/quick.css">
    <script src="https://kit.fontawesome.com/f0e73cfa04.js" crossorigin="anonymous"></script>
    <link rel="preconnect" href="https://fonts.googleapis.com">
    <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
    <link href="https://fonts.googleapis.com/css2?family=Noto+Sans+KR:wght@100..900&display=swap" rel="stylesheet">
</head>
<body>
<jsp:include page="/WEB-INF/views/include/nav.jsp"/>
<section>
    <form action="<c:url value="/cancelOrder"/>" method="post">

        <div class="wrapper">
            <div class="title">
                <p>
                    <a href="main.html"><span>home</span></a>
                    <span>></span>
                    <a href="orderDetail.html"><span>주문내역</span></a>
                </p>
                <p>취소 신청</p>
            </div>
            <jsp:include page="/WEB-INF/views/include/aside.jsp"/>
            <div class="content">
                <p class="table_title">주문 상품 정보
                </p>
                <table class="ordProduct">
                    <tr>
                        <th scope="col">주문일자 [주문번호]</th>
                        <th scope="col">상품정보</th>
                        <th scope="col">수량</th>
                        <th scope="col">상품구매금액</th>
                        <th scope="col">주문상태</th>
                    </tr>
                    <tr>
                        <c:forEach var="orderDetailDto" items="${cancelList}">
                        <td class="orderNum">
                            <p>${orderDetailDto.ord_date}</p>
                            <p>${orderDetailDto.ord_num}</p>
                        </td>
                        <td class="ordProductTitle">
                            <p> ${orderDetailDto.item_name} </p>
                            <p id ="originalOption">옵션: ${orderDetailDto.opt1}/${orderDetailDto.opt2}</p>
                        </td>
                        <td>${orderDetailDto.item_qty}</td>
                        <td>${orderDetailDto.item_price}</td>
                        <td>${orderDetailDto.ord_state}</td>
                    </tr>
                    </c:forEach>
                </table>

                <p class="table_title">취소사유
                </p>
                <table class="reason">
                    <tr>
                        <td scope="col" class="reasonChoice">사유선택</td>
                        <td scope="col">
                            <select name="reason_code" id="reason">
                                <option  value="" selected="selected" >선택하세요</option>
                                <option  value="CNS1" >고객변심</option>
                                <option  value="CNS2" >서비스불만족</option>
                                <option  value="SPL2" >배송지연</option>
                                <option  value="ETC" >기타</option>
                            </select>
                        </td>
                    </tr>
                    <tr>
                        <td>상세사유</td>
                        <td>
                            <textarea name="reason_detail" rows="4" cols="50">${OrdEtcReqDto.reason_detail}</textarea>
                        </td>
                    </tr>
                </table>


                <div id="buttons">
                    <button id="cancelBtn">취소 신청</button>
                    <button type="button" class="back" onClick="goBack()">이전 페이지</button>
                </div>
            </div>
        </div>
        <input type="hidden" name="ord_num" value="${ord_num}">
        <input type="hidden" name="type_code" value="C">
        <input type="hidden" name="state_code" value="CNL1">
        <input type="hidden" name="ord_state" value="주문취소">
    </form>
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
<script>

    //수거지변경이 선택되면 새로운 주소를 입력할 수 있는 테이블을 보여준다.
    document.getElementById("cancelBtn").onclick = function () {
        let reasonCode = document.getElementById("reason").value;
        if(reasonCode === ""){
            alert("취소사유를 선택해주세요")
            return false;
        }
        let cancelConfirm = confirm("정말 취소하시겠습니까?")
        if (cancelConfirm) {
            alert("주문 취소되었습니다.");
            return true;
        }
        return false;
    }

    //이전페이지 클릭
    function goBack() {
        window.location.href = '/order/list'
    }
</script>
</body>
</html>
