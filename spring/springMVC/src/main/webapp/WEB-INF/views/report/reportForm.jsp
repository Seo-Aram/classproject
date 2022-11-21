<%--
  Created by IntelliJ IDEA.
  User: LG
  Date: 2022-11-21
  Time: 오후 2:40
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
    <head>
        <title>Title</title>
    </head>
    <body>
        <h1>Result1</h1>
        <form action  ="/report/submit1" method="post" enctype="multipart/form-data">
            <input type="file" name="report"/>
            <input type="submit" value="result1"/>
        </form>
        <hr/>
        <hr/>


        <h1>Result2</h1>
        <form action  ="/report/submit2" method="post" enctype="multipart/form-data">
            <input type="file" name="report"/>
            <input type="submit" value="result2"/>
        </form>
        <hr/>
        <hr/>


        <h1>Result3</h1>
        <form action  ="/report/submit3" method="post" enctype="multipart/form-data">
            <input type="file" name="report"/>
            <input type="submit" value="result3"/>
        </form>
        <hr/>
        <hr/>
    </body>
</html>
