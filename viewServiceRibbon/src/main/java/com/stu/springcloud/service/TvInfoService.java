package com.stu.springcloud.service;

import com.stu.springcloud.client.ProductClientRibbon;
import com.stu.springcloud.modle.Video;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TvInfoService {
    @Autowired
    ProductClientRibbon productClientRibbon;
    public List<Video> getAllTv(int videoType){
        return productClientRibbon.getAllTv(videoType);
    }
}
