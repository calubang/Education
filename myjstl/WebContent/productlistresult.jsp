<%@page import="com.kitri.dto.Product"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<style>
body{
	box-sizing: border-box;
}
#productList div{
	float: left;
	margin: 10px;
	border: 1px solid #868e96;
	cursor: pointer;
	border-radius: 5%;
	padding: 1%
}
#productList div:hover{
	border: 2px solid #868e96;
	margin: 9px;
}
img{
	border-radius: 10%;
}
#productList div img{
	width: 200px;
	height: 200px;
	display: block;
}
</style>
<div id="productList">
<c:set var="productList" value="${requestScope.productList}"></c:set>
<c:choose>
	<c:when test="${!empty productList}">
		<c:forEach var="product" items="${productList}">
			<div class="product">
				<img src="img/productimg/${product.prod_no}.jpg" alt="${product.prod_name}">
				<p>카테고리 : ${product.productCategory.cate_name}</p>
				<p>상품번호 : <span class="prodno">${product.prod_no}</span></p>
				<p>상품명 : ${product.prod_name}</p>
				<p>가격 : ${product.prod_price}</p>				
			</div>
		</c:forEach>
	</c:when>
	<c:otherwise>
	 상품이 없습니다.	
	</c:otherwise>
</c:choose>
</div>