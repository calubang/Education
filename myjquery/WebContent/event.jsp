<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.0/jquery.min.js"></script>
<script type="text/javascript">
$(document).ready(function() {
	var $aTagAll = $("div > a");
	//console.log($aTagAll);
	
	$aTagAll.click(function(e) {
		$(this).css("background-color", "yellow");
		//jQuery 에서 return false 는 기본이벤트도 막고 이벤트 전파도 막는 기능을 가지고 있다.
		return false;
		//event.preventDefault();
		//event.stopPropagation();
	});
	
	$("div").click(divClickEventJQ);
});

function divClickEventJQ(e){
	$(this).css("background-color", "gray");
}

/* window.addEventListener("load", function(e) {
	//DOM트리에서 div > a 객체 찾기
	var a = document.querySelector("div > a");
	//aObj 객체에서 클릭이벤트가 발생했을 때 처리할 핸들러 작성
	// 할일 : "클릭되었습니다" 메시지 alert
	//       : 배경색을 yellow 로 변경
	a.addEventListener("click", aClickEvent, false);
	
	var div = document.querySelector("div");
	div.addEventListener("click", divClickEvent, false);
	
}, false); */

function divClickEvent() {
	this.style.backgroundColor = "gray";
}

function aClickEvent(event) {
	alert("클릭되었습니다.");
	this.style.backgroundColor = "yellow";
	event.preventDefault();
	event.stopPropagation();
}


</script>
</head>
<body>
<div>
	<h3>DIV3</h3>
	<a href="http://www.google.com">구글</a>
</div>
</body>
</html>