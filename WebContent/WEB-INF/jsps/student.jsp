  <%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h1>All student</h1>
<% 
String sname=(String)request.getAttribute(("sname"));
out.println(sname);
%>
<h3>List Iteration</h3>
<%
List<String> list=(List<String>)request.getAttribute("slist");
for(String s:list){
	out.println(s+"***");
}

%>


<h3>Reading Data from URL</h3>

<a href="${pageContext.request.contextPath }/sample-link?name=sachin&city=mumbai">sample Link</a> <br />
%>
<!--  
name=sachin,
city=mumbai
-->
</body>
</html>