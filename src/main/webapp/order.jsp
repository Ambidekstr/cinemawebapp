<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <fmt:setBundle basename = "message" var="ms"/>
    <title>Order</title>
    <h1><fmt:message key = "ORDER_PAGE" bundle="${ms}"/></h1>
</head>
<form action="/Controller" method="post">
<body>
<c:forEach items="${ticketForOrder}" var="ticket">
    <table border="1">
        <thead align="center">
        <tr>
            <td colspan="2" ><c:out value="${ticket.session.film.filmName}"/></td>
        </tr>
        </thead>
        <tbody>
        <tr>
            <td><fmt:message key = "TIME_DATE" bundle="${ms}"/></td>
            <td>
                <c:out value="${ticket.session.time}"/><br/>
                <c:out value="${ticket.session.date}"/>
            </td>
        </tr>
        <tr>
            <td><fmt:message key = "SEAT" bundle="${ms}"/></td>
            <td>
                <fmt:message key = "ROW" bundle="${ms}"/> <c:out value="${ticket.seat.seatRow}"/><br/>
                <fmt:message key = "PLACE" bundle="${ms}"/> <c:out value="${ticket.seat.seatPlace}"/>
            </td>
        </tr>
        <tr>
            <td><fmt:message key = "PRICE" bundle="${ms}"/></td>
            <td>
                <c:out value="${ticket.seat.seatCategory.price}"/> UAH
            </td>
        </tr>
        </tbody>
    </table>
<input type="hidden" name="ticketId" value="${ticket.ticketId}">
</c:forEach>
<p><fmt:message key = "TOTAL_COST" bundle="${ms}"/>: <c:out value="${totalPrice}"/> <fmt:message key = "CURRENCY" bundle="${ms}"/></p>
<input type="hidden" name="command" value="buy">
<input type="submit" value="<fmt:message key = "BUY_BUTTON" bundle="${ms}"/>">
</body>
</form>
<a href="/Controller"><fmt:message key = "MAIN_PAGE" bundle="${ms}"/></a>
</html>
