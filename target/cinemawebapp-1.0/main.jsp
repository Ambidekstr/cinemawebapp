<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<html>
<head>
    <title>Cinema</title>
</head>
<body>
        <table>
        <c:forEach  items="${sessions}" var="session">
            <tr><c:out value="${session}"/> </tr>
        </c:forEach>
        </table>
</body>
</html>