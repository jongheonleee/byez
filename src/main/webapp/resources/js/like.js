
  $(".modifyBtn").on("click", function (e) {
  // 버튼 변경
  $(this).css("display", "none");
  $(".deleteBtn").css("display", "flex");
  $(".cancelBtn").css("display", "flex");

  // 체크 박스 보이기
  $(".likeItemInfo").find(".checkBox").css("display", "flex");

})

  $(".deleteBtn").on("click", function () {
  let formContents = '';
  let itemNumber = 0;

  // 선택된 요소들 동적으로 인풋 태그 생성
  $(".likeItemInfo").each(function (i, e) {
    if ($(this).find(".checkBox").is(":checked")) {
      alert("de");
      let id = $(this).find(".checkBox").data("id");
      let num = $(this).find(".checkBox").data("num");

      let inputItemId = "<input name='list[" + itemNumber + "].id' type='hidden' value='" + id + "'>";
      let inputItemNum = "<input name='list[" + itemNumber + "].num' type='hidden' value='" + num + "'>";

      formContents += inputItemId;
      formContents += inputItemNum;

      itemNumber++;
    }
  });

  alert(formContents);
  $(".removeSeveralLikeForm").html(formContents);
  $(".removeSeveralLikeForm").submit();
})

  $(".cancelBtn").on("click", function (e) {
  $(".modifyBtn").css("display", "flex");
  $(".deleteBtn").css("display", "none");
  $(this).css("display", "none");

  $(".likeItemInfo").find(".checkBox").css("display", "none");
})