<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>${user.name}</title>
	<style>
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
	<p>Name: ${user.name}</p>
	<p>Alias: ${user.alias}</p>
	<p>Email: ${user.username}
	<p>---------------------------------------------------------------------</p>
	<p>Total number of posts: ${posts}</p>
	<p>Total number of likes: ${likes}</p>
</body>
</html>