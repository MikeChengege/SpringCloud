package com.stu.springcloud.controller;


import cn.hutool.json.JSONObject;
import com.stu.springcloud.model.UserCollection;
import com.stu.springcloud.model.Video;
import com.stu.springcloud.service.UserCollService;
import com.stu.springcloud.service.VideoInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by mikechen on 2018/9/21.
 */
@Controller
public class CollectController {
    @Autowired
    UserCollService userCollService;
    @Autowired
    VideoInfoService videoInfoService;
    @RequestMapping("/userCollection")
    @ResponseBody
    public List<UserCollection>  userCollection(int id){
        List<UserCollection> luc = userCollService.getUserColl(id);
        return luc;
    }
    @RequestMapping("/updateVideo")
    @ResponseBody
    public void updateVideo(@RequestBody Video vi){
        videoInfoService.updateVideo(vi);
    }

    @RequestMapping("/deleteById")
    @ResponseBody
    public void deleteUploadVideo(int vid){
        videoInfoService.deleteById(vid);
    }

    @RequestMapping("/addCollect")
    @ResponseBody
    public void addCollect(@RequestBody UserCollection userCollection){
      userCollService.addCollect(userCollection);
    }
    @RequestMapping("/deleteCollect")
    @ResponseBody
    public void deleteCollect(@RequestBody UserCollection userCollection){
      userCollService.deleteCollect(userCollection);
    }
//@RequestMapping("/deleteCollect")
//    @ResponseBody
//    public JSONObject deleteCollect(UserCollection uc){
//        JSONObject json = new JSONObject();
//        if(uc.getUserid()==0||uc.getVideoid()==0){
//            json.put("msg","error");
//        }else{
//            try {
//                usercollmapper.deleteCollect(uc);
//                json.put("msg","success");
//            }catch (Exception e){
//                json.put("msg","error");
//            }
//        }
//        return json;
//    }

//
//    @RequestMapping("/userUpdateVideo")
//    @ResponseBody
//    public JSONObject userUpdateVideo(int id){
//        JSONObject json = new JSONObject();
//        if(id!=0){
//             User ui = userinfomapper.getById(id);
//            if(ui!=null){
//                List<Video> lv = videoinfomapper.getVideoByUser(ui.getUsername());
//                json.put("msg",lv);
//            }else {
//                json.put("msg","error");
//            }
//        }
//        return json;
//    }



}
