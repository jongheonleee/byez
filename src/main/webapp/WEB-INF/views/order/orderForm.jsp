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
    <link rel="stylesheet" href="/css/footer.css" />
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
<nav>
    <div class="wrapper">
        <div class="nav_logo">
            <a href="main.html">
                <img src="/img/logo3.png" alt="" />
            </a>
        </div>
        <ul class="nav_menu">
            <li><a href="discount.html">할인 상품</a></li>
            <li><a href="best.html">베스트</a></li>
            <li><a href="category.html">여성</a></li>
            <li><a href="category.html">남성</a></li>
            <li><a href="category.html">혼성</a></li>
        </ul>
        <ul class="nav_member">
            <li class="hover">
                <a href="#">
                    <img src="/img/top_mypage.png" />
                </a>
                <!-- <ul class="sub_menu">
                <li><a href="#">LOGIN</a>
                </li>
                <li><a href="#">ORDER</a>
                </li>
            </ul> -->
                <ul class="sub_menu">
                    <li><a href="#">LOGOUT</a></li>
                    <li><a href="mypage.html">MYPAGE</a></li>
                    <li><a href="#">ORDER</a></li>
                </ul>
            </li>
            <li>
                <a href="#"><img src="/img/top_search.png" /></a>
            </li>
            <li>
                <a href="#"><img src="/img/top_wish.png" /></a>
            </li>
            <li>
                <a href="#" class="cart_cnt">
                    <img src="/img/top_cart_pc.png" />
                    <div>
                        <span>0</span>
                    </div>
                </a>
            </li>
        </ul>
    </div>
    <div class="nav_woman">
        <ul>
            <li>
                <ul>
                    <li>여성</li>
                </ul>
            </li>
            <li>
                <ul>
                    <li><a href="category.html">상의</a></li>
                    <li><a href="category.html">맨투맨/스웨트셔츠</a></li>
                    <li><a href="category.html">후드/집업</a></li>
                    <li><a href="category.html">니트/스웨터</a></li>
                    <li><a href="category.html">셔츠/블라우스</a></li>
                    <li><a href="category.html">긴팔 티셔츠</a></li>
                    <li><a href="category.html">반팔 티셔츠</a></li>
                    <li><a href="category.html">슬리브리스</a></li>
                </ul>
            </li>
            <li>
                <ul>
                    <li><a href="category.html">아우터</a></li>
                    <li><a href="category.html">패딩/다운</a></li>
                    <li><a href="category.html">폴리스/덤블</a></li>
                    <li><a href="category.html">자켓/점퍼</a></li>
                    <li><a href="category.html">블레이저</a></li>
                    <li><a href="category.html">가디건</a></li>
                    <li><a href="category.html">바람막이</a></li>
                </ul>
            </li>
            <li>
                <ul>
                    <li><a href="category.html">하의</a></li>
                    <li><a href="category.html">슬랙스</a></li>
                    <li><a href="category.html">트레이닝/스웨트셔츠</a></li>
                    <li><a href="category.html">팬츠</a></li>
                    <li><a href="category.html">숏츠</a></li>
                    <li><a href="category.html">스커트</a></li>
                </ul>
            </li>
            <li>
                <ul>
                    <li><a href="category.html">신발</a></li>
                    <li><a href="category.html">운동화</a></li>
                    <li><a href="category.html">구두</a></li>
                    <li><a href="category.html">로퍼</a></li>
                    <li><a href="category.html">힐</a></li>
                    <li><a href="category.html">부츠</a></li>
                    <li><a href="category.html">슬리퍼</a></li>
                    <li><a href="category.html">샌달</a></li>
                </ul>
            </li>
            <li>
                <ul>
                    <li><a href="category.html">기타</a></li>
                </ul>
            </li>
        </ul>
    </div>
    <div class="nav_man">
        <ul>
            <li>
                <ul>
                    <li>여성</li>
                </ul>
            </li>
            <li>
                <ul>
                    <li><a href="category.html">상의</a></li>
                    <li><a href="category.html">맨투맨/스웨트셔츠</a></li>
                    <li><a href="category.html">후드/집업</a></li>
                    <li><a href="category.html">니트/스웨터</a></li>
                    <li><a href="category.html">셔츠/블라우스</a></li>
                    <li><a href="category.html">긴팔 티셔츠</a></li>
                    <li><a href="category.html">반팔 티셔츠</a></li>
                    <li><a href="category.html">슬리브리스</a></li>
                </ul>
            </li>
            <li>
                <ul>
                    <li><a href="category.html">아우터</a></li>
                    <li><a href="category.html">패딩/다운</a></li>
                    <li><a href="category.html">폴리스/덤블</a></li>
                    <li><a href="category.html">자켓/점퍼</a></li>
                    <li><a href="category.html">블레이저</a></li>
                    <li><a href="category.html">가디건</a></li>
                    <li><a href="category.html">바람막이</a></li>
                </ul>
            </li>
            <li>
                <ul>
                    <li><a href="category.html">하의</a></li>
                    <li><a href="category.html">슬랙스</a></li>
                    <li><a href="category.html">트레이닝/스웨트셔츠</a></li>
                    <li><a href="category.html">팬츠</a></li>
                    <li><a href="category.html">숏츠</a></li>
                    <li><a href="category.html">스커트</a></li>
                </ul>
            </li>
            <li>
                <ul>
                    <li><a href="category.html">신발</a></li>
                    <li><a href="category.html">운동화</a></li>
                    <li><a href="category.html">구두</a></li>
                    <li><a href="category.html">로퍼</a></li>
                    <li><a href="category.html">힐</a></li>
                    <li><a href="category.html">부츠</a></li>
                    <li><a href="category.html">슬리퍼</a></li>
                    <li><a href="category.html">샌달</a></li>
                </ul>
            </li>
            <li>
                <ul>
                    <li><a href="category.html">기타</a></li>
                </ul>
            </li>
        </ul>
    </div>
    <div class="nav_unisex">
        <ul>
            <li>
                <ul>
                    <li>여성</li>
                </ul>
            </li>
            <li>
                <ul>
                    <li><a href="category.html">상의</a></li>
                    <li><a href="category.html">맨투맨/스웨트셔츠</a></li>
                    <li><a href="category.html">후드/집업</a></li>
                    <li><a href="category.html">니트/스웨터</a></li>
                    <li><a href="category.html">셔츠/블라우스</a></li>
                    <li><a href="category.html">긴팔 티셔츠</a></li>
                    <li><a href="category.html">반팔 티셔츠</a></li>
                    <li><a href="category.html">슬리브리스</a></li>
                </ul>
            </li>
            <li>
                <ul>
                    <li><a href="category.html">아우터</a></li>
                    <li><a href="category.html">패딩/다운</a></li>
                    <li><a href="category.html">폴리스/덤블</a></li>
                    <li><a href="category.html">자켓/점퍼</a></li>
                    <li><a href="category.html">블레이저</a></li>
                    <li><a href="category.html">가디건</a></li>
                    <li><a href="category.html">바람막이</a></li>
                </ul>
            </li>
            <li>
                <ul>
                    <li><a href="category.html">하의</a></li>
                    <li><a href="category.html">슬랙스</a></li>
                    <li><a href="category.html">트레이닝/스웨트셔츠</a></li>
                    <li><a href="category.html">팬츠</a></li>
                    <li><a href="category.html">숏츠</a></li>
                    <li><a href="category.html">스커트</a></li>
                </ul>
            </li>
            <li>
                <ul>
                    <li><a href="category.html">신발</a></li>
                    <li><a href="category.html">운동화</a></li>
                    <li><a href="category.html">구두</a></li>
                    <li><a href="category.html">로퍼</a></li>
                    <li><a href="category.html">힐</a></li>
                    <li><a href="category.html">부츠</a></li>
                    <li><a href="category.html">슬리퍼</a></li>
                    <li><a href="category.html">샌달</a></li>
                </ul>
            </li>
            <li>
                <ul>
                    <li><a href="category.html">기타</a></li>
                </ul>
            </li>
        </ul>
    </div>
    <div class="search_div">
        <div>
            <p>
                고객님<br />무엇을 찾으시나요?
                <img src="/img/top_search_close.png" alt="" />
            </p>
            <form action="">
                <input type="text" placeholder="상품을 찾아보세요" />
                <button type="submit">
                    <i class="fa-solid fa-magnifying-glass"></i>
                </button>
            </form>
        </div>
    </div>
    <div class="shadow"></div>
