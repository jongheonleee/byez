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
    <link rel="stylesheet" href="/css/orderDetail.css?after?after?after">
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
            <a href="/">
                <img src="/img/logo3.png" alt="">
            </a>
        </div>
        <ul class="nav_menu">
            <li><a href="/item/categories/discount">할인 상품</a></li>
            <li><a href="/item/categories/best">베스트</a></li>
            <li><a href="/item/categories/02">여성</a></li>
            <li><a href="/item/categories/01">남성</a></li>
            <li><a href="/item/categories/03">혼성</a></li>
        </ul>
        <ul class="nav_member">
            <li class="hover">
                <a href="#">
                    <img src="/img/top_mypage.png">
                </a>
                <ul class="sub_menu">
                    <li><a href="/logout">LOGOUT</a>
                    </li>
                    <li><a href="mypage.html">MYPAGE</a>
                    </li>
                    <li><a href="/order">ORDER</a>
                    </li>
                </ul>
            </li>
            <li><a><img src="/img/top_search.png"></a></li>
            <li><a href="/like"><img src="/img/top_wish.png"></a></li>
            <li><a href="/basket" class="cart_cnt">
                <img src="/img/top_cart_pc.png">
                <div>
                    <span>${cnt}</span>
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
                    <li><a href="category">상의</a></li>
                    <li><a href="category">맨투맨/스웨트셔츠</a></li>
                    <li><a href="category">후드/집업</a></li>
                    <li><a href="category">니트/스웨터</a></li>
                    <li><a href="category">셔츠/블라우스</a></li>
                    <li><a href="category">긴팔 티셔츠</a></li>
                    <li><a href="category">반팔 티셔츠</a></li>
                    <li><a href="category">슬리브리스</a></li>
                </ul>
            </li>
            <li>
                <ul>
                    <li><a href="category">아우터</a></li>
                    <li><a href="category">패딩/다운</a></li>
                    <li><a href="category">폴리스/덤블</a></li>
                    <li><a href="category">자켓/점퍼</a></li>
                    <li><a href="category">블레이저</a></li>
                    <li><a href="category">가디건</a></li>
                    <li><a href="category">바람막이</a></li>
                </ul>
            </li>
            <li>
                <ul>
                    <li><a href="category">슬랙스</a></li>
                    <li><a href="category">트레이닝/스웨트셔츠</a></li>
                    <li><a href="category">팬츠</a></li>
                    <li><a href="category">숏츠</a></li>
                    <li><a href="category">스커트</a></li>
                </ul>
            </li>
            <li>
                <ul>
                    <li><a href="category">신발</a></li>
                    <li><a href="category">운동화</a></li>
                    <li><a href="category">구두</a></li>
                    <li><a href="category">로퍼</a></li>
                    <li><a href="category">힐</a></li>
                    <li><a href="category">부츠</a></li>
                    <li><a href="category">슬리퍼</a></li>
                    <li><a href="category">샌달</a></li>
                </ul>
            </li>
            <li>
                <ul>
                    <li><a href="category">기타</a></li>
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
                    <li><a href="/item/category/0101">상의</a></li>
                    <li><a href="/item/category/010101">맨투맨/스웨트셔츠</a></li>
                    <li><a href="/item/category/010102">후드/집업</a></li>
                    <li><a href="/item/category/010103">니트/스웨터</a></li>
                    <li><a href="/item/category/010104">셔츠/블라우스</a></li>
                    <li><a href="/item/category/010105">긴팔 티셔츠</a></li>
                    <li><a href="/item/category/010106">반팔 티셔츠</a></li>
                    <li><a href="/item/category/010107">슬리브리스</a></li>
                </ul>
            </li>
            <li>
                <ul>
                    <li><a href="/item/category/0102">아우터</a></li>
                    <li><a href="/item/category/010201">패딩/다운</a></li>
                    <li><a href="/item/category/010202">폴리스/덤블</a></li>
                    <li><a href="/item/category/010203">자켓/점퍼</a></li>
                    <li><a href="/item/category/010204">블레이저</a></li>
                    <li><a href="/item/category/010205">가디건</a></li>
                    <li><a href="/item/category/010206">바람막이</a></li>
                </ul>
            </li>
            <li>
                <ul>
                    <li><a href="/item/category/0103">하의</a></li>
                    <li><a href="/item/category/010301">슬랙스</a></li>
                    <li><a href="/item/category/010302">트레이닝/스웨트셔츠</a></li>
                    <li><a href="/item/category/010303">팬츠</a></li>
                    <li><a href="/item/category/010304">숏츠</a></li>
                </ul>
            </li>
            <li>
                <ul>
                    <li><a href="/item/category/0104">신발</a></li>
                    <li><a href="/item/category/040101">운동화</a></li>
                    <li><a href="/item/category/040102">구두</a></li>
                    <li><a href="/item/category/040103">로퍼</a></li>
                    <li><a href="/item/category/040104">힐</a></li>
                    <li><a href="/item/category/040105">부츠</a></li>
                    <li><a href="/item/category/040106">슬리퍼</a></li>
                    <li><a href="/item/category/040107">샌달</a></li>
                </ul>
            </li>
            <li>
                <ul>
                    <li><a href="/item/category/99">기타</a></li>
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
                    <li><a href="/item/category/0301">상의</a></li>
                    <li><a href="/item/category/030101">맨투맨/스웨트셔츠</a></li>
                    <li><a href="/item/category/030102">후드/집업</a></li>
                    <li><a href="/item/category/030103">니트/스웨터</a></li>
                    <li><a href="/item/category/030104">셔츠/블라우스</a></li>
                    <li><a href="/item/category/030105">긴팔 티셔츠</a></li>
                    <li><a href="/item/category/030106">반팔 티셔츠</a></li>
                    <li><a href="/item/category/030107">슬리브리스</a></li>
                </ul>
            </li>
            <li>
                <ul>
                    <li><a href="/item/category/0302">아우터</a></li>
                    <li><a href="/item/category/030201">패딩/다운</a></li>
                    <li><a href="/item/category/030202">폴리스/덤블</a></li>
                    <li><a href="/item/category/030203">자켓/점퍼</a></li>
                    <li><a href="/item/category/030204">블레이저</a></li>
                    <li><a href="/item/category/030205">가디건</a></li>
                    <li><a href="/item/category/030206">바람막이</a></li>
                </ul>
            </li>
            <li>
                <ul>
                    <li><a href="/item/category/0303">하의</a></li>
                    <li><a href="/item/category/030301">슬랙스</a></li>
                    <li><a href="/item/category/030302">트레이닝/스웨트셔츠</a></li>
                    <li><a href="/item/category/030303">팬츠</a></li>
                    <li><a href="/item/category/030304">숏츠</a></li>
                </ul>
            </li>
            <li>
                <ul>
                    <li><a href="/item/category/0304">신발</a></li>
                    <li><a href="/item/category/030401">운동화</a></li>
                    <li><a href="/item/category/030402">구두</a></li>
                    <li><a href="/item/category/030403">로퍼</a></li>
                    <li><a href="/item/category/030404">힐</a></li>
                    <li><a href="/item/category/030405">부츠</a></li>
                    <li><a href="/item/category/030406">슬리퍼</a></li>
                    <li><a href="/item/category/030407">샌달</a></li>
                </ul>
            </li>
            <li>
                <ul>
                    <li><a href="category/99">기타</a></li>
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
    <div class="wrapper">
        <div class="title">
            <p>
                <a href="main.html"><span>home</span></a>
                <span>></span>
                <a href="mypage.html"><span>마이페이지</span></a>
            </p>
            <p>주문조회</p>
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
            <ul class="tab_menu">
                <li><a href="#tab1-1">주문내역조회</a></li>
                <li><a href="#tab1-2">취소/반품/교환내역</a></li>
                <li><a href="#tab1-3">과거주문내역</a></li>
            </ul>
            <!-- 탭 콘텐츠 -->
            <div class="≈">
                <div id="tab1-1" class="tab_content">
                    <div class="tab_c_arti">
                        <fieldset class="search">
                            <select id="order_status" name="order_status" class="fSelect uniform-height">
                                <option value="all">전체 주문처리상태</option>
                                <option value="shipped_before">입금전</option>
                                <option value="shipped_standby">배송준비중</option>
                                <option value="shipped_begin">배송중</option>
                                <option value="shipped_complate">배송완료</option>
                                <option value="order_cancel">취소</option>
                                <option value="order_exchange">교환</option>
                                <option value="order_return">반품</option>
                            </select>
                            <span class="period">
                                        <a href="#none" class="btnNormal uniform-height" days="00"><img src="//img.echosting.cafe24.com/skin/base_ko_KR/myshop/btn_date1.gif" offimage="//img.echosting.cafe24.com/skin/base_ko_KR/myshop/btn_date1.gif" onimage="//img.echosting.cafe24.com/skin/base_ko_KR/myshop/btn_date1_on.gif" alt="오늘"></a>
                                        <a href="#none" class="btnNormal uniform-height" days="07"><img src="//img.echosting.cafe24.com/skin/base_ko_KR/myshop/btn_date2.gif" offimage="//img.echosting.cafe24.com/skin/base_ko_KR/myshop/btn_date2.gif" onimage="//img.echosting.cafe24.com/skin/base_ko_KR/myshop/btn_date2_on.gif" alt="1주일"></a>
                                        <a href="#none" class="btnNormal uniform-height" days="30"><img src="//img.echosting.cafe24.com/skin/base_ko_KR/myshop/btn_date3.gif" offimage="//img.echosting.cafe24.com/skin/base_ko_KR/myshop/btn_date3.gif" onimage="//img.echosting.cafe24.com/skin/base_ko_KR/myshop/btn_date3_on.gif" alt="1개월"></a>
                                        <a href="#none" class="btnNormal uniform-height" days="90"><img src="//img.echosting.cafe24.com/skin/base_ko_KR/myshop/btn_date4.gif" offimage="//img.echosting.cafe24.com/skin/base_ko_KR/myshop/btn_date4.gif" onimage="//img.echosting.cafe24.com/skin/base_ko_KR/myshop/btn_date4_on.gif" alt="3개월"></a>
                                        <a href="#none" class="btnNormal uniform-height" days="180"><img src="//img.echosting.cafe24.com/skin/base_ko_KR/myshop/btn_date5.gif" offimage="//img.echosting.cafe24.com/skin/base_ko_KR/myshop/btn_date5.gif" onimage="//img.echosting.cafe24.com/skin/base_ko_KR/myshop/btn_date5_on.gif" alt="6개월"></a>
                                    </span>
                            <label for="date1" class="uniform-height">
                                <input type="date"
                                       id="date1"
                                       class="date-input"
                                       max="2077-06-20"
                                       min="2077-06-05"
                                       value="2077-06-15">
                            </label>

                            ~
                            <label for="date2" class="uniform-height">
                                <input type="date"
                                       id="date2"
                                       class="date-input"
                                       max="2077-06-20"
                                       min="2077-06-05"
                                       value="2077-06-15">
                            </label>
                            <input alt="조회"  class= "uniform-height" type="image" src="//img.echosting.cafe24.com/skin/admin_ko_KR/myshop/btn_search.gif">
                        </fieldset>
                        <div class="info">
                            <ul>
                                <li>-기본적으로 최근 3개월간의 자료가 조회되며, 기간 검색시 주문처리완료 후 36개월 이내의 주문내역을 조회하실 수 있습니다.</li>
                                <li>-완료 후 36개월 이상 경과한 주문은 [과거주문내역]에서 확인할 수 있습니다.</li>
                                <li>-주문번호를 클릭하시면 해당 주문에 대한 상세내역을 확인하실 수 있습니다.</li>
                                <li>-취소/교환/반품 신청은 배송완료일 기준 7일까지 가능합니다.</li>
                            </ul>
                        </div>

                        <div class="product-title">
                            <p>주문상품내역</p>
                        </div>
                        <table class="product">
                            <thead>
                            <tr>
                                <th scope="col">주문일자</th>
                                <th scope="col">상품명</th>
                                <th scope="col">수량</th>
                                <th scope="col">주문금액</th>
                                <th scope="col">주문상태</th>
                            </tr>
                            </thead>

                            <tbody>
                            <c:forEach var="orderDetailDto" items="${list}">
                            <tr>
                                <td class="number order_actions">
                                        ${orderDetailDto.ord_date}
                                            <input type="hidden" name="ord_date" value="${orderDetailDto.ord_date}">
                                    <p>
