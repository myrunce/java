<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link href="style.css" rel="stylesheet" type="text/css">
<title>CheckerBoard</title>
</head>
<body>
	<% int height = Integer.parseInt(request.getParameter("height")); %>
	<% int width = Integer.parseInt(request.getParameter("width")); %>
	<h1>Checkerboard: <%= width %>w X <%= height %>h </h1>
 	<% for(int i = 0; i < height; i++){ %>
 		<% if (i % 2 == 0) {%>	
	 		<div class= "evenRow"> 
			<% for (int j = 0; j < width; j++) { %>
				<% if( j % 2 == 0){ %>
					<div class="red"></div>
				<% } else { %>
					<div class="black"></div>
				<% } %>
			<% } %>
		<% } else {%>	
	 		<div class= "oddRow"> 
			<% for (int j = 0; j < width; j++) { %>
				<% if( j % 2 == 0){ %>
					<div class="black"></div>
				<% } else { %>
					<div class="red"></div>
				<% } %>
			<% } %>
		<% } %>
		</div>
	<% } %>  
</body>
</html>