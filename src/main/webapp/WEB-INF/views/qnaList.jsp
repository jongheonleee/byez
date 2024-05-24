<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"  pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<!DOCTYPE html>
<html lang="ko">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>BYEZ</title>
    <link rel="stylesheet" href="../css/nav.css">
    <link rel="stylesheet" href="../css/qnaList.css?after">
    <link rel="stylesheet" href="/css/aside.css?after">
    <link rel="stylesheet" href="../css/footer.css?after">
    <link rel="stylesheet" href="../css/quick.css">
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
                <a href="/qna/list"><span>나의문의</span></a>
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
                        <td class="reg_date"> <c:out value="${fn:substring(CateJoinDto.reg_date, 0, 10)}" /></td>

                    </tr>
                </c:forEach>
            </table>
            <div class="search">
                <form class="searchArea" action="/qna/list" method="get">
                    <div class="searchArea">
                        <select name="cate_num">
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
                        <select   name="search">
                            <%--                        class="search"--%>
                            <option value="title"  ${search == 'title' ? 'selected' : ''}>제목</option>
                            <option value="content" ${search == 'content' ? 'selected' : ''}>내용</option>
                        </select>
                        <input type="text" name="searchContent" value="${searchContent}" placeholder="검색하시오">
                        <input type="checkbox" value="Y" name="res_state">답변 완료
                        <input type="hidden" name="mode" value="search">
                        <button type="submit">검색하기</button>
                        <a href="/qna/write">글쓰기</a>
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
<script src="../js/jquery-3.6.4.min.js"></script>
<script src="../js/nav.js"></script>
<script src="../js/aside.js"></script>
</body>
</html>
