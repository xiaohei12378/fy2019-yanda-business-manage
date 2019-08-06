package com.neuedu.controller;

import com.neuedu.pojo.Category;
import com.neuedu.service.ICategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
@RequestMapping("/user/category/")
public class CategoryController {
    @Autowired
    ICategoryService categoryService;

    @RequestMapping("find")
    public  String findAll(HttpSession session){
        List<Category> categoryList =categoryService.findAll();

        session.setAttribute("categorylist",categoryList);
        return "categorylist";
    }

    @RequestMapping(value = "update/{id}",method = RequestMethod.GET)
    public  String Update(@PathVariable("id") Integer categoryId, HttpServletRequest request ){

      Category category=  categoryService.findCategoryById(categoryId);

      request.setAttribute("category",category);


        return "categoryupdate";
    }
    @RequestMapping(value = "update/{id}",method = RequestMethod.POST)
    public  String Update(Category category ){



        return "categoryupdate";
    }

}
