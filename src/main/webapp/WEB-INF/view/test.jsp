<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Lenovo
  Date: 2018-03-26
  Time: 19:28
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
zobaczmy czy teraz dziala

<form:form method="post" modelAttribute="carDTO">
    <form:input type="text" path="brand"/>
    <form:input type="text" path="model"/>
    <form:input type="text" path="horsePower"/>
    <form:input type="text" path="engine"/>
    <form:input type="text" path="productionYear"/>
    <form:input type="text" path="drivetrain"/>
    <form:input type="text" path="mileage"/>
    <form:input type="text" path="color"/>
    <input type="submit" name="submit" value="Add car">
</form:form>
<c:forEach items="${cars}" var="item">
    <li>${item}</li><br>
</c:forEach>
</body>
</html>
