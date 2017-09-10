<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>New Dojo</title>
</head>
<body>
	<form:form method="POST" action="/dojos/add" modelAttribute="dojo">
	    <form:label path="name">Name
	    <form:errors path="name"/>
	    <form:input path="name"/></form:label><br><br>
	
	    <input type="submit" value="Add Dojo"/>
	</form:form>
	<p><a href="/ninjas/new">Give a ninja a home</a><p>
</body>
</html>