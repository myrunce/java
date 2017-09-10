<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<style>
	fieldset.table{
		display:inline-block;
	}
</style>
</head>
<body>
	<fieldset class = "table">
		<table>
			<thead>
				<tr>
					<th>Name</th>
					<th>Creator</th>
					<th>Version</th>
					<th>Action</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${languages}" var="language" varStatus="loop">
					<tr>    
					    <td><a href="/language/${loop.index}"><c:out value="${language.name}"/></a></td>
					    <td><c:out value="${language.creator}"/></td>
					    <td><c:out value="${language.version}"/></td>
					    <td><a href="/edit/${language.id}">Edit</a> <a href="/delete/${language.id}">Delete</a></td>
				    </tr>				
				</c:forEach>	
			</tbody>
		</table>
	</fieldset>
	<form:form method="POST" action="/" modelAttribute="language">
	    <form:label path="name">Name
	    <form:errors path="name"/>
	    <form:input path="name"/></form:label><br><br>
	    
	    <form:label path="creator">Creator
	    <form:errors path="creator"/>
	    <form:input path="creator"/></form:label><br><br>
	    
	    <form:label path="version">Version
	    <form:errors path="version"/>
	    <form:input path="version"/></form:label><br><br>
	    
	    <form:hidden path="id"/>
	    <input type="submit" value="Submit"/>
	</form:form>
</body>
</html>