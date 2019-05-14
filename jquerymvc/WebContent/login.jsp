<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="javax.servlet.http.Cookie"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Semantic HTML</title>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.2.1/css/bootstrap.min.css">
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.6/umd/popper.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.2.1/js/bootstrap.min.js"></script>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.0/jquery.min.js"></script>
<%
String root = request.getContextPath();
%>
<%
String saveId = "";
String ckId = "";
Cookie cookies[] = request.getCookies();
if(cookies != null){
	for(Cookie cookie : cookies){
		if("kid_inf".equals(cookie.getName())){
			saveId = cookie.getValue();
			ckId =  "checked";
			break;
		}
	}
}
%>
<script type="text/javascript">
$(document).ready(function() {
	$.ajax(function() {
		url : "<%=root%>/login"
		, data : $("#loginform").serialize()
		, method : "post"
		, success : function(result) {
			alert(result);
		}
		, error : function (jqXHR, textStatus, errorThrown) {
			alert(errorThrown);
		}
	});
});

</script>
</head>
<body>
<div class="container" align="center">
	<div class="col-lg-6" align="center">
		<h2>로그인</h2>
		<form id="loginform" method="post" action="">
			<input type="hidden" name="act" value="login">
			<div class="form-group" align="right">
				<label for="">
				<input type="checkbox" class="form-control" name="idsave" value="idsave" placeholder="" <%=ckId%>>아이디</label>
			</div>
			<div class="form-group" align="left">
				<label for="">아이디</label>
				<input type="text" class="form-control" id="id" name="id" placeholder="" value="<%=saveId%>">
			</div>
			<div class="form-group" align="left">
				<label for="">비밀번호</label>
				<input type="password" class="form-control" id="pass" name="pass" placeholder="">
			</div>
			<div class="form-group" align="center">
				<button type="button" class="btn btn-warning" id="loginBtn">로그인</button>
				<button type="button" class="btn btn-primary" id="moveRegisterBtn">회원가입</button>
			</div>
		</form>
	</div>
</div>
</body>
</html>