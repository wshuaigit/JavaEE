
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>$Title$</title>
  </head>
  <body>
        index.jsp<br>
        <a href="test/some.do">发起get方式的请求</a><br>
        <br>
        <form action="test/other.do" method="post">
            学号：<input type="text" name="username"><br>
            <input type="submit" value="登录">
        </form>
  </body>
</html>
