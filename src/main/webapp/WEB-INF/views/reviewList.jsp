<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: chanbin
  Date: 2024-04-26
  Time: 오전 11:07
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Review Page</title>
    <style>
        .bold {
            font-weight: bold;
        }

        .light {
            opacity: 0.5;
        }

        .hidden {
            display: none;
        }

        .clickable {
            cursor: pointer;
        }
    </style>
</head>
<body>
<h1>Review Page</h1>
<span id="pendingHeader" class="clickable bold" onclick="toggleReviews('pending')">작성 가능한 리뷰</span>
<span id="completedHeader" class="clickable light" onclick="toggleReviews('completed')">작성 완료한 리뷰</span>

<div id="pendingReviews" class="reviews">
    <h2 class="bold">작성 가능한 리뷰</h2>
    <ul>
        <c:forEach var="offList" items="${reviewOffList}">
            <tr>
                <td>
                    <div class="n-prd-row">
                        <a href="https://www.musinsa.com/app/goods/1973470/0" class="img-block">
                            <img src="//image.msscdn.net/images/goods_img/20210528/1973470/1973470_17119378809255_160.jpg"
                                 alt="아비드 백팩_Black">
                        </a>
                        <ul class="info">
                            <li class="name"><a
                                    href="https://www.musinsa.com/app/goods/1973470/0">${offList.item_name}</a></li>
                            <li class="option">옵션 : ${offList.opt1},${offList.opt2}</li>
                            <a href="/review/write?ord_num=${offList.ord_num}&item_num=${offList.item_num}">
                                <button>작성하기</button>
                            </a>
                            </li>
                        </ul>
                    </div>
                </td>
            </tr>
        </c:forEach>
    </ul>
</div>

<div id="completedReviews" class="reviews hidden">
    <h2 class="bold">작성 완료한 리뷰</h2>
    <ul>
        <c:forEach var="onList" items="${reviewOnList}">
            <tr>
                <td>
                    <div class="n-prd-row">
                        <a href="https://www.musinsa.com/app/goods/1973470/0" class="img-block">
                            <img src="//image.msscdn.net/images/goods_img/20210528/1973470/1973470_17119378809255_160.jpg"
                                 alt="아비드 백팩_Black">
                        </a>
                        <ul class="info">
                            <li class="name">
                                <a href="https://www.musinsa.com/app/goods/1973470/0">${onList.item_name}</a></li>
                            <li class="option">옵션 : ${onList.opt1},${onList.opt2}</li>
                            <li class="score"> 별점 :${onList.score}</li>
                            <li class="title"> 한줄평 : ${onList.title}</li>
                            <li class="content"> ${onList.content}</li>
                        </ul>
                        <span>
                            <a href="/review/modify?review_num=${onList.review_num}&ord_num=${onList.ord_num}&item_num=${onList.item_num}" onclick="return confirm('수정하시겠습니까?')"
                            >
                            <button>수정하기</button>
                            </a>
                            <a href="/review/delete?review_num=${onList.review_num}" onclick="return confirm('삭제하시겠습니까?')">
                            <button>삭제하기</button>
                            </a>
                        </span>
                    </div>
                </td>
            </tr>
        </c:forEach>
    </ul>
</div>

<script>
    function toggleReviews(type) {
        if (type === 'pending') {
            document.getElementById('pendingReviews').classList.remove('hidden');
            document.getElementById('completedReviews').classList.add('hidden');
            document.getElementById('pendingHeader').classList.add('bold');
            document.getElementById('pendingHeader').classList.remove('light');
            document.getElementById('completedHeader').classList.remove('bold');
            document.getElementById('completedHeader').classList.add('light');
        } else if (type === 'completed') {
            document.getElementById('completedReviews').classList.remove('hidden');
            document.getElementById('pendingReviews').classList.add('hidden');
            document.getElementById('completedHeader').classList.add('bold');
            document.getElementById('completedHeader').classList.remove('light');
            document.getElementById('pendingHeader').classList.remove('bold');
            document.getElementById('pendingHeader').classList.add('light');
        }
    }
</script>
</body>
</html>


