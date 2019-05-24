<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.util.Date"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
첫번째 JSP 입니다.
<%
	int i; //scriptlet : _jspService()내부에 작성될 구문
	i = 99;
%>

<%//expression :  out.print() 자동호출 %>
i=<%=i%>

<%//declaration : _jspService()외부에 작성될 구문  %>
<%!int i;%>
<hr>
i=<%=i%>,  this.i=<%=this.i%>
<hr>
<ul>
	<li>page directive : 속성-contentType, import, errorPage, isErrorPage, buffer
	<% 
		Date dt = new Date();
		String pattern = "yyyy-MM-dd";
		SimpleDateFormat sdf = new SimpleDateFormat(pattern);
	%><%=sdf.format(dt)%>
	</li>
	<li>include directive : 정적포함(.java파일에 포함), 속성-file</li>
	<li>taglib directive</li>
</ul>
<hr>
<h3>ACTION TAG</h3>
<ul>
	<li>STANDARD Action Tag</li>
		<ol>
			<li>jsp:include : 동적포함, 속성-page </li>
			<li>jsp:forward</li>
			<li>jsp:param</li>
			<li>jsp:useBean</li>
			<li>jsp:setProperty</li>
			<li>jsp:getProperty</li>
		</ol>
	<li>CUSTOM Action Tag</li>
</ul>
</body>
</html>