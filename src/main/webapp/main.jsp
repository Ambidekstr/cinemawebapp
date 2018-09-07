<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<html>
<head>
    <fmt:setBundle basename = "message" var="ms"/>
    <jsp:include page="head.jsp"/>
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
        <th><fmt:message key = "SESSION_TICKETS" bundle="${ms}"/></th>
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
                    <input type="submit" value="<fmt:message key = "SESSION_TICKETS" bundle="${ms}"/>">

                </td>
            </form>
        </tr>
    </c:forEach>
    <tr>
        <td colspan="2" align="center">
            <c:if test="${previousPage>0}">
                <a href="/Controller?command=previousPage"><fmt:message key = "PREVIOUS" bundle="${ms}"/></a>
            </c:if>
        </td>
        <td colspan="2" align="center">
            <c:if test="${!empty sessionList}">
                <a href="/Controller?command=nextPage"><fmt:message key = "NEXT" bundle="${ms}"/></a>
            </c:if>
        </td>
    </tr>
</table>
</body>
</html>