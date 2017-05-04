<%@page import="com.rameez.movies.model.Employee"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

	<h1>Model page</h1>
	
	
	
	
	<%=request.getAttribute("NameStringKey") %>
	<br>
	
	
	<%	
	
		Employee emp = (Employee)request.getAttribute("myemp");
		
		out.println(emp.getName());
		out.println(emp.getAge());
		out.println(emp.getSalary());	
		out.println(emp.getDog().getName());
		out.println(emp.getDog().getBreed());
	%>
	
	<br>
	<p>--------------------------------------------------------------------------------</p>

	<h1> Name is : ${NameStringKey} </h1>
	
	<h2>Name: ${myemp.name}</h2>
	<h2>Age: ${myemp.age}</h2>
	<h2>Salary: ${myemp.salary}</h2>
	<h3>${myemp.name} 's dog's name: ${myemp.dog.name}</h3>
	<h3>${myemp.name} 's dog's breed: ${myemp.dog.breed}</h3>
	
	<h1>${ReqKey}</h1>
	

</body>
</html>