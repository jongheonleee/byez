<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<!DOCTYPE html>
<html lang="ko">
<head>
    <meta charset="UTF-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <title>BYEZ</title>
    <link rel="stylesheet" href="/css/nav.css" />
    <link rel="stylesheet" href="/css/orderForm.css" />
    <link rel="stylesheet" href="/css/footer.css?after?after">
    <link rel="stylesheet" href="/css/quick.css" />
    <script src="https://kit.fontawesome.com/f0e73cfa04.js" crossorigin="anonymous"></script>
    <link rel="preconnect" href="https://fonts.googleapis.com" />
    <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin />
    <link
            href="https://fonts.googleapis.com/css2?family=Noto+Sans+KR:wght@100..900&display=swap"
            rel="stylesheet"
    />
    <!-- <link rel="icon" href="https://static.toss.im/icons/png/4x/icon-toss-logo.png" /> -->
    <!-- <link rel="stylesheet" type="text/css" href="/css/style.css" /> -->

    <!-- 결제위젯 SDK 추가 -->
    <script src="https://js.tosspayments.com/v1/payment-widget"></script>
</head>
<body>
<jsp:include page="/WEB-INF/views/include/nav.jsp"/>
<section>
    <div class="wrapper">
        <!-- 제목  -->
        <div class="orderForm_header">
            <h2>Order / Payment</h2>
            <p>
                <a href="/"><span>home</span></a>
                <span>></span>
                <span>주문서</span>
            </p>
        </div>

        <div class="wrapper_info">
            <!-- 전송용 태그 - 배송 -->
            <input type="hidden" class="delivery_info" name="dlv_num" value="">
            <input type="hidden" class="delivery_info" name="pickup_chk" value="N">
            <input type="hidden" class="delivery_info" name="rcpr" value="">
            <input type="hidden" class="delivery_info" name="rcpr_mobile" value="">
            <input type="hidden" class="delivery_info" name="zpcd" value="">
            <input type="hidden" class="delivery_info" name="main_addr" value="">
            <input type="hidden" class="delivery_info" name="detail_addr" value="">
            <input type="hidden" class="delivery_info" name="msg" value="">
            <!--// 전송용 태그 - 배송 -->

            <!-- 전송용 태그 - 주문 -->
            <input type="hidden" class="order_info" name="ord_num" value="0">
            <input type="hidden" class="order_info" name="total_item_qty" value="${orderDto.total_item_qty}">
            <input type="hidden" class="order_info" name="total_price" value="${orderDto.total_price}">
            <input type="hidden" class="order_info" name="total_dlv_price" value="0">
            <input type="hidden" class="order_info" name="total_disc_price" value="0">
            <input type="hidden" class="order_info" name="total_pay_price" value="${orderDto.total_price}">
            <input type="hidden" class="order_info" name="ord_state" value="주문대기">
            <!--// 전송용 태그 - 주문 -->

            <!-- 전송용 태그 - 쿠폰 -->
            <input type="hidden" class="coupon_info" name="seq" value="">
            <!--// 전송용 태그 - 쿠폰 -->

            <!-- 전송용 태그 - 결제 -->
            <input type="hidden" class="pay_info" name="pay_num" value="">
            <input type="hidden" class="pay_info" name="price" value="${orderDto.total_price}">
            <input type="hidden" class="pay_info" name="mtd_code" value="Toss">
            <!--// 전송용 태그 - 결제 -->

            <!-- 배송 정보 -->
            <div class="orderForm_delivery">
                <!-- 레이아웃명 -->
                <p class="orderForm_title">배송정보</p>

                <!-- 탭 메뉴 -->
                <ul class="tab_menu">
                    <li><a href="#tab1-1">기존배송지</a></li>
                    <li><a href="#tab1-2">직접입력</a></li>
                </ul>
                <!-- 탭 콘텐츠 -->
                <div class="≈">
                    <div id="tab1-1" class="tab_content">
                        <div class="tab_c_arti">
                            <c:if test="${not empty addressEntryDtoList}">
                                <ul class="info_list_delivery info_style">
                                    <!-- 배송지 목록 선택 -->
                                    <li class="list_item">
                                        <span class="list_item_label">배송지</span>
                                        <div class="list_item_area">
                                            <ul>
                                                <c:forEach var="addr" items="${addressEntryDtoList}" varStatus="status">
                                                    <li>
                                                        <input type="hidden" id="dlvInfo_rcpr_${status.index}" value="${addr.recipient}">
                                                        <input type="hidden" id="dlvInfo_rcpr_mobile_${status.index}" value="${addr.mobileNum}">
                                                        <input type="hidden" id="dlvInfo_zpcd_${status.index}" value="${addr.zpcd}">
                                                        <input type="hidden" id="dlvInfo_main_addr_${status.index}" value="${addr.mainAddr}">
                                                        <input type="hidden" id="dlvInfo_detail_addr_${status.index}" value="${addr.detailAddr}">

                                                        <input type="radio" name="delivery_list_item_btn" id="delivery_choice_${status.index}" <c:if test="${status.index==0}">checked</c:if> onclick="selectDeliveryItem(${status.index})"/>
                                                        <label for="delivery_choice_${status.index}">${addr.nick}</label>
                                                    </li>
                                                </c:forEach>
                                                    <%--// 배송지 정보 --%>
                                                <!-- ####### 버튼 나중에 구현 -->
                                                <button type="button" class="order_button" onclick="showDelivery()" style="display: none">
                                                    배송지 변경
                                                </button>
                                            </ul>
                                        </div>
                                    </li>
                                    <!-- 이름/연락처 -->
                                    <li class="list_item">
                                        <span class="list_item_label">이름/연락처</span>
                                        <div class="list_item_area">
                                            <ul>
                                                <li id="delivery_view_rcpr"></li>
                                                <li id="delivery_view_mobile"></li>
                                            </ul>
                                        </div>
                                    </li>
                                    <!-- 주소(우편번호, 기본주소, 상세주소) -->
                                    <li class="list_item">
                                        <span class="list_item_label">주소</span>
                                        <div class="list_item_area">
                                            <ul>
                                                <li id="delivery_view_addr"></li>
                                            </ul>
                                        </div>
                                    </li>
                                </ul>
                            </c:if>
                            <c:if test="${empty addressEntryDtoList}">
                                <ul class="info_list_delivery info_style" id="noDlvCheck">
                                    <!-- 배송지 목록 선택 -->
                                    <li class="list_item noDlv">
                                        <p>등록된 배송지가 없습니다.</p>
                                    </li>
                                </ul>
                            </c:if>
                        </div>
                    </div>
                    <div id="tab1-2" class="tab_content" <c:if test="${empty addressEntryDtoList}">style="display: block"</c:if> >
                        <div class="tab_c_arti">
                            <!-- <p>123</p> -->
                            <!-- 배송지 직접 입력 폼 -->
                            <ul class="info_list_delivery info_style">
                                <!-- 이름 -->
                                <li class="list_item">
                                    <span class="list_item_label">이름</span>
                                    <div class="list_item_area">
                                        <input id="delivery_form_rcpr" type="text" oninput="setDeliveryRcpr(this.value)"/>
                                    </div>
                                </li>
                                <!-- 주소 -->
                                <li class="list_item">
                                    <span class="list_item_label">주소</span>
                                    <div class="list_item_area">
                                        <input id="delivery_form_zpcd" type="text" readonly/><button type="button" id="searchAddressBtn">주소검색</button><br />
                                        <input id="delivery_form_main_addr" type="text" readonly/><br />
                                        <input id="delivery_form_detail_addr" type="text" oninput="setDeliveryDetailAddr(this.value)" />
                                    </div>
                                </li>
                                <!-- #######일반전화 -->
                                <li class="list_item" style="display: none">
                                    <span class="list_item_label">일반전화</span>
                                    <div class="list_item_area">
                                        <input id="delivery_form_tel_num" type="text" />
                                    </div>
                                </li>
                                <!-- 휴대전화 -->
                                <li class="list_item">
                                    <span class="list_item_label">휴대전화</span>
                                    <div class="list_item_area">
                                        <input id="delivery_form_mobile_num" type="text" inputmode="numeric" maxlength="11" oninput="setDeliveryMobile(this.value)"/>
                                    </div>
                                </li>
                            </ul>
                        </div>
                    </div>
                </div>
                <!-- 배송지 입력 폼 -->
                <ul class="info_list_delivery info_style">
                    <!-- 배송 메시지 -->
                    <li class="list_item orderForm_item_overflow">
                        <span class="list_item_label">배송 요청사항</span>
                        <div class="list_item_area_column">
                            <!-- A 선택 후 직접 입력 선택 시 A 출력 -->
                            <select class="orderForm_select" onchange="showEtc(this.value);">
                                <option value="" selected="selected">배송 시 요청사항을 선택해주세요</option>
                                <option value="부재 시 경비실에 맡겨주세요">부재 시 경비실에 맡겨주세요</option>
                                <option value="부재 시 택배함에 넣어주세요">부재 시 택배함에 넣어주세요</option>
                                <option value="부재 시 집 앞에 놔주세요">부재 시 집 앞에 놔주세요</option>
                                <option value="배송 전 연락 바랍니다">배송 전 연락 바랍니다</option>
                                <option value="파손의 위험이 있는 상품입니다. 배송 시 주의해 주세요">파손의 위험이 있는 상품입니다. 배송 시 주의해 주세요</option>
                                <option value="etc">직접 입력</option>
                            </select>
                            <!-- 배송메시지 직접 입력 - 글자 수 제한 구현 필요-->
                            <textarea
                                    id="delivery_msg"
                                    class="order_textarea"
                                    name="etc_textarea"
                                    style="display: none"
                                    maxlength="50"
                                    oninput="setDeliveryMsg(this.value)"
