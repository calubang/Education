<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="my" uri="http://kitri.com/my"%>
<%@taglib prefix="tf" tagdir="/WEB-INF/tags"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<hr>
<my:welcome></my:welcome>
<hr>
<tf:now/>
<hr>
<tf:pageGroup end="10" url="boardList" current="3" start="1"/>
<hr>
</body>
</html>