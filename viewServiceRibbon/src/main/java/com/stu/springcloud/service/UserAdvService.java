package com.stu.springcloud.service;

import com.stu.springcloud.client.ProductClientRibbon;
import com.stu.springcloud.modle.UserAdv;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserAdvService {
    @Autowired
    ProductClientRibbon productClientRibbon;
    public void submitAdvice(UserAdv uadv){
        productClientRibbon.submitAdvice(uadv);
    }
}
