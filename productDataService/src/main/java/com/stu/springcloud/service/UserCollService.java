package com.stu.springcloud.service;

import com.stu.springcloud.mapper.UserCollMapper;
import com.stu.springcloud.model.UserCollection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserCollService {
    @Autowired
    UserCollMapper userCollMapper;
    public List<UserCollection> getUserColl(int uid){
       return userCollMapper.getCollection(uid);
    }
    public void addCollect(UserCollection userCollection){
        userCollMapper.addCollect(userCollection);
    }
    public void deleteCollect(UserCollection userCollection){
        userCollMapper.deleteCollect(userCollection);
    }
}
