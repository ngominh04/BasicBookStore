<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<div style="padding: 5px;" align="center">
		<a href="${pageContext.request.contextPath }/adminHome">Trang chủ</a> | 
		<a href="${pageContext.request.contextPath }/OrderAdmin1">Các dơn hàng chưa xác nhận</a> | 
		<a href="${pageContext.request.contextPath }/OrderAdmin2">Các đơn hàng đang chờ giao hàng</a> | 
		<a href="${pageContext.request.contextPath }/OrderAdmin3">các đơn hàng đã giao hàng</a> | 
		<a href="${pageContext.request.contextPath }/OrderAdmin5">Các đơn hàng đã trả hàng</a>
	</div>

</body>
</html>