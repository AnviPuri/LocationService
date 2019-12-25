<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="ISO-8859-1">
		<title>View All Locations</title>
	</head>
	<body>
		<h2>Locations</h2>
		<table>
			<tr>
				<th>ID</th>
				<th>CODE</th>
				<th>NAME</th>
				<th>TYPE</th>
			</tr>
			<c:forEach items="${locations}" var="location">
				<tr>
					<td>${location.id}</td>
					<td>${location.code}</td>
					<td>${location.city}</td>
					<td>${location.type}</td>
					<td><a href="delete-location?id=${location.id}">Delete</a></td>
					<td><a href="call-update-location?id=${location.id}">Update</a></td>
				</tr>
			</c:forEach>
		</table>	
		<a href="show-create-loaction">Add Location</a>
	</body>
</html>