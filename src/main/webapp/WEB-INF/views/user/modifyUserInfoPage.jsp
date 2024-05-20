<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>BYEZ</title>
    <link rel="stylesheet" href="/css/nav.css">
    <link rel="stylesheet" href="/css/modifyUserInfoPage.css">
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
                <a href="/">
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
                    <a href="mypage/index">
                        <img src="/img/top_mypage.png">
                    </a>
                    <!-- <ul class="sub_menu">
                        <li><a href="loginForm">LOGIN</a>
                        </li>
                        <li><a href="#">ORDER</a>
                        </li>
                    </ul> -->
                    <ul class="sub_menu">
                        <li><a href="/login/out">LOGOUT</a>
                        </li>
                        <li><a href="/mypage/index">MYPAGE</a>
                        </li>
                        <li><a href="#">ORDER</a>
                        </li>
                    </ul>
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
                    <a href="/"><span>home</span></a>
                    <span>></span>
                    <a href="/mypage/index"><span>마이페이지</span></a>
                </p>
                <p>회원정보 수정</p>
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
                                <li><a href="/mypage/modifyPage">회원정보 수정</a></li>
                                <li><a href="#">배송 주소록 관리</a></li>
                                <li><a href="#">나의 게시물 관리</a></li>
                                <li><a href="#">나의 문의</a></li>
                                <li><a href="#">위시리스트</a></li>
                                <li><a href="#">최근 본 상품</a></li>
                                <li><a href="/mypage/withdrawal">회원탈퇴</a></li>
                            </ul>
                        </li>
                    </ul>
                </div>
            </div>
            <div class="content">
                <p class="table_title">
                    기본 회원정보
                </p>
                <table>
                    <tr>
                        <td>아이디</td>
                        <td>${userDto.id}</td>
                        <td></td>
                    </tr>
                    <tr class="no-bottom">
                        <td>비밀번호</td>
                        <td>********</td>
                        <td><button id="modify-pwd-btn" onclick="showPwdChangeInput()">비밀번호 변경</button></td>
                    </tr>
                    <tr class="hidden no-bottom new-pwd-show">
                        <td>현재 비밀번호</td>
                        <td>
                            <input type="password" id="pwd" name="pwd" oninput="checkPwdLength()">
                            <span id="pwd-length-error-msg"></span>
                        </td>
                        <td></td>
                    </tr>
                    <tr class="hidden no-bottom new-pwd-show">
                        <td>새 비밀번호</td>
                        <td><input type="password" id="newPwd1" name="pwd"></td>
                        <td></td>
                    </tr>
                    <tr class="hidden no-bottom new-pwd-show">
                        <td>비밀번호 확인</td>
                        <td>
                            <input type="password" id="newPwd2" name="pwd" oninput="checkPwdMatch()">
                            <span id="match-error-msg"></span>
                        </td>
                        <td><button type="button" id="saveNewPwdBtn">비밀번호 저장</button></td>
                    </tr>
                    <tr class="hidden no-bottom">
                        <td></td>
                        <td id="wrong-pwd-format-msg">${wrongFormat}</td>
                        <td></td>
                    </tr>
                    <tr>
                        <td>이름</td>
                        <td>${userDto.name}</td>
                        <td></td>
                    </tr>
                    <tr class="no-bottom">
                        <td>생년월일</td>
                        <td>${userDto.bef_birth}</td>
                        <td><button id="modify-bef-birth" onclick="showBefBirthChangeInput()">생년월일 변경</button></td>
                    </tr>
                    <tr class="hidden no-bottom new-bef-birth-show">
                        <td>변경할 생년월일</td>
                        <td>
                            <input type="text" id="bef_birth" name="bef_birth" maxlength="8" oninput="checkBirthFormat(this.value)">
                            <span id="birth-error-msg"></span>
                        </td>
                        <td><button type="button" id="saveNewBefBirthBtn" disabled>생년월일 저장</button></td>
                    </tr>
                    <tr class="no-bottom">
                        <td>휴대폰 번호</td>
                        <td>
                            <c:if test="${not empty userDto.mobile_num}">
                                0${userDto.mobile_num}
                            </c:if>
                            <c:if test="${empty userDto.mobile_num}">
                                ${userDto.mobile_num}
                            </c:if>
                        </td>
                        <td><button id="modify-mobile-num" onclick="showMobileNumChangeInput()">휴대폰번호 변경</button></td>
                    </tr>
                    <tr class="hidden new-mobile-num-show">
                        <td>변경할 휴대폰 번호</td>
                        <td>
                            <input type="text" id="mobile_num" name="mobile_num" placeholder="-제외한 숫자만 입력하십시오." maxlength="11" oninput="restrictMobileNumbers(this.value)">
                            <span id="mobile-number-error-msg"></span>
                        </td>
                        <td><button type="button" id="saveNewMobileNumBtn" disabled>휴대폰 번호 저장</button></td>
                    </tr>
                    <tr class="no-bottom">
                        <td>이메일</td>
                        <td>${userDto.email}</td>
                        <td><button id="modify-email-btn" onclick="showEmailChangeInput()">이메일 변경</button></td>
                    </tr>
                    <tr class="hidden no-bottom new-email-show">
                        <td></td>
                        <td>
                            <div>
                                * 메일주소 입력 후 인증하기 버튼을 누르시면, 고객님의 이메일로 인증 번호가 적힌 메일이 발송됩니다.
                            </div>
                            <div>
                                * 아래에 인증 번호 입력 후 인증번호 전송 버튼을 누르시면 인증이 완료됩니다.
                            </div>
                        </td>
                        <td></td>
                    </tr>
                    <tr class="hidden no-bottom new-email-show">
                        <td>변경할 이메일 주소</td>
                        <td>
                            <input type="email" id="newEmail" name="email" maxlength="50" oninput="checkEmailFormat(this.value)">
                            <span id="email-error-msg"></span>
                        </td>
                        <td><button type="button" id="sendEmailBtn">인증번호 전송</button></td>
                    </tr>
                    <tr class="hidden new-email-show">
                        <td>인증번호</td>
                        <td><input type="text" id="verificationCode" name="mail_key" maxlength="10" required></td>
                        <td><button type="button" id="verifyCodeBtn">인증</button></td>
                    </tr>
                </table>
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
</body>

