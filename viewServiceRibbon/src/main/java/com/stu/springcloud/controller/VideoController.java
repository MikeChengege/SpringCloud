package com.stu.springcloud.controller;



import cn.hutool.json.JSONObject;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.stu.springcloud.modle.TvSub;
import com.stu.springcloud.modle.User;
import com.stu.springcloud.modle.Video;
import com.stu.springcloud.modle.VideoComm;
import com.stu.springcloud.service.VideoCommService;
import com.stu.springcloud.service.VideoInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;
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
    public List<Video> mostseeGetVideoInf(){
        List<Video> limag = videoInfoService.getMostseeInfoAll();
        return limag;
    }
    @RequestMapping("/getRankinfo")
    @ResponseBody
   public List<Video> getRankinfo(){
        List<Video> limag = videoInfoService.getRankBothAll();
        return limag;
    }
   @RequestMapping("/getvideoPage")
    @ResponseBody
    public PageInfo getPageVideo(Model m, @RequestParam(value = "start", defaultValue = "0") int start, @RequestParam(value = "size", defaultValue = "5") int size) throws Exception {
        PageHelper.startPage(start,size,"id desc");
        List<Video> cs=videoInfoService.getVideoInfo();
        List<Video> lvo = new ArrayList<>();
        if(cs!=null){
            int i = 0;
            for (Video v:cs) {
                if(i>=start&&i<start+10){
                    lvo.add(v);
                }
                i++;
            }
        }
        PageInfo<Video> page = new PageInfo<>(lvo);
        m.addAttribute("page", page);
        return page;
    }
    @RequestMapping("/getVideoById")
    @ResponseBody
    public  Video getVideoById(int id){
        Video video = new Video();
        if (id>=0){
            video = videoInfoService.getVideoById(id);
        }
        return video;
    }
    @RequestMapping("/getNextVideo")
    @ResponseBody
    public  List<Video> getVideoByType(int videotype,int limit){
        List<Video> lvo = new ArrayList<>();
            if (videotype>=0){
                lvo = videoInfoService.getAllByType(videotype,limit);
        }
        return lvo;
    }

    @RequestMapping("/updateLike")
    @ResponseBody
    public boolean updateLike(int like,int dislike,int videoid){
        Video video = videoInfoService.getVideoById(videoid);
        if(video!=null){
            video.setVideo_like(like);
            video.setVideo_dislike(dislike);
            videoInfoService.updateAll(video);
            return true;
        }else{
            return false;
        }
    }
    @RequestMapping("/getVideoComm")
    @ResponseBody
    public List<VideoComm> getVideoComm(int id){
        List<VideoComm> videoComm = new ArrayList<>();
        videoComm =videoCommService.getCommAndPeo(id);
        return videoComm;
    }

    @RequestMapping("/addComment")
    @ResponseBody
    public JSONObject addComment(VideoComm vicm){
        JSONObject json = new JSONObject();
        if (vicm.getComt_content()==null){
            json.put("msg","error");
        }else{
            try {
                vicm.setComt_liked(0);
                videoCommService.insertComm(vicm);
                Video vi =  videoInfoService.getVideoById(vicm.getVideo_id());
                vi.setVideo_comment(vi.getVideo_comment()+1);
                videoInfoService.updateVideoComm(vi);
                json.put("msg","success");
            }catch (Exception e){
                json.put("msg",e);
            }
        }
        return json;
    }
    @RequestMapping("/updateHadLike")
    @ResponseBody
    public JSONObject updateLike(VideoComm vicm){
        JSONObject json = new JSONObject();
        VideoComm videocomm = videoCommService.getCommById(vicm.getId());
        if(videocomm!=null){
            try{
                videoCommService.updateHadLike(vicm);
                json.put("msg","success");
            }catch (Exception e){
                json.put("msg",e);
            }
        }else {
            json.put("msg","error");
        }
        return json;
    }
    @RequestMapping("/Mosttv/tvinfomation")
    public String tvinfomation(String name, int id, HttpSession session){
        if(id>=0){
            Video video =  videoInfoService.getVideoById(id);
            if(video.getVideo_hadvisit()>=0){
                int oldVis=video.getVideo_hadvisit();
                video.setVideo_hadvisit(++oldVis);
                try{
                    videoInfoService.updateHadVis(video);
                }catch (Exception e){
                    System.out.println(e);
                }
            }
        }
        if(session.getAttribute("useInfo")!=null){
            User u = (User)session.getAttribute("useInfo");
            session.setAttribute("sessionUser",u);
        }else {
            session.setAttribute("sessionUser",null);
        }
        return "tvinfomation";
    }
////    @RequestMapping("/downloadVideo")
////    @ResponseBody
////    public void downLoad(){
////        try {
////            OutputStream out = response.getOutputStream();
////            out.write(xmlContent.getBytes("UTF-8"));
////            out.flush();
////
////        } catch (IOException e) {
////            e.printStackTrace();
////        }
////    }
    @RequestMapping("/getSubTv")
    @ResponseBody
    public JSONObject getSubTv(int videoid){
        JSONObject json = new JSONObject();
        try {
            List<TvSub> lts = videoInfoService.getTvSub(videoid);
            json.put("msg",lts);
        }catch (Exception e){
            json.put("msg","error");
        }

        return  json;
    }
    @RequestMapping("/getSearchContent")
    @ResponseBody
    public List<Video> getSearchContent(String searcon){
        JSONObject jsonObject = new JSONObject();
        List<Video> lv = new ArrayList<>();
        if(searcon!=null&&searcon!=""){
            searcon = "%"+searcon+"%";
            try {
                lv = videoInfoService.getSearchContent(searcon);
                System.out.println("查出的结果为"+lv.toString());
            }catch (Exception e){
                System.out.println(e);
            }
        }
        return lv;
    }
}
