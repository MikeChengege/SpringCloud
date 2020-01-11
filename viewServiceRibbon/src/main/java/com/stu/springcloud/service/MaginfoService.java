package com.stu.springcloud.service;

import com.stu.springcloud.client.ProductClientRibbon;
import com.stu.springcloud.modle.Manager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MaginfoService {
    @Autowired
    ProductClientRibbon productClientRibbon;
    public Manager getMangByName(String name){
        return productClientRibbon.getMangByName(name);
    }
}