</nav>
<section>
    <div class="wrapper">
        <!-- 제목  -->
        <div class="orderForm_header">
            <h2>Order / Payment</h2>
            <p>
                <a href="main.html"><span>home</span></a>
                <span>></span>
                <a href="orderForm.html"><span>주문서</span></a>
                <!-- <span>></span>
            <a href="#"><span>중분류</span></a>
            <span>></span>
            <a href="#"><span>소분류</span></a> -->
            </p>
        </div>

        <div class="wrapper_info">

            <!-- 전송용 태그 - 주문 -->
            <input type="hidden" class="order_info" name="ord_num" value="0">
            <input type="hidden" class="order_info" name="total_item_qty" value="${orderDto.total_item_qty}">
            <input type="hidden" class="order_info" name="total_price" value="${orderDto.total_price}">
            <input type="hidden" class="order_info" name="total_dlv_price" value="0">
            <input type="hidden" class="order_info" name="total_disc_price" value="0">
            <input type="hidden" class="order_info" name="total_pay_price" value="${orderDto.total_price}">
            <input type="hidden" class="order_info" name="ord_state" value="">
            <!--// 전송용 태그 - 주문 -->

            <!-- 전송용 태그 - 결제 -->
            <input type="hidden" class="pay_info" name="pay_num" value="">
            <input type="hidden" class="pay_info" name="price" value="${orderDto.total_price}">
            <input type="hidden" class="pay_info" name="mtd_code" value="">
            <!--// 전송용 태그 - 결제 -->

            <!-- 전송용 태그 - 배송 -->
            <input class="delivery_info" type="hidden" name="dlv_num" value="">
            <input class="delivery_info" type="hidden" name="pickup_chk" value="N">
            <input class="delivery_info" type="hidden" name="rcpr" value="">
            <input class="delivery_info" type="hidden" name="rcpr_mobile" value="">
            <input class="delivery_info" type="hidden" name="zpcd" value="">
            <input class="delivery_info" type="hidden" name="main_addr" value="">
            <input class="delivery_info" type="hidden" name="detail_addr" value="">
            <input class="delivery_info" type="hidden" name="msg" value="">
            <!--// 전송용 태그 - 배송 -->

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
                            <!-- <p>123</p> -->
                            <!-- 배송지 선택 폼 -->
                            <ul class="info_list_delivery info_style">
                                <!-- 배송지 목록 선택 -->
                                <li class="list_item">
                                    <span class="list_item_label">배송지</span>
                                    <div class="list_item_area">
                                        <ul>
                                            <!--
                                                TODO:배송지 목록 없는 경우 직접 입력 보여줄것
                                            -->
                                            <c:if test="${empty addressEntryDtoList}">

                                            </c:if>
                                            <c:forEach var="addr" items="${addressEntryDtoList}" varStatus="status">
                                                <li>
                                                    <input type="hidden" id="dlvInfo_rcpr${status.index}" value="${addr.recipient}">
                                                    <input type="hidden" id="dlvInfo_rcpr_mobile${status.index}" value="${addr.mobileNum}">
                                                    <input type="hidden" id="dlvInfo_zpcd${status.index}" value="${addr.zpcd}">
                                                    <input type="hidden" id="dlvInfo_main_addr${status.index}" value="${addr.mainAddr}">
                                                    <input type="hidden" id="dlvInfo_detail_addr${status.index}" value="${addr.detailAddr}">

                                                    <input type="radio" name="delivery_list_item_btn" id="delivery_choice_${status.index}" onclick="changeDeliveryView(${status.index})"/>
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
                        </div>
                    </div>
                    <div id="tab1-2" class="tab_content">
                        <div class="tab_c_arti">
                            <!-- <p>123</p> -->
                            <!-- 배송지 직접 입력 폼 -->
                            <ul class="info_list_delivery info_style">
                                <!-- 이름 -->
                                <li class="list_item">
                                    <span class="list_item_label">이름</span>
                                    <div class="list_item_area">
                                        <input id="delivery_form_rcpr" type="text" oninput="changeDeliveryRcpr(this.value)"/>
                                    </div>
                                </li>
                                <!-- 주소 -->
                                <li class="list_item">
                                    <span class="list_item_label">주소</span>
                                    <div class="list_item_area">
                                        <input id="delivery_form_zpcd" type="text" readonly/><button type="button" id="searchAddressBtn">주소검색</button><br />
                                        <input id="delivery_form_main_addr" type="text" readonly/><br />
                                        <input id="delivery_form_detail_addr" type="text" oninput="changeDeliveryDetailAddr(this.value)" />
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
                                        <input id="delivery_form_mobile_num" type="text" inputmode="numeric" maxlength="11" oninput="changeDeliveryMobile(this.value)"/>
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
                                <option value="">배송 시 요청사항을 선택해주세요</option>
                                <option value="부재 시 경비실에 맡겨주세요" selected="selected">부재 시 경비실에 맡겨주세요</option>
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
                                    oninput="changeDeliveryMsg(this.value)"
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
                    <colgroup></colgroup>
                    <thead>
                    <tr>
                        <th scope="col">상품정보</th>
                        <th scope="col">수량</th>
                        <th scope="col">상품할인</th>
                        <th scope="col">배송그룹</th>
                        <th scope="col">배송비</th>
                        <th scope="col">주문금액</th>
                    </tr>
                    </thead>
                    <tbody>
                    <!--
                            주문상품정보
                                ##. 순번
                                #. 상품번호
                                #. 상품명
                                #. 상품가격
                                #. 수량
                                #. 옵션
                         -->
                    <c:forEach var="item" items="${basketItemDtoList}" varStatus="status">
                        <!-- 주문상품 정보 -->
                        <td class="orderDetail">
                            <!-- 전송용 태그 - 주문상품 -->
                            <input type="hidden" class="orderDetail_info" name="seq" value="${status.index}">
                            <input type="hidden" class="orderDetail_info" name="item_num" value="${item.num}">
                            <input type="hidden" class="orderDetail_info" name="item_name" value="${item.name}">
                            <input type="hidden" class="orderDetail_info" name="item_qty" value="${item.qty}">
                            <input type="hidden" class="orderDetail_info" name="price" value="${item.price}">
                            <input type="hidden" class="orderDetail_info" name="item_price" value="${(item.price) * (item.qty)}">
                            <input type="hidden" class="orderDetail_info" name="opt1" value="${item.opt1}">
                            <input type="hidden" class="orderDetail_info" name="opt2" value="${item.opt2}">
                            <input type="hidden" class="orderDetail_info" name="opt3" value="${item.opt3}">
                            <input type="hidden" class="orderDetail_info" name="opt4" value="${item.opt4}">
                            <input type="hidden" class="orderDetail_info" name="opt5" value="${item.opt5}">
                            <!--// 전송용 태그 - 주문상품 -->

                            <!-- 주문상품 이미지 -->
                            <div class="connect_img"></div>
                            <!-- 상품번호 -->
                            <div>${item.num}</div>
                            <!-- 상품명 -->
                            <div class="textLeft">${item.name}</div>
                            <!-- 옵션 -->
                            <div class="textLeft">옵션 : ${item.opt1}, ${item.opt2}</div>
                        </td>
                        <!-- 수량 -->
                        <td>${item.qty}</td>
                        <!-- 상품할인 -->
                        <td>${item.price}원</td>
                        <!-- 배송그룹 -->
                        <td>그룹1</td>
                        <!-- 배송비 -->
                        <td>0원</td>
                        <!-- 주문금액 -->
                        <td>${(item.price) * (item.qty)}원</td>
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
                        <td><span id="payment_view_totalPrice">${orderDto.total_price}</span>원</td>
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
                    <div class="checkable typography--p" style="padding-left: 25px">
                        <label for="coupon-box" class="checkable__label typography--regular"
                        ><input
                                id="coupon-box"
                                class="checkable__input"
                                type="checkbox"
                                aria-checked="true"
                                disabled
                        /><span class="checkable__label-text">5,000원 쿠폰 적용</span></label
                        >
                    </div>
                    <!-- 결제하기 버튼 -->
                    <button class="button" id="payment-button" style="margin-top: 30px" disabled>
                        결제하기
                    </button>
                </div>
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
        <button class="xBtn"><i class="fa-solid fa-xmark"></i></button>
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
                            <input type="radio" name="options" onclick="saveSelectedCoupon('${coupon.couponDto.name}', '${coupon.couponDto.minPayPrice}', '${coupon.couponDto.maxDiscPrice}', '${coupon.couponDto.prmo}', '${coupon.couponDto.discType}', '${coupon.custCouponsDto.seq}')"/>
                            <!-- 이 부분에 쿠폰명 또는 다른 정보를 출력할 수 있습니다. -->
                                ${coupon.couponDto.name}
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
        </div>
        <div>
            <button id="couponModalCancel">적용취소</button>
            <button id="couponModalSelect">쿠폰적용</button>
        </div>
    </div>
</div>
<script src="/js/jquery-3.6.4.min.js"></script>
<script src="/js/nav.js"></script>
<script src="/js/tab.js"></script>
<script src="/js/orderForm.js"></script>
<script src="//t1.daumcdn.net/mapjsapi/bundle/postcode/prod/postcode.v2.js"></script>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script>
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
        let order_info = $('.order_info');
        let orderInfo = inputTagToObj(order_info);

        let orderDetail_info = $('.orderDetail');
        let orderDetailInfo = inputTagToObjList(orderDetail_info);

        let delivery_info = $('.delivery_info');
        let deliveryInfo = inputTagToObj(delivery_info);

        let pay_info = $('.pay_info');
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
    var amount = $('#payment_view_totalPrice').text();
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
</script>
</body>
</html>