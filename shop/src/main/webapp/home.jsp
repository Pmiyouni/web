<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>쇼핑몰 프로그램</title>
	<!-- jquery를 상단에 둘것 -->
	<script src="http://code.jquery.com/jquery-1.9.1.js"></script>
	<!-- 핸들바 임포트 -->
	<script src="https://cdnjs.cloudflare.com/ajax/libs/handlebars.js/3.0.1/handlebars.js"></script>
	<!-- 부트스트랩 CSS only -->
	<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-rbsA2VBKQhggwzxH7pPCaAqO46MgnOM80zW1RWuH61DGLwZJEdK2Kadq2F9CUG65" crossorigin="anonymous">
	<!-- 부트스트랩 JavaScript Bundle with Popper -->
	<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-kenU1KFdBIe4zVF0s0G1M5b4hcpxyD9F7jL+jjXkk+Q2h455rYXK/7HAuoJl+0I4" crossorigin="anonymous"></script>
	<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.10.3/font/bootstrap-icons.css">
	<!--카카오개발자센터  내애플리케이션 자바스크랩키 (지도 사용)-->
	<script type="text/javascript" src="//dapi.kakao.com/v2/maps/sdk.js?appkey=ac83cffda10b59ae6466ef081acf80fe"></script>
	<!-- twbs-pagination -->
	<script type="text/javascript" src="https://cdnjs.cloudflare.com/ajax/libs/twbs-pagination/1.4.2/jquery.twbsPagination.min.js"></script>
	<!--스타일시트  -->
	<link rel="stylesheet" href="/css/style.css"/>
	<!-- 다음 주소 찾기 -->
	<script src="https://t1.daumcdn.net/mapjsapi/bundle/postcode/prod/postcode.v2.js"></script>
</head>
<body>
	<div class="container">
		<div class="row">
			<div class="col">
				<jsp:include page="header.jsp"/>
				<jsp:include page="${pageName}"/>
				<jsp:include page="footer.jsp"/>
			</div>
		</div>
	</div>
</body>
</html>