<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Lenovo
  Date: 2018-04-20
  Time: 16:26
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Specification for search</title>
</head>
<body>
<form:form method="post" modelAttribute="carSpec">

    Brand :
    <form:select path="brand">
    <c:choose>
        <c:when test="${brand==null}">
            <c:forEach items="${brands}" var="item">
                <form:option value="${item.key}"/>
            </c:forEach>
        </c:when>
        <c:otherwise>
            <form:option value="${brand}"/>
        </c:otherwise>
    </c:choose>
    </form:select>
    <br>
    Model :
    <form:select path="model">
        <c:choose>
            <c:when test="${brand==null}">
                <form:option value="">Choose brand first</form:option>
            </c:when>
            <c:otherwise>
                <c:forEach items="${models}" var="item">
                    <form:option value="${item}"/>
                </c:forEach>
            </c:otherwise>
        </c:choose>
    </form:select>
    <br>
    Power from :
    <form:select path="powerFrom">
        <form:option value="">No bottom limit</form:option>
        <c:forEach var="i" begin="25" step="25" end="500">
            <form:option value="${i}">${i}hp</form:option>
        </c:forEach>
    </form:select>
     To :
    <form:select path="powerTo">
        <form:option value="">No limit</form:option>
        <c:forEach var="i" begin="50" step="25" end="500">
            <form:option value="${i}">${i}hp</form:option>
        </c:forEach>
    </form:select>
    <br>
    Body type :
    <form:select path="bodyType">
        <form:option value="Coupe"/>
        <form:option value="Sedan"/>
        <form:option value="Combi"/>
        <form:option value="Hatchback"/>
        <form:option value="Compact"/>
        <form:option value="">Any of above</form:option>
    </form:select>
    <br>
    Production year from :
    <form:select path="productionFrom">
        <form:option value="">No limit</form:option>
        <c:forEach var="i" begin="1960" end="2018">
            <form:option value="${i}"/>
        </c:forEach>
    </form:select>
    To :
    <form:select path="productionTo">
        <form:option value="">No limit</form:option>
        <c:forEach var="i" begin="1960" end="2018">
            <form:option value="${i}"/>
        </c:forEach>
    </form:select>
    <br>
    Drivetrain :
    <form:select path="drivetrain">
        <form:option value="AWD">AWD</form:option>
        <form:option value="RWD">RWD</form:option>
        <form:option value="FWD">FWD</form:option>
        <form:option value="">Any of above</form:option>
    </form:select>
    <br>
    Max mileage :
    <form:select path="mileageTo">
        <form:option value="">No limit</form:option>
        <c:forEach var="i" begin="100000" step="50000" end="1000000">
            <form:option value="${i}"/>
        </c:forEach>
    </form:select>
    <br>
    Color :
    <form:select path="color">
        <form:option value="Beige"/>
        <form:option value="Black"/>
        <form:option value="Blue"/>
        <form:option value="Brown"/>
        <form:option value="Burgundy"/>
        <form:option value="Gray"/>
        <form:option value="Green"/>
        <form:option value="Gold"/>
        <form:option value="Purple"/>
        <form:option value="Red"/>
        <form:option value="Silver"/>
        <form:option value="White"/>
        <form:option value="Yellow"/>
        <form:option value="">Other</form:option>
    </form:select>
    <br>
    <form:button type="submit" name="submit" value="brand">chose</form:button>

</form:form>
</body>
</html>
