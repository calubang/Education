<%@page import="java.util.Collections"%>
<%@page import="java.util.Iterator"%>
<%@page import="java.util.Collection"%>
<%@page import="java.util.Set"%>
<%@page import="com.kitri.dto.Product"%>
<%@page import="java.util.Map"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
Map<Product, Integer> dataCart = (Map)request.getAttribute("dataCart");
session = request.getSession();
%>
<script>
$(function() {
	var buttons = $(".orderlist button");
	//$(".orderlist button")[0].click(cartAllRemove);
	$(buttons[1]).click(order);
});

function order() {
	alert("버튼눌림");
	$.ajax({
		url : "addorder"
		, method : "get"
		, success : function(result) {
			if(result.trim() != "1"){
				//주문실패
				alert(result.trim());
			}else{
				alert("주문성공");
			}
		}
	});
}
</script>
<<style>
.orderlist img{
	width: 100px;
	height: 100px;
	border-radius: 5%;
}
.orderlist td{
	vertical-align: middle;
}
</style>
<div class="orderlist">
	<table class="table table-hover">
		<thead>
			<tr>
				<td>상품이미지</td>
				<td>상품 카테고리 코드</td>
				<td>상품 카테고리명</td>
				<td>상품코드</td>
				<td>상품명</td>
				<td>상품가격</td>
				<td>상품정보</td>
				<td>수량</td>
			</tr>
		</thead>
		<tbody>
			<% 
			if(dataCart == null){
				%><tr align="center"><td colspan="8">장바구니가 비었습니다.</td></tr><%
			} else{
				Set<Product> keys = dataCart.keySet();
				//Collections.sort(keys.);
				for(Product product : keys){
				%>
				<tr>
					<td><img src="/jquerymvc/img/productimg/<%=product.getProd_no()%>.jpg"/></td>
					<td><%=product.getProductCategory().getCate_no()%></td>
					<td><%=product.getProductCategory().getCate_name()%></td>
					<td><%=product.getProd_no()%></td>
					<td><%=product.getProd_name()%></td>
					<td><%=product.getProd_price()%></td>
					<td><%=product.getProd_detail()%></td>
					<td><%=dataCart.get(product)%></td>
				</tr>
				<%
				}
			}
			%>
		</tbody>
		<tfoot>
			<tr>
				<td colspan="8" align="center">
					<button class="btn btn-info" >장바구니 비우기</button>
				<%if(session.getAttribute("loginInfo") != null){%>
					<button class="btn btn-info" >주문하기</button>
				<%}%>
				</td>
			</tr>
		</tfoot>
	</table>
</div>