package com.stu.springcloud.service;

import com.stu.springcloud.mapper.UserAdvMapper;
import com.stu.springcloud.model.UserAdv;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserAdvService {
    @Autowired
    UserAdvMapper userAdvMapper;
    public void submitAdvice(UserAdv uadv){
        userAdvMapper.insertAdv(uadv);
    }

    public List<UserAdv> getAdv(){
       return userAdvMapper.getAdv();
    }
    public void updateUserAdv(UserAdv uadv){
        userAdvMapper.updateUserAdv(uadv);
    }
    public UserAdv getAdvById(int id){
       return userAdvMapper.getAdvById(id);
    }
    public void deleteUserAdv(int id){
        userAdvMapper.deleteUserAdv(id);
    }
}
