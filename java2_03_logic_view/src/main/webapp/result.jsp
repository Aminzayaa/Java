<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%
String id = (String) request.getAttribute("id");
String passwordMatch = (String) request.getAttribute("passwordMatch");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Result screen</title>
</head>
<body>
<div>
	<p> The ID entered was <%= id %>.</p>
	<% if (passwordMatch.equals("ok")) {%>
	<p>Passwords matched.</p>
	<% } else { %>
	<p> Passwords did not match. </p>
	<%} %>
</div>
</body>
</html>