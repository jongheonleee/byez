<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"  pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ko">


<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>BYEZ</title>
    <link rel="stylesheet" href="/css/nav.css">
    <link rel="stylesheet" href="/css/review_write.css?after">
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
                <a href="main.html"><span>home</span></a>
                <span>></span>
                <a href="mypage.html"><span>마이페이지</span></a>
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
                                <img src="/img/1.jpeg">
                            </div>
                        </th>
                        <td class="item_info">
                            <p class="item_name">상품명 :${ordDetailDto.item_name}</p>
                            <p class="item_opt">옵션명 :${ordDetailDto.opt1},${ordDetailDto.opt2}</p>
                        </td>
                    </tr>
                    <tr>
                        <th>
                            별점
                        </th>
                        <td>
                            <select name="score">
                                <option value=5>5점</option>
                                <option value=4>4점</option>
                                <option value=3>3점</option>
                                <option value=2>2점</option>
                                <option value=1>1점</option>
                            </select>
                        </td>
                    </tr>
                    <tr>
                        <th>
                            한줄평
                        </th>
                        <td>
                            <input id="title" name="title" type="text" placeholder="한줄평" value="${reviewDto.title}">
                        </td>
                    </tr>
                    <tr>
                        <th colspan="3">
                            <textarea  id="content" name="content"placeholder="자세한리뷰" class="put_large_content" contenteditable="true">${reviewDto.content}</textarea>
                        </th>
                    </tr>

                </table>
                <div class="btn_area">
                    <a href="list" onclick="return confirm('취소하시고 목록으로 가시겠습니까?')">
                        <button type="button">목록</button>
                    </a>
                    <div class="btn_right">
                        <c:if test="${mode eq 'write'}">
                            <a><button type="button" id="writebtn">등록</button></a>
                        </c:if>
                        <c:if test="${mode eq 'update'}">
                            <a> <button type="button" id="updatebtn">수정</button></a>
                            <input type="hidden" name="review_num" value="${reviewDto.review_num}"
                        </c:if>
                    </div>
                </div>
            </div>
        </form></div>
    </div>
</section>
<footer>
    <div class="wrapper">
        <p>© 2024 spao-copymachine. All rights not reserved.</p>
    </div>
</footer>
<div class="quick">
    <a href="#none" onclick="jQuery('html,body').animate({scrollTop:0},'slow')">
        <img src="/img/quick_up.png" alt="">
    </a>
    <a href="#none" onclick="jQuery('html,body').animate({scrollTop:$(document).height()},'slow');">
        <img src="/img/quick_down.png" alt="">
    </a>
</div>

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
        } else {
            return true;
        }
    }
    $(document).ready(function () {
        $("#writebtn").on("click", function () {
            let form = $("#form");
            form.attr("action", "write");
            form.attr("method", "post");
            alert("등록되었습니다1.");
            form.submit();
        })
        $("#updatebtn").on("click", function () {
            let form = $("#form");
            form.attr("action", "modify?seq_num=${ReviewDto.review_num}");
            form.attr("method", "post");
            var title = document.getElementById("title").value;
            var content = document.getElementById("content").value;
            if (title.trim() === "" || content.trim() === "") {
            } else {
                alert("수정되었습니다.");
            }
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