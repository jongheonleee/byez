$(function() {
  $('._count :button').on({
    'click': function (e) {
      e.preventDefault();
      let $cnt = $(this).parent('._count').find('.inp');
      let currCnt = parseInt($cnt.val());

      const minCnt = 1;
      const maxCnt = 10;

      if ($(this).hasClass('minus') && currCnt > minCnt) {
        currCnt--;
      } else if (!$(this).hasClass('minus') && currCnt < maxCnt) {
        currCnt++;
      } else if (currCnt < minCnt) {
        alert(`주문 가능 수량은 최소 ${minCnt}개입니다.`);
      } else if (currCnt >= maxCnt) {
        alert(`주문 가능 수량은 최대 ${maxCnt}개입니다.`);
      }

      $cnt.val(currCnt);
    }
  });
});
