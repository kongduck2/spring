<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>regist</title>
</head>
<body>
	<h3>Order 완료~</h3>
	<ul>
		<li>주문 아이디 :${order.id }</li>
		<li>주문 수량 : ${order.amount }</li>
		<li>배송 날짜 : ${order.devDate }</li>
	</ul>
	
	
</body>
</html>