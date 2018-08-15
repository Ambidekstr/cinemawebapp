<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <title>Insert title here</title>
</head>
<body>
Sample login Example (try with username as "admin" and password as "admin" without quart ) <br> <br>
<form action="Controller" method="post">
  <input type="hidden" name="command" value="login">
  Enter username :<input type="text" name="username"> <br>
  Enter password :<input type="password" name="password"><br>
  <input type="submit" value="Login">
</form>
</body>
</html>
