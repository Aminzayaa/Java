<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>

<!DOCTYPE html>

<html>
<head>
<meta charset="UTF-8">
<title>Java application assignment</title>
<link href="css/styles.css" rel="stylesheet">
</head>
<body>
	<h1>Pet information management</h1>
	<div class="info">
		<h2>Home page</h2>
		<form action="startServlet" method="post">
			<c:if test="${not empty requestScope.errorMsg}">
				<p class="error">${requestScope.errorMsg}</p>
			</c:if>
			Password: <input type="password" name="pass"> <br />
			<button class="btn" type="submit">Get Started</button>
		</form>
	</div>
</body>
</html>