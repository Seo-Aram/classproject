<%--
  Created by IntelliJ IDEA.
  User: LG
  Date: 2022-11-10
  Time: 오후 12:31
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
    <head>
        <title>Modify</title>
    </head>
    <body>
        <form action="/todo/modify" method="post">
            <input type="hidden" name="key" value="${data.key}"/>

            <input type="checkbox" name="finished" ${data.finished ? "checked" : ""}>
            <label>할 일 : </label> <input type="text" name="title" value="${data.title}"/> <br/>
            <label>날짜 : </label> <input type="date" name="date" value="${data.date}"/> <br/>
            <input type="submit" value="수정"/>
            <input type="button" value="삭제" onclick="location.href='/todo/remove?key=${data.key}'"/>
        </form>
    </body>
</html>
