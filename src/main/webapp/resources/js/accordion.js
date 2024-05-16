$(document).ready(function() {
  $(".accordion").each(function() {
    $(this).click(function() {
      $(this).toggleClass("active");

      var icon = $(this).find("i");
      var panel = $(this).next();

      if (panel.is(":visible")) {
        panel.slideUp();
        icon.removeClass("fa-chevron-up").addClass("fa-chevron-down");
      } else {
        panel.slideDown();
        icon.removeClass("fa-chevron-down").addClass("fa-chevron-up");
      }
    });

    var panel = $(this).next();
    panel.show();
    var icon = $(this).find("i");
    icon.removeClass("fa-chevron-down").addClass("fa-chevron-up");
  });
});
