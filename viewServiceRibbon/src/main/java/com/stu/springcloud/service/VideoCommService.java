package com.stu.springcloud.service;

import com.stu.springcloud.client.ProductClientRibbon;
import com.stu.springcloud.modle.VideoComm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VideoCommService {
    @Autowired
    ProductClientRibbon productClientRibbon;
    public List<VideoComm> getCommAndPeo(int id){
        return productClientRibbon.getCommAndPeo(id);
    }
    public List<VideoComm> getAllComm(){
        return productClientRibbon.getAllComm();
    }
    public VideoComm getCommById(int id){
        return productClientRibbon.getCommById(id);
    }
    public void insertComm(VideoComm vic){
         productClientRibbon.insertComm(vic);
    }
    public void updateHadLike(VideoComm vic){
         productClientRibbon.updateHadLike(vic);
    }
    public void updVideocomm(VideoComm vic){
         productClientRibbon.updVideocomm(vic);
    }
    public void delVideocomm(int id){
         productClientRibbon.delVideocomm(id);
    }
}
