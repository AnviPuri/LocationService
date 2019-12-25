<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="ISO-8859-1">
		<title>Update Location</title>
	</head>
	<body>
		<form action="update-location" method="post">
				Id:<input type="text" name="id" value="${location.id}" readonly/><br>
				Code:<input type="text" name="code" value="${location.code}"/><br>
				City:<input type="text" name="city" value="${location.city}"/><br>
				Type: Urban<input type="radio" name="type" value="URBAN" ${location.type=='URBAN'?'checked':''}/><br>
					  Rural<input type="radio" name="type" value="RURAL" ${location.type=='RURAL'?'checked':''}/><br>
				<input type="submit" value="save"/><br>
		</form>
	</body>
</html>