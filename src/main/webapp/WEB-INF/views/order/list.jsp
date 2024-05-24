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
<jsp:include page="/WEB-INF/views/include/nav.jsp"/>
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
        <jsp:include page="/WEB-INF/views/include/aside.jsp"/>
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
                                <option value="shipped_standby">배송준비중</option>
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
                            <thead class="thead">
                            <tr>
                                <th scope="col">주문일자</th>
                                <th scope="col">상품명</th>
                                <th scope="col">수량</th>
                                <th scope="col">주문금액</th>
                                <th scope="col">주문상태</th>
                            </tr>
                            </thead>

                            <tbody>
                            <c:forEach var="orderDetailDto" items="${limitList}">
                            <tr>
                                <td class="number order_actions">
                                    ${orderDetailDto.ord_date}
                                            <input type="hidden" name="ord_date" value="${orderDetailDto.ord_date}">
                                    <p class="ord_num">
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
                                    <p class="option">
                                        옵션 : ${orderDetailDto.opt1}/${orderDetailDto.opt2}
                                    </p>
                                </td>
                                <td>${orderDetailDto.item_qty}</td>
                                <td>${orderDetailDto.item_price}</td>
                                <td class="order_actions">
                                    <div class="confirmDiv">${orderDetailDto.ord_state}</div>
                                    <form action = "/confirmPurchase" method = "post" class="form_center">
                                            <%--           hidden타입의 주문상태를 담아둔다--%>
                                        <input type="hidden" name="ord_num" value="${orderDetailDto.ord_num}">
                                        <c:if test="${orderDetailDto.ord_state == '배송완료' || '교환완료'  }">
                                            <div>
                                            <input type="submit" class="confirm_button" value="구매확정">
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
                        <c:if test="${not empty listMessage}">
                            <p class="noneOrderMsg">${listMessage}</p>
                        </c:if>
                        <br>

                        <div class="paging">
                        <c:if test="${ph.showPrev}">
                            <a href = "list?curPage=${ph.naviStart-1}"><<</a> &nbsp;
                            <a href = "list?curPage=${ph.curPage-1}"><</a>
                        </c:if>

                        <c:forEach var="ph" begin="${ph.naviStart}" end="${ph.naviEnd}" varStatus="status">
                            <a id = "${status.index}" href="list?curPage=${status.index}" style="font-size: 20px">${status.index}</a>
                        </c:forEach>

                        <c:if test="${ph.showNext}">
                            <a href = "list?curPage=${ph.curPage+1}">></a> &nbsp;
                            <a href = "list?curPage=${ph.naviEnd+1}">>></a>
                        </c:if>
                        </div>
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
                        <thead class="thead">
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
                            <div class="ord_num_ord_date">
                            <td class="number">
                                <p style="margin-top: 20px"> ${orderDetailDto.ord_date}
                                <input type="hidden" name="ord_date" value="${orderDetailDto.ord_date}">
                                </p>
                                <p class="ord_num">
<%--                                    <a href="#">${orderDetailDto.ord_num}</a>--%>
                                    ${orderDetailDto.ord_num}
                                </p>
                            </td>
                            </div>
                            <td>${orderDetailDto.item_name}
                                <p class="option">
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

<%--                    취소교환반품 리스트 페이징기능 관련 매퍼, 다오 추가후 기능추가 예정--%>
                    <c:if test="${ph.showPrev}">
                        <a href = list?curPage=${ph.naviStart-1}><<</a> &nbsp;
                        <a href = list?curPage=${ph.curPage-1}><</a>
                    </c:if>

                    <c:forEach var="ph" begin="${ph.naviStart}" end="${ph.naviEnd}" varStatus="status">
                        <a id = "${status.index}" href="list?curPage=${status.index}" style="font-size: 20px">${status.index}</a>
                    </c:forEach>

                    <c:if test="${ph.showNext}">
                        <a href = /list?curPage=${ph.curPage+1}>></a> &nbsp;
                        <a href = /list?curPage=${ph.naviEnd+1}>>></a>
                    </c:if>

                    <c:if test="${not empty etcMessage}">
                        <p class="noneOrderMsg">${etcMessage}</p>
                    </c:if>

                </div>
            </div>

<%--            3번째 탭 주석처리--%>
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

    <%--$("#${ph.curPage}").css("color", "#f141a2");--%>
    <%--$("#${ph.curPage}").css("font-weight", "bold");--%>
    <%--$("#${ph.curPage}").css("font-size", "25px");--%>
    <%--$("#${ph.curPage}").css("text-align", "center");--%>

    <script src="/js/jquery-3.6.4.min.js"></script>
    <script src="/js/nav.js"></script>
    <script src="/js/tab.js"></script>


    <script>
        // document.getElementsByClassName("confirm_button").onclick = function () {
        //     console.log("test")
        //     let confirmPurchase = confirm("구매확정 후에는 교환,반품이 불가합니다")
        //     if (confirmPurchase) {
        //         alert("구매 확정되었습니다.");
        //     } else return false;
        // }

        document.addEventListener("DOMContentLoaded", function() {
            // 이벤트 위임을 사용하여 동적 요소에 대응
            document.body.addEventListener('click', function(event) {
                if (event.target.className === "confirm_button") {
                    let confirmPurchase = confirm("구매확정 후에는 교환,반품이 불가합니다");
                    if (confirmPurchase) {
                        alert("구매 확정되었습니다.");
                    }else if(!confirmPurchase) {
                        event.preventDefault(); // 구매확정을 취소했을 때, 폼 제출 막기
                    }
                }
            });
        });
</script>

</body>
</html>