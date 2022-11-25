<%--
  Created by IntelliJ IDEA.
  User: LG
  Date: 2022-11-17
  Time: 오후 12:55
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
    <head>
        <title>Title</title>
    </head>
    <body>
        <form method="post" action="/login">
            <label>ID : </label> <input type="text" name="uid"><br/>
            <label>PW : </label> <input type="password" name="pw">
            <input type="submit" value="login">
        </form>
    </body>
</html>
