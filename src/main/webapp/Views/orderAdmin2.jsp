<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<jsp:include page="_headerAdmin.jsp"></jsp:include>
	<jsp:include page="_menuAdmin.jsp"></jsp:include>
	<div align="center">
		<h3>Danh sách các đơn hàng đang giao</h3>
		<p style="color: red">${errors }</p>
		
		<table border="1px">
			<tr>
				<th>Mã hóa đơn</th>
				<th>Tên khách</th>
				<th>Số điện thoại</th>
				<th>Giá Tiền</th>
				<th>Ngày đặt</th>
				<th colspan="3" width="120px">Thao tác</th>
			</tr>
			<c:forEach items="${bookList}" var="book">
				<tr>
					<td>${book.orderNo}</td>
					<td>${book.fullname}</td>
					<td>${book.mobile} </td>
					<td><fmt:formatNumber type="number" maxFractionDigits="0" value="${book.totalCost}"/><sup>đ</sup></td>
					<td><fmt:formatDate value="${book.orderDate}" pattern="dd-MM-yyyy HH:mm"/> </td>
					
					<td align="center">
						<a href="detailBookAdmin2?orderNo=${book.orderNo }&orderStatus=2">Xem chi tiết</a>
					</td>
				</tr>
			</c:forEach>
		</table>
		<br>
		
	</div>
</body>
</html>