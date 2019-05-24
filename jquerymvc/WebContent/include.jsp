<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>include.jsp</title>
</head>
<body>
<h3>포함지시자</h3>
<%@include file="loginResult.jsp" %>
<hr>
<h3>포함태그</h3>
<jsp:include page="loginResult.jsp"/>
</body>
</html>