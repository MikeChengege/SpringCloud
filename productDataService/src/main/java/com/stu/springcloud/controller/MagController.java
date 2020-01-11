package com.stu.springcloud.controller;



import com.stu.springcloud.model.Manager;
import com.stu.springcloud.model.UserAdv;
import com.stu.springcloud.service.MaginfoService;
import com.stu.springcloud.service.UserAdvService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.text.SimpleDateFormat;
import java.util.Date;


/**
 * Created by mikechen on 2018/9/21.
 */
@Controller
public class MagController {
    @Autowired
    UserAdvService userAdvService;

    @Autowired
    MaginfoService maginfoService;

    @RequestMapping("/getMangByName")
    @ResponseBody
    public Manager getMangByName(String name){
        return maginfoService.getMangByName(name);
    }
    @RequestMapping("/submitAdvice")
    @ResponseBody
    public void submitAdvice(UserAdv uadv){
        userAdvService.submitAdvice(uadv);
    }
//    @RequestMapping("/savedgrid")
//    @ResponseBody
//    public void savedgrid(Video vi){
//        System.out.println();
//    }
//    @RequestMapping("/updatedgrid")
//    @ResponseBody
//    public JSONObject updatedgrid(int id,int video_type,String video_title,String video_descript,String video_address,String video_pic,int video_exam){
//        Video vi = new Video();
//        JSONObject json = new JSONObject();
//        if(id!=0){
//            vi = videoinfomapper.getVideoById(id);
//            if(vi!=null){
//                vi.setVideo_type(video_type);
//                vi.setVideo_address(video_address);
//                vi.setVideo_descript(video_descript);
//                vi.setVideo_pic(video_pic);
//                vi.setVideo_exam(video_exam);
//                vi.setVideo_title(video_title);
//                try{
//                videoinfomapper.magUpdate(vi);
//                    json.put("msg","success");
//                }catch (Exception e){
//                    json.put("msg",e);
//                }
//            }
//        }else {
//            json.put("msg","error");
//        }
//        return json;
//    }
//    @RequestMapping("/deletevideo")
//    @ResponseBody
//    public void deletevideo(int id){
//        if(id!=0){
//            try {
//                videoinfomapper.deleteById(id);
//            }catch (Exception e){
//                System.out.println(e);
//            }
//        }
//    }
//    @RequestMapping(value ="/maguploadvideo",method = RequestMethod.POST)
//    public String getInformation(@RequestParam("subpic") MultipartFile fpic, @RequestParam("subvideo") MultipartFile fvid, String videoadd, int vid, Model m, HttpServletResponse resp){
//        try{
//            if(fpic.isEmpty()&&vid>0){
//                m.addAttribute("msg","error");
//            }else{
//                String picName = System.currentTimeMillis()+fpic.getOriginalFilename();
//                String destFileName="D:/uploadFiles/img/";
////                String destFileName="/uploadFiles/img/";
//                String picfile =destFileName +picName;
//                File destFile1 = new File(picfile);
//                destFile1.getParentFile().mkdirs();
//                fpic.transferTo(destFile1);
//                Video vi  = videoinfomapper.getVideoById(vid);
//                if(fvid.isEmpty()&&videoadd==""){
//                    m.addAttribute("msg","error");
//                }else {
//                    if(!fvid.isEmpty()){
//                        String vidName = System.currentTimeMillis()+fvid.getOriginalFilename();
//                        String destFileName2="D:/uploadFiles/vid/";
////                        String destFileName2="/uploadFiles/vid/";
//                        String vicfile =destFileName2 +vidName;
//                        File destFile2 = new File(vicfile);
//                        destFile2.getParentFile().mkdirs();
//                        fvid.transferTo(destFile2);
//                        if(vi!=null){
////                            本地地址
//                            m.addAttribute("msg","success");
//                            vi.setVideo_pic("http://localhost:8080/img/"+picName);
//                            vi.setVideo_address("http://localhost:8080/vid/"+vidName);
//
////                           服务器地址
////                            vi.setVideo_pic("http://106.13.77.233:8080/img/"+picName);
////                            vi.setVideo_address("http://106.13.77.233:8080/vid/"+vidName);
//                        }
//                    }else {
//                        if(vi!=null){
//                            vi.setVideo_pic("http://localhost:8080/img/"+picName);
//                            vi.setVideo_address("http://localhost:8080/vid/"+videoadd);
//                            m.addAttribute("msg","success");
//                            //   服务器地址
////                            vi.setVideo_pic("http://106.13.77.233:8080/img/"+picName);
////                            vi.setVideo_address("http://106.13.77.233:8080/vid/"+videoadd);
//
//                        }
//                    }
//                    videoinfomapper.magUpdate(vi);
//                }
//            }
////            String destFileName=req.getServletContext().getRealPath("")+"uploaded"+ File.separator;获取项目内地址
////            m.addAttribute("picName",picName);放进类似于session
//        }catch (Exception e){
//            e.printStackTrace();
//        }
//        return "redirect:http://localhost:8080/MostTV/magindex";
////        return "redirect:http://106.13.77.233:8080/MostTV/magindex";
//    }
//    @RequestMapping("/maguploadvideoinfo")
//    @ResponseBody
//    public JSONObject uploadvideoinfo(Video vi){
//        Date day = new Date();
//        JSONObject json = new JSONObject();
//        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
//        String nowtime = df.format(day).toString();
//        vi.setVideo_time(nowtime);
//        VideoSub vs = new VideoSub();
//        try {
//            int  maguserindex = vi.getVideo_peop().indexOf("：");
//            vi.setVideo_peop(vi.getVideo_peop().substring(maguserindex+1,vi.getVideo_peop().length()));
//            videoinfomapper.insertVideoInfo(vi);
//            vi =  videoinfomapper.getVideoByTitle(vi);
//            videosubmapper.insertVidSub(vi.getId());
//            json.put("id",vi.getId());
//            json.put("msg","success");
//        }catch (Exception e){
//            json.put("msg",e);
//        }
//        return json;
//    }




}
