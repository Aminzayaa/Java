<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Java Application Assignment</title>
<link href="css/styles.css" rel="stylesheet">
</head>
<body>
	<h1>Pet Information Management</h1>

	<c:if test="${not empty requestScope.infoUpdatedMsg}">
		<p class="update-msg">${requestScope.infoUpdatedMsg}</p>
	</c:if>

	<div class="info">
		<h2>Pet List</h2>
		<form action="petListServlet">
			<button class="btn" type="submit" name="btn" value="dog">${fn:escapeXml(sessionScope.dogName)}</button>
			<button class="btn" type="submit" name="btn" value="cat">${fn:escapeXml(sessionScope.catName)}</button>
			<button class="btn" type="submit" name="btn" value="lizard">${fn:escapeXml(sessionScope.lizardName)}</button>
		</form>
	</div>
	<form action="index.jsp">
		<button class="btn" type="submit">Back to top</button>
	</form>
</body>
</html>