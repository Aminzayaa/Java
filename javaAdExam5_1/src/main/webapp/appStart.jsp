<%@ page import="jp.co.axiz.app.GameApp"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%
String result = (String) request.getAttribute("result");
String playTime = (String) request.getAttribute("playTime");
%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Java Advanced_Exercise 5_1</title>
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

<h1>Java Exercise</h1>

<h2>App run page</h2>
<div class="result">
    <c:if test="${not empty result}">
        <h3>App execution results</h3>
        <p><%= result %></p>
        <c:if test="${not empty playTime}">
        </c:if>
    </c:if>
</div>

<form action="StartAppServlet" method="post">
    <label>Username:</label>
    <input type="text" name="name">
    <br>
    <label>Select App Type:</label>
    <input type="radio" name="appType" value="card" checked> Trump
    <input type="radio" name="appType" value="darts"> Darts
    <input type="radio" name="appType" value="clock"> Clock
    <input type="radio" name="appType" value="other"> Other
    <br>
    <button type="submit">Start</button>
</form>

</body>
</html>
