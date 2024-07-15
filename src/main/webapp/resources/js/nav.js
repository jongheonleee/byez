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
            var url = '/item/search'.split('?')[0]; // 현재 페이지 URL 가져오기
            window.location.href = url + '?nameKeyword=' + encodeURIComponent(query);
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

    // 로그아웃 상태에서 order 클릭 시 로그인 페이지로 이동
    $(document).ready(function () {
        $(".alert-and-redirect").click(function(event) {
            event.preventDefault(); // 기존 링크로의 이동 막음
            alert("로그인이 필요합니다."); // alert 창 띄움
            window.location.href = "/login/form"; // 해당 링크로 이동
        })
    })

});