<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Welcome Page</title>
</head>
<body>
    <h1>Welcome <c:out value="${currentUser.firstName}"></c:out>!</h1>
    <fieldset>
    	<p>First name: <c:out value="${currentUser.firstName}"></c:out>
    	<p>Last name: <c:out value="${currentUser.lastName}"></c:out>
    	<p>Email: <c:out value="${currentUser.username}"></c:out>
    	<p>Sign up date: <c:out value="${currentUser.createdAt}"></c:out>
    	<p>Last Sign in: <%= session.getAttribute("signIn") %></p>
    </fieldset>
    <form id="logoutForm" method="POST" action="/logout">
        <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
        <input type="submit" value="Logout!" />
    </form>
</body>
</html>