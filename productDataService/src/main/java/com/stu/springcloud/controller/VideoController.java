package com.stu.springcloud.controller;


import com.stu.springcloud.mapper.TvSubMapper;
import com.stu.springcloud.model.TvSub;
import com.stu.springcloud.model.Video;
import com.stu.springcloud.model.VideoComm;
import com.stu.springcloud.service.VideoCommService;
import com.stu.springcloud.service.VideoInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * Created by mikechen on 2018/9/21.
 */
@Controller
@RefreshScope
public class VideoController {

    @Autowired
    VideoInfoService videoInfoService;
    @Autowired
    VideoCommService videoCommService;

    @RequestMapping("/getVideoInf")
    @ResponseBody
   public List<Video> getVideoInf(){
        List<Video> limag = videoInfoService.getVideoInfo();
        return limag;
    }
    @RequestMapping("/mostseeVideoInf")
    @ResponseBody
    public List<Video> mostseeVideoInf(){
        List<Video> limag = videoInfoService.getMostseeInfoAll();
        return limag;
    }
    @RequestMapping("/getRankinfo")
    @ResponseBody
   public List<Video> getRankinfo(){
        List<Video> limag = videoInfoService.getRankBothAll();
        return limag;
    }
    @RequestMapping("/getVideoById")
    @ResponseBody
    public  Video getVideoById(int vid){
        Video video = new Video();
        if (vid>=0){
            video = videoInfoService.getVideoById(vid);
        }
        return video;
    }
    @RequestMapping("/getVideoByName")
    @ResponseBody
    public List<Video> getVideoByName(String name){
        List<Video> limag = videoInfoService.getVideoByUser(name);
        return limag;
    }
//    @RequestMapping("/getvideoPage")
//    @ResponseBody
//    public PageInfo getPageVideo(Model m, @RequestParam(value = "start", defaultValue = "0") int start, @RequestParam(value = "size", defaultValue = "5") int size) throws Exception {
//        PageHelper.startPage(start,size,"id desc");
//        List<Video> cs=videoinfomapper.getBothAll();
//        List<Video> lvo = new ArrayList<>();
//        if(cs!=null){
//            int i = 0;
//            for (Video v:cs) {
//                if(i>=start&&i<start+10){
//                    lvo.add(v);
//                }
//                i++;
//            }
//        }
//        PageInfo<Video> page = new PageInfo<>(lvo);
//        m.addAttribute("page", page);
//        return page;
//    }
//


    @RequestMapping("/getAllByType")
    @ResponseBody
    public  List<Video> getVideoByType(int videotype,int limit){
        List<Video> lvo =  videoInfoService.getAllByType(videotype,limit);
        return lvo;
    }

    @RequestMapping("/updateAll")
    @ResponseBody
    public void updateAll(@RequestBody Video vi){
        videoInfoService.updateAll(vi);
    }

    @RequestMapping("/updateHadVis")
    @ResponseBody
    public void updateHadVis(@RequestBody Video vi){
        videoInfoService.updateAll(vi);
    }

    @RequestMapping("/getCommAndPeo")
    @ResponseBody
    public List<VideoComm> getVideoComm(int id){
        List<VideoComm> videoComm =videoCommService.getCommAndPeo(id);
        return videoComm;
    }
    @RequestMapping("/insertComm")
    @ResponseBody
    public void insertComm(@RequestBody VideoComm vicm){
        videoCommService.insertComm(vicm);
    }

    @RequestMapping("/updateVideoComm")
    @ResponseBody
    public void updateVideoComm(@RequestBody Video vi){
        videoInfoService.updateVideoComm(vi);
    }

    @RequestMapping("/magUpdate")
    @ResponseBody
    public void magUpdate(@RequestBody Video vi){
        videoInfoService.magUpdate(vi);
    }

    @RequestMapping("/updateHadLike")
    @ResponseBody
    public void updateHadLike(@RequestBody VideoComm vicm){
        videoCommService.updateHadLike(vicm);
    }
    @RequestMapping("/getCommById")
    @ResponseBody
    public VideoComm getCommById(int id){
        return videoCommService.getCommById(id);
    }

    @RequestMapping("/getTvSub")
    @ResponseBody
    public List<TvSub> getTvSub(int id){
        return videoInfoService.getTvSub(id);
    }

    @RequestMapping("/insertVideoInfo")
    @ResponseBody
    public void insertVideoInfo(@RequestBody Video vi){
        videoInfoService.insertVideoInfo(vi);
    }

    @RequestMapping("/getVideoByTitle")
    @ResponseBody
    public Video getVideoByTitle(@RequestBody Video vi){
       return videoInfoService.getVideoByTitle(vi);
    }

    @RequestMapping("/getSearchContent")
    @ResponseBody
    public List<Video> getSearchContent(String name){
       return videoInfoService.getSearchContent(name);
    }

}
