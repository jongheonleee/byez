$(function(){
        $('._count :button').on({
          'click' : function(e){
            e.preventDefault();
            let $cnt = $(this).parent('._count').find('.inp');
            let currCnt = parseInt($cnt.val());
    
            const minCnt = 1;
            const maxCnt = 1000;
    
            if ($(this).hasClass('minus') && currCnt>minCnt){
              currCnt--;
            } else if (!$(this).hasClass('minus') && currCnt<maxCnt){
              currCnt++;
            }
    
            $cnt.val(currCnt);
          }
        });
      });
