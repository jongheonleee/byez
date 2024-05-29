<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%--찬빈추가--%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="dateOK" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html>
<html lang="ko">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>BYEZ</title>
    <link rel="stylesheet" href="/css/nav.css">
    <link rel="stylesheet" href="/css/detail.css?after">
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
        <p>
            <a href="/"><span>home</span></a>
        </p>
        <div class="info">
            <div class="infoImgWrapper">
                <div class="foldImg">
                    <img src="/img/${itemDto.main_img}" alt="" class="detail_img">
                    <p>Info</p>
                    <img src="/img/${itemDetail.detail_img}" alt="" class="detail_img">
                </div>
                <div class="more">
                    <button>
                        <span>상품설명 더보기</span>
                        <i class="fa-solid fa-angle-down"></i>
                    </button>
                </div>
                <p>소재 : <span class="matr">${itemDetail.matr}</span></p>
                <p>제조국 : <span class="origin">${itemDetail.origin}</span></p>
                <p>제조사 : <span class="mfg_corp">${itemDetail.mfg_corp}</span></p>
                <p>제조자 : <span class="mfg_name">${itemDetail.mfg_name}</span></p>
                <p>제조일자 : <span class="mfg_date"><fmt:parseDate value="${itemDetail.mfg_date}" pattern="yyyy-MM-dd" var="parsedDate" />
                        <fmt:formatDate value="${parsedDate}" pattern="yyyy년 MM월 dd일" /></span></p>
                <p>모델명 : <span class="model">${itemDetail.model}</span></p>
                <p>취급 시 주의사항 :
                    <span class="caut">${itemDetail.caut}</span>
                </p>
            </div>
            <div class="infoWrapper">
                <p class="detail_name">${itemDetail.detail_name}</p>
                <div class="type" value="${itemDetail.cust_type}">${itemDetail.cust_type}</div>
                <p>
                    <span class="disc_price"><fmt:formatNumber value="${itemDetail.disc_price}" pattern="#,###"/></span>
                    <span class="price"><fmt:formatNumber value="${itemDetail.price}" pattern="#,###"/></span>
                    <span class="disc_rate"><fmt:formatNumber value="${itemDetail.disc_rate * 100}" pattern="#,###"/>%</span>
                </p>
<%--                <div class="newbie">--%>
<%--                    <span>신규가입 혜택</span>--%>
<%--                    <a href="#">--%>
<%--                        <span>신규 가입 시 웰컴 쿠폰팩 즉시 지급</span>--%>
<%--                        <i class="fa-solid fa-chevron-right"></i>--%>
<%--                    </a>--%>
<%--                </div>--%>
                <div class="optionBox">
                    <p>Color</p>
                    <ul class="col">
                        <input type="hidden" class="opt1" name="opt1" >
                        <select class="changeOpt1" onchange="selectOpt1(this.value);">
                            <option value="" disabled selected>--색상을 선택해주세요--</option>
                            <c:forEach var="color" items="${itemDetail.colors}">
                                <option value=${color}>${color}</option>
                            </c:forEach>
                        </select>
                    </ul>
<%--                    <p>--%>
<%--                        <span>[필수] </span>--%>
<%--                        <span class="colOption">옵션을 선택해 주세요.</span>--%>
<%--                    </p>--%>
                    <p>Size</p>
                    <ul class="size">
                        <input type="hidden" class="opt2" name="opt2">
                        <select class="changeOpt2" onchange="selectOpt2(this.value);">
                            <option value="" disabled selected>--사이즈 유형을 선택해주세요--</option>
                            <c:forEach var="size" items="${itemDetail.sizes}">
                                <option value=${size}>${size}</option>
                            </c:forEach>
                        </select>
                    </ul>
<%--                    <p>--%>
<%--                        <span>[필수] </span>--%>
<%--                        <span class="sizeOption">옵션을 선택해 주세요.</span>--%>
<%--                    </p>--%>
                    <p>Quantity</p>
                    <ul class="qty">
                        <div class="count_box">
                            <div class="count-wrap _count">
                                <button type="button" class="minus">-</button>
                                <input type="text" class="inp qty" value="1" readonly/>
                                <button type="button" class="plus">+</button>
                            </div>
                        </div>
                    </ul>
