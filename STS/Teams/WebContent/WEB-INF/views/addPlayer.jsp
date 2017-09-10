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
	<c:set var="teamName" value="${team.getName()}"/>
	<c:set var="teamID" value="${id}"/>
	<h1>Add a player to <c:out value = "${teamName}"/></h1>
	<form action="addPlayer" method="POST">
		First Name: <input type="text" name="firstName"><br><br>
		Last Name: <input type="text" name="lastName"><br><br>
		Age: <select name="age">
				<option value="1">1</option>
				<option value="2">2</option>
				<option value="3">3</option>
				<option value="4">4</option>
				<option value="5">5</option>
				<option value="6">6</option>
				<option value="7">7</option>
				<option value="8">8</option>
				<option value="9">9</option>
				<option value="10">10</option>
		</select><br><br>
		<input type="hidden" name="id" value="${teamID}">
		<input type="submit" value="Add">
	</form>
</body>
</html>