package com.stu.springcloud.controller;


import com.stu.springcloud.model.Video;
import com.stu.springcloud.service.TvInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * Created by mikechen on 2018/9/21.
 */
@Controller
public class TvInfoController {
    @Autowired
    TvInfoService tvInfoService;

    @RequestMapping("/getAllTv")
    @ResponseBody
    public List<Video> getAllTv(int videoType){
        List<Video> limag = tvInfoService.getVideoByType(videoType);
        return  limag;
    }
//    @RequestMapping("/getAllFilm")
//    @ResponseBody
//    public List<Video> getAllFilm(){
//        List<Video> limag = videoinfomapper.getVideoByType(1);
//        return  limag;
//    }
//    @RequestMapping("/getAllNews")
//    @ResponseBody
//    public List<Video> getAllNews(){
//        List<Video> limag = videoinfomapper.getVideoByType(3);
//        return  limag;
//    }
//    @RequestMapping("/getAllSport")
//    @ResponseBody
//    public List<Video> getAllSport(){
//        List<Video> limag = videoinfomapper.getVideoByType(4);
//        return  limag;
//    }
//    @RequestMapping("/getAllGame")
//    @ResponseBody
//    public List<Video> getAllGame(){
//        List<Video> limag = videoinfomapper.getVideoByType(5);
//        return  limag;
//    }
//    @RequestMapping("/getAllStudy")
//    @ResponseBody
//    public List<Video> getAllStudy(){
//        List<Video> limag = videoinfomapper.getVideoByType(6);
//        return  limag;
//    }

}
