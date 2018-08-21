<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <fmt:setBundle basename = "message" var="ms"/>
    <title>Error</title>
</head>
<body>
<h1><fmt:message key = "ERROR_PAGE" bundle="${ms}"/></h1>
<a href="/Controller"><fmt:message key = "BACK_TO_SAFETY_BUTTON" bundle="${ms}"/></a>
</body>
</html>
