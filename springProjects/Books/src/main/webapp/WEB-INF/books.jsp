<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<table class="table">
		<c:forEach items="${books}" var="book" varStatus="loop">
		    <tr>    
		    <td><c:out value="${book.title}"/></td>
		    <td><c:out value="${book.description}"/></td>
		    <td><c:out value="${book.language}"/></td>
		    <td><c:out value="${book.numberOfPages}"/></td>
		    <td><a href="/books/delete/${loop.index}">Delete</a></td>
		    </tr>
		</c:forEach>
	</table>
	<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!-- ... -->
<form:form method="POST" action="/books" modelAttribute="book">
    <form:label path="title">Title
    <form:errors path="title"/>
    <form:input path="title"/></form:label>
    
    <form:label path="description">Description
    <form:errors path="description"/>
    <form:textarea path="description"/></form:label>
    
    <form:label path="language">language
    <form:errors path="language"/>
    <form:input path="language"/></form:label>
    
    <form:label path="numberOfPages">Pages
    <form:errors path="numberOfPages"/>     
    <form:input type="number" path="numberOfPages"/></form:label>
    
    <input type="submit" value="Submit"/>
</form:form>
<!-- ... -->
</body>
</html>