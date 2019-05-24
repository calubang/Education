<%@page import="com.kitri.dto.Product"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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
<div id="productList"><%
	List<Product> productList = (List)request.getAttribute("productList");
	if(productList == null || productList.size() == 0){
%>보여줄 목록이 없습니다.<%} else{
		for(Product product : productList){
			%>
<div class="product">
	<img src="img/productimg/<%=product.getProd_no()%>.jpg" alt="<%=product.getProd_name()%>">
	<p>카테고리 : <%=product.getProductCategory().getCate_name()%></p>
	<p>상품번호 : <span class="prodno"><%=product.getProd_no()%></span></p>
	<p>상품명 : <%=product.getProd_name()%></p>
	<p>가격 : <%=product.getProd_price()%></p>
</div>
			<%
		}
	}%>
</div>