<%--                                    onkeyup="return textarea_maxlength(this)"--%>
                                    placeholder="최대 50자까지 입력 가능합니다."
                            ></textarea>
                        </div>
                    </li>
                </ul>
            </div>
            <!-- 상품 정보 -->
            <div class="orderForm_products">
                <!-- 레이아웃 명 -->
                <p class="orderForm_title">상품정보</p>
                <!-- 주문상품 정보 테이블-->
                <table class="orderdetailInfo">
                    <thead>
                        <th>상품정보</th>
                        <th>수량</th>
                        <th>상품금액</th>
                        <th>배송그룹</th>
                        <th>배송비</th>
                        <th>주문금액</th>
                    </thead>
                    <tbody>
                        <c:forEach var="item" items="${basketItemDtoList}" varStatus="status">
                            <tr>
                                <td class="orderDetail_info" style="text-align: center;">
                                    <!-- 전송용 태그 - 주문상품 -->
                                    <input type="hidden" name="seq" value="${item.seq}">
                                    <input type="hidden" name="item_num" value="${item.num}">
                                    <input type="hidden" name="main_img" value="${item.main_img}">
                                    <input type="hidden" name="item_name" value="${item.name}">
                                    <input type="hidden" name="item_qty" value="${item.qty}">
                                    <input type="hidden" name="price" value="${item.price}">
                                    <input type="hidden" name="item_price" value="${(item.price) * (item.qty)}">
                                    <input type="hidden" name="opt1" value="${item.opt1}">
                                    <input type="hidden" name="opt2" value="${item.opt2}">
                                    <input type="hidden" name="opt3" value="${item.opt3}">
                                    <input type="hidden" name="opt4" value="${item.opt4}">
                                    <input type="hidden" name="opt5" value="${item.opt5}">
                                    <!--// 전송용 태그 - 주문상품 -->
                                    <div class="basketImgWrap">
                                        <a href="/goods/${item.num}">
