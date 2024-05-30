<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"  pageEncoding="UTF-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>BYEZ</title>
    <link rel="stylesheet" href="css/nav.css?after">
    <link rel="stylesheet" href="css/basket.css?after?after?after?after?after?after?after">
    <link rel="stylesheet" href="/css/footer.css">
    <link rel="stylesheet" href="css/quick.css">
    <script src="https://kit.fontawesome.com/f0e73cfa04.js" crossorigin="anonymous"></script>
    <link rel="preconnect" href="https://fonts.googleapis.com">
    <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
    <link href="https://fonts.googleapis.com/css2?family=Noto+Sans+KR:wght@100..900&display=swap" rel="stylesheet">
    <link rel="icon" href="/img/favicon-32x32_2.png">
</head>
<body>
<jsp:include page="/WEB-INF/views/include/nav.jsp"/>
<!-- 2. section : 장바구니 타이틀, 장바구니 상품 목록, 모두삭제/선택삭제 버튼, 주문 정보-->
<section>
<%--    </c:forEach>--%>
    <div class="wrapper">
        <!-- 2-1. 타이틀 : 장바구니 -->
        <p>
            <a href="/"><span>home</span></a>
            <span>></span>
            <span>장바구니</span>
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
                <c:if test="${list == null  || list.size() == 0}">
                    <table>
                        <thead>
                            <th class="td1">
                                <div class="allCheckInputDiv">
                                    <input type="checkbox" class="allBasketItemCheckBox" checked="checked">
                                </div>
                            </th>
                            <th style="height: 50px">상품정보</th>
                            <th>수량</th>
                            <th>가격</th>
                            <th>합계</th>
                            <th>선택</th>
                            <th></th>
                            <th></th>
                        </thead>
                        <tbody>
                            <tr>
                                <td colspan="6" class="noItem">
                                    장바구니에 담긴 상품이 없습니다.
                                </td>
                            </tr>
                        </tbody>
                    </table>
                </c:if>
                <c:if test="${list.size() > 0}">
                    <table>
                        <thead>
                            <th class="td1">
                                <div class="allCheckInputDiv">
                                    <input type="checkbox" class="allBasketItemCheckBox" checked="checked">
                                </div>
                            </th>
                            <th style="height: 50px">상품정보</th>
                            <th>수량</th>
                            <th>가격</th>
                            <th>합계</th>
                            <th>선택</th>
                            <th></th>
                            <th></th>
                        </thead>
                        <tbody>
                                <c:forEach var="i" begin="0" end="${list.size()-1}">
                                    <%--                    <c:forEach var="basketItemDto" items="${list}">--%>
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
                                            <input type="hidden" class="eachBasketItemId" value="${list.get(i).id}">
                                            <input type="hidden" class="eachBasketItemSeq" value="${list.get(i).seq}">
                                            <input type="hidden" class="eachBasketItemNum" value="${list.get(i).num}">
                                            <input type="hidden" class="eachBasketItemName" value="${list.get(i).name}">
                                            <input type="hidden" class="eachBasketItemMainImg" value="${list.get(i).main_img}">
                                            <input type="hidden" class="eachBasketItemPrice" value="${list.get(i).price}">
                                            <input type="hidden" class="eachBasketItemQty" value="${list.get(i).qty}">
                                            <input type="hidden" class="eachBasketItemOpt1" value="${list.get(i).opt1}">
                                            <input type="hidden" class="eachBasketItemOpt2" value="${list.get(i).opt2}">
                                            <input type="hidden" class="eachBasketItemOpt3" value="${list.get(i).opt3}">
                                            <input type="hidden" class="eachBasketItemOpt4" value="${list.get(i).opt4}">
                                        </td>


                                        <td class="tb1" style="text-align: center;">
                                            <div class="basketImgWrap">
                                                <a href="/goods/${list.get(i).num}">
                                                    <img src="/img/${list.get(i).main_img}">
                                                </a>
                                            </div>
                                            <div class="eachBasketInfo">
                                                <p>
                                                    <strong>${list.get(i).name}</strong>
                                                </p>
                                                <p>
                                                    [컬러 : ${list.get(i).opt1} / 사이즈 : ${list.get(i).opt2}]
                                                </p>
                                                <div>
                                                        ${list.get(i).opt3}
                                                </div>
                                            </div>
                                        </td>

                                        <td style="text-align: center;">${list.get(i).qty}</td>
                                        <td style="text-align: center;"><p class="sales_price"><fmt:formatNumber value="${list.get(i).price}" pattern="#,###"/></p></td>
                                        <td style="text-align: center;"><p class="sales_price"><fmt:formatNumber value="${list.get(i).qty * list.get(i).price}" pattern="#,###"/></p></td>
                                        <td style="text-align: center;">
                                            <div>
                                                <button class="deleteBtn btnStyle" data-seq="${list.get(i).seq}" data-id="${list.get(i).id}">삭제</button>
                                            </div>
                                            <div>
                                                <button class="openModalBtn btnStyle">변경</button>
                                                <div class="modal">
                                                    <div class="modalBody">
                                                        <button class="closeBtn closeModalBtn"><i class="fa-solid fa-xmark"></i></button>
                                                        <form>
                                                            <h1 class="modalItemName">${list.get(i).name}</h1>
                                                            <input class="seq" type="hidden" name="seq" value="${list.get(i).seq}"><br>
                                                            <input class="id" type="hidden" name="id" value="${list.get(i).id}"><br>
                                                            <input class="name" type="hidden" name="name" value="${list.get(i).name}"><br>
                                                            <input class="num" type="hidden" name="num" value="${list.get(i).num}"><br>
                                                            <input class="price" type="hidden" name="price" value="${list.get(i).price}"><br>
                                                            <input class="opt3" type="hidden" name="opt3" value="${list.get(i).opt3}">
                                                            <div class="modalImgWrap">
                                                                <a href="/goods/${list.get(i).num}">
                                                                    <img src="/img/${list.get(i).main_img}">
                                                                </a>
                                                            </div>

                                                            <ul class="modalStyle">
                                                                <li>
                                                                    <label>
                                                                        <b>수량</b>
                                                                    </label>
                                                                    <div class="counting">
                                                                        <div class="modalQty">
                                                                            <div class="count_box">
                                                                                <div class="count-wrap _count">
                                                                                    <button type="button" class="minus">-</button>
                                                                                    <input type="text" class="inp qty" value="${list.get(i).qty}" readonly/>
                                                                                    <button type="button" class="plus">+</button>
                                                                                </div>
                                                                            </div>
                                                                        </div>
                                                                    </div>

                                                                </li>

                                                                <li>
                                                                    <label>
                                                                        <b>색상</b>
                                                                    </label>
                                                                    <input type="hidden" class="opt1" name="opt1" value="${list.get(i).opt1}" placeholder="${list.get(i).opt1}" >
                                                                    <select class="changeOpt1" onchange="selectOpt1(this.value);">
                                                                        <option value="" disabled selected>--색상을 선택해주세요--</option>
                                                                        <c:forEach var="color" items="${list2.get(i).colors}">
                                                                            <option value=${color}>${color}</option>
                                                                        </c:forEach>
                                                                    </select>
                                                                </li>

                                                                <li>
                                                                    <label>
                                                                        <b>사이즈</b>
                                                                    </label>
                                                                    <input type="hidden" class="opt2" name="opt2" value="${list.get(i).opt2}" placeholder="${list.get(i).opt2}">
                                                                    <select class="changeOpt2" onchange="selectOpt2(this.value);">
                                                                        <option value="" disabled selected>--사이즈 유형을 선택해주세요--</option>
                                                                        <c:forEach var="size" items="${list2.get(i).sizes}">
                                                                            <option value=${size}>${size}</option>
                                                                        </c:forEach>
                                                                    </select>
                                                                </li>
                                                            </ul>

                                                            <button class="modalBtn closeModalBtn"><p>취소</p></button>
                                                            <button class="modalBtn sendModalBtn"><p>수정</p></button>
                                                        </form>
                                                    </div>
                                                </div>
                                            </div>
                                        </td>
                                    </tr>
                                </c:forEach>
                        </tbody>
                    </table>

                    <div class="deleteBtnArea">
                        <!-- margin-left : 10px -->
                        <button class="deleteAllBtn btnStyle" data-id="${list.get(i).id}">모두 삭제</button>
                        <button class="deleteSeveralBtn btnStyle" data-id="${list.get(i).id}">선택된 상품 삭제</button>
                    </div>
                </c:if>
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
<form action="/order/orderForm" method="post" class="orderCheckedBasketItemForm">
</form>
<jsp:include page="/WEB-INF/views/include/footer.jsp"/>
<jsp:include page="/WEB-INF/views/include/quick.jsp"/>
<!-- 4. 자스 -->
<script type="text/javascript" src="http://code.jquery.com/jquery-3.5.1.min.js"></script>
<script src="/js/nav.js"></script>
<script src="/js/basket.js"></script>
</body>
</html>
