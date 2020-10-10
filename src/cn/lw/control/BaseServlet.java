package cn.lw.control;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.Method;

//@WebServlet(name = "BaseServlet")
public class BaseServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String handler=request.getParameter("handler");//handler就是方法名
        //要通过handler去获取方法

        //这里this代表子类。因为stu里面没有去声明doGet和doPost直接去继承父类了。
        try {//获取传递来的方法名
            Method method=this.getClass().getDeclaredMethod(handler, HttpServletRequest.class,HttpServletResponse.class);
            method.invoke(this, request, response);//实现这个方法
        } catch (NoSuchMethodException e) {
            throw new RuntimeException("无此方法："+handler+"\n Exception"+e);
        } catch (Exception e) {
            throw new RuntimeException("此方法："+this.getClass()+"."+handler+"\n 产生异常：Exception"+e);
        }
    }
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
         doPost(request,response);
    }
}
//反射