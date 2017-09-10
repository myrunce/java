<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>New Question</title>
</head>
<body>
	<h1>What is your Question?</h1>
	<form:form method="POST" action="/questions/add" modelAttribute="theQuestion">
	    <form:label path="question">Question:
	    <form:errors path="question"/>
	    <form:textarea path="question"/></form:label><br><br>
	    
	    <c:if test="${!empty errors}">
	    		<p>${errors}</p>
	    </c:if>
<%-- 	    <form:label path="tags">Tags --%>
<%-- 	    <form:errors path="tags"/> --%>
<%-- 	    <form:input path="tags"/></form:label><br><br> --%>

			<label for="subject">Tags: </label>
			<input type="text" name="subject" id="subject"><br><br>
		
	    
	    <input type="submit" value="Submit"/>
	
	</form:form>
</body>
</html>