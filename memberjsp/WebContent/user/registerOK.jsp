<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/template/header.jsp" %>
<% 
String name = request.getParameter("name");
%>
<%=name%>님 회원가입을 환영합니다.<br>
로그인 후 모든 서비스를 이용할 수 있습니다.<br>
<a href='<%=root%>/user/login.jsp'>로그인</a>		
<%@ include file="/template/footer.jsp" %>