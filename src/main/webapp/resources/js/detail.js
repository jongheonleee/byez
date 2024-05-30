$(document).ready(function(){

    $('._count :button').on({'click': function (e) {
            e.preventDefault();

            let $cnt = $(this).parent('._count').find('.inp');
            let currCnt = parseInt($cnt.val());

            const minCnt = 1;
            const maxCnt = 10000;

            if ($(this).hasClass('minus') && currCnt > minCnt) {
                currCnt--;
            } else if (!$(this).hasClass('minus') && currCnt < maxCnt) {
                currCnt++;
            } else if (currCnt < minCnt) {
                alert(`주문 가능 수량은 최소 ${minCnt}개입니다.`);
            } else if (currCnt >= maxCnt) {
                alert(`주문 가능 수량은 최대 ${maxCnt}개입니다.`);
            }

            $cnt.val(currCnt);

            // 가격 조회
            let totalPrice = 0;
            const price = parseInt($('.item-info').find('.disc_price').val());

            // 가격 계산
            totalPrice = price * currCnt;

            // 가격 업데이트
            $(".total_price").html(totalPrice.toLocaleString());
        }
    });


    $(".review_pic > li img").click(function() {
        $(".modal_bg").fadeIn();
        $(".modal_box")
            .fadeIn()
            .html("<img src='" + $(this).attr("src") + "'>")
            .append("<button class='close_btn'><i class='fa-solid fa-xmark'></i></button>");

        $(".close_btn, .modal_bg").click(function() {
            $(".modal_bg, .modal_box").fadeOut();
        });
    });

    // 좋아요 버튼, ajax 전송
    $('.heart-btn').click(function(){
        $(this).find('.fa-heart').toggleClass('heart-red');

        // 상품 정보 조회
            // num, name, type, price, disc_price, review_cnt, like_cnt, state_code
        const num = $('.item-info').find('.num').val();

        // 상품 정보 검증
        if (num === null || num === undefined) {
            alert('잘못된 상품 번호입니다. 다시 요청해주세요!');
            return;
        }

        // Json 객체 직렬화
        const likeItemDto =
            JSON.stringify({
                num : num
        });


        // ajax 호출
        $.ajax({
            type:'POST',
            url : '/like/add',
            headers : { "content-type": "application/json"},
            data : likeItemDto,
            success : function () {

            },
            error : function () {
            }
        })

    });

    // 장바구니 버튼, ajax 전송
    $('.cart-btn').on('click', function (e) {
        // 옵션 선택했는지 확인
            // 선택x, 옵션선택 요구창
            // 선택o, 데이터 검증

        if (!checkOpt()) {
            alert('상품의 옵션과 수량을 지정해주세요!');
            return;
        }

        // 장바구니 상품 조회
            // num, name, price(disc_price), qty, opt1(color), opt2(size), opt3(cust_type), opt4(item_type), coupon_chk
        const num = $('.item-info').find('.num').val();
        const name = $('.item-info').find('.name').val();
        const main_img = $('.item-info').find('.name').val();
        const qty = parseInt($('._count>input').val());
        const price = parseInt($('.item-info').find('.price').val());
        const opt1 = $('.opt1').val();
        const opt2 = $('.opt2').val();
        const opt3 = $('.cust_type').val();
        const coupon_chk = '';


        // Json 객체 직렬화
        const basketItemDto = JSON.stringify({
            num : num,
            name : name,
            main_img : main_img,
            qty : qty,
            price : price,
            opt1 : opt1,
            opt2 : opt2,
            opt3 : opt3,
            coupon_chk : coupon_chk
        });


        // ajax 호출
        $.ajax({
            type:'POST',
            url : '/basket/add',
            headers : { "content-type": "application/json"},
            data : basketItemDto,
            success : function () {
                alert("장바구니에 상품을 담았습니다.");
            },
            error : function () {

            }
        })
    });

    const selectOpt1 = function (e) {
        $(".opt1").val(e);
    }


    $('.changeOpt1').on('change', function (e) {
        // 값 조회
        const opt1 = this.value;
        // 값 저장
        $('.opt1').val(opt1);
    })

    $('.changeOpt2').on('change', function (e) {
        // 값 조회
        const opt2 = this.value;
        // 값 저장
        $('.opt2').val(opt2);
    })


    const checkOpt = function () {
        // 상품 옵션 확인
        // 컬러 확인
        if ($('.opt1').val() === undefined || $('.opt1').val() == null || $('.opt1').val() === '') {
            return false;
        }

        // 사이즈 확인
        if ($('.opt2').val() === undefined || $('.opt2').val() == null || $('.opt2').val() === '') {
            return false;
        }

        // 수량 확인
        if (parseInt($('_count>input').val())<= 0) {
            return false;
        }

        return true;
    }

    // 주문 버튼, post 전송
    $('.order-btn').on('click', function (e) {
        if (!checkOpt()) {
            alert('상품의 옵션과 수량을 지정해주세요!');
            return;
        }

        // 장바구니 상품 조회
        // num, name, price(disc_price), qty, opt1(size), opt2(color), opt3(cust_type), opt4(item_type), coupon_chk
        const num = $('.item-info').find('.num').val();
        const name = $('.item-info').find('.name').val();
        const qty = parseInt($('._count>input').val());
        const price = parseInt($('.item-info').find('.disc_price').val());
        const opt1 = $('.opt1').val();
        const opt2 = $('.opt2').val();
        const opt3 = $('.cust_type').val();


        // form 동적으로 생성
        let formText = "";
        formText += '<input type="hidden" name="num" value="'+ num + '">';
        formText += '<input type="hidden" name="name" value="'+ name + '">';
        formText += '<input type="hidden" name="qty" value="'+ qty + '">';
        formText += '<input type="hidden" name="price" value="'+ price + '">';
        formText += '<input type="hidden" name="opt1" value="'+ opt1 + '">';
        formText += '<input type="hidden" name="opt2" value="'+ opt2 + '">';
        formText += '<input type="hidden" name="opt3" value="'+ opt3 + '">';

        // 포스트로 전송
        $('.order-form').html(formText);
        $('.order-form').submit();
    });

    $('.more button').click(function() {
        $('.foldImg').css({
            'height': 'fit-content',
            'overflow': 'visible'
        });
        $(this).parent().hide();
    });


});

// 카운트