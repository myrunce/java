<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>   
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>One Product</title>
</head>
<body>
<h1><c:out value="${product.name}"/></h1>
<h3>Categories</h3>
<ul>
	<c:forEach items="${product.categories}" var="pCategory">
			<li><c:out value="${pCategory.name}"/></li>
	</c:forEach>
</ul>
	<form:form method="POST" action="/products/${id}/addCategory" modelAttribute="category">
		<form:label path="name">Category
		<form:errors path="name"/>
		<form:select path="name">
		<c:forEach items="${categories}" var="category">
			<form:option value="${category.id}" label="name">${category.name}</form:option>
		</c:forEach>
		</form:select>
	</form:label><br><br>

	<input type="submit" value="Add A Category"/>
	</form:form>
</body>
</html>