<%--
  Created by IntelliJ IDEA.
  User: LG
  Date: 2022-11-13
  Time: 오후 3:24
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
      <title>Login</title>
  </head>
  <body>
    <form action="/sign/signIn" method="post">
      <label>ID: </label> <input type="text" name="id"/>
      <label>Password: </label> <input type="password" name="password"/>
      <input type="submit" value="login"/>
    </form>
  </body>
</html>
