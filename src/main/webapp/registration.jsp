<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <fmt:setBundle basename = "message" var="ms"/>
    <title><fmt:message key = "REGISTRATION" bundle="${ms}"/></title>
</head>
<body>
<h2><fmt:message key = "REGISTER_PAGE" bundle="${ms}"/></h2>
<form action="/Controller" method="post" style=" display:  flex; flex-direction:  column; width: 30%;"
>
    <label><fmt:message key = "LOGIN_PLACEHOLDER" bundle="${ms}"/></label>
    <input type="email" name="email" placeholder="<fmt:message key = "LOGIN_PLACEHOLDER" bundle="${ms}"/>" required/>
    <label><fmt:message key = "PASSWORD_PLACEHOLDER" bundle="${ms}"/></label>
    <input type="password" name="password" placeholder="<fmt:message key = "PASSWORD_PLACEHOLDER" bundle="${ms}"/>" required/>
    <label><fmt:message key = "NAME" bundle="${ms}"/></label>
    <input type="text" name="name" placeholder="<fmt:message key = "NAME" bundle="${ms}"/>"/>
    <label><fmt:message key = "SURNAME" bundle="${ms}"/></label>
    <input type="text" name="surname" placeholder="<fmt:message key = "SURNAME" bundle="${ms}"/>"/>
    <input type="hidden" name="command" value="registerUser"/>
    <input type="submit" value="<fmt:message key = "REGISTRATION" bundle="${ms}"/>"/>
</form>
<a href="/Controller"><fmt:message key = "MAIN_PAGE" bundle="${ms}"/></a>
</body>
</html>
