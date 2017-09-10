<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>The code</title>
<style>
	p.red{
		color:red;
	}
</style>
</head>
<body>
	<p class = "red">${errors}</p>
	<p>What is the code?</p>
	<form action="/process" method="post">
		<input type="text" name="guess"><br><br>
		<input type="submit" value="Try code">
	</form>
</body>
</html>