package com.stu.springcloud.controller;

import com.stu.springcloud.model.Product;
import com.stu.springcloud.model.User;
import com.stu.springcloud.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ProductController {
    @Autowired
    ProductService productService;

    @RequestMapping("/products")
    public  Object product(){
        List<Product> lp = productService.listProduct();
        return  lp;
    }
}
