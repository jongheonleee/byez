<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"  pageEncoding="UTF-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html lang="ko">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>BYEZ</title>
    <link rel="stylesheet" href="/css/nav.css">
    <link rel="stylesheet" href="/css/orderDetail.css">
    <link rel="stylesheet" href="/css/footer.css">
    <link rel="stylesheet" href="/css/aside.css">
    <link rel="stylesheet" href="/css/quick.css">

    <script src="https://kit.fontawesome.com/f0e73cfa04.js" crossorigin="anonymous"></script>
    <link rel="preconnect" href="https://fonts.googleapis.com">
    <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
    <link href="https://fonts.googleapis.com/css2?family=Noto+Sans+KR:wght@100..900&display=swap" rel="stylesheet">
</head>
<body>
<jsp:include page="/WEB-INF/views/include/nav.jsp"/>
<section>
    <div class="wrapper">
        <div class="title">
            <p>
                <a href="/"><span>home</span></a>
                <span>></span>
                <span>주문조회</span>
            </p>
            <p>주문조회</p>
        </div>
        <jsp:include page="/WEB-INF/views/include/aside.jsp"/>
        <div class="content">
            <ul class="tab_menu">
                <li><a href="#tab1-1">주문내역조회</a></li>
                <li><a href="#tab1-2">취소/반품/교환내역</a></li>
                <li><a href="#tab1-3">과거주문내역</a></li>
            </ul>
            <div class="tab_contents">
                <div id="tab1-1" class="tab_content">
                    <div class="tab_c_arti">
                        <fieldset class="search">
                            <select class="order_status" name="order_status" class="fSelect uniform-height">
                                <option value="all">전체 주문처리상태</option>
                                <option value="shipped_standby">주문대기</option>
                                <option value="shipped_standby">주문완료</option>
                                <option value="shipped_begin">배송중</option>
                                <option value="shipped_complate">배송완료</option>
                                <option value="order_cancel">취소신청</option>
                                <option value="order_cancelCmpl">취소완료</option>
                                <option value="order_exchange">교환신청</option>
                                <option value="order_exchangeCmpl">교환완료</option>
                                <option value="order_return">반품신청</option>
                                <option value="order_returnCmpl">반품완료</option>
                            </select>
                            <span class="period">
                                <a href="#none" class="btnNormal uniform-height" days="00"><img src="//img.echosting.cafe24.com/skin/base_ko_KR/myshop/btn_date1.gif" offimage="//img.echosting.cafe24.com/skin/base_ko_KR/myshop/btn_date1.gif" onimage="//img.echosting.cafe24.com/skin/base_ko_KR/myshop/btn_date1_on.gif" alt="오늘"></a>
                                <a href="#none" class="btnNormal uniform-height" days="07"><img src="//img.echosting.cafe24.com/skin/base_ko_KR/myshop/btn_date2.gif" offimage="//img.echosting.cafe24.com/skin/base_ko_KR/myshop/btn_date2.gif" onimage="//img.echosting.cafe24.com/skin/base_ko_KR/myshop/btn_date2_on.gif" alt="1주일"></a>
                                <a href="#none" class="btnNormal uniform-height" days="30"><img src="//img.echosting.cafe24.com/skin/base_ko_KR/myshop/btn_date3.gif" offimage="//img.echosting.cafe24.com/skin/base_ko_KR/myshop/btn_date3.gif" onimage="//img.echosting.cafe24.com/skin/base_ko_KR/myshop/btn_date3_on.gif" alt="1개월"></a>
                                <a href="#none" class="btnNormal uniform-height" days="90"><img src="//img.echosting.cafe24.com/skin/base_ko_KR/myshop/btn_date4.gif" offimage="//img.echosting.cafe24.com/skin/base_ko_KR/myshop/btn_date4.gif" onimage="//img.echosting.cafe24.com/skin/base_ko_KR/myshop/btn_date4_on.gif" alt="3개월"></a>
                                <a href="#none" class="btnNormal uniform-height" days="180"><img src="//img.echosting.cafe24.com/skin/base_ko_KR/myshop/btn_date5.gif" offimage="//img.echosting.cafe24.com/skin/base_ko_KR/myshop/btn_date5.gif" onimage="//img.echosting.cafe24.com/skin/base_ko_KR/myshop/btn_date5_on.gif" alt="6개월"></a>
                            </span>
                            <label for="date1" class="uniform-height">
                                <input type="date" id="date1" class="date-input" max="2012-06-20" min="2077-06-05" value="2024-05-31">
                            </label>
                            ~
                            <label for="date2" class="uniform-height">
                                <input type="date" id="date2" class="date-input" max="2012-06-20" min="2077-06-05" value="2024-05-31">
                            </label>
                            <input alt="조회" class="uniform-height" type="image" src="//img.echosting.cafe24.com/skin/admin_ko_KR/myshop/btn_search.gif">
                        </fieldset>
                        <div class="info">
                            <ul>
                                <li>-기본적으로 최근 3개월간의 자료가 조회되며, 기간 검색시 주문처리완료 후 36개월 이내의 주문내역을 조회하실 수 있습니다.</li>
                                <li>-완료 후 36개월 이상 경과한 주문은 [과거주문내역]에서 확인할 수 있습니다.</li>
                                <li>-주문번호를 클릭하시면 해당 주문에 대한 상세내역을 확인하실 수 있습니다.</li>
                            </ul>
                        </div>
                        <div class="product-title">
                            <p>주문상품내역</p>
                        </div>
                        <table class="product">
                            <thead class="thead">
                            <tr>
                                <th scope="col">상품정보</th>
                                <th scope="col">주문일자</th>
                                <th scope="col">수량</th>
                                <th scope="col">주문금액</th>
                                <th scope="col">주문상태</th>
                            </tr>
                            </thead>
                            <tbody>
                            <c:forEach var="orderDetailDto" items="${limitList}">
                                <tr>
                                    <td>
                                        <a href="/goods/${orderDetailDto.item_num}">
                                            <img src="/img/${orderDetailDto.item_num}.jpeg" class="img">
                                        </a>
                                        <p class="item_name"><strong>${orderDetailDto.item_name}</strong></p>
                                        <p class="option">[컬러 : ${orderDetailDto.opt1}/ 사이즈 : ${orderDetailDto.opt2}]</p>
                                    </td>
                                    <td class="number order_actions">
                                        <p>
                                            <fmt:parseDate value="${orderDetailDto.ord_date}" var="registered" pattern="yyyy-MM-dd HH:mm:ss" />
                                            <fmt:formatDate pattern="yyyy-MM-dd" value="${registered}"/>
                                            <input type="hidden" name="ord_date" value="${orderDetailDto.ord_date}">
                                        </p>
                                        <p class="ord_num"><a href="/order/orderHist?ord_num=${orderDetailDto.ord_num}">${orderDetailDto.ord_num}</a></p>
                                        <form action="/cancel" method="post" class="form_center">
                                            <input type="hidden" name="ord_num" value="${orderDetailDto.ord_num}">
                                            <c:if test="${orderDetailDto.ord_state == '주문완료' || orderDetailDto.ord_state == '주문대기'}">
                                                <input type="submit" class="cancel_button" value="취소">
                                            </c:if>
                                        </form>
                                        <form action="/refund" method="post" class="form_center">
                                            <input type="hidden" name="seq" value="${orderDetailDto.seq}">
                                            <input type="hidden" name="ord_num" value="${orderDetailDto.ord_num}">
                                            <c:if test="${orderDetailDto.ord_state == '배송완료' || orderDetailDto.ord_state == '배송중' || orderDetailDto.ord_state == '교환완료'}">
                                                <input type="submit" class="refund_button" value="반품">
                                            </c:if>
                                        </form>
                                        <form action="/exchange" method="post" class="form_center">
                                            <input type="hidden" name="seq" value="${orderDetailDto.seq}">
                                            <input type="hidden" name="ord_num" value="${orderDetailDto.ord_num}">
                                            <input type="hidden" name="item_num" value="${orderDetailDto.item_num}">
                                            <input type="hidden" name="opt1" value="${orderDetailDto.opt1}">
                                            <input type="hidden" name="opt2" value="${orderDetailDto.opt2}">
                                            <c:if test="${orderDetailDto.ord_state == '배송완료' || orderDetailDto.ord_state == '배송중' || orderDetailDto.ord_state == '교환완료'}">
                                                <input type="submit" class="exchange_button" value="교환">
                                            </c:if>
                                        </form>
                                    </td>
                                    <td>${orderDetailDto.item_qty}</td>
                                    <td><fmt:formatNumber value="${orderDetailDto.item_price}" pattern="#,###"/>원</td>
                                    <td class="order_actions">
                                        <div class="confirmDiv">${orderDetailDto.ord_state}</div>
                                        <form action="/confirmPurchase" method="post" class="form_center">
                                            <input type="hidden" name="ord_num" value="${orderDetailDto.ord_num}">
                                            <c:if test="${orderDetailDto.ord_state == '배송완료' || orderDetailDto.ord_state == '교환완료'}">
                                                <div>
                                                    <input type="submit" class="confirm_button" value="구매확정">
                                                    <input type="hidden" name="ord_state" value="구매확정">
                                                    <input type="hidden" name="state_code" value="CPS">
                                                    <input type="hidden" name="seq" value="${orderDetailDto.seq}">
                                                </div>
                                            </c:if>
                                        </form>
                                    </td>
                                </tr>
                            </c:forEach>
                            </tbody>
                        </table>
                        <div class="paging">
                            <c:if test="${ph.showPrev}">
                                <a href="list?curPage=${ph.naviStart-1}"><<</a> &nbsp;
                                <a href="list?curPage=${ph.curPage-1}"><</a>
                            </c:if>
                            <c:forEach var="page" begin="${ph.naviStart}" end="${ph.naviEnd}" varStatus="status">
                                <a id="${status.index}" href="list?curPage=${page}" <c:if test="${ph.curPage == page}">style="font-weight:bold;"</c:if>>${page}</a>
                            </c:forEach>
                            <c:if test="${ph.showNext}">
                                <a href="list?curPage=${ph.curPage+1}">></a> &nbsp;
                                <a href="list?curPage=${ph.naviEnd+1}">>></a>
                            </c:if>
                        </div>

                    </div>
                </div>
                <div id="tab1-2" class="tab_content">
                    <div class="tab_c_arti">
                        <fieldset class="search">
                            <select class="order_status" name="order_status" class="fSelect uniform-height">
                                <option value="all">전체 주문처리상태</option>
                                <option value="order_cancel">취소신청</option>
                                <option value="order_cancelCmpl">취소완료</option>
                                <option value="order_exchange">교환신청</option>
                                <option value="order_exchangeCmpl">교환완료</option>
                                <option value="order_return">반품신청</option>
                                <option value="order_returnCmpl">반품완료</option>
                            </select>
                            <span class="period">
                                <a href="#none" class="btnNormal uniform-height" days="00"><img src="//img.echosting.cafe24.com/skin/base_ko_KR/myshop/btn_date1.gif" offimage="//img.echosting.cafe24.com/skin/base_ko_KR/myshop/btn_date1.gif" onimage="//img.echosting.cafe24.com/skin/base_ko_KR/myshop/btn_date1_on.gif" alt="오늘"></a>
                                <a href="#none" class="btnNormal uniform-height" days="07"><img src="//img.echosting.cafe24.com/skin/base_ko_KR/myshop/btn_date2.gif" offimage="//img.echosting.cafe24.com/skin/base_ko_KR/myshop/btn_date2.gif" onimage="//img.echosting.cafe24.com/skin/base_ko_KR/myshop/btn_date2_on.gif" alt="1주일"></a>
                                <a href="#none" class="btnNormal uniform-height" days="30"><img src="//img.echosting.cafe24.com/skin/base_ko_KR/myshop/btn_date3.gif" offimage="//img.echosting.cafe24.com/skin/base_ko_KR/myshop/btn_date3.gif" onimage="//img.echosting.cafe24.com/skin/base_ko_KR/myshop/btn_date3_on.gif" alt="1개월"></a>
                                <a href="#none" class="btnNormal uniform-height" days="90"><img src="//img.echosting.cafe24.com/skin/base_ko_KR/myshop/btn_date4.gif" offimage="//img.echosting.cafe24.com/skin/base_ko_KR/myshop/btn_date4.gif" onimage="//img.echosting.cafe24.com/skin/base_ko_KR/myshop/btn_date4_on.gif" alt="3개월"></a>
                                <a href="#none" class="btnNormal uniform-height" days="180"><img src="//img.echosting.cafe24.com/skin/base_ko_KR/myshop/btn_date5.gif" offimage="//img.echosting.cafe24.com/skin/base_ko_KR/myshop/btn_date5.gif" onimage="//img.echosting.cafe24.com/skin/base_ko_KR/myshop/btn_date5_on.gif" alt="6개월"></a>
                            </span>
                            <label for="date3" class="uniform-height">
                                <input type="date" id="date3" class="date-input" max="2012-06-20" min="2077-06-05" value="2024-05-31">
                            </label>
                            ~
                            <label for="date4" class="uniform-height">
                                <input type="date" id="date4" class="date-input" max="2012-06-20" min="2077-06-05" value="2024-05-31">
                            </label>
                            <input alt="조회" class="uniform-height" type="image" src="//img.echosting.cafe24.com/skin/admin_ko_KR/myshop/btn_search.gif">
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
                            <thead class="thead">
                            <tr>
                                <th scope="col">상품정보</th>
                                <th scope="col">주문일자</th>
                                <th scope="col">수량</th>
                                <th scope="col">주문금액</th>
                                <th scope="col">주문상태</th>
                            </tr>
                            </thead>
                            <tbody>
                            <!-- 취소/교환/반품 아이템 -->
                            </tbody>
                        </table>
                        <div class="paging"></div>
                    </div>
                </div>
                <div id="tab1-3" class="tab_content">
                    <div class="tab_c_arti">
                        <!-- 과거 주문내역 콘텐츠 -->
                    </div>
                </div>
            </div>
        </div>
    </div>
