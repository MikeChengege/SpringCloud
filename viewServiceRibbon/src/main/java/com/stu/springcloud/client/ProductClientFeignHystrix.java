package com.stu.springcloud.client;

import cn.hutool.json.JSONObject;
import com.stu.springcloud.modle.Product;
import com.stu.springcloud.modle.User;
import com.stu.springcloud.modle.UserAdv;
import com.stu.springcloud.modle.Video;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.List;

/**
 * 数据微服务无法连接后回调类
 */
@Component
public class ProductClientFeignHystrix  implements ProductClientRibbon{
    public List<Product> listProduct() {
        List<Product> lp = new ArrayList<>();
        lp.add(new Product(0,"产品不可用",0));
        return lp;
    }

    @Override
    public List<User> userList() {
        List<User> lp = new ArrayList<>();
        lp.add(new User());
        return lp;
    }

    @Override
    public User Verification(String username) {
        return null;
    }

    @Override
    public List<Video> getVideoInf() {
        return null;
    }

    @Override
    public List<Video> mostseeVideoInf() {
        return null;
    }

    @Override
    public List<Video> getRankinfo() {
        return null;
    }

    @Override
    public List<Video> getAllTv(int videoType) {
        return null;
    }

    @Override
    public List<Video> submitAdvice(UserAdv uadv) {
        return null;
    }
}
