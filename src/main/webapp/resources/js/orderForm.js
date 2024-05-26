// 함수 정의

// 배송지 정보 조회
    function getDeliveryItem(num){
        // 선택한 배송지 정보 조회
        let rcpr = $('#dlvInfo_rcpr_' + num).val();
        let mobile = $('#dlvInfo_rcpr_mobile_' + num).val().replace(/(\d{2})(\d{4})(\d{4})/, "010-$2-$3");
        let zpcd = $('#dlvInfo_zpcd_' + num).val();
        let main_addr = $('#dlvInfo_main_addr_' + num).val();
        let detail_addr = $('#dlvInfo_detail_addr_' + num).val();

        // 객체로 반환
        return {rcpr: rcpr, mobile:mobile, zpcd:zpcd, main_addr:main_addr, detail_addr:detail_addr};
    }

// 선택한 배송지 출력
    function showDeliveryItem(deliveryItem){
        // 변수에 저장
        let rcpr = deliveryItem.rcpr;
        let mobile = deliveryItem.mobile;
        let zpcd = deliveryItem.zpcd;
        let main_addr = deliveryItem.main_addr;
        let detail_addr = deliveryItem.detail_addr;
        // let addr = '(' + zpcd + ') ' + main_addr + ' ' + detail_addr;

        // 선택한 배송지 출력
        $('#delivery_view_rcpr').html(rcpr);
        $('#delivery_view_mobile').html(mobile);
        $('#delivery_view_addr').html('(' + zpcd + ') ' + main_addr + ' ' + detail_addr);
    }

// 전송용 태그에 저장 - 배송지 정보
    function setDeliveryInfo(deliveryItem){
        $('input[name=rcpr].delivery_info').val(deliveryItem.rcpr);
        $('input[name=rcpr_mobile].delivery_info').val(deliveryItem.mobile);
        $('input[name=zpcd].delivery_info').val(deliveryItem.zpcd);
        $('input[name=main_addr].delivery_info').val(deliveryItem.main_addr);
        $('input[name=detail_addr].delivery_info').val(deliveryItem.detail_addr);
    }

// 배송지 선택 함수
    function selectDeliveryItem(num){
        // 선택한 배송지 정보 조회
        let deliveryItem = getDeliveryItem(num);

        // 배송지 정보 출력
        showDeliveryItem(deliveryItem);

        // 전송용 태그에 저장
        setDeliveryInfo(deliveryItem);
    }

//시작 - 배송지 직접입력 함수

// 전송용 태그에 저장 - 수령인
    function setDeliveryRcpr(value) {
        $('input[name=rcpr].delivery_info').val(value);
    }

// 전송용 태그에 저장 - 수령인 휴대전화
    function setDeliveryMobile(value) {
        $('input[name=rcpr_mobile].delivery_info').val(value);
    }

// 전송용 태그에 저장 - 우편번호
    function setDeliveryZpcd(value) {
        $('input[name=zpcd].delivery_info').val(value);
    }

// 전송용 태그에 저장 - 기본주소
    function setDeliveryMainAddr(value) {
        $('input[name=main_addr].delivery_info').val(value);
    }

// 전송용 태그에 저장 - 상세주소
    function setDeliveryDetailAddr(value) {
        $('input[name=detail_addr].delivery_info').val(value);
    }

// 전송용 태그에 저장 - 배송 메시지
    function setDeliveryMsg(value) {
        $('input[name=msg].delivery_info').val(value);
    }

//끝 - 배송지 직접입력 함수

