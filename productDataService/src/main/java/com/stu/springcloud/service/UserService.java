package com.stu.springcloud.service;

import com.stu.springcloud.mapper.UserInfoMapper;
import com.stu.springcloud.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    @Autowired
    UserInfoMapper userInfoMapper;
    public User getUser(String username){
        User us  = userInfoMapper.get(username);
        return  us;
    }
    public User getById(int id){
        User us = userInfoMapper.getById(id);
        return  us;
    }

    public List<User> getAllUser(){
        return  userInfoMapper.getAllUser();
    }
    public void updateUser(User us){
        userInfoMapper.updateUser(us);
    }
    public void setUser(User us){
        userInfoMapper.setUser(us);
    }
    public void destroyUser(int id){
        userInfoMapper.destroyUser(id);
    }

}
