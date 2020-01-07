package com.stu.springcloud.service;

import com.stu.springcloud.client.ProductClientRibbon;
import com.stu.springcloud.modle.Video;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VideoInfoService {
    @Autowired
    ProductClientRibbon productClientRibbon;
    public List<Video> getVideoInfo(){
        return productClientRibbon.getVideoInf();
    }
    public List<Video> getMostseeInfoAll(){
        return productClientRibbon.getVideoInf();
    }
    public List<Video> getRankBothAll(){
        return productClientRibbon.getRankBothAll();
    }
}
