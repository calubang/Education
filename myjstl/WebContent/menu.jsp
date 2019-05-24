<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="id" value="${sessionScope.loginInfo}"></c:set>
<ul>
	<li><a href="index.jsp" role="home">홈으로</a></li>
	<c:choose>
	<c:when test="${empty id}">
		<li><a href="login.jsp">로그인</a></li>
		<li><a href="member.jsp">가입</a></li>
	</c:when>
	<c:otherwise>
		<li><a href="login?act=logout" role="logout">로그아웃</a></li>
	</c:otherwise>
	</c:choose>
	<li><a href="productlist.jsp">제품보기</a></li>
	<li><a href="viewcart" class="viewcart">장바구니 목록보기</a></li>
	<c:choose>
	<c:when test="${!empty id}">
		<li><a href="vieworder" >주문 목록보기</a></li>
	</c:when>
	</c:choose>
	<li><a href="write.jsp" >글쓰기</a></li>
	<li><a href="boardlist" role="pagemove">글 목록보기</a></li>	
	<li><a href="/myjstl/upload/upload.html" >파일업로드</a></li>	
	<li><a href="/myjstl/upload/uploadresult.jsp" >파일다운로드</a></li>	
</ul>