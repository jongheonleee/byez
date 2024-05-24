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
    <link rel="stylesheet" href="/css/ordEtcReq.css?after?after?after?after">
    <link rel="stylesheet" href="/css/footer.css?after?after">
    <link rel="stylesheet" href="/css/quick.css">
    <script src="https://kit.fontawesome.com/f0e73cfa04.js" crossorigin="anonymous"></script>
    <link rel="preconnect" href="https://fonts.googleapis.com">
    <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
    <link href="https://fonts.googleapis.com/css2?family=Noto+Sans+KR:wght@100..900&display=swap" rel="stylesheet">
</head>
<body>
<nav>
    <div class="wrapper">
        <div class="nav_logo">
            <a href="main.html">
                <img src="/img/logo3.png" alt="">
            </a>
        </div>
        <ul class="nav_menu">
            <li><a href="#">할인 상품</a></li>
            <li><a href="best.html">베스트</a></li>
            <li><a href="category.html">여성</a></li>
            <li><a href="category.html">남성</a></li>
            <li><a href="category.html">혼성</a></li>
        </ul>
        <ul class="nav_member">
            <li class="hover">
                <a href="#">
                    <img src="/img/top_mypage.png">
                </a>
                <!-- <ul class="sub_menu">
                    <li><a href="#">LOGIN</a>
                    </li>
                    <li><a href="#">ORDER</a>
                    </li>
                </ul> -->
                <ul class="sub_menu">
                    <li><a href="#">LOGOUT</a>
                    </li>
                    <li><a href="mypage.html">MYPAGE</a>
                    </li>
                    <li><a href="#">ORDER</a>
                    </li>
                </ul>
            </li>
            <li><a href="#"><img src="/img/top_search.png"></a></li>
            <li><a href="#"><img src="/img/top_wish.png"></a></li>
            <li><a href="#" class="cart_cnt">
                <img src="/img/top_cart_pc.png">
                <div>
                    <span>0</span>
                </div>
            </a></li>

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
                    <li>남성</li>

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
                    <li>혼성</li>

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
                고객님<br>무엇을 찾으시나요?
                <img src="/img/top_search_close.png" alt="">
            </p>
            <form action="">
                <input type="text" placeholder="상품을 찾아보세요">
                <button type="submit">
                    <i class="fa-solid fa-magnifying-glass"></i>
                </button>
            </form>
        </div>
    </div>
    <div class="shadow"></div>
