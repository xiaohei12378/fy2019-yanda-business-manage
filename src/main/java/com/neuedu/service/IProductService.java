package com.neuedu.service;

import com.neuedu.exception.MyException;
import com.neuedu.pojo.Product;

import java.util.List;

public interface IProductService {
    public int addProduct(Product product) throws MyException;
    public int deleteProduct( int productId) throws MyException;
    public int updateProduct(Product product) throws MyException;
    public List<Product> findAll() throws MyException;
    public Product findProductById(int productId ) throws  MyException;
}
