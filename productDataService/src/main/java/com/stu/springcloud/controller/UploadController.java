package com.stu.springcloud.controller;


import com.stu.springcloud.model.VideoSub;
import com.stu.springcloud.service.VideoInfoService;
import com.stu.springcloud.service.VideoSubService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * Created by mikechen on 2018/9/21.
 */
@Controller
public class UploadController {
    @Autowired
    VideoInfoService videoInfoService;
    @Autowired
    VideoSubService videoSubService;
    @RequestMapping("/updateSubTime")
    @ResponseBody
    public void updateSubTime(@RequestBody VideoSub vs){
        videoSubService.updateSubTime(vs);
    }

    @RequestMapping("/updateSub")
    @ResponseBody
    public void updateSub(@RequestBody VideoSub vs){
        videoSubService.updateSub(vs);
    }

    @RequestMapping("/insertVidSub")
    @ResponseBody
    public void insertVidSub(int id){
        videoSubService.insertVidSub(id);
    }

    @RequestMapping("/getSub")
    @ResponseBody
    public List<VideoSub> getSub(){
        return videoSubService.getSub();
    }

    @RequestMapping("/getSubById")
    @ResponseBody
    public VideoSub getSubById(int id){
        return videoSubService.getSubById(id);
    }
}
