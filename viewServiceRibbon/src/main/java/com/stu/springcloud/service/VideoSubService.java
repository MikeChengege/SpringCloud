package com.stu.springcloud.service;

import com.stu.springcloud.client.ProductClientRibbon;
import com.stu.springcloud.modle.VideoSub;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VideoSubService {
    @Autowired
    ProductClientRibbon productClientRibbon;
    public void updateSubTime(VideoSub vs){
        productClientRibbon.updateSubTime(vs);
    }
    public void updateSub(VideoSub vs){
        productClientRibbon.updateSub(vs);
    }
    public void insertVidSub(int id){
        productClientRibbon.insertVidSub(id);
    }
    public List<VideoSub> getSub(){
       return productClientRibbon.getSub();
    }
    public VideoSub getSubById(int id){
       return productClientRibbon.getSubById(id);
    }
}
