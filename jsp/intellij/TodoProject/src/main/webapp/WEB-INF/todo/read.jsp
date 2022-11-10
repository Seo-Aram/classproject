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
        <title>READ</title>
    </head>
    <body>
        <form action="/remove" method="post">
            <input type="hidden" name="key" value="${data.key}">
            <label>할 일 : </label> <input type="text" disabled name="title" value="${data.title}"/> <br/>
            <label>날짜 : </label> <input type="date" disabled name="date" value="${data.date}"/> <br/>
            <button><a href="/modify?key=${data.key}">수정</a></button>
            <input type="submit" value="삭제"/>
        </form>
    </body>
</html>