<%--                                        <a href="#">${orderDetailDto.ord_num}</a>--%>
                                        ${orderDetailDto.ord_num}
                                    </p>
                                                <%-- 주문취소버튼--%>
                                            <form action = "/cancel" method="post" class="form_center">
                                                <input type="hidden" name="ord_num" value="${orderDetailDto.ord_num}">
                                                <c:if test="${orderDetailDto.ord_state == '주문완료'  }">
                                                    <input type="submit" class="cancel_button" value="취소">
                                                </c:if>
                                            </form>
                                                <%-- 주문반품버튼--%>
                                            <form action = "/refund" method="post" class="form_center">
                                                <input type="hidden" name="ord_num" value="${orderDetailDto.ord_num}">
                                                <c:if test="${orderDetailDto.ord_state == '배송완료' || '배송중'|| '교환완료'  }">
                                                    <input type="submit" class="refund_button" value="반품">
                                                </c:if>
                                            </form>
                                                <%-- 주문교환버튼--%>
                                            <form action = "/exchange" method="post" class="form_center">
                                                <input type="hidden" name="seq" value="${orderDetailDto.seq}">
                                                <input type="hidden" name="ord_num" value="${orderDetailDto.ord_num}">
                                                <input type="hidden" name="item_num" value="${orderDetailDto.item_num}">
                                                <input type="hidden" name="opt1" value="${orderDetailDto.opt1}">
                                                <input type="hidden" name="opt2" value="${orderDetailDto.opt2}">
                                                <c:if test="${orderDetailDto.ord_state == '배송완료' || '배송중'|| '교환완료'  }">
                                                    <input type="submit" class="exchange_button" value="교환">
                                                </c:if>
                                            </form>
                                </td>
                                <td>${orderDetailDto.item_name}
                                    <p>
                                        옵션 : ${orderDetailDto.opt1}/${orderDetailDto.opt2}
                                    </p>
                                </td>
                                <td>${orderDetailDto.item_qty}</td>
                                <td>${orderDetailDto.item_price}</td>
                                <td class="order_actions">
                                    <div>${orderDetailDto.ord_state}</div>
                                    <form action = "/confirmPurchase" method = "post" class="form_center">
                                            <%--           hidden타입의 주문상태를 담아둔다--%>
                                        <input type="hidden" name="ord_num" value="${orderDetailDto.ord_num}">
                                        <c:if test="${orderDetailDto.ord_state == '배송완료' || '교환완료'  }">
                                            <div>
                                            <input type="submit" id="confirm_button" value="구매확정">
                                            <input type = "hidden" name="ord_state" value="구매확정">
                                            <input type = "hidden" name="state_code" value="CPS">
                                            </div>
                                        </c:if>
                                    </form>
                                </td>
                            </tr>
                            </c:forEach>
                            </tbody>
                        </table>
                    </div>
                </div>
            </div>
            <div id="tab1-2" class="tab_content">
                <div class="tab_c_arti">
                    <fieldset class="search">
                                    <span class="period">
                                        <a href="#none" class="btnNormal uniform-height" days="00"><img src="//img.echosting.cafe24.com/skin/base_ko_KR/myshop/btn_date1.gif" offimage="//img.echosting.cafe24.com/skin/base_ko_KR/myshop/btn_date1.gif" onimage="//img.echosting.cafe24.com/skin/base_ko_KR/myshop/btn_date1_on.gif" alt="오늘"></a>
                                        <a href="#none" class="btnNormal uniform-height" days="07"><img src="//img.echosting.cafe24.com/skin/base_ko_KR/myshop/btn_date2.gif" offimage="//img.echosting.cafe24.com/skin/base_ko_KR/myshop/btn_date2.gif" onimage="//img.echosting.cafe24.com/skin/base_ko_KR/myshop/btn_date2_on.gif" alt="1주일"></a>
                                        <a href="#none" class="btnNormal uniform-height" days="30"><img src="//img.echosting.cafe24.com/skin/base_ko_KR/myshop/btn_date3.gif" offimage="//img.echosting.cafe24.com/skin/base_ko_KR/myshop/btn_date3.gif" onimage="//img.echosting.cafe24.com/skin/base_ko_KR/myshop/btn_date3_on.gif" alt="1개월"></a>
                                        <a href="#none" class="btnNormal uniform-height" days="90"><img src="//img.echosting.cafe24.com/skin/base_ko_KR/myshop/btn_date4.gif" offimage="//img.echosting.cafe24.com/skin/base_ko_KR/myshop/btn_date4.gif" onimage="//img.echosting.cafe24.com/skin/base_ko_KR/myshop/btn_date4_on.gif" alt="3개월"></a>
                                        <a href="#none" class="btnNormal uniform-height" days="180"><img src="//img.echosting.cafe24.com/skin/base_ko_KR/myshop/btn_date5.gif" offimage="//img.echosting.cafe24.com/skin/base_ko_KR/myshop/btn_date5.gif" onimage="//img.echosting.cafe24.com/skin/base_ko_KR/myshop/btn_date5_on.gif" alt="6개월"></a>
                                    </span>
                        <label for="date3" class="uniform-height">
                            <input type="date"
                                   id="date3"
                                   class="date-input"
                                   max="2077-06-20"
                                   min="2077-06-05"
                                   value="2077-06-15">
                        </label>

                        ~
                        <label for="date4" class="uniform-height">
                            <input type="date"
                                   id="date4"
                                   class="date-input"
                                   max="2077-06-20"
                                   min="2077-06-05"
                                   value="2077-06-15">
                        </label>
                        <input alt="조회"  class= "uniform-height" type="image" src="//img.echosting.cafe24.com/skin/admin_ko_KR/myshop/btn_search.gif">
                    </fieldset>
                    <div class="info">
                        <ul>
                            <li>-기본적으로 최근 3개월간의 자료가 조회되며, 기간 검색시 주문처리완료 후 36개월 이내의 주문내역을 조회하실 수 있습니다.</li>
                            <li>-완료 후 36개월 이상 경과한 주문은 [과거주문내역]에서 확인할 수 있습니다.</li>
                            <li>-주문번호를 클릭하시면 해당 주문에 대한 상세내역을 확인하실 수 있습니다.</li>
                        </ul>
                    </div>
                    <div class="product-title">
                        <p>취소/교환/반품</p>
                    </div>
                    <table class="product">
                        <thead>
                        <tr>
                            <th scope="col">주문일자</th>
                            <th scope="col">상품명</th>
                            <th scope="col">수량</th>
                            <th scope="col">주문금액</th>
                            <th scope="col">주문상태</th>
                        </tr>
                        </thead>

                        <tbody>
                        <tr>
                            <c:forEach var="orderDetailDto" items="${etcList}">
                        <tr>
                            <td class="number">
                                    ${orderDetailDto.ord_date}
                                <input type="hidden" name="ord_date" value="${orderDetailDto.ord_date}">
                                <p>