// 배송지 선택 or 직접 입력 선택 시
// 배송지 선택으로 하면 checked 되어있는 것으로 변환
    function clickDeliveryList(){
        // 1번째 배송지 선택
        selectDeliveryItem(0);

        // 1번째 라디오버튼 체크
        $('#delivery_choice_0').prop('checked', true);
    }


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
                    $('#delivery_form_main_addr').val(extraAddr);

                    // 전송용 태그에 저장
                    setDeliveryMainAddr(extraAddr);

                } else {
                    // $('#delivery_form_main_addr').val('');
                    $('#delivery_form_main_addr').val(addr);

                    // 전송용 태그에 저장
                    setDeliveryMainAddr(addr);
                }

                // 우편번호와 주소 정보를 해당 필드에 넣는다.
                $('#delivery_form_zpcd').val(data.zonecode);

                // 전송용 태그에 저장
                setDeliveryZpcd(data.zonecode);


                // 커서를 상세주소 필드로 이동한다.
                $('#delivery_form_detail_addr').focus();
            }
        }).open();
    }

// 배송메시지 직접 입력창 호출 함수
    function showEtc(value) {
        const dlvMsg_textArea = $('#delivery_msg');
        // 직접 입력이 아니면
        if (value !== 'etc') {
            // 직접 입력 창에 메시지 넣고 창 숨기기
            dlvMsg_textArea.hide().val(value);
            // 전송용 태그에 저장
            setDeliveryMsg(value);
            return;
        }
        // 직접 입력이면 창 보이기
        dlvMsg_textArea.show();
    }

//끝 - 배송지 관련 함수


//시작 - 쿠폰 관련 함수

// 전송용 태그에 저장 - 선택한 쿠폰
    function setCouponSeq(value) {
        $('input[name=seq].coupon_info').val(value);
    }

//끝 - 쿠폰 관련 함수

//시작 - 주문, 결제 관련 함수

// 전송용 태그에 저장 - 총 할인금액
    function setTotalDiscountPrice(value){
        $('input[name=total_disc_price].order_info').val(value);
    }

// 전송용 태그에 저장 - 최종 결제금액
    function setTotalPayPrice(value){
        $('input[name=total_pay_price].order_info').val(value);
        $('input[name=price].pay_info').val(value);
    }

//끝 - 주문, 결제 관련 함수


//시작 - 쿠폰 관련

// 쿠폰 적용 전 변수들
    const previousDiscountAmount = $('input[name=total_disc_price].order_info').val();
    const previousTotalPaymentAmount = $('input[name=total_price].order_info').val();

// 선택된 쿠폰 정보를 저장할 변수들
    var selectedCouponName = "";
    var selectedMinPayPrice = "";
    var selectedMaxDiscPrice = "";
    var selectedPrmo = "";
    var selectedDiscType = "";
    var selectedSeq = "";


// 쿠폰 적용 전 가격으로 초기화
    function cancleCoupon() {
        let promotion = previousDiscountAmount.toString().replace(/\B(?<!\.\d*)(?=(\d{3})+(?!\d))/g, ",");
        let total_pay_price = previousTotalPaymentAmount.toString().replace(/\B(?<!\.\d*)(?=(\d{3})+(?!\d))/g, ",");


        // 결제 초기화 정보 출력
        document.getElementById('payment_view_couponPrice').textContent = promotion;
        document.getElementById('payment_view_discountPrice').textContent = promotion;
        document.getElementById('payment_view_payPrice').textContent = total_pay_price;

        // 결제 위젯 초기화
        paymentMethodWidget.updateAmount(previousTotalPaymentAmount);

        // 주문, 결제 정보 초기화
        setTotalDiscountPrice(previousDiscountAmount);
        setTotalPayPrice(previousTotalPaymentAmount);

        // 모달 닫기
        closeCouponModal();
    }

// 모달창 띄우는 함수
    function openCouponModal() {
        document.getElementsByClassName('couponModalShadow')[0].style.display = 'block';
    }

// 모달창 닫는 함수
    function closeCouponModal() {
        document.getElementsByClassName('couponModalShadow')[0].style.display = 'none';
    }

