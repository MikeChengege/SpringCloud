package com.stu.springcloud.controller;


import cn.hutool.json.JSONObject;
import com.stu.springcloud.modle.User;
import com.stu.springcloud.modle.UserCollection;
import com.stu.springcloud.modle.Video;
import com.stu.springcloud.service.UserCollService;
import com.stu.springcloud.service.UserInfoService;
import com.stu.springcloud.service.VideoInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
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
    @Autowired
    UserInfoService userInfoService;

    @RequestMapping("/userCollection")
    @ResponseBody
    public JSONObject userCollection(int id){
        JSONObject json = new JSONObject();
        List<Video> backuc = new ArrayList<>();
        if(id!=0){
            List<UserCollection> luc = userCollService.getUserColl(id);
            if(luc!=null){
                for (UserCollection uc:luc) {
                    Video vi = videoInfoService.getVideoById(uc.getVideoid());
                    if(vi!=null){
                        backuc.add(vi);
                    }
                }
                json.put("msg",backuc);
            }else {
                json.put("msg","error");
            }
        }
        return json;
    }
    @RequestMapping("/userUpdateVideo")
    @ResponseBody
    public JSONObject userUpdateVideo(int id){
        JSONObject json = new JSONObject();
        if(id!=0){
            User ui = userInfoService.getUserInfoById(id);
            if(ui!=null){
                List<Video> lv = videoInfoService.getVideoByName(ui.getUsername());
                json.put("msg",lv);
            }else {
                json.put("msg","error");
            }
        }
        return json;
    }
    @RequestMapping("/updateVideo")
    @ResponseBody
    public JSONObject updateVideo(Video vi){
        JSONObject json = new JSONObject();
        if(vi.getVideo_title()!=null){
            try{
                videoInfoService.updateVideo(vi);
                json.put("msg","success");
            }catch (Exception e){
                json.put("msg",e);
            }
        }
        return json;
    }
    @RequestMapping("/deleteVideo")
    @ResponseBody
    public JSONObject deleteVideo(int id){
        JSONObject json = new JSONObject();
        if(id>0){
            try{
                videoInfoService.deleteById(id);
                json.put("msg","success");
            }catch (Exception e){
                json.put("msg",e);
            }
        }
        return json;
    }

    @RequestMapping("/findColled")
    @ResponseBody
    public JSONObject findColled(UserCollection uc){
        JSONObject json = new JSONObject();
        List<UserCollection> li=null;
        if(uc.getUserid()>0){
            li = userCollService.getUserColl(uc.getUserid());
            if(li!=null&&!li.isEmpty()&&uc.getVideoid()>0){
                for (UserCollection u:li) {
                    if(u.getVideoid()==uc.getVideoid()){
                        json.put("msg","success");
                        break;
                    }else{
                        json.put("msg","error");
                        continue;
                    }
                }
            }else {
                json.put("msg","error");
            }
        }else {
            json.put("msg","error");
        }
        return json;
    }
  @RequestMapping("/addCollect")
    @ResponseBody
    public JSONObject addCollect(UserCollection uc){
        JSONObject json = new JSONObject();
        if(uc.getUserid()==0||uc.getVideoid()==0){
            json.put("msg","error");
        }else{
            try {
                userCollService.addCollect(uc);
                json.put("msg","success");
            }catch (Exception e){
                json.put("msg",e);
            }
        }
        return json;
    }
@RequestMapping("/deleteCollect")
    @ResponseBody
    public JSONObject deleteCollect(UserCollection uc){
        JSONObject json = new JSONObject();
        if(uc.getUserid()==0||uc.getVideoid()==0){
            json.put("msg","error");
        }else{
            try {
                userCollService.deleteCollect(uc);
                json.put("msg","success");
            }catch (Exception e){
                json.put("msg","error");
            }
        }
        return json;
    }

//



}
