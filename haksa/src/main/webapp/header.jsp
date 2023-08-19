<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
 
<div class="row">
	<div class="col">
		<img src="/image/header.jpg" width="100%" height=300px id="img_header">
		<!--네비게이션 바(부트스트랩)  -->
		<nav class="navbar navbar-expand-lg navbar-dark bg-primary">
		<!-- navbar-dark bg-primary를 추가 -->
			<div class="container-fluid">
				<a class="navbar-brand" href="/">학사관리</a>
				<button class="navbar-toggler" type="button"
					data-bs-toggle="collapse" data-bs-target="#navbarSupportedContent"
					aria-controls="navbarSupportedContent" aria-expanded="false"
					aria-label="Toggle navigation">
					<span class="navbar-toggler-icon"></span>
				</button>
				<div class="collapse navbar-collapse" id="navbarSupportedContent">
					<ul class="navbar-nav me-auto mb-2 mb-lg-0">			
						
						<li class="nav-item">
							<a class="nav-link active" aria-current="page" href="/pro/list">교수관리</a>
						</li>
						<li class="nav-item">
							<a class="nav-link active" aria-current="page" href="/stu/list">학생관리</a>
						</li>
						<li class="nav-item">
							<a class="nav-link active" aria-current="page" href="/cou/list">강좌관리</a>
						</li>
					</ul>
				</div>
			</div>
		</nav>
	</div>
</div>