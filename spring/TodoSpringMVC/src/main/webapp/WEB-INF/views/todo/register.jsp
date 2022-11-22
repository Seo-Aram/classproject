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
        <link rel="stylesheet" type="text/css" href="/resources/css/list-group.css"/>
        <link rel="stylesheet" type="text/css" href="/resources/css/base.css"/>
        <link rel="stylesheet" type="text/css" href="/resources/bootstrap/css/bootstrap.min.css"/>
        <link rel="stylesheet" type="text/css" href="/resources/css/form.css"/>
    </head>
    <body>
    <%@include file="../parts/header.jsp"%>
        <%@include file="../parts/side.jsp"%>
        <div class="box">
            <div class="list-group w-auto">
            <main class="form-todo w-100 m-auto" style="max-width: 460px">
                <form action="/todo/register" method="post" id="register">
                    <h1 class="h3 mb-3 fw-normal">Add Todo</h1>

                    <div class="form-floating">
                        <input type="text" class="form-control" id="floatingTitle" placeholder="title" name="todo_title">
                        <label for="floatingTitle">todo</label>
                    </div>
                    <div class="form-floating">
                        <input type="date" class="form-control" id="floatingDate" placeholder="date" name="todo_date">
                        <label for="floatingDate">date</label>
                    </div>

                    <div class="checkbox mb-3">
                    </div>
                    <button class="w-100 btn btn-lg btn-primary" type="button" id="addTodo">등록</button>
                </form>
            </main>
            </div>
        </div>
        <%@include file="../parts/footer.jsp"%>
    </body>
    <script>
        document.addEventListener('DOMContentLoaded', () => {
            document.querySelector('#addTodo').addEventListener('click', (event) =>{
                const todoTitle = document.querySelector('#floatingTitle');
                const todoDate = document.querySelector('#floatingDate');

                if(todoTitle.value == '' || todoTitle.value.trim() == '') {
                    todoTitle.focus();
                    return;
                }

                if(todoDate.value == null || todoDate.value == '' || todoDate.value.trim() == '') {
                    todoDate.focus();
                    return;
                }

                document.querySelector('#register').submit();

            });
        });
    </script>
</html>
