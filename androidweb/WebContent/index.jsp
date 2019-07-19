<%@page import="com.fasterxml.jackson.databind.ObjectMapper"%>
<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.kitri.dto.Product" %>
<%@ page language="java" contentType="application/json; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="method" value="${pageContext.request.method}"></c:set>
<c:set var="opt" value="${param.opt}"></c:set>
<c:if test="${empty opt}">
	<c:set var="opt" value="default"></c:set>
</c:if>
<%-- {
"method" : "${method}"
, "status" : 1
, "msg" : "Welcom to Android World!!"
, "opt" : "${opt}"
} --%>
<%--[
{"prod_no" : "001"
	, "prod_name" : "아메리카노"
	, "prod_price" : 2500}
,{"prod_no" : "002"
	, "prod_name" : "카페라떼"
	, "prod_price" : 2500}
,{"prod_no" : "003"
	, "prod_name" : "카페모카"
	, "prod_price" : 2500}
] --%>
<%
List<Product> list = new ArrayList<>();
Product p1 = new Product();
p1.setProd_no("001");
p1.setProd_name("아메리카노우");
p1.setProd_price(2500);
p1.setProd_detail("가성비 좋은 아메리카노");

Product p2 = new Product();
p2.setProd_no("002");
p2.setProd_name("카페라떼");
p2.setProd_price(3000);
p2.setProd_detail("몸에 좋은 카페라떼");

Product p3 = new Product();
p3.setProd_no("003");
p3.setProd_name("카페베네");
p3.setProd_price(3000);
p3.setProd_detail("커즈 욘 마이 걸");

Product p4 = new Product();
p4.setProd_no("004");
p4.setProd_name("밀크티");
p4.setProd_price(1500);
p4.setProd_detail("흑당 밀크티");

list.add(p1);
list.add(p2);
list.add(p3);
list.add(p4);

ObjectMapper mapper = new ObjectMapper();
String data = mapper.writeValueAsString(list);
%>
<%=data%>
