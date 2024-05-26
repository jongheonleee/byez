<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html lang="ko">


<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>BYEZ</title>
    <link rel="stylesheet" href="/css/nav.css">
    <link rel="stylesheet" href="/css/review_write.css?after?after">
    <link rel="stylesheet" href="/css/footer.css">
    <link rel="stylesheet" href="/css/quick.css">
    <script src="https://kit.fontawesome.com/f0e73cfa04.js" crossorigin="anonymous"></script>
    <link rel="preconnect" href="https://fonts.googleapis.com">
    <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
    <link href="https://fonts.googleapis.com/css2?family=Noto+Sans+KR:wght@100..900&display=swap" rel="stylesheet">
</head>

<body>
<jsp:include page="/WEB-INF/views/include/nav.jsp"/>
<section>
    <div class="wrapper">
        <div class="title">
            <p>
                <a href="/"><span>home</span></a>
                <span>></span>
                <a href="/mypage/index"><span>마이페이지</span></a>
                <span>></span>
                <a href="/review/list"><span>리뷰</span></a>
            </p>
            <p>리뷰 작성</p>
        </div>
        <jsp:include page="/WEB-INF/views/include/aside.jsp"/>
        <form id="form" action="" method="" onsubmit="return validateReview()">
            <input type="hidden" name="ord_num" value="${ordDetailDto.ord_num}">
            <input type="hidden" name="item_num" value="${ordDetailDto.item_num}">
            <div class="content">
                <table>
                    <tr>
                        <th>
                            <div class="first_image">
                                <img src="/img/${ordDetailDto.main_img}">
                            </div>
                        </th>
                        <td class="item_info">
                            <p class="item_name">상품명 : ${ordDetailDto.item_name}</p>
                            <p class="item_opt">옵션 : ${ordDetailDto.opt1} ${ordDetailDto.opt2} ${ordDetailDto.opt3}</p>
                        </td>
                    </tr>
                    <tr>
                        <td colspan="5">
                            <div>
                                <fieldset class="rate fa-solid">
                                    <input type="radio" id="rating10" name="score" value="5"><label for="rating10"
                                                                                                    title="5점"></label>
                                    <input type="radio" id="rating8" name="score" value="4"><label for="rating8"
                                                                                                   title="4점"></label>
                                    <input type="radio" id="rating6" name="score" value="3"><label for="rating6"
                                                                                                   title="3점"></label>
                                    <input type="radio" id="rating4" name="score" value="2"><label for="rating4"
                                                                                                   title="2점"></label>
                                    <input type="radio" id="rating2" name="score" value="1"><label for="rating2"
                                                                                                   title="1점"></label>
                                </fieldset>
                            </div>
                        </td>
                    </tr>
                    <tr>
                        <th>
                            한줄평
                        </th>
                        <td>
                            <input id="title" name="title" type="text" placeholder="(100자 제한)"
                                   value="${reviewDto.title}">
                        </td>
                    </tr>
                    <tr>
                        <th colspan="3">
                            <div><p class="detailReview">자세한 리뷰</p></div>
                            <textarea id="content" name="content" placeholder="(100자 제한)"
                                      class="put_large_content" contenteditable="true">${reviewDto.content}</textarea>
                        </th>
                    </tr>

                </table>
                <div class="btn_area">
                    <a href="list" onclick="return confirm('취소하시고 목록으로 가시겠습니까?')">
                        <button type="button" id="listbtn">목록</button>
                    </a>
                    <div class="btn_right">
                        <c:if test="${mode eq 'write'}">
                            <a>
                                <button type="button" id="writebtn">등록</button>
                            </a>
                        </c:if>
                        <c:if test="${mode eq 'update'}">
                            <a>
                                <button type="button" id="updatebtn">수정</button>
                            </a>
                            <input type="hidden" name="review_num" value="${reviewDto.review_num}"
                        </c:if>
                    </div>
                </div>
            </div>
        </form>
    </div>
</section>
<jsp:include page="/WEB-INF/views/include/footer.jsp"/>
<jsp:include page="/WEB-INF/views/include/quick.jsp"/>
<%--<script src="/js/jquery-3.6.4.min.js"></script>--%>
<script src="https://code.jquery.com/jquery-1.11.3.js"></script>

<script src="/js/nav.js"></script>
<script type="text/javascript">
    function readURL(input) {
        var file = input.files[0]
        console.log(file)
        if (file != '') {
            var reader = new FileReader();
            reader.readAsDataURL(file);
            reader.onload = function (e) {
                console.log(e.target)
                console.log(e.target.result)
                $('#preview').attr('src', e.target.result);
            }
        }
    }
</script>
<script>
    function validateReview() {
        var title = document.getElementById("title").value;
        var content = document.getElementById("content").value;
        if (title.trim() === "" || content.trim() === "") {
            alert("제목과 내용을 작성해주세요");
            return false;
        }
        if (title.length > 100 || content.length > 1000) {
            alert("글자수 확인하고 작성해주세요");
            return false;
        }
        <c:if test="${mode eq 'write'}">
        alert("등록되었습니다.");
        </c:if>
        <c:if test="${mode ne 'write'}">
        alert("수정되었습니다.");
        </c:if>
        return true;
    }

    $(document).ready(function () {
        $("#writebtn").on("click", function () {
            let form = $("#form");
            form.attr("action", "write");
            form.attr("method", "post");
            form.submit();
        })
        $("#updatebtn").on("click", function () {
            let form = $("#form");
            form.attr("action", "modify?seq_num=${ReviewDto.review_num}");
            form.attr("method", "post");
            form.submit();
        })
    });

    function moveAtoInput() {
        var a = document.getElementById("realReview").value;

        $('#content').val(a);
    }
</script>
</body>
</html>

