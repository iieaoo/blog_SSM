package com.example.demo.common;

import com.example.demo.entity.Userinfo;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 * ClassName: UserSessionUtils
 * Package: com.example.demo.common
 * Description:
 *  和当前登录用户相关的操作
 * @Author 全家乐
 * @Create 2023/9/2 0:59
 * Version 1.0
 */
public class UserSessionUtils {
    //得到当前的登录用户
    public static Userinfo getUser(HttpServletRequest request) {
        HttpSession session = request.getSession(false);    //存在不管，不存在创建一个
        if (session!=null && session.getAttribute(AppVariable.USER_SESSION_KEY) != null) {
            //说明用户已经正常登录了
            return (Userinfo) session.getAttribute(AppVariable.USER_SESSION_KEY);
        }
        return null;
    }

}
