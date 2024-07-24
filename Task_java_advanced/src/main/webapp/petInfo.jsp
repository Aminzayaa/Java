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
	<div class="info">
		<h2>Pet Information</h2>
		<table class="petInfoTable">
			<tr>

				<th>Name:</th>
				<td>${fn:escapeXml(requestScope.name)}</td>
			</tr>
			<tr>
				<th>Age:</th>
				<td>${fn:escapeXml(requestScope.age)}</td>
			</tr>
			<tr>
				<th>Length:</th>
				<td>${fn:escapeXml(requestScope.height)}</td>
			</tr>
			<tr>
				<th>Weight:</th>
				<td>${fn:escapeXml(requestScope.weight)}<c:if
						test="${requestScope.isFat}">
						<span class="error">*I'm overweight</span>
					</c:if>
				</td>
			</tr>
			<c:choose>
				<c:when test="${requestScope.isAnimal}">
					<tr>
						<th>Type:</th>
						<td>${fn:escapeXml(requestScope.type)}</td>
					</tr>
					<tr>
						<th>${fn:escapeXml(requestScope.optionTitle)}:</th>
						<td>${fn:escapeXml(requestScope.option)}</td>
					</tr>
				</c:when>
			</c:choose>
			<c:choose>
				<c:when
					test="${requestScope.isReptile and requestScope.isDangerous}">
					<td colspan="2"><span class="dangerous">※Dangerous</span></td>
				</c:when>
			</c:choose>
		</table>
	</div>

	<div class="update">
		<h3>Change pet information</h3>
		<form action="petInfoServlet" method="post">
			Name: <input type="text" name="name"
				value="${fn:escapeXml(requestScope.name)}" /> <br>
			<c:if test="${requestScope.isAnimal}">
Weight:
<input type="number" name="weight" min="1"
					value="${fn:escapeXml(requestScope.weight)}" />
			</c:if>
			<br>
			<button class="btn-update" type="submit" name="btn">Change</button>
		</form>
	</div>

	<form action="petList.jsp">
		<button class="btn" type="submit">Go back</button>
	</form>

	<form action="index.jsp">
		<button class="btn" type="submit">Go back to the top</button>
	</form>
</body>
</html>