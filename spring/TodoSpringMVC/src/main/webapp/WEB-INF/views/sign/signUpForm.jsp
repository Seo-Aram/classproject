<%--
  Created by IntelliJ IDEA.
  User: LG
  Date: 2022-11-22
  Time: 오전 9:50
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
      <title>회원가입</title>
      <link rel="stylesheet" type="text/css" href="/resources/bootstrap/css/bootstrap.min.css"/>
      <link rel="stylesheet" type="text/css" href="/resources/css/sign.css"/>
  </head>
  <body>

    <main class="form-signin w-100 m-auto">
      <form action="/sign/up" method="post" enctype="multipart/form-data">
        <h1 class="h3 mb-3 fw-normal">Sign Up</h1>

        <div class="form-floating">
          <input type="text" class="form-control" id="floatingInput" placeholder="UserID" name="user_id">
          <label for="floatingInput">ID</label>
        </div>
        <div class="form-floating">
          <input type="password" class="form-control" id="floatingPassword" placeholder="Password" name="password">
          <label for="floatingPassword">Password</label>
        </div>
        <div class="form-group">
          <label for="formFile" class="form-label mt-4">Profile Image</label>
          <input class="form-control" type="file" id="formFile" name="profileImg" accept=".gif, .jpg, .png">
        </div>

        <div class="mb-3">
        </div>

        <button class="w-100 btn btn-lg btn-primary" type="submit">Sign up</button>
        <p class="mt-5 mb-3 text-muted">&copy; 2022</p>
      </form>
    </main>
  </body>
</html>
