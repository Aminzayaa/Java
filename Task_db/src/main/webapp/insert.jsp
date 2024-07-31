<%@ page language="java" contentType="text/html; charset=UTF-8"
  pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>登録画面</title>
<link href="css/commons.css" rel="stylesheet">
</head>
<body>
  <p>
    登録情報を入力してください<br> <span class="required"></span>は必須です
  </p>

  <c:if test="${not empty errMsg}">
    <p class="error">${fn:escapeXml(errMsg)}</p>
  </c:if>

  <form action="insert" method="post">
    <fieldset class="label-60">
      <div>
        <label class="required">ID</label>
        <input type="text" name="loginId"
          value="${fn:escapeXml(sessionInfo.registerUser.loginId)}">
        <c:if test="${not empty idErrMsg}">
          <span class="error">${fn:escapeXml(idErrMsg)}</span>
        </c:if>
      </div>
      <div>
        <label class="required">名前</label>
        <input type="text" name="userName"
          value="${fn:escapeXml(sessionInfo.registerUser.userName)}">
        <c:if test="${not empty nameErrMsg}">
          <span class="error">${fn:escapeXml(nameErrMsg)}</span>
        </c:if>
      </div>
      <div>
        <label class="required">TEL</label>
        <input type="text" name="tel"
          value="${fn:escapeXml(sessionInfo.registerUser.telephone)}">
        <c:if test="${not empty telErrMsg}">
          <span class="error">${fn:escapeXml(telErrMsg)}</span>
        </c:if>
      </div>
      <div>
        <label class="required">権限</label> <select name="roleId">
          <c:forEach var="role" items="${sessionInfo.roleList}">
            <option value="${fn:escapeXml(role.roleId)}"
              <c:choose>
                <c:when test="${not empty sessionInfo.registerUser}">
                  <c:if test="${sessionInfo.registerUser.roleId == role.roleId}">selected</c:if>
                </c:when>
                <c:otherwise>
                  <c:if test="${role.roleId == 2}">selected</c:if>
                </c:otherwise>
              </c:choose>>
              ${fn:escapeXml(role.roleName)}</option>
          </c:forEach>
        </select>
      </div>
      <div>
        <label class="required">PASS</label>
        <input type="password" name="pass"
          value="${fn:escapeXml(sessionInfo.registerUser.password)}">
        <c:if test="${not empty passErrMsg}">
          <span class="error">${fn:escapeXml(passErrMsg)}</span>
        </c:if>
      </div>
    </fieldset>
    <button type="submit">確認</button>
  </form>
  <div>
    <a href="menu.jsp">メニューに戻る</a>
  </div>
</body>
</html>
