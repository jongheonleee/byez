<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <link rel="icon" href="/img/favicon-32x32_2.png">
</head>
<div id="basketList"></div>
<button id="basketBtn">장바구니</button>
<script type="text/javascript" src="http://code.jquery.com/jquery-3.5.1.min.js"></script>
<script>

  $(document).ready(function() {
    $("#basketBtn").click(function () {

    })


    $('#modBtm').click(function () {

    })


    $('#sendBtn').click(function () {
      showBasketInfo();
    })


    $('#basketList').on("click", ".delBtn", function () {
      const seq = $(this).parent().attr("data-seq");
      $.ajax({
        type: 'DELETE',
        url: 'basket/'+seq,
        success: function (result) {
          showBasketInfo();
        },
        error: function (error) {
          alert("what?");
          alert(error);
          showBasketInfo();
        }
      });
    })

    // 0. 옵션 변경 버튼을 누름
    $("#basketList").on("click", ".modBtn", function (event) {
      const modal = $(this).parent().children(".modal");
      modal.css("display", "flex");
    })
  })

  // 💥 이 부분만 해결하면됨... => 타겟이 되는 데이터를 정확하게 지정하지 못함
  const sendMod = function (event) {

    alert("you clicked this");

    $.ajax({
      type: 'PATCH',       // 요청 메서드
      url: 'basket',  // 요청 URI
      headers: {"content-type": "application/json"}, // 요청 헤더
      data: JSON.stringify({
        seq: $("input[name=seq]").val(),
        num: $("input[name=num]").val(),
        name: $("input[name=name]").val(),
        qty: $("input[name=qty]").val(),
        opt1: $("input[name=opt1]").val(),
        opt2: $("input[name=opt2]").val(),
        opt3: $("input[name=opt3]").val()
      }),
      success: function (result) {
        alert("work");
        showBasketInfo();
      },
      error: function (error) {
        alert("not work");
        showBasketInfo();
      } // 에러가 발생했을 때, 호출될 함수
    }); // $.ajax()
  }

  // 추후에 css 속성 none 처리하는 방법 알아내기
  const closeMod = function () {
    showBasketInfo();
  }


  const showBasketInfo = function () {
    $.ajax({
      type: 'GET',       // 요청 메서드
      url: 'basket?id='+1 ,  // 요청 URI
      success : function(result){
        $("#basketList").html(toHtml(result));
      },
      error   : function(){ alert("error") } // 에러가 발생했을 때, 호출될 함수
    }); // $.ajax()
  }



  const toHtml = function (basketItems) {
    let totalCnt = 0; // 총 상품 개수
    let totalPrice = 0; // 총 주문 금액
    let tmp = ""; // 추가할 html 생성

    // 총 주문 가격, 수량 계산
    basketItems.forEach(function (item) {
      totalCnt += item.qty;
      totalPrice += (item.qty * item.price);
    })

    <!-- 0. 장바구니 정보 보여주기(주문 가격, 수량) -->
    tmp += '<h1 style="text-align: center">장바구니</h1>';
    tmp += '<h3>총 상품 개수<div id="totalCnt">'+ totalCnt + '</div></h3>';
    tmp += '<h3>총 주문 금액<div id="totalPrice">' + totalPrice + '</div></h3>';


    tmp += "<ul>";
    basketItems.forEach(function (item) {

      <!-- 1. 상품 정보 리스트로 뿌림(테이블로 수정) -->
      tmp += '<li data-seq = ' + item.seq
      tmp += ' data-id = ' + item.id
      tmp += ' data-num = ' + item.num
      tmp += ' data-qty = ' + item.qty
      tmp += ' data-opt1 = ' + item.opt1
      tmp += ' data-opt2 = ' + item.opt2
      tmp += ' data-opt3 = ' + item.opt3
      tmp += ' data-price = ' + item.price
      tmp += ' 상품명 : <span class="name">' + item.name + '</span>'
      tmp += ' 수량 : <span class="qty">' + item.qty + '</span>'
      tmp += ' 가격 : <span class="price">' + item.price + '</span>'
      tmp += ' 사이즈 : <span class="opt1">' + item.opt1 + '</span>'
      tmp += ' 색상 : <span class="opt2">' + item.opt2 + '</span>'
      tmp += '<button class="delBtn">삭제</button>'
      tmp += '<button class="modBtn">옵션변경</button>'

      <!-- 2. 모달 창(모달 창 내에서 지정된 값만 넣을 수 있도록 정하기, 사이즈, 수량은 셀렉트 태그 활용) -->
      tmp += '<div class="modal"><div class="modal_body">'
      tmp += '<h1>' + item.name + '</h1>'
      tmp += '<input id="id" class="id" type="hidden" name="id" value="' +  item.id + '"><br>'
      tmp += '<input id="seq" class="seq" type="hidden" name="seq" value="' +  item.seq + '"><br>'
      tmp += '<input id="name" class="name" type="hidden" name="name" value="' +  item.name + '"><br>'
      tmp += '<input id="num" class="num" type="hidden" name="num" value="' + item.num + '"><br>'
      tmp += '변경할 수량 <input id="qty" class="qty" name="qty" value="' + item.qty + '" placeholder="' + item.qty + '"><br>'
      tmp += '변경할 사이즈 <input id="opt1" class="opt1" name="opt1" value="' + item.opt1 + '" placeholder="' +item.opt1 + '"><br>'
      tmp += '변경할 컬러 <input id="opt2" class="opt2" name="opt2" value="' + item.opt2 + '" placeholder="' + item.opt2 +'"><br>'
      tmp += '<input id="opt3" class="opt3" type="hidden" name="opt3" value="' + item.opt3 + '" placeholder="' + item.opt3 +'"><br>'
      tmp += '<button class="sendMod" onclick="sendMod()">수정</button>'
      tmp += '<button class="closeMod" onclick="closeMod()">닫기</button>'
      tmp += '</div></div>'
      tmp += '</li>'
    });

    return tmp + "</ul>";
  };
</script>
</body>
</html>