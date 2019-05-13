<%@page import="com.kitri.member.model.MemberDto"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="com.kitri.member.model.MemberDto, com.kitri.util.MoveUrl"%>
<%@ include file="/template/header.jsp" %>
<%
MemberDto memberDto = (MemberDto)session.getAttribute("userInfo");
if(memberDto != null){
%>
<script type="text/javascript">
function deleteMember() {
	if(confirm("탈퇴 하시겠습니까?")){
		document.location.href = "<%=root%>/user?act=deletemember";
	}
}
</script>
<font size='15' color='green'><%=memberDto.getName()%>님, 환영합니다.</font>
<br><a href="<%=root%>/user?act=logout">로그아웃</a>
<br><a href="<%=root%>/user?act=mvmodify">정보수정</a>
<br><a href="#" onclick="javascript:deleteMember();">회원탈퇴</a>
<% 
if("calubang".equals(memberDto.getId())){
%>	
<br><a href="<%=root%>/admin?act=memberlist">관리자</a>
<% 
}
%>
<%
} else {
	MoveUrl.redirect(request, response, "/user?act=login");
}
%>
<%@ include file="/template/footer.jsp" %>