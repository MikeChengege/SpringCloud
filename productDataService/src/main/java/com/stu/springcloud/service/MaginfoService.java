package com.stu.springcloud.service;

import com.stu.springcloud.mapper.MagInfoMapper;
import com.stu.springcloud.model.Manager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MaginfoService {
    @Autowired
    MagInfoMapper magInfoMapper;
    public Manager getMangByName(String name){
        return magInfoMapper.get(name);
    }
}