// 쿠폰 선택 시 쿠폰 정보 변수에 저장
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
        // 총 주문상품 금액 조회
        const total_price = parseFloat($('input[name=total_price].order_info').val()); // 총 주문금액을 가져옴
        // 할인금액 담을 변수
        var promotion = 0;

        // 쿠폰 타입이 퍼센트이면
        if (selectedDiscType === "PER") {
            // 퍼센트로 계산
            promotion = (selectedPrmo / 100) * total_price;
        } else {
            // 아니면 할인금액
            promotion = selectedPrmo;
        }

        // 할인금액이 최대 할인금액 보다 크면
        if (promotion > selectedMaxDiscPrice) {
            // 최대 할인금액으로 저장
            promotion = selectedMaxDiscPrice;
        }

        // 총 결제금액을 계산
        var total_pay_price = total_price - promotion;

        // 전송용 태그에 저장 - 총 할인금액
        setTotalDiscountPrice(promotion);

        // 전송용 태그에 저장 - 최종 결제금액
        setTotalPayPrice(total_pay_price);

        // 결제 위젯 결제금액 업데이트
        paymentMethodWidget.updateAmount(total_pay_price);

        // 금액 , 파싱
        promotion = promotion.toString().replace(/\B(?<!\.\d*)(?=(\d{3})+(?!\d))/g, ",");
        total_pay_price = total_pay_price.toString().replace(/\B(?<!\.\d*)(?=(\d{3})+(?!\d))/g, ",");

        // 결과 표시
        $('#payment_view_couponPrice').text(promotion);
        $('#payment_view_discountPrice').text(promotion);
        $('#payment_view_payPrice').text(total_pay_price);
    }

//끝 - 쿠폰 관련


// 이벤트 연결

// 주소 API 출력
    $('#searchAddressBtn').on('click', findZpcd_DaumPostcode);

// 쿠폰 리스트 출력
    $('#getCouponList').on('click', function(event) {
        event.preventDefault();
        openCouponModal();
    });

// 쿠폰 리스트 닫기
    $('#xBtn').on('click', function(event) {
        event.preventDefault()
        closeCouponModal();
    });

// 쿠폰 적용 취소
    $('#couponModalCancel').on('click', function(event) {
        event.preventDefault()
        cancleCoupon();
    });

// 쿠폰 적용 후 모달 닫기
    $('#couponModalSelect').on('click', function() {
        applyCoupon();
        closeCouponModal();
    });

// 전송용 데이터 가공
// 주문번호 생성 요청 (orderNumGenerateRequest)
    function orderNumGenerateRequest(){
        $.ajax({
            type : 'GET',
            url : '/order/orderNumGenerator',
            contentType : "application/json",
            dataType: 'text'
        })
            .done(function(result){
                // 주문, 결제, 배송 번호 생성
                setOrderPayDeliveryNum(result);
                // 전송용 데이터 생성
                let map = makeOrderInfo();
                console.log(map);
                // 전송
                orderReady(map);
            })
            .fail(function (){alert('주문번호 생성 실패')});
    }

// 주문, 결제, 배송 번호 입력
    function setOrderPayDeliveryNum(num){
        $('input[name=ord_num].order_info').val(num);
        $('input[name=pay_num].pay_info').val('P' + num);
        $('input[name=dlv_num].delivery_info').val('D' + num);
    }

// 객체 생성
    function inputTagToObj(list){
        let obj = {};
        for(let i=0; i < list.length; i++){
            let input = list[i];
            obj[input.name] = input.value;
        }
        return obj;
    }

// 객체 배열 생성
    function inputTagToObjList(tagList){
        let objList = [];
        for(let i=0; i<tagList.length; i++){
            let tmpList = tagList[i].children;
            let obj = {};

            for(let j=0; j < tmpList.length; j++){
                let input = tmpList[j];
                obj[input.name] = input.value;
            }
            objList[i] = obj;
        }
        return objList;
    }

