<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="ko">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>BYEZ</title>
    <link rel="stylesheet" href="/css/nav.css">
    <link rel="stylesheet" href="/css/template.css">
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
            <li><a href="discount.html">할인 상품</a></li>
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
        <p>
            <a href="main.html"><span>home</span></a>
            <span>></span>
            <a href="best.html"><span>best 50</span></a>
            <!-- <span>></span>
            <a href="#"><span>중분류</span></a>
            <span>></span>
            <a href="#"><span>소분류</span></a> -->

            ${orderResultInfo}
        </p>

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
