<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"  pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ko">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>BYEZ</title>
    <link rel="stylesheet" href="../css/nav.css">
    <link rel="stylesheet" href="../css/qna_write.css">
    <link rel="stylesheet" href="../css/footer.css">
    <link rel="stylesheet" href="/css/aside.css">
    <link rel="stylesheet" href="../css/quick.css">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.6.0/css/all.min.css" integrity="sha512-Kc323vGBEqzTmouAECnVceyQqyqdsSiqLQISBL29aUW4U/M7pSPA/gEUZQqv1cwx4OnYxTxve5UMg5GT6L4JJg==" crossorigin="anonymous" referrerpolicy="no-referrer" />
    <link rel="preconnect" href="https://fonts.googleapis.com">
    <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
    <link href="https://fonts.googleapis.com/css2?family=Noto+Sans+KR:wght@100..900&display=swap" rel="stylesheet">
    <link rel="icon" href="/img/favicon-32x32_2.png">
</head>

<body>
<jsp:include page="/WEB-INF/views/include/nav.jsp"/>
<section>
    <div class="wrapper">
        <div class="title">
            <p>
                <a href="main.html"><span>home</span></a>
                <span>></span>
                <span>나의 문의</span>
            </p>
            <p>문의 작성</p>
        </div>
        <jsp:include page="/WEB-INF/views/include/aside.jsp"/>
        <form id="form" action="" method="" onsubmit="return validateQna()">
            <div class="content">
                <table class="marginOpt">
                    <th>
                        title
                    </th>
                    <td colspan="2">
                        <select class="selectopt"name="cate_num">
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
                        <input class="titlebtn"id="qna_title" name="qna_title" type="text" placeholder="제목을 작성해 주세요 (100자 제한)" value="${qnaDto.qna_title}">
                    </td>
                    <tr>
                        <th colspan="3">
                            <textarea class="put_large_content" id="qna_content" name="qna_content" placeholder="글을 작성해 주세요 (1000자 제한)" contenteditable="true">${qnaDto.qna_content}</textarea>
                        </th>
                    </tr>
                </table>
                <div class="btn_area">
                    <a href="/qna/list" onclick="return confirm('취소하시고 목록으로 가시겠습니까?')">
                        <button class="listbtn" type="button">목록</button>
                    </a>
                    <div class="btn_right">
                        <c:if test="${mode eq 'write'}">
                            <button class="writebtn" type="button" id="writebtn">등록</button>
                        </c:if>
                        <c:if test="${mode eq 'update'}">
                            <button class ="updatebtn"type="button" id="updatebtn">수정</button>
                            <input type="hidden" name="seq_num" value="${qnaDto.seq_num}">
                        </c:if>
                    </div>
                </div>
            </div>
        </form>
    </div>
    </div>
</section>
<jsp:include page="/WEB-INF/views/include/footer.jsp"/>
<jsp:include page="/WEB-INF/views/include/quick.jsp"/>

<script src="../js/jquery-3.6.4.min.js"></script>
<script src="../js/aside.js"></script>
<script src="../js/nav.js"></script>
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
<script src="../js/jquery-3.6.4.min.js"></script>
<script src="../js/nav.js"></script>
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
        }
        if(title.length>100||content.length>1000){
            alert("글자수 확인하고 작성해 주세요");
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
        $("#updatebtn").on("click", function () {
            let form = $("#form");
            form.attr("action", "/qna/update?seq_num=${qnaDto.seq_num}");
            form.attr("method", "post")

            form.submit();
        })
        $("#writebtn").on("click", function () {
            let form = $("#form");
            form.attr("action", "/qna/write");
            form.attr("method", "post")
            form.submit();
        })
    });

</script>
</body>

</html>

