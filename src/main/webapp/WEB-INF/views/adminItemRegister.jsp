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
                <h1 class="mt-4">상품 <span >등록</span></h1>
                <ol class="breadcrumb mb-4">
                    <li class="breadcrumb-item"><a href="index.html">Dashboard</a></li>
                    <li class="breadcrumb-item active">
                        <a href="/itemList">상품</a></li>
                    <li class="breadcrumb-item active">
                        상품 등록
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
                        상품 등록 폼
                    </div>
                    <div class="card-body">
                        <div class="registerForm">
                            <form action="/admin/itemRegister" method="post">
                                <table>
                                    <tr>
                                        <td>상품 번호</td>
                                        <td><input type="text" placeholder="num"></td>
                                    </tr>
                                    <tr>
                                        <td>상품명</td>
                                        <td><input type="text" placeholder="name"></td>
                                    </tr>
                                    <tr>
                                        <td>상품명 상세</td>
                                        <td><input type="text" placeholder="detail_name"></td>
                                    </tr>
                                    <tr>
                                        <td>판매가</td>
                                        <td><input type="text" placeholder="price"></td>
                                    </tr>
                                    <tr>
                                        <td>할인 적용가</td>
                                        <td><input type="text" placeholder="disc_price"></td>
                                    </tr>
                                    <tr>
                                        <td>할인율</td>
                                        <td><input type="text" placeholder="disc_rate"></td>
                                    </tr>
                                    <tr>
                                        <td>할인 기간</td>
                                        <td>
                                            <input type="text" placeholder="period">
                                            <fieldset class="search">
                                                <label for="date3" class="uniform-height">
                                                    <input type="date" id="date3" class="date-input" max="2077-06-20" min="2077-06-05" value="2077-06-15">
                                                </label>
                                                ~
                                                <label for="date4" class="uniform-height">
                                                    <input type="date" id="date4" class="date-input" max="2077-06-20" min="2077-06-05" value="2077-06-15">
                                                </label>
                                                <!-- <input alt="조회"  class= "uniform-height 조회" type="image" src="img/조회.gif"> -->
                                            </fieldset>
                                        </td>
                                    </tr>
                                    <tr>
                                        <td>상품 대표 이미지</td>
                                        <td><input type="file" placeholder="main_img"></td>
                                    </tr>
                                    <tr>
                                        <td>상품 상세 이미지</td>
                                        <td><input type="file" placeholder="detail_img"></td>
                                    </tr>
                                    <tr>
                                        <td>상품 유형</td>
                                        <td>
                                            <input type="text" placeholder="item_type (ex:010101)">
                                        </td>
                                    </tr>

                                    <tr>
                                        <td>고객 유형</td>
                                        <td>
                                            <input type="text" placeholder="cust_type">
                                            <select name="cust_type" id="cust_type">
                                                <option value="" disabled selected>--고객 유형을 선택해주세요--</option>
                                                <option value="f">여성</option>
                                                <option value="m">남성</option>
                                                <option value="u">혼성</option>
                                            </select>
                                        </td>
                                    </tr>

                                    <tr>
                                        <td>사이즈</td>
                                        <td><input type="text" placeholder="size"></td>
                                    </tr>
                                    <tr>
                                        <td>색상</td>
                                        <td>
                                            <input type="text" placeholder="col">
                                            <select id="col" name="col" multiple="multiple">
                                                <option value="">선택</option><option value="" disabled selected>--색깔 유형을 선택해주세요--</option>
                                                <option value="검정">#000000</option>
                                                <option value="하양">#ffffff</option>
                                                <option value="남색">#000080</option>
                                                <option value="회색">#9c9c9c</option>
                                                <option value="라이트그레이">#dfdfdf</option>
                                                <option value="카키">#556b2f</option>
                                                <option value="핑크">#ffc0cb</option>
                                                <option value="레드">#ff0000</option>
                                                <option value="파랑">#0000ff</option>
                                                <option value="베이지">#f5f5dc</option>
                                                <option value="크림">#fff8ed</option>
                                                <option value="골드">#fafad2</option>
                                                <option value="실버">#c0c0c0</option>
                                                <option value="노랑">#ffff00</option>
                                                <option value="갈색">#a52a2a</option>
                                                <option value="라벤더">#e6e6fa</option>
                                                <option value="라이트그린">#90ee90</option>
                                                <option value="라이트블루">#add8e6</option>
                                            </select>
                                        </td>
                                    </tr>
                                    <tr>
                                        <td>상품 상세</td>
                                        <td><input type="text" placeholder="comt" value="..."></td>
                                    </tr>

                                    <tr>
                                        <td>상품 출시일</td>
                                        <td>
                                            <input type="text" placeholder="rel_date">
                                            <fieldset class="search">
                                                <label for="date3" class="uniform-height">
                                                    <input type="date" id="date3" class="date-input" max="2077-06-20" min="2077-06-05" value="2077-06-15">
                                                </label>
                                            </fieldset>
                                        </td>
                                    </tr>
                                    <tr>
                                        <td>상품 입고일</td>
                                        <td>
                                            <input type="text" placeholder="gr_date">
                                            <fieldset class="search">
                                                <label for="date3" class="uniform-height">
                                                    <input type="date" id="date3" class="date-input" max="2077-06-20" min="2077-06-05" value="2077-06-15">
                                                </label>
                                            </fieldset>
                                        </td>
                                    </tr>
                                    <tr>
                                        <td>제조사</td>
                                        <td><input type="text" placeholder="mfg_corp"></td>
                                    </tr>
                                    <tr>
                                        <td>제조자</td>
                                        <td><input type="text" placeholder="mfg_name"></td>
                                    </tr>
                                    <tr>
                                        <td>제조연월</td>
                                        <td>
                                            <input type="text" placeholder="mfg_date">
                                            <fieldset class="search">
                                                <label for="date3" class="uniform-height">
                                                    <input type="date" id="date3" class="date-input" max="2077-06-20" min="2077-06-05" value="2077-06-15">
                                                </label>
                                            </fieldset>
                                        </td>
                                    </tr>
                                    <tr>
                                        <td>모델명</td>
                                        <td><input type="text" placeholder="model"></td>
                                    </tr>
                                    <tr>
                                        <td>원산지</td>
                                        <td><input type="text" placeholder="origin"></td>
                                    </tr>
                                    <tr>
                                        <td>판매 상태</td>
                                        <td>
                                            <input type="text" placeholder="state_code">
                                            <select name="state_code" id="state_code">
                                                <option value="" disabled selected>--판매 상태를 선택해주세요--</option>
                                                <option value="SLA1">판매중</option>
                                                <option value="SLA2">품절</option>
                                                <option value="SLA3">재입고</option>
                                                <option value="SLA4">절판</option>
                                            </select>
                                        </td>
                                    </tr>
                                    <tr>
                                        <td>제품 소재</td>
                                        <td><input type="text" placeholder="matr"></td>
                                    </tr>
                                    <tr>
                                        <td>주의사항</td>
                                        <td><input type="text" placeholder="caut"></td>
                                    </tr>
                                    <tr>
                                        <td>코드</td>
                                        <td><input type="text" placeholder="code"></td>
                                    </tr>
                                    <tr>
                                        <td>리뷰 수</td>
                                        <td><input type="text" placeholder="review_cnt" value="0"></td>
                                    </tr>
                                    <tr>
                                        <td>좋아요 수</td>
                                        <td><input type="text" placeholder="like_cnt" value="0"></td>
                                    </tr>
                                    <tr>

                                        <td>평균 별점</td>
                                        <td><input type="text" placeholder="review_rate" value="0"></td>
                                    </tr>
                                    <tr>
                                        <td>조회수</td>
                                        <td><input type="text" placeholder="view_cnt" value="0"></td>
                                    </tr>
                                    <tr>
                                        <td>재고</td>
                                        <td><input type="text" placeholder="stock_qty" value="0"></td>
                                    </tr>
                                    <tr>
                                        <td>판매량</td>
                                        <td><input type="text" placeholder="sales_qty" value="0"></td>
                                    </tr>
                                    <tr>
                                        <td>비고</td>
                                        <td><input type="text" placeholder="remark"></td>
                                    </tr>
                                </table>
                                <button type="submit" class="add-button" >등록하기</button>
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
<script scr="jquery.multiple.select.js"></script>
<script>
  $("#cust_type").multipleSelect({
    filter: true
  });
</script>
</body>
</html>

