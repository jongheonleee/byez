<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8" />
    <meta http-equiv="X-UA-Compatible" content="IE=edge" />
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no" />
    <meta name="description" content="" />
    <meta name="author" content="" />
    <title>쿠폰 만들기</title>
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
                <h1 class="mt-4">쿠폰 <span >생성</span></h1>
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
                        쿠폰 생성 폼
                    </div>
                    <div class="card-body">
                        <div class="registerForm">
                            <form action="/createCouponType" method="post" onsubmit="return validateForm()">
                                <table>
                                    <tr>
                                        <td>쿠폰 이름</td>
                                        <td><input type="text" id="name" name="name" placeholder="쿠폰의 이름을 입력하세요"></td>
                                    </tr>
                                    <tr>
                                        <td>할인 유형</td>
                                        <td><input type="text" id="discType" name="discType" placeholder="할인 유형을 입력하세요"></td>
                                    </tr>
                                    <tr>
                                        <td>할인</td>
                                        <td><input type="text" id="prmo" name="prmo" placeholder="할인혜택을 입력하세요 (PER or ABS)"></td>
                                    </tr>
                                    <tr>
                                        <td>유효기간(일)</td>
                                        <td><input type="text" id="validDay" name="validDay" placeholder="유효기간을 입력하세요"></td>
                                    </tr>
                                    <tr>
                                        <td>최소 결제 금액</td>
                                        <td><input type="text" id="minPayPrice" name="minPayPrice" placeholder="최소 결제 금액을 입력하세요"></td>
                                    </tr>
                                    <tr>
                                        <td>최대 할인 금액</td>
                                        <td>
                                            <input type="text" id="maxDiscPrice" name="maxDiscPrice" placeholder="최대 할인 금액을 입력하세요">
                                        </td>
                                    </tr>
                                    <tr>
                                        <td>설명</td>
                                        <td><input type="text" id="comt" name="comt" placeholder="쿠폰에 대한 설명을 입력하세요"></td>
                                    </tr>
                                    <tr>
                                        <td>비고</td>
                                        <td><input type="text" id="remark" name="remark" placeholder="비고를 입력하세요"></td>
                                    </tr>
                                </table>
                                <button type="submit" class="add-button">쿠폰 추가</button>
                            </form>
                        </div>
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
<script src="https://cdn.jsdelivr.net/npm/simple-datatables@7.1.2/dist/umd/simple-datatables.min.js" crossorigin="anonymous"></script>
<script src="/js/datatables-simple-demo.js"></script>
<script>

    <c:if test="${not empty error}">
    alert("${error}");
    </c:if>

    function validateForm() {
        var name = document.getElementById("name").value;
        var discType = document.getElementById("discType").value;
        var prmo = document.getElementById("prmo").value;
        var validDay = document.getElementById("validDay").value;
        var minPayPrice = document.getElementById("minPayPrice").value;
        var maxDiscPrice = document.getElementById("maxDiscPrice").value;

        // 이름 필드가 비어 있는지 확인
        if (name.trim() === "") {
            alert("쿠폰 이름을 입력하세요.");
            return false;
        }

        // 할인 유형 필드가 PER 또는 ABS 중 하나인지 확인
        if (discType !== "PER" && discType !== "ABS") {
            alert("올바른 할인 유형을 입력하세요 (PER 또는 ABS).");
            return false;
        }

        // 할인 필드가 숫자인지 확인
        if (isNaN(prmo) || prmo < 1) {
            alert("할인은 1이상의 숫자여야 합니다");
            return false;
        }

        // 유효기간 필드가 숫자인지 확인
        if (isNaN(validDay) || validDay < 1) {
            alert("유효기간은 1 이상의 숫자여야 합니다.");
            return false;
        }

        // 최소 결제 금액 필드가 숫자인지 확인
        if (isNaN(minPayPrice) || minPayPrice < 0) {
            alert("최소 결제 금액은 0 이상의 숫자여야 합니다.");
            return false;
        }

        // 최대 할인 금액 필드가 숫자인지 확인
        if (isNaN(maxDiscPrice) || maxDiscPrice < 0) {
            alert("최대 할인 금액은 0 이상의 숫자여야 합니다.");
            return false;
        }

        // 모든 필드가 올바르게 채워져 있는 경우 true 반환
        return true;
    }
</script>
</body>
</html>