<%--                    <p>--%>
<%--                        <span>[필수] </span>--%>
<%--                        <span class="qtyOption">수량을 선택해 주세요.</span>--%>
<%--                    </p>--%>
                    <div class="work_btn">
                        <!-- 좋아요 상품 정보 담기 : 상품 번호, 아이디 -->
                        <!-- 장바구니 상품 정보 담기 : 상품 번호, 아이디, 사이즈, 색상, 수량 -->
                        <!-- 구매 상품 정보 담기 : 상품 번호, 아이디, 사이즈, 색상, 수량  -->

                        <button class="heart-btn">
                            <i class="fa-regular fa-heart"></i>
                            <!-- 추후에 db에서 num만 조회해서 좋아요 상품 등록하게 만들기-->
                            <div class="item-info">
                                <input class="num" type="hidden" value=${itemDetail.num}>
                                <input class="name" type="hidden" value="${itemDetail.detail_name}">
                                <input class="price" type="hidden" value=${itemDetail.price}>
                                <input class="disc_price" type="hidden" value=${itemDetail.disc_price}>
                                <input class="cust_type" type="hidden" value="${itemDetail.cust_type}">
                            </div>
                        </button>
                        <button class="cart-btn">장바구니</button>
                        <button class="order-btn">바로구매</button>
                        <form class="order-form" action="/goods/${itemDetail.num}" method="post">
                        </form>
                    </div>
                    <div class="total_price_box">
                        <span>총 상품금액</span>
                        <span>
                                <span class="total_price"><fmt:formatNumber value="${itemDetail.disc_price}" pattern="#,###"/></span> 원
                            </span>
                    </div>
                </div>
            </div>
        </div>
        <div class="review">
            <p>REVIEW (<span>25727</span>)</p>
            <div class="avg_star">
                <div>
                    <p>
                        <i class="fa-solid fa-star" style="color: #FFD43B;"></i>
                        <span>4.9</span>
                    </p>
                    <p>
                        <span>96</span>%의 구매자가 이 상품을 좋아합니다.
                    </p>
                </div>
                <div>
                    <ul>
                        <li>
                            <span>아주 좋아요</span>
                            <div>
                                <div style="width: 87%;"></div>
                            </div>
                            <span>23828</span>
                        </li>
                        <li>
                            <span>맘에 들어요</span>
                            <div>
                                <div style="width: 9%;"></div>
                            </div>
                            <span>938</span>
                        </li>
                        <li>
                            <span>보통이에요</span>
                            <div>
                                <div style="width: 3%;"></div>
                            </div>
                            <span>785</span>
                        </li>
                        <li>
                            <span>그냥 그래요</span>
                            <div>
                                <div style="width: 0%;"></div>
                            </div>
                            <span>56</span>
                        </li>
                        <li>
                            <span>별로에요</span>
                            <div>
                                <div style="width: 1%;"></div>
                            </div>
                            <span>120</span>
                        </li>
                    </ul>
                </div>
            </div>
            <ul>
                <li>최신순</li>
                <li>별점순</li>
            </ul>
            <ul class="review_list">
                <c:forEach var="reviewList" items="${reviewList}">
                    <li>
                        <div>
                            <div class="wrap-star">
                                <div class='star-rating'>
                                    <span style="width:${20*reviewList.score}%"></span>
                                </div>
                                <span><dateOK:formatDate value="${reviewList.reg_date}" pattern="yyyy.M.d"/></span>
                            </div>
                            <p>${reviewList.title}</p>
                            <p>${reviewList.content}</p>
                            <ul class="review_pic">
                                <li>
                                    <img src="/img/302review5.jpeg" alt="">
                                </li>
                            </ul>
                        </div>
                        <div>
                            <p><span>${reviewList.writer}</span>님의 리뷰입니다.</p>
                        </div>
                </c:forEach>
                <li>
                    <div>
                        <div class="wrap-star">
                            <div class='star-rating'>
                                <span style="width:100%"></span>
                            </div>
                            <span>2024.5.28</span>
                        </div>
                        <p>사이즈는 만족해요!</p>
                        <p>길이는 살짝 짧은기장이고 기모라 따뜻해요 프린팅도 예뻐서 요즘 자주 입게됩니당 굳굳</p>
                        <ul class="review_pic">
                            <li>
                                <img src="/img/302review7_1.jpeg" alt="">
                            </li>
                            <li>
                                <img src="/img/302review7_2.jpeg" alt="">
                            </li>
                        </ul>
                    </div>
                    <div>
                        <p><span>코딩하는고양이</span>님의 리뷰입니다.</p>
                    </div>
                </li>
                <li>
                    <div>
                        <div class="wrap-star">
                            <div class='star-rating'>
                                <span style="width:100%"></span>
                            </div>
                            <span>2024.5.28</span>
                        </div>
                        <p>옷은 이쁜데 사이즈가 아쉬워요</p>
                        <p>원래 L사이즈 입는데 크게 나온거 같아요. 한 사이즈 다운해서 구매하시는걸 추천드릴게요...</p>
                        <ul class="review_pic">
                            <li>
                                <img src="/img/302review6.jpeg" alt="">
                            </li>
                        </ul>
                    </div>
                    <div>
                        <p><span>객체지향적인삶</span>님의 리뷰입니다.</p>
                    </div>
                </li>
                <li>
                    <div>
                        <div class="wrap-star">
                            <div class='star-rating'>
                                <span style="width:100%"></span>
                            </div>
                            <span>2024.5.28</span>
                        </div>
                        <p>옷에서 뭔 냄새가 이렇게 많이 나는겁니까</p>
                        <p>옷에서 냄새가 너무 많이 나는것같은데요;;;; 분명 받자마자 4번 정도 빨아서 섬유유연제 한 통 다 쓴 것같은데도 냄새가 아직도 안 빠져요;;; 저만 이런건지 다른
                            분들도 그런건지 모르겠지만, 뭔 이상한 가죽냄새가 진하게 베어있습니다. 사실 때 비슷한 냄새 난다 싶으면 다른 분들은 그냥 환불하시는게 나을 것 같아요!!! 꼮꼮
                            주의해주세요!!!</p>
                        <ul class="review_pic">
                            <li>
                                <img src="/img/302review4.jpeg" alt="">
                            </li>
                        </ul>
                    </div>
                    <div>
                        <p><span>서울의 spring-boot</span>님의 리뷰입니다.</p>
                    </div>
                </li>
                <li>
                    <div>
                        <div class="wrap-star">
                            <div class='star-rating'>
                                <span style="width:100%"></span>
                            </div>
                            <span>2024.5.28</span>
                        </div>
                        <p>만족합니다. 최근에 삿던 옷중에 꽤 맘에 듭니다. </p>
                        <p>한번 입어보고 나서 너무 맘에 들어서 저는 3장 바로 연속해서 샀어요!!! 옷이 튼튼해서 거칠게 다뤄도 옷이 찌그러지거나 헐거워지지도 않아서 밖에서나 안에서나 불편함
                            없이 막 입기 너무 좋은것같아요!!!!</p>
                        <ul class="review_pic">
                            <li>
                                <img src="/img/302review3.jpeg" alt="">
                            </li>
                        </ul>
                    </div>
                    <div>
                        <p><span>너의꿈을JAVA</span>님의 리뷰입니다.</p>
                    </div>
                </li>
                <li>
                    <div>
                        <div class="wrap-star">
                            <div class='star-rating'>
                                <span style="width:100%"></span>
                            </div>
                            <span>2024.5.28</span>
                        </div>
                        <p>친구 선물로 사줬는데 진짜 최고인것같습니다.</p>
                        <p>최근에 친구가 생일이었어서 줄 거 없어서 그냥 이거 사다줬는데 좋아죽더라구요 ㅋㅋㅋ 사이즈도 좀 넉넉하게 나오고 호불호 있는 옷이 아니라서 친구 취향 모를 때, 선물로
                            주기 최고인것같네요 ㅋㅋ가격도 부담스럽지 않고 선물해주고 더 크게 받을 수 있을 것 같습니닼ㅋ 재구매 의사 아주 많이 있어요!!</p>
                        <ul class="review_pic">
                            <li>
                                <img src="/img/302review2.jpeg" alt="">
                            </li>
                        </ul>
                    </div>
                    <div>
                        <p><span>TOPisNEO</span>님의 리뷰입니다.</p>
                    </div>
                </li>
                <li>
                    <div>
                        <div class="wrap-star">
                            <div class='star-rating'>
                                <span style="width:80%"></span>
                            </div>
                            <span>2024.5.28</span>
                        </div>
                        <p>멀리서 누가 입은 걸 보고 찾아서 사버렸는데...최고</p>
                        <p>홍대 근처에서 어떤 분이 입고 있는 모습을 보고 너무 이뻐서 한참 웹사이트 돌아다니다가 상품 찾고 나서 환호성 지르면서 바로 사버렸습니다. ㅋㅋㅋ 역시나 제 눈은 틀리지 않았어욬ㅋㅋ 입는 동안 너무 행복합니다. 옷이 너무 이쁜 것같아요 ㅠ 나중에 옷 사라질것같아서 5장정도 사서 옷장에다가 보관해놔야겠어요 ㅋ</p>
                        <ul class="review_pic">
                            <li>
                                <img src="/img/302review1.jpeg" alt="">
                            </li>
                        </ul>
                    </div>
                    <div>
                        <p><span>NEOisBest</span>님의 리뷰입니다.</p>
                    </div>
                </li>
            </ul>
            <div class="paging_box">
                <p class="reviewIndex"><&nbsp;&nbsp;1&nbsp;&nbsp;2&nbsp;&nbsp;3&nbsp;&nbsp;4&nbsp;&nbsp;5&nbsp;&nbsp;></p>
            </div>
        </div>
    </div>
</section>
<jsp:include page="/WEB-INF/views/include/footer.jsp"/>
<jsp:include page="/WEB-INF/views/include/quick.jsp"/>
<div class="modal_bg"></div>
<div class="modal_box"></div>
<script src="/js/jquery-3.6.4.min.js"></script>
<script src="/js/nav.js"></script>
<script src="/js/detail.js?after"></script>
</body>
</html>