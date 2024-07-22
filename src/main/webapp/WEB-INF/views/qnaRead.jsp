<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"  pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="dateOK" %>

<!DOCTYPE html>
<html lang="ko">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>BYEZ</title>
    <link rel="stylesheet" href="/css/nav.css">
    <link rel="stylesheet" href="/css/qna_read.css?after?after">
    <link rel="stylesheet" href="/css/footer.css?after">
    <link rel="stylesheet" href="/css/aside.css">
    <link rel="stylesheet" href="/css/quick.css">
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
                <span>나의문의</span>
            </p>
            <p>나의 문의</p>
        </div>
        <jsp:include page="/WEB-INF/views/include/aside.jsp"/>
        <div class="content">
            <table>
                <tbody class="custom_section">
                <tr>
                    <th scope="row">제목</th>
                    <td colspan="3">${qnaDto.qna_title}</td>
                </tr>
                <tr>
                    <th scope="row">작성자</th>
                    <td class="second_width">${qnaDto.qna_writer}</td>
                    <th class ="third_width" scope="row">답변여부</th>
                    <td>${qnaDto.res_state}</td>
                </tr>
                <tr class="put_line_class">
                    <th scope="row">입력날짜</th>
                    <td colspan="3"><dateOK:formatDate value="${qnaDto.reg_date}" pattern="yyyy.M.d" /></td>
                </tr>
                <tr>
                    <td colspan="4">${qnaDto.qna_content}</td>
                </tr>
                </tbody>
            </table>
        </div>
        <!--관리자 답변 x-->
        <c:if test="${qnaDto.res_content eq null}">
            <div class="content">
                <div class="noReviewBox">
                    <p>답변 대기중입니다. 조금만 기달려주세요.</p>
                </div>
            </div>
            <div class="content">
                <div class="btn_area">
                    <a href="/qna/list"><button class="listbtn">목록</button></a>
                    <div class="btn_right">
                        <a href="/qna/delete?seq_num=${qnaDto.seq_num}" onclick="return confirm('삭제하시겠습니까?')"><button class="deletebtn">삭제</button></a>
                        <a href="/qna/update?seq_num=${qnaDto.seq_num}" onclick="return confirm('수정하시겠습니까?')"><button class="updatebtn">수정</button></a>
                    </div>
                </div>
            </div>

        </c:if>
        <c:if test="${qnaDto.res_content ne null}">
            <div class="content">
                <table>
                    <tbody class="manage_section">
                    <tr>
                        <th scope="row">답변자</th>
                        <td>${qnaDto.res_writer}</td>
                    </tr>
                    <tr class="put_line_class">
                        <th class="redred" scope="row">답변날짜</th>
                        <td><dateOK:formatDate value="${qnaDto.up_date}" pattern="yyyy.M.d" /></td>
                    </tr>
                    <tr class="put_detail_content">
                        <td colspan="3">
                            <div>${qnaDto.res_content}</div>
                        </td>
                    </tr>
                    </tbody>
                </table>
            </div>
            <div class="content">
                <div class="btn_area">
                    <a href="/qna/list"><button class="listbtn">목록</button></a>
                </div>
            </div>
        </c:if>
        <!--관리자 답변 o-->

        <!--관리자 답변 x-->

        <!--관리자 답변 o-->
        <!-- <div>
            <a href=""><button class="white_btn">목록</button></a>
        </div> -->
    </div>
</section>
<jsp:include page="/WEB-INF/views/include/footer.jsp"/>
<jsp:include page="/WEB-INF/views/include/quick.jsp"/>
<script src="/js/jquery-3.6.4.min.js"></script>
<script src="/js/aside.js"></script>
<script src="/js/nav.js"></script>
</body>

<%--    function readURL(input) {--%>
<%--        var file = input.files[0]--%>
<%--        console.log(file)--%>
<%--        if (file != '') {--%>
<%--            var reader = new FileReader();--%>
<%--            reader.readAsDataURL(file);--%>
<%--            reader.onload = function (e) {--%>
<%--                console.log(e.target)--%>
<%--                console.log(e.target.result)--%>
<%--                $('#preview').attr('src', e.target.result);--%>
<%--            }--%>
<%--        }--%>
<%--    }--%>
<%--</script>--%>
</html>
