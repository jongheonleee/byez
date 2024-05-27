<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"  pageEncoding="UTF-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%--찬빈추가--%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="dateOK" %>
<!DOCTYPE html>
<html lang="ko">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>BYEZ</title>
    <link rel="stylesheet" href="/css/nav.css">
    <link rel="stylesheet" href="/css/detail.css?after?after?after?after?after">
    <link rel="stylesheet" href="/css/footer.css">
    <link rel="stylesheet" href="/css/quick.css">
    <script src="https://kit.fontawesome.com/f0e73cfa04.js" crossorigin="anonymous"></script>
    <link rel="preconnect" href="https://fonts.googleapis.com">
    <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
    <link href="https://fonts.googleapis.com/css2?family=Noto+Sans+KR:wght@100..900&display=swap" rel="stylesheet">

</head>
<body>
<%@include file="../views/include/nav.jsp"%>
<section>
    <div class="wrapper">
        <p>
            <a href="/"><span>home</span></a>
        </p>
        <div class="info">
            <div class="infoImgWrapper">
                <div class="foldImg">
                    <img src="/img/${itemDto.main_img}" alt="" class="detail_img">
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
                <p>제조일자 : <span class="mfg_date">${itemDetail.mfg_date}</span></p>
                <p>상품출시일자 : <span class="rel_date"></span></p>
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
                        <input type="hidden" class="opt2" name="opt2" >
                        <select class="changeOpt2" onchange="selectOpt2(this.value);">
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
                        <input type="hidden" class="opt1" name="opt1">
                        <select class="changeOpt1" onchange="selectOpt1(this.value);">
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
            <p>REVIEW (<span>12,345</span>)</p>
            <div class="avg_star">
                <div>
                    <p>
                        <i class="fa-solid fa-star" style="color: #FFD43B;"></i>
                        <span>4.5</span>
                    </p>
                    <p>
                        <span>100</span>%의 구매자가 이 상품을 좋아합니다.
                    </p>
                </div>
                <div>
                    <ul>
                        <li>
                            <span>아주 좋아요</span>
                            <div>
                                <div style="width: 50%;"></div>
                            </div>
                            <span>10000</span>
                        </li>
                        <li>
                            <span>맘에 들어요</span>
                            <div>
                                <div style="width: 0%;"></div>
                            </div>
                            <span>10000</span>
                        </li>
                        <li>
                            <span>보통이에요</span>
                            <div>
                                <div style="width: 90%;"></div>
                            </div>
                            <span>10000</span>
                        </li>
                        <li>
                            <span>그냥 그래요</span>
                            <div>
                                <div style="width: 9%;"></div>
                            </div>
                            <span>10000</span>
                        </li>
                        <li>
                            <span>별로에요</span>
                            <div>
                                <div style="width: 70%;"></div>
                            </div>
                            <span>10000</span>
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
                                <span style ="width:${20*reviewList.score}%"></span>
                        </div>
                        </div>
                        <span><dateOK:formatDate value="${reviewList.reg_date}" pattern="yyyy.M.d" /></span>
                        <p>${reviewList.title}</p>
                        <p>${reviewList.content}</p>
                        <ul class="review_pic">
                            <li>
                                <img src="/img/hello1.jpeg" alt="">
                            </li>
                            <li>
                                <img src="/img/hello2.jpeg" alt="">
                            </li>
                            <li>
                                <img src="/img/hello4.jpeg" alt="">
                            </li>
                        </ul>
                    </div>
                    <div>
                        <p><span>${reviewList.writer}</span>님의 리뷰입니다.</p>
                    </div>
                </li>
                </c:forEach>
                <li>
                    <div>
                        <div class="wrap-star">
                            <div class='star-rating'>
                                <span style ="width:60%"></span>
                            </div>
                            <span>2021.6.10</span>
                        </div>
                        <p>첫번째 볼드체 p태그~~~~~</p>
                        <p>체격이 있는 편인데 XL도 큰 느낌은 아니어서 XXL가 딱 적당해요! 더운 봄 날씨 와중에 냉방병이나 비온 뒤 급 쌀쌀한 날씨 커버 해주기에는 부족함이 딱히 없어요. 엄청 가볍고 얇은데다 어느 정도 방수도 되기 때문에 작은 비 정도는 원 마일 웨어로 문제 없습니다! 접을 수 있도록 스트랩과 주머니 뒷 부분이 잘 되어 있어서 평상시 휴대하기에도 너무 만족스러워요. 다만 지퍼가 잘 집혀서 지퍼 마감만 좋은 지퍼로 바꿔주면 더 좋을 것 같아요.</p>
                        <ul class="review_pic">
                            <li>
                                <img src="/img/hello1.jpeg" alt="">
                            </li>
                            <li>
                                <img src="/img/hello2.jpeg" alt="">
                            </li>
                            <li>
                                <img src="/img/hello4.jpeg" alt="">
                            </li>
                        </ul>
                    </div>
                    <div>
                        <p><span>무신사 리뷰 작성자</span>님의 리뷰입니다.</p>
                    </div>
                </li>
                <li>
                    <div>
                        <div class="wrap-star">
                            <div class='star-rating'>
                                <span style ="width:40%"></span>
                            </div>
                            <span>2021.6.10</span>
                        </div>
                        <p>첫번째 볼드체 p태그~~~~~</p>
                        <p>체격이 있는 편인데 XL도 큰 느낌은 아니어서 XXL가 딱 적당해요! 더운 봄 날씨 와중에 냉방병이나 비온 뒤 급 쌀쌀한 날씨 커버 해주기에는 부족함이 딱히 없어요. 엄청 가볍고 얇은데다 어느 정도 방수도 되기 때문에 작은 비 정도는 원 마일 웨어로 문제 없습니다! 접을 수 있도록 스트랩과 주머니 뒷 부분이 잘 되어 있어서 평상시 휴대하기에도 너무 만족스러워요. 다만 지퍼가 잘 집혀서 지퍼 마감만 좋은 지퍼로 바꿔주면 더 좋을 것 같아요.</p>
                        <ul class="review_pic">
                            <li>
                                <img src="/img/hello1.jpeg" alt="">
                            </li>
                            <li>
                                <img src="/img/hello2.jpeg" alt="">
                            </li>
                        </ul>
                    </div>
                    <div>
                        <p><span>무신사 리뷰 작성자</span>님의 리뷰입니다.</p>
                    </div>
                </li>
                <li>
                    <div>
                        <div class="wrap-star">
                            <div class='star-rating'>
                                <span style ="width:100%"></span>
                            </div>
                            <span>2021.6.10</span>
                        </div>
                        <p>첫번째 볼드체 p태그~~~~~</p>
                        <p>체격이 있는 편인데 XL도 큰 느낌은 아니어서 XXL가 딱 적당해요! 더운 봄 날씨 와중에 냉방병이나 비온 뒤 급 쌀쌀한 날씨 커버 해주기에는 부족함이 딱히 없어요. 엄청 가볍고 얇은데다 어느 정도 방수도 되기 때문에 작은 비 정도는 원 마일 웨어로 문제 없습니다! 접을 수 있도록 스트랩과 주머니 뒷 부분이 잘 되어 있어서 평상시 휴대하기에도 너무 만족스러워요. 다만 지퍼가 잘 집혀서 지퍼 마감만 좋은 지퍼로 바꿔주면 더 좋을 것 같아요.</p>
                        <ul class="review_pic">
                            <li>
                                <img src="/img/hello1.jpeg" alt="">
                            </li>
                        </ul>
                    </div>
                    <div>
                        <p><span>무신사 리뷰 작성자</span>님의 리뷰입니다.</p>
                    </div>
                </li>
                <li>
                    <div>
                        <div class="wrap-star">
                            <div class='star-rating'>
                                <span style ="width:20%"></span>
                            </div>
                            <span>2021.6.10</span>
                        </div>
                        <p>첫번째 볼드체 p태그~~~~~첫번째 볼드체 p태그~~~~~첫번째 볼드체 p태그~~~~~첫번째 볼드체 p태그~~~~~첫번째 볼드체 p태그~~~~~첫번째 볼드체 p태그~~~~~첫번째 볼드체 p태그~~~~~첫번째 볼드체 p태그~~~~~첫번째 볼드체 p태그~~~~~첫번째 볼드체 p태그~~~~~첫번째 볼드체 p태그~~~~~첫번째 볼드체 p태그~~~~~첫번째 볼드체 p태그~~~~~첫번째 볼드체 p태그~~~~~첫번째 볼드체 p태그~~~~~</p>
                        <p>체격이 있는 편인데 XL도 큰 느낌은 아니어서 XXL가 딱 적당해요! 더운 봄 날씨 와중에 냉방병이나 비온 뒤 급 쌀쌀한 날씨 커버 해주기에는 부족함이 딱히 없어요. 엄청 가볍고 얇은데다 어느 정도 방수도 되기 때문에 작은 비 정도는 원 마일 웨어로 문제 없습니다! 접을 수 있도록 스트랩과 주머니 뒷 부분이 잘 되어 있어서 평상시 휴대하기에도 너무 만족스러워요. 다만 지퍼가 잘 집혀서 지퍼 마감만 좋은 지퍼로 바꿔주면 더 좋을 것 같아요.</p>
                        <ul class="review_pic">
                            <li>
                                <img src="/img/hello1.jpeg" alt="">
                            </li>
                            <li>
                                <img src="/img/hello2.jpeg" alt="">
                            </li>
                            <li>
                                <img src="/img/hello3.jpeg" alt="">
                            </li>
                        </ul>
                    </div>
                    <div>
                        <p><span>무신사 리뷰 작성자</span>님의 리뷰입니다.</p>
                    </div>
                </li>
                <li>
                    <div>
                        <div class="wrap-star">
                            <div class='star-rating'>
                                <span style ="width:0%"></span>
                            </div>
                            <span>2021.6.10</span>
                        </div>
                        <p>첫번째 볼드체 p태그~~~~~</p>
                        <p>체격이 있는 편인데 XL도 큰 느낌은 아니어서 XXL가 딱 적당해요! 더운 봄 날씨 와중에 냉방병이나 비온 뒤 급 쌀쌀한 날씨 커버 해주기에는 부족함이 딱히 없어요. 엄청 가볍고 얇은데다 어느 정도 방수도 되기 때문에 작은 비 정도는 원 마일 웨어로 문제 없습니다! 접을 수 있도록 스트랩과 주머니 뒷 부분이 잘 되어 있어서 평상시 휴대하기에도 너무 만족스러워요. 다만 지퍼가 잘 집혀서 지퍼 마감만 좋은 지퍼로 바꿔주면 더 좋을 것 같아요.</p>
                        <ul class="review_pic">
                            <li>
                                <img src="/img/hello1.jpeg" alt="">
                            </li>
                            <li>
                                <img src="/img/hello2.jpeg" alt="">
                            </li>
                            <li>
                                <img src="/img/hello3.jpeg" alt="">
                            </li>
                        </ul>
                    </div>
                    <div>
                        <p><span>무신사 리뷰 작성자</span>님의 리뷰입니다.</p>
                    </div>
                </li>
                <li>
                    <div>
                        <div class="wrap-star">
                            <div class='star-rating'>
                                <span style ="width:80%"></span>
                            </div>
                            <span>2021.6.10</span>
                        </div>
                        <p>첫번째 볼드체 p태그~~~~~첫번째 볼드체 p태그~~~~~첫번째 볼드체 p태그~~~~~첫번째 볼드체 p태그~~~~~첫번째 볼드체 p태그~~~~~첫번째 볼드체 p태그~~~~~첫번째 볼드체 p태그~~~~~첫번째 볼드체 p태그~~~~~첫번째 볼드체 p태그~~~~~첫번째 볼드체 p태그~~~~~첫번째 볼드체 p태그~~~~~첫번째 볼드체 p태그~~~~~첫번째 볼드체 p태그~~~~~</p>
                        <p>체격이 있는 편인데 XL도 큰 느낌은 아니어서 XXL가 딱 적당해요! 더운 봄 날씨 와중에 냉방병이나 비온 뒤 급 쌀쌀한 날씨 커버 해주기에는 부족함이 딱히 없어요. 엄청 가볍고 얇은데다 어느 정도 방수도 되기 때문에 작은 비 정도는 원 마일 웨어로 문제 없습니다! 접을 수 있도록 스트랩과 주머니 뒷 부분이 잘 되어 있어서 평상시 휴대하기에도 너무 만족스러워요. 다만 지퍼가 잘 집혀서 지퍼 마감만 좋은 지퍼로 바꿔주면 더 좋을 것 같아요.</p>
                        <ul class="review_pic">
                            <li>
                                <img src="/img/hello1.jpeg" alt="">
                            </li>
                            <li>
                                <img src="/img/hello2.jpeg" alt="">
                            </li>
                            <li>
                                <img src="/img/hello3.jpeg" alt="">
                            </li>
                        </ul>
                    </div>
                    <div>
                        <p><span>무신사 리뷰 작성자</span>님의 리뷰입니다.</p>
                    </div>
                </li>
            </ul>
            <div class="paging_box">
                <p>페이징 부분!!! 지워도 됨~~~~일단 이부분 주석잡아주고 페이징 백단 끝난후 css문제 있으면 부르세용</p>
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