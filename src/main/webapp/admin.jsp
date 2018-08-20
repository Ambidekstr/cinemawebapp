<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

<table cellpadding="4">
    <tr>
        <th colspan="4"><h2>Sessions</h2></th>
    </tr>
    <tr>
        <th>Date</th>
        <th>Time</th>
        <th>Film</th>
        <th>Tickets</th>
    </tr>
    <c:forEach items="${sessionList}" var="sessionEntity">
    <tr>
        <td><c:out value="${sessionEntity.date}"/></td>
        <td><c:out value="${sessionEntity.time}"/></td>
        <td><c:out value="${sessionEntity.film.filmName}"/></td>
        <td>
            <form action="/Controller" method="post">
                <input type="hidden" name="command" value="updateSession">
                <input type="hidden" name="sessionId" value="${sessionEntity.sessionId}">
                <input type="submit" value="Update">
            </form>
        </td>
        <td>
            <form action="/Controller" method="get">
                <input type="hidden" name="command" value="buyTicket">
                <input type="hidden" name="sessionId" value="${sessionEntity.sessionId}">
                <input type="submit" value="Tickets">
            </form>
        </td>
    </tr>
    </c:forEach>
</table>
<form action="/Controller" method="get">
    <input type="hidden" name="command" value="addSession">
    <input type="submit" value="Add new Session">
</form>
</body>
</html>
