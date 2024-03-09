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
	<jsp:include page="_header.jsp"></jsp:include>
	<jsp:include page="_menu.jsp"></jsp:include>
	<div align="center">
		<h3>Các cuốn sách có trong giỏ hàng</h3>
		<form action="removeFromCart" id="removeBookFromCartForm" method="post">
			<input type="hidden" name="bookId" id="removeBookFromCart">
			</form>
			<table border="1">
			<tr>
				<td>Tiêu đề</td>
				<td>Tác giả</td>
				<td>Giá tiền</td>
				<td>Số lượng mua</td>
				<td>Tổng tiền</td>
				<td>Thao tác</td>
			</tr>
			<c:forEach items="${cartOfCustomer.cartItemList }" var="entry">
				
				<tr>
					<td>${entry.value.selectedBook.title }</td>
					<td>${entry.value.selectedBook.author }</td>
					<td>
					<fmt:formatNumber type="number" maxFractionDigits="0" value="${entry.value.selectedBook.price }"/> <sup>đ</sup></td>
					<td>
						<button type="button" 
							onclick="minusValueAndUpdateCart('quantity${entry.value.selectedBook.bookId }');" 
						> - </button>
						
						<input type="text" value="${entry.value.quantity }" 
							id="quantity${entry.value.selectedBook.bookId }" 
							onchange="validateValueAndUpdateCart(this,${entry.value.selectedBook.quantityInStock }
																		,${entry.value.selectedBook.bookId }
																		,${entry.value.selectedBook.price })"
							size="2" style="line-height: 20px" >
							
						<button type="button" 
							onclick="plusValueAndUpdate('quantity${entry.value.selectedBook.bookId }'
																	,${entry.value.selectedBook.quantityInStock});" 
						>+</button>
					</td>
					<td>
						<span id="subtotal${entry.value.selectedBook.bookId }">
							<fmt:formatNumber 
								type="number" maxFractionDigits="0" 
								value="${entry.value.selectedBook.price*entry.value.quantity }"/> <sup>đ</sup>
						</span>
						
					</td>
					<td>
						<button type="button" 
						onclick="onClickRemoveBook('${entry.value.selectedBook.title}'
													,${entry.value.selectedBook.bookId })">
							Xóa sp
						</button>   
					</td>
				</tr>
			</c:forEach>
			
		</table>
		<br>
			<a href="${pageContext.request.contextPath }/clientHome">Tiếp tục xem tiếp</a>  
			Tổng số tiền:
			<b>
				<span id="total"><fmt:formatNumber type="number" maxFractionDigits="0" value="${cartOfCustomer.totalCost }"/> <sup>đ</sup></span>
			</b>
		
		
	</div>
	<hr>
	<div align="center">
		<h3>THANH TOÁN & ĐẶT MUA</h3>
		<p style="color: red;">${errors}</p>
		<form action="${pageContext.request.contextPath }/order" method="post"
			enctype="multipart/form-data">
			<table border="1">
				<tr>
					<th align="left">Tài khoản</th>
					<td>${loginedUser.username}</td>
				</tr>
				<tr>
					<th align="left">Họ tên</th>
					<td>${loginedUser.fullname}</td>
				</tr>
				<tr>
					<th align="left">Số di động</th>
					<td>${loginedUser.mobile}</td>
				</tr>
				<tr>
					<th align="left">Địa chỉ đăng ký</th>
					<td>${loginedUser.address}</td>
				</tr>
				<tr>
					<th align="left">Nhập địa chỉ nhận sách</th>
					<td><input type="text" name="deliveryAddress"
						required="required" size="100" /></td>
				</tr>
				<tr>
					<th align="left">Phương thức thanh toán</th>
					<td><input type="radio" name="paymentMode" value="cash"
						checked="checked"
						onclick="document.getElementById('uploadDiv').style.display='none';" />
						Thanh toán tiền mặt khi nhận hàng <br> <input type="radio"
						name="paymentMode" value="transfer"
						onclick="document.getElementById('uploadDiv').style.display='block';" />
						Chuyển khoản ngân hàng <br>
						<div id="uploadDiv" style="padding-left: 30px; display: none;"><br>
							Quý khách hãy chuyển khoản tới tài khoản dưới đây với nội dung theo một trong 2 mẫu: <br>
							&ensp;mẫu 1: (Số điện thoại đăng ký tài khoản) - thanh toán đơn hàng <br>
							&ensp;mẫu 2: (Tên tài khoản đăng ký) - thanh toán đơn hàng <br>
							Sau đó chụp ảnh màn hình kết quả chuyển khoản hoặc chụp ảnh phiếu xác nhận từ cây ATM <br><br>
							&ensp;Tên chủ tài khoản:.................. <br>
							&ensp;Số tài khoản     :.................. <br>
							&ensp;Chi nhánh ngân hàng................. <br><br>
							<b>Chọn ảnh kết quả chuyển khoản:</b>
							<img alt="" src="" id="bookImage" width="150">&nbsp;
							<input type="file" name="file" accept="image/*" onchange="loadImage(event)" />
						</div>
						</td>
				</tr>
				<tr>
					<td></td>
					<td><input type="submit" value="Đặt mua" /></td>
				</tr>
			</table>
		</form>
	</div>
</body>
</html>