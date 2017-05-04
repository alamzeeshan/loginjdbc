<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<a href="employee">Go to Employee Page</a> 


<br>

 <form action="login" method="get">
	Username: <input type="text" name="user" id="user" />
	Password : <input type="password" name="pwd" id="pwd" />
	<input type="submit" value="Click Here">
</form>
${requestScope.result} 



</body>
</html>