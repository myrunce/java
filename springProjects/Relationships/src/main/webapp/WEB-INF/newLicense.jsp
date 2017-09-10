<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<form:form method="POST" action="/licenses/add" modelAttribute="license">
	    <form:label path="person">Person
	    <form:errors path="person"/>
	    <form:select path="person">
	    	<c:forEach items="${persons}" var="person">
	    		<form:option value="${person}" label="person">${person.firstName} ${person.lastName}</form:option>
	    	</c:forEach>
	    </form:select>
	    </form:label><br><br>
	    
	    <form:label path="state">State
	    <form:errors path="state"/>
	    <form:input path="state"/></form:label><br><br>
	    
	    <form:label path="expiration_date">Date
	    <form:errors path="expiration_date"/>
	    <form:input type="date" path="expiration_date"/></form:label><br><br>
	    
	    <form:hidden value="${id}" path="number"/>
	    <input type="submit" value="Add License"/>
	</form:form>
</body>
</html>