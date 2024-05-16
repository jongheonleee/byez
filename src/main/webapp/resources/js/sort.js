$(function(){
    $(".sort").hover(function(){
        $(this).children(".order").stop().fadeToggle(300);
    });
});