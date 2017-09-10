<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>New Ninja</title>
</head>
<body>
	<form:form method="POST" action="/ninjas/add" modelAttribute="ninja">
	    <form:label path="dojo">Dojo
	    <form:errors path="dojo"/>
	    <form:select path="dojo">
	    	<c:forEach items="${dojos}" var="dojo">
	    		<form:option value="${dojo.id}" label="dojo">${dojo.name}</form:option>
	    	</c:forEach>
	    </form:select>
	    </form:label><br><br>
	    
	    <form:label path="firstName">First name
	    <form:errors path="firstName"/>
	    <form:input path="firstName"/></form:label><br><br>
	    
	    <form:label path="lastName">Last name
	    <form:errors path="lastName"/>
	    <form:input path="lastName"/></form:label><br><br>
	    
	    <form:label path="age">Age
	    <form:errors path="age"/>
	    <form:input path="age"/></form:label><br><br>
	
	    <input type="submit" value="Make A Ninja"/>
	</form:form>
</body>
</html>