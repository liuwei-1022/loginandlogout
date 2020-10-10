package cn.lw.control;

import cn.dsna.util.images.ValidateCode;
import cn.lw.javaben.User;
import cn.lw.service.UserTestService;
import org.apache.commons.beanutils.BeanUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.Map;

@WebServlet("/UserTestServlet")
public class UserTestServlet extends BaseServlet {
    private UserTestService us;

    /*
    *    让该类继承BaseServlet ，然后只需要写相应的控制代码即可，不需要
    *    编写 doGet  和  doPost方法   ：因为 父类已经写好  根据java 的机制
    *    如果本类没有 就会执行父类的。
    *
    *
    * */
    {
        us= new UserTestService();
    }
    public  void  login(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException {

        Map<String, String[]> parameterMap = request.getParameterMap();
        User user = new User();
        try {
            BeanUtils.populate(user, parameterMap);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
        String vCode = request.getParameter("verification");  //获得用户的验证码/////////
        String sCode = (String) request.getSession().getAttribute("VCcode");   //  从session域中提取信息 <重点>
        Map<String ,String >info=us.login(user, vCode, sCode);
        if(info.isEmpty()){
            //登陆成功
                request.getSession().setAttribute("username",user.getUsername());
                response.sendRedirect("/LoginAndLogout/index.jsp");

        }else {
            //登陆失败 : 通过请求转发的形式跳转到登陆界面 斌告知用户错误信息
             request.setAttribute("error",info);
             request.setAttribute("username",user.getUsername());
             request.getRequestDispatcher("html/login.jsp").forward(request,response);
        }


    }
       /*


    }

    /**
     *   生成验证码
     * @param request
     * @param response
     */
        public void vCode (HttpServletRequest request, HttpServletResponse response) throws IOException {
            ValidateCode vc = new ValidateCode(150, 50, 4, 100);
            String code = vc.getCode();
            HttpSession session = request.getSession();  //获得会话链接Session的方式  <重点>
            session.setAttribute("VCcode", code);    // 将数据放到session域中   <重点>
            vc.write(response.getOutputStream());     //  JSESSIONID会自动传递给浏览器，默认 关闭浏览器JSESSIONID消失


        }

    }


