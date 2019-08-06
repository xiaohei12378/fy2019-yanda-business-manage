package com.neuedu.service;

import com.neuedu.exception.MyException;
import com.neuedu.pojo.Category;

import java.util.List;

public interface ICategoryService {
    /**
     *
     * 添加类别
     * **/
    public int addCategory(Category category) throws MyException;
    public int deleteCategory(int categoryId) throws MyException;
    public int updateCategory(Category category) throws MyException;
    public List<Category> findAll() throws MyException;

    public Category findCategoryById(int categoryId ) throws  MyException;
}
