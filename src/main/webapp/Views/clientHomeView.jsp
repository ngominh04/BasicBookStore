<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Trang chủ phía máy khách</title>
</head>
<body>
	<jsp:include page="_header.jsp"></jsp:include>
	<jsp:include page="_menu.jsp"></jsp:include>
	
	<div align="center">
		<h3>Danh sách các cuốn sách</h3>
		<c:if test="${keyword != null}">
			Bạn đang tìm kiếm theo từ khóa : <span>${keyword }</span>
		</c:if>
		<br>
		<table border="1">
			<tr>
				<th>Tiêu đề</th>
				<th>Tác giả</th>
				<th>Giá tiền</th>
				<th>Số lượng</th>
				<th>Thao tác</th>
				
			</tr>
			<c:forEach items="${bookList}" var="book">
				<tr>
					<td>${book.title}</td>
					<td>${book.author}</td>
					<td><fmt:formatNumber value="${book.price}" maxFractionDigits="0" type="number"/> <sup>đ</sup></td>
					<td>${book.quantityInStock }</td>
					<td><a href="detailBook?bookId=${book.bookId }">Xem chi tiết</a></td>
				</tr>
			</c:forEach>
		</table>
		
		<c:if test="${empty keyword }">
			<div style="margin-top: 5px">
				<c:if test="${currentPage gt 1 }">
					<a href="clientHome?page=${curentPage-1 }">Previous</a>
				</c:if>
				<c:forEach	begin="1" end="${noOfPages }" var="i">
					<c:choose>
						<c:when test="${curentPage eq i }">
							&nbsp;${i}&nbsp;
						</c:when>
						<c:otherwise>
							&nbsp;<a href="clientHome?page=${i }">${i }</a>&nbsp;
						</c:otherwise>
					</c:choose>
				</c:forEach>
				
				<c:if test="${curentPage lt noOfPages }">
					&nbsp;<a href="clientHome?page=${curentPage + 1 }">Next</a>
				</c:if>
			</div>
		</c:if>
		
		<c:if test="${not empty keyword }">
			<div style="margin-top: 5px">
				<c:if test="${currentPage gt 1 }">
					<a href="clientHome?page=${curentPage-1 }">Previous</a>
				</c:if>
				<c:forEach	begin="1" end="${noOfPages }" var="i">
					<c:choose>
						<c:when test="${curentPage eq i }">
							&nbsp;${i}&nbsp;
						</c:when>
						<c:otherwise>
							&nbsp;<a href="clientHome?page=${i }&keyword=${keyword}">${i }</a>&nbsp;
						</c:otherwise>
					</c:choose>
				</c:forEach>
				
				<c:if test="${curentPage lt noOfPages }">
					&nbsp;<a href="clientHome?page=${curentPage + 1 }$&keyword=${keyword}">Next</a>
				</c:if>
			</div>
		</c:if>
	</div>
</body>
</html>