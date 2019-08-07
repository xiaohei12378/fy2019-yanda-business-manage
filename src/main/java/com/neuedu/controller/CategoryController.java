package com.neuedu.controller;

import com.neuedu.pojo.Category;
import com.neuedu.service.ICategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.UnsupportedEncodingException;
import java.util.List;

@Controller
@RequestMapping("/user/category/")
public class CategoryController {
    @Autowired
    ICategoryService categoryService;
    /**
     *
     * 把数据库的类别信息展示到页面
     */
    @RequestMapping("find")
    public  String findAll(HttpSession session){
        List<Category> categoryList =categoryService.findAll();

        session.setAttribute("categorylist",categoryList);
        return "categorylist";
    }

    /**
     *
     * 类别修改
     */
    @RequestMapping(value = "update/{id}",method = RequestMethod.GET)
    public  String Update(@PathVariable("id") Integer categoryId, HttpServletRequest request ){

      Category category=  categoryService.findCategoryById(categoryId);

      request.setAttribute("category",category);


        return "categoryupdate";
    }
    @RequestMapping(value = "update/{id}",method = RequestMethod.POST)
    public  String Update(Category category , HttpServletRequest request, HttpServletResponse response) throws UnsupportedEncodingException {
        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html; charset=UTF-8");


        int count=categoryService.updateCategory(category);
        if(count>0)
        {
            return "redirect: /user/category/find";
        }

        return "categoryupdate";
    }


/**
 *
 * 类别删除
 */

    @RequestMapping(value = "find/{id}",method = RequestMethod.GET)
    public  String Delete(@PathVariable("id") Integer categoryId, HttpServletRequest request ){




      int count= categoryService.deleteCategory(categoryId);
        if (count>0)
            System.out.println("chenggong");
        else
            System.out.println("shibai");

      return "redirect: /user/category/find";
    }




}
