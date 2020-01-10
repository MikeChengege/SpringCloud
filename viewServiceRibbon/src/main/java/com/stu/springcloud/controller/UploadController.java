package com.stu.springcloud.controller;


import cn.hutool.json.JSONObject;
import com.stu.springcloud.modle.User;
import com.stu.springcloud.modle.Video;
import com.stu.springcloud.modle.VideoSub;
import com.stu.springcloud.service.UserInfoService;
import com.stu.springcloud.service.VideoInfoService;
import com.stu.springcloud.service.VideoSubService;
import it.sauronsoftware.jave.MultimediaInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import it.sauronsoftware.jave.Encoder;
import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by mikechen on 2018/9/21.
 */
@Controller
public class UploadController {
    @Autowired
    VideoInfoService videoInfoService;
    @Autowired
    VideoSubService videoSubService;
    @Autowired
    UserInfoService userInfoService;
    @RequestMapping(value ="/uploadvideo",method = RequestMethod.POST)
    public String getInformation(@RequestParam("subpic") MultipartFile fpic, @RequestParam("subvideo") MultipartFile fvid, String videoadd, int vid, Model m){
        VideoSub vs = new VideoSub();
        try{
            if(fpic.isEmpty()&&vid>0){
                m.addAttribute("msg","error");
            }else{
                String picName = System.currentTimeMillis()+fpic.getOriginalFilename();
                String destFileName="D:/uploadFiles/img/";
//                String destFileName="/uploadFiles/img/";
                String picfile =destFileName +picName;
                File destFile1 = new File(picfile);
                destFile1.getParentFile().mkdirs();
                fpic.transferTo(destFile1);
                Video vi  = videoInfoService.getVideoById(vid);
                if(fvid.isEmpty()&&videoadd==""){
                    m.addAttribute("msg","error");
                }else {
                    if(!fvid.isEmpty()){
                        Encoder encoder = new Encoder();
                        String vidName = System.currentTimeMillis()+fvid.getOriginalFilename();
//                        本机地址
                        String destFileName2="D:/uploadFiles/vid/";
//                        服务器地址
//                        String destFileName2="/uploadFiles/vid/";
                        String vicfile =destFileName2 +vidName;
                        File destFile2 = new File(vicfile);
                        destFile2.getParentFile().mkdirs();
                        fvid.transferTo(destFile2);
                        MultimediaInfo md = encoder.getInfo(destFile2);
                        long ls = md.getDuration()/1000;
                        int hour = (int) (ls/3600);
                        int minute = (int) (ls%3600)/60;
                        int second = (int) (ls-hour*3600-minute*60);
                        String length = hour+":"+minute+":"+second;
                        vs.setVideo_id(vi.getId());
                        vs.setVideo_duration(length);
                        videoSubService.updateSubTime(vs);
                        if(vi!=null){
                            vi.setVideo_pic("/img/"+picName);
                            vi.setVideo_address("/vid/"+vidName);
//                           服务器地址
//                            vi.setVideo_pic("http://106.13.77.233:8080/img/"+picName);
//                            vi.setVideo_address("http://106.13.77.233:8080/vid/"+vidName);
                            m.addAttribute("msg","success");
                        }
                    }else {
                        if(vi!=null){
                            vi.setVideo_pic("http://localhost:8080/img/"+picName);
                            vi.setVideo_address("http://localhost:8080/vid/"+videoadd);
                            m.addAttribute("msg","success");
//                           服务器地址
//                            vi.setVideo_pic("http://106.13.77.233:8080/img/"+picName);
//                            vi.setVideo_address("http://106.13.77.233:8080/vid/"+videoadd);

                        }
                    }
                    videoInfoService.magUpdate(vi);
                }
            }

//            String destFileName=req.getServletContext().getRealPath("")+"uploaded"+ File.separator;获取项目内地址
//            m.addAttribute("picName",picName);放进类似于session
        }catch (Exception e){
            e.printStackTrace();
        }
        return "showupdate";
    }


    @RequestMapping("/uploadvideoinfo")
    @ResponseBody
    public JSONObject uploadvideoinfo(Video vi){
        JSONObject json = new JSONObject();
        Date day = new Date();
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String nowtime = df.format(day).toString();
        vi.setVideo_time(nowtime);
        VideoSub vs = new VideoSub();
        try {
            User u = userInfoService.getUserInfoById(Integer.parseInt(vi.getVideo_peop()));
            vi.setVideo_peop(u.getUsername());
            videoInfoService.insertVideoInfo(vi);
            vi =  videoInfoService.getVideoByTitle(vi);
            videoSubService.insertVidSub(vi.getId());
            json.put("msg","success");
            json.put("id",vi.getId());
        }catch (Exception e){
            json.put("msg",e);
        }
        return json;
    }
}
