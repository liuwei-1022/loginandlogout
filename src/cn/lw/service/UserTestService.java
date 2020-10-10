package cn.lw.service;

import cn.lw.javaben.User;

import java.util.HashMap;
import java.util.Map;

/**
 *
 *  服务    登录   注册    注销
 *
 *
 */
public class UserTestService {
    /*    让   login  实现  服务层的  登录功能
    *
    *          返回值  ： 如果登陆失败 向map集合翻入 错误信息
    *                     如果登陆成功  什么都不放
    *
    *
    *
    * */
    public Map<String ,String> login(User user, String vCode, String sCode) {

        Map<String ,String>  info= new HashMap<String,String>();
        if(vCode.equalsIgnoreCase(sCode)==false){
            info.put("verifiError","验证码有误");
        }
        if("liuwei".equals(user.getUsername())==false){
            info.put("usernameError","用户名有误");
        }
        if("123".equals(user.getPassword())==false){
            info.put("passwordError","密码有误");
        }


        return info;
    }
}
