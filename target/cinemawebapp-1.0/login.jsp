<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <fmt:setBundle basename = "message" var="ms"/>
    <title>Login</title>
</head>
<body>
<h1><fmt:message key = "LOGIN_PAGE" bundle="${ms}"/></h1>
<form action="/Controller" method="post">
    <input type="email" name="username" placeholder="<fmt:message key = "LOGIN_PLACEHOLDER" bundle="${ms}"/>"/>
    <input type="password" name="password" placeholder="<fmt:message key = "PASSWORD_PLACEHOLDER" bundle="${ms}"/>"/>
    <input type="hidden" name="command" value="loginUser"/>
    <input type="submit" value="<fmt:message key = "LOGIN_BUTTON" bundle="${ms}"/>"/>
</form>
<a href="/Controller"><fmt:message key = "MAIN_PAGE" bundle="${ms}"/></a>
</body>
</html>
