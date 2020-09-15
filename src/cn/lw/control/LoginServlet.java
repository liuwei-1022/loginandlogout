package cn.lw.control;

        import cn.lw.javaben.User;
        import org.apache.commons.beanutils.BeanUtils;
        import org.apache.commons.beanutils.ConvertUtils;
        import org.apache.commons.beanutils.Converter;
        import org.apache.commons.beanutils.locale.converters.DateLocaleConverter;

        import javax.servlet.ServletException;
        import javax.servlet.annotation.WebServlet;
        import javax.servlet.http.HttpServlet;
        import javax.servlet.http.HttpServletRequest;
        import javax.servlet.http.HttpServletResponse;
        import java.io.IOException;
        import java.lang.reflect.InvocationTargetException;
        import java.text.ParseException;
        import java.text.SimpleDateFormat;
        import java.util.Date;
        import java.util.Map;

@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Map<String, String[]> parameterMap = request.getParameterMap();
        User user=new User();
        try {
            ConvertUtils.register(new Converter() {
                @Override
                public Object convert(Class clazz, Object value) {
                    //将String转化为date
                    SimpleDateFormat format=new SimpleDateFormat("yyyy-MM-dd");
                    Date parse=null;
                    try {

//parse()返回的是一个Date类型数据，format返回的是一个StringBuffer类型的数据

                        parse =format.parse(value.toString());
                    } catch (ParseException e) {

                        e.printStackTrace();
                    }
                    return parse;
                }
            }, Date.class);
            BeanUtils.populate(user,parameterMap);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
        request.setAttribute("user",user);
        request.getRequestDispatcher("/WEB-INF/info.jsp").forward(request,response);

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
