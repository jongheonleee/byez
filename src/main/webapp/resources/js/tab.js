$(function(){
    $(".tab_content").hide();

    $(".tab_content:first").show();

    $(".tab_menu a:first").addClass("tab_active");

    $(".tab_menu a").click(function(e){
        e.preventDefault();
        $(".tab_menu a").removeClass("tab_active");
        
        $(this).addClass("tab_active");
        
        $(".tab_content").hide();
        
        var activeTab = $(this).attr("href");
        console.log(activeTab);
        
        $(activeTab).show();
        
    });
});