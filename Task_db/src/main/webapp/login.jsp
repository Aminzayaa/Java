<%@ page language="java" contentType="text/html; charset=UTF-8"
  pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>ログイン画面</title>
<link href="css/commons.css" rel="stylesheet">
</head>
<body>
  <c:if test="${not empty errMsg}">
    <p class="error">${fn:escapeXml(errMsg)}</p>
  </c:if>

  <form action="login" method="post">
    <fieldset>
      <div>
        <label>ID</label>
        <input type="text" name="loginId"
          value="${fn:escapeXml(param.loginId)}">
        <c:if test="${not empty idErrMsg}">
          <span class="error">${fn:escapeXml(idErrMsg)}</span>
        </c:if>
      </div>
      <div>
        <label>PASS</label>
        <input type="password" name="pass"
          value="${fn:escapeXml(param.pass)}">
        <c:if test="${not empty passErrMsg}">
          <span class="error">${fn:escapeXml(passErrMsg)}</span>
        </c:if>
      </div>
    </fieldset>
    <button type="submit">ログイン</button>
  </form>
  <div>
    <a href="index.jsp">TOP画面に戻る</a>
  </div>
</body>
</html>
