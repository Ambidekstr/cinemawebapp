<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <fmt:setBundle basename = "message" var="ms"/>
    <title>Admin Panel</title>
</head>
<body>

<table cellpadding="4">
    <tr>
        <th colspan="4"><h2><fmt:message key = "SESSIONS" bundle="${ms}"/></h2></th>
    </tr>
    <tr>
        <th><fmt:message key = "SESSION_DATE" bundle="${ms}"/></th>
        <th><fmt:message key = "SESSION_TIME" bundle="${ms}"/></th>
        <th><fmt:message key = "SESSION_FILM" bundle="${ms}"/></th>
    </tr>
    <c:forEach items="${sessionList}" var="sessionEntity">
    <tr>
        <td><c:out value="${sessionEntity.date}"/></td>
        <td><c:out value="${sessionEntity.time}"/></td>
        <td><c:out value="${sessionEntity.film.filmName}"/></td>
        <td>
            <form action="/Controller" method="post">
                <input type="hidden" name="command" value="deleteSession">
                <input type="hidden" name="sessionId" value="${sessionEntity.sessionId}">
                <input type="submit" value="<fmt:message key = "DELETE_BUTTON" bundle="${ms}"/>">
            </form>
        </td>
        <td>
            <form action="/Controller" method="get">
                <input type="hidden" name="command" value="buyTicket">
                <input type="hidden" name="sessionId" value="${sessionEntity.sessionId}">
                <input type="submit" value="<fmt:message key = "SESSION_TICKETS" bundle="${ms}"/>">
            </form>
        </td>
    </tr>
    </c:forEach>
</table>
<form action="/Controller" method="get">
    <input type="hidden" name="command" value="addSession">
    <input type="submit" value="<fmt:message key = "ADD_NEW_SESSION_BUTTON" bundle="${ms}"/>">
</form>
</body>
<a href="/Controller"><fmt:message key = "MAIN_PAGE" bundle="${ms}"/></a>
</html>
