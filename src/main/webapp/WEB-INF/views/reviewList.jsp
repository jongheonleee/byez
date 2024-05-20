<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"  pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ko">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>BYEZ</title>
    <link rel="stylesheet" href="/css/nav.css">
    <link rel="stylesheet" href="/css/review_list.css?after">
    <link rel="stylesheet" href="/css/footer.css">
    <link rel="stylesheet" href="/css/quick.css">
    <!-- 추가합니다 -->
    <!-- <link rel="stylesheet" href="css/tab_template.css"> -->
    <!--  -->
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
            <li><a href="discount.html">할인 상품</a></li>
            <li><a href="best.html">베스트</a></li>
            <li><a href="category.html">여성</a></li>
            <li><a href="category.html">남성</a></li>
            <li><a href="category.html">혼성</a></li>
        </ul>
        <ul class="nav_member">
            <li class="hover">
                <a href="mypage.html">
                    <img src="/img/top_mypage.png">
                </a>
                <ul class="sub_menu">
                    <li><a href="loginForm">LOGIN</a>
                    </li>
                    <li><a href="#">ORDER</a>
                    </li>
                </ul>
                <!-- <ul class="sub_menu">
                    <li><a href="#">LOGOUT</a>
                    </li>
                    <li><a href="mypage.html">MYPAGE</a>
                    </li>
                    <li><a href="#">ORDER</a>
                    </li>
                </ul> -->
            </li>
            <li><a href="#"><img src="/img/top_search.png"></a></li>
            <li><a href="like"><img src="/img/top_wish.png"></a></li>
            <li><a href="basket" class="cart_cnt">
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
                <span>></span>
                <a href="/review/list"><span>리뷰</span></a>

            </p>
            <p>나의 게시물 관리</p>
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

        <!-- 탭 메뉴 -->
        <ul class="tab_menu">
            <li><a href="#tab1-1">작성 가능한 리뷰</a></li>
            <li><a href="#tab1-2">작성 완료한 리뷰</a></li>
        </ul>
        <!-- 탭 콘텐츠 -->
        <div class="content">
            <!--작성 "가능한" 리뷰-->
            <div id="tab1-1" class="tab_content">
                <c:forEach var="offList" items="${reviewOffList}">
                    <!-- 1st -->
                    <div class="container">
                        <!-- 이미지 -->
                        <div class="box box1">
                            <img src="/img/1.jpeg" alt="Product Image">
                        </div>
                        <!-- 상품상세 -->
                        <div class="box box2">
                            <h4>${offList.item_name}</h4>
                            <h6>${offList.opt1},${offList.opt2}</h6>
                            <h6>${offList.reg_date}</h6>
                        </div>
                        <!-- 리뷰버튼 -->
                        <div class="box box3">
                            <a href="/review/write?ord_num=${offList.ord_num}&item_num=${offList.item_num}">
                                <button>작성하기</button>
                            </a>
                        </div>
                    </div>
                </c:forEach>
            </div>

            <!-- 작성 "완료한" 리뷰 -->
            <div id="tab1-2" class="tab_content">
                <div class="content">
                    <ul>
                        <c:forEach var="onList" items="${reviewOnList}">
                            <li class="reviewDone">
                                <div class="first">
                                    <div class="first_image"><img src="/img/1.jpeg"></div>
                                    <div class="first_info">
                                        <p>상품명 : ${onList.item_name}</p>
                                        <p>별점 : ${onList.score}</p>
                                        <p>한줄평 : ${onList.title}</p>
                                        <p>${onList.content}</p>
                                    </div>
                                </div>
                                <div class="second">
                                    <p>${onList.reg_date}</p>
                                    <a href="/review/delete?review_num=${onList.review_num}" onclick="return confirm('삭제하시겠습니까?')">
                                        <button>삭제하기</button>
                                    </a>
                                    <a href="/review/modify?review_num=${onList.review_num}&ord_num=${onList.ord_num}&item_num=${onList.item_num}" onclick="return confirm('수정하시겠습니까?')">
                                        <button>수정하기</button>
                                    </a>
                                </div>
                            </li>
                        </c:forEach>
                        <!--  -->
                        <li>
                            <div class="first">
                                <div class="first_image"><img src="/img/1.jpeg"></div>
                                <div class="first_info">
                                    <p>상품명 : 옵션명</p>
                                    <p>별점</p>
                                    <p>한줄평</p>
                                    <p>이것은천자가될것이야이것은천자가될것이야이것은천자가될것이야이것은천자가될것이야이것은천자가될것이야이것은천자가될것이야이것은천자가될것이야이것은천자가될것이야이것은천자가될것이야이것은천자가될것이야이것은천자가될것이야이것은천자가될것이야이것은천자가될것이야이것은천자가될것이야이것은천자가될것이야이것은천자가될것이야이것은천자가될것이야이것은천자가될것이야이것은천자가될것이야이것은천자가될것이야이것은천자가될것이야이것은천자가될것이야이것은천자가될것이야이것은천자가될것이야이것은천자가될것이야이것은천자가될것이야이것은천자가될것이야이것은천자가될것이야이것은천자가될것이야이것은천자가될것이야이것은천자가될것이야이것은천자가될것이야이것은천자가될것이야이것은천자가될것이야이것은천자가될것이야이것은천자가될것이야이것은천자가될것이야이것은천자가될것이야이것은천자가될것이야이것은천자가될것이야이것은천자가될것이야이것은천자가될것이야이것은천자가될것이야이것은천자가될것이야이것은천자가될것이야이것은천자가될것이야이것은천자가될것이야이것은천자가될것이야이것은천자가될것이야이것은천자가될것이야이것은천자가될것이야이것은천자가될것이야이것은천자가될것이야이것은천자가될것이야이것은천자가될것이야이것은천자가될것이야이것은천자가될것이야이것은천자가될것이야이것은천자가될것이야이것은천자가될것이야이것은천자가될것이야이것은천자가될것이야이것은천자가될것이야이것은천자가될것이야이것은천자가될것이야이것은천자가될것이야이것은천자가될것이야이것은천자가될것이야이것은천자가될것이야이것은천자가될것이야이것은천자가될것이야이것은천자가될것이야이것은천자가될것이야이것은천자가될것이야이것은천자가될것이야이것은천자가될것이야이것은천자가될것이야이것은천자가될것이야이것은천자가될것이야이것은천자가될것이야이것은천자가될것이야이것은천자가될것이야이것은천자가될것이야이것은천자가될것이야이것은천자가될것이야이것은천자가될것이야이것은천자가될것이야이것은천자가될것이야이것은천자가될것이야이것은천자가될것이야이것은천자가될것이야이것은천자가될것이야이것은천자가될것이야이것은천자가될것이야이것은천자가될것이야이것은천자가될것이야이것은천자가될것이야이것은천자가될것이야이것은천자가될것이야이것은천자가될것이야이것은천자가될것이야이것은천자가될것이야이것은천자가될것이야이것은천자가될것이야이것은천자가될것이야이것은천자가될것이야이것은천자가될것이야이것은천자가될것이야이것은천자가될것이야이것은천자가될것이야</p>
                                </div>
                            </div>
                            <div class="second">
                                <p>2024. 04. 17</p>
                                <button>삭제하기</button>
                            </div>
                        </li>
                    </ul>
                </div>
            </div>
        </div>
        <script src="/js/jquery-3.6.4.min.js"></script>
        <script src="/js/tab.js"></script>
    </div></section></body>
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
</body>

</html>