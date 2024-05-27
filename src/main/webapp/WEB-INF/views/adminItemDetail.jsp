<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"  pageEncoding="UTF-8"%>
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
    <link rel="stylesheet" href="/css/form.css">
    <script src="https://use.fontawesome.com/releases/v6.3.0/js/all.js" crossorigin="anonymous"></script>
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
                <h1 class="mt-4">상품 <span >수정&삭제</span></h1>
                <ol class="breadcrumb mb-4">
                    <li class="breadcrumb-item"><a href="index.html">Dashboard</a></li>
                    <li class="breadcrumb-item active">
                        <a href="/itemList">상품</a></li>
                    <li class="breadcrumb-item active">
                        상품 수정&삭제
                    </li>
                </ol>
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
                        상품 폼
                    </div>
                    <div class="card-body">
                        <div class="registerForm">
                            <form action="">
                                <table>
                                    <tr>
                                        <td>num</td>
                                        <td><input type="text" placeholder="num" name="num" value="${itemRegisterInfo.num}"></td>
                                    </tr>
                                    <tr>
                                        <td>name</td>
                                        <td><input type="text" placeholder="name" name="name" value="${itemRegisterInfo.name}"></td>
                                    </tr>
                                    <tr>
                                        <td>price</td>
                                        <td><input type="text" placeholder="price" name="price" value="${itemRegisterInfo.price}"></td>
                                    </tr>
                                    <tr>
                                        <td>disc_price</td>
                                        <td><input type="text" placeholder="disc_price" name="disc_price" value="${itemRegisterInfo.disc_price}"></td>
                                    </tr>
                                    <tr>
                                        <td>main_img</td>
                                        <td><input type="text" placeholder="main_img" name="main_img" value="${itemRegisterInfo.main_img}"></td>
                                    </tr>
                                    <tr>
                                        <td>item_type</td>
                                        <td><input type="text" placeholder="item_type" name="item_type" value="${itemRegisterInfo.item_type}"></td>
                                    </tr>
                                    <tr>
                                        <td>review_cnt</td>
                                        <td><input type="text" placeholder="review_cnt" name="review_cnt" value="${itemRegisterInfo.review_cnt}"></td>
                                    </tr>
                                    <tr>
                                        <td>like_cnt</td>
                                        <td><input type="text" placeholder="like_cnt" name="like_cnt" value="${itemRegisterInfo.like_cnt}"></td>
                                    </tr>
                                    <tr>

                                        <td>review_rate</td>
                                        <td><input type="text" placeholder="review_rate" name="review_rate" value="${itemRegisterInfo.review_rate}"></td>
                                    </tr>
                                    <tr>
                                        <td>cust_type</td>
                                        <td><input type="text" placeholder="cust_type" name="cust_type" value="${itemRegisterInfo.cust_type}"></td>
                                    </tr>
                                    <tr>
                                        <td>disc_rate</td>
                                        <td><input type="text" placeholder="disc_rate" name="disc_rate" value="${itemRegisterInfo.disc_rate}"></td>
                                    </tr>
                                    <tr>
                                        <td>period</td>
                                        <td><input type="text" placeholder="period" name="period" value="${itemRegisterInfo.period}"></td>
                                    </tr>
                                    <tr>
                                        <td>size</td>
                                        <td><input type="text" placeholder="size" name="size" value="${itemRegisterInfo.size}"></td>
                                    </tr>
                                    <tr>
                                        <td>col</td>
                                        <td><input type="text" placeholder="col" name="col" value="${itemRegisterInfo.col}"></td>
                                    </tr>
                                    <tr>
                                        <td>remark</td>
                                        <td><input type="text" placeholder="remark" name="remark" value="${itemRegisterInfo.remark}"></td>
                                    </tr>
                                    <tr>
                                        <td>detail_name</td>
                                        <td><input type="text" placeholder="detail_name" name="detail_name" value="${itemRegisterInfo.detail_name}"></td>
                                    </tr>
                                    <tr>
                                        <td>comt</td>
                                        <td><input type="text" placeholder="comt" name="comt" value="${itemRegisterInfo.comt}"></td>
                                    </tr>
                                    <tr>
                                        <td>detail_img</td>
                                        <td><input type="text" placeholder="detail_img" name="detail_img" value="${itemRegisterInfo.detail_img}"></td>
                                    </tr>
                                    <tr>
                                        <td>rel_date</td>
                                        <td><input type="text" placeholder="rel_date" name="rel_date" value="${itemRegisterInfo.rel_date}"></td>
                                    </tr>
                                    <tr>
                                        <td>gr_date</td>
                                        <td><input type="text" placeholder="gr_date" name="gr_date" value="${itemRegisterInfo.num}"></td>
                                    </tr>
                                    <tr>
                                        <td>mfg_corp</td>
                                        <td><input type="text" placeholder="mfg_corp" name="mfg_corp" value="${itemRegisterInfo.mfg_corp}"></td>
                                    </tr>
                                    <tr>
                                        <td>mfg_name</td>
                                        <td><input type="text" placeholder="mfg_name" name="mfg_name" value="${itemRegisterInfo.mfg_name}"></td>
                                    </tr>
                                    <tr>
                                        <td>mfg_date</td>
                                        <td><input type="text" placeholder="mfg_date" name="mfg_date" value="${itemRegisterInfo.mfg_date}"></td>
                                    </tr>
                                    <tr>
                                        <td>view_cnt</td>
                                        <td><input type="text" placeholder="view_cnt" name="view_cnt" value="${itemRegisterInfo.view_cnt}"></td>
                                    </tr>
                                    <tr>
                                        <td>model</td>
                                        <td><input type="text" placeholder="model" name="model" value="${itemRegisterInfo.model}"></td>
                                    </tr>
                                    <tr>
                                        <td>stock_qty</td>
                                        <td><input type="text" placeholder="stock_qty" name="stock_qty" value="${itemRegisterInfo.stock_qty}"></td>
                                    </tr>
                                    <tr>
                                        <td>origin</td>
                                        <td><input type="text" placeholder="origin" name="origin" value="${itemRegisterInfo.origin}"></td>
                                    </tr>
                                    <tr>
                                        <td>state_code</td>
                                        <td><input type="text" placeholder="state_code" name="state_code" value="${itemRegisterInfo.state_code}"></td>
                                    </tr>
                                    <tr>
                                        <td>matr</td>
                                        <td><input type="text" placeholder="matr" name="matr" value="${itemRegisterInfo.matr}"></td>
                                    </tr>
                                    <tr>
                                        <td>code</td>
                                        <td><input type="text" placeholder="code" name="code" value="${itemRegisterInfo.code}"></td>
                                    </tr>
                                    <tr>
                                        <td>sales_qty</td>
                                        <td><input type="text" placeholder="sales_qty" name="sales_qty" value="${itemRegisterInfo.sales_qty}"></td>
                                    </tr>
                                    <tr>
                                        <td>caut</td>
                                        <td><input type="text" placeholder="caut" name="caut" value="${itemRegisterInfo.caut}"></td>
                                    </tr>
                                </table>
                            </form>
                            <button type="submit" class="add-button" id="modify">수정하기</button>
                            <button type="submit" class="add-button" style="color: red;" id="delete">삭제하기</button>
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
</body>
</html>

