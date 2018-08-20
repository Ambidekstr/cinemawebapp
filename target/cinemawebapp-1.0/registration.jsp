<%--
  Created by IntelliJ IDEA.
  User: Lena
  Date: 20.08.2018
  Time: 13:45
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Registration</title>
</head>
<body>
<h2>Please enter your information</h2>
<form action="/Controller" method="post" style=" display:  flex; flex-direction:  column; width: 30%;"
>
    <label>Email</label>
    <input type="email" name="email" placeholder="Email" required/>
    <label>Password</label>
    <input type="password" name="password" placeholder="Password" required/>
    <label>Name</label>
    <input type="text" name="name" placeholder="Your first name"/>
    <label>Surname</label>
    <input type="text" name="surname" placeholder="Your last name"/>
    <input type="hidden" name="command" value="registerUser"/>
    <input type="submit" value="Register"/>
</form>

</body>
</html>
