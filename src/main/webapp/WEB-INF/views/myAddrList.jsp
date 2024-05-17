<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="ko">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>BYEZ</title>
    <link rel="stylesheet" href="css/nav.css">
    <link rel="stylesheet" href="css/myAddrList.css">
    <link rel="stylesheet" href="css/footer.css">
    <link rel="stylesheet" href="css/quick.css">
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
                <img src="img/logo3.png" alt="">
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
                    <img src="img/top_mypage.png">
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
            <li><a href="#"><img src="img/top_search.png"></a></li>
            <li><a href="like"><img src="img/top_wish.png"></a></li>
            <li><a href="basket" class="cart_cnt">
                <img src="img/top_cart_pc.png">
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
<section>
    <div class="wrapper">
        <div class="title">
            <p>
                <a href="main.html"><span>home</span></a>
                <span>></span>
                <a href="myAddrList.html"><span>배송 주소록 관리</span></a>
            </p>
            <p>배송 주소록 관리</p>
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
                            <li><a href="goMyCouponPage">쿠폰</a></li>
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
        <div class="content">
            <p class="table_title">
                <span>(총 배송지 수 : <span>${addresses.size()}</span>)</span>
            </p>
            <table>
                <thead>
                <tr>
                    <th>배송지명</th>
                    <th>수령인</th>
                    <th>일반전화</th>
                    <th>휴대전화</th>
                    <th>주소</th>
                    <th>수정</th>
                    <th>삭제</th>
                </tr>
                </thead>
                <tbody>
                <c:forEach items="${addresses}" var="address">
                    <tr>
                        <td>${address.nick}</td>
                        <td>${address.recipient}</td>
                        <td>${address.telNum}</td>
                        <td>${address.mobileNum}</td>
                        <td>(${address.zpcd})${address.mainAddr} ${address.detailAddr}</td>
                        <td><a href="#" class="edit_btn" onclick="goAddrEditForm(${address.seq})">수정</a></td>
                        <td><a href="#" class="delete_btn" onclick="deleteAddress(${address.seq})">삭제</a></td>
                    </tr>
                </c:forEach>
                </tbody>
            </table>
            <div class="btn_wrapper"> <!-- 버튼을 감싸는 div -->
                <a href="goAddrRegisterForm" class="add_address_btn">배송지등록</a>
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
        <img src="img/quick_up.png" alt="">
    </a>
    <a href="#none" onclick="jQuery('html,body').animate({scrollTop:$(document).height()},'slow');">
        <img src="img/quick_down.png" alt="">
    </a>
</div>
<script src="js/jquery-3.6.4.min.js"></script>
<script src="js/nav.js"></script>
<script>
    function goAddrEditForm(seq) {
        window.location.href = 'goAddrEditForm?seq=' + seq;
    }


    function deleteAddress(seq) {
        var confirmDelete = confirm("정말로 삭제하시겠습니까?");
        if (confirmDelete) {
            window.location.href = 'deleteAddress?seq=' + seq;
        }
    }
</script>
</body>
</html>