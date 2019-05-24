<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<script>
$(function(){
	$("div.boardwrite>form").submit(function(){
		$.ajax({
			url:'writeboard',
			method:'post',
			data:$(this).serialize(),
			success:function(result){
				result = result.trim();
				if(result == 1){
					alert("글쓰기 성공");
				}else{
					alert("글쓰기 실패");
				}
			}
		});
		return false;
	});
});
</script>
<div class="boardwrite" style="width: 30rem; margin: auto;">
  <h4>글쓰기</h4>
  <form autocomplete="off">
    <label>제목</label><input name="subject" class="form-control"><br>
    <c:set var="id" value=""></c:set>
    <c:if test="${!empty sessionScope.loginInfo}">
    	<c:set var="id" value="${sessionScope.loginInfo}"></c:set>
    </c:if>
    <label>작성자</label><input name="writer" class="form-control" value="${id}"><br>
    <label>비밀번호</label><input type="password" name="password" class="form-control"><br>
    <label>내용</label>
    <textarea name="contents" class="form-control" rows="10"></textarea>
    <button class="btn btn-info">글쓰기</button>
  </form>
</div>