<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="utf-8" />
    <link rel="icon" href="https://static.toss.im/icons/png/4x/icon-toss-logo.png" />
    <link rel="stylesheet" type="text/css" href="/style.css" />
    <meta http-equiv="X-UA-Compatible" content="IE=edge" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <title>토스페이먼츠 샘플 프로젝트</title>
    <!-- 결제위젯 SDK 추가 -->
    <script src="https://js.tosspayments.com/v1/payment-widget"></script>
</head>
<body>

<%--
    주문 정보

    1. 주문 정보
    2. 주문내역 상세 정보
    3. 결제 정보
    4. 배송 정보?
 --%>

<form>
    <!-- 주문정보 -->
    <%--        주문의 요약 정보 입력 --%>
    <div id="order_info">
        <input type="hidden" name="ord_num" value="">
        <input type="hidden" name="total_item_qty" value="5">
        <input type="hidden" name="total_price" value="8000">
        <input type="hidden" name="total_dlv_price" value="0">
        <input type="hidden" name="total_disc_price" value="0">
        <input type="hidden" name="total_pay_price" value="8000">
        <input type="hidden" name="ord_state" value="주문완료">
    </div>
    <!--// 주문정보 -->

    <!-- 주문상품정보 -->
    <div class="td_product">
        <input type="hidden" name="seq" value="1">
        <input type="hidden" name="item_num" value="1234">
        <input type="hidden" name="item_name" value="[COOL] 오픈카라 스트라이프 반팔니트_SPKWE25C08">
        <input type="hidden" name="price" value="2000">
        <input type="hidden" name="item_qty" value="2">
        <input type="hidden" name="item_price" value="4000">
    </div>
    <div class="td_product">
        <input type="hidden" name="seq" value="2">
        <input type="hidden" name="item_num" value="1234">
        <input type="hidden" name="item_name" value="상의">
        <input type="hidden" name="price" value="2000">
        <input type="hidden" name="item_qty" value="2">
        <input type="hidden" name="item_price" value="4000">
    </div>
    <!--// 주문상품정보 -->

    <!-- 배송지 정보 -->
    <div id="delivery_info">
        <input type="hidden" name="dlv_num" value="">
        <input type="hidden" name="waybill_num" value="">
        <input type="hidden" name="dlv_corp" value="">
        <input type="hidden" name="pickup_chk" value="N">
        <input type="hidden" name="rcpr" value="김자바">
        <input type="hidden" name="rcpr_mobile" value="010-1234-5678">
        <input type="hidden" name="zpcd" value="12345">
        <input type="hidden" name="main_addr" value="서울시 강남구">
        <input type="hidden" name="detail_addr" value="미왕빌딩10층">
        <input type="hidden" name="msg" value="부재시 문 앞">
    </div>
    <!--// 배송지 정보 -->

    <!-- 결제 정보 -->
    <div id="pay_info">
        <input type="hidden" name="pay_num" value="">
        <input type="hidden" name="price" value="17500">
        <input type="hidden" name="mtd_code" value="PMT03">
        <input type="hidden" name="state" value="결제대기">
    </div>
