package com.neuedu.controller;

import com.neuedu.pojo.Product;
import com.neuedu.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.List;
import java.util.UUID;

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
        return "product/list";
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


@RequestMapping(value = "upload" ,method = RequestMethod.GET)
    public String upload(){
        return "product/upload";
    }
@RequestMapping(value = "/upload",method = RequestMethod.POST)
public String  upload (@RequestParam("picfile")MultipartFile uploadFile){

        if(uploadFile!=null) {
            String uuid = UUID.randomUUID().toString();
            //获取扩展名
            String fileName=uploadFile.getOriginalFilename();
           String  fileextendname =fileName.substring(fileName.lastIndexOf("."));
           String newFilename=uuid+fileextendname;
            //将文件保存在该目录下
            File file=new File("F:\\idea\\business_manage\\upload");
            if(!file.exists()){
                file.mkdir();
            }
            File newFile =new File(file,newFilename);

            try {
                //将文件写入到磁盘
                uploadFile.transferTo(newFile);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        return "product/upload";

}



}
