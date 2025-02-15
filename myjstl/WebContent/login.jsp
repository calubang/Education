<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
String root = request.getContextPath();
%>
<script type="text/javascript">
$(document).ready(function() {
	$("#loginBtn").click(function() {
		login();
		return false;
	});
	
	$("moveRegisterBtn").click(function() {
		var $aTags = $("nav>ul>li>a[href='user/member.jsp']").trigger("click");
	});
});

function login(){
	$.ajax({
		url : "<%=root%>/login"
		, data : $("#loginform").serialize()
		, method : "post"
		, success : function(result) {
			$("#loginBtn").css("background-image", "none");
			if(result == 1){
				location.href = "index.jsp";
			} else{
				alert("로그인 실패");
			}
		}
		, beforeSend : function(){
			$("#loginBtn").css("background-image", "url('<%=root%>/img/loading.gif')");
			$("#loginBtn").css("background-repeat", "no-repeat");
			$("#loginBtn").css("background-size", "cover");
			$("#loginBtn").css("background-position", "center");
		}
		, error : function (jqXHR, textStatus, errorThrown) {
			alert(errorThrown.trim());
		}
	});
}
</script>
<div class="container" align="center">
	<div class="col-lg-6" align="center">
		<h2>로그인</h2>
		<form id="loginform" method="post" action="">
			<input type="hidden" name="act" value="login">
			<div class="form-group" align="right">
				<label for="">
				<input type="checkbox" class="form-control" name="idsave" value="idsave" placeholder="" >아이디</label>
			</div>
			<div class="form-group" align="left">
				<label for="">아이디</label>
				<input type="text" class="form-control" id="id" name="id" placeholder="" >
			</div>
			<div class="form-group" align="left">
				<label for="">비밀번호</label>
				<input type="password" class="form-control" id="pass" name="pass" placeholder="">
			</div>
		</form>
		<div class="form-group" align="center">
			<button type="button" class="btn btn-warning" id="loginBtn">로그인</button>
			<button type="button" class="btn btn-primary" id="moveRegisterBtn">회원가입</button>
		</div>
	</div>
</div>