</form>
    <!--// 결제 정보 -->


    <!-- 주문서 영역 -->
    <div class="wrapper">
        <div class="box_section" style="padding: 40px 30px 50px 30px; margin-top: 30px; margin-bottom: 50px">
            <!-- 결제 UI -->
            <div id="payment-method"></div>
            <!-- 이용약관 UI -->
            <div id="agreement"></div>
            <!-- 쿠폰 체크박스 -->
            <div class="checkable typography--p" style="padding-left: 25px">
                <label for="coupon-box" class="checkable__label typography--regular"
                ><input id="coupon-box" class="checkable__input" type="checkbox" aria-checked="true" disabled /><span class="checkable__label-text">5,000원 쿠폰 적용</span></label
                >
            </div>
            <!-- 결제하기 버튼 -->
            <button class="button" id="payment-button" style="margin-top: 30px" disabled>결제하기</button>
        </div>
    </div>
    <!--
        주문 프로세스
        고객이 상품을 주문한다.

            1. 장바구니 or 상품상세에서 주문하기 클릭(orderForm 요청)
            2. 주문에 필요한 정보를 출력한다.(주문자, 배송지목록, 주문상품목록, 쿠폰목록, 결제 정보)
                1. 성공 시 : orderForm.jsp 출력
                2. 실패 시 : "실패 메시지" 출력
            3. 고객이 정보를 입력한다.
            4. 결제 수단을 선택하고 결제하기 클릭
                4-1. 주문번호 생성 요청 (orderNumGenerateRequest)
                    4-1-1. 성공 시 : input 태그에 주문번호 입력
                    4-1-2. 실패 시 : 재요청
                    4-1-3. 재요청 실패 시 : "실패 메시지" 출력.

                4-2. 결제 생성 요청 (paymentMakeRequest) - Toss API 기준
                    4-2-1. 주문정보 저장 (orderReady) (주문, 주문상품목록, 배송지, 결제)
                        a. 주문정보 검증
                            a-a. 성공 시 : 주문정보 저장(b)
                            a-b. 실패 시 : "실패 메시지" 출력.
                        b. 주문정보 저장
                    4-2-2. 결제 요청정보 생성(ord_num, ord_name, 성공 실패 URL, 주문자 이메일, 이름, 전화번호)
                    4-2-3. 결제 생성 요청 및 사용자 인증
                        a. 성공 시 : success URL 이동.(QueryParameter 정보 : paymentKey, orderId, amount)
                        b. 실패 시 : fail URL 이동.
            5. 결제 승인 요청 (confirm)
                5-1. 승인 요청 정보 검증
                    5-1-1. 성공 시 : 승인 요청(5-2)
                    5-1-2. 실패 시 : "실패 메시지" 출력.
                5-2. 승인 요청
                    5-2-1. 성공 시 : 결제 정보 저장(5-3)
                    5-2-2. 실패 시 : "실패 메시지 출력".
                5-3. 결제 정보 저장(결제 상태 변경 및 결제 이력 생성)
                    5-3-1. 성공 시 : 주문 완료 페이지 이동
                    5-3-2. 실패 시 : "실패 메시지" 출력.
            6. 주문 완료 페이지 이동

        사전 정보
            1. 주문자 정보
            2. 배송지 목록
            3. 주문상품 목록
            4. 쿠폰 목록
            5. 결제 정보
    -->
    <script src="//code.jquery.com/jquery-1.11.3.min.js"></script>
    <script src="//code.jquery.com/jquery-migrate-1.2.1.min.js"></script>
    <script>
        $(window).load(function (){

        })
        // 주문번호 생성 요청 (orderNumGenerateRequest)
        function orderNumGenerateRequest(){
            $.ajax({
                type : 'GET',
                url : '/order/orderNumGenerator',
                contentType : "application/json",
                dataType: 'text'
            })
            .done(function(result){
                setOrderPayDeliveryNum(result);
                let map = makeOrderInfo();
                orderReady(map);
            })
            .fail(function (){alert('주문번호 생성 실패')})
        }

        // 주문, 결제, 배송 번호 입력
        function setOrderPayDeliveryNum(ord_num){
            $('input[name=ord_num]').val(ord_num);
            $('input[name=pay_num]').val('P' + ord_num);
            $('input[name=dlv_num]').val('D' + ord_num);
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
            let order_info = $('#order_info input');
            let orderInfo = inputTagToObj(order_info);

            let orderDetail_info = $('.td_product');
            let orderDetailInfo = inputTagToObjList(orderDetail_info);

            let delivery_info = $('#delivery_info input');
            let deliveryInfo = inputTagToObj(delivery_info);

            let pay_info = $('#pay_info input');
            let payInfo = inputTagToObj(pay_info);
            let ord_num = $('input[name=ord_num]:first').val();
            let pay_num = $('input[name=pay_num]:first').val();

            let map = {
                'orderDto' : orderInfo,
                'orderDetailDtoList' : orderDetailInfo,
                'orderStateDto' : {ord_num:ord_num},
                'deliveryDto' : deliveryInfo,
                'payDto' : payInfo,
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
                // return result;
            })
                .fail(function (error){
                    console.log(error);
                    alert('주문 정보 저장 실패!');
                });
        }

        const button = document.getElementById('payment-button');
        const coupon = document.getElementById('coupon-box');
        const generateRandomString = () => window.btoa(Math.random()).slice(0, 20);
        var amount = $('input[name=total_pay_price]').val();
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
            coupon.disabled = false;
        });

        // ------  결제 금액 업데이트 ------
        // @docs https://docs.tosspayments.com/reference/widget-sdk#updateamount결제-금액
        coupon.addEventListener("change", function () {
            if (coupon.checked) {
                paymentMethodWidget.updateAmount(amount - 5000);
            } else {
                paymentMethodWidget.updateAmount(amount);
            }
        });

        // ------ '결제하기' 버튼 누르면 결제창 띄우기 ------
        // @docs https://docs.tosspayments.com/reference/widget-sdk#requestpayment결제-정보
        button.addEventListener("click", orderNumGenerateRequest);
        // function () {
        //     orderNumGenerateRequest();
            // 결제를 요청하기 전에 orderId, amount를 서버에 저장하세요.
            // 결제 과정에서 악의적으로 결제 금액이 바뀌는 것을 확인하는 용도입니다.
            // paymentWidget.requestPayment({
            //     // orderId: $('input[name=ord_num]:first'),
            //     orderId: generateRandomString(),
            //     orderName: "토스 티셔츠 외 2건",
            //     successUrl: window.location.origin + "/success",
            //     failUrl: window.location.origin + "/fail",
            //     customerEmail: "customer123@gmail.com",
            //     customerName: "김토스",
            //     customerMobilePhone: "01012341234",
            // });
        // }
        // );
    </script>

</body>
</html>
