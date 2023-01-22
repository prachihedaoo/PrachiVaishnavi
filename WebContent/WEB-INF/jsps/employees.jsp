<%@page import="org.springframework.beans.factory.ListableBeanFactory"%>
<%@page import="java.util.List"%>
<%@page import="com.main.model.Employee" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Employees</title>
</head>
<body>
<h1>All Employees are present</h1>
<%
int x=5;
int y=10;
out.println(x+y);
out.println("\n");
out.println(y/x);
%>
<%  
String value=(String)request.getAttribute("msg");
double priceVal=(double)request.getAttribute("price");
out.println(value);
out.println(priceVal);
%>
<h3>Array Iteration</h3>
<%
Integer[] iarray=(Integer[])request.getAttribute("iarray");

for(Integer t:iarray){
	out.println(t +"--");
}
%>
<h3>Employee List</h3>
<%
List<Employee> list=(List)request.getAttribute("list");

for(Employee e:list)
{
	out.println(e+"<BR>");
}
%>
<h3>Enter Employee Details</h3>
<fieldset style="width: 30%">
<legend>Employee Details</legend>
<form action="${pageContext.request.contextPath}/add-employee" method="POST">
<label>Name:</label> 
<input type="text" name="ename"> <br /> <br />
<label>City:</label> 
<input type="text" name="ecity"> <br /> <br />
<label>Salary:</label>     
<input type="text" name="esalary"> <br /> <br />
<input type="submit" value="Add Employee">
</form>
</fieldset>
</body>
</html>