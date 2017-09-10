<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Bright Idea</title>
<style>
	fieldset.anIdea{
		width:400px;
	}
	input#message{
		width:700px;
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
    <h1>Welcome <c:out value="${currentUser.alias}"></c:out>!</h1>
	<p>
		<form:errors path="idea.*" />
	</p>

	<form:form method="POST" action="/bright_idea" modelAttribute="idea">
		<p>
			<form:label path="message"></form:label>
			<form:input Value="Post something witty here.." path="message" /> <input type="submit" value="Idea!" />
		</p>
	</form:form>
	
	<div class="ideas">
		<c:forEach items="${ideas}" var="idea">
			<p><a href="/users/${idea.author.id}">${idea.author.name}</a> says:</p>
			<c:if test="${idea.author.id == currentUser.id}">
				<a href="/delete/${idea.id}">Delete</a>
			</c:if>
			<fieldset class="anIdea">
				<p>${idea.message}</p>
			</fieldset>
			<c:set var = "count" value = "0"/>
			<c:forEach items="${idea.likes}" var="person">
				<c:if test = "${person.id == currentUser.id}">
					<p><a href="/unlike/${idea.id}">Unlike</a> <a href="/bright_ideas/${idea.id}">${idea.likes.size()} People</a> liked this.</p>
					<c:set var = "count" value = "1"/>
				</c:if>
			</c:forEach>
			<c:if test="${count == 0 || idea.likes.size() == 0}">
				<p><a href="/like/${idea.id}">Like</a> <a href="/bright_ideas/${idea.id}">${idea.likes.size()} People</a> liked this.</p>
			</c:if>
		</c:forEach>
	</div>
</body>
</html>