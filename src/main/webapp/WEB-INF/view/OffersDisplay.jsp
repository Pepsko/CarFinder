<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%--
  Created by IntelliJ IDEA.
  User: Lenovo
  Date: 2018-05-09
  Time: 15:23
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form:form method="post" modelAttribute="carSpec">
<c:forEach items="${offers}" var="item"><button type="submit" name="offer" value="${item.key}">${item.value}<img src="${images.get(item.key)}"></button><br></c:forEach>
</form:form>

</body>
</html>
