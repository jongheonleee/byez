<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>

<head>
    <title>[BYEZ] 아이디 찾기</title>
</head>

<link rel="stylesheet" href="/css/nav.css">
<link rel="stylesheet" href="/css/findIdForm.css">
<link rel="stylesheet" href="/css/footer.css">
<link rel="stylesheet" href="/css/quick.css">
<script src="https://kit.fontawesome.com/f0e73cfa04.js" crossorigin="anonymous"></script>
<link rel="preconnect" href="https://fonts.googleapis.com">
<link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
<link href="https://fonts.googleapis.com/css2?family=Noto+Sans+KR:wght@100..900&display=swap" rel="stylesheet">

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
                        <li>남성</li>

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
                        <li>혼성</li>

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
            </p>

            <div class="find-id-input">
                <h1>아이디 찾기</h1>
                <h3>회원가입 시 등록한 아이디를 입력하십시오.</h3>

                <ul class="submit-email">
                    <li>
                        이메일: <input type="email" id="findId-email" name="email" placeholder="byez@example.com" oninput="checkEmailFormat(this.value)" required>
                        <button type="button" id="sendEmailBtn">인증번호 전송</button>
                        <div id="wrong-email-format-msg"></div>
                    </li>

                </ul>

                <ul id="verificationDiv">
                    <li>
                        <h5>이메일을 받지 못한 경우 다시 인증번호 전송 버튼을 누르십시오.</h5>
                    </li>
                    <li>
                        인증번호: <input type="text" id="verificationCode" name="mail_key" required>
                        <button type="button" id="verifyCodeBtn">인증</button>
                    </li>
                </ul>
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

<script>
    function checkEmailFormat(inputValue) {
        let pattern = new RegExp('[a-z0-9._%+-]+@[a-z0-9.-]+\.[a-z]{2,}$')
        let msg = document.getElementById('wrong-email-format-msg');
        // let sendEmailBtn = document.getElementById('sendEmailBtn');

        if(inputValue.length > 0 && !inputValue.match(pattern)) {
            msg.innerHTML = "이메일 형식이 올바르지 않습니다.";
            // sendEmailBtn.disabled = true;
        } else {
            msg.innerHTML = "";
            // sendEmailBtn.disabled = false;
        }
    }
</script>


<script src="/js/jquery-3.6.4.min.js"></script>
<script src="/js/nav.js"></script>

<script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
<script type="text/javascript">
    $(document).ready(function() {

        // 1. '인증번호 전송' 버튼 클릭
        $("#sendEmailBtn").click(function () {
            let email = $("#findId-email").val();

            $.ajax({
                url: "/find/verify",
                type: "POST",
                data: {email: email},
                success: function (response) {
                    $("#verificationDiv").css('visibility', 'visible');
                    alert("인증번호 전송에 성공했습니다.");
                },
                error: function (xhr, status, error) {
                    console.error("메일 전송 실패:", error);
                    alert(xhr.responseText);
                }
            });
        });

        // 2. '인증하기' 버튼 클릭
        $("#verifyCodeBtn").click(function() {
            let email = $("#findId-email").val();
            let verificationCode = $("input[name='mail_key']").val();

            $.ajax({
                url: "/find/findId",
                type: "POST",
                data: { email: email, verificationCode: verificationCode },
                success: function(response) {
                    alert("본인인증 완료");
                    window.location.href = "/find/myId";
                },
                error: function(xhr, status, error) {
                    console.error("인증 실패:", error);
                    alert(xhr.responseText);
                }
            });
        });
    });
</script>

</html>
