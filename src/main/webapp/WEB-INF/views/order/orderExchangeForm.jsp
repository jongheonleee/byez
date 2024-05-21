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
    <link rel="stylesheet" href="/css/footer.css">
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
    <form action="<c:url value="/exchangeOrder"/>" method="post">

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
<%--                            ${orderDetailDto.item_name} - <span id="options"></span>--%>
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
                        <textarea name="reason_detail" rows="4" cols="50">${OrdEtcReqDto.reason_detail}</textarea>
                    </td>
                </tr>
            </table>

            <p class="table_title">수거신청
            </p>
            <table>
                <tr>
                    <td class="pickup">수거신청여부</td>
                    <td class="pickupChoice">
                        <input type="radio" id ="req" name="req_chk" value="Y" checked="checked">수거신청
                        <input type="radio" id="noReq"  name="req_chk" value="N">직접발송
                        <p>수거신청 선택시 택배사에 연락하지 않으셔도 직접 수거요청을 드립니다.</p>
                    </td>
                </tr>
            </table>

            <p class="table_title pickupAddressTable" >수거지 정보
            </p>
            <table class="pickupAddressTable">
                <thead>
                <tr>
                    <td class="pickupSpot">수거지 선택</td>
                    <td class="pickupSpotChoice">
                        <input type="radio" name="chg_chk" value="N" checked="checked" onclick="toggleAddressFields()">배송지정보와 동일
                        <input type="radio" name="chg_chk" value="Y" onclick="toggleAddressFields()">수거지 변경
                    </td>
                </tr>
                </thead>
                <tbody id="currentAddress">
                <tr>
                    <td>수거지 주소</td>
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
                    <td class="addressText" >* 수령인<input type="text" name="new_rcpr" value="" oninput="checkRcpr()" placeholder="한글만 입력해주세요.">
                        <p>
                            <span>* 우편번호 <button type="button" onclick="findZpcd_DaumPostcode()">우편번호 검색</button>
                                <input type="text" name="new_zpcd" id="zpcdSearch" value=""   readonly></span>
                            <span>* 기본주소<input type="text" name="new_main_addr" id="mainAddr" value=""   readonly></span>
                            <span>* 상세주소<input type="text" name="new_detail_addr" id="detailAddr" value="" placeholder="상세주소를 정확히 입력해주세요."></span>
                        </p>
                        <p>* 휴대폰번호<input type="text" name="new_rcpr_mobile" value="" onblur="checkRcprMobile()" placeholder="010-0000-0000"></p>
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
            <div id="buttons">
                <button id="exchangeBtn">교환 신청</button>
                <button type="button" class="back" onClick="goBack()">이전 페이지</button>
            </div>
        </div>
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
<%--    <input type="submit" id="exchangeBtn" value="교환신청">--%>
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
                <input type = button  id="change" value = "변경하기" onclick="changeOptionVisibility()">
            </div>
        </div>
    </div>
</div>
<script src="/js/jquery-3.6.4.min.js"></script>
<script src="/js/nav.js"></script>
<script src="//t1.daumcdn.net/mapjsapi/bundle/postcode/prod/postcode.v2.js"></script>
<script>
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
                document.getElementById("mainAddr").value = addr;;

                // 커서를 상세주소 필드로 이동한다.
                document.getElementById("detailAddr").focus();
            }
        }).open();
    }
