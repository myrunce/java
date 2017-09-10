<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<div id="ninjas">
		<h1>Ninjas</h1>

		// for loop to create all the links
		<c:forEach begin="1" end="${totalPages}" var="index">
			<a href="/pages/${index}">${index}</a>
		</c:forEach>
		<table class="table">
			<thead>
				<tr>
					<th>First Name</th>
					<th>Last Name</th>
					<th>Dojo</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach var="ninja" items="${ninjas.content}">
					<tr>
						<td><c:out value="${ninja.firstName}"></c:out></td>
						<td><c:out value="${ninja.lastName}"></c:out></td>
						<td><c:out value="${ninja.dojo.name}"></c:out></td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</div>
</body>
</html>