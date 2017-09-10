<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<div class="makeDog">
		<h3>Make A Dog!</h3>
		<form action="makeDog" method = "Post">
			Name: <input type="text" name="name"><br><br>
			Breed: <input type="text" name="breed"><br><br>
			Weight: <input type="text" name="weight"><br><br>
			<input type="submit" value="Submit">
		</form>
	</div>
	<div class="makeCat">
		<h3>Make A Cat!</h3>
		<form action="makeCat" method = "Post">
			Name: <input type="text" name="name"><br><br>
			Breed: <input type="text" name="breed"><br><br>
			Weight: <input type="text" name="weight"><br><br>
			<input type="submit" value="Submit">
		</form>
	</div>
</body>
</html>