// 로딩
// 현재 url 조회
// 현재 url과 같은 태그 조회
// css 동적 추가(classList)

$(document).ready(function () {
  // 현재 url 조회
  const currUrl = window.location.href;

  // 서브 스트링 추출
  let subStr = '';
  let j = 0;

  for (let i=0; i<currUrl.length; i++) {
    if (currUrl.charAt(i) === '/') j++;

    if (j === 3) {
      subStr = currUrl.substring(i+1, currUrl.length);
      break;
    }
  }

  // li 모두 순회
    // 현재 li의 값과 서브스트링 값 같음
    // css 동적 추가
  $('.mside_content ul>li>a').each(function () {
    // 현재 li의 값도 동일하게 파싱하기
    const targetUrl = this.href;

    let subStr2 = '';
    let j2 = 0;
    let done = false;

    for (let i=0; i<targetUrl.length; i++) {
      if (targetUrl.charAt(i) === '/') j2++;

      if (j2 === 3) {
        subStr2 = targetUrl.substring(i+1, targetUrl.length);
        break;
      }
    }

    if (subStr === subStr2) {
      this.classList.add('select');
      done = true;
    }

    if (done) {
      return;
    }
  })

})