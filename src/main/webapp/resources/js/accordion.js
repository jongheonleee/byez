// $(document).ready(function() {
//   $(".accordion").each(function() {
//     $(this).click(function() {
//       $(this).toggleClass("active");
//
//       var icon = $(this).find("i");
//       var panel = $(this).next();
//
//       if (panel.is(":visible")) {
//         panel.slideUp();
//         icon.removeClass("fa-chevron-up").addClass("fa-chevron-down");
//       } else {
//         panel.slideDown();
//         icon.removeClass("fa-chevron-down").addClass("fa-chevron-up");
//       }
//     });
//
//     var panel = $(this).next();
//     panel.show();
//     var icon = $(this).find("i");
//     icon.removeClass("fa-chevron-down").addClass("fa-chevron-up");
//   });
// });


$(document).ready(function() {
  $(".accordion").each(function() {
    var panel = $(this).next();
    var icon = $(this).find("i");

    panel.show();
    icon.removeClass("fa-chevron-down").addClass("fa-chevron-up");

    $(this).click(function(event) {
      event.preventDefault();

      $(this).toggleClass("active");

      if (panel.is(":visible")) {
        panel.slideUp();
        icon.removeClass("fa-chevron-up").addClass("fa-chevron-down");
      } else {
        panel.slideDown();
        icon.removeClass("fa-chevron-down").addClass("fa-chevron-up");
      }
    });
  });


  $(".price_search input, .detail_search input").on("keypress", function(event) {
    if (event.key === "Enter") {
      event.preventDefault(); // Prevent form submission
      alert("상세 검색 기능을 사용하시려면 내용 기입 후, 맨 아래의 검색 버튼을 클릭해 주세요.");
    }
  });
});