<%--                                    <a href="#">${orderDetailDto.ord_num}</a>--%>
                                    ${orderDetailDto.ord_num}
                                </p>
                            </td>
                            <td>${orderDetailDto.item_name}
                                <p>
                                    옵션 : ${orderDetailDto.opt1}/${orderDetailDto.opt2}
                                </p>
                            </td>
                            <td>${orderDetailDto.item_qty}</td>
                            <td>${orderDetailDto.item_price}</td>
                            <td>${orderDetailDto.ord_state}</td>
                        </tr>
                        </c:forEach>
                        </tbody>
                    </table>
                </div>
            </div>
            <div id="tab1-3" class="tab_content">
                <div class="tab_c_arti">
                    <p>789</p>
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
        <img src="/img/quick_up.png" alt="">
    </a>
    <a href="#none" onclick="jQuery('html,body').animate({scrollTop:$(document).height()},'slow');">
        <img src="/img/quick_down.png" alt="">
    </a>
</div>
<script src="/js/jquery-3.6.4.min.js"></script>
<script src="/js/nav.js"></script>
<script src="/js/tab.js"></script>
<script>
    $("#${ph.curPage}").css("color", "#f141a2")
    $("#${ph.curPage}").css("font-weight", "bold")
    $("#${ph.curPage}").css("font-size", "25px")
    $("#${ph.curPage}").css("text-align", "center")

    document.getElementById("confirm_button").onclick = function () {
        let confirmPurchase = confirm("구매확정 후에는 교환,반품이 불가합니다")
        if (confirmPurchase) {
            alert("구매 확정되었습니다.");
        }else return false;
    }
</script>
    <script>
        document.getElementById('tab1-2').addEventListener('click', function() {
            window.location.href = '/etcList';
        });
    </script>
</script>
</body>
</html>