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
            <form action="/Controller" method="post" sc >
            <td><c:out value="${sessionEntity.time}"/></td>
            <td><c:out value="${sessionEntity.film.filmName}"/></td>
            <td>

                    <%--<c:set var="sessionId" scope="session" value="${sessionEntity.sessionId}"/>--%>
                    <%--<c:set var="command" scope="session" value="buyTicket"/>--%>
                        <input type="hidden" name="command" value="buyTicket">
                        <input type="hidden" name="sessionId" value="${sessionEntity.sessionId}">
                    <input type="submit" value="Buy ticket">

            </td>
            </form>
        </tr>
    </c:forEach>
</table>
</body>
</html>