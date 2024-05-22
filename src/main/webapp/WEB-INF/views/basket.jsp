<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"  pageEncoding="UTF-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>BYEZ</title>
    <link rel="stylesheet" href="css/nav.css?after">
    <link rel="stylesheet" href="css/basket.css?after?after?after?after?after">
    <link rel="stylesheet" href="css/footer.css">
    <link rel="stylesheet" href="css/quick.css">
    <script src="https://kit.fontawesome.com/f0e73cfa04.js" crossorigin="anonymous"></script>
    <link rel="preconnect" href="https://fonts.googleapis.com">
    <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
    <link href="https://fonts.googleapis.com/css2?family=Noto+Sans+KR:wght@100..900&display=swap" rel="stylesheet">
</head>
<body>
<%@include file="../views/include/nav.jsp"%>

<!-- 2. section : 장바구니 타이틀, 장바구니 상품 목록, 모두삭제/선택삭제 버튼, 주문 정보-->
<section>
    <div class="wrapper">
        <!-- 2-1. 타이틀 : 장바구니 -->
        <p>
            <a href="/"><span>HOME></span></a>
            <span></span>
            <a href="/basket"><span> 장바구니</span></a>
        </p>

        <p class="title">
            장바구니
        </p>

        <!-- 2-2. 주요 콘텐츠 : 장바구니 상품 목록 -->
            <!-- 2-2-1. 각 상품 콘텐츠 * n : 체크 박스, 상품정보(사진, 명, 옵션), 수량, 주문 금액, 주문관리 -->
                <!-- 체크 박스 : 선택 여부 -->
                <!-- 상품 정보 : 사진, 상품명, 선택된 옵션 정보 -->
                <!-- 수량 : 상품 수량 -->
                <!-- 주문관리 : 변경하기/삭제하기 버튼 -->

            <!-- 2-3. 버튼 1 : 모두삭제/선택삭제 -->
        <div class="mainContent">
            <div class="basketItemList">
                <table>
                    <thead>
                        <th class="td1">
                            <div class="allCheckInputDiv">
                                <input type="checkbox" class="allBasketItemCheckBox" checked="checked">
                            </div>
                        </th>
                        <th>상품정보</th>
                        <th>수량</th>
                        <th>가격</th>
                        <th>합계</th>
                        <th>선택</th>
                        <th></th>
                        <th></th>
                    </thead>

                    <tbody>
                    <c:forEach var="basketItemDto" items="${list}">
