package com.stu.springcloud.controller;

import cn.hutool.json.JSONObject;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.stu.springcloud.modle.VideoComm;
import com.stu.springcloud.service.VideoCommService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by mikechen on 2018/9/21.
 */
@Controller
public class UserCommController {

    @Autowired
    VideoCommService videoCommService;

    @RequestMapping("/getvideocomm")
    @ResponseBody
    public Map<String, Object> getvideovisit(@RequestParam(name = "page", defaultValue = "1") int page, @RequestParam(name = "rows", defaultValue = "10") int rows){
        int start = (page-1)*rows+1;
        int size = rows;
        List<VideoComm> lv = videoCommService.getAllComm();
        PageHelper.startPage(start,size,"id desc");
        PageInfo<VideoComm> pagev = new PageInfo<>(lv);
        List<VideoComm> lvc = new ArrayList<>();
        int i=0;
        for (VideoComm vc:lv) {
            i++;
            if(i>=start&&i<start+size){
                lvc.add(vc);
            }
        }
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("rows", lvc);
        map.put("total", pagev.getTotal());
        return map;
    }

    @RequestMapping("/updVideocomm")
    @ResponseBody
    public JSONObject updVideocomm(int id,String comt_content,int comt_exam,int comt_liked,int comt_dislike){
        JSONObject json = new JSONObject();
        if(id!=0){
            VideoComm vcc = videoCommService.getCommById(id);
            if(vcc!=null){
                vcc.setComt_content(comt_content);
                vcc.setComt_exam(comt_exam);
                vcc.setComt_liked(comt_liked);
                vcc.setComt_dislike(comt_dislike);
                try {
                    videoCommService.updVideocomm(vcc);
                    json.put("msg","success");
                }catch (Exception e){
                    json.put("msg","error");
                }
            }
        }
        return  json;
    }
    @RequestMapping("/delVideocomm")
    @ResponseBody
    public JSONObject delVideocomm(int id){
        JSONObject json = new JSONObject();
        try {
            videoCommService.delVideocomm(id);
            json.put("msg","success");
        }catch (Exception e){
            json.put("msg","error");
        }

        return  json;
    }

}
