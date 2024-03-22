<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

<style type="text/css">
	li{
		border:1px solid black ;
		border-radius: 10px;
		display: inline-block;
		margin-right: 15px;
		padding: 5px;
	}
	a{text-decoration: none}
</style>
</head>
<body>
	
	<div class="menu" style="padding: 5px;" align="center">
		<ul>
			<li><a id="btn1" href="${pageContext.request.contextPath }/adminHome">Trang chủ</a></li>
			<li><a id="btn2" href="${pageContext.request.contextPath }/OrderAdmin1">Các dơn hàng chưa xác nhận</a></li>
			<li><a id="btn3" href="${pageContext.request.contextPath }/OrderAdmin2">Các đơn hàng đang chờ giao hàng</a></li>
			<li><a id="btn4" href="${pageContext.request.contextPath }/OrderAdmin3">các đơn hàng đã giao hàng</a></li>
			<li><a id="btn5" href="${pageContext.request.contextPath }/OrderAdmin5">Các đơn hàng đã trả hàng</a></li>
		</ul>
	</div>
	<script type="text/javascript">
	$(document).ready(function(){
		$('#btn1').click(function(){
			$('#btn1').css('color','white').css('background-color','red');
			$('#btn2').css('color','black').css('background-color','white');
			$('#btn3').css('color','black').css('background-color','white');
			$('#btn4').css('color','black').css('background-color','white');
			$('#btn5').css('color','black').css('background-color','white');
	    })
	    $('#btn2').click(function(){
	    	$('#btn1').css('color','black').css('background-color','white');
			$('#btn2').css('color','white').css('background-color','red');
			$('#btn3').css('color','black').css('background-color','white');
			$('#btn4').css('color','black').css('background-color','white');
			$('#btn5').css('color','black').css('background-color','white');
	    })
	    $('#btn3').click(function(){
	    	$('#btn1').css('color','black').css('background-color','white');
			$('#btn2').css('color','black').css('background-color','white');
			$('#btn3').css('color','white').css('background-color','red');
			$('#btn4').css('color','black').css('background-color','white');
			$('#btn5').css('color','black').css('background-color','white');
	    })
	    $('#btn4').click(function(){
	    	$('#btn1').css('color','black').css('background-color','white');
			$('#btn2').css('color','black').css('background-color','white');
			$('#btn3').css('color','black').css('background-color','white');
			$('#btn4').css('color','white').css('background-color','red');
			$('#btn5').css('color','black').css('background-color','white');
	    })
	    $('#btn5').click(function(){
	    	$('#btn1').css('color','black').css('background-color','white');
			$('#btn2').css('color','black').css('background-color','white');
			$('#btn3').css('color','black').css('background-color','white');
			$('#btn4').css('color','black').css('background-color','white');
			$('#btn5').css('color','white').css('background-color','red');
	    })
	})
	</script>
</body>
</html>