<%--                        <tr>--%>
<%--                            <div class="allCheckInputDiv">--%>
<%--                                <input type="checkbox" class="allBasketItemCheckBox" checked="checked">--%>
<%--                            </div>--%>
<%--                        </tr>--%>
                        <tr>
                            <td class="basketItemInfo" style="text-align: center;">
                                <div class="eachBasketItemCheckBox">
                                    <input type="checkbox" class="basketItemCheckBox" checked="checked">
                                </div>
                                <input type="hidden" class="eachBasketItemId" value="${basketItemDto.id}">
                                <input type="hidden" class="eachBasketItemSeq" value="${basketItemDto.seq}">
                                <input type="hidden" class="eachBasketItemNum" value="${basketItemDto.num}">
                                <input type="hidden" class="eachBasketItemName" value="${basketItemDto.name}">
                                <input type="hidden" class="eachBasketItemPrice" value="${basketItemDto.price}">
                                <input type="hidden" class="eachBasketItemQty" value="${basketItemDto.qty}">
                                <input type="hidden" class="eachBasketItemOpt1" value="${basketItemDto.opt1}">
                                <input type="hidden" class="eachBasketItemOpt2" value="${basketItemDto.opt2}">
                                <input type="hidden" class="eachBasketItemOpt3" value="${basketItemDto.opt3}">
                                <input type="hidden" class="eachBasketItemOpt4" value="${basketItemDto.opt4}">
                            </td>


                            <td class="tb1" style="text-align: center;">
                                <div class="basketImgWrap">
                                    <a href="/goods/${basketItemDto.num}">
                                        <img src="${basketItemDto.main_img}">
                                    </a>
                                </div>
                                <div class="eachBasketInfo">
                                    <p>
                                        <strong>${basketItemDto.name}</strong>
                                    </p>
                                    <p>
                                        [사이즈 : ${basketItemDto.opt1} / 컬러 : ${basketItemDto.opt2}]
                                    </p>
                                    <div>
                                        ${basketItemDto.opt3}
                                    </div>
                                </div>
                            </td>

                            <td style="text-align: center;">${basketItemDto.qty}</td>
                            <td style="text-align: center;"><p class="sales_price"><fmt:formatNumber value="${basketItemDto.price}" pattern="#,###"/></p></td>
                            <td style="text-align: center;"><p class="sales_price"><fmt:formatNumber value="${basketItemDto.qty * basketItemDto.price}" pattern="#,###"/></p></td>
                            <td style="text-align: center;">
                                <div>
                                    <button class="deleteBtn btnStyle" data-seq="${basketItemDto.seq}" data-id="${basketItmDto.id}">삭제</button>
                                </div>
                                <div>
                                    <button class="openModalBtn btnStyle">변경</button>
                                    <div class="modal">
                                        <div class="modalBody">
                                            <button class="closeBtn closeModalBtn"><i class="fa-solid fa-xmark"></i></button>
                                                <form>
                                                    <h1 class="modalItemName">${basketItemDto.name}</h1>
                                                        <input class="seq" type="hidden" name="seq" value="${basketItemDto.seq}"><br>
                                                        <input class="id" type="hidden" name="id" value="${basketItemDto.id}"><br>
                                                        <input class="name" type="hidden" name="name" value="${basketItemDto.name}"><br>
                                                        <input class="num" type="hidden" name="num" value="${basketItemDto.num}"><br>
                                                        <input class="price" type="hidden" name="price" value="${basketItemDto.price}"><br>
                                                        <input class="opt3" type="hidden" name="opt3" value="${basketItemDto.opt3}">
                                                        <div class="modalImgWrap">
                                                            <a href="/goods/${basketItemDto.num}">
                                                                <img src="${basketItemDto.main_img}">
                                                            </a>
                                                        </div>

                                                        <ul class="modalStyle">
                                                            <li>
                                                                <label>
                                                                    <b>수량</b>
                                                                </label>
                                                                <div class="modalQty">
                                                                    <div class="count_box">
                                                                        <div class="count-wrap _count">
                                                                            <button type="button" class="minus">-</button>
                                                                            <input type="text" class="inp qty" value="${basketItemDto.qty}" readonly/>
                                                                            <button type="button" class="plus">+</button>
                                                                        </div>
                                                                    </div>
                                                                </div>
                                                            </li>

                                                            <li>
                                                                <label>
                                                                    <b>사이즈</b>
                                                                </label>
                                                                <input type="hidden" class="opt1" name="opt1" value="${basketItemDto.opt1}" placeholder="${basketItemDto.opt1}">
                                                                    <select class="changeOpt1" onchange="selectOpt1(this.value);">
                                                                        <option value="S">S</option>
                                                                        <option value="M">M</option>
                                                                        <option value="L">L</option>
                                                                        <option value="XL">XL</option>
                                                                        <option value="XXL">XXL</option>
                                                                    </select>
                                                            </li>

                                                            <li>
                                                                <label>
                                                                    <b>색상</b>
                                                                </label>
                                                                <input type="hidden" class="opt2" name="opt2" value="${basketItemDto.opt2}" placeholder="${basketItemDto.opt2}" >
                                                                    <select class="changeOpt2" onchange="selectOpt2(this.value);">
                                                                        <option value="COL1">블랙</option>
                                                                        <option value="COL2">화이트</option>
                                                                        <option value="COL3">브라운</option>
                                                                        <option value="COL4">그린</option>
                                                                    </select>
                                                            </li>
                                                        </ul>

                                                        <button class="modalBtn sendModalBtn">수정</button>
                                                        <button class="modalBtn closeModalBtn">취소</button>
                                              </form>
                                        </div>
                                    </div>
                                </div>
                            </td>
                        </tr>
                    </c:forEach>
                    </tbody>
                </table>
            </div>

            <div class="deleteBtnArea">
                <!-- margin-left : 10px -->
                <button class="deleteAllBtn btnStyle" data-id="${basketItemDto.id}">모두삭제</button>
                <button class="deleteSeveralBtn btnStyle" data-id="${basketItemDto.id}">선택된 상품 삭제</button>

            </div>

        </div>
        <!-- 2-4. 서브 콘텐츠 : 장바구니 주문 예상 정보 -->
            <!-- 2-4-1.장바구니 주문 예상 정보 * 1 : 상품 금액 - 할인 금액 = 주문 예상 금액  -->
            <!-- 2-4-2. 버튼 2 : 주문하기-->
        <div class="subContent">
            <p class="subTitle">
                장바구니 주문 정보
            </p>

            <!-- 총 주문 가격 -->
            <p class="orderInfo">
                예상 주문 가격 :
                <span class="orderPrice"></span>
                /
                <!-- 총 상품 개수 -->
                총 상품 수량 :
                <span class="totalCnt"></span>
            </p>
        </div>

        <div class="basketItemOrderBtn">
            <!-- margin-auto : 정중앙 배치  -->
            <button class="orderBtn orderBtnStyle">주문하기</button>
        </div>
    </div>
</section>

<!-- 수정 form -->
<form action="basket/update" method="post" class="updateBasketItem">
    <input type="hidden" name="seq" class="updateSeq">
    <input type="hidden" name="id" class="updateId">
    <input type="hidden" name="name" class="updateName">
    <input type="hidden" name="num" class="updateNum">
    <input type="hidden" name="price" class="updatePrice">
    <input type="hidden" name="qty" class="updateQty">
    <input type="hidden" name="opt1" class="updateOpt1">
    <input type="hidden" name="opt2" class="updateOpt2">
    <input type="hidden" name="opt3" class="updateOpt3">
</form>

<!-- 삭제 form -->
<form action="basket/delete" method="post" class="deleteBasketItem">
    <input type="hidden" name="seq" class="deleteSeq">
    <input type="hidden" name="id" class="deleteId">
</form>

<!-- 선택된 상품만 삭제 form -->
<%--<form action="basket/delete" method="post" class="deleteSelectedBasketItem">--%>
<%--</form>--%>

<!-- 모두 삭제 form -->
<form action="basket/delete/all" method="post" class="deleteAllBasketItemForm">
</form>

<!-- 여러개 삭제 form -->
<form action="basket/delete/several" method="get" class="deleteSeveralBasketItemForm">
</form>

<!-- 주문 form -->
<form action="order" method="post" class="orderCheckedBasketItemForm">
</form>
<%@include file="../views/include/quick.jsp"%>
<%@include file="../views/include/footer.jsp"%>
<!-- 4. 자스 -->
<script type="text/javascript" src="http://code.jquery.com/jquery-3.5.1.min.js"></script>
<script src="/js/nav.js?after"></script>
<script src="/js/basket.js?after"></script>
</body>
</html>
