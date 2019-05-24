<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Semantic HTML</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.0/jquery.min.js"></script>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.2.1/css/bootstrap.min.css">
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.6/umd/popper.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.2.1/js/bootstrap.min.js"></script>
<link rel="stylesheet" href="css/default.css">
<script type="text/javascript">
$(function() {
	//dom트리에서 nav>ul>li>a 객체를 찾기
	var $aTags = $("nav>ul>li>a");
	$aTags.click(function(e, args) {
		var vurl = $(this).attr("href");
		if($(this).attr("role") == "logout"){
			$.ajax({
				url : vurl
				, method : "get"
				, success : function(result) {
					//응답 받았을 때
					//alert(result);
					location.href = "index.jsp";
				}
			});
		} else if($(this).attr("role") == "home"){
			location.href = "index.jsp";
		} else if($(this).attr("role") == "pagemove"){
			$.ajax({
				url : vurl
				, method : "get"
				, data : {
					currentpage : args
				}
				, success : function(result) {
					//응답 받았을 때
					$("section").html(result);
				}
			});
		}else{
			$.ajax({
				url : vurl
				, method : "get"
				, success : function(result) {
					//응답 받았을 때
					$("section").html(result);
				}
			});
		}	
		return false;
	});
});
</script>
</head>
<body>
<header>
<h1>HEADER My Web</h1>
</header>
<nav>
<jsp:include page="menu.jsp"></jsp:include>
</nav>
<section>본문</section>
<footer>사업자 : KITRI(주) | 대표 : 안병욱</footer>
</body>
</html>