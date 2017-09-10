<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!-- ... -->
<h1><c:out value="${license.person.firstName} ${license.person.lastName}"/></h1>
<p>License number: <c:out value="${license.number}"/></p>
<p>State: <c:out value="${license.state}"/></p>
<P>Expiration Date: <c:out value="${license.expiration_date}"/></p>
</body>
</html>