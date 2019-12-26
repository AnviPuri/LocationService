<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="ISO-8859-1">
		<title>Location Service</title>
	</head>
	<body>
		<form action="save-location" method="post">
			Id:<input type="text" name="id"/><br>
			Code:<input type="text" name="code"/><br>
			City:<input type="text" name="city"/><br>
			Type: Urban<input type="radio" name="type" value="URBAN"/><br>
				  Rural<input type="radio" name="type" value="RURAL"/><br>
			<input type="submit" value="save"/><br>
		</form>
		${message}<br>
		<a href="view-locations">Display All Locations</a>
	</body>
</html>