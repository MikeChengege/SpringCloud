package com.stu.springcloud.client;

import com.stu.springcloud.modle.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@FeignClient(value ="PRODUCT-DATA-SERVICE" )
public interface ProductClientRibbon {
    @GetMapping("/products")
    public List<Product> listProduct();

}
