package com.neuedu.controller;

import com.neuedu.consts.Const;
import com.neuedu.pojo.UserInfo;
import com.neuedu.service.IUserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.UnsupportedEncodingException;
import java.util.List;

@Controller
@RequestMapping("/user/")
public class UserController {

    @Autowired
    IUserService userService;

    /**
     *
     *用户登录
     *
     **/
   @RequestMapping(value = "/login",method = RequestMethod.GET)
   public  String login(){
    return "login";
   }
    @RequestMapping(value = "/login",method = RequestMethod.POST)
    public  String login(UserInfo userInfo, HttpSession session, HttpServletResponse response, HttpServletRequest request){

        UserInfo loginUserInfo =userService.login(userInfo);


        if (loginUserInfo!=null) {

            Cookie username_cookie=new Cookie("username",loginUserInfo.getUsername());
            Cookie password_cookie=new Cookie("password",loginUserInfo.getPassword());
            username_cookie.setMaxAge(60*60*24*7);
           password_cookie.setMaxAge(60*60*24*7);

           response.addCookie(username_cookie);
           response.addCookie(password_cookie);

            session.setAttribute(Const.CURRENT_USER,loginUserInfo);
            return "home/home";
        }
        else {
            System.out.println("============啊啊=======");
            return "login";
        }
    }



    /**
     *
     *用户列表
     *
     **/
    @RequestMapping("find")
    public  String findAll(HttpSession session){
        List<UserInfo> userInfoList =userService.findAll();

        session.setAttribute("userInfolist",userInfoList);
        return "user/usermss";
    }
    /**
     *
     * 添加用户
     *
     */

    @RequestMapping(value = "add",method = RequestMethod.GET)
    public  String add( ){


        return "user/useradd";

    }

    @RequestMapping(value = "add",method = RequestMethod.POST)
    public  String add( UserInfo userInfo){
        int count= userService.addUser(userInfo);
        if (count>0)
            System.out.println("chenggong");
        else
            System.out.println("shibai");

        return "redirect: /user/find";
    }



    /**
     *
     *用户删除
     */

    @RequestMapping(value = "find/{id}",method = RequestMethod.GET)
    public  String Delete(@PathVariable("id") Integer userId){


        int count= userService.deleteUser(userId);
        if (count>0)
            System.out.println("chenggong");
        else
            System.out.println("shibai");

        return "redirect: /user/find";
    }


    /**
     *
     *用户修改
     */
    @RequestMapping(value = "add/{id}",method = RequestMethod.GET)
    public  String Update(@PathVariable("id") Integer userId, HttpServletRequest request ){

        UserInfo userInfo=  userService.findUserById(userId);

        request.setAttribute("userInfo",userInfo);


        return "user/useradd";
    }
    @RequestMapping(value = "add/{id}",method = RequestMethod.POST)
    public  String Update(UserInfo userInfo , HttpServletRequest request, HttpServletResponse response) throws UnsupportedEncodingException {
        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html; charset=UTF-8");

        if(userInfo.getId()!=null) {
            int count = userService.updateUser(userInfo);
            if (count > 0) {
                return "redirect: /user/find";
            }

            return "user/add";
        }
        else {
          /*  int count= userService.addUser(userInfo);
            if (count>0)
                System.out.println("chenggong");
            else
                System.out.println("shibai");

            return "redirect: /user/find";*/
            add();

        }
        return null;
    }



}
