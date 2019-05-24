<%@page import="oracle.net.aso.p"%>
<%@page import="com.kitri.dto.Product"%>
<%@page import="javax.sound.midi.MidiDevice.Info"%>
<%@page import="com.kitri.dto.OrderLine"%>
<%@page import="java.util.Date"%>
<%@page import="com.kitri.dto.OrderInfo"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
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
		<c:set var="orderList" value="${requestScope.orderlist}"></c:set>
		<c:forEach var="info" items="${orderList}">
			<c:set var="orderNo" value="${info.order_no}"></c:set>
			<c:set var="orderDt" value="${info.order_dt}"></c:set>
			<c:set var="lines" value="${info.lines}"></c:set>
			<c:set var="linesSize" value="${fn:length(lines)}"></c:set>
			<c:forEach var="line" items="${lines}" varStatus="stat">
				<tr>
					<c:if test="${stat.index == 0}">
					<td rowspan="${linesSize}">${orderNo}</td>
					<td rowspan="${linesSize}">${orderDt}</td>
					</c:if>
					<td>${line.product.prod_no}</td>
					<td>${line.product.prod_name}</td>
					<td><img src="/myjstl/img/productimg/${line.product.prod_no}.jpg" /></td>
					<td>${line.product.prod_price}</td>
					<td>${line.order_quantity}</td>
				</tr>
			</c:forEach>
		</c:forEach>
		</tbody>
	</table>
</div>