<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Lena
  Date: 20.08.2018
  Time: 11:36
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Cinema</title>
</head>
<body>
<c:if test="${user == null}">
<div>
    <h1>Cinema</h1>
    <div style="display: flex; flex-direction: row; grid-gap: 4px">
    <form style="display: block;" action="/Controller" method="get">
        <input type="hidden" name="command" value="login"/>
        <input type="submit" value="Login">
    </form>
    <form style="display: block;" action="/Controller" method="get">
        <input type="hidden" name="command" value="registration"/>
        <input type="submit" value="Registration">
    </form>
    </div>
</div>
</c:if>
<c:if test="${user!=null}">
    <div><h1>Welcome, <c:choose>
    <c:when test="${user.name != null}">
        <c:out value="${user.name}"/>!
    </c:when>
    <c:when test="${user.name == null}">
        <c:out value="${user.login}"/>!
    </c:when>
</c:choose><c:if test="">!</c:if></h1>
    </div>
    <div style="display: flex; flex-direction: row; grid-gap: 4px">
        <form style="display: block;" action="/Controller" method="get">
            <input type="hidden" name="command" value="account"/>
            <input type="submit" value="Account">
        </form>
    </div>
</c:if>
</body>
</html>
