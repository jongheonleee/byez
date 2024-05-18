<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: chanbin
  Date: 2024-04-26
  Time: 오전 11:08
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<script src="https://code.jquery.com/jquery-1.11.3.js"></script>
<style>

</style>
<div>

    <h2>리뷰 쓰기</h2>
    <span>
        <img src="//image.msscdn.net/images/goods_img/20210528/1973470/1973470_17119378809255_160.jpg"
             alt="아비드 백팩_Black">
    </span>
    <span>
        <h3>상품명 : ${ordDetailDto.item_name}</h3>
        <h4>옵션 : ${ordDetailDto.opt1},${ordDetailDto.opt2}</h4>
<%--        <h5> 이미지  : ${ordDetailDto.main_img}</h5> 추후에 이미지파일컬럼을 ord_detail에 추가할 경우 넣을것--%>
    </span>

    <form id="form" action="" method="" onsubmit="return validateReview()">
        <input type="hidden" name="ord_num" value="${ordDetailDto.ord_num}">
        <input type="hidden" name="item_num" value="${ordDetailDto.item_num}">

        <label>
            <select name="score">
                <option value=5>5점</option>
                <option value=4>4점</option>
                <option value=3>3점</option>
                <option value=2>2점</option>
                <option value=1>1점</option>
            </select>
        </label>
        <input id="title" name="title" type="text" placeholder="한줄평" value="${reviewDto.title}">
        <textarea id="content" name="content" placeholder="자세한 리뷰">${reviewDto.content}</textarea>
        <a href="list" onclick="return confirm('취소하시고 목록으로 가시겠습니까?')">
            <button type="button">목록</button>
        </a>
        <c:if test="${mode eq 'write'}">
            <button type="button" id="writebtn">등록</button>
        </c:if>
        <c:if test="${mode eq 'update'}">
            <button type="button" id="updatebtn">수정</button>
            <input type="hidden" name="review_num" value="${reviewDto.review_num}"
        </c:if>
        <div class="form-group" style="height: 150px; width: 200px;">
            <label>첨부파일</label>
            <input type="file" name="imgFile" onchange="readURL(this);"/>
            <img id="preview" src="#" width=200 height=150 alt="선택된 이미지가 없습니다" style="align-content: flex-end; ">
        </div>

    </form>
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
                alert("등록되었습니다.");
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
    </script>
</div>
</html>

