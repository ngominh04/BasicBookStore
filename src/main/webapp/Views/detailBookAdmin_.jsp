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
		<h3>Thông tin cuốn sách</h3>
		<table style="width: 30%" border="1">
					<tr>
						<td width="25%">Tiêu đề</td>
						<td>${book.title }</td>
					</tr>
					<tr>
						<td>Tác giả</td>
						<td>${book.author }</td>
					</tr>
					<tr>
						<td>Giá tiền</td>
						<td><fmt:formatNumber value="${book.price }" maxFractionDigits="0" type="number"/> <sup>đ</sup></td>
					</tr>
					<tr>
						<td colspan="2">
							<div style="text-align: justify;text-justify: inter-word;margin: 5px">
								<img alt="Book Image" src="${book.imagePath }" style="float: left;margin-right: 5px" width="150px">
								${book.detail }
							</div>
						</td>
					</tr>
				</table>
				<a href="adminHome">Tiếp tục xem tiếp</a>
	</div>
</body>
</html>