<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page isELIgnored="false"%>
<%@ include file="/WEB-INF/include/Header.jsp"%>


<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Cart Page</title>
</head>

<h1>Cart Page</h1>
<div style="color: white">
	<table border='1'>
		<form action="./cart" method="get">
			<c:forEach var="product" items="${requestScope.productList}">

				<tr align='center'>
					<td width="10">${product.id}</td>
					<td><img src="./productImage/${product.id}.jpg" height="25"></td>
					<td width="50">${product.name}</td>
					<td width="30">${product.price}</td>
					<td width="20">${numberProduct}</td>
					<td width="20">
					<button type="submit" value="+" />+	</button></td>
					<td width="20">
					<button type="submit" value="-" />-	</button></td>
					<td width="20">Summ</td>
				</tr>
			</c:forEach>
		<tr>
	
			<td>Final Summ</td>
			<td> 	
			<input type = "hidden" name ="ClearCart" value ="Ok" /> 
			<input type="submit" value="ClearCart"/>
			</td>
		
		</tr>
		</form>
	</table>
</div>

</html>


<%@ include file="/WEB-INF/include/Footer.jsp"%>