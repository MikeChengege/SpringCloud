package com.stu.springcloud.service;

import com.stu.springcloud.mapper.TvSubMapper;
import com.stu.springcloud.mapper.VideoInfoMapper;
import com.stu.springcloud.model.TvSub;
import com.stu.springcloud.model.Video;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VideoInfoService {
    @Autowired
    VideoInfoMapper videoInfoMapper;
    @Autowired
    TvSubMapper tvSubMapper;
    public List<Video> getAll(){
        return videoInfoMapper.getAll();
    }
    public List<Video> getVideoInfo(){
        return videoInfoMapper.getBothAll();
    }
    public List<Video> getMostseeInfoAll(){
        return videoInfoMapper.getMostseeInfoAll();
    }
    public List<Video> getRankBothAll(){
        return videoInfoMapper.getRankBothAll();
    }
    public List<Video> getVideoByUser(String name){
        return videoInfoMapper.getVideoByUser(name);
    }
    public Video getVideoById(int vid){
        return videoInfoMapper.getVideoById(vid);
    }
    public void updateVideo(Video video){
         videoInfoMapper.updateVideoTitle(video);
    }
    public void updateAll(Video video){
         videoInfoMapper.updateAll(video);
    }

    public Video getVideoByTitle(Video video){
         return videoInfoMapper.getVideoByTitle(video);
    }
    public void insertVideoInfo(Video video){
         videoInfoMapper.insertVideoInfo(video);
    }
    public void magUpdate(Video video){
         videoInfoMapper.magUpdate(video);
    }
    public void updateHadVis(Video video){
         videoInfoMapper.updateHadVis(video);
    }
    public void updateVideoComm(Video video){
         videoInfoMapper.updateVideoComm(video);
    }
    public void deleteById(int vid) {
        videoInfoMapper.deleteById(vid);
    }
    public List<Video> getAllByType(int videotype,int limit){
        return videoInfoMapper.getAllByType(videotype,limit);
    }

    public List<TvSub> getTvSub(int id){
        return tvSubMapper.getTvSub(id);
    }

    public List<Video> getSearchContent(String name){
        return videoInfoMapper.getSearchContent(name);
    }
}
