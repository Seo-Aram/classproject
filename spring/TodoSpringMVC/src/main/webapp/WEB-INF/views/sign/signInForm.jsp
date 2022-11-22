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
        <link rel="stylesheet" type="text/css" href="/resources/bootstrap/css/bootstrap.min.css"/>
        <link rel="stylesheet" type="text/css" href="/resources/css/sign.css"/>
    </head>
    <body>
        <main class="form-signin w-100 m-auto">
            <form action="/sign/in" method="post" id="signin">
                <h1 class="h3 mb-3 fw-normal">Please sign in</h1>

                <div class="form-floating">
                    <input type="text" class="form-control" id="floatingInput" placeholder="UserID" name="user_id">
                    <label for="floatingInput">ID</label>
                </div>
                <div class="form-floating">
                    <input type="password" class="form-control" id="floatingPassword" placeholder="Password" name="password">
                    <label for="floatingPassword">Password</label>
                </div>

                <div class="checkbox mb-3">
                    <label>
                        <input type="checkbox" value="remember-me"> Remember me
                    </label>
                </div>
                <button class="w-100 btn btn-lg btn-primary" type="button" id="sign">Sign in</button>
                <p class="mb-3 text-muted"> <a href="/sign/up">Sign up</a> </p>
                <p class="mt-5 mb-3 text-muted">&copy; 2022</p>
            </form>
        </main>
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
    <script>
        document.addEventListener('DOMContentLoaded', () => {
            document.querySelector('#sign').addEventListener('click', (event) =>{
                const userId = document.querySelector('#floatingInput');
                const password = document.querySelector('#floatingPassword');

                if(userId.value == '' || userId.value.trim() == '') {
                    userId.focus();
                    return;
                }

                if(password.value == '' || password.value.trim() == '') {
                    password.focus();
                    return;
                }

                document.querySelector('#signin').submit();

            });
        });
    </script>
</html>
