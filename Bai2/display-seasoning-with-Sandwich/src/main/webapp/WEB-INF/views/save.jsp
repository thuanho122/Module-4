<%--
  Created by IntelliJ IDEA.
  User: thuanho
  Date: 09/02/2022
  Time: 02:52
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>List condiments</title>
</head>
<body>
<h3>List Condiments:</h3>
<ul>
    <c:forEach items="${requestScope.condiments}" var="c"><li>${c}</li></c:forEach>
</ul>
</body>
</html>
