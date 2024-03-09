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
	<div style="background-color: #E0E0E0;height: 75px;padding: 1rem">
		<div style="float: left;">
			<h2>Website cửa hàng bán sách với JSP/SERVLLET</h2>
		</div>
		<div style="float: right;;text-align: right;">
		
		<c:if test="${empty loginedUser }">
			<a href="${pageContext.request.contextPath }/login">Đăng nhập</a>
		</c:if>
		
			<c:if test="${not empty loginedUser }">
				Xin chào <b>${loginedUser.fullname }</b>
				|
				<a href="${pageContext.request.contextPath }/accountInfo">Thông tin tài khoản/dơn hàng</a>
				|
				<a href="${pageContext.request.contextPath }/logout">Đăng xuất</a>
			</c:if>
			<c:if test="${not empty cartOfCustomer }">
				<a href="${pageContext.request.contextPath }/cartBook/viewCart">giỏ hàng</a>
			</c:if>
			<br>
			Tìm sách :<input name="search" onchange="activeAsLink('${pageContext.request.contextPath }/clientHome?keyword=' +this.value);">
		</div>
	</div>
	<script type="text/javascript" src="${pageContext.request.contextPath }/js/bookStore_script.js"></script>
</body>
</html>