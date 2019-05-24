<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%!
int peopleNum = 0;
int totalScore = 0;
%>
<%
peopleNum++;
int score = Integer.parseInt(request.getParameter("score"));
totalScore += score;
%>
<label>참여자수 : </label><%=peopleNum%> 명<br>
<label>총 별점 : </label><%=totalScore%> 점<br>
<label>평균 별점 : </label><%=totalScore/peopleNum%> 점<br>