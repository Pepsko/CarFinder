<%@ page import="application.car.CarDTO" %><%--
  Created by IntelliJ IDEA.
  User: Lenovo
  Date: 2018-03-27
  Time: 22:24
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>BrandSearch</title>
</head>
<body>

<c:forEach items="${brand}" var="item">
    <li>${item}</li><br>
</c:forEach>
</body>
</html>