</script>

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
            let originalColor = '${orderDetailDto.opt1}';
            let originalSize = '${orderDetailDto.opt2}';
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
        const pickupAddressTable = document.querySelectorAll('.pickupAddressTable');
        pickupAddressTable.forEach(section => section.style.display = isSelfShipping ? 'none' : 'block');

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
        var originalOption = document.getElementById('originalOption');
        var changedOption = document.getElementById('changedOption');
        var selectedColor = '';
        var selectedSize = '';

        selectedColor = document.getElementById('color').value;
        selectedSize = document.getElementById('size').value;
        var displayDiv = document.getElementById('options');

        document.querySelector('input[name="opt1"]').value = selectedColor;
        document.querySelector('input[name="opt2"]').value = selectedSize;

        displayDiv.innerHTML = "옵션: " + selectedColor + "/" + selectedSize;

        // 변경된 옵션을 보이게 하고, 원래 옵션을 숨긴다.
        changedOption.style.display = 'block'; // changedOption을 보이게 함
        originalOption.style.display = 'none'; // originalOption을 숨김
    }

    // 문서 로딩 완료 후에 이벤트 리스너를 설정
    document.addEventListener("DOMContentLoaded", function() {
        // 'req_chk' 이름을 가진 모든 라디오 버튼에 대해 이벤트 리스너를 추가
        document.querySelectorAll('input[name="req_chk"]').forEach(function(element) {
            element.addEventListener('change', updateShippingCost);
        });
    });

    // 교환사유에 따른 배송비 업데이트
    function updateShippingCost() {
        const reasonCode = document.getElementById('reason').value;
        const shippingCostField = document.getElementById('shippingCost');
        const noReqChecked = document.getElementById('noReq').checked;

        if (noReqChecked) {
            shippingCostField.textContent = "개별 안내 드리겠습니다.";
        }else if (reasonCode === 'CNS1' || reasonCode === 'CNS2' || reasonCode === 'CNS4') {
            shippingCostField.textContent = '5000원';
        }else if(reasonCode === 'SPL1' ||  reasonCode === 'SPL3') {
            shippingCostField.textContent = '0원';
        }else
            shippingCostField.textContent = '교환사유를 선택하면 교환배송비를 확인할 수 있습니다.';
    }

    //TODO 수거지 변경 시 수거지 입력 유효성 검증
    function checkRcpr() {
        // 수거신청인 입력값 유효성 검증
        // 한글만 가능
        let inputField = document.querySelector('input[name="new_rcpr"]');
        let name = inputField.value;
        let pattern = new RegExp('^[\s,ㄱ-ㅎ가-힣]+$');

        if (name.length > 0 && !name.match(pattern)) {
            alert("이름은 한글만 입력 가능합니다.");
            inputField.value = "";
            return false;
        }
        return true;
    }

    //배송지 우편번호 검색기능을 추가하여 더이상 사용하지 않음
    //엔터키 입력후 얼럿창이 무한으로 반복되는 에러 있음
    function checkZpcd() {
        // 우편번호 입력값 유효성 검증
        // 5자리 숫자만 가능
        let inputField = document.querySelector('input[name="new_zpcd"]');
        let zipcode = inputField.value;
        let pattern = new RegExp('^[0-9]{5}$'); // 5자리 숫자만 매칭

        if (!pattern.test(zipcode)) {
            alert("우편번호는 5자리 숫자만 입력 가능합니다.");
            inputField.value = ""; // 입력 필드 초기화
            return false;
        }
        return true;
    }

    function checkRcprMobile() {
        var inputField = document.querySelector('input[name="new_rcpr_mobile"]');
        var mobileNumber = inputField.value;
        // 정규 표현식을 사용하여 숫자와 하이픈만 포함하고, 올바른 형식인지 검사합니다.
        // 예: "010-1234-5678" - 여기서는 일반적인 한국의 휴대폰 번호 형식을 사용합니다.
        var pattern = /^(\d{3}-\d{3,4}-\d{4})$/;

        if (!pattern.test(mobileNumber)) {
            alert("휴대폰 번호는 010-0000-0000의 형식으로 숫자와 '-'만 사용 가능합니다.");
            inputField.value = "";
            return false;
        }
        return true;
    }

    //엔터키 입력시 폼제출이 되는것을 방지한다.
    //엔터키를 아예 비활성화 하는것도 가능하다고 함
    document.addEventListener("DOMContentLoaded", function() {
        const form = document.querySelector('form');
        form.onsubmit = function(event) {
            // 필요한 모든 필드가 채워졌는지 검사
            if (!validateFields()) {
                alert("모든 필드를 채워주세요.");
                event.preventDefault(); // 폼 제출 방지
            }
        };

        // 각 입력 필드에 keydown 이벤트 리스너 추가
        //이해필요..
        document.querySelectorAll('input[type="text"]').forEach(input => {
            input.addEventListener('keydown', preventFormSubmitOnEnter);
        });
    });

    function preventFormSubmitOnEnter(event) {
        if (event.keyCode === 13) {
            event.preventDefault(); // 기본 동작 방지
            alert("엔터키로는 폼을 제출할 수 없습니다.");
        }
    }

    function validateFields() {
        // 모든 필수 입력 필드를 검사하고, 모두 채워졌는지 여부를 반환
        let isValid = true;
        document.querySelectorAll('.required').forEach(input => {
            if (!input.value.trim()) isValid = false;
        });
        return isValid;
    }

    //교환신청버튼 클릭
    document.addEventListener("DOMContentLoaded", function() {
        document.getElementById("exchangeBtn").onclick = function() {
            let form = $('form');
            let chg_chk = form.find('input[name="chg_chk"]:checked').val();
            let noReqChecked = document.getElementById("noReq").checked;

            let new_rcpr = form.find('input[name="new_rcpr"]').val().trim();
            let new_zpcd = form.find('input[name="new_zpcd"]').val().trim();
            let new_main_addr = form.find('input[name="new_main_addr"]').val().trim();
            let new_detail_addr = form.find('input[name="new_detail_addr"]').val().trim();
            let new_rcpr_mobile = form.find('input[name="new_rcpr_mobile"]').val().trim();

            //수거지 정보테이블에 빈값이 있지 않은지 유효성검사
            if(chg_chk === "Y"  && !noReqChecked && (new_rcpr === ""  || new_zpcd ===""  || new_main_addr === "" || new_detail_addr === "" || new_rcpr_mobile === "")  ){
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

            if(selectedColor === "" && selectedSize === ""){
                alert("옵션을 변경해주세요")
                return false;
            }

            let originalColor = '${orderDetailDto.opt1}';
            let originalSize = '${orderDetailDto.opt2}';
            if((selectedColor === "" || selectedSize === "" ) || selectedColor === originalColor  && selectedSize === originalSize ){
                alert("옵션을 선택해주세요");
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

    //이전페이지 클릭
    function goBack() {
        window.location.href = '/order/list'
    }

</script>
</body>
</html>
