<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <script src="https://code.jquery.com/jquery-1.11.3.js"></script>
    <title>교환 신청</title>

    <style>
        .dialog {
            display: none;
            position: fixed;
            left: 0;
            top: 0;
            z-index: 10;
            width: 100%;
            height: 100%;
            background: rgba(0, 0, 0, 0.4);
        }

        .dialog>.tb {
            display: flex;
            justify-content: center;
            align-items: center;
            width: 100%;
            height: 100%;
        }

        .dialog>.tb .inner {
            width: 30%;
            max-width: 100px;
            padding: 20px;
            background: #fff;
            border-radius: 16px;
        }

        .dialog .top {
            display: flex;
            align-items: center;
            border-bottom: 1px solid #ddd;
            justify-content: space-between;
            padding-bottom: 15px;
            margin-bottom: 15px;
        }

        .dialog .title {
            font-weight: bold;
            font-size: 18px; /* 글씨 크기 조정 */
        }

        .dialog .ct {
            max-height: 30vh; /* 최대 높이를 40vh로 조정 */
            height: 30vh; /* 높이를 40vh로 조정 */
            overflow-y: auto;
            border-bottom-left-radius: 10px;
            border-bottom-right-radius: 10px;
            background-color: #fff;
        }
    </style>
    <h2>교환 신청</h2>
    <script>

        // 문서가 완전히 로드된 후에 실행
        document.addEventListener("DOMContentLoaded", function() {
            // 모달창의 아이디
            const modal = document.querySelector("#modal");
            // 버튼의 아이디
            const btn = document.querySelector("#changeOptionBtn");
            // 닫기 버튼
            const close = document.querySelector(".close");
            const changeBtn = document.querySelector("#change");

            // // 각 버튼에 이벤트 리스너 추가
            // buttons.forEach(function(btn) {
            //     btn.addEventListener("click", function() {
            //         modal.style.display = "block";
            //     });
            // });

            // 모달창 열기
            btn.addEventListener("click", function() {
                modal.style.display = "block";
            });

            // 모달창 닫기
            close.addEventListener("click", function() {
                modal.style.display = "none";
            });

            //옵션변경하면서 모달창닫기
            changeBtn.addEventListener("click", function() {
                let selectedColor = document.getElementById('color').value;
                let selectedSize = document.getElementById('size').value;
                let originalColor = '${OrderDetailDto.opt1}';
                let originalSize = '${OrderDetailDto.opt2}';
                if((selectedColor === "" || selectedSize === "" ) || selectedColor === originalColor  && selectedSize === originalSize ){
                    alert("옵션을 선택해주세요");
                    let originalOption = document.getElementById('option');
                    originalOption.style.display = 'block';
                    let changedOption = document.getElementById('changedOption');
                    changedOption.style.display = "none";
                    return false;
                }
                modal.style.display = "none";
            });

            // 모달창 외부 클릭 시 닫기
            window.addEventListener("click", function(event) {
                if (event.target === modal) {
                    modal.style.display = "none";
                }
            });
        });


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
        1. 수저지정보테이블과 수거지선택 옵션을 숨긴다.
        2. 교환신청폼으로 넘어올때 가져온 배송지정보를 "" 빈문자열로 변경하여 저장한다.
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

        function changeOptionVisibility() {
            var originalOption = document.getElementById('option');
            var changedOption = document.getElementById('changedOption');
            var selectedColor = '';
            var selectedSize = '';

            selectedColor = document.getElementById('color').value;
            selectedSize = document.getElementById('size').value;
            var displayDiv = document.getElementById('options');

            document.querySelector('input[name="opt1"]').value = selectedColor;
            document.querySelector('input[name="opt2"]').value = selectedSize;

            displayDiv.innerHTML = "옵션: " + selectedColor + "/" + selectedSize;


            // 변경된 옵션을 보이게 하고, 원래 옵션을 숨깁니다.
            changedOption.style.display = 'block'; // changedOption을 보이게 함
            originalOption.style.display = 'none'; // originalOption을 숨김
        }

        // 교환사유에 따른 배송비 업데이트
        function updateShippingCost() {
            const reasonCode = document.getElementById('reason').value;
            const shippingCostField = document.getElementById('shippingCost');

            if (reasonCode === 'CNS1' || reasonCode === 'CNS2' || reasonCode === 'CNS4') {
                shippingCostField.textContent = '5000원';
            }else if(reasonCode === 'SPL1' ||  reasonCode === 'SPL3') {
                shippingCostField.textContent = '0원';
            }else
                shippingCostField.textContent = '교환사유를 선택하면 교환배송비를 확인할 수 있습니다.';
        }

        //교환신청버튼 클릭
        document.addEventListener("DOMContentLoaded", function() {
            document.getElementById("exchangeBtn").onclick = function() {
                let form = $('form');
                let chg_chk = form.find('input[name="chg_chk"]:checked').val();
                let new_rcpr = form.find('input[name="new_rcpr"]').val().trim();
                let new_zpcd = form.find('input[name="new_zpcd"]').val().trim();
                let new_main_addr = form.find('input[name="new_main_addr"]').val().trim();
                let new_detail_addr = form.find('input[name="new_detail_addr"]').val().trim();
                let new_rcpr_mobile = form.find('input[name="new_rcpr_mobile"]').val().trim();

                //수거지 정보테이블에 빈값이 있지 않은지 유효성검사
                if(chg_chk === "Y" && (new_rcpr === ""  || new_zpcd ===""  || new_main_addr === "" || new_detail_addr === "" || new_rcpr_mobile === "")  ){
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
                let selectedColor = document.getElementById('color').value;
                let selectedSize = document.getElementById('size').value;
                let rcpr = document.querySelector('input[name="rcpr"]').value;
                let zpcd = document.querySelector('input[name="zpcd"]').value;
                let main_addr = document.querySelector('input[name="main_addr"]').value;
                let detail_addr = document.querySelector('input[name="detail_addr"]').value;
                let rcpr_mobile = document.querySelector('input[name="rcpr_mobile"]').value;


                if(selectedColor === "" && selectedSize === ""){
                    alert("옵션을 변경해주세요")
                    return false;
                }

                let reasonCode = document.getElementById("reason").value;
                if(reasonCode === ""){
                    alert("교환사유를 선택해주세요")
                    return false;
                }
                //교환신청 confirm창에서 취소를 입력하면 교환신청페이지에 머물러있도록한다.
                    let refundConfirm = confirm("교환신청 하시겠습니까?");
                    if (refundConfirm) {
                        updateHiddenFields();
                        alert("교환 신청되었습니다.");
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
<form action="<c:url value="/exchangeOrder"/>" method="post">
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

            <tr>
                <td>${orderDetailDto.ord_date}</td>
                <td>${orderDetailDto.ord_num}</td>
                <td>
                    <div id = "option">
                            ${orderDetailDto.item_name} - 옵션: ${orderDetailDto.opt1}/${orderDetailDto.opt2}
                    </div>
                    <div id = "changedOption" style ="display :  none;">
                            ${orderDetailDto.item_name} - <span id="options"></span>
                    </div>
                    <input type="button" id = "changeOptionBtn" value = "옵션변경">
                </td>
                <td>${orderDetailDto.item_qty}</td>
                <td>${orderDetailDto.item_price}</td>
                <td>${orderDetailDto.ord_state}</td>
            </tr>

        </tbody>
    </table>

    <div id="modal" class="dialog" style = "display:none">
        <div class="tb">
            <div class="inner" style="max-width:800px;">
                <div class="top">
                    <div class="title">옵션변경</div>
                    <a href="#" class="close">X</a>
                </div>
                <div class="ct">
                    상품명
                    [옵션 : ${orderDetailDto.opt1}/${orderDetailDto.opt2}]
                    <br>
                    상품옵션
                    Color
                    <select name = "color" id="color">
                            <option value = "">색상</option>
                        <c:forEach var="itemOptionDto" items="${colorList}">
                            <option value = ${itemOptionDto.color}>${itemOptionDto.color}</option>
                        </c:forEach>
                    </select>
                    Size
                    <select name = "size" id="size">
                            <option value = "">사이즈</option>
                        <c:forEach var="itemOptionDto" items="${sizeList}">
                            <option value = ${itemOptionDto.size}>${itemOptionDto.size}</option>
                        </c:forEach>
                    </select>
                    <input type = button  id="change"  value = "변경하기" onclick="changeOptionVisibility()">
                </div>
            </div>
        </div>
    </div>

    <h3>교환사유</h3>
    <select name="reason_code" id="reason">
        <option  value="" selected="selected" >선택하세요</option>
        <option value="CNS1">고객변심</option>
        <option value="CNS2">서비스불만족</option>
        <option value="CNS4">배송지기재오류</option>
        <option value="SPL1">상품불량</option>
        <option value="SPL3">발송오류</option>
    </select>
    <br>
    상세 사유: <textarea name="reason_detail" rows="4" cols="50">${OrdEtcReqDto.reason_detail}</textarea>

    <div class="shippingCharge">
        <h3>교환배송비결제</h3>
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
                <td><input type="text" name="new_rcpr" value=""></td>
                <td><input type="text" name="new_zpcd" value=""></td>
                <td><input type="text" name="new_main_addr" value=""></td>
                <td><input type="text" name="new_detail_addr" value=""></td>
                <td><input type="text" name="new_rcpr_mobile" value=""></td>
            </tr>
            </tbody>
        </table>
    </div>

    <input type ="hidden" name="opt1" value = "${selectedColor}">
    <input type ="hidden" name="opt2" value = "${selectedSize}">
    <input type="hidden" name="appcn_name" value="${deliveryDto.rcpr}">
    <input type="hidden" name="appcn_mobile" value="${deliveryDto.rcpr_mobile}">
    <input type="hidden" name="rcpr" value="${deliveryDto.rcpr}">
    <input type="hidden" name="zpcd" value="${deliveryDto.zpcd}">
    <input type="hidden" name="main_addr" value="${deliveryDto.main_addr}">
    <input type="hidden" name="detail_addr" value="${deliveryDto.detail_addr}">
    <input type="hidden" name="rcpr_mobile" value="${deliveryDto.rcpr_mobile}">
    <input type="hidden" name="ord_num" value="${ord_num}">
    <input type="hidden" name="seq" value="${orderDetailDto.seq}">
    <input type="hidden" name="type_code" value="E">
    <input type="hidden" name="state_code" value="EXC1">
    <input type="hidden" name="ord_state" value="교환신청">
    <input type="submit" id="exchangeBtn" value="교환신청">
</form>
</body>
</html>