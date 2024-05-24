$('#main_slider .slick').slick({
  autoplay : true,
  autoplaySpeed: 5000,
  speed : 500,
  infinite: true,
  slidesToShow: 1,
  slidesToScroll: 1,
  arrows : true,
  prevArrow : $(".slide_btn_prev a"),
  nextArrow : $(".slide_btn_next a")
});

function mainFraction(){
  var status = $('#main_slider .fraction');
  var slickElement = $('#main_slider .slick');

  slickElement.on('init reInit beforeChange', function(event, slick, currentSlide, nextSlide){

    var i = (nextSlide ? nextSlide : 0) + 1;

    status.text(i + ' / ' + slick.slideCount);

  });
}
mainFraction();

$("#main_slider .pause").click(function(){
  $("#main_slider .slick").slick("slickPause");
  $(this).css({display: "none"});
  $("#main_slider .play").css({display: "block"});
});

$("#main_slider .play").click(function(){
  $("#main_slider .slick").slick("slickPlay");
  $(this).css({display: "none"});
  $("#main_slider .pause").css({display: "block"});
});