<%@page import="java.io.File"%>
<%@page import="java.io.FileInputStream"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page errorPage="err.jsp" %>
<%@page buffer="100kb" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%
for(int i=1 ; i<=10000; i++){
%>
<%=i%>
<%}%>
<%
//a.txt 파일을 byte단위로 읽기위한 스트림객체 생성
FileInputStream in = null;
in = new FileInputStream("a.txt");
%>
</body>
</html>