<%@ page import="app.GameApp"%> 
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%
String result = (String) request.getAttribute("result");
%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Java Advanced_Exercise 1</title>
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

<h1>Java дасгал 1</h1>

<h2>Тоглоомын программын гүйцэтгэлийн хуудас</h2>
<div class="result">
    <c:if test="${not empty result}">
        <h3> テスト <h3>
    </c:if>
    <p><%= result %></p>
</div>

<form action="StartAppServlet" method="post">
    <label>Username:</label>
    <input type="text" name="name">
    <br>
    <button type="submit">start</button>
</form>

</body>
</html>