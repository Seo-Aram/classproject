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
    <link rel="stylesheet" type="text/css" href="/resources/css/base.css"/>
    <link rel="stylesheet" type="text/css" href="/resources/bootstrap/css/bootstrap.min.css"/>
    <link rel="stylesheet" type="text/css" href="/resources/css/list-group.css"/>
</head>
    <body>

    <%@include file="../parts/header.jsp"%>
    <%@include file="../parts/side.jsp"%>
        <div class="box">

            <div class="list-group w-auto">
<c:if test="${list == null || list.size() == 0}">
                <label class="list-group-item d-flex gap-3">
                    <span class="pt-1 form-checked-content">
                        <strong>No Data</strong>
                        <small class="d-block text-muted">
                            <svg class="bi me-1" width="1em" height="1em"><use xlink:href="#calendar-event"></use></svg>
                            -
                        </small>
                    </span>
                </label>
</c:if>
<c:forEach var="data" items="${list}">
                <label class="list-group-item d-flex gap-3">
                    <input class="form-check-input flex-shrink-0" disabled type="checkbox" value="${data.key}" ${data.finished ? "checked" : ""} style="font-size: 1.375em;">
                    <span class="pt-1 form-checked-content">
                        <strong><a href="/todo/modify?key=${data.key}">${data.title}</a></strong>
                        <small class="d-block text-muted">
                            <svg class="bi me-1" width="1em" height="1em"><use xlink:href="#calendar-event"></use></svg>
                            ${data.date}
                        </small>
                    </span>
                </label>
</c:forEach>
                <div class="row-cols-lg-3 d-flex p-3 flex-column bg-light" style="align-items: center;">
                    <div style="width:200px;">
                        <button class="w-100 btn btn-lg btn-primary" type="button" id="addTodo">Add Todo</button>
                    </div>
                </div>
            </div>
        </div>

        <%@include file="../parts/footer.jsp"%>
    </body>
<script>
    document.addEventListener('DOMContentLoaded', () => {
        document.querySelector('#addTodo').addEventListener('click', (event) =>{
            location.href = '/todo/register';
        });
    });
</script>
</html>
