<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<%@ include file="template/default_link.jsp" %>
<style type="text/css">
#sidebar{
	position: fixed;
	height: 100%;
}
</style>
<script type="text/javascript">
$(document).ready(function() {
	var sidebarWidth = $("#sidebar").width();
	var marginLeftSideBar = $("#sidebar").css("margin-left");
	$("#contents").css("margin-left", parseInt(sidebarWidth) + parseInt(marginLeftSideBar));
});
window.onresize = function() {
	var sidebarWidth = $("#sidebar").width();
	var marginLeftSideBar = $("#sidebar").css("margin-left");
	$("#contents").css("margin-left", parseInt(sidebarWidth) + parseInt(marginLeftSideBar));
}
</script>
</head>
<body>
<!-- navbar-->	
	<!-- 
	<header class="header">
		<nav class="navbar navbar-expand-lg px-4 py-2 bg-white shadow">
			
			<ul class="ml-auto d-flex align-items-center list-unstyled mb-0">
				<li class="nav-item">
					<form id="searchForm" class="ml-auto d-none d-lg-block">
						<div class="form-group position-relative mb-0">
							<button type="submit" style="top: -3px; left: 0;"
								class="position-absolute bg-white border-0 p-0">
								<i class="o-search-magnify-1 text-gray text-lg"></i>
							</button>
							<input type="search" placeholder="Search ..."
								class="form-control form-control-sm border-0 no-shadow pl-4">
						</div>
					</form>
				</li>
				
			</ul>
		</nav>
	</header>
	-->
	<div class="d-flex align-items-stretch">
		<!-- 사이드 sidebar -->
		<%@ include file="template/sidebar.jsp" %>
		<!-- 사이드 sidebar -->
		<div class="page-holder w-100 d-flex flex-wrap" id="contents">
			<div class="container-fluid">
				
				<!-- section 1 -->
				<section class="py-5" id="mainSection">
					<div class="w-100">
						<h1 class="text-main">댕댕이를 <span class="text-primary">부탁해~</span></h1>
						<div class="subheading">
							kitri 2nd Project 4조
						</div>
						<div class="login-icons">
							<button class="btn btn-primary">로그인</button>
							<button class="btn btn-primary">회원가입</button>
						</div>
					</div>
				</section>
				
				<!-- section 2 -->
				<section>
					<div class="row mb-4">
						<div class="col-lg-7 mb-4 mb-lg-0">
							<div class="card">
								<div class="card-header">
									<h2 class="h6 text-uppercase mb-0">Current server uptime</h2>
								</div>
								<div class="card-body">
									<p class="text-gray">Lorem ipsum dolor sit amet,
										consectetur adipisicing elit.</p>
									<div class="chart-holder">
										<canvas id="lineChart1" style="max-height: 14rem !important;"
											class="w-100"></canvas>
									</div>
								</div>
							</div>
						</div>
						<div class="col-lg-5 mb-4 mb-lg-0 pl-lg-0">
							<div class="card mb-3">
								<div class="card-body">
									<div class="row align-items-center flex-row">
										<div class="col-lg-5">
											<h2 class="mb-0 d-flex align-items-center">
												<span>86.4</span><span
													class="dot bg-green d-inline-block ml-3"></span>
											</h2>
											<span class="text-muted text-uppercase small">Work
												hours</span>
											<hr>
											<small class="text-muted">Lorem ipsum dolor sit</small>
										</div>
										<div class="col-lg-7">
											<canvas id="pieChartHome1"></canvas>
										</div>
									</div>
								</div>
							</div>
							<div class="card">
								<div class="card-body">
									<div class="row align-items-center flex-row">
										<div class="col-lg-5">
											<h2 class="mb-0 d-flex align-items-center">
												<span>1.724</span><span
													class="dot bg-violet d-inline-block ml-3"></span>
											</h2>
											<span class="text-muted text-uppercase small">Server
												time</span>
											<hr>
											<small class="text-muted">Lorem ipsum dolor sit</small>
										</div>
										<div class="col-lg-7">
											<canvas id="pieChartHome2"></canvas>
										</div>
									</div>
								</div>
							</div>
						</div>
					</div>
					<div class="row">
						<div class="col-lg-5 mb-4 mb-lg-0">
							<div class="card mb-3">
								<div class="card-body">
									<div class="row align-items-center mb-3 flex-row">
										<div class="col-lg-5">
											<h2 class="mb-0 d-flex align-items-center">
												<span>86%</span><span
													class="dot bg-violet d-inline-block ml-3"></span>
											</h2>
											<span class="text-muted text-uppercase small">Monthly
												Usage</span>
											<hr>
											<small class="text-muted">Lorem ipsum dolor sit</small>
										</div>
										<div class="col-lg-7">
											<canvas id="pieChartHome3"></canvas>
										</div>
									</div>
								</div>
							</div>
							<div class="card">
								<div class="card-body">
									<div class="row align-items-center flex-row">
										<div class="col-lg-5">
											<h2 class="mb-0 d-flex align-items-center">
												<span>$126,41</span><span
													class="dot bg-green d-inline-block ml-3"></span>
											</h2>
											<span class="text-muted text-uppercase small">All
												Income</span>
											<hr>
											<small class="text-muted">Lorem ipsum dolor sit</small>
										</div>
										<div class="col-lg-7">
											<canvas id="pieChartHome4"></canvas>
										</div>
									</div>
								</div>
							</div>
						</div>
						<div class="col-lg-7">
							<div class="card">
								<div class="card-header">
									<h2 class="h6 text-uppercase mb-0">Total Overdue</h2>
								</div>
								<div class="card-body">
									<p class="text-gray">Lorem ipsum dolor sit amet,
										consectetur adipisicing elit.</p>
									<div class="chart-holder">
										<canvas id="lineChart2" style="max-height: 14rem !important;"
											class="w-100"></canvas>
									</div>
								</div>
							</div>
						</div>
					</div>
				</section>
			</div>
			<%@ include file="template/footer.jsp" %>
		</div>
	</div>
	<%@ include file="template/default_js_link.jsp" %>
</body>
</html>