<%--
  Created by IntelliJ IDEA.
  User: Lena
  Date: 20.08.2018
  Time: 11:37
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Login</title>
</head>
<body>
<h1>Please enter your Login and password</h1>
<form action="/Controller" method="post">
    <input type="email" name="username" placeholder="Email"/>
    <input type="password" name="password" placeholder="Password"/>
    <input type="hidden" name="command" value="loginUser"/>
    <input type="submit" value="Login"/>
</form>

</body>
</html>
