// 우편번호 검색 API
function findZpcd_DaumPostcode() {
    new daum.Postcode({
        oncomplete: function (data) {
            // 팝업에서 검색결과 항목을 클릭했을때 실행할 코드를 작성하는 부분.

            // 각 주소의 노출 규칙에 따라 주소를 조합한다.
            // 내려오는 변수가 값이 없는 경우엔 공백('')값을 가지므로, 이를 참고하여 분기 한다.
            var addr = ''; // 주소 변수
            var extraAddr = ''; // 참고항목 변수

            //사용자가 선택한 주소 타입에 따라 해당 주소 값을 가져온다.
            if (data.userSelectedType === 'R') { // 사용자가 도로명 주소를 선택했을 경우
                addr = data.roadAddress;
            } else { // 사용자가 지번 주소를 선택했을 경우(J)
                addr = data.jibunAddress;
            }

            // 사용자가 선택한 주소가 도로명 타입일때 참고항목을 조합한다.
            if (data.userSelectedType === 'R') {
                // 법정동명이 있을 경우 추가한다. (법정리는 제외)
                // 법정동의 경우 마지막 문자가 "동/로/가"로 끝난다.
                if (data.bname !== '' && /[동|로|가]$/g.test(data.bname)) {
                    extraAddr += data.bname;
                }
                // 건물명이 있고, 공동주택일 경우 추가한다.
                if (data.buildingName !== '' && data.apartment === 'Y') {
                    extraAddr += (extraAddr !== '' ? ', ' + data.buildingName : data.buildingName);
                }
                // 표시할 참고항목이 있을 경우, 괄호까지 추가한 최종 문자열을 만든다.
                if (extraAddr !== '') {
                    extraAddr = ' (' + extraAddr + ')';
                }
                // 조합된 참고항목을 해당 필드에 넣는다.
                // document.getElementById("sample6_extraAddress").value = extraAddr;

            } else {
                document.getElementById("sample6_extraAddress").value = '';
            }

            // 우편번호와 주소 정보를 해당 필드에 넣는다.
            document.getElementById('delivery_form_zpcd').value = data.zonecode;
            document.getElementById("delivery_form_main_addr").value = addr;

            // 전송용 태그에 넣는다.
            document.querySelector('input[name=zpcd]').value = data.zonecode;
            document.querySelector('input[name=main_addr]').value = addr;

            // 커서를 상세주소 필드로 이동한다.
            document.getElementById("delivery_form_detail_addr").focus();
        }
    }).open();
}

//
// var rcpr = $('#delivery_view_rcpr');
// var mobile = $('#delivery_view_mobile');
// var addr = $('#delivery_view_addr');

function changeDeliveryView(num) {

    let rcpr = $('#dlvInfo_rcpr' + num).val();
    let mobile = $('#dlvInfo_rcpr_mobile' + num).val();
    let zpcd = $('#dlvInfo_zpcd' + num).val();
    let main_addr = $('#dlvInfo_main_addr' + num).val();
    let detail_addr = $('#dlvInfo_detail_addr' + num).val();
    let addr = '(' + zpcd + ') ' + main_addr + ' ' + detail_addr;

    $('#delivery_view_rcpr').html(rcpr);
    $('#delivery_view_mobile').html(mobile);
    $('#delivery_view_addr').html(addr);

    // 직접 입력 창에 넣어주기
    // $('#delivery_form_rcpr').val(rcpr);
    // $('#delivery_form_zpcd').val(zpcd);
    // $('#delivery_form_main_addr').val(main_addr);
    // $('#delivery_form_detail_addr').val(detail_addr);
    // $('#delivery_form_tel_num').val(mobile);
    // $('#delivery_form_mobile_num').val(mobile);
    $('input[name=rcpr]').val(rcpr);
    $('input[name=rcpr_mobile]').val(mobile);
    $('input[name=zpcd]').val(zpcd);
    $('input[name=main_addr]').val(main_addr);
    $('input[name=detail_addr]').val(detail_addr);

}

// 주소검색 버튼에 주소 API 클릭 이벤트
$('#searchAddressBtn').on('click', findZpcd_DaumPostcode);

// 배송메시지 직접 입력창 호출 함수
function showEtc(value) {
    if (value !== 'etc') {
        $('#delivery_msg').hide().val(value);
        $('input[name=msg]').val(value);
        return;
    }
    $('#delivery_msg').show();
}


// 전송용 태그 - 배송 (배송지 직접 입력)
function changeDeliveryMsg(value) {
    $('input[name=msg]').val(value);
}

function changeDeliveryRcpr(value) {
    $('input[name=rcpr]').val(value);
}

function changeDeliveryDetailAddr(value) {
    $('input[name=detail_addr]').val(value);
}

function changeDeliveryMobile(value) {
    $('input[name=rcpr_mobile]').val(value);
}

//End 전송용 태그 - 배송 (배송지 직접 입력)


$(function () {
    // 화면 로딩 후 배송지 첫번째 선택
    changeDeliveryView(0);
    $('#delivery_choice_0').prop('checked', true);
});

// 전송용 태그 - 주문 갱신
function changeOrderInfo(){
    $('input[name=ord_num]').val()
    $('input[name=total_item_qty]').val()
    $('input[name=total_price]').val()
    $('input[name=total_dlv_price]').val()
    $('input[name=total_disc_price]').val()
    $('input[name=total_pay_price]').val()
    $('input[name=ord_state]').val()
}

// 총 주문상품 수량 계산
function calcTotalItemQty(){
    let itemQtyList = $('input[name=item_qty].orderDetail_info');
    let sum = 0;
    for(let itemQty of itemQtyList){
        sum += Number(itemQty.value);
    }
    return sum;
}


