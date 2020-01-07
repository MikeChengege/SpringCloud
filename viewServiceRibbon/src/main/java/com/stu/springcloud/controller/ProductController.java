package com.stu.springcloud.controller;

import java.util.ArrayList;
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
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;


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
        return  "products";
    }
    @RequestMapping("/Mosttv/index")
    public String indexPag(HttpSession session, HttpServletRequest request){
        if(session.getAttribute("useInfo")!=null){
            User u = (User)session.getAttribute("useInfo");
            session.setAttribute("sessionUser",u);
        }else {
            session.setAttribute("sessionUser",null);
        }
        return  "index";
    }
    @RequestMapping("/Mosttv/mostsee")
    public String mostSee() {
        return "mostsee";
    }
    @RequestMapping("/Mosttv/rankingList")
    public String rankingList() {
        return "rankingList";
    }
}
