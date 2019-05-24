<%@page import="com.kitri.dto.Product"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<style>
.productInfo img{
 	height : 500px;
	display: block;
	margin-left: auto;
	margin-right: auto;	
}
</style>
<c:set var="product" value="${requestScope.product}"></c:set>
<c:choose>
	<c:when test="${empty product}">info 정보 없음</c:when>
	<c:otherwise>
		<div class="productInfo">
		<img src="img/productimg/${product.prod_no}.jpg">
		<p>카테고리 : ${product.productCategory.cate_name}</p>
		<p>상품번호 : <span class="prodno">${product.prod_no}</span></p>
		<p>상품명 : <span class="prodname">${product.prod_name}</span></p>
		<p>가격 : <fmt:formatNumber value="${product.prod_price}" type="currency"></fmt:formatNumber></p>
		</div>
	</c:otherwise>
</c:choose>