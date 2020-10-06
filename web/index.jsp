<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2020/9/15
  Time: 9:22
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>$Title$</title>
      <style>
          @import "css/base.css";
          div{
              color:darkgrey;
              width: 100px;
              float: right;
              word-wrap: break-word;
              word-break: break-all;
              overflow: hidden;
          }

      </style>
  </head>

  <body>
       <h1 class="title1" id="title1">javaWeb的基础</h1>
       <%
           String  username=null;
           Cookie[] userCookie=request.getCookies();//去出cookie
           if(userCookie!=null &&userCookie.length>0)
           {
               for(Cookie  c: userCookie){
                   if(c.getName().equals("username")){
                       username= c.getValue();
                   }
               }//for
           }// 查找cookie中 是否有 username的Cookie
       %>

       <%   if(username ==null)   { %>
       <a class="link1" href="/LoginAndLogout/html/register.html">注册</a>
       <a class="link1" href="/LoginAndLogout/html/login.jsp">登录</a>
       <%} else{%>
       <div>亲爱的<%=username%>欢迎登陆
       <a class="link" href="/LoginAndLogout/Logout">注销</a>
       </div>

       <%}%>

       <h1>  Cookie</h1>
       Cookie是会话技术的一种。我们需要记录之前的的对话信息,例如用户信息用户名和密码。当然用户的密码保存在Cookie中是不安全的，这就用到Session技术，后面会涉及到。
       <br>Cookie技术是属于客户端（浏览器）保存信息的技术。它的基本原理是服务器相应的时候讲键值信息传递给浏览器，浏览器下次请求的时候将信息传递给服务器，服务器得到信息后可以确定客户端的身份。
       <br>  <img src="img/Cookie.png">
       <br>  <img src="img/cookie1.png" alt="aaaa">
       <br>  <img src="img/cookie3.png">

       <h1>  Session</h1>
       <br>  <img src="img/Session1.png">
       <br>  <img src="img/Session2.png">
       <br>  <img src="img/session3.png">
       <br>  <img src="img/session4.png">

  </body>
</html>
