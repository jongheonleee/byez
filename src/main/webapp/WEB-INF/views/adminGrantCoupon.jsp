<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"  pageEncoding="UTF-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8" />
    <meta http-equiv="X-UA-Compatible" content="IE=edge" />
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no" />
    <meta name="description" content="" />
    <meta name="author" content="" />
    <title>Tables - SB Admin</title>
    <link href="https://cdn.jsdelivr.net/npm/simple-datatables@7.1.2/dist/style.min.css" rel="stylesheet" />
    <link href="/css/styles.css" rel="stylesheet" />
    <link rel="stylesheet" href="/css/table.css?after">
    <link rel="stylesheet" href="/css/form.css">
    <script src="https://use.fontawesome.com/releases/v6.3.0/js/all.js" crossorigin="anonymous"></script>
    <link rel="icon" href="/img/favicon-32x32_2.png">
</head>
<body class="sb-nav-fixed">
<nav class="sb-topnav navbar navbar-expand navbar-dark bg-dark">
    <!-- Navbar Brand-->
    <a class="navbar-brand ps-3" href="index.html">BYEZ</a>
    <!-- Sidebar Toggle-->
    <button class="btn btn-link btn-sm order-1 order-lg-0 me-4 me-lg-0" id="sidebarToggle" href="#!"><i class="fas fa-bars"></i></button>
    <!-- Navbar Search-->
    <form class="d-none d-md-inline-block form-inline ms-auto me-0 me-md-3 my-2 my-md-0">
        <div class="input-group">
            <input class="form-control" type="text" placeholder="Search for..." aria-label="Search for..." aria-describedby="btnNavbarSearch" />
            <button class="btn btn-primary" id="btnNavbarSearch" type="button"><i class="fas fa-search"></i></button>
        </div>
    </form>
    <!-- Navbar-->
    <ul class="navbar-nav ms-auto ms-md-0 me-3 me-lg-4">
        <li class="nav-item dropdown">
            <a class="nav-link dropdown-toggle" id="navbarDropdown" href="#" role="button" data-bs-toggle="dropdown" aria-expanded="false"><i class="fas fa-user fa-fw"></i></a>
            <ul class="dropdown-menu dropdown-menu-end" aria-labelledby="navbarDropdown">
                <li><a class="dropdown-item" href="#!">Settings</a></li>
                <li><a class="dropdown-item" href="#!">Activity Log</a></li>
                <li><hr class="dropdown-divider" /></li>
                <li><a class="dropdown-item" href="#!">Logout</a></li>
            </ul>
        </li>
    </ul>
</nav>
<div id="layoutSidenav">
    <jsp:include page="/WEB-INF/views/include/adminNav.jsp"/>
    <div id="layoutSidenav_content">
        <main>
            <div class="container-fluid px-4">
                <h1 class="mt-4">쿠폰 <span>목록</span></h1>
                <!-- <div class="card mb-4">
                    <div class="card-body">
                        DataTables is a third party plugin that is used to generate the demo table below. For more information about DataTables, please visit the
                        <a target="_blank" href="https://datatables.net/">official DataTables documentation</a>
                        .
                    </div>
                </div> -->
                <div class="card mb-4">
                    <div class="card-header">
                        <i class="fas fa-table me-1"></i>
                        쿠폰 테이블
                    </div>
                    <div class="card-body">
                        <div class="registerForm">
                            <form action="/grantCoupon" method="post">
                                <table>
                                    <tr>
                                        <td>사용자 ID</td>
                                        <td><input type="text" id="userId" name="userId" placeholder="사용자의 ID를 입력하세요"></td>
                                    </tr>
                                    <tr>
                                        <td>쿠폰 이름</td>
                                        <td><input type="text" id="couponName" name="couponName" placeholder="지급할 쿠폰의 이름을 입력하세요"></td>
                                    </tr>
                                </table>
                                <button type="submit" class="add-button">쿠폰 지급</button>
                            </form>
                        </div>
                        <br><br>
                        <table id="datatablesSimple">
                            <thead>
                            <tr>
                                <th>쿠폰 이름</th>
                                <th>할인율</th>
                                <th>유효기간(일)</th>
                                <th>최소 결제 금액</th>
                                <th>최대 할인 금액</th>
                                <th>지급 가능 여부</th>
                                <th>할인 유형</th>
                                <th>설명</th>
                                <th>비고</th>
                            </tr>
                            </thead>
                            <tbody>
                            <c:forEach items="${couponList}" var="coupon">
                                <tr>
                                    <td>${coupon.name}</td>
                                    <td>${coupon.prmo}</td>
                                    <td>${coupon.validDay}</td>
                                    <td>${coupon.minPayPrice}</td>
                                    <td>${coupon.maxDiscPrice}</td>
                                    <td>${coupon.ableChk}</td>
                                    <td>${coupon.discType}</td>
                                    <td>${coupon.comt}</td>
                                    <td>${coupon.remark}</td>
                                </tr>
                            </c:forEach>
                            </tbody>
                        </table>

                    </div>
                </div>
            </div>
        </main>
        <footer class="py-4 bg-light mt-auto">
            <div class="container-fluid px-4">
                <div class="d-flex align-items-center justify-content-between small">
                    <div class="text-muted">Copyright &copy; BYEZ 2024</div>
                    <div>
                        <a href="#">Privacy Policy</a>
                        &middot;
                        <a href="#">Terms &amp; Conditions</a>
                    </div>
                </div>
            </div>
        </footer>
    </div>
</div>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js" crossorigin="anonymous"></script>
<script src="/js/scripts.js"></script>
<script src="/js/adminItemList.js"></script>
<script src="https://cdn.jsdelivr.net/npm/simple-datatables@7.1.2/dist/umd/simple-datatables.min.js" crossorigin="anonymous"></script>
<script src="/js/datatables-simple-demo.js"></script>
<script>

    document.addEventListener("DOMContentLoaded", function() {
        const urlParams = new URLSearchParams(window.location.search);
        if (urlParams.get('grantSuccess') === 'true') {
            alert('쿠폰 지급이 완료되었습니다.');
        }
    });

    function deleteCouponType(name) {
        var confirmDelete = confirm("정말로 삭제하시겠습니까?");
        if (confirmDelete) {
            window.location.href = 'deleteCouponType?name=' + name;
        }
    }

</script>
</body>
</html>