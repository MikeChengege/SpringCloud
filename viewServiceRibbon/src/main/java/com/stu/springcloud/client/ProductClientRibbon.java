package com.stu.springcloud.client;

import cn.hutool.json.JSONObject;
import com.stu.springcloud.modle.Product;
import com.stu.springcloud.modle.User;
import com.stu.springcloud.modle.Video;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

@FeignClient(value ="PRODUCT-DATA-SERVICE",fallback = ProductClientFeignHystrix.class )
public interface ProductClientRibbon {
    @GetMapping("/products")
    public List<Product> listProduct();
    @GetMapping("/userList")
    public List<User> userList();
    @GetMapping("/Verification")
    public User Verification(@RequestParam("username") String username);
    @GetMapping("/getVideoInf")
    public List<Video> getVideoInf();
    @GetMapping("/mostseeVideoInf")
    public List<Video> mostseeVideoInf();
    @GetMapping("/getRankBothAll")
    public List<Video> getRankBothAll();
}
