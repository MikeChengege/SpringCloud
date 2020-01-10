package com.stu.springcloud.service;

import com.stu.springcloud.client.ProductClientRibbon;
import com.stu.springcloud.modle.TvSub;
import com.stu.springcloud.modle.Video;
import com.stu.springcloud.modle.VideoComm;
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
    public List<Video> getAllByType(int videotype,int limit){
        return productClientRibbon.getAllByType(videotype,limit);
    }
    public List<Video> getMostseeInfoAll(){
        return productClientRibbon.getVideoInf();
    }
    public List<Video> getRankBothAll(){
        return productClientRibbon.getRankinfo();
    }
    public Video getVideoById(int vid){
        return productClientRibbon.getVideoById(vid);
    }
    public Video getVideoByTitle(Video vi){
        return productClientRibbon.getVideoByTitle(vi);
    }
    public List<Video> getVideoByName(String name){
        return productClientRibbon.getVideoByName(name);
    }
    public void updateVideo(Video vi){
        productClientRibbon.updateVideo(vi);
    }
    public void magUpdate(Video vi){
        productClientRibbon.magUpdate(vi);
    }
    public void updateHadVis(Video vi){
        productClientRibbon.updateHadVis(vi);
    }
    public void updateAll(Video vi){
        productClientRibbon.updateAll(vi);
    }
    public void deleteById(int vid) {
        productClientRibbon.deleteById(vid);
    }
    public void updateVideoComm(Video vi){
         productClientRibbon.updateVideoComm(vi);
    }
    public List<TvSub> getTvSub(int id){
        return productClientRibbon.getTvSub(id);
    }
    public void insertVideoInfo(Video vi){
        productClientRibbon.insertVideoInfo(vi);
    }
    public List<Video> getSearchContent(String name){
        return productClientRibbon.getSearchContent(name);
    }
}
