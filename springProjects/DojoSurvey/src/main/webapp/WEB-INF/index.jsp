<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
        <form action="/process" method="post">
            Your Name: <input type="text" name="name"><br><br>
            Dojo Location: <select name="dojoLocation">
                <option value="San Jose">San Jose</option>
                <option value="Seattle">Seattle</option>
                <option value="Los Angeles">Los Angeles</option>
                <option value="Washington DC">Washington Dc</option>
            </select><br><br>
            Favorite Language: <select name="favLanguage">
                <option value="Python">Python</option>
                <option value="Javascript">Javascript</option>
                <option value="C++">C++</option>
            </select><br><br>
            Comment (optional):<br><br>
            <textarea name="comment"></textarea><br>
            <input type="submit" value="submit">
        </form>
    </body>
</body>
</html>