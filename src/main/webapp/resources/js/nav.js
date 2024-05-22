// $(function(){
//     $(".nav_menu>li").hover(
//         function(){
//             $(this).find("ul:not(:animated)").slideDown();
//         },
//         function(){
//             $(this).find("ul").slideUp();
//         }
//     );
// });

$(function(){
    $(".hover").hover(function(){
        $(this).children(".sub_menu").stop().fadeToggle(300);
    });

    $('#searchForm').on('submit', function(event) {
        event.preventDefault(); // 폼의 기본 제출 동작을 막음
        var query = $('#searchInput').val().trim();
        if (query) {
            var currentUrl = window.location.href.split('?')[0]; // 현재 페이지 URL 가져오기
            window.location.href = currentUrl + '?nameKeyword=' + encodeURIComponent(query);
        }
    });

    function show(showNav) {
        if (!$('.search_div').is(':visible')) {
            $(showNav + ', .shadow').show();
        }
    }

    function hide(hideNav) {
        if (!$('.search_div').is(':visible')) {
            $(hideNav + ', .shadow').hide();
        }
    }

    $('nav .nav_menu li:nth-child(3)').hover(function() {
        show('.nav_woman');
    }, function() {
        hide('.nav_woman');
    });

    $('nav .nav_menu li:nth-child(4)').hover(function() {
        show('.nav_man');
    }, function() {
        hide('.nav_man');
    });

    $('nav .nav_menu li:nth-child(5)').hover(function() {
        show('.nav_unisex');
    }, function() {
        hide('.nav_unisex');
    });

    $('.nav_woman, .nav_man, .nav_unisex').hover(function() {
        var showNav = '.' + $(this).attr('class');
        show(showNav);
    }, function() {
        var hideNav = '.' + $(this).attr('class');
        hide(hideNav);
    });


    $('nav .nav_member>li:nth-child(2) a').click(function() {
        $('.search_div, .shadow').show();
    });

    $('.search_div p img').click(function() {
        $('.search_div, .shadow').hide();
    });
    

});
