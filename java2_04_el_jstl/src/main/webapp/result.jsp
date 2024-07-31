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
<title>結果画面</title>
</head>
<body>
<div>
  <p>入力されたIDは<%= id %>でした。</p>
  <p>パスワードは
  <% if (passwordMatch.equals("ok")) { %>
    一致しました。
  <% } else { %>
    一致しませんでした。
  <% } %>
  </p>
</div>
</body>
</html>