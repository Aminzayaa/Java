<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert</title>
</head>
<body>
  <p>ユーザーを登録します。<br>ID、NAME、PASSを入力してください。</p>
  <form action="insert" method="post">
    ID <input type="text" name="id"><br>
    NAME <input type="text" name="name"><br>
    PASS <input type="text" name="pass"><br>
    <button type="submit">クエリ送信</button>
  </form>
</body>
</html>