<%@ page language="java" contentType="text/html; charset=UTF-8"
  pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>削除確認画面</title>
<link href="css/commons.css" rel="stylesheet">
</head>
<body>
  <p>これでよろしいですか？</p>

  <form action="deleteConfirm" method="post">
    <fieldset>
      <div>
        <label>ID</label>
        <input type="text" name="loginId"
          value="${fn:escapeXml(deleteUser.loginId)}" readonly>
      </div>
      <div>
        <label>名前</label>
        <input type="text" name="userName"
          value="${fn:escapeXml(deleteUser.userName)}" readonly>
      </div>
      <div>
        <label>TEL</label>
        <input type="text" name="tel"
          value="${fn:escapeXml(deleteUser.telephone)}" readonly>
      </div>
      <div>
        <label>権限</label>
        <input type="text" name="roleName"
          value="${fn:escapeXml(deleteUser.roleName)}" readonly>
      </div>
      <input type="hidden" name="userId"
        value="${fn:escapeXml(deleteUser.userId)}" />
    </fieldset>
    <div>
      <button type="submit">削除</button>
      <button type="submit"
        onclick="location.href='delete.jsp'; return false;">戻る</button>
    </div>
  </form>
  <div>
    <a href="menu.jsp">メニューに戻る</a>
  </div>
</body>
</html>
