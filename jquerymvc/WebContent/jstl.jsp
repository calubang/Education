<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<c:set var="num" value="${param.num}"/>
<c:if test="${num%2==0}">
짝수입니다.<br>
</c:if>
<hr>
<c:choose>
	<c:when test="${num%2==0}">짝수입니다.</c:when>
	<c:otherwise>홀수입니다.</c:otherwise>
</c:choose>
<hr>
<c:forEach begin="1" end="10" step="1" var="i">${i} </c:forEach>
<hr>
<c:set var="total" value="0"></c:set>
<c:forEach begin="1" end="10" var="i">
	<c:set var="total" value="${total+i}"></c:set>
</c:forEach>
1~10 합 : ${total}
<hr>
<%
List<String> list = new ArrayList<String>();
list.add("one");
list.add("two");
list.add("three");
list.add("four");
request.setAttribute("list", list);
%>

<c:forEach var="e" items="${requestScope.list}" varStatus="obj">${obj.index} : ${e}<br></c:forEach>

</body>
</html>