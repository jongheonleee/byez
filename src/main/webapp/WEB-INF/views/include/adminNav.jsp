<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<div id="layoutSidenav_nav">
    <nav class="sb-sidenav accordion sb-sidenav-dark" id="sidenavAccordion">
        <div class="sb-sidenav-menu">
            <div class="nav">

                <div class="sb-sidenav-menu-heading">Core</div>
                <a class="nav-link" href="index.html">
                    <div class="sb-nav-link-icon"><i class="fas fa-tachometer-alt"></i></div>
                    대시보드
                </a>
                <div class="sb-sidenav-menu-heading">Interface</div>

                <!-- <a class="nav-link collapsed" href="#" data-bs-toggle="collapse" data-bs-target="#collapseLayouts" aria-expanded="false" aria-controls="collapseLayouts">
                    <div class="sb-nav-link-icon"><i class="fas fa-columns"></i></div>
                    Layouts
                    <div class="sb-sidenav-collapse-arrow"><i class="fas fa-angle-down"></i></div>
                </a>
                <div class="collapse" id="collapseLayouts" aria-labelledby="headingOne" data-bs-parent="#sidenavAccordion">
                    <nav class="sb-sidenav-menu-nested nav">
                        <a class="nav-link" href="layout-static.html">Static Navigation</a>
                        <a class="nav-link" href="layout-sidenav-light.html">Light Sidenav</a>
                    </nav>
                </div> -->

                <a class="nav-link collapsed" href="#" data-bs-toggle="collapse" data-bs-target="#collapseOrder" aria-expanded="false" aria-controls="collapseOrder">
                    <div class="sb-nav-link-icon"><i class="fas fa-columns"></i></div>
                    주문
                    <div class="sb-sidenav-collapse-arrow"><i class="fas fa-angle-down"></i></div>
                </a>
                <div class="collapse" id="collapseOrder" aria-labelledby="headingOne" data-bs-parent="#sidenavAccordion">
                    <nav class="sb-sidenav-menu-nested nav">
                        <a class="nav-link" href="item.html">주문 대시보드</a>
                        <a class="nav-link" href="layout-sidenav-light.html">전체 주문 조회</a>
                        <a class="nav-link" href="layout-sidenav-light.html">배송 관리</a>
                        <a class="nav-link" href="layout-sidenav-light.html">입금전 관리</a>
                        <a class="nav-link" href="layout-sidenav-light.html">배송 준비중 관리</a>
                        <a class="nav-link" href="layout-sidenav-light.html">배송 대기 관리</a>
                        <a class="nav-link" href="layout-sidenav-light.html">배송 중 관리</a>
                        <a class="nav-link" href="layout-sidenav-light.html">배송 완료 조회</a>
                        <a class="nav-link" href="layout-sidenav-light.html">취소/교환/반품</a>
                        <a class="nav-link" href="layout-sidenav-light.html">입금전 취소 관리</a>
                        <a class="nav-link" href="layout-sidenav-light.html">취소 관리</a>
                        <a class="nav-link" href="layout-sidenav-light.html">교환 관리</a>
                        <a class="nav-link" href="layout-sidenav-light.html">반품 관리</a>
                        <a class="nav-link" href="layout-sidenav-light.html">취소 조회</a>
                    </nav>
                </div>

                <a class="nav-link collapsed" href="#" data-bs-toggle="collapse" data-bs-target="#collapseLayouts" aria-expanded="false" aria-controls="collapseLayouts">
                    <div class="sb-nav-link-icon"><i class="fas fa-columns"></i></div>
                    상품
                    <div class="sb-sidenav-collapse-arrow"><i class="fas fa-angle-down"></i></div>
                </a>
                <div class="collapse" id="collapseLayouts" aria-labelledby="headingOne" data-bs-parent="#sidenavAccordion">
                    <nav class="sb-sidenav-menu-nested nav">
                        <a class="nav-link" href="#">상품 대시보드</a>
                        <a class="nav-link" href="/admin/item">상품 목록</a>
                        <a class="nav-link" href="/admin/itemRegister">상품 등록</a>
                        <a class="nav-link" href="#">상품 관리</a>
                        <a class="nav-link" href="#">분류 관리</a>
                        <a class="nav-link" href="/admin/itemStock">재고 관리</a>
                        <a class="nav-link" href="#">상품 옵션 관리</a>
                    </nav>
                </div>


                <a class="nav-link collapsed" href="#" data-bs-toggle="collapse" data-bs-target="#collapsePages" aria-expanded="false" aria-controls="collapsePages">
                    <div class="sb-nav-link-icon"><i class="fas fa-book-open"></i></div>
                    고객
                    <div class="sb-sidenav-collapse-arrow"><i class="fas fa-angle-down"></i></div>
                </a>
                <div class="collapse" id="collapsePages" aria-labelledby="headingTwo" data-bs-parent="#sidenavAccordion">
                    <nav class="sb-sidenav-menu-nested nav accordion" id="sidenavAccordionPages">
                        <a class="nav-link collapsed" href="#" data-bs-toggle="collapse" data-bs-target="" aria-expanded="false" aria-controls="">
                            고객 대시보드
                        </a>

                        <a class="nav-link collapsed" href="#" data-bs-toggle="collapse" data-bs-target="#pagesCollapseAuth" aria-expanded="false" aria-controls="pagesCollapseAuth">
                            회원 조회
                            <div class="sb-sidenav-collapse-arrow"><i class="fas fa-angle-down"></i></div>
                        </a>
                        <div class="collapse" id="pagesCollapseAuth" aria-labelledby="headingOne" data-bs-parent="#sidenavAccordionPages">
                            <nav class="sb-sidenav-menu-nested nav">
                                <a class="nav-link" href="login.html">회원 정보 조회</a>
                                <a class="nav-link" href="register.html">주문 회원 조회</a>
                                <a class="nav-link" href="password.html">구매액 상위회원 조회</a>
                            </nav>
                        </div>

                        <a class="nav-link collapsed" href="#" data-bs-toggle="collapse" data-bs-target="#pagesCollapseError" aria-expanded="false" aria-controls="pagesCollapseError">
                            회원 관리
                            <div class="sb-sidenav-collapse-arrow"><i class="fas fa-angle-down"></i></div>
                        </a>
                        <div class="collapse" id="pagesCollapseError" aria-labelledby="headingOne" data-bs-parent="#sidenavAccordionPages">
                            <nav class="sb-sidenav-menu-nested nav">
                                <a class="nav-link" href="401.html">회원 탈퇴 관리</a>
                                <a class="nav-link" href="404.html">회원 접속 관리</a>
                            </nav>
                        </div>

                    </nav>
                </div>

                <a class="nav-link collapsed" href="#" data-bs-toggle="collapse" data-bs-target="#collapseCoupon" aria-expanded="false" aria-controls="collapseCoupon">
                    <div class="sb-nav-link-icon"><i class="fas fa-columns"></i></div>
                    쿠폰
                    <div class="sb-sidenav-collapse-arrow"><i class="fas fa-angle-down"></i></div>
                </a>
                <div class="collapse" id="collapseCoupon" aria-labelledby="headingOne" data-bs-parent="#sidenavAccordion">
                    <nav class="sb-sidenav-menu-nested nav">
                        <a class="nav-link" href="item.html">프로모션 대시보드</a>
                        <a class="nav-link" href="layout-sidenav-light.html">쿠폰 만들기</a>
                        <a class="nav-link" href="layout-sidenav-light.html">쿠폰 발급/조회</a>
                    </nav>
                </div>


                <a class="nav-link collapsed" href="#" data-bs-toggle="collapse" data-bs-target="#collapseBoard" aria-expanded="false" aria-controls="collapseBoard">
                    <div class="sb-nav-link-icon"><i class="fas fa-columns"></i></div>
                    게시판
                    <div class="sb-sidenav-collapse-arrow"><i class="fas fa-angle-down"></i></div>
                </a>
                <div class="collapse" id="collapseBoard" aria-labelledby="headingOne" data-bs-parent="#sidenavAccordion">
                    <nav class="sb-sidenav-menu-nested nav">
                        <a class="nav-link" href="item.html">게시판 대시보드</a>
                        <a class="nav-link" href="layout-sidenav-light.html">게시판 관리</a>
                        <a class="nav-link" href="layout-sidenav-light.html">게시물 관리</a>
                    </nav>
                </div>



                <div class="sb-sidenav-menu-heading">Addons</div>
                <!-- <a class="nav-link" href="charts.html">
                    <div class="sb-nav-link-icon"><i class="fas fa-chart-area"></i></div>
                    통계
                </a> -->


                <a class="nav-link collapsed" href="#" data-bs-toggle="collapse" data-bs-target="#collapseStatics" aria-expanded="false" aria-controls="collapseStatics">
                    <div class="sb-nav-link-icon"><i class="fas fa-book-open"></i></div>
                    통계
                    <div class="sb-sidenav-collapse-arrow"><i class="fas fa-angle-down"></i></div>
                </a>

                <div class="collapse" id="collapseStatics" aria-labelledby="headingTwo" data-bs-parent="#sidenavAccordion">
                    <nav class="sb-sidenav-menu-nested nav accordion" id="sidenavAccordionPagesStatics">
                        <a class="nav-link collapsed" href="#" data-bs-toggle="collapse" data-bs-target="" aria-expanded="false" aria-controls="">
                            통계 대시보드
                        </a>

                        <a class="nav-link collapsed" href="#" data-bs-toggle="collapse" data-bs-target="#pagesCollapseAuthSales" aria-expanded="false" aria-controls="pagesCollapseAuthSales">
                            매출 분석
                            <div class="sb-sidenav-collapse-arrow"><i class="fas fa-angle-down"></i></div>
                        </a>
                        <div class="collapse" id="pagesCollapseAuthSales" aria-labelledby="headingOne" data-bs-parent="#sidenavAccordionPagesStatics">
                            <nav class="sb-sidenav-menu-nested nav">
                                <a class="nav-link" href="login.html">일별 매출</a>
                                <a class="nav-link" href="register.html">주별 매출</a>
                                <a class="nav-link" href="password.html">월별 매출</a>
                                <a class="nav-link" href="password.html">결제 수단별 매출</a>
                                <a class="nav-link" href="password.html">매출 집계</a>
                            </nav>
                        </div>

                        <a class="nav-link collapsed" href="#" data-bs-toggle="collapse" data-bs-target="#pagesCollapseErrorItem" aria-expanded="false" aria-controls="pagesCollapseErrorItem">
                            상품 분석
                            <div class="sb-sidenav-collapse-arrow"><i class="fas fa-angle-down"></i></div>
                        </a>
                        <div class="collapse" id="pagesCollapseErrorItem" aria-labelledby="headingOne" data-bs-parent="#sidenavAccordionPagesStatics">
                            <nav class="sb-sidenav-menu-nested nav">
                                <a class="nav-link" href="401.html">판매 상품 순위</a>
                                <a class="nav-link" href="404.html">판매 분류 순위</a>
                                <a class="nav-link" href="404.html">취소/반품 순위</a>
                                <a class="nav-link" href="404.html">장바구니 상품 분석</a>
                                <a class="nav-link" href="404.html">장바구니 상세 내역</a>
                                <a class="nav-link" href="404.html">관심 상품 분석</a>
                            </nav>
                        </div>

                        <a class="nav-link collapsed" href="#" data-bs-toggle="collapse" data-bs-target="#pagesCollapseErrorCust" aria-expanded="false" aria-controls="pagesCollapseErrorCust">
                            고객 분석
                            <div class="sb-sidenav-collapse-arrow"><i class="fas fa-angle-down"></i></div>
                        </a>
                        <div class="collapse" id="pagesCollapseErrorCust" aria-labelledby="headingOne" data-bs-parent="#sidenavAccordionPagesStatics">
                            <nav class="sb-sidenav-menu-nested nav">
                                <a class="nav-link" href="401.html">요일별 분석</a>
                                <a class="nav-link" href="404.html">시간별 분석</a>
                                <a class="nav-link" href="404.html">배송 지역별 분석</a>
                            </nav>
                        </div>
                    </nav>
                </div>






                <a class="nav-link" href="#">
                    <div class="sb-nav-link-icon"><i class="fas fa-chart-area"></i></div>
                    설정
                </a>
            </div>
        </div>
        <div class="sb-sidenav-footer">
            <div class="small">Logged in as:</div>
            BYEZ
        </div>
    </nav>
</div>