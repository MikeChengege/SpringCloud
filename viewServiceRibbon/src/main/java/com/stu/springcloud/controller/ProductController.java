package com.stu.springcloud.controller;

import java.util.List;

import com.stu.springcloud.modle.Product;
import com.stu.springcloud.modle.User;
import com.stu.springcloud.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
@RefreshScope
public class ProductController {
    @Autowired
    ProductService productService;

    @Value("${version}")
    String version;
    @RequestMapping("/products")
    public Object listProduct(Model m){
        List<Product> lp = productService.listProduct();
        m.addAttribute("version",version);
        m.addAttribute("ps",lp);
        return  "page/products";
    }
    @RequestMapping("/userList")
    public Object userList(Model m){
        List<User> lp = productService.userList();
        m.addAttribute("ps",lp);
        return  "userList";
    }
    @RequestMapping("/Mosttv/index")
    public String indexPag(Model m){
        m.addAttribute("name","thymeleaf");
        return  "page/index";
    }
}
