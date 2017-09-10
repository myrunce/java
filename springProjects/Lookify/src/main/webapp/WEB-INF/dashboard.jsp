<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Dashboard</title>
<style>
	form#song{
		display:inline-block
	}
	a.move{
		margin-right:850px;
	}
</style>
</head>
<body>
	<div id="header">
		<a href="/songs/new">Add New</a>
		<a class="move" href="songs/topSongs">Top Songs</a>
		<form:form method="post" action="/search/${artist}" modelAttribute="song">
	    	<form:label path="artist">
	    	<form:errors path="artist"/>
	    	<form:input path="artist"/></form:label>
	    
	    	<input type="submit" value="Search Artists"/>
		</form:form>
	</div>
	<div id="body">
		<table>
			<thead>
				<tr>
					<th>Name</th>
					<th>Rating</th>
					<th>Actions</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${songs}" var="song" varStatus="loop">
					<tr>    
					    <td><a href="songs/<c:out value="${song.id}"/>">${song.name}</a></td>
					    <td><c:out value="${song.rating}"/></td>
					    <td><a href="/delete/${song.id}">Delete</a></td>
				    </tr>				
				</c:forEach>	
			</tbody>
		</table>	
	</div>
</body>
</html>