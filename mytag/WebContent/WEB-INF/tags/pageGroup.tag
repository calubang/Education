<%@ tag language="java" pageEncoding="UTF-8" body-content="empty"%>
<%@ attribute name="current" required="true" type="java.lang.Integer"%>
<%@ attribute name="start" required="true" type="java.lang.Integer"%>
<%@ attribute name="end" required="true" type="java.lang.Integer"%>
<%@ attribute name="url" required="true"%>
<%
for(int i = start; i<=end ; i++){
	//current 와 i가 동일하면 a 속성을 주지 않는다
	if(i==current){
	%>
	<span><%=i%></span>
<%
	}else{%>
	<a href="<%=url%>?page=<%=i%>"><%=i%></a><%	
	}
}%>