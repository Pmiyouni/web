<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!-- Modal -->
<div class="modal fade" id="modal{{@index}}" data-bs-backdrop="static" data-bs-keyboard="false" tabindex="-1" aria-labelledby="staticBackdropLabel" aria-hidden="true">
  <div class="modal-dialog modal-lg">
    <div class="modal-content">
      <div class="modal-header">
        <h1 class="modal-title fs-5" id="staticBackdropLabel">도서정보</h1>
        <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
      </div>
      <div class="modal-body">
        <div class="row">
			<div class="col-4 card p-3 me-3">
				<img src="{{printImage thumbnail}}">
			</div>
			<div class="col card p-3 me-3">
				<h5>제목: {{title}}</h5>
				<h5>가격: {{fmtPrice price}}</h5>
				<h5>출판사: {{publisher}}</h5>
				<h5>저자: {{authors}}</h5>
				<h5><a href="{{url}}">사이트이동</a></h5>
			</div>
		</div>
		<hr>
		<div>
			<p class="card p-3">{{contents}}</p>
		</div>
      </div>
      <div class="modal-footer">
        <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">Close</button>
      </div>
    </div>
  </div>
</div>