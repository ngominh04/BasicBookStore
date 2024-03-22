<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<jsp:include page="_headerAdmin.jsp"></jsp:include>
	<jsp:include page="_menuAdmin.jsp"></jsp:include>
	<div align="center">
		<c:if test="${not empty book }">
				<div align="center">
		<h3>CHI TIẾT HÓA ĐƠN</h3>
		<table border="1">
			<tr>
				<th align="left">Họ tên:</th>
				<td>${order.fullname }</td>
			</tr>
			<tr>
				<th align="left">Số di động</th>
				<td>${order.mobile }</td>
			</tr>
			<tr>
				<th align="left">Mã hóa đơn</th>
				<td>${order.orderNo }</td>
			</tr>
			<tr>
				<th align="left">Ngày đặt mua</th>
				<td><fmt:formatDate value="${order.orderDate }"
						pattern="dd-MM-yyyy HH:mm" /></td>
			</tr>
			<tr>
				<th align="left">Địa chỉ nhận sách</th>
				<td>${order.deliveryAddress }</td>
			</tr>
			<tr>
				<th align="left">Phương thức thanh toán:</th>
				<td>
					${order.paymentMode}
				</td>
			</tr>
		</table>
	</div>

	<div align="center">
		<h3>Các cuốn sách trong hóa đơn</h3>
		<table border="1">
			<tr>
				<th>Tiêu đề</th>
				<th>Tác giả</th>
				<th>Giá tiền</th>
				<th>Số lượng mua</th>
				
			</tr>
			<c:forEach items="${book }" var="entry">
				<tr>
					<td>${entry.title }</td>
					<td>${entry.author }</td>
					<td><fmt:formatNumber type="number" maxFractionDigits="0"
							value="${entry.price }" /><sup>đ</sup></td>
					<td>${entry.orderQuantity }</td>
					
				</tr>

			</c:forEach>
		</table>
		
		<br>
		Tổng số tiền:
		<b>
			<span id="total">
				<fmt:formatNumber type="number" maxFractionDigits="0"
							value="${order.totalCost }" />
			</span>
			<sup>đ</sup>
		</b>
	</div>
				<c:if test="${order.orderStatus ==1}">
					<a href="confirmOrder1?orderNo=${order.orderNo}">Xác Nhận đơn</a>
				</c:if>
				<c:if test="${order.orderStatus ==2}">
					<a href="confirmOrder2?orderNo=${order.orderNo}">Xác nhận đã giao</a>
				</c:if>
				
				<a href="adminHome">Tiếp tục xem tiếp</a>				
		
		</c:if>
	</div>
</body>
</html>