<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Team Details</title>
</head>
<body>
	<c:set var="teamName" value="${team.getName()}"/>
	<c:set var="teamID" value="${id}"/>
	<h1><c:out value = "${teamName}"/></h1>
	<a href='addPlayer?id=<c:out value ="${teamID}"/>'>Add Player</a>
	<table>
		<thead>
			<tr>
				<th>First Name</th>
				<th>Last Name</th>
				<th>Age</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach var="teamPlayer" items="${team.getPlayers()}" varStatus="loop">
				<tr>
					<td><c:out value = "${teamPlayer.getFirst()}"/></td>
					<td><c:out value = "${teamPlayer.getLast()}"/></td>
					<td><c:out value = "${teamPlayer.getAge()}"/></td>
					<td><a href='/Team?id=<c:out value ="${teamID}"/>/deleteplayer?playerid=<c:out value ="${loop.index}"/>'>Delete Player</a></td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
</body>
</html>