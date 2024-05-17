<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <script src="https://code.jquery.com/jquery-1.11.3.js"></script>
    <title>반품 신청</title>
    <h2>반품 신청</h2>
    <script>

    //수거지변경이 선택되면 새로운 주소를 입력할 수 있는 테이블을 보여준다.
        function toggleAddressFields() {
            const changeAddress = document.querySelector('input[name="chg_chk"]:checked').value === 'Y';
            document.getElementById('currentAddress').style.display = changeAddress ? 'none' : 'table-row-group';
            document.getElementById('newAddress').style.display = changeAddress ? 'table-row-group' : 'none';
        }

        function updateHiddenFields() {
            document.querySelector('input[name="rcpr"]').value = document.querySelector('input[name="new_rcpr"]').value;
            document.querySelector('input[name="zpcd"]').value = document.querySelector('input[name="new_zpcd"]').value;
            document.querySelector('input[name="main_addr"]').value = document.querySelector('input[name="new_main_addr"]').value;
            document.querySelector('input[name="detail_addr"]').value = document.querySelector('input[name="new_detail_addr"]').value;
            document.querySelector('input[name="rcpr_mobile"]').value = document.querySelector('input[name="new_rcpr_mobile"]').value;
        }

        /*
        직접발송 선택시
        1. 수거지정보테이블과 수거지선택 옵션을 숨긴다.
        2. 반품신청폼으로 넘어올때 가져온 배송지정보를 "" 빈문자열로 변경하여 저장한다.
        정수형인 휴대폰번호는 null가능하게 수정함
        */
        function handleShippingOptionChange() {
            const isSelfShipping = document.querySelector('input[name="req_chk"]:checked').value === 'N';
            const addressSection = document.querySelectorAll('.addressSection');
            addressSection.forEach(section => section.style.display = isSelfShipping ? 'none' : 'block');

            //배송지정보 빈문자열처리하는 메서드
            if (isSelfShipping) {
                clearAddressFields();
            }
        }
        function clearAddressFields() {
            document.querySelector('input[name="appcn_name"]').value = "";
            document.querySelector('input[name="appcn_mobile"]').value = "";
            document.querySelector('input[name="rcpr"]').value = "";
            document.querySelector('input[name="zpcd"]').value = "";
            document.querySelector('input[name="main_addr"]').value = "";
            document.querySelector('input[name="detail_addr"]').value = "";
            document.querySelector('input[name="rcpr_mobile"]').value = "";
        }

        // 반품사유에 따른 배송비 업데이트
        function updateShippingCost() {
            const reasonCode = document.getElementById('reason').value;
            const shippingCostField = document.getElementById('shippingCost');

            if (reasonCode === 'CNS1' || reasonCode === 'CNS2') {
                shippingCostField.textContent = '5000원';
            } else if(reasonCode === 'SPL1' || reasonCode === 'SPL2' || reasonCode === 'SPL3') {
                shippingCostField.textContent = '0원';
            }else
                shippingCostField.textContent = '반품사유를 선택하면 반품배송비를 확인할 수 있습니다.';
        }

        //반품신청버튼 클릭
        document.addEventListener("DOMContentLoaded", function() {
            document.getElementById("refundBtn").onclick = function() {
                let form = $('form');
                let chg_chk = form.find('input[name="chg_chk"]:checked').val();
                let new_rcpr = form.find('input[name="new_rcpr"]').val().trim();
                let new_zpcd = form.find('input[name="new_zpcd"]').val().trim();
                let new_main_addr = form.find('input[name="new_main_addr"]').val().trim();
                let new_detail_addr = form.find('input[name="new_detail_addr"]').val().trim();
                let new_rcpr_mobile = form.find('input[name="new_rcpr_mobile"]').val().trim();

                //수거지 정보테이블에 빈값이 있지 않은지 유효성검사
                if(chg_chk === "Y" && (new_rcpr === ""  || new_zpcd ===""  || new_main_addr === "" || new_detail_addr === "" || new_rcpr_mobile === "") ){
                    alert("수거지정보를 모두 작성해주세요");
                    return false;
                }

                //특수문자 입력 불가 검사
                let specialCharPattern = /[!@#$%^&*(),.?":{}|<>]/;
                if (specialCharPattern.test(new_rcpr) ||
                    specialCharPattern.test(new_zpcd) ||
                    specialCharPattern.test(new_main_addr) ||
                    specialCharPattern.test(new_detail_addr) ||
                    specialCharPattern.test(new_rcpr_mobile)) {

                    alert("입력 필드에 특수문자가 포함되어 있습니다.");
                    return false;
                }

                let rcpr = document.querySelector('input[name="rcpr"]').value;
                let zpcd = document.querySelector('input[name="zpcd"]').value;
                let main_addr = document.querySelector('input[name="main_addr"]').value;
                let detail_addr = document.querySelector('input[name="detail_addr"]').value;
                let rcpr_mobile = document.querySelector('input[name="rcpr_mobile"]').value;
                //반품신청 confirm창에서 취소를 입력하면 반품신청페이지에 머물러있도록한다.

                let reasonCode = document.getElementById("reason").value;
                if(reasonCode === ""){
                    alert("반품사유를 선택해주세요")
                    return false;
                }

                //휴대폰번호는 null가능하게 수정된 상태이기 때문에 검증에서 제외
                    let refundConfirm = confirm("반품하시겠습니까?");
                    if (refundConfirm) {
                        updateHiddenFields();
                        alert("반품 신청되었습니다.");
                    } else {
                        return false;
                }
            }

            document.querySelectorAll('input[name="req_chk"]').forEach(function(element) {
                element.addEventListener('change', handleShippingOptionChange);
            });
            // reason_code 선택시 배송비 업데이트 이벤트 바인딩
            document.getElementById('reason').addEventListener('change', updateShippingCost);

            // 초기화시 배송비 설정
            updateShippingCost();
        });
    </script>
</head>
<body>
<form action="<c:url value="/refundOrder"/>" method="post">
    <h3>상품정보</h3>
    <table border="1">
        <thead>
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
        <c:forEach var="orderDetailDto" items="${refundList}">
            <tr>
                <td>${orderDetailDto.ord_date}</td>
                <td>${orderDetailDto.ord_num}</td>
                <td>${orderDetailDto.item_name} - 옵션 : ${orderDetailDto.opt1}/${orderDetailDto.opt2}
                </td>
                <td>${orderDetailDto.item_qty}</td>
                <td>${orderDetailDto.item_price}</td>
                <td>${orderDetailDto.ord_state}</td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
    <h3>반품사유</h3>
    <select name="reason_code" id="reason" >
        <option  value="" selected="selected" >선택하세요</option>
        <option value="CNS1">고객변심</option>
        <option value="CNS2">서비스불만족</option>
        <option value="SPL1">상품불량</option>
        <option value="SPL2">배송지연</option>
        <option value="SPL3">발송오류</option>
    </select>
    <br>
    상세 사유: <textarea name="reason_detail" rows="4" cols="50">${OrdEtcReqDto.reason_detail}</textarea>

    <div class="shippingCharge">
        <h3>반품배송비결제</h3>
        <span id="shippingCost"></span>
    </div>


    <h3>수거신청</h3>
    <input type="radio" name="req_chk" value="Y" checked="checked">수거신청
    <input type="radio" name="req_chk" value="N">직접발송

    <div class="addressSection">
        <h3>수거지선택</h3>
        <input type="radio" name="chg_chk" value="N" checked="checked" onclick="toggleAddressFields()">배송지정보와 동일
        <input type="radio" name="chg_chk" value="Y" onclick="toggleAddressFields()">수거지 변경

        <h3>수거지정보</h3>
        <table border="1">
            <thead>
            <tr>
                <th>수거신청인</th>
                <th>우편번호</th>
                <th>기본주소</th>
                <th>상세주소</th>
                <th>연락처</th>
            </tr>
            </thead>
            <tbody id="currentAddress">
            <tr>
                <td>${deliveryDto.rcpr}</td>
                <td>${deliveryDto.zpcd}</td>
                <td>${deliveryDto.main_addr}</td>
                <td>${deliveryDto.detail_addr}</td>
                <td>${deliveryDto.rcpr_mobile}</td>
            </tr>
            </tbody>
            <tbody id="newAddress" style="display: none;">
            <tr>
<%--    oninput 이벤트처리하면 특수문자등 들어가지 말아야 할 것이 입력되었을때 바로 확인 가능함--%>
<%--     focus 사용하면 입력완료 시 다음으로 넘어간다.--%>
                <td><input type="text" name="new_rcpr" value=""></td>
                <td><input type="text" name="new_zpcd" value=""></td>
                <td><input type="text" name="new_main_addr" value=""></td>
                <td><input type="text" name="new_detail_addr" value=""></td>
                <td><input type="text" name="new_rcpr_mobile" value=""></td>
            </tr>
            </tbody>
        </table>
    </div>

    <input type="hidden" name="appcn_name" value="${deliveryDto.rcpr}">
    <input type="hidden" name="appcn_mobile" value="${deliveryDto.rcpr_mobile}">
    <input type="hidden" name="rcpr" value="${deliveryDto.rcpr}">
    <input type="hidden" name="zpcd" value="${deliveryDto.zpcd}">
    <input type="hidden" name="main_addr" value="${deliveryDto.main_addr}">
    <input type="hidden" name="detail_addr" value="${deliveryDto.detail_addr}">
    <input type="hidden" name="rcpr_mobile" value="${deliveryDto.rcpr_mobile}">
    <input type="hidden" name="ord_num" value="${ord_num}">
    <input type="hidden" name="type_code" value="R">
    <input type="hidden" name="state_code" value="RTN1">
    <input type="hidden" name="ord_state" value="반품신청">
    <input type="submit" id="refundBtn" value = "반품신청">
</form>
</body>
</html>