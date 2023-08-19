<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <!-- 상품등록 include  -->
    <jsp:include page="insert.jsp"/>
   
<div class="row my-5 justify-content-center">
	<div class="col-8">
		<h1 class="text-center mb-5">상품목록</h1>
		
		<!--검색 버튼 영역  -->
		<div class="row">
		<form class="col-6" name="frm">
			<div class="input-group">
				<input class="form-control" placeholder="검색어" name="query">
				<!--<input> 태그의 placeholder 속성은 입력 필드에 사용자가 적절한 값을 입력할 수 있도록 도와주는 짧은 도움말을 명시  -->
				<button class="btn btn-primary">검색</button>
				<span id="total" class="ms-3">20건</span>
			</div>
		</form>
		</div>
	
	<!-- 출력 영역 -->
	<div id="div_product"></div>
	<!--페이징 버튼 영역  -->
	<div class="text-center mt-3" id="btn-group">
		<button class="btn btn-primary" id="prev">이전</button>
		<span class="mx-3" id="page">1/100</span>
		<button class="btn btn-primary" id="next">다음</button>
	</div> 
	
  </div>
</div>

<!-- 상품목록 템플릿 -->
<script id="temp_product" type="text/x-handlebars-template">
	<table class="table">
		{{#each items}}
		<tr>
			<td class="code">{{code}}</td>
			<td><input value="{{name}}" class="name"</td>
			<td><input value="{{price}}" class="price" size=10 > ..{{fprice}}원</td>
         	<td>{{fdate}}</td>	
	
			<td><button class="btn btn-danger btn-sm" code="{{code}}">삭제</button></td>
			<td><button class="btn btn-warning btn-sm">수정</button></td>	
		</tr>
		{{/each}}
 	</table>
</script>

<script>
let page=1;
let query="";
getList();

$("#div_product").on("click", ".btn-warning",function(){
	let row=$(this).parent().parent();
	let code=row.find(".code").text();
	/* text()는 xml과 html 둘다사용,  <tag>_____</tag>에서 _____에 해당하는 value를 get한다 */
	/*  html()는  HTML만 가능. value가 아니라 html code(contents)자체를 get한다 */
	
	let name=row.find(".name").val();
	let price=row.find(".price").val();
	/*form이나 input은 val()로 값을 받아오는데 사용  */
	if(confirm(code+":"+name+":"+price+"수정하실래요?")){
		$.ajax({
			type:"post",
			url:"/pro/update",
			data:{"code":code,"name":name,"price":price},
			success:function(){
				alert("수정이 완료되었습니다");
				getList();
				}
			});
	 	}else{
			alert("수정이 취소되었습니다");
	 		getList();
		}			
	});

$("#div_product").on("click", ".btn-danger", function(){
	let code=$(this).attr("code");
	if(confirm(code+"번 상품을 삭제하실래요?")){
	$.ajax({
		type:"post",
		url:"/pro/delete",
		data:{"code":code},
		success:function(){
			alert("삭제가 완료되었습니다");
			getList();
		}
	});
	}else{
		alert("삭제가 취소되었습니다")
	}
});

$(frm).on("submit",function(e){
	e.preventDefault();
	page=1;
	query=$(frm.query).val();
	getList();
});

$("#prev").on("click",function(){
	page--;
	getList();
});
$("#next").on("click", function(){
	page++;
	getList();
});
	
function getList(){
	$.ajax({
		type:"get",
		data:{"page":page, "query":query},
		url:"/pro/list.json",
		dataType:"json",
		success: function(data){
			console.log(data);
			const temp=Handlebars.compile($("#temp_product").html());
			//핸들바 템플릿의 내용을 가져와서 템플릿을 컴파일
			const html=temp(data);
			//리턴한 함수의 파라미터에 바인딩할 데이터를 넣음
			$("#div_product").html(html);
			//html 템플릿을 출력영역에 추가(dom 추가)
			//바인딩이란 프로그램에서 사용된 구성 요소의 실제값 또는 속성을 결정짓는 행위
			//DOM(Document Object Model) – HTML 요소들의 구조화된 표현으로 다영한 프로그램에 사용
			
			const last=Math.ceil(data.total/5);
			$("#page").html(page+"/"+last);
			
			if(page==1) $("#prev").attr("disabled",true);
			else $("#prev").attr("disabled",false);
			
			if(page==last) $("#next").attr("disabled",true);
			else $("#next").attr("disabled",false);
			
			$("#total").html(data.total+"건");
			
			if(data.total==0) $("#btn-group").hide();
			else $("#btn-group").show();	
			}
	});
}
</script>