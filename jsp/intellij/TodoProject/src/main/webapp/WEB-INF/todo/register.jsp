<%--
  Created by IntelliJ IDEA.
  User: LG
  Date: 2022-11-10
  Time: 오후 12:31
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
    <head>
        <title>Register</title>
    </head>
    <body>
        <h1>Todo List 작성</h1>
        <form method="post" action="/register">
            <label>할 일 : </label> <input type="text" name="title"/> <br/>
            <label>날짜 : </label> <input type="date" name="date"/> <br/>
            <input type="submit" value="등록"/>
        </form>
    </body>
</html>
