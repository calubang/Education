<%@page import="oracle.net.aso.p"%>
<%@page import="com.kitri.dto.Product"%>
<%@page import="javax.sound.midi.MidiDevice.Info"%>
<%@page import="com.kitri.dto.OrderLine"%>
<%@page import="java.util.Date"%>
<%@page import="com.kitri.dto.OrderInfo"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<style>
.vieworder>table{
	text-align: center;
}
.vieworder>table>thead{
	background-color: aliceblue;
}
.vieworder>table td{
	vertical-align: middle;
}
.vieworder img{
	width: 50px;
	height: 50px;
	border-radius: 10%
}
</style>
<div class="vieworder">
	<table class="table">
		<thead>
			<tr>
				<td>주문번호</td>
				<td>주문일자</td>
				<td>주문상품번호</td>
				<td>상품명</td>
				<td>상품이미지</td>
				<td>가격</td>
				<td>주문수량</td>
			</tr>
		</thead>
		<tbody>
<%
List<OrderInfo> orderList = (List)request.getAttribute("orderlist");
for(OrderInfo info : orderList){
%>
<% 
	int orderNo = info.getOrder_no();
	Date orderDt = info.getOrder_dt();
	List<OrderLine> lines = info.getLines();

	for(int i=0 ; i<lines.size() ; i++){
		%><tr><% 
		OrderLine line = lines.get(i);
		if(i==0){
			%><td rowspan="<%=lines.size()%>"><%=orderNo%></td>
			<td rowspan="<%=lines.size()%>"><%=orderDt%></td><%
		}
		Product product = line.getProduct();
		String prodNo = product.getProd_no();
		String prodName = product.getProd_name();
		int prodPrice = product.getProd_price();
		int orderQuantity = line.getOrder_quantity();
%><td><%=prodNo%></td>
<td><%=prodName%></td>
<td><img src="/jquerymvc/img/productimg/<%=prodNo%>.jpg" /></td>
<td><%=prodPrice%></td>
<td><%=orderQuantity%></td></tr><%
	} // end line
} //end info
%></tbody></table></div>