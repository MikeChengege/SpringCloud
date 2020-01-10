package com.stu.springcloud.service;

import com.stu.springcloud.client.ProductClientRibbon;
import com.stu.springcloud.modle.UserView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserSeeHistoryService {
    @Autowired
    ProductClientRibbon productClientRibbon;
    public List<UserView> getHadSee(int id){
        return productClientRibbon.getHadView(id);
    }
    public UserView getSeemHadSee(UserView userView){
        return productClientRibbon.getSeemHadSee(userView);
    }
    public void deleteHadSee(int id){
         productClientRibbon.deleteHadSee(id);
    }
    public void addUserView(UserView userView){
         productClientRibbon.addUserView(userView);
    }
}
