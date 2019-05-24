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
작업구분
<hr>
<%=request.getParameter("opt")%>작업을 선택했습니다.<br>
${param.opt} 작업을 선택했습니다.
<hr>
<%=Integer.parseInt(request.getParameter("a"))+10%><br>
${param.a+10}
<hr>
<% 
Customer customer = new Customer();
customer.setId("id1");
customer.setName("name1");
customer.setPass("pass1");
request.setAttribute("customer", customer);
%>
고객이름 : <%=((Customer)request.getAttribute("customer")).getName()%><br>
${requestScope.customer.name}
</body>
</html>