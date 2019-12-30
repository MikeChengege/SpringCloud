package com.stu.springcloud.service;


import com.stu.springcloud.model.Product;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProductService {
    @Value("${server.port}")
    String port;
    public List<Product> listProduct(){
        List<Product> lp = new ArrayList<>();
        lp.add(new Product(1,"pro "+port,10));
        lp.add(new Product(2,"pro "+port,11));
        lp.add(new Product(3,"pro "+port,12));
        return  lp;
    }
}
