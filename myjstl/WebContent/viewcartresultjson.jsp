<%@page import="org.json.JSONArray"%>
<%@page import="org.json.JSONObject"%>
<%@page import="java.util.HashMap"%>
<%@page import="java.util.Set"%>
<%@page import="com.fasterxml.jackson.databind.ObjectMapper"%>
<%@page import="com.kitri.dto.Product"%>
<%@page import="java.util.Map"%>
<%@ page language="java" contentType="application/json; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
//1. Map을 다 풀어헤침
// Product , Integer
// 1. product : 제이슨 객체
// 2. Quantity : 제이슨객체
// 3. ㅅ로운 제이슨 추가
// { {}, {} }
Map<Product, Integer> dataCart = (Map)request.getAttribute("dataCart");
ObjectMapper mapper = new ObjectMapper();
JSONArray jsonArray = new JSONArray();
for(Map.Entry<Product, Integer> entry : dataCart.entrySet()){
	JSONObject json = new JSONObject();
	JSONObject productJson = new JSONObject(mapper.writeValueAsString(entry.getKey()));
	json.put("product", productJson);
	json.put("quantity", entry.getValue());
	jsonArray.put(json);
}
%><%=jsonArray.toString()%>
