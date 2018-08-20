<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<html>
<head>
    <jsp:include page="head.jsp"/>
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
            <form action="/Controller" method="post">
                <td><c:out value="${sessionEntity.date}"/></td>
                <td><c:out value="${sessionEntity.time}"/></td>
                <td><c:out value="${sessionEntity.film.filmName}"/></td>
                <td>
                    <input type="hidden" name="command" value="buyTicket">
                    <input type="hidden" name="sessionId" value="${sessionEntity.sessionId}">
                    <input type="submit" value="Tickets">

                </td>
            </form>
        </tr>
    </c:forEach>
</table>
</body>
</html>