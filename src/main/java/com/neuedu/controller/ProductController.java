package com.neuedu.controller;

import com.neuedu.pojo.Product;
import com.neuedu.service.IProductService;
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
@RequestMapping("/user/product/")
public class ProductController {
    @Autowired
    IProductService productService;
    /**
     *
     * 把数据库的商品信息展示到页面
     */
    @RequestMapping("find")
    public  String findAll(HttpSession session){
        List<Product> productList=productService .findAll();

        session.setAttribute("productlist",productList);
        return "productlist";
    }
    /**
     *
     * 商品删除
     */

    @RequestMapping(value = "find/{id}",method = RequestMethod.GET)
    public  String Delete(@PathVariable("id") Integer productId){
        int count= productService.deleteProduct(productId);
        if (count>0)
            System.out.println("chenggong");
        else
            System.out.println("shibai");

        return "redirect: /user/product/find";
    }

    /**
     * 添加商品
     */
    @RequestMapping(value = "add",method = RequestMethod.GET)
    public  String add( ){

        return "productadd";

    }

    @RequestMapping(value = "add",method = RequestMethod.POST)
    public  String add( Product product){
        int count= productService.addProduct(product);
        if (count>0)
            System.out.println("chenggong");
        else
            System.out.println("shibai");

        return "redirect: /user/product/find";
    }
    /**
     *
     * 商品修改
     */
    @RequestMapping(value = "update/{id}",method = RequestMethod.GET)
    public  String Update(@PathVariable("id") Integer productId, HttpServletRequest request ){

        Product product=  productService.findProductById(productId);

        request.setAttribute("product",product);


        return "productupdate";
    }
    @RequestMapping(value = "update/{id}",method = RequestMethod.POST)
    public  String Update(Product product , HttpServletRequest request, HttpServletResponse response) throws UnsupportedEncodingException {
        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html; charset=UTF-8");


        int count=productService.updateProduct(product);
        if(count>0)
        {
            return "redirect: /user/product/find";
        }

        return "productupdate";
    }





}
