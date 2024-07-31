<%@ page language="java" contentType="text/html; charset=UTF-8"
  pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>トップ画面</title>
<link href="css/commons.css" rel="stylesheet">
</head>
<body>
  <h2>検索条件を入力してください</h2>
  <c:if test="${not empty msg}">
    <p>${msg}</p>
  </c:if>
  <form action="ProductServlet" method="post">
    <label>product_name:</label>
    <input type="text" name="productName" value="${param.productName}">
    <br>
    <label>price:</label>
    <input type="number" name="price" value="${param.price}">
    <br>
    <button type="submit" name="command" value="select">検索</button>
  </form>
  <br>
</body>