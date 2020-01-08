package com.stu.springcloud.controller;


import com.stu.springcloud.modle.Video;
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
    public List<Video> getAllTv(){
        List<Video> limag = tvInfoService.getAllTv(2);
        return  limag;
    }
    @RequestMapping("/getAllFilm")
    @ResponseBody
    public List<Video> getAllFilm(){
        List<Video> limag = tvInfoService.getAllTv(1);
        return  limag;
    }
    @RequestMapping("/getAllStudy")
    @ResponseBody
    public List<Video> getAllStudy(){
        List<Video> limag = tvInfoService.getAllTv(6);
        return  limag;
    }
    @RequestMapping("/getAllNews")
    @ResponseBody
    public List<Video> getAllNews(){
        List<Video> limag = tvInfoService.getAllTv(3);
        return  limag;
    }
    @RequestMapping("/getAllSport")
    @ResponseBody
    public List<Video> getAllSport(){
        List<Video> limag = tvInfoService.getAllTv(4);
        return  limag;
    }
    @RequestMapping("/getAllGame")
    @ResponseBody
    public List<Video> getAllGame(){
        List<Video> limag = tvInfoService.getAllTv(5);
        return  limag;
    }


}