// 총 주문상품 금액 계산
function calcTotalPrice(){
    let itemPriceList = $('input[name=item_price].orderDetail_info');
    let sum = 0;
    for(let itemPrice of itemPriceList){
        sum += Number(itemPrice.value);
    }
    return sum;
}

// 최종 결제금액 계산
function calcTotalPayPrice(){
    let discountPrice = $('#discountPrice').val();
    let result = calcTotalPayPrice() - discountPrice;
    return result;
}

/*
    toss api amount에 데이터 삽입 할 것
    전송용 태그

    주문
        주문번호 :      orderNumGenerator
        총 상품수량 :    calcTotalItemQty
        총 주문금액 :    calcTotalPrice
        총 배송비  : 0원으로 고정 - 총 배송비 계산
        총 할인금액 : 제법 - 총 할인금액 계산
        총 결제금액 : 제법 - 총 결제금액 계산
        주문상태 : ?

    결제
        결제번호 : orderNumGenerator
        결제금액 : 주문의 총 결제금액 결과
        결제수단 : 추가 필요

    배송
        배송번호 : orderNumGenerator
        수령인, 휴대전화, 우편번호, 주소 : changeDeliveryView
        배송메시지 : showEtc
 */

document.getElementById('getCouponList').addEventListener('click', function(event) {
    event.preventDefault();

    openCouponModal();
});

document.getElementsByClassName('xBtn')[0].addEventListener('click', function(event) {
    event.preventDefault()

    closeCouponModal();
});

document.getElementById('couponModalCancel').addEventListener('click', function(event) {
    event.preventDefault()

    cancleCoupon();
});

document.getElementById("couponModalSelect").addEventListener("click", function() {

    applyCoupon();
});

// 모달창 띄우는 함수
function openCouponModal() {
    document.getElementsByClassName('couponModalShadow')[0].style.display = 'block';
}

// 모달창 닫는 함수
function closeCouponModal() {
    document.getElementsByClassName('couponModalShadow')[0].style.display = 'none';
}

// 쿠폰 적용 전 변수들
var previousDiscountAmount = document.getElementById('payment_view_couponPrice').innerText;
var previousTotalPaymentAmount = document.getElementById('payment_view_payPrice').innerText;

// 쿠폰 적용 전 상태로 돌리는 함수
function cancleCoupon() {

    document.getElementById('payment_view_couponPrice').textContent = previousDiscountAmount;
    document.getElementById('payment_view_discountPrice').textContent = previousDiscountAmount;
    document.getElementById('payment_view_payPrice').textContent = previousTotalPaymentAmount;
    // 결제 위젯 결제금액 업데이트
    paymentMethodWidget.updateAmount(previousTotalPaymentAmount);


    closeCouponModal();
}
// 선택된 쿠폰 정보를 저장할 변수들
var selectedCouponName = "";
var selectedMinPayPrice = "";
var selectedMaxDiscPrice = "";
var selectedPrmo = "";
var selectedDiscType = "";
var selectedSeq = "";

// 라디오 버튼 클릭 시 호출되는 함수
function saveSelectedCoupon(couponName, minPayPrice, maxDiscPrice, prmo, discType, seq) {

    // 선택된 쿠폰 정보를 변수에 저장합니다.
    selectedCouponName = couponName;
    selectedMinPayPrice = minPayPrice;
    selectedMaxDiscPrice = maxDiscPrice;
    selectedPrmo = prmo;
    selectedDiscType = discType;
    selectedSeq = seq;
}

// 주문, 쿠폰정보로 최종 결제금액 구하는 함수
function applyCoupon() {

    // payment_view_totalPrice 변수를 JavaScript로 가져오기
    // var payment_view_totalPrice = parseFloat(${orderDto.payment_view_totalPrice}); // 총 주문금액을 가져옴
    var payment_view_totalPrice = parseFloat($('#payment_view_totalPrice').text()); // 총 주문금액을 가져옴

    var promotion = 0;

    if (selectedDiscType === "PER") {
        promotion = (selectedPrmo / 100) * payment_view_totalPrice;
    } else {
        promotion = selectedPrmo;
    }

    if (selectedPrmo > selectedMaxDiscPrice) {
        promotion = selectedMaxDiscPrice;
    }

    // 총 결제금액을 계산합니다.
    var payment_view_payPrice = payment_view_totalPrice - promotion;


    // 결과를 표시합니다.
    document.getElementById('payment_view_couponPrice').textContent = promotion;
    document.getElementById('payment_view_discountPrice').textContent = promotion;
    document.getElementById('payment_view_payPrice').textContent = payment_view_payPrice;

    // 총 할인금액
    $('input[name=total_disc_price].order_info').val(promotion);

    // 결과를 전송용 태그 및 최종 결제 금액에 추가
    $('input[name=total_pay_price].order_info').val(payment_view_payPrice);
    $('input[name=price].pay_info').val(payment_view_payPrice);

    // 결제 위젯 결제금액 업데이트
    paymentMethodWidget.updateAmount(payment_view_payPrice);

    // 유효성 검사를 위해 필요할 수 있음
    // $('#name').val(selectedCouponName);
    // $('#minPayPrice').val(selectedMinPayPrice);
    // $('#maxDiscPrice').val(selectedMaxDiscPrice);
    // $('#prmo').val(selectedPrmo);
    // $('#discType').val(selectedDiscType);
    // $('#seq').val(selectedSeq);

    // 팝업을 닫습니다.
    closeCouponModal();
}