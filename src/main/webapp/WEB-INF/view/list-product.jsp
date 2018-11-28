<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
	<table>
		<tr>
			<td>STT</td>
			<td>Name</td>
			<td>Category</td>
			<td>PublishingHose</td>
			<td>Price</td>
			<td>Quantity</td>
			<td>View</td>
			<td>Doc</td>
			<td>Discount</td>
			<td>SoldNumber</td>
		</tr>
		<c:set var="i" value="1"></c:set>
		<c:forEach var="p" items="${products}">
			<tr>
				<td>${i}</td>
				<td>p.name</td>
				<td>p.getCategory().name</td>
				<td>p.getPublishingHouse().name</td>
				<td>p.price</td>
				<td>p.quantity</td>
				<td>p.view</td>
				<td>p.doc</td>
				<td>p.discount</td>
				<td>p.soldNumber</td>
			</tr>
			<c:set var="i" value="${i+1}"></c:set>
		</c:forEach>
	</table>
</body>
</html>