<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Add a new Song</title>
</head>
<body>
	<a href="/dashboard">Dashboard</a>
	<form:form method="POST" action="/songs/new" modelAttribute="song">
	    <form:label path="name">Title
	    <form:errors path="name"/>
	    <form:input path="name"/></form:label><br><br>
	    
	    <form:label path="artist">Artist
	    <form:errors path="artist"/>
	    <form:input path="artist"/></form:label><br><br>
	    
	    <form:label path="rating">Rating</form:label><br><br>
	    <form:errors path="rating"/>
	    <form:select path="rating">
	    	<form:option value="1" label="rating">1</form:option>
	    	<form:option value="2" label="rating">2</form:option>
	    	<form:option value="3" label="rating">3</form:option>
	    	<form:option value="4" label="rating">4</form:option>
	    	<form:option value="5" label="rating">5</form:option>
	    	<form:option value="6" label="rating">6</form:option>
	    	<form:option value="7" label="rating">7</form:option>
	    	<form:option value="8" label="rating">8</form:option>
	    	<form:option value="9" label="rating">9</form:option>
	    	<form:option value="10" label="rating">10</form:option>
	    </form:select>
	    
	    
	    <input type="submit" value="Add Song"/>
	</form:form>
</body>
</html>