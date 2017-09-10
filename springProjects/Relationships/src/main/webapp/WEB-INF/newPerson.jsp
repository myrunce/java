<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>New Person</title>
</head>
<body>
	<form:form method="POST" action="/persons/add" modelAttribute="person">
	    <form:label path="firstName">First Name
	    <form:errors path="firstName"/>
	    <form:input path="FirstName"/></form:label><br><br>
	    
	    <form:label path="lastName">Last Name
	    <form:errors path="lastName"/>
	    <form:input path="lastName"/></form:label><br><br>
	    
	    <input type="submit" value="Add Person"/>
	</form:form>
	<p><a href="/licenses/new">Make a License</a><p>
</body>
</html>