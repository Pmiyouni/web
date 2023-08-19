<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<div class="row my-5">
	<div class="col">
		<h1 class="text-center mb-5">교수정보수정</h1>
		<!--$.ajax대신 사용, controller의 getpost로 -->
		<form name="frm1" method="post" action="/pro/update">
		
			<div class="input-group mb-2">
				<span class="input-group-text">교수번호</span> 
				<input name="pcode" class="form-control" value="${vo.pcode}">
			</div>
			<div class="input-group mb-2">
				<span class="input-group-text">교수이름</span> <input name="pname"
					class="form-control" value="${vo.pname}">
			</div>
			<div class="input-group mb-2">
				<span class="input-group-text">교수학과</span> 
				<select name="dept" class="form-select">
				<!--  태그안에 조건문, 반복문등을 사용할 수 없으므로 태그라이브러리를 통해 출력 -->
					<option value="전산" <c:out value="${vo.dept=='전산' ? 'selected':''}"/>>전자계산학과</option>
					<option value="컴정" <c:out value="${vo.dept=='컴정' ? 'selected':''}"/>>컴퓨터정보공학과</option>
					<option value="전자" <c:out value="${vo.dept=='전자' ? 'selected':''}"/>>전자공학과</option>
					<option value="건축" <c:out value="${vo.dept=='건축' ? 'selected':''}"/>>건축공학과</option>
				</select>
			</div>
			<div class="input-group mb-2 pt-2">
				<span class="input-group-text">교수직급</span>&nbsp;&nbsp; 
				<input type="radio" name="title" value="정교수" <c:out value="${vo.title=='정교수' ? 'checked':''}"/>> 
				<span class="p-2">정교수</span>&nbsp;&nbsp;
				<input type="radio" name="title" value="부교수" <c:out value="${vo.title=='부교수' ? 'checked':''}"/>> 
				<span class="p-2">부교수</span>&nbsp;&nbsp; 
				<input type="radio" name="title" value="조교수" <c:out value="${vo.title=='조교수' ? 'checked':''}"/>> 
				<span class="p-2">조교수</span>
			</div>
			<div class="input-group mb-2">
				<span class="input-group-text">교수급여</span> 
				<input name="salary" class="form-control" value="${vo.salary}">
			</div>
			<div class="input-group mb-2">
				<span class="input-group-text">임용일자</span> 
				<input name="hiredate" value="${vo.hiredate}" class="form-control" type="date">
			</div>
			<div class="text-center mt-5">
				<input type="submit" value="정보수정" class="btn btn-primary"> <input
					type="reset" value="수정취소" class="btn btn-secondary">
			</div>
		</form>
	</div>
</div>
<script>
	$(frm1).on("submit", function(e){
		e.preventDefault();
		if(confirm("교수 정보를 수정하실래요?")){
			frm1.submit();
		}
	})
	 $(frm1).on("reset", function(){
		location.href="/pro/list";
	}); 
</script>