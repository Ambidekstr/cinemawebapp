<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<html>
<head>
    <fmt:setBundle basename = "message" var="ms"/>
    <title><fmt:message key = "TICKET_PAGE" bundle="${ms}"/></title>
    <style content="text/css">
        .table tbody tr td  {
        border: 0px;
        width: 1em;
        height:1em;
    }
        .table {
        border-spacing: 3em;
    }
    </style>
</head>
<body>
<form action="/Controller" method="post">
<table class="table">
    <thead>
    <tr>
        <th colspan="10"><h1><fmt:message key = "TICKET_PAGE" bundle="${ms}"/></h1></th>
    </tr>
    </thead>
    <tbody>
        <c:forEach items="${ticketList}" var="tickets">
            <tr>
                <c:forEach items="${tickets}" var="ticket">

                    <c:if test="${ticket.booked}">
                        <c:if test="${ticket.seat.seatRow < 5}">
                            <td style="background-color:indianred;">
                                <input type="checkbox" name="ticketId" value="${ticket.ticketId}" disabled/>
                            </td>
                        </c:if>
                    </c:if>
                    <c:if test="${!ticket.booked}">
                        <c:if test="${ticket.seat.seatRow < 5}">
                            <td style="background-color:green;">
                                <input type="checkbox" name="ticketId" value="${ticket.ticketId}"/>
                            </td>
                        </c:if>
                    </c:if>
                    <c:if test="${ticket.booked}">
                        <c:if test="${ticket.seat.seatRow == 5}">
                            <td class="lux" style="background-color:indianred;">
                                <input type="checkbox" name="ticketId" value="${ticket.ticketId}" disabled/>
                            </td>
                        </c:if>
                    </c:if>
                    <c:if test="${!ticket.booked}">
                        <c:if test="${ticket.seat.seatRow == 5}">
                            <td style="background-color:mediumpurple;">
                                <input type="checkbox" name="ticketId" value="${ticket.ticketId}"/>
                            </td>
                        </c:if>
                    </c:if>
                </c:forEach>
            </tr>
        </c:forEach>
    <c:if test="${user!=null}">
    <tr>
        <td colspan="10" align="center" >
            <input type="hidden" name="command" value="order">
            <input type="submit" value="<fmt:message key = "CHECKOUT_BUTTON" bundle="${ms}"/>"></td>
    </tr>
    </c:if>
    </tbody>
</table>
</form>
<a href="/Controller"><fmt:message key = "MAIN_PAGE" bundle="${ms}"/></a>
</body>
</html>