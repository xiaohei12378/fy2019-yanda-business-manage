package com.neuedu.interceptors;

import com.neuedu.consts.Const;
import com.neuedu.dao.UserInfoMapper;
import com.neuedu.exception.MyException;
import com.neuedu.pojo.UserInfo;
import com.neuedu.service.IUserService;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class AuthorityInterceptor implements HandlerInterceptor {
    @Autowired
    IUserService userService;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws MyException, IOException {

        HttpSession session = request.getSession();

        /**
         * 从cookie中获取用户名和密码
         */
        Cookie[] cookies = request.getCookies();
        String username = null;
        String password = null;
        if (cookies != null && cookies.length > 0) {

            for (Cookie c : cookies) {
                // c -> name value
                if (c.getName().equals("username")) {
                    username = c.getValue();
                }
                if (c.getName().equals("password")) {
                    password = c.getValue();
                }

            }
        }
        if (username != null && password != null) {//根据用户名和密码自动登录
            UserInfo userInfo=new UserInfo();
            userInfo.setUsername(username);
            userInfo.setPassword(password);
            UserInfo userInfoLogin=userService.login(userInfo);
          //UserInfo userInfo=loginService.login(username,password);
            if (userInfoLogin != null) {//登录成功
                session.setAttribute(Const.CURRENT_USER,userInfoLogin);
                System.out.println("========================0===========================");
                return true;
            }
            if (session.getAttribute(Const.CURRENT_USER) != null) {
                System.out.println("=======================1============================");
                return true;
            }

        }
        System.out.println("======拦截==========");
        response.sendRedirect("/user/login");
        return false;
    }
}
