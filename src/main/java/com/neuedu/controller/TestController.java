package com.neuedu.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;

@Controller
public class TestController {

    @RequestMapping("/ftl")
    public String login(HttpSession session){

        session.setAttribute("username","zs");
        return  "home";
    }

}
