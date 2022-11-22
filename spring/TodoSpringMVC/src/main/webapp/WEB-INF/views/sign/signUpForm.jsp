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
      <title>Title</title>
  </head>
  <body>
    <form action="/sign/up" method="post" enctype="multipart/form-data">
      <table>
        <tr>
          <td>id</td>
          <td><input type="text" name="userId"/></td>
        </tr>

        <tr>
          <td>pw</td>
          <td><input type="password" name="password"/></td>
        </tr>

        <tr>
          <td>프로필</td>
          <td><input type="file" name="profileImg" accept=".gif, .jpg, .png"/></td>
        </tr>

        <tr>
          <td></td>
          <td><input type="submit" value="가입"/></td>
        </tr>
      </table>
    </form>
  </body>
</html>
