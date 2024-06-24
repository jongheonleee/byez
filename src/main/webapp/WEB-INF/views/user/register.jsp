<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="ko">
<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <title>BYEZ</title>
  <link rel="stylesheet" href="/css/register.css?after">
  <script src="https://kit.fontawesome.com/f0e73cfa04.js" crossorigin="anonymous"></script>
  <link rel="preconnect" href="https://fonts.googleapis.com">
  <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
  <link href="https://fonts.googleapis.com/css2?family=Noto+Sans+KR:wght@100..900&display=swap" rel="stylesheet">
  <link rel="icon" href="/img/favicon-32x32_2.png">
</head>
<body>
  <div class="wrapper">
    <div class="register_form">
      <div class="register_form_wrapper">
        <div>
          <p>회원가입</p>
        </div>
        <p>*필수입력 항목</p>
        <p class="errorMsg">
          <c:if test="${not empty errorMsg}">
            ${errorMsg}
          </c:if>
        </p>
        <form action="/register/save" method="POST">
          <table>
            <tr>
              <td>
                <span>*이름</span>
              </td>
              <td>
                <input type="text" id="name" name="name" value="${userDto.name}" maxlength="6" oninput="checkNameFormat()" required>
                <p id="name-error-msg"></p>
              </td>
            </tr>
            <tr>
              <td>성별</td>
              <td>
                <label><input type="radio" name="sex" value="M" <c:if test="${userDto.sex == 'M'}">checked</c:if>> M </label>
                <label><input type="radio" name="sex" value="F" <c:if test="${userDto.sex == 'F'}">checked</c:if>> F </label>
              </td>
            </tr>
            <tr>
              <td>
                <span>
                    *아이디
                </span>
              </td>
              <td>
                <input type="text" id="id" name="id" maxlength="20" value="${userDto.id}" placeholder="3자리 이상 입력하세요." oninput="checkIdFormat()" required>
                <button type="button" id="checkDuplicateBtn">중복확인</button>
                <p id="id-msg"></p>
              </td>
            </tr>
            <tr>
              <td colspan="2">비밀번호는 영문, 숫자, 특수문자를 최소 1개 이상 포함하여 8자 이상 20자 이하로 입력해주세요.</td>
            </tr>
            <tr>
              <td>
                <span>
                    *비밀번호
                </span>
              </td>
              <td>
                <input type="password" id="pwd1" name="pwd" maxlength="20" oninput="checkPwdLength()" required>
                <p id="pwd-length-error-msg"></p>
                <p>
                  <c:if test="${not empty wrongPwdMsg}">
                    ${wrongPwdMsg}
                  </c:if>
                </p>
              </td>
            </tr>
            <tr>
              <td>
                <span>
                    *비밀번호 확인
                </span>
              </td>
              <td> <input type="password" id="pwd2" name="pwd" maxlength="20" oninput="checkPwdMatch()" required>
                <p id="match-error-msg"></p>
              </td>
            </tr>
            <tr>
              <td>
                <span>
                    생년월일
                </span>
              </td>
              <td>
                <input type="text" id="birth1" name="bef_birth" value="${userDto.bef_birth}" maxlength="8" placeholder="8자리로 입력하세요." oninput="checkBirthFormat1(); inputNum(this);">
                - <input type="text" id="birth2" name="af_birth" value="${userDto.af_birth}" maxlength="1" oninput="checkBirthFormat2(); inputNum(this);"> <span>******</span>
                <p id="birth-error-msg"></p>
              </td>
            </tr>
            <tr>
              <td>
                <span>
                    전화번호
                </span>
              </td>
              <td>
                <input type="text" id="tel_num" name="tel_num" value="${userDto.tel_num}" maxlength="11" placeholder="-제외한 숫자만 입력하십시오." oninput="restrictToTelNumbers(this.value); inputNum(this);">
                <p id="tel-number-error-msg"></p>
              </td>
            </tr>
            <tr>
              <td>
                <span>
                    핸드폰 번호
                </span>
              </td>
              <td>
                <input type="text" id="mobile_num" name="mobile_num" value="${userDto.mobile_num}" maxlength="11" placeholder="-제외한 숫자만 입력하십시오." oninput="restrictToPhoneNumbers(this.value); inputNum(this);">
                <p id="mobile-number-error-msg"></p>
              </td>
            </tr>
            <tr>
              <td>
                <span>
                    *E-mail
                </span>
              </td>
              <td>
                <input type="email" name="email" maxlength="50" value="${userDto.email}" placeholder="이메일을 입력해주세요." oninput="checkEmailFormat(this.value)" required>
                <p id="email-error-msg"></p>
              </td>
            </tr>
          </table>
          <div class="button_wrapper">
            <button type="button" onclick="location.href='/'">가입취소</button>
            <input type="submit" id="sendUserInfoBtn" value="제출">
          </div>
        </form>
      </div>
    </div>
  </div>
</body>

