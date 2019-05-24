<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
	<ul>
		<li><a href="index.jsp" role="home">홈으로</a></li>
		<%
		String id = (String)session.getAttribute("loginInfo");
		if(id == null){
		%>
		<li><a href="login.jsp">로그인</a></li>
		<li><a href="member.jsp">가입</a></li>
		<%} else{%>
		<li><a href="login?act=logout" role="logout">로그아웃</a></li>
		<%}%>
		<li><a href="productlist.jsp">제품보기</a></li>
		<li><a href="viewcart" class="viewcart">장바구니 목록보기</a></li>
		<%if(id != null){
		%><li><a href="vieworder" >주문 목록보기</a></li><%
		}%>
	</ul>