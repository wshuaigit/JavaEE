<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <form action="${pageContext.request.contextPath}/addstudent" method="post">
        姓名：<input type="text" name="name"><br>
        年龄：<input type="text" name="age"><br>
        <input type="submit" value="注册">
    </form>
</body>
</html>
