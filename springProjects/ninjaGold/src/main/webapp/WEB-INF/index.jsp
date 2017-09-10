<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<style>
	p.red{
		color:red;
	}
	p.green{
		color:green;
	}
</style>
</head>
<body>
       <h2>Your gold: <input type="text" value="<%=session.getAttribute("gold") %>"></h2>
        <p>Find Gold!</p>
        <fieldset>
            <h2>Farm</h2>
            <p>(Earns 10-20) gold</p>
            <form action="/process_money" method="post">
                <input type="hidden" name="building" value="farm">
                <input type="submit" value="Find Gold!"/>
            </form>
        </fieldset>
        <fieldset>
            <h2>Cave</h2>
            <p>(Earns 5-10 gold)</p>
            <form action="/process_money" method="post">
                <input type="hidden" name="building" value="cave">
                <input type="submit" value="Find Gold!"/>
            </form>
        </fieldset>
        <fieldset>
            <h2>House</h2>
            <p>(Earns 2-5 gold)</p>
            <form action="/process_money" method="post">
                <input type="hidden" name="building" value="house">
                <input type="submit" value="Find Gold!"/>
            </form>
        </fieldset>
        <fieldset>
            <h2>Casino</h2>
            <p>(Earns/takes 0-50 gold)</p>
            <form action="/process_money" method="post">
                <input type="hidden" name="building" value="casino">
                <input type="submit" value="Find Gold!"/>
            </form>
        </fieldset>
        <div>
            <h3>Activities</h3>
          <c:forEach items="${messages}" var="value">
		        <p class='<c:out value="${color}"/></c:out>'><c:out value="${value}"></c:out></p>
	      </c:forEach>
        </div>
</body>
</html>