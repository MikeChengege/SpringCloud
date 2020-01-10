package com.stu.springcloud.service;

import com.stu.springcloud.mapper.UserViewMapper;
import com.stu.springcloud.model.UserView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserSeeHistoryService {
    @Autowired
    UserViewMapper userViewMapper;
    public List<UserView> getHadSee(int id){
        return userViewMapper.getHadSee(id);
    }
    public UserView getSeemHadSee(UserView userView){
        return userViewMapper.getSeemHadSee(userView);
    }
    public void deleteHadSee(int id){
        userViewMapper.deleteHadSee(id);
    }
    public void addUserView(UserView userView){
        userViewMapper.addUserView(userView);
    }
}
