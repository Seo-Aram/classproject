<%--
  Created by IntelliJ IDEA.
  User: LG
  Date: 2022-11-22
  Time: 오후 12:16
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>MemberInfo</title>
</head>
    <body>
        <form>
            <table>
                <tr>
                    <td colspan="2">
                        <img src="/resources/profile/${loginInfo.profileUrl != '' ? loginInfo.profileUrl : "default.png"}"/>
                        <c:if test="${loginInfo.profileUrl != ''}">
                        </c:if>
                    </td>
                </tr>
                <tr>
                    <td>ID </td>
                    <td>${loginInfo.userId}</td>
                </tr>
            </table>
        </form>
    </body>
</html>
