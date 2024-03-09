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
		<h3>Danh sách các cuốn sách</h3>
		<p style="color: red">${errors }</p>
		
		<div style="margin-bottom: 10px">
			<form action="adminHome" method="post">
				<b>Lọc theo ngày bán: </b>Từ ngày &nbsp;
				<input type="date" value="${fromDate }" required="required" name="fromDate" >&nbsp;&nbsp;
				Tới &nbsp;<input type="date" value="${toDate }" required="required" name="toDate">&nbsp;
				<input type="submit" value="Lọc">&nbsp;&nbsp;&nbsp;
				<b>Doanh thu:&nbsp;</b><fmt:formatNumber type="number" maxFractionDigits="0" value="${turnover }"/><sup>đ</sup>
			</form>
		</div>
		<table border="1px">
			<tr>
				<th>Tiêu đề</th>
				<th>Tác giả</th>
				<th>Giá Tiền</th>
				<th>số lượng còn</th>
				<th>Số lượng bán</th>
				<th>Ngày tạo</th>
				<th colspan="3" width="120px">Thao tác</th>
			</tr>
			<c:forEach items="${bookList}" var="book">
				<tr>
					<td>${book.title}</td>
					<td>${book.author}</td>
					<td><fmt:formatNumber type="number" maxFractionDigits="0" value="${book.price}"/><sup>đ</sup></td>
					<td>${book.quantityInStock} </td>
					<td>${book.soldQuantity} </td>
					<td><fmt:formatDate value="${book.createDate}" pattern="dd-MM-yyyy HH:mm"/> </td>
					<td align="center">
						<button type="button" onclick="activeAsLink('editBook?bookId=${book.bookId }');">sửa</button>
					</td>
					<td align="center">
						<form action="deleteBook" id="deleteBookFromAdminForm" method="post">
							<input type="hidden" value="${book.bookId }" name="bookId" id="deleteBookFromAdmin" />
							<button type="submit">Xóa</button>
						</form>
					</td>
					<td align="center">
						<a href="detailBookAdmin?bookId=${book.bookId }">Xem chi tiết</a>
					</td>
				</tr>
			</c:forEach>
		</table>
		<br>
		<a href="createBook">Thêm sách mới</a>
	</div>
	
	
	
	<script type="text/javascript">
		function onClickDeleteBook(bookTitle,bookId) {
			let c = confirm('Bạn chắc chắn múa xóa cuốn sách '+bookTitle+'?');
			if (c) {
				document.getElementById("deleteBookFromAdmin").value=bookId;
				document.getElementById("deleteBookFormAdminForm").submit();
			}
		}
		
	</script>
</body>
</html>