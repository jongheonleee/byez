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
    <h2>게시판 쓰기</h2>
    <form id="form" action="" method="" onsubmit="return validateQna()">
        <%--        <input type="hidden" name="cust_id" value="${qnaDto.cust_id}">--%>
        <%--        <input type="hidden" name="qna_writer" value="${qnaDto.cust_id}">--%>

        <label>
            <select name="cate_num">
                <option value="100">교환</option>
                <option value="200">환불</option>
                <option value="300">취소</option>
                <option value="400">배송</option>
                <option value="500">불량</option>
                <option value="600">주문</option>
                <option value="700">상품</option>
                <option value="800">회원</option>
                <option value="900">기타</option>
                <option value="1000">신고</option>
            </select>
        </label>
        <input id="qna_title" name="qna_title" type="text" placeholder="제목을 작성해 주세요" value="${qnaDto.qna_title}">
        <textarea id="qna_content" name="qna_content" placeholder="글을 작성해 주세요">${qnaDto.qna_content}</textarea>
        <a href="list" onclick="return confirm('취소하시고 목록으로 가시겠습니까?')">
            <button type="button">목록</button>
        </a>
        <c:if test="${mode eq 'write'}">
            <button type="button" id="writebtn">등록</button>
        </c:if>
        <c:if test="${mode eq 'update'}">
            <button type="button" id="updatebtn">수정</button>
            <input type="hidden" name="seq_num" value="${qnaDto.seq_num}">
        </c:if>
        <%--        <button type="button" id="deletebtn">삭제</button>--%>
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
        function validateQna() {
            var title = document.getElementById("qna_title").value;
            var content = document.getElementById("qna_content").value;
            if (title.trim() === "" || content.trim() === "") {
                alert("제목과 내용을 작성해주세요");
                return false;
            } else {
                return true;
            }
        }

        $(document).ready(function () {
            $("#updatebtn").on("click", function () {
                let form = $("#form");
                form.attr("action", "update?seq_num=${qnaDto.seq_num}");
                form.attr("method", "post")
                var title = document.getElementById("qna_title").value;
                var content = document.getElementById("qna_content").value;
                if (title.trim() === "" || content.trim() === "") {
                } else {
                    alert("수정되었습니다.");
                }
                form.submit();
            })
            $("#writebtn").on("click", function () {
                let form = $("#form");
                form.attr("action", "write");
                form.attr("method", "post")
                var title = document.getElementById("qna_title").value;
                var content = document.getElementById("qna_content").value;
                if (title.trim() === "" || content.trim() === "") {
                } else {
                    alert("작성되었습니다.");
                }
                form.submit();
            })
        });

    </script>
</div>
</html>

