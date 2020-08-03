<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="utf-8" />
<meta http-equiv="X-UA-Compatible" content="IE=edge" />
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no" />
<meta name="description" content="" />
<meta name="author" content="" />

<link href="/MoneySalad-WEB/dist/css/styles.css" rel="stylesheet" />
<link
	href="https://cdn.datatables.net/1.10.20/css/dataTables.bootstrap4.min.css"
	rel="stylesheet" crossorigin="anonymous" />

<script
	src="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.13.0/js/all.min.js"
	crossorigin="anonymous"></script>
</head>
<body>
	<div id="layoutSidenav">
		<div id="layoutSidenav_nav">
			<nav class="sb-sidenav accordion sb-sidenav-dark"
				id="sidenavAccordion">
				<div class="sb-sidenav-menu">
					<div class="nav">
						<div class="sb-sidenav-menu-heading">Core</div>
						<a class="nav-link" href="<%=request.getContextPath()%>">
							<div class="sb-nav-link-icon">
								<i class="fas fa-tachometer-alt"></i>
							</div> 전계좌조회
						</a>
						<div class="sb-sidenav-menu-heading">Interface</div>
						<a class="nav-link collapsed" href="#" data-toggle="collapse"
							data-target="#collapseLayouts" aria-expanded="false"
							aria-controls="collapseLayouts">
							<div class="sb-nav-link-icon">
								<i class="fas fa-columns"></i>
							</div> Layouts
							<div class="sb-sidenav-collapse-arrow">
								<i class="fas fa-angle-down"></i>
							</div>
						</a>
						<div class="collapse" id="collapseLayouts"
							aria-labelledby="headingOne" data-parent="#sidenavAccordion">
							<nav class="sb-sidenav-menu-nested nav">
								<a class="nav-link" href="layout-static.html">Static
									Navigation</a> <a class="nav-link" href="layout-sidenav-light.html">Light
									Sidenav</a>
							</nav>
						</div>
						<a class="nav-link collapsed" href="#" data-toggle="collapse"
							data-target="#collapsePages" aria-expanded="false"
							aria-controls="collapsePages">
							<div class="sb-nav-link-icon">
								<i class="fas fa-book-open"></i>
							</div> Pages
							<div class="sb-sidenav-collapse-arrow">
								<i class="fas fa-angle-down"></i>
							</div>
						</a>
						<div class="collapse" id="collapsePages"
							aria-labelledby="headingTwo" data-parent="#sidenavAccordion">
							<nav class="sb-sidenav-menu-nested nav accordion"
								id="sidenavAccordionPages">
								<a class="nav-link collapsed" href="#" data-toggle="collapse"
									data-target="#pagesCollapseAuth" aria-expanded="false"
									aria-controls="pagesCollapseAuth"> Authentication
									<div class="sb-sidenav-collapse-arrow">
										<i class="fas fa-angle-down"></i>
									</div>
								</a>
								<div class="collapse" id="pagesCollapseAuth"
									aria-labelledby="headingOne"
									data-parent="#sidenavAccordionPages">
									<nav class="sb-sidenav-menu-nested nav">
										<a class="nav-link" href="login.html">Login</a> <a
											class="nav-link" href="register.html">Register</a> <a
											class="nav-link" href="password.html">Forgot Password</a>
									</nav>
								</div>
								<a class="nav-link collapsed" href="#" data-toggle="collapse"
									data-target="#pagesCollapseError" aria-expanded="false"
									aria-controls="pagesCollapseError"> Error
									<div class="sb-sidenav-collapse-arrow">
										<i class="fas fa-angle-down"></i>
									</div>
								</a>
								<div class="collapse" id="pagesCollapseError"
									aria-labelledby="headingOne"
									data-parent="#sidenavAccordionPages">
									<nav class="sb-sidenav-menu-nested nav">
										<a class="nav-link" href="401.html">401 Page</a> <a
											class="nav-link" href="404.html">404 Page</a> <a
											class="nav-link" href="500.html">500 Page</a>
									</nav>
								</div>
							</nav>
						</div>
						<div class="sb-sidenav-menu-heading">Addons</div>
						<a class="nav-link" href="charts.html">
							<div class="sb-nav-link-icon">
								<i class="fas fa-chart-area"></i>
							</div> Charts
						</a> <a class="nav-link" href="tables.html">
							<div class="sb-nav-link-icon">
								<i class="fas fa-table"></i>
							</div> Tables
						</a>
					</div>
				</div>
				<div class="sb-sidenav-footer">
					<div class="small">Logged in as:</div>
					${userVO.name } &nbsp;&nbsp;&nbsp;<a
						href="<%=request.getContextPath()%>/logoutProcess.do">로그아웃</a><br>
				</div>
			</nav>
		</div>
		<!--             ---======================================================== -->
		<!-- 		<div id="layoutSidenav_content"> -->
		<!-- 			<main> -->
		<!-- 				<div class="container-fluid"> -->
		<!-- 					<h1 class="mt-4">Static Navigation</h1> -->
		<!-- 					<ol class="breadcrumb mb-4"> -->
		<!-- 						<li class="breadcrumb-item"><a href="index.html">Dashboard</a></li> -->
		<!-- 						<li class="breadcrumb-item active">Static Navigation</li> -->
		<!-- 					</ol> -->
		<!-- 					<div class="card mb-4"> -->
		<!-- 						<div class="card-body"> -->
		<!-- 							<p class="mb-0"> -->
		<!-- 								This page is an example of using static navigation. By removing -->
		<!-- 								the -->
		<%-- 								<code>.sb-nav-fixed</code> --%>
		<!-- 								class from the -->
		<%-- 								<code>body</code> --%>
		<!-- 								, the top navigation and side navigation will become static on -->
		<!-- 								scroll. Scroll down this page to see an example. -->
		<!-- 							</p> -->
		<!-- 						</div> -->
		<!-- 					</div> -->
		<!-- 					<div style="height: 100vh;"></div> -->
		<!-- 					<div class="card mb-4"> -->
		<!-- 						<div class="card-body">When scrolling, the navigation stays -->
		<!-- 							at the top of the page. This is the end of the static navigation -->
		<!-- 							demo.</div> -->
		<!-- 					</div> -->
		<!-- 				</div> -->
		<!-- 			</main> -->
		<!-- 			<footer class="py-4 bg-light mt-auto"> -->
		<!-- 				<div class="container-fluid"> -->
		<!-- 					<div -->
		<!-- 						class="d-flex align-items-center justify-content-between small"> -->
		<!-- 						<div class="text-muted">Copyright &copy; Your Website 2020</div> -->
		<!-- 						<div> -->
		<!-- 							<a href="#">Privacy Policy</a> &middot; <a href="#">Terms -->
		<!-- 								&amp; Conditions</a> -->
		<!-- 						</div> -->
		<!-- 					</div> -->
		<!-- 				</div> -->
		<!-- 			</footer> -->
		<!-- 		</div> -->
		<!--             ---======================================================== -->


	</div>
	<script src="https://code.jquery.com/jquery-3.5.1.min.js"
		crossorigin="anonymous"></script>
	<script
		src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/js/bootstrap.bundle.min.js"
		crossorigin="anonymous"></script>
	<script src="/MoneySalad/dist/js/scripts.js"></script>
	<script
		src="https://cdnjs.cloudflare.com/ajax/libs/Chart.js/2.8.0/Chart.min.js"
		crossorigin="anonymous"></script>
	<script src="/MoneySalad-WEB/dist/assets/demo/chart-area-demo.js"></script>
	<script src="/MoneySalad-WEB/dist/assets/demo/chart-bar-demo.js"></script>
	<script
		src="https://cdn.datatables.net/1.10.20/js/jquery.dataTables.min.js"
		crossorigin="anonymous"></script>
	<script
		src="https://cdn.datatables.net/1.10.20/js/dataTables.bootstrap4.min.js"
		crossorigin="anonymous"></script>
	<script src="/MoneySalad-WEB/dist/assets/demo/datatables-demo.js"></script>
</body>
</html>



<!-- <h2>입출금내역</h2> -->
<%-- <c:forEach items="${transactionList }" var="transaction"> --%>
<%-- 	거래일자: ${transaction.transactionDate }<br> --%>
<%-- 	본인계좌: ${transaction.accountNumber }<br> --%>
<%-- 	상대계좌: ${transaction.counterAccountNumber }<br> --%>
<%-- 	거래유형: ${transaction.transactionType }<br> --%>
<%-- 	거래금액: ${transaction.transactionAmount }<br> --%>
<!-- 	<hr> -->
<%-- </c:forEach> --%>


