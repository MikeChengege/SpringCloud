package com.stu.springcloud.controller;



import cn.hutool.json.JSONObject;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.stu.springcloud.modle.Manager;
import com.stu.springcloud.modle.UserAdv;
import com.stu.springcloud.modle.Video;
import com.stu.springcloud.modle.VideoSub;
import com.stu.springcloud.service.MaginfoService;
import com.stu.springcloud.service.UserAdvService;
import com.stu.springcloud.service.VideoInfoService;
import com.stu.springcloud.service.VideoSubService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.File;
import java.text.SimpleDateFormat;
import java.util.*;


/**
 * Created by mikechen on 2018/9/21.
 */
@Controller
public class MagController {
    @Autowired
    UserAdvService userAdvService;

    @Autowired
    MaginfoService maginfoService;
    @Autowired
    VideoInfoService videoInfoService;
    @Autowired
    VideoSubService videoSubService;
    @RequestMapping("/magVerification")
    @ResponseBody
    public JSONObject MagVerification(Manager manager, HttpServletRequest request, HttpServletResponse response){
        String newpass =manager.getPassword();
        Manager mg  = maginfoService.getMangByName(manager.getUsername());
        JSONObject jsonObject = new JSONObject();
        HttpSession session = request.getSession();
        if(mg!=null){
            String rightpass =mg.getPassword();
            if(newpass.equals(rightpass)){
                jsonObject.put("msg", "success");
                session.setAttribute("maguser",mg);//把值存入session
            }else {
                jsonObject.put("msg", "error");
            }
        } else {
            jsonObject.put("msg", "NoUser");
        }
        return jsonObject;
    }
    @RequestMapping("/submitAdvice")
    @ResponseBody
    public JSONObject submitAdvice(UserAdv uadv){
        JSONObject json = new JSONObject();
        Date day = new Date();
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String nowtime = df.format(day).toString();
        uadv.setAdvtime(nowtime);
        try{
            userAdvService.submitAdvice(uadv);
            json.put("msg","success");
        }catch (Exception e){
            json.put("msg",e);
        }
        return  json;
    }
//    @RequestMapping("/savedgrid")
//    @ResponseBody
//    public void savedgrid(Video vi){
//        System.out.println();
//    }
    @RequestMapping("/updatedgrid")
    @ResponseBody
    public JSONObject updatedgrid(int id,int video_type,String video_title,String video_descript,String video_address,String video_pic,int video_exam){
        Video vi = new Video();
        JSONObject json = new JSONObject();
        if(id!=0){
            vi = videoInfoService.getVideoById(id);
            if(vi!=null){
                vi.setVideo_type(video_type);
                vi.setVideo_address(video_address);
                vi.setVideo_descript(video_descript);
                vi.setVideo_pic(video_pic);
                vi.setVideo_exam(video_exam);
                vi.setVideo_title(video_title);
                try{
                    videoInfoService.magUpdate(vi);
                    json.put("msg","success");
                }catch (Exception e){
                    json.put("msg",e);
                }
            }
        }else {
            json.put("msg","error");
        }
        return json;
    }
    @RequestMapping("/deletevideo")
    @ResponseBody
    public void deletevideo(int id){
        if(id!=0){
            try {
                videoInfoService.deleteById(id);
            }catch (Exception e){
                System.out.println(e);
            }
        }
    }
    @RequestMapping(value ="/maguploadvideo",method = RequestMethod.POST)
    public String getInformation(@RequestParam("subpic") MultipartFile fpic, @RequestParam("subvideo") MultipartFile fvid, String videoadd, int vid, Model m, HttpServletResponse resp){
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
                        String vidName = System.currentTimeMillis()+fvid.getOriginalFilename();
                        String destFileName2="D:/uploadFiles/vid/";
//                        String destFileName2="/uploadFiles/vid/";
                        String vicfile =destFileName2 +vidName;
                        File destFile2 = new File(vicfile);
                        destFile2.getParentFile().mkdirs();
                        fvid.transferTo(destFile2);
                        if(vi!=null){
//                            本地地址
                            m.addAttribute("msg","success");
                            vi.setVideo_pic("http://localhost:8012/img/"+picName);
                            vi.setVideo_address("http://localhost:8012/vid/"+vidName);

//                           服务器地址
//                            vi.setVideo_pic("http://106.13.77.233:8080/img/"+picName);
//                            vi.setVideo_address("http://106.13.77.233:8080/vid/"+vidName);
                        }
                    }else {
                        if(vi!=null){
                            vi.setVideo_pic("http://localhost:8012/img/"+picName);
                            vi.setVideo_address("http://localhost:8012/vid/"+videoadd);
                            m.addAttribute("msg","success");
                            //   服务器地址
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
        return "redirect:http://127.0.0.1:8012/Mosttv/magindex";
//        return "redirect:http://106.13.77.233:8080/MostTV/magindex";
    }
    @RequestMapping("/maguploadvideoinfo")
    @ResponseBody
    public JSONObject uploadvideoinfo(Video vi){
        Date day = new Date();
        JSONObject json = new JSONObject();
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String nowtime = df.format(day).toString();
        vi.setVideo_time(nowtime);
        VideoSub vs = new VideoSub();
        try {
            int  maguserindex = vi.getVideo_peop().indexOf("：");
            vi.setVideo_peop(vi.getVideo_peop().substring(maguserindex+1,vi.getVideo_peop().length()));
            videoInfoService.insertVideoInfo(vi);
            vi =  videoInfoService.getVideoByTitle(vi);
            videoSubService.insertVidSub(vi.getId());
            json.put("id",vi.getId());
            json.put("msg","success");
        }catch (Exception e){
            json.put("msg",e);
        }
        return json;
    }
    @RequestMapping("/getvideovisit")
    @ResponseBody
    public Map<String, Object> getvideovisit(@RequestParam(name = "page", defaultValue = "1") int page, @RequestParam(name = "rows", defaultValue = "10") int rows){
        int start = (page-1)*rows+1;
        int size = rows;
        List<VideoSub> lv = videoSubService.getSub();
        PageHelper.startPage(start,size,"id desc");
        PageInfo<VideoSub> pagev = new PageInfo<>(lv);
        List<VideoSub> lvs = new ArrayList<>();
        int i=0;
        for (VideoSub vi:lv) {
            i++;
            if(i>=start&&i<start+size){
                lvs.add(vi);
            }
        }
        Map<String, Object> map = new HashMap<>();
        map.put("rows",lvs);
        map.put("total", pagev.getTotal());
        return map;
    }
    @RequestMapping("/updateVideoSub")
    @ResponseBody
    public JSONObject updateVideoSub(VideoSub vsm){
        JSONObject json = new JSONObject();
        if(vsm.getId()!=0){
            try {
                VideoSub vs =   videoSubService.getSubById(vsm.getId());
                if(vs!=null){
                    vs.setVideo_hot(vsm.getVideo_hot());
                    vs.setVideo_score(vsm.getVideo_score());
                    vs.setVideo_backtime(vsm.getVideo_backtime());
                    vs.setVideo_playtype(vsm.getVideo_playtype());
                    vs.setVideo_updatetiem(vsm.getVideo_updatetiem());
                    vs.setVideo_videotype(vsm.getVideo_videotype());
                    try{
                        videoSubService.updateSub(vs);
                        json.put("msg","success");
                    }catch (Exception e){
                        json.put("msg","error");
                    }

                }
            }catch (Exception e){
                System.out.println(e);
            }
        }
        return  json;
    }


}
