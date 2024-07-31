<%@ page language="java" contentType="text/html; charset=UTF-8"
  pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ page import="jp.co.axiz.web.servlet.SessionInfo"%>

<c:if test="${empty sessionInfo.loginUser}">
  <c:redirect url="/index.jsp" />
</c:if>
<c:if test="${not empty sessionInfo}">
    ${sessionInfo.setRegisterUser(null)}
</c:if>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>メニュー画面</title>
<link href="css/commons.css" rel="stylesheet">
</head>
<body>
  <p>${fn:escapeXml(sessionInfo.loginUser.userName)}さん、こんにちは</p>

  <p>
    <a href="select.jsp">検索</a>
  </p>
  <c:if test="${sessionInfo.loginUser.isAdmin()}">
    <p>
      <a href="insert.jsp">登録</a>
    </p>
    <p>
      <a href="update.jsp">更新</a>
    </p>
    <p>
      <a href="delete.jsp">削除</a>
    </p>
  </c:if>
  <form action="logout" method="post">
    <button type="submit">ログアウト</button>
  </form>
</body>
</html>
