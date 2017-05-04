<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
 <h1>Emp page</h1>
 
 <h2>Message : </h2> <% out.print(request.getAttribute("msg")); %>
 <br>
 <h2>Message : </h2> ${msg}
 
 <h2>Message1 : </h2> ${msg1}
  
 <h2>Message2 : </h2> ${msg2}
 
</body>
</html>