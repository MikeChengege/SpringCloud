package com.stu.springcloud.service;

import com.stu.springcloud.mapper.UserAdvMapper;
import com.stu.springcloud.model.UserAdv;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserAdvService {
    @Autowired
    UserAdvMapper userAdvMapper;
    public void submitAdvice(UserAdv uadv){
        userAdvMapper.insertAdv(uadv);
    }
}
