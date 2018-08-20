<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Account</title>
</head>
<body>
<h1>Your tickets</h1>
<c:forEach items="${userTickets}" var="ticket">
    <table border="1">
        <thead align="center">
        <tr>
            <td colspan="2" ><c:out value="${ticket.session.film.filmName}"/></td>
        </tr>
        </thead>
        <tbody>
        <tr>
            <td>Time&Date</td>
            <td>
                <c:out value="${ticket.session.time}"/><br/>
                <c:out value="${ticket.session.date}"/>
            </td>
        </tr>
        <tr>
            <td>Seat</td>
            <td>
                Row <c:out value="${ticket.seat.seatRow}"/><br/>
                Place <c:out value="${ticket.seat.seatPlace}"/>
            </td>
        </tr>
        <tr>
            <td>Price</td>
            <td>
                <c:out value="${ticket.seat.seatCategory.price}"/> UAH
            </td>
        </tr>
        </tbody>
    </table>
    <input type="hidden" name="ticketId" value="${ticket.ticketId}">
</c:forEach>
</body>
<a href="/Controller">Main page</a>
</html>
