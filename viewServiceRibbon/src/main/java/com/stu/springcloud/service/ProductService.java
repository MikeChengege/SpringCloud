package com.stu.springcloud.service;


import com.stu.springcloud.client.ProductClientRibbon;
import com.stu.springcloud.modle.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {
    @Autowired
    ProductClientRibbon productClientRibbon;
    public List<Product> listProduct(){
        return productClientRibbon.listProduct();
    }
}