<%--                                            <img src="/img/${item.main_img}">--%>
                                            <img src="/img/${item.main_img}">
                                        </a>
                                    </div>
                                    <div class="eachBasketInfo">
                                        <p>
                                            <a href="/goods/${item.num}">
                                                <strong>${item.name}</strong>
                                            </a>
                                        </p>
                                        <p>
                                            [사이즈 : ${item.opt1} / 컬러 : ${item.opt2}]
                                        </p>
                                        <div>
                                            ${item.opt3}
                                        </div>
                                    </div>
                                </td>
                                <td style="text-align: center;">${item.qty}</td>
                                <td style="text-align: center;"><p class="sales_price"><fmt:formatNumber value="${item.price}" pattern="#,###"/></p></td>
                                <td style="text-align: center;"><p class="sales_price">배송그룹1</p></td>
                                <td style="text-align: center;"><p class="sales_price">0원</p></td>
                                <td style="text-align: center;"><p class="sales_price"><fmt:formatNumber value="${item.qty * item.price}" pattern="#,###"/></p></td>
                            </tr>
                        </c:forEach>
                    </tbody>
                </table>
            </div>
            <!-- 쿠폰 정보 -->
            <div class="orderForm_coupon info_style">
                <p class="orderForm_title">쿠폰정보</p>
                <input type="hidden" name="discountPrice" value="0">
            </div>
            <!-- 결제 정보 -->
            <div class="orderForm_payment">
                <p class="orderForm_title">결제정보</p>
                <table class="orderdetailInfo paymentInfo">
                    <tbody>
                    <tr>
                        <td>상품금액</td>
                        <td></td>
                        <td><span id="payment_view_totalPrice"><fmt:formatNumber value="${orderDto.total_price}" pattern="#,###"/></span>원</td>
                    </tr>
                    <tr>
                        <td>쿠폰할인금액</td>
                        <td class="relative">
                            <button id="getCouponList">쿠폰 조회/적용</button>
                        </td>
                        <td><span id="payment_view_couponPrice">0</span>원</td>
                    </tr>
                    <tr>
                        <td>할인 합계</td>
                        <td></td>
                        <td><span id="payment_view_discountPrice">0</span>원</td>
                    </tr>
                    <tr>
                        <td>배송비</td>
                        <td></td>
                        <td><span id="payment_view_deliveryPrice">0</span>원</td>
                    </tr>
                    <tr>
                        <td>최종결제금액</td>
                        <td></td>
                        <td><span id="payment_view_payPrice">0</span>원</td>
                    </tr>
                    </tbody>
                </table>
            </div>
            <div class="tossApi">
                <div class="box_section info_style" style="padding: 40px 30px 50px 30px; margin-top: 30px">
                    <!-- 결제 UI -->
                    <div id="payment-method"></div>
                    <!-- 이용약관 UI -->
                    <div id="agreement"></div>
                    <!-- 쿠폰 체크박스 -->
                    <button class="button" id="payment-button" style="margin-top: 30px" disabled>결제하기</button>
                </div>
            </div>
        </div>
    </div>
