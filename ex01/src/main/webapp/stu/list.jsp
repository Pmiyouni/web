<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>  
 <%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>  

<div class="row">
<div class="col">
	<h1 class="text-center">학생 목록</h1>
	<table  class="table table-striped my-5">
		<c:forEach items="${array}" var="vo">
	<tr>
	<td> ${vo.scode}</td>
	<td> ${vo.sname}</td>
	<td> ${vo.addr}</td>
	<td> ${vo.phone}</td>
	<td> ${vo.birth}</td>
	</tr>
	</c:forEach>
	</table>
	</div>
</div>



