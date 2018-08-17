<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<html>
<head>
    <title>Cinema</title>
</head>
<body>

<table>
    <tr>
        <th>Time</th>
        <th>Film</th>
        <th>Tickets</th>
    </tr>
    <c:forEach items="${sessionList}" var="sessionEntity">
        <tr>
            <td><c:out value="${sessionEntity.time}"/></td>
            <td><c:out value="${sessionEntity.film.filmName}"/></td>
            <td>
                <form action="/Controller" method="post" sc >
                    <c:set var="sessionId" scope="session" value="${sessionEntity.sessionId}"/>
                    <c:set var="command" scope="session" value="buyTicket"/>
                    <input type="submit" value="Buy ticket">
                </form>
            </td>
        </tr>
    </c:forEach>
</table>
</body>
</html>