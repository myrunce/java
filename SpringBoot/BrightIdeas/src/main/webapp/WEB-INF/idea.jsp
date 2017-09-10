<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Idea</title>
<style>
	fieldset.anIdea{
		display:inline-block;
	}
	fieldset.likers{
		display:inline-block;
	}
	table {
		    border-collapse: collapse;
		    width: 100%;
		}
		
		td, th {
		    border: 1px solid #dddddd;
		    text-align: left;
		    padding: 8px;
		}
		
		tr:nth-child(even) {
		    background-color: #dddddd;
		}
		fieldset.eventTable{
			display:inline-block;
			width:800px;
		}
		fieldset.addEvent{
			display:inline-block;
		}
		.submitLink {
  			background-color: transparent;
  			text-decoration: underline;
 			border: none;
 			color: blue;
  			cursor: pointer;
  			margin-left:1000px;
		}
		submitLink:focus {
  			outline: none;
		}
		form.logoutForm{
			display:inline-block;		
		}
</style>
</head>
<body>
	<form class="logoutForm" method="POST" action="/logout">
        <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
        <input type="submit" class="submitLink" value="Logout" />
    </form>
    <a href="/bright_idea">Bright Ideas</a>
	<p><a href="/users/${idea.author.id}">${idea.author.name}</a> says:</p>
	<fieldset class="anIdea">
		<p>${idea.message}</p>
	</fieldset>
	
	<h5>People who liked this post:</h5>
	<fieldset class="likers">
		<table>
			<thead>
				<tr>
					<th>Alias</th>
					<th>Name</th>
			</thead>
			<tbody>
				<c:forEach items="${idea.likes}" var="person">
					<tr>
						<td><a href="/users/${person.id}">${person.alias}</a></td>
						<td>${person.name}</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</fieldset>
</body>
</html>