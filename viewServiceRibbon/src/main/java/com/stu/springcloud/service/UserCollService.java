package com.stu.springcloud.service;

import com.stu.springcloud.client.ProductClientRibbon;
import com.stu.springcloud.modle.UserCollection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserCollService {
    @Autowired
    ProductClientRibbon productClientRibbon;
    public List<UserCollection> getUserColl(int uid){
       return productClientRibbon.userCollection(uid);
    }
    public void addCollect(UserCollection userCollection){
        productClientRibbon.addCollect(userCollection);
    }
    public void deleteCollect(UserCollection userCollection){
        productClientRibbon.deleteCollect(userCollection);
    }
}
