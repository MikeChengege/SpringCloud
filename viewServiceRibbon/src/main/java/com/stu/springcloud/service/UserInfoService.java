package com.stu.springcloud.service;

import cn.hutool.json.JSONObject;
import com.stu.springcloud.client.ProductClientRibbon;
import com.stu.springcloud.modle.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

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
                session.setAttribute("useInfo",us);//把值存入session
            }else {
                jsonObject.put("msg", "error");
            }
        } else {
            jsonObject.put("msg", "NoUser");
        }
        return  jsonObject;
    }
}
