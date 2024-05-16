<%@ page language="java" contentType="text/html; charset=UTF-8"  pageEncoding="UTF-8"%>
<nav>
    <div class="wrapper">
        <div class="nav_logo">
            <a href="/">
                <img src="img/logo3.png" alt="">
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
                    <img src="img/top_mypage.png">
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
            <li><a><img src="img/top_search.png"></a></li>
            <li><a href="/like"><img src="img/top_wish.png"></a></li>
            <li><a href="/basket" class="cart_cnt">
                <img src="img/top_cart_pc.png">
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
                <img src="img/top_search_close.png" alt="">
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
