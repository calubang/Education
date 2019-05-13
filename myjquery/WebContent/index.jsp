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
		var pTagAll = $("p"); 
		pTagAll.click(pTagClickEvent);
	});

	/* window.addEventListener("load", function() {
		var pTagAll = document.querySelectorAll("p");
		for(var i=0 ; i<pTagAll.length ; i++){
			var pTag = pTagAll[i];
			pTag.addEventListener("click", pTagClickEvent, false);
		}
	}, false); */
	
	function pTagClickEvent() {
		//this.style.display = "none";
		$(this).hide();
	}
</script>
</head>
<body>
<p>If you click on me, I will disappear.</p>
<p>Click me away!</p>
<p>Click me too!</p>

</body>
</html>