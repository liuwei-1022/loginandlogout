package cn.lw.control;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/Logout")
public class Logout extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Cookie[] userCookie=request.getCookies();//去出cookie

        if(userCookie!=null &&userCookie.length>0)
        {

            for(Cookie  c: userCookie){
                if(c.getName().equals("username")){

                    c.setMaxAge(0);////////////////////
                    response.addCookie(c);
                }
            }//for
        }//
        response.sendRedirect("/LoginAndLogout/index.jsp");
    }
}