</section>

<jsp:include page="/WEB-INF/views/include/footer.jsp"/>
<jsp:include page="/WEB-INF/views/include/quick.jsp"/>

<script src="/js/jquery-3.6.4.min.js"></script>
<script src="/js/nav.js"></script>
<script src="/js/tab.js"></script>

<script>
    $(document).ready(function() {
        // 탭 클릭 이벤트 바인딩
        $("body").on('click', "a[href='#tab1-2']", function(e) {
            e.preventDefault();
            loadEtcList(1);  // 첫 페이지 로드
        });

        $("body").on('click', "a[href='#tab1-1']", function(e) {
            e.preventDefault();
            loadOrderList(1);  // 첫 페이지 로드
        });

        function updateEtcList(data) {
            var $tbody = $("#tab1-2 .product tbody");
            $tbody.empty();

            $.each(data.items, function(i, item) {
                var $row = $("<tr></tr>");
                var $tdInfo = $("<td></td>");
                var $link = $("<a></a>").attr("href", "/goods/" + item.item_num);
                var $img = $("<img>").attr({
                    "src": "/img/" + item.item_num + ".jpeg",
                    "class": "img"
                });
                var $itemName = $("<p></p>").addClass("item_name").html("<strong>" + item.item_name + "</strong>");
                var $itemOptions = $("<p></p>").addClass("option").text("[컬러 : " + item.opt1 + "/ 사이즈 : " + item.opt2 + "]");

                $link.append($img);
                $tdInfo.append($link, $itemName, $itemOptions);
                $row.append($tdInfo);

                var $tdNumber = $("<td></td>").addClass("number");
                var $orderDate = $("<div></div>").addClass("ord_date_box").append(
                    $("<p></p>").addClass("ord_date").text(formatDate(item.ord_date)),
                    $("<input>").attr({"type": "hidden", "name": "ord_date", "value": item.ord_date})
                );
                var $orderNum = $("<p></p>").addClass("ord_num").append(
                    $("<a></a>").attr("href", "/order/orderHist?ord_num=" + item.ord_num).text(item.ord_num)
                );
                $tdNumber.append($orderDate, $orderNum);
                $row.append($tdNumber);

                $row.append($("<td></td>").text(item.item_qty));
                $row.append($("<td></td>").text(item.item_price.toLocaleString() + "원"));
                $row.append($("<td></td>").text(item.ord_state));

                $tbody.append($row);
            });
        }

        function updateOrderList(data) {
            var $tbody = $("#tab1-1 .product tbody");
            $tbody.empty();

            $.each(data.items, function(i, item) {
                var $row = $("<tr></tr>");
                var $tdInfo = $("<td></td>");
                var $link = $("<a></a>").attr("href", "/goods/" + item.item_num);
                var $img = $("<img>").attr({
                    "src": "/img/" + item.item_num + ".jpeg",
                    "class": "img"
                });
                var $itemName = $("<p></p>").addClass("item_name").html("<strong>" + item.item_name + "</strong>");
                var $itemOptions = $("<p></p>").addClass("option").text("[컬러 : " + item.opt1 + "/ 사이즈 : " + item.opt2 + "]");

                $link.append($img);
                $tdInfo.append($link, $itemName, $itemOptions);
                $row.append($tdInfo);

                var $tdNumber = $("<td></td>").addClass("number order_actions");
                var $orderDate = $("<div></div>").addClass("ord_date_box").append(
                    $("<p></p>").addClass("ord_date").html(formatDate(item.ord_date) +
                        '<input type="hidden" name="ord_date" value="' + item.ord_date + '">'),
                );
                var $orderNum = $("<p></p>").addClass("ord_num").append(
                    $("<a></a>").attr("href", "/order/orderHist?ord_num=" + item.ord_num).text(item.ord_num)
                );
                $tdNumber.append($orderDate, $orderNum);

                // 취소, 반품, 교환 버튼
                var $cancelForm = $("<form></form>").attr({
                    "action": "/cancel",
                    "method": "post",
                    "class": "form_center"
                }).append(
                    $("<input>").attr({
                        "type": "hidden",
                        "name": "ord_num",
                        "value": item.ord_num
                    })
                );
                if (item.ord_state == '주문완료' || item.ord_state == '주문대기') {
                    $cancelForm.append($("<input>").attr({
                        "type": "submit",
                        "class": "cancel_button",
                        "value": "취소"
                    }));
                }
                $tdNumber.append($cancelForm);

                var $refundForm = $("<form></form>").attr({
                    "action": "/refund",
                    "method": "post",
                    "class": "form_center"
                }).css("margin-right", "3px") // 오른쪽 여백 추가
                .append(
                    $("<input>").attr({
                        "type": "hidden",
                        "name": "seq",
                        "value": item.seq
                    }),
                    $("<input>").attr({
                        "type": "hidden",
                        "name": "ord_num",
                        "value": item.ord_num
                    })
                );
                if (item.ord_state == '배송완료' || item.ord_state == '배송중' || item.ord_state == '교환완료') {
                    $refundForm.append($("<input>").attr({
                        "type": "submit",
                        "class": "refund_button",
                        "value": "반품"
                    }));
                }
                $tdNumber.append($refundForm);

                var $exchangeForm = $("<form></form>").attr({
                    "action": "/exchange",
                    "method": "post",
                    "class": "form_center"
                }).append(
                    $("<input>").attr({
                        "type": "hidden",
                        "name": "seq",
                        "value": item.seq
                    }),
                    $("<input>").attr({
                        "type": "hidden",
                        "name": "ord_num",
                        "value": item.ord_num
                    }),
                    $("<input>").attr({
                        "type": "hidden",
                        "name": "item_num",
                        "value": item.item_num
                    }),
                    $("<input>").attr({
                        "type": "hidden",
                        "name": "opt1",
                        "value": item.opt1
                    }),
                    $("<input>").attr({
                        "type": "hidden",
                        "name": "opt2",
                        "value": item.opt2
                    })
                );
                if (item.ord_state == '배송완료' || item.ord_state == '배송중' || item.ord_state == '교환완료') {
                    $exchangeForm.append($("<input>").attr({
                        "type": "submit",
                        "class": "exchange_button",
                        "value": "교환"
                    }));
                }
                $tdNumber.append($exchangeForm);

                $row.append($tdNumber);

                $row.append($("<td></td>").text(item.item_qty));
                $row.append($("<td></td>").html(item.item_price.toLocaleString() + "원"));

                // 구매확정 버튼
                var $tdActions = $("<td></td>").addClass("order_actions");
                $tdActions.append($("<div></div>").addClass("confirmDiv").text(item.ord_state));

                var $confirmForm = $("<form></form>").attr({
                    "action": "/confirmPurchase",
                    "method": "post",
                    "class": "form_center"
                }).append(
                    $("<input>").attr({
                        "type": "hidden",
                        "name": "ord_num",
                        "value": item.ord_num
                    })
                );
                if (item.ord_state == '배송완료' || item.ord_state == '교환완료') {
                    $confirmForm.append($("<div></div>").append(
                        $("<input>").attr({
                            "type": "submit",
                            "class": "confirm_button",
                            "value": "구매확정"
                        }),
                        $("<input>").attr({
                            "type": "hidden",
                            "name": "ord_state",
                            "value": "구매확정"
                        }),
                        $("<input>").attr({
                            "type": "hidden",
                            "name": "state_code",
                            "value": "CPS"
                        }),
                        $("<input>").attr({
                            "type": "hidden",
                            "name": "seq",
                            "value": item.seq
                        })
                    ));
                }
                $tdActions.append($confirmForm);

                $row.append($tdActions);
                $tbody.append($row);
            });
        }

        function updatePagination(data, tab) {
            var $paging = $(tab + " .paging");
            $paging.empty();

            if (data.hasPrevious) {
                $paging.append($('<a href="#" class="page-link" data-page="' + (data.currentPage - 1) + '">이전</a>'));
            }
            for (var i = 1; i <= data.totalPages; i++) {
                var $pageLink = $('<a href="#" class="page-link" data-page="' + i + '">' + i + '</a>');
                if (i === data.currentPage) {
                    $pageLink.css('font-weight', 'bold').css('color','black');
                }
                $paging.append($pageLink);
            }
            if (data.hasNext) {
                $paging.append($('<a href="#" class="page-link" data-page="' + (data.currentPage + 1) + '">다음</a>'));
            }

            bindPaginationEvents(tab);
        }

        function bindPaginationEvents(tab) {
            $(tab + " .paging").off("click", ".page-link").on("click", ".page-link", function(e) {
                e.preventDefault();
                var pageNum = $(this).data("page");
                if (tab === '#tab1-2') {
                    loadEtcList(pageNum);
                } else if (tab === '#tab1-1') {
                    loadOrderList(pageNum);
                }
            });
        }

        function loadEtcList(pageNum) {
            $.ajax({
                url: "/order/etcListData",
                type: "POST",
                contentType: "application/json",
                data: JSON.stringify({ userId: $("#userId").val(), curPage: pageNum }),
                dataType: "json",
                success: function(response) {
                    updateEtcList(response);
                    updatePagination(response, '#tab1-2');
                },
                error: function(xhr, status, error) {
                    console.error("Error reloading page: " + error);
                }
            });
        }

        function loadOrderList(pageNum) {
            $.ajax({
                url: "/order/listData",
                type: "POST",
                contentType: "application/json",
                data: JSON.stringify({ userId: $("#userId").val(), curPage: pageNum }),
                dataType: "json",
                success: function(response) {
                    updateOrderList(response);
                    updatePagination(response, '#tab1-1');
                },
                error: function(xhr, status, error) {
                    console.error("Error reloading page: " + error);
                }
            });
        }

        // 탭 전환 이벤트 처리
        $('a[data-toggle="tab"]').on('shown.bs.tab', function (e) {
            var target = $(e.target).attr("href"); // 활성화된 탭의 #id
            if (target === '#tab1-2') {
                loadEtcList(1); // 항상 첫 페이지 로드
            } else if (target === '#tab1-1') {
                loadOrderList(1); // 항상 첫 페이지 로드
            }
        });
        $("body").on('click', ".confirm_button", function(e) {
            var confirmPurchase = confirm("구매확정 후에는 교환,반품이 불가합니다");
            if (confirmPurchase) {
                alert("구매 확정되었습니다.");
            } else {
                e.preventDefault(); // 구매확정을 취소했을 때, 폼 제출 막기
            }
        });
    });

    $("#${ph.curPage}").css("color", "black")

    function formatDate(dateString) {
        var date = new Date(dateString);
        var year = date.getFullYear();
        var month = ("0" + (date.getMonth() + 1)).slice(-2); // 월은 0부터 시작하므로 +1을 해줘야 합니다.
        var day = ("0" + date.getDate()).slice(-2);
        return year + "-" + month + "-" + day;
    }

</script>

</body>
</html>
