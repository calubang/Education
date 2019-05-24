<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<!--
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.0/jquery.min.js"></script>
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"></script>
</head> -->
<style>
input[type=number] {
	width: 30%;
	margin: auto;
}

.orderdiv>input, orderdiv>button {
	display: inline;
}
</style>
<script type="text/javascript">
	$(function() {
		$("#btnAll").click(findAll);
		//$("#productInfoModal .btn-primary").click();
		$("#productInfoModal .btn-success").click(addcart);
		/* 	$('#productInfoModal').focusin(function() {
		 $('#productInfoModal').modal();
		 }); */
	});

	function findAll() {
		//alert("클릭");
		$.ajax({
			url : "productlist",
			data : {
				act : "productAll"
			},
			success : function(result) {
				//alet("");
				$("#result").html(result);
				$("#btnAll").css("background-image", "none");
				var products = $(".product");
				$.each(products, productClick);
			},
			beforeSend : function() {
				$("#btnAll").css("background-image", "url('img/loading.gif')");
				$("#btnAll").css("background-repeat", "no-repeat");
				$("#btnAll").css("background-size", "cover");
				$("#btnAll").css("background-position", "center");
			}
		});
	}

	function productClick(index, product) {
		$(product).click(function() {
			var prodNo = $(this).find("span[class=prodno]").text();
			//alert(productId);
			productDetail(prodNo);
		});
	}

	function productDetail(prodNo) {
		$.ajax({
			url : "productInfo",
			data : {
				prodNo : prodNo
			},
			success : function(result) {
				var name = $(result).find("span[class=prodname]").text();

				//alert($(result).find("p>span").text());

				$("#productInfoModal .modal-title").html(name);
				$("#productInfoModal input[type=number]").val(1);
				$("#productInfoModal").modal('show');
				$("#productContent").html(result);
			}
		});
	}
	function addcart() {
		//alert("장바구니에 담았습니다.");
		var quantity = $("#productInfoModal input[type=number]").val();
		var prodno = $("#productInfoModal .prodno").text();

		//alert(quantity + "//" + prodno);
		//$("#productInfoModal input[type=hidden]").val(prodno);

		$.ajax({
			url : "addcart",
			method : "get",
			data : {
				prodno : prodno,
				quantity : quantity
			},
			success : function(result) {
				//alert(result);
				$("#addcartModal .modal-body").html(result);
				//$("#addcartModal").modal({backdrop: "static"});
				$("#productInfoModal").modal("hide");
				$("#addcartModal").modal("show");
			}
		});

		

		return false;
	}
</script>
<div>
	<button class="btn btn-primary" id="btnAll">상품 모두 보여주기</button>
</div>
<div id="result"></div>

<div id="productInfoModal" class="modal fade" role="dialog">
	<div class="modal-dialog modal-lg">
		<div class="modal-content">
			<div class="modal-header text-center">
				<h5 class="modal-title" style="margin-left: auto;"></h5>
				<button type="button" class="close" data-dismiss="modal"
					aria-label="Close">
					<span aria-hidden="true">×</span>
				</button>
			</div>
			<div class="modal-body text-center">
				<div align="center">
					<label id="productNameLabel"></label>
				</div>
				<div id="productContent"></div>
				<div class="orderdiv">
					<input type="number" name="quantity" class="form-control"
						width="30%" min="0" value="0" max="999">
					<button class="btn btn-success">장바구니 담기</button>
					<button class="btn btn-warning" data-dismiss="modal"
						aria-label="Close">취소</button>
				</div>
			</div>
		</div>
	</div>
</div>

<!-- 장바구니 추가시 뜨는 모달 -->
<div class="modal" id="addcartModal" role="dialog">
	<div class="modal-dialog" style="margin-top: 10%;">
		<!-- Modal content-->
		<div class="modal-content">
			<div class="modal-header">
				<h4 class="modal-title" style="margin-left: auto">장바구니 추가완료</h4>
				<button type="button" class="close" data-dismiss="modal">&times;</button>
			</div>
			<div class="modal-body"></div>
			<div class="modal-footer">
				<button type="button" class="btn btn-success" data-dismiss="modal">확인</button>
			</div>
		</div>

	</div>
</div>