<%@ page language="java" contentType="text/html; charset=UTF-8"
  pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>更新内容入力画面</title>
<link href="css/commons.css" rel="stylesheet">
</head>
<body>
  <p>
    １箇所以上の項目を変更してください
  </p>

  <c:if test="${not empty errMsg}">
    <p class="error">${fn:escapeXml(errMsg)}</p>
  </c:if>

  <form action="updateInput" method="post">
    <fieldset>
      <div>
        <label>ID</label>
        <input type="text" name="loginId"
          value="${fn:escapeXml(sessionInfo.updateUser.loginId)}">
        <c:if test="${not empty idErrMsg}">
          <span class="error">${fn:escapeXml(idErrMsg)}</span>
        </c:if>
      </div>
      <div>
        <label>名前</label>
        <input type="text" name="userName"
          value="${fn:escapeXml(sessionInfo.updateUser.userName)}">
        <c:if test="${not empty nameErrMsg}">
          <span class="error">${fn:escapeXml(nameErrMsg)}</span>
        </c:if>
      </div>
      <div>
        <label>TEL</label>
        <input type="text" name="tel"
          value="${fn:escapeXml(sessionInfo.updateUser.telephone)}">
        <c:if test="${not empty telErrMsg}">
          <span class="error">${fn:escapeXml(telErrMsg)}</span>
        </c:if>
      </div>
      <div>
        <label>権限</label> <select name="roleId">
          <c:forEach var="role" items="${sessionInfo.roleList}">
            <option value="${fn:escapeXml(role.roleId)}"
              <c:if test="${sessionInfo.updateUser.roleId == role.roleId}">selected</c:if>>
              ${fn:escapeXml(role.roleName)}</option>
          </c:forEach>
        </select>
      </div>
      <div>
        <label>PASS</label>
        <input type="password" name="pass"
          value="${fn:escapeXml(sessionInfo.updateUser.password)}">
        <c:if test="${not empty passErrMsg}">
          <span class="error">${fn:escapeXml(passErrMsg)}</span>
        </c:if>
      </div>
    </fieldset>
    <div>
      <button type="submit">確認</button>
      <button type="submit"
        onclick="location.href='update.jsp'; return false;">戻る</button>
    </div>
  </form>
  <div>
    <a href="menu.jsp">メニューに戻る</a>
  </div>
</body>
</html>
