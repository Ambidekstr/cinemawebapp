<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: kmbs
  Date: 17-Aug-18
  Time: 5:33 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Order</title>
    <h1>Your order</h1>
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
<p>Total cost: <c:out value="${totalPrice}"/> UAH</p>
<input type="hidden" name="command" value="buy">
<input type="submit" value="Buy">
</body>
</form>
</html>
