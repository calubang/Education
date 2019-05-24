<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<script>
$(function(){
	var btns = $("div.addcartbtngroup>button");
	$(btns[0]).click(function() {
		$("#addcartModal").modal("hide");
		return false;
	});
	$(btns[1]).click(function() {
		$("#addcartModal").modal("hide");
		$("nav>ul>li>.viewcart").trigger("click");
		return false;
	});
	
});
</script>
<div align="center" class="addcartbtngroup">
<p style="text-align: center">장바구니에 넣었습니다.</p>
<button class="btn btn-info">상품목록으로 가기</button>
<button class="btn btn-info">장바구니보기</button>
</div>