<%@page import="com.kitri.dto.Customer"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%-- <% 
//1. request의 속성(이름:"c", 타입:com.kitri.dto.Customer )얻기
Customer customer = (Customer)request.getAttribute("customer");

//2. 1속성이 null 인 경우
//    Customer 객체 생성하여 customer 변수에 대입
//    customer 변수를 request의 속성(이름: customer)로 추가
if(customer == null){
	customer = new Customer();
	request.setAttribute("customer", customer);
}
%> --%>
<jsp:useBean id="customer" class="com.kitri.dto.Customer" scope=""></jsp:useBean>
<%-- <%
customer.setId("id1");
%> --%>
<jsp:setProperty property="id" name="customer" value="id1"/>
<%-- 
customer.setName(request.getParameter("n"));
--%>
<jsp:setProperty property="name" param="n" name="customer"/>
<%--
customer.getId()
 --%>
<jsp:getProperty property="id" name="customer"/>
</body>
</html>