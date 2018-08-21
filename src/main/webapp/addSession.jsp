<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <fmt:setBundle basename = "message" var="ms"/>
    <title>Session</title>
</head>
<body>
<h1><fmt:message key = "ADD_NEW_SESSION_PAGE" bundle="${ms}"/></h1>
<form action="/Controller" method="post" style=" display:  flex; flex-direction:  column; width: 30%;">
    <label><fmt:message key = "CHOOSE_THE_FILM" bundle="${ms}"/></label>
    <select name="selectedFilm" required>
        <c:forEach items="${films}" var="film">
            <c:if test="${session.film.filmId==film.filmId}">
                <option value="${film.filmId}" selected><c:out value="${film.filmName}"/></option>
            </c:if>
            <c:if test="${session.film.filmId!=film.filmId}">
                <option value="${film.filmId}"><c:out value="${film.filmName}"/></option>
            </c:if>
        </c:forEach>
    </select>
    <label><fmt:message key = "SESSION_DATE" bundle="${ms}"/></label>
    <input type="date" name="date" value="${session.date}" required/>
    <label><fmt:message key = "TIME_ADD_NEW_SESSION_PAGE" bundle="${ms}"/></label>
    <input type="time" name="time" value="${session.time}" required/>
    <c:if test="${session==null}">
        <input type="hidden" name="command" value="addNewSession"/>
    </c:if>
    <c:if test="${session!=null}">
        <input type="hidden" name="command" value="updateExistingSession"/>
    </c:if>
    <input type="submit" value="<fmt:message key = "SAVE_BUTTON" bundle="${ms}"/>"/>
</form>
<a href="/Controller"><fmt:message key = "MAIN_PAGE" bundle="${ms}"/></a>
</body>
</html>
