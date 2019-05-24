<%@page import="com.kitri.dto.Product"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<style>
.productInfo img{
 	height : 500px;
	display: block;
	margin-left: auto;
	margin-right: auto;	
}
</style>
<%
Product product = (Product)request.getAttribute("product");
if(product == null){
	//데이터 없음
%>info 정보 없음<%
} else{
%>
<div class="productInfo">
<img src="img/productimg/<%=product.getProd_no()%>.jpg">
<p>카테고리 : <%=product.getProductCategory().getCate_name()%></p>
<p>상품번호 : <span class="prodno"><%=product.getProd_no()%></span></p>
<p>상품명 : <span class="prodname"><%=product.getProd_name()%></span></p>
<p>가격 : <%=product.getProd_price()%></p>
</div>
<%
}
%>