<script>
  function inputNum(element) {
    element.value = element.value.replace(/[^0-9]/g, "");
  }

  function checkNameFormat() {
    let id = document.getElementById('name').value;
    let msg = document.getElementById('name-error-msg');
    let pattern = new RegExp('^[ㄱ-ㅎ가-힣]+$');

    if (id.length > 0 && !id.match(pattern)) {
      msg.innerHTML = "이름은 한글만 입력 가능합니다.";
    } else {
      msg.innerHTML = "";
    }
  }

  function checkIdFormat() {
    let id = document.getElementById('id').value;
    let msg = document.getElementById('id-error-msg');
    let pattern = new RegExp('^[A-Za-z0-9]+$')

    if (id.length > 0 && id.length < 3 || id.length > 20) {
      msg.innerHTML = "아이디는 3자 이상, 20자 이하로 입력해주세요.";
    } else if(id.length > 0 && !id.match(pattern)) {
      msg.innerHTML = "아이디는 영문자와 숫자만 사용 가능합니다."
    } else {
      msg.innerHTML = "";
    }
  }

  function checkPwdLength() {
    let pwd1 = document.getElementById('pwd1').value;
    let msg = document.getElementById('pwd-length-error-msg');

    if (pwd1.length > 0 && pwd1.length < 8 || pwd1.length > 20) {
      msg.innerHTML = "비밀번호는 8자리 이상 20자리 이하로 입력해야 합니다."
    } else {
      msg.innerHTML = "";
    }
  }

  function checkPwdMatch() {
    let pwd1 = document.getElementById('pwd1').value;
    let pwd2 = document.getElementById('pwd2').value;
    let msg = document.getElementById('match-error-msg');

    if (pwd1 !== pwd2) {
      msg.innerHTML = "비밀번호가 일치하지 않습니다."
    } else {
      msg.innerHTML = "";
    }
  }

  function checkBirthFormat1() {
    let birth1 = document.getElementById('birth1').value;
    let pattern = new RegExp('^[0-9]+$')

    let msg = document.getElementById('birth-error-msg');

    if (birth1.length > 0 && !birth1.match(pattern)) {
      msg.innerHTML = "숫자만 입력 가능합니다.";
    } else if (birth1.length > 0 && birth1.length !== 8) {
      msg.innerHTML = "생년월일은 8자리로 입력해주세요.";
    } else if (birth1.length === 8) {
      msg.innerHTML = "";
      birth2.focus();
    } else {
      msg.innerHTML = "";
    }
  }

  function checkBirthFormat2() {
    let birth2 = document.getElementById('birth2').value;
    let pattern = new RegExp('^[0-9]+$')

    let msg = document.getElementById('birth-error-msg');

    if (birth2.length > 0 && !birth2.match(pattern)) {
      msg.innerHTML = "숫자만 입력 가능합니다.";
    } else if (birth2 != 0 && birth2 < 1 || birth2 > 4) {
      msg.innerHTML = " 1 ~ 4 사이의 숫자만 입력해주세요.";
    } else {
      msg.innerHTML = "";
    }
  }

  function restrictToTelNumbers(inputValue) {
    let pattern = new RegExp('^[0-9]+$');
    let msg = document.getElementById('tel-number-error-msg');

    if (inputValue.length > 0 && !inputValue.match(pattern)) {
      msg.innerHTML = "전화번호는 숫자만 입력 가능합니다.";
    } else {
      msg.innerHTML = "";
    }
  }

  function restrictToPhoneNumbers(inputValue) {
    let pattern = new RegExp('^[0-9]+$');
    let msg = document.getElementById('mobile-number-error-msg');

    if (inputValue.length > 0 && !inputValue.match(pattern)) {
      msg.innerHTML = "핸드폰 번호는 숫자만 입력 가능합니다.";
    } else {
      msg.innerHTML = "";
    }
  }

  function checkEmailFormat(inputValue) {
    let pattern = new RegExp('[a-z0-9._%+-]+@[a-z0-9.-]+\.[a-z]{2,}$')
    let msg = document.getElementById('email-error-msg');

    if(inputValue.length > 0 && !inputValue.match(pattern)) {
      msg.innerHTML = "이메일 형식이 올바르지 않습니다.";
    } else {
      msg.innerHTML = "";
    }
  }
</script>

<script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
<script type="text/javascript">
  $(document).ready(function () {

    // 아이디 중복 확인
    $("#checkDuplicateBtn").click(function () {
      let id = $("#id").val();
      $.ajax({
        url: "/register/checkDuplicatedId",
        type: "POST",
        data: { id: id },
        success: function (response) {
          $("#id-msg").text(response); // 성공 메시지를 id-msg에 표시
          $("#id-msg").removeClass('duplicate-msg').addClass('success-msg'); // 성공 시 success-msg 클래스를 추가
          $("#sendUserInfoBtn").prop("disabled", false); // 성공 시 제출 버튼 활성화
        },
        error: function (xhr, status, error) {
          $("#id-msg").text(xhr.responseText); // 오류 메시지를 id-msg에 표시
          $("#id-msg").removeClass('success-msg').addClass('duplicate-msg'); // 오류 시 error-msg 클래스를 추가
          $("#sendUserInfoBtn").prop("disabled", true); // 실패 시 제출 버튼 비활성화
        }
      });
    });

    $("#checkNicknameBtn").click(function () {
      window.location.href="https://kauth.kakao.com/oauth/authorize?response_type=code&client_id=873c82dfa901cd280c11ee222e944826&redirect_uri=http://localhost:8080/kakaoSignUp";
      // URL에서 인가 코드를 확인하고 서버에 전달
      $.ajax({
        url: "/kakaoSignUp",
        type: "POST",
        data: { code: code },
        success: function (response) {

          alert(response);
        },
        error: function (xhr, status, error) {
          alert(response);
        }
      });
    });
  });
</script>

</html>