<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Trang kết quả</title>
</head>
<body>
	Xin chào: <b>${loginedUser.fullName }</b>
	<br>
	<a href="${pageContext.request.contextPath}/logout">Đăng xuất</a>
</body>
</html>