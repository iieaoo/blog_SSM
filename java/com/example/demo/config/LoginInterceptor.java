package com.example.demo.config;

import com.example.demo.common.AppVariable;
import com.example.demo.entity.Userinfo;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * ClassName: LoginIntercept
 * Package: com.example.demo.config
 * Description:
 *
 * @Author 全家乐
 * @Create 2023/8/31 17:26
 * Version 1.0
 */
public class LoginInterceptor implements HandlerInterceptor {
    /*
    * true -> 用户已登录
    * false -> 用户未登录
    * */
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        HttpSession session = request.getSession(false);    //false:有session就取，没有不强求
        if (session != null && session.getAttribute(AppVariable.USER_SESSION_KEY) != null) {
            //用户已登录
            System.out.println("当前登录用户为：" +
                    ((Userinfo) session.getAttribute(AppVariable.USER_SESSION_KEY)).getUsername());
            return true;
        }
        //跳转到登录页面
        response.sendRedirect("/login.html");
        return false;
    }
}