<script src="/js/jquery-3.6.4.min.js"></script>
<script src="/js/nav.js"></script>

<script>
    function checkPwdLength() {
        let pwd = document.getElementById('pwd').value;
        let msg = document.getElementById('pwd-length-error-msg');

        if (pwd.length > 0 && pwd.length < 8 || pwd.length > 20) {
            msg.innerHTML = "비밀번호는 8자리 이상 20자리 이하로 입력해야 합니다."
        } else {
            msg.innerHTML = "";
        }
    }

    function checkPwdMatch() {
        let pwd1 = document.getElementById('newPwd1').value;
        let pwd2 = document.getElementById('newPwd2').value;
        let msg = document.getElementById('match-error-msg');
        let saveBtn = document.getElementById('saveNewPwdBtn');

        if (pwd1 !== pwd2) {
            msg.innerHTML = "비밀번호가 일치하지 않습니다."
            saveBtn.disabled = true;
        } else {
            msg.innerHTML = "";
            saveBtn.disabled = false;
        }
    }

    function showPwdChangeInput() {
        let pwdChangeInput = document.getElementsByClassName("new-pwd-show");
        let pwdChangeBtn = document.getElementById("modify-pwd-btn");

        for(let i = 0; i < pwdChangeInput.length; i++) {
            pwdChangeInput[i].style.display = "table-row"; // 입력란을 보이도록 변경
        }
        pwdChangeBtn.style.display = "none";
    }

    function showBefBirthChangeInput() {
        let befBirthChangeInput = document.getElementsByClassName('new-bef-birth-show');
        let befBirthChangeBtn = document.getElementById('modify-bef-birth');

        for(let i = 0; i < befBirthChangeInput.length; i++) {
            befBirthChangeInput[i].style.display = "table-row";
        }
        befBirthChangeBtn.style.display= "none";
    }

    function checkBirthFormat(inputValue) {
        let pattern = new RegExp('^[0-9]+$')
        let msg = document.getElementById('birth-error-msg');
        let befBirthChangeBtn = document.getElementById('saveNewBefBirthBtn')

        if (inputValue.length > 0 && !inputValue.match(pattern)) {
            msg.innerHTML = "숫자만 입력 가능합니다.";
            befBirthChangeBtn.disabled = true;
        } else if (inputValue.length > 0 && inputValue.length !== 8) {
            msg.innerHTML = "생년월일은 8자리로 입력해주세요.";
            befBirthChangeBtn.disabled = true;
        } else if (inputValue.length === 8) {
            msg.innerHTML = "";
            befBirthChangeBtn.disabled = false;
        } else {
            msg.innerHTML = "";
            befBirthChangeBtn.disabled = true;
        }
    }

    function showMobileNumChangeInput() {
        let mobileNumChangeInput = document.getElementsByClassName("new-mobile-num-show");
        let mobileNumChangeBtn = document.getElementById("modify-mobile-num");

        for(let i = 0; i < mobileNumChangeInput.length; i++) {
            mobileNumChangeInput[i].style.display = "table-row"; // 입력란을 보이도록 변경
        }
        mobileNumChangeBtn.style.display= "none";
    }

    function restrictMobileNumbers(inputValue) {
        let pattern = new RegExp('^[0-9]+$');
        let msg = document.getElementById('mobile-number-error-msg');
        let mobileNumChangeBtn = document.getElementById('saveNewMobileNumBtn');

        if (inputValue.length > 0 && !inputValue.match(pattern)) {
            msg.innerHTML = "핸드폰 번호는 숫자만 입력 가능합니다.";
            mobileNumChangeBtn.disabled = true;
        } else if (inputValue.length === 0 || inputValue.length < 10) {
            msg.innerHTML = "";
            mobileNumChangeBtn.disabled = true;
        } else {
            msg.innerHTML = "";
            mobileNumChangeBtn.disabled = false;
        }
    }

    function showEmailChangeInput() {
        let emailChangeInput = document.getElementsByClassName("new-email-show");
        let emailChangeBtn = document.getElementById("modify-email-btn");

        for(let i = 0; i < emailChangeInput.length; i++) {
            emailChangeInput[i].style.display = "table-row"; // 입력란을 보이도록 변경
        }
        emailChangeBtn.style.display= "none";
    }

    function checkEmailFormat(inputValue) {
        let pattern = new RegExp('[a-z0-9._%+-]+@[a-z0-9.-]+\.[a-z]{2,}$')
        let msg = document.getElementById('email-error-msg');
        let sendEmailBtn = document.getElementById('sendEmailBtn');

        if(inputValue.length > 0 && !inputValue.match(pattern)) {
            msg.innerHTML = "이메일 형식이 올바르지 않습니다.";
            sendEmailBtn.disabled = true;
        } else {
            msg.innerHTML = "";
            sendEmailBtn.disabled = false;
        }
    }

