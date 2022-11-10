<%--
  Created by IntelliJ IDEA.
  User: LG
  Date: 2022-11-10
  Time: 오후 12:09
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Todo List</title>
</head>
    <body>
        <table>
            <thead>
                <tr>
                    <th></th>
                    <th>제목</th>
                    <th>날짜</th>
                </tr>
            </thead>
            <tbody>
            <c:forEach var="data" items="${list}">
                <tr>
                    <td> <input type="checkbox" name="key" value="${data.key}"/> </td>
                    <td>
                        <a href="/read?key=${data.key}">
                            <c:out value="${data.title}"></c:out>
                        </a>
                    </td>
                    <td><c:out value="${data.date}"></c:out></td>
                </tr>
            </c:forEach>
            </tbody>
        </table>
        <a href="/register">할 일 등록</a>
    </body>
</html>
