<%--
  Created by IntelliJ IDEA.
  User: thuanho
  Date: 13/01/2022
  Time: 15:41
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <title>Dictionary</title>
</head>
<body>
<form action="run" >
  <label for="english">ENGLISH</label>
  <input type="text" id="english" name="word" placeholder="Nhập từ cần tìm"/>
  <input type="submit" value="Translate"/>
</form>
<h1>${res}</h1>
<h3>${message}</h3>
</body>
</html>
