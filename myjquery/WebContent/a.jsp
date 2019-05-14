<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
request.setCharacterEncoding("utf-8");
String id = request.getParameter("id");
String name = new String(request.getParameter("name").getBytes(), "utf-8");
%>
<%
Thread.sleep(2 * 1000);
%>
<%=id%>(<%=name%>)님 반갑습니다.