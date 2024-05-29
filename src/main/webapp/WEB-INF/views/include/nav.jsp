<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<nav>
    <div class="wrapper">
        <div class="nav_logo">
            <a href="/">
                <img src="/img/logo1.png" alt="">
            </a>
        </div>
        <ul class="nav_menu">
            <li><a href="/item/discount">할인 상품</a></li>
            <li><a href="/item/best">베스트</a></li>
            <li><a href="/item/categories/02">여성</a></li>
            <li><a href="/item/categories/01">남성</a></li>
            <li><a href="/item/categories/03">혼성</a></li>
        </ul>
        <ul class="nav_member">
            <li class="hover">
            <c:if test="${sessionScope.loginState != null}">
                <a href="/mypage/index">
            </c:if>
            <c:if test="${sessionScope.loginState == null}">
                <a href="/login/form">
            </c:if>
                    <img src="/img/top_mypage.png">
                </a>
                <ul class="sub_menu">

                    <%-- 로그인 상태 --%>
                    <c:if test="${sessionScope.loginState != null}">
                        <li><a href="/login/out">LOGOUT</a>
                        </li>
<%--                        <li><a href="mypage.html">MYPAGE</a>--%>
                        <%-- 수인 테스트용 MYPAGE INDEX --%>
                        <li><a href="/order/list">MYPAGE</a>
                        </li>
                        <li><a href="/order/list">ORDER</a>
                        </li>
                    </c:if>
                    <%-- 로그아웃 상태 --%>
                    <c:if test="${sessionScope.loginState == null}">
                        <li><a href="/login/form">LOGIN</a>
                        </li>
                        <li><a href="/order/list">ORDER</a>
                        </li>
                    </c:if>
                </ul>
            </li>
            <li class="nav_search_btn"><a><img src="/img/top_search.png"></a></li>
            <li><a href="/like"><img src="/img/top_wish.png"></a></li>
            <li><a href="/basket" class="cart_cnt">
                <img src="/img/top_cart_pc.png">
                <div>