</section>
<jsp:include page="/WEB-INF/views/include/footer.jsp"/>
<div class="quick">
    <a href="#none" onclick="jQuery('html,body').animate({scrollTop:0},'slow')">
        <img src="/img/quick_up.png" alt="" />
    </a>
    <a href="#none" onclick="jQuery('html,body').animate({scrollTop:$(document).height()},'slow');">
        <img src="/img/quick_down.png" alt="" />
    </a>
</div>
<div class="couponModalShadow">
    <div class="couponModal">
        <c:set var="limitDate" value="2500-01-01" />
        <p>적용 가능 쿠폰 리스트</p>
        <p>해당 주문에 적용 가능한 쿠폰입니다. 쿠폰을 선택해 주세요.</p>
        <button id="xBtn"><i class="fa-solid fa-xmark"></i></button>
        <div class="modalScroll">
            <table class="orderdetailInfo modalTable">
                <thead>
                <tr>
                    <th scope="col">쿠폰명</th>
                    <th scope="col">최대할인금액</th>
                    <th scope="col">할인혜택</th>
                    <th scope="col">만료일</th>
                </tr>
                </thead>
                <tbody>
                <c:forEach items="${coupons}" var="coupon">
                    <tr>
                        <td>
                            <input type="radio" id="${coupon.custCouponsDto.seq}" name="options" onclick="saveSelectedCoupon('${coupon.couponDto.name}', '${coupon.couponDto.minPayPrice}', '${coupon.couponDto.maxDiscPrice}', '${coupon.couponDto.prmo}', '${coupon.couponDto.discType}', '${coupon.custCouponsDto.seq}')"/>
                            <!-- 이 부분에 쿠폰명 또는 다른 정보를 출력할 수 있습니다. -->
                            <label for="${coupon.custCouponsDto.seq}">
                                    ${coupon.couponDto.name}
                            </label>
                        </td>
                        <td>
                            <span>${coupon.couponDto.maxDiscPrice}</span>원
                        </td>
                        <td>
                            <c:choose>
                                <c:when test="${coupon.couponDto.discType eq 'PER'}">
                                    ${coupon.couponDto.prmo}%
                                </c:when>
                                <c:otherwise>
                                    -${coupon.couponDto.prmo}
                                </c:otherwise>
                            </c:choose>
                        </td>
                        <td>
                            <c:choose>
                                <c:when test="${coupon.custCouponsDto.expDate >= limitDate}">
                                    제한 없음
                                </c:when>
                                <c:otherwise>
                                    <fmt:parseDate var="parsedDate" value="${coupon.custCouponsDto.expDate}" pattern="yyyy-MM-dd" />
                                    <fmt:formatDate value="${parsedDate}" pattern="yyyy-MM-dd"/>
                                </c:otherwise>
                            </c:choose>
                        </td>
                    </tr>
                </c:forEach>
                </tbody>
            </table>
            <c:if test="${coupons.size() == 0}">
                <p class="message">보유중인 쿠폰이 없습니다.</p>
            </c:if>
        </div>
        <div>
            <button id="couponModalCancel">적용취소</button>
            <button id="couponModalSelect">쿠폰적용</button>
        </div>
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
<script src="//t1.daumcdn.net/mapjsapi/bundle/postcode/prod/postcode.v2.js"></script>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script src="/js/jquery-3.6.4.min.js"></script>
<script src="/js/nav.js"></script>
<script src="/js/tab.js"></script>
<script src="/js/orderForm.js"></script>
</body>
</html>