</script>

<script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>

<script type="text/javascript">
    var userDto = {
        id: "${userDto.id}",
        name: "${userDto.name}",
        bef_birth: "${userDto.bef_birth}",
        mobile_num: "${userDto.mobile_num}",
        email: "${userDto.email}"
    };

    // 1. 비밀번호 변경
    $(document).ready(function () {
        // 1.1. '저장' 버튼 클릭
        $("#saveNewPwdBtn").click(function() {
            let id = userDto.id;
            let pwd = $("#pwd").val();
            let newPwd = $("#newPwd2").val();

            // 1.1.1. AJAX 활용하여 현재 비밀번호 및 변경할 비밀번호 controller 에 넘겨줌.
            // 1.1.2. 현재 비밀번호 정확히 입력한 경우
            // 1.1.2.1. 변경된 비밀번호 고객 정보에 저장 및 변경이력 저장
            // 1.1.3. 현재 비밀번호 잘못 입력한 경우
            // 1.1.3.1. 기존 화면에서 오류메세지 출력
            $.ajax({
                url: "<c:url value='/mypage/modifyPwd'/>",
                type: "POST",
                data: { id: id, pwd: pwd, newPwd: newPwd },
                success: function (response) {
                    alert("비밀번호 변경 성공!");
                    window.location.href = "/mypage/modifyPage";
                },
                error: function (xhr, status, error) {
                    alert(xhr.responseText);
                }
            });
        });
    });

    // 2. 이메일 인증
    $(document).ready(function() {

        // 2.1. '인증번호 전송' 버튼 클릭
        $("#sendEmailBtn").click(function() {
            let id = userDto.id;
            let newEmail = $("#newEmail").val();

            // 2.1.1. AJAX 활용하여 이메일 전송 요청
            // 2.1.2.1. 변경할 새로운 이메일 주소를 controller 에 넘겨줌.
            // 2.1.2.2. 이메일 전송 성공 시 인증번호 입력란 출력
            // 2.1.2.3. 이메일 전송 실패 시 오류 메세지 출력
            $.ajax({
                url: "/mypage/sendEmailVerification",
                type: "POST",
                data: { id: id, newEmail: newEmail },
                success: function (response) {
                    $("#verificationDiv").show();
                    alert("인증번호 전송에 성공했습니다.");
                },
                error: function (xhr, status, error) {
                    console.error("메일 전송 실패:", error);
                    alert(xhr.responseText);
                }
            });
        });

        // 2.2. '인증하기' 버튼 클릭
        $("#verifyCodeBtn").click(function() {
            let id = userDto.id;
            let newEmail = $("#newEmail").val();
            let verificationCode = $("input[name='mail_key']").val();

            // 2.2.1. AJAX 활용하여 인증번호 입력 결과 확인
            // 2.2.2. 인증번호 일치 시
            // 2.2.2.1. 고객정보에서 이메일 변경하여 저장 및 변경이력 추가
            // 2.2.3. 인증번호 불일치 시
            // 2.2.3.1. 기존 화면에서 오류메세지 출력
            $.ajax({
                url: "/mypage/verifyEmail",
                type: "POST",
                data: { id: id, newEmail: newEmail, verificationCode: verificationCode },
                success: function(response) {
                    alert("이메일 변경 성공!");
                    window.location.href = "/mypage/modifyPage";
                },
                error: function(xhr, status, error) {
                    console.error("인증 실패:", error);
                    alert(xhr.responseText);
                }
            });
        });

        // 3. 생년월일 변경
        $("#saveNewBefBirthBtn").click(function() {
            let id = userDto.id;
            let bef_birth = $("#bef_birth").val();

            $.ajax({
                url: "/mypage/modifyBefBirth",
                type: "POST",
                data: { id: id, bef_birth: bef_birth },
                success: function (response) {
                    alert("생년월일 변경 성공!");
                    window.location.href = "/mypage/modifyPage";
                },
                error: function (xhr, status, error) {
                    alert(xhr.responseText);
                }
            });
        });

        // 4. 휴대폰 번호 변경
        $("#saveNewMobileNumBtn").click(function() {
            let id = userDto.id;
            let mobile_num = $("#mobile_num").val();

            $.ajax({
                url: "/mypage/modifyMobileNum",
                type: "POST",
                data: { id: id, mobile_num: mobile_num },
                success: function (response) {
                    alert("휴대폰 번호 변경 성공!");
                    window.location.href = "/mypage/modifyPage";
                },
                error: function (xhr, status, error) {
                    alert(xhr.responseText);
                }
            });
        });
    });
</script>

</html>