<%--                    <span>${basketCnt}</span>--%>
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
                    <li><a href="/item/categories/0201">상의</a></li>
                    <li><a href="/item/categories/020101">맨투맨/스웨트셔츠</a></li>
                    <li><a href="/item/categories/020102">후드/집업</a></li>
                    <li><a href="/item/categories/020103">니트/스웨터</a></li>
                    <li><a href="/item/categories/020104">셔츠/블라우스</a></li>
                    <li><a href="/item/categories/020105">긴팔 티셔츠</a></li>
                    <li><a href="/item/categories/020106">반팔 티셔츠</a></li>
                    <li><a href="/item/categories/020107">슬리브리스</a></li>
                </ul>
            </li>
            <li>
                <ul>
                    <li><a href="/item/categories/0202">아우터</a></li>
                    <li><a href="/item/categories/020201">패딩/다운</a></li>
                    <li><a href="/item/categories/020202">폴리스/덤블</a></li>
                    <li><a href="/item/categories/020203">자켓/점퍼</a></li>
                    <li><a href="/item/categories/020204">블레이저</a></li>
                    <li><a href="/item/categories/020205">가디건</a></li>
                    <li><a href="/item/categories/020206">바람막이</a></li>
                </ul>
            </li>
            <li>
                <ul>
                    <li><a href="/item/categories/0203">하의</a></li>
                    <li><a href="/item/categories/020301">슬랙스</a></li>
                    <li><a href="/item/categories/020302">트레이닝/스웨트셔츠</a></li>
                    <li><a href="/item/categories/020303">팬츠</a></li>
                    <li><a href="/item/categories/020304">숏츠</a></li>
                    <li><a href="/item/categories/020305">스커트</a></li>
                </ul>
            </li>
            <li>
                <ul>
                    <li><a href="/item/categories/0204">신발</a></li>
                    <li><a href="/item/categories/020101">운동화</a></li>
                    <li><a href="/item/categories/020102">구두</a></li>
                    <li><a href="/item/categories/020103">로퍼</a></li>
                    <li><a href="/item/categories/020104">힐</a></li>
                    <li><a href="/item/categories/020105">부츠</a></li>
                    <li><a href="/item/categories/020106">슬리퍼</a></li>
                    <li><a href="/item/categories/020107">샌달</a></li>
                </ul>
            </li>
            <li>
                <ul>
                    <li><a href="/item/categories/99">액세사리</a></li>
                </ul>
            </li>
            <li class="nav_img">
                <img src="/img/woman.jpeg">
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
                    <li><a href="/item/categories/0101">상의</a></li>
                    <li><a href="/item/categories/010101">맨투맨/스웨트셔츠</a></li>
                    <li><a href="/item/categories/010102">후드/집업</a></li>
                    <li><a href="/item/categories/010103">니트/스웨터</a></li>
                    <li><a href="/item/categories/010104">셔츠/블라우스</a></li>
                    <li><a href="/item/categories/010105">긴팔 티셔츠</a></li>
                    <li><a href="/item/categories/010106">반팔 티셔츠</a></li>
                    <li><a href="/item/categories/010107">슬리브리스</a></li>
                </ul>
            </li>
            <li>
                <ul>
                    <li><a href="/item/categories/0102">아우터</a></li>
                    <li><a href="/item/categories/010201">패딩/다운</a></li>
                    <li><a href="/item/categories/010202">폴리스/덤블</a></li>
                    <li><a href="/item/categories/010203">자켓/점퍼</a></li>
                    <li><a href="/item/categories/010204">블레이저</a></li>
                    <li><a href="/item/categories/010205">가디건</a></li>
                    <li><a href="/item/categories/010206">바람막이</a></li>
                </ul>
            </li>
            <li>
                <ul>
                    <li><a href="/item/categories/0103">하의</a></li>
                    <li><a href="/item/categories/010301">슬랙스</a></li>
                    <li><a href="/item/categories/010302">트레이닝/스웨트셔츠</a></li>
                    <li><a href="/item/categories/010303">팬츠</a></li>
                    <li><a href="/item/categories/010304">숏츠</a></li>
                </ul>
            </li>
            <li>
                <ul>
                    <li><a href="/item/categories/0104">신발</a></li>
                    <li><a href="/item/categories/040101">운동화</a></li>
                    <li><a href="/item/categories/040102">구두</a></li>
                    <li><a href="/item/categories/040103">로퍼</a></li>
                    <li><a href="/item/categories/040105">부츠</a></li>
                    <li><a href="/item/categories/040106">슬리퍼</a></li>
                    <li><a href="/item/categories/040107">샌달</a></li>
                </ul>
            </li>
            <li>
                <ul>
                    <li><a href="/item/categories/99">액세사리</a></li>
                </ul>
            </li>
            <li class="nav_img">
                <img src="/img/man.jpeg">
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
                    <li><a href="/item/categories/0301">상의</a></li>
                    <li><a href="/item/categories/030101">맨투맨/스웨트셔츠</a></li>
                    <li><a href="/item/categories/030102">후드/집업</a></li>
                    <li><a href="/item/categories/030103">니트/스웨터</a></li>
                    <li><a href="/item/categories/030104">셔츠/블라우스</a></li>
                    <li><a href="/item/categories/030105">긴팔 티셔츠</a></li>
                    <li><a href="/item/categories/030106">반팔 티셔츠</a></li>
                    <li><a href="/item/categories/030107">슬리브리스</a></li>
                </ul>
            </li>
            <li>
                <ul>
                    <li><a href="/item/categories/0302">아우터</a></li>
                    <li><a href="/item/categories/030201">패딩/다운</a></li>
                    <li><a href="/item/categories/030202">폴리스/덤블</a></li>
                    <li><a href="/item/categories/030203">자켓/점퍼</a></li>
                    <li><a href="/item/categories/030204">블레이저</a></li>
                    <li><a href="/item/categories/030205">가디건</a></li>
                    <li><a href="/item/categories/030206">바람막이</a></li>
                </ul>
            </li>
            <li>
                <ul>
                    <li><a href="/item/categories/0303">하의</a></li>
                    <li><a href="/item/categories/030301">슬랙스</a></li>
                    <li><a href="/item/categories/030302">트레이닝/스웨트셔츠</a></li>
                    <li><a href="/item/categories/030303">팬츠</a></li>
                    <li><a href="/item/categories/030304">숏츠</a></li>
                </ul>
            </li>
            <li>
                <ul>
                    <li><a href="/item/categories/0304">신발</a></li>
                    <li><a href="/item/categories/030401">운동화</a></li>
                    <li><a href="/item/categories/030402">구두</a></li>
                    <li><a href="/item/categories/030403">로퍼</a></li>
                    <li><a href="/item/categories/030405">부츠</a></li>
                    <li><a href="/item/categories/030406">슬리퍼</a></li>
                    <li><a href="/item/categories/030407">샌달</a></li>
                </ul>
            </li>
            <li>
                <ul>
                    <li><a href="/item/categories/99">액세사리</a></li>
                </ul>
            </li>
            <li class="nav_img">
                <img src="/img/uni.jpeg">
            </li>
        </ul>
    </div>
    <div class="search_div">
        <div>
            <p>
                고객님<br>무엇을 찾으시나요?
                <img src="/img/top_search_close.png" alt="">
            </p>
            <form id="searchForm">
                <input type="text" id="searchInput" placeholder="상품을 찾아보세요">
                <button type="submit">
                    <i class="fa-solid fa-magnifying-glass"></i>
                </button>
            </form>
        </div>
    </div>
    <div class="shadow"></div>
</nav>
