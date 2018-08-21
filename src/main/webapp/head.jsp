<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<html>
<head>
    <fmt:setBundle basename = "message" var="ms"/>
</head>
<body>
<c:if test="${user == null}">
<div>
    <h1><fmt:message key = "CINEMA_PAGE" bundle="${ms}"/></h1>
    <div style="display: flex; flex-direction: row; grid-gap: 4px">
    <form style="display: block;" action="/Controller" method="get">
        <input type="hidden" name="command" value="login"/>
        <input type="submit" value="<fmt:message key = "LOGIN_BUTTON" bundle="${ms}"/>">
    </form>
    <form style="display: block;" action="/Controller" method="get">
        <input type="hidden" name="command" value="registration"/>
        <input type="submit" value="<fmt:message key = "REGISTRATION" bundle="${ms}"/>">
    </form>
    </div>
</div>
</c:if>
<c:if test="${user!=null}">
    <div><h1><fmt:message key = "LOGED_IN_MAIN_PAGE" bundle="${ms}"/> <c:choose>
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
            <input type="submit" value="<fmt:message key = "ACCOUNT_BUTTON" bundle="${ms}"/>">
        </form>
    </div>
    <div style="display: flex; flex-direction: row; grid-gap: 4px">
        <form style="display: block;" action="/Controller" method="get">
            <input type="hidden" name="command" value="logOut"/>
            <input type="submit" value="<fmt:message key = "LOG_OUT_BUTTON" bundle="${ms}"/>">
        </form>
    </div>
</c:if>
<div>
    <a href="/Controller?command=changeLocale&locale=ru">русский</a> |
    <a href="/Controller?command=changeLocale&locale=ua">українська</a> |
    <a href="/Controller?command=changeLocale&locale=en">english</a>
</div>
</body>
</html>
