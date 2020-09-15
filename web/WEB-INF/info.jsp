<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2020/9/15
  Time: 11:04
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
       注册成功 <br>
       用户名：${requestScope.user.username}<br>
       密码：${requestScope.user.password}<br>
       性别：${requestScope.user.sex}<br>
       生日：${requestScope.user.birthday}<br>
</body>
</html>
