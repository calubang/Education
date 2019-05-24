<%@page import="java.util.Collections"%>
<%@page import="java.util.Iterator"%>
<%@page import="java.util.Collection"%>
<%@page import="java.util.Set"%>
<%@page import="com.kitri.dto.Product"%>
<%@page import="java.util.Map"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="dataCart" value="${requestScope.dataCart}"></c:set>
<c:set var="session" value="${pageContext.request.session}"></c:set>
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
			<c:choose>
			<c:when test="${empty dataCart}">
			<tr align="center"><td colspan="8">장바구니가 비었습니다.</td></tr>
			</c:when>
			<c:otherwise>
			<c:forEach var="mapitem" items="${dataCart}">
			<tr>
				<td><img src="/myjstl/img/productimg/${mapitem.key.prod_no}.jpg"/></td>
				<td>${mapitem.key.productCategory.cate_no}</td>
				<td>${mapitem.key.productCategory.cate_name}</td>
				<td>${mapitem.key.prod_no}</td>
				<td>${mapitem.key.prod_name}</td>
				<td>${mapitem.key.prod_price}</td>
				<td>${mapitem.key.prod_detail}</td>
				<td>${mapitem.value}</td>
			</tr>
			</c:forEach>
			</c:otherwise>
			</c:choose>
		</tbody>
		<tfoot>
			<tr>
				<td colspan="8" align="center">
					<button class="btn btn-info" >장바구니 비우기</button>
					<c:if test="${!empty sessionScope.loginInfo}">
					<button class="btn btn-info" >주문하기</button>
					</c:if>
				</td>
			</tr>
		</tfoot>
	</table>
</div>