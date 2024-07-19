<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%
String result = (String) request.getAttribute("result");
%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Word Search</title>
<style>
body {
    border: solid 2px #000080;
    padding: 5px;
}
.result {
    background: #fffacd;
    display: inline-block;
    margin: 5px;
    padding: 10px;
}
</style>
</head>
<body>

<h1>Word Search</h1>

<h2>Dictionary Search Page</h2>
<div class="result">
    <c:if test="${not empty result}">
        <h3>Search Results</h3>
        <p><%= result %></p>
    </c:if>
</div>

<form action="SearchServlet" method="post">
    <label>Enter English word:</label>
    <input type="text" name="english">
    <br>
    <button type="submit">Search</button>
</form>

</body>
</html>
