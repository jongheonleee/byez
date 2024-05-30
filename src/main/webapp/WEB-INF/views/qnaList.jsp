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
    <link rel="stylesheet" href="../css/nav.css">
    <link rel="stylesheet" href="../css/qnaList.css?after?after?after?after?after">
    <link rel="stylesheet" href="/css/aside.css">
    <link rel="stylesheet" href="../css/footer.css">
    <link rel="stylesheet" href="../css/quick.css">
    <script src="https://kit.fontawesome.com/f0e73cfa04.js" crossorigin="anonymous"></script>
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
                <a href="/"><span>home</span></a>
                <span>></span>
                <span>나의 문의</span>

            </p>
            <p>나의 문의</p>
        </div>
        <jsp:include page="/WEB-INF/views/include/aside.jsp"/>
        <div class="content">
            <table class="tableStyle">
                <tr>
                    <th class="cate_num">질문유형</th>
                    <th class="qna_title">제목</th>
                    <th class="res_state">답변여부</th>
                    <th class="reg_date">작성일</th>
                </tr>
                <c:forEach var="CateJoinDto" items="${list}">
                    <tr>
                        <td class="cate_num">${CateJoinDto.cate_state}</td>
                        <td class="qna_title"><a
                                href="/qna/read?seq_num=${CateJoinDto.seq_num}">${CateJoinDto.qna_title}</a></td>
                        <td class="res_state">${CateJoinDto.res_state}</td>
                        <td class="reg_date"> <dateOK:formatDate value="${CateJoinDto.reg_date}" pattern="yyyy.M.d" /></td>

                    </tr>
                </c:forEach>
            </table>
            <div class="search">
                <form class="searchArea" action="/qna/list" method="get">
                    <div class="searchArea">
                        <select class="cateopt" name="cate_num">
                            <option value=null >전체</option>
                            <option value="100" ${cate_num == '100' ? 'selected' : ''}>교환</option>
                            <option value="200" ${cate_num == '200' ? 'selected' : ''}>환불</option>
                            <option value="300" ${cate_num == '300' ? 'selected' : ''}>취소</option>
                            <option value="400" ${cate_num == '400' ? 'selected' : ''}>배송</option>
                            <option value="500" ${cate_num == '500' ? 'selected' : ''}>불량</option>
                            <option value="600" ${cate_num == '600' ? 'selected' : ''}>주문</option>
                            <option value="700" ${cate_num == '700' ? 'selected' : ''}>상품</option>
                            <option value="800" ${cate_num == '800' ? 'selected' : ''}>회원</option>
                            <option value="900" ${cate_num == '900' ? 'selected' : ''}>기타</option>
                            <option value="1000" ${cate_num == '1000' ? 'selected' : ''}>신고</option>
                        </select>
                        <select  class="searchopt" name="search">
                            <%--                        class="search"--%>
                            <option value="title"  ${search == 'title' ? 'selected' : ''}>제목</option>
                            <option value="content" ${search == 'content' ? 'selected' : ''}>내용</option>
                        </select>
                        <input class="okbtn"type="checkbox" value="Y" name="res_state">답변 완료
                        <input class="searchChang"type="text" name="searchContent" value="${searchContent}" placeholder="검색하시오">
                        <input type="hidden" name="mode" value="search">
                        <button type="submit" class="searchbtn">검색</button>
                        <a href="/qna/write"><div class="writebtn">글쓰기</div></a>
                    </div>
                </form>
            </div>
            <div class="page" style="text-align: center">
                <c:if test="${startPage != 1}">
                    <a href="/qna/list?page=${startPage-1}&cate_num=${cate_num}&search=${search}&searchContent=${searchContent}&mode=${mode}&res_state=${res_state}"><</a>
                </c:if>
                <c:forEach var="pageHandler" begin="${startPage}" end="${endPage}">
                    <a href="/qna/list?page=${pageHandler}&cate_num=${cate_num}&search=${search}&searchContent=${searchContent}&mode=${mode}&res_state=${res_state}">${pageHandler}</a>
                </c:forEach>
                <c:if test="${endPage < totalPage}">
                    <a href="/qna/list?page=${endPage+1}&cate_num=${cate_num}&search=${search}&searchContent=${searchContent}&mode=${mode}&res_state=${res_state}">></a>
                </c:if>
            </div>
        </div>
    </div>
</section>
<jsp:include page="/WEB-INF/views/include/footer.jsp"/>
<jsp:include page="/WEB-INF/views/include/quick.jsp"/>
<script src="../js/jquery-3.6.4.min.js"></script>
<script src="../js/nav.js"></script>
<script src="../js/aside.js"></script>
</body>
</html>
