
  $(document).ready(function() {
  let totalCnt = 0;
  let orderPrice = 0;

  // 장바구니 상품 조회
  // 수량, 가격 계산
  // 주문 예상 정보 업데이트

  $('.basketITemInfo').each(function (i, e) {
  if ($(e).find(".basketItemCheckBox").is(":checked") === true) {
  // 값 조회
  totalCnt += parseInt($(e).find(".eachBasketItemQty").val());
  orderPrice += parseInt($(e).find(".eachBasketItemPrice").val()) * parseInt($(e).find(".eachBasketItemQty").val());
}
})


  $(".totalCnt").html(totalCnt.toLocaleString());
  $(".orderPrice").html(orderPrice.toLocaleString());
});


  $('.allBasketItemCheckBox').on("change", function () {
  calculateOrderInfo();
});

  $('.basketItemCheckBox').on("change", function () {
  calculateOrderInfo();
});

  const calculateOrderInfo = function () {
  let totalCnt = 0;
  let orderPrice = 0;

  $('.basketITemInfo').each(function (i, e) {
  if ($(e).find(".basketItemCheckBox").is(":checked") === true) {
  // 값 조회
  totalCnt += parseInt($(e).find(".eachBasketItemQty").val());
  orderPrice += parseInt($(e).find(".eachBasketItemPrice").val()) * parseInt($(e).find(".eachBasketItemQty").val());
}
})

  $(".totalCnt").html(totalCnt.toLocaleString());
  $(".orderPrice").html(orderPrice.toLocaleString());

}

  $(".sendModalBtn").on("click", function(e){
    e.preventDefault();
    let seq = parseInt($(this).parents("div.modalBody").find("input.seq").val());
    let id = $(this).parents("div.modalBody").find("input.id").val();
    let name = $(this).parents("div.modalBody").find("input.name").val();
    let num = $(this).parents("div.modalBody").find("input.num").val();
    alert($(this).parents("div.modalBody").find("input.qty").val());
    let qty = parseInt($(this).parents("div.modalBody").find("input.qty").val());
    let price = parseInt($(this).parents("div.modalBody").find("input.price").val());
    let opt1 = $(this).parents("div.modalBody").find("input.opt1").val();
    let opt2 = $(this).parents("div.modalBody").find("input.opt2").val();


    // 검증 로직 추가
    if (seq <= 0) {
    alert("잘못된 시퀀스 번호입니다.");
    return;
  }

    if (id === null || id === '') {
    alert("잘못된 아이디입니다.");
    return;
  }

    if (name === null || name === '') {
    alert("잘못된 상품명입니다.");
    return;
  }

    if (num === null || num <= 0) {
    alert("잘못된 상품 번호입니다.");
    return;
  }

    if (qty <= 0) {
    alert("잘못된 상품 수량입니다.");
    return;
  }

    if (price <= 0) {
    alert("잘못된 상품 가격입니다.");
    return;
  }

    if (opt1 === null || opt1 === '') {
    alert("잘못된 상품 사이즈입니다.");
    return;
  }

    if (opt2 === null || opt2 === '') {
    alert("잘못된 상품 색상입니다.");
    return;
  }


  $(".updateSeq").val(seq);
  $(".updateId").val(id);
  $(".updateName").val(name);
  $(".updateNum").val(num);
  $(".updateQty").val(qty);
  $(".updatePrice").val(price);
  $(".updateOpt1").val(opt1);
  $(".updateOpt2").val(opt2);

  $(".updateBasketItem").submit();
});

  /* 장바구니 삭제 버튼 */
  $(".deleteBtn").on("click", function(e){
  e.preventDefault();

  // 값 조회
  const seq = $(this).data("seq");
  const id = $(this).data("id");

  // 폼에 값 설정
  $(".deleteSeq").val(seq);
  $(".deleteId").val(id);

  // 폼 전송
  $(".deleteBasketItem").submit();
});

  $('.allBasketItemCheckBox').on("click", function () {
  if ($(".allBasketItemCheckBox").is(":checked")) {
  $(".basketItemCheckBox").prop("checked", true);
} else {
  $(".basketItemCheckBox").prop("checked", false);
}
});

  $('.basketItemCheckBox').on("click", function () {
  if ($(this).prop("checked")) {
  $(this).attr("checked", true);
} else {
  $(this).attr("checked", false);
}
});

  /* 장바구니 모든 상품 삭제 버튼 */
  $(".deleteAllBtn").on("click", function(e){
  e.preventDefault();

  const id = $(this).data("id");

  $(".deleteId").val(id);
  $(".deleteAllBasketItemForm").submit();
});

  $(".deleteSeveralBtn").on("click", function (e) {
  let formContents = '';
  let deleteNumber = 0;

  $('.basketITemInfo').each(function (i, e) {
  if ($(e).find(".basketItemCheckBox").is(":checked") === true) {
  // 값 조회
  let id = $(e).find(".eachBasketItemId").val();
  let seq = $(e).find(".eachBasketItemSeq").val();


  // input 태그 생성
  let inputItemId = "<input name='orders[" + deleteNumber + "].id' type='hidden' value='" + id + "'>";
  let inputItemSeq = "<input name='orders[" + deleteNumber + "].seq' type='hidden' value='" + seq + "'>";

  // form에 추가
  formContents += inputItemId;
  formContents += inputItemSeq;

  // 삭제 번호 증가
  deleteNumber += 1;
}
})

  // form 전송
  $(".deleteSeveralBasketItemForm").html(formContents);
  $(".deleteSeveralBasketItemForm").submit();
});

  /* 장바구니 선택 상품 구매 버튼 */
  $(".orderBtn").on("click", function(){
  let formContents = '';
  let orderNumber = 0;

  $('.basketItemInfo').each(function(i, e) {
  if ($(e).find(".basketItemCheckBox").is(":checked") === true) {
  // 값 조회
  let num = $(e).find(".eachBasketItemNum").val();
  let name = $(e).find(".eachBasketItemName").val();
  let price = $(e).find(".eachBasketItemPrice").val();
  let qty = $(e).find(".eachBasketItemQty").val();


  // input 태그 생성
  let inputItemNum = "<input name='orders[" + orderNumber + "].num' type='hidden' value='" + num + "'>";
  let inputItemName = "<input name='orders[" + orderNumber + "].name' type='hidden' value='" + name + "'>";
  let inputItemPrice = "<input name='orders[" + orderNumber + "].price' type='hidden' value='" + price + "'>";
  let inputItemQty = "<input name='orders[" + orderNumber + "].qty' type='hidden' value='" + qty + "'>";

  // form에 추가
  formContents += inputItemNum;
  formContents += inputItemName;
  formContents += inputItemPrice;
  formContents += inputItemQty;

  // 주문 번호 증가
  orderNumber += 1;
}
});

  // form 전송
  $(".orderCheckedBasketItemForm").html(formContents);
  $(".orderCheckedBasketItemForm").submit();
});

  $('.deleteSelectedBtn').on("click", function () {
  let deleteNumber = 0;
  let formContents = '';


  $(".basketItemInfo").each(function (i, e) {
  if ($(e).find(".basketItemCheckBox").is(":checked") === true) {
  // 값 조회
  let id = $(e).find(".eachBasketItemId").val();
  let seq = $(e).find(".eachBasketItemSeq").val();

  // input 태그 생성
  let inputItemId = "<input name='deletes[" + deleteNumber + "].id' type='hidden' value='" + id + "'>";
  let inputItemSeq = "<input name='deletes[" + deleteNumber + "].seq' type='hidden' value='" + seq + "'>";

  // form에 추가
  formContents += inputItemId;
  formContents += inputItemSeq;

  // 주문 번호 증가
  deleteNumber += 1;
}
})

  $(".deleteSelectedBasketItem").html(formContents);
  $(".deleteSelectedBasketItem").submit();

});


  const selectOpt1 = function (e) {
  $(".opt1").val(e);
}

  const selectOpt2 = function (e) {
  $(".opt2").val(e);
}


  $('.openModalBtn').on("click", function(e) {
  e.preventDefault();
  $(this).parent().find("div.modal").css("display", "flex");
});

  $('.closeModalBtn').on("click", function(e) {
  e.preventDefault();
  $(this).parents("div.modal").css("display", "none");
})

  $(function(){
    $('._count :button').on({
      'click' : function(e){
        e.preventDefault();
        let $cnt = $(this).parent('._count').find('.inp');
        let currCnt = parseInt($cnt.val());

        const minCnt = 1;
        const maxCnt = 1000;

        if($(this).hasClass('minus')){
          if(currCnt>minCnt){
            currCnt--;
          }
        }else{
          if(currCnt<maxCnt){
            currCnt++;
          }
        }

        $cnt.val(currCnt);
      }
    });
  });
