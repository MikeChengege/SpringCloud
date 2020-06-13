package com.stu.springcloud.service;

import cn.hutool.json.JSONObject;
import com.stu.springcloud.client.ProductClientRibbon;
import com.stu.springcloud.modle.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.List;

@Service
public class UserInfoService {
    @Autowired
    ProductClientRibbon productClientRibbon;
    public JSONObject Verification(User user, HttpServletRequest request){
        HttpSession session = request.getSession();
        String newpass =user.getPassword();
        User us  = productClientRibbon.Verification(user.getUsername());
        JSONObject jsonObject = new JSONObject();
        if(us!=null){
            String rightpass =us.getPassword();
            if(newpass.equals(rightpass)){
                jsonObject.put("msg", "success");
                session.setAttribute("sessionUser",us);
                session.setAttribute("useInfo",us);//把值存入session
            }else {
                jsonObject.put("msg", "error");
            }
        } else {
            jsonObject.put("msg", "NoUser");
        }
        return  jsonObject;
    }
    public User getUserInfoByName(String username){
        return productClientRibbon.Verification(username);
    }
    public User getUserInfoById(int id){
        return productClientRibbon.getUserInfoById(id);
    }
    public List<User> getAllUser(){
        return productClientRibbon.getAllUser();
    }
    public String findHasUserName(String username){
        User us =productClientRibbon.Verification(username);
        if(us==null){
            return "N";
        }else {
            return us.getUsername();
        }
    }
    public void updateUser(User us){
        productClientRibbon.updateUser(us);
    }
    public void setUser(User us){
        productClientRibbon.setUser(us);
    }
    public void destroyUser(int id){
        productClientRibbon.destroyUser(id);
    }
}