// 주문 정보 생성
    function makeOrderInfo(){
        let order_info = $('.order_info');
        order_info = inputTagToObj(order_info);

        let orderDetail_info = $('.orderDetail_info');
        orderDetail_info = inputTagToObjList(orderDetail_info);

        let delivery_info = $('.delivery_info');
        delivery_info = inputTagToObj(delivery_info);

        let pay_info = $('.pay_info');
        pay_info = inputTagToObj(pay_info);
        let ord_num = $('input[name=ord_num].order_info').val();
        let pay_num = $('input[name=pay_num].pay_info').val();

        let map = {
            'orderDto' : order_info,
            'orderDetailDtoList' : orderDetail_info,
            'orderStateDto' : {ord_num:ord_num},
            'deliveryDto' : delivery_info,
            'payDto' : pay_info,
            'payStateDto' : {pay_num:pay_num}
        }
        return map;
    }

// 주문 정보 저장 요청
    function orderReady(map){
        $.ajax({
            type : 'POST',
            url : '/order/orderReady',
            headers : {"content-type" : "application/json"},
            dataType : 'json',
            // 주문정보 생성
            data : JSON.stringify(map),
        })
            .done(function (result){
                result.successUrl = window.location.origin + result.successUrl;
                result.failUrl = window.location.origin + result.failUrl;
                console.log(result)

                paymentWidget.requestPayment(result);
            })
            .fail(function (error){
                console.log(error);
                alert('주문 정보 저장 실패!');
            });
    }

// 결제하기 버튼
    const button = document.getElementById('payment-button');
        // $('#payment-button');
    const generateRandomString = () => window.btoa(Math.random()).slice(0, 20);
// 결제위젯에 저장할 결제금액
    var amount = $('input[name=total_price].order_info').val();

// ------  결제위젯 초기화 ------
// TODO: clientKey는 개발자센터의 결제위젯 연동 키 > 클라이언트 키로 바꾸세요.
// TODO: 구매자의 고유 아이디를 불러와서 customerKey로 설정하세요. 이메일・전화번호와 같이 유추가 가능한 값은 안전하지 않습니다.
// @docs https://docs.tosspayments.com/reference/widget-sdk#sdk-설치-및-초기화
    const clientKey = "test_gck_docs_Ovk5rk1EwkEbP0W43n07xlzm";
    const customerKey = generateRandomString();
    const paymentWidget = PaymentWidget(clientKey, customerKey); // 회원 결제
// const paymentWidget = PaymentWidget(clientKey, PaymentWidget.ANONYMOUS); // 비회원 결제

// ------  결제 UI 렌더링 ------
// @docs https://docs.tosspayments.com/reference/widget-sdk#renderpaymentmethods선택자-결제-금액-옵션
    var paymentMethodWidget = paymentWidget.renderPaymentMethods(
        "#payment-method",
        { value: amount },
        // 렌더링하고 싶은 결제 UI의 variantKey
        // 결제 수단 및 스타일이 다른 멀티 UI를 직접 만들고 싶다면 계약이 필요해요.
        // @docs https://docs.tosspayments.com/guides/payment-widget/admin#멀티-결제-ui
        { variantKey: "DEFAULT" }
    );
// ------  이용약관 UI 렌더링 ------
// @docs https://docs.tosspayments.com/reference/widget-sdk#renderagreement선택자-옵션
    paymentWidget.renderAgreement("#agreement", { variantKey: "AGREEMENT" });

//  ------  결제 UI 렌더링 완료 이벤트 ------
    paymentMethodWidget.on("ready", function () {
        button.disabled = false;
    });

// ------  결제 금액 업데이트 ------
// @docs https://docs.tosspayments.com/reference/widget-sdk#updateamount결제-금액

// ------ '결제하기' 버튼 누르면 결제창 띄우기 ------
// @docs https://docs.tosspayments.com/reference/widget-sdk#requestpayment결제-정보
button.addEventListener("click", orderNumGenerateRequest);

$(function (){
    // button.on("click", orderNumGenerateRequest);
    selectDeliveryItem(0);
    // $('#delivery_choice_0').prop('checked', true);
})


