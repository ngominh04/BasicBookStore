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
<div style="padding: 5px;" align="center">
	<c:if test="${empty loginedUser }">
		<a href="${pageContext.request.contextPath }/clientHome">Trang chủ</a>
		
	</c:if>	
	<c:if test="${not empty loginedUser }">
		<c:if test="${loginedUser.role == 0 }">
			<a href="${pageContext.request.contextPath }/clientHome">Trang chủ</a>
		</c:if>
		<c:if test="${loginedUser.role != 0 }">
			<a href="${pageContext.request.contextPath }/admninHome">Trang chủ</a>
		</c:if>
	</c:if>	
	|
	<a href="">Sách phổ biến</a>
	|
	<a href="">Sách bán chạy</a>
	|
	<a href="">Sách mới</a>
	|
	<a href="">Giá thấp đến cao</a>
	|
	<a href="">Giá cao đến thấp</a>
</div>
</body>
</html>