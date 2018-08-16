<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<html>
<head>
    <title>Cinema</title>
    <link rel="stylesheet" type="text/css" href="<c:url value="style.css"/>"/>
</head>
<body>
<div>
    <form action="/" method="post">
        <input type="hidden" name="command" value="search"/>
        <label>
            <input type="search" name="search"/>
        </label>
        <input type="submit" value="search"/>
    </form>
</div>
<div>
    <div>
        <table>
        <c:forEach items="${sessions}" var="sessions">
            <tr><c:out value="${sessions}"/> </tr>
        </c:forEach>
        </table>
    </div>
</div>
</body>
</html>