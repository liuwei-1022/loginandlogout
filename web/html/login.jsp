<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2020/9/29
  Time: 8:38
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="UTF-8">
    <title>注册</title>
    <style>
        @import  "${pageContext.request.contextPath}/css/login.css";
    </style>
</head>
<body id="register" >
<div  class="lay_out">
    <div class="rg_left">
        <p> 欢迎登陆</p>
        <p>WELCOME</p>
    </div>
    <div class="rg_center">
        <form action="/LoginAndLogout/UserTestServlet?handler=login"  method="post">
            <table>
                <tr>
                    <td class="td_left">用户名</td>
                    <td class="td_right"><input  type="text" name="username"  value="${username}" id="username" placeholder="请输入用户名"></td>
                    <td class="td_right">${error.usernameError} </td>
                </tr>
                <tr>
                    <td class="td_left">密码</td>
                    <td class="td_right"><input  type="password" name="password"  id="password" placeholder="请输入密码" ></td>
                    <td class="td_right">${error.passwordError} </td>
                </tr>
                <tr>
                    <td class="td_left">验证码</td>
                    <td class="td_right"><input  type="text" name="verification"  id="verification" placeholder="请输入验证码" ></td>
                    <td class="td_right">${error.verifiError} </td>
                </tr>
                <tr>
                    <td  colspan="2" class="td_left">
                        <img src="${pageContext.request.contextPath}/UserTestServlet?handler=vCode">
                        
                    </td>
                    <td>
                        <a href="${pageContext.request.contextPath}/html/login.jsp"> 看不清？换一张</a>

                    </td>
                </tr>

                <tr>
                    <td colspan="2" align="center"><input type="submit" value="登录" id="submit"></td>
                </tr>
            </table>

        </form>
    </div>


</div>


</body>
</html>
