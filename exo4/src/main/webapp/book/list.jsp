<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<div class="row my-5">
	<div class="col">
		<h1 class="text-center">도서목록</h1>
		<div class="row">
			<div class="col">				
					<span id="total" class="ms-3"> 전체 20건</span>
				</div>
			</div>
	
		<hr/>
		<div id="div_book1"></div>
		<div class="text-center mt-3" id="btn-group">
			<button class="btn btn-primary" id="prev1">이전</button>
			<span class="mx-3" id="page">1/10</span>
			<button class="btn btn-primary" id="next1">다음</button>
		</div>	
</div>
</div>

<!-- 도서목록 템플릿 -->
<script id="temp_book1" type="text/x-handlebars-template">
	<table class="table">
		{{#each items}}
		<tr>			
			<td class="seq">{{seq}}</td>
			<td><input value="{{title}}" class="title"></td>			
			<td><img src="{{thumbnail}}" class="thumbnail"/></td>
			<td><input value="{{price}}" class="price" size=7></td>            
			<td><input value="{{contents}}" class="contents" size=30></td>			
			<td><input value="{{publisher}}" class="publisher"></td>			
		</tr>
		{{/each}}
	</table>
</script>

<script>
let page=1;
getList1();

$("#next1").on("click", function(){
	page++;
	getList1();
});

$("#prev1").on("click", function(){
	page--;
	getList1();
});

function getList1(){
	$.ajax({
		type:"get",
		url:"/book/list.json", 
		dataType:"json",
		data:{"page": page},
		success:function(data){
			console.log(data);
			const temp=Handlebars.compile($("#temp_book1").html());
			const html=temp(data);
			$("#div_book1").html(html);
			
			const last1=Math.ceil(data.count/5);
			$("#page").html(page + "/" + last1);
			
			if(page==1) $("#prev1").attr("disabled", true)
			else $("#prev1").attr("disabled", false)
			
			if(page==last1) $("#next1").attr("disabled", true)
			else $("#next1").attr("disabled", false);
			
			$("#total").html(data.count + "건");
			
			if(data.count==0) $("#btn-group").hide();
			else $("#btn-group").show();
		}
	});
}
</script>