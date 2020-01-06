package com.stu.springcloud.client;

import com.stu.springcloud.modle.Product;
import com.stu.springcloud.modle.User;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@FeignClient(value ="PRODUCT-DATA-SERVICE",fallback = ProductClientFeignHystrix.class )
public interface ProductClientRibbon {
    @GetMapping("/products")
    public List<Product> listProduct();
    @GetMapping("/userList")
    public List<User> userList();

}
