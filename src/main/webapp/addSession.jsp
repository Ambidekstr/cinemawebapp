<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Session</title>
</head>
<body>

<form action="/Controller" method="post" style=" display:  flex; flex-direction:  column; width: 30%;">
    <label>Choose the film</label>
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
    <label>Date</label>
    <input type="date" name="date" value="${session.date}" required/>
    <label>Time</label>
    <input type="time" name="time" value="${session.time}" required/>
    <c:if test="${session==null}">
        <input type="hidden" name="command" value="addNewSession"/>
    </c:if>
    <c:if test="${session!=null}">
        <input type="hidden" name="command" value="updateExistingSession"/>
    </c:if>
    <input type="submit" value="Save"/>
</form>
<a href="/Controller">Main page</a>
</body>
</html>
