<%@ page import="app.GameApp"%>  //GameApp.java импортлож оруулсан
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%
    request.setCharacterEncoding("UTF-8");

    String name = request.getParameter("name"); // утгыг авч хувьсагчид оноодог
    String result = "Not executed"; // ямар ч үйлдэл хийгээгүй болон амжилтгүй үед гарна

    if (name != null && !name.isEmpty()) { // нөхцлийг шалгаж бна
        GameApp gameApp = new GameApp(); // GameApp Object үүсгэж бна
        gameApp.setItem("something"); 
        result = gameApp.start(name);
    }
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
    <h3>Хэрэглээний гүйцэтгэлийн хуудас</h3>
    <p><%= result %></p>
</div>

<form action="appStart.jsp" method="post">
    <label>Username:</label>
    <input type="text" name="name">
    <br>
    <button type="submit">start</button>
</form>

</body>
</html>
