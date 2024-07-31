<%@ page language="java" contentType="text/html; charset=UTF-8"
  pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>トップ画面</title>
</head>
<body>
  <h2>検索条件を入力してください</h2>
  <c:if test="${not empty msg}">
    <p>${msg}</p>
  </c:if>
  <form action="ProductServlet" method="post">
    <label>product_id:</label>
    <input type="number" name="productId" value="${param.productId}">
    <br>
    <button type="submit" name="command" value="select">検索</button>
  </form>
  <br>
</body>