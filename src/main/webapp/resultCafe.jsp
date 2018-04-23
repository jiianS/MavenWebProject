<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>	
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page isELIgnored="false" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Result</title>
</head>

<body>

	<h1>총 금액 : ${total}</h1>
	
	
	<form action = "CafeS">		 
		<input type="hidden" name="total" value="${total}"/>
		<input type="number" name="pay" placeholder="얼마 내실 거예요?"/>
		<input type="submit" value="계산 ㄱㄱ"> 
	</form>
	<a href="indexCafe.html"> 주문 취소 </a>
	<% 
	if (request.getParameter("pay") != null)
	%>
	<p><font color="red"> ${change} </font></p>
	 
</body>
</html>