</nav>
<section>
    <!--
        교환신청페이지
        교환을 한다.

        사전 정보
            1. 주문상품정보
            2. 배송지
            3. 상품 옵션

        교환 성공 조건
            1. 옵션 2가지 중 한가지는 변해야 한다.
            2. 교환 사유가 선택되어야 한다.
            3. 수거지 정보가 모두 입력 되어야 한다.
                3-1. 수거지 변경 선택 시 모든 값이 입력 되어야 한다.



        상품 옵션 변경




     -->
    <div class="wrapper">
        <div class="title">
            <p>
                <a href="main.html"><span>home</span></a>
                <span>></span>
                <a href="orderDetail.html"><span>주문내역</span></a>
            </p>
            <p>교환 신청</p>
        </div>
        <div class="mside">
            <div class="mside_wrapper">
                <p>마이페이지</p>
                <ul class="mside_content">
                    <li>
                        <ul>
                            <li>나의 쇼핑정보</li>
                            <li><a href="#">주문/배송</a></li>
                            <li><a href="#">취소/반품</a></li>
                        </ul>
                    </li>
                    <li>
                        <ul>
                            <li>나의 혜택 정보</li>
                            <li><a href="#">쿠폰</a></li>
                            <li><a href="#">혜택 보기</a></li>
                        </ul>
                    </li>
                    <li>
                        <ul>
                            <li>나의 활동 정보</li>
                            <li><a href="#">회원정보 수정</a></li>
                            <li><a href="#">배송 주소록 관리</a></li>
                            <li><a href="#">나의 게시물 관리</a></li>
                            <li><a href="#">나의 문의</a></li>
                            <li><a href="#">위시리스트</a></li>
                            <li><a href="#">최근 본 상품</a></li>
                            <li><a href="#">회원탈퇴</a></li>
                        </ul>
                    </li>
                </ul>
            </div>
        </div>
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
                    <td class="orderNum">
                        <p>${orderDetailDto.ord_date}</p>
                        <p>${orderDetailDto.ord_num}</p>
                    </td>
                    <td class="ordProductTitle">
                        <p> ${orderDetailDto.item_name} </p>
                        <p id ="originalOption">옵션: ${orderDetailDto.opt1}/${orderDetailDto.opt2}</p>
                        <div id = "changedOption" style ="display :  none;">
                            <span id="options"></span>
                        </div>
                        <button id="changeOptionBtn" type = "button">옵션변경</button>
                    </td>
                    <td>${orderDetailDto.item_qty}</td>
                    <td>${orderDetailDto.item_price}</td>
                    <td>${orderDetailDto.ord_state}</td>
                </tr>
            </table>

            <p class="table_title">교환사유
            </p>
            <table class="reason">
                <tr>
                    <td scope="col" class="reasonChoice">사유선택</td>
                    <td scope="col">
                        <select name="reason_code" id="reason">
                            <option  value="" selected="selected" >선택하세요</option>
                            <option value="CNS1">고객변심</option>
                            <option value="CNS2">서비스불만족</option>
                            <option value="CNS4">배송지기재오류</option>
                            <option value="SPL1">상품불량</option>
                            <option value="SPL3">발송오류</option>
                        </select>
                    </td>
                </tr>
                <tr>
                    <td>상세사유</td>
                    <td>
                        <textarea name="reason_detail" rows="4" cols="50"></textarea>
                    </td>
                </tr>
            </table>

            <p class="table_title">수거신청</p>
            <table>
                <tr>
                    <td class="pickup">수거신청여부</td>
                    <td class="pickupChoice">
                        <input type="radio" id="req" name="req_chk" value="Y" onclick="setPickUpCheck(this.value)"  checked="checked" >수거신청
                        <input type="radio" id="noReq" name="req_chk" value="N" onclick="setPickUpCheck(this.value)">직접발송
                        <p>수거신청 선택시 택배사에 연락하지 않으셔도 직접 수거요청을 드립니다.</p>
                    </td>
                </tr>
            </table>
            <div id="noRequestPickUp">
                <p class="table_title pickupAddressTable" >수거지 정보
                </p>
                <table class="pickupAddressTable">
                    <thead>
                    <tr>
                        <td class="pickupSpot">수거지 선택</td>
                        <td class="pickupSpotChoice">
                            <input type="radio" id="old_delivery" name="chg_chk" value="N" checked="checked">배송지정보와 동일
                            <input type="radio" id="new_delivery" name="chg_chk" value="Y">수거지 변경
                        </td>
                    </tr>
                    </thead>
                    <tbody id="currentAddress">
                        <tr>
                            <td>수거지 주소</td>

                            <input type="hidden" class="source_info" name="rcpr" value="${deliveryDto.rcpr}">
                            <input type="hidden" class="source_info" name="rcpr_mobile" value="${deliveryDto.rcpr_mobile}">
                            <input type="hidden" class="source_info" name="zpcd" value="${deliveryDto.zpcd}">
                            <input type="hidden" class="source_info" name="main_addr" value="${deliveryDto.main_addr}">
                            <input type="hidden" class="source_info" name="detail_addr" value="${deliveryDto.detail_addr}">

                            <td>
                                <p>${deliveryDto.rcpr}</p>
                                <p>
                                    (<span>${deliveryDto.zpcd}</span>)
                                    <span>${deliveryDto.main_addr}</span>
                                    <span>${deliveryDto.detail_addr}</span>
                                </p>
                                <p>${deliveryDto.rcpr_mobile}</p>
                            </td>
                        </tr>
                    </tbody>
                    <tbody id="newAddress" style="display: none;">
                    <tr>
                        <td>수거지 주소
                            <p style="color: #999999; font-size: 14px">
                                * 필수입력항목
                            </p>
                        </td>
                        <td class="addressText" >* 수령인<input type="text" name="new_rcpr" value="" oninput="setRcpr(this.value)" placeholder="한글만 입력해주세요.">
                            <p>
                                <span>* 우편번호 <button type="button" onclick="findZpcd_DaumPostcode()">우편번호 검색</button>
                                    <input type="text" name="new_zpcd" id="zpcdSearch" value=""   readonly></span>
                                <span>* 기본주소<input type="text" name="new_main_addr" id="mainAddr" value=""   readonly></span>
                                <span>* 상세주소<input type="text" name="new_detail_addr" id="detailAddr" value="" oninput="setDetailAddr(this.value)" placeholder="상세주소를 정확히 입력해주세요."></span>
                            </p>
                            <p>* 휴대폰번호<input type="text" name="new_rcpr_mobile" value="" oninput="setRcprMobile(this.value)" placeholder="010-0000-0000"></p>
                        </td>
                    </tr>
                    </tbody>
                </table>

                <p class="table_title">교환배송비 결제
                </p>
                <table>
                    <tr>
                        <td class="dlvCost">교환배송비</td>
                        <td>
                            <div class="shippingCharge">
                                <span id="shippingCost"></span>
                            </div>
                        </td>
                    </tr>
                </table>
            </div>

            <div id="buttons">
                <button id="exchangeBtn">교환 신청</button>
                <button type="button" class="back" >이전 페이지</button>
            </div>
        </div>
    </div>
    <div id="modal" class="dialog" style = "display:none">
        <div class="tb">
            <div class="inner" style="max-width:800px;">
                <div class="top">
                    <div class="title">옵션변경</div>
                    <a href="#" id="XBtn" class="close">X</a>
                </div>
                <div class="ct">
                    <input type="hidden" class="source_info" name="color" value="${orderDetailDto.opt1}">
                    <input type="hidden" class="source_info" name="size" value="${orderDetailDto.opt2}">
                    상품명
                    [옵션 : ${orderDetailDto.opt1}/${orderDetailDto.opt2}]
                    <br>
                    상품옵션
                    Color
                    <select name ="color" id="color">
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
                    <input type = button  id="change" value = "변경하기">
                </div>
            </div>
        </div>
    </div>

    <form id="submitForm" action="/exchangeOrder" method="post">
        // 상품 정보
        <input type="hidden" class="item_info" name="ord_num" value="${ord_num}">
        <input type="hidden" class="item_info" name="seq" value="${orderDetailDto.seq}">
        <input type="hidden" class="item_info" name="opt1" value="">
        <input type="hidden" class="item_info" name="opt2" value="">
        <input type="hidden" class="item_info" name="type_code" value="E">
        <input type="hidden" class="item_info" name="state_code" value="EXC1">
        <input type="hidden" class="item_info" name="ord_state" value="교환신청">

        // 기타 정보
        <input type="hidden" class="etc_info" name="reason_code" value="">
        <input type="hidden" class="etc_info" name="pickup_chk" value="Y">
        <input type="hidden" class="etc_info" name="chg_check" value="Y">

        // 배송지 정보
        <input type="hidden" class="delivery_info" name="rcpr" value="${deliveryDto.rcpr}">
        <input type="hidden" class="delivery_info" name="rcpr_mobile" value="${deliveryDto.rcpr_mobile}">
        <input type="hidden" class="delivery_info" name="zpcd" value="${deliveryDto.zpcd}">
        <input type="hidden" class="delivery_info" name="main_addr" value="${deliveryDto.main_addr}">
        <input type="hidden" class="delivery_info" name="detail_addr" value="${deliveryDto.detail_addr}">
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
<script src="//t1.daumcdn.net/mapjsapi/bundle/postcode/prod/postcode.v2.js"></script>
<script>
    // 모달창 출력
    function openModal(){
        $('#modal').show();
    }

    // 모달창 닫기
    function closeModal(){
        $('#modal').hide();
    }

    // 옵션 변경
    function changeOption(){
        let color = getOption().color;
        let size = getOption().size;
        let str = '옵션: ' + color + '/' + size;

        // 2개의 옵션 중 한개도 변한게 없으면
        if(!valitateSelectOption()){
            // 옵션 변경 요청
            return alert('옵션을 변경해주세요');
        }
        // 옵션 변경 - 보이는 부분
        $('#originalOption').html(str);
        // 전송용 데이터 변경 - 색상, 사이즈
        setOption(color, size);
        // 모달창 닫기
        closeModal();
    }

    function getOption(){
        return {color:$('#color').val(), size:$('#size').val()};
    }

    // 기존의 옵션과 동일한지 비교
    function valitateSelectOption(){
        let selectColor = getOption().color;
        let selectSize = getOption().size;

        const sourceColor = $('input[name=color].source_info').val();
        const sourceSize = $('input[name=size].source_info').val();

        // 두 옵션이 모두 같으면 true
        // 선택한 옵션이 기존의 옵션과 하나라도 다르거나
        // 선택한 옵션이 2개의 옵션 모두 공백이 아니어야 true
        return ((sourceColor !== selectColor) || (sourceSize !== selectSize)) || ((selectColor !== "") && (selectSize !== ""));
    }

    // 사유를 선택하지 않으면 true
    function isNotSelectReason(){
        return ($('#reason').val().length === 0);
    }

    // 직접발송 선택 시 수거지 정보 숨기기
    function hidePickUpOriginalInfo(){
        $('#noRequestPickUp').hide();
    }

    // 수거신청 선택 시 수거지 정보 보이기
    function showPickUpOriginalInfo(){
        $('#noRequestPickUp').show();
    }

    // 수거지 변경 선택 시 직접 입력 폼 출력
    function showNewAddressForm(){
        $('#currentAddress').hide();
        $('#newAddress').show();
    }

    // 기존배송지 선택 시 직접 입력 폼 숨김
    function hideNewAddressForm(){
        $('#newAddress').hide();
        $('#currentAddress').show();
    }



    // 전송용 데이터 변경 - 옵션
    function setOption(color, size){
        $('input[name=opt1].item_info').val(color);
        $('input[name=opt2].item_info').val(size);
    }

    // 전송용 데이터 변경 - 사유코드
    function setReasonCode(){
        $('input[name=reason_code].etc_info').val($('#reason').val());
    }

    // 전송용 데이터 변경 - 수거지 신청 여부
    function setPickUpCheck(v){
        $('input[name=pickup_chk].etc_info').val(v);
    }

    // 전송용 데이터 변경 - 수거지 선택 여부
    function setChgCheck(v){
        $('input[name=chg_check].etc_info').val(v);
    }

    // 전송용 데이터 변경 - 수령인
    function setRcpr(v){
        $('input[name=rcpr].delivery_info').val(v);
    }

    // 전송용 데이터 변경 - 수령인 전화번호
    function setRcprMobile(v){
        $('input[name=rcpr_mobile].delivery_info').val(v);
    }

    // 전송용 데이터 변경 - 수거지 우편번호
    function setZpcd(v){
        $('input[name=zpcd].delivery_info').val(v);
    }

    // 전송용 데이터 변경 - 수거지 기본주소
    function setMainAddr(v){
        $('input[name=main_addr].delivery_info').val(v);
    }

    // 전송용 데이터 변경 - 수거지 상세주소
    function setDetailAddr(v){
        $('input[name=detail_addr].delivery_info').val(v);
    }


    // 이벤트 연결
    // 모달창 띄우기
    $('#changeOptionBtn').on('click', openModal);
    // 모달창 닫기
    $('#XBtn').on('click', closeModal);
    // 옵션 변경하기 (보이는 부분)
    $('#change').on('click', changeOption);
    // 배송지 기존 배송지 버튼 선택 시
    $('input[type=radio]#old_delivery').on('click', function (v){
        setChgCheck(v);
        $('input[name=rcpr].delivery_info').val($('input[name=rcpr].source_info').val());
        $('input[name=rcpr_mobile].delivery_info').val($('input[name=rcpr_mobile].source_info').val());
        $('input[name=zpcd].delivery_info').val($('input[name=zpcd].source_info').val());
        $('input[name=main_addr].delivery_info').val($('input[name=main_addr].source_info').val());
        $('input[name=detail_addr].delivery_info').val($('input[name=detail_addr].source_info').val());
    });

    // 교환사유 옵션 변경 시
    $('#reason').on('change', setReasonCode);

    // 수거신청을 직접발송으로 변경 시
    $('#noReq').on('click', hidePickUpOriginalInfo);

    // 수거신청을 수거신청으로 변경 시
    $('#req').on('click', showPickUpOriginalInfo);

    // 수거지 변경 선택 시 직접 입력 폼 출력
    $('#new_delivery').on('click', showNewAddressForm);

    // 기존배송지 선택 시 직접 입력 폼 숨김
    $('#old_delivery').on('click', hideNewAddressForm);

    // 교환신청 버튼 클릭 시 교환 사유 선택되어있는지 확인
    $('#exchangeBtn').on('click', function (){
        // 만약 옵션 선택을 안하면
        if(!valitateSelectOption()){
            // 옵션 변경 요청
            return alert('옵션을 변경해주세요');
        }

        // 사유가 선택되지 않으면
        if (isNotSelectReason()){
            // 메시지 출력
            return alert('사유가 선택 되지 않았습니다.')
        }
        // 확인창 출력
        let exchangeConfirm = confirm('교환 신청하시겠습니까?');
        // 취소 시
        if (!exchangeConfirm){
            // 이동 X
            return false;
        }
        // 요청 제출
        $('#submitForm').submit();
    });



    // 주소검색 API
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
                document.getElementById('zpcdSearch').value = data.zonecode;
                document.getElementById("mainAddr").value = addr;
                setZpcd(data.zonecode);
                setMainAddr(addr)

                // 커서를 상세주소 필드로 이동한다.
                document.getElementById("detailAddr").focus();
            }
        }).open();
    }

</script>

</body>
</html>
