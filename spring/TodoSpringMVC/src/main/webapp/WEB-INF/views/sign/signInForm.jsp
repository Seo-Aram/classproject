<%--
  Created by IntelliJ IDEA.
  User: LG
  Date: 2022-11-21
  Time: 오후 11:48
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Login</title>
</head>
<body>
<form method="post" action="/sign/in">
    <table>
        <tr>
            <td>ID: </td>
            <td><input type="text" name="user_id"/> <br/></td>
        </tr>
        <tr>
            <td>PW: </td>
            <td><input type="password" name="password"/></td>
        </tr>
        <tr>
            <td><input type="submit" value="login"></td>
            <td></td>
        </tr>
        <tr>
            <td colspan="2"><a href="/sign/up">회원가입</a></td>
        </tr>
    </table>
</form>
</body>
<c:if test="${param.result=='l'}">
    <script>
        alert("id와 비밀번호를 확인해주세요.");
    </script>
</c:if>
<c:if test="${param.result=='ups'}">
    <script>
        alert("회원가입에 성공하였습니다.");
    </script>
</c:if>
</html>
