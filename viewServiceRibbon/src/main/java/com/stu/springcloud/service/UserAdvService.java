package com.stu.springcloud.service;

import com.stu.springcloud.client.ProductClientRibbon;
import com.stu.springcloud.modle.UserAdv;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserAdvService {
    @Autowired
    ProductClientRibbon productClientRibbon;
    public void submitAdvice(UserAdv uadv){
        productClientRibbon.submitAdvice(uadv);
    }
    public List<UserAdv> getAdv(){
       return productClientRibbon.getAdv();
    }
    public void updateUserAdv(UserAdv uav){
        productClientRibbon.updateUserAdv(uav);
    }
    public UserAdv getAdvById(int id){
       return productClientRibbon.getAdvById(id);
    }
    public void deleteUserAdv(int id){
        productClientRibbon.deleteUserAdv(id);
    }
}
