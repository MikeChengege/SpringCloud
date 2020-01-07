package com.stu.springcloud.controller;



import com.stu.springcloud.modle.Video;
import com.stu.springcloud.service.VideoInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

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
/*    @RequestMapping("/getvideoPage")
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
    }*/


//    @RequestMapping("/getVideoById")
//    @ResponseBody
//    public  Video getVideoById(int id){
//        Video video = new Video();
//        if (id>=0){
//            video = videoinfomapper.getVideoById(id);
//        }
//        return video;
//    }
//    @RequestMapping("/getNextVideo")
//    @ResponseBody
//    public  List<Video> getVideoByType(int videotype,int limit){
//        List<Video> lvo = new ArrayList<>();
//            if (videotype>=0){
//                lvo = videoinfomapper.getAllByType(videotype,limit);
//        }
//        return lvo;
//    }
//
//    @RequestMapping("/updateLike")
//    @ResponseBody
//    public boolean updateLike(int like,int dislike,int videoid){
//        Video video = videoinfomapper.getVideoById(videoid);
//        if(video!=null){
//            video.setVideo_like(like);
//            video.setVideo_dislike(dislike);
//            videoinfomapper.updateAll(video);
//            return true;
//        }else{
//            return false;
//        }
//    }
//    @RequestMapping("/getVideoComm")
//    @ResponseBody
//    public List<VideoComm> getVideoComm(int id){
//        List<VideoComm> videoComm = new ArrayList<>();
//        videoComm =videovommmapper.getCommAndPeo(id);
//        return videoComm;
//    }
//
//    @RequestMapping("/addComment")
//    @ResponseBody
//    public JSONObject addComment(VideoComm vicm){
//        JSONObject json = new JSONObject();
//        if (vicm.getComt_content()==null){
//            json.put("msg","error");
//        }else{
//            try {
//                vicm.setComt_liked(0);
//                videovommmapper.insertComm(vicm);
//                Video vi =  videoinfomapper.getVideoById(vicm.getVideo_id());
//                vi.setVideo_comment(vi.getVideo_comment()+1);
//                videoinfomapper.updateVideoComm(vi);
//                json.put("msg","success");
//            }catch (Exception e){
//                json.put("msg",e);
//            }
//        }
//        return json;
//    }
//    @RequestMapping("/updateHadLike")
//    @ResponseBody
//    public JSONObject updateLike(VideoComm vicm){
//        JSONObject json = new JSONObject();
//        VideoComm videocomm = videovommmapper.getById(vicm.getId());
//        if(videocomm!=null){
//            try{
//                videovommmapper.updateHadLike(vicm);
//                json.put("msg","success");
//            }catch (Exception e){
//                json.put("msg",e);
//            }
//        }else {
//            json.put("msg","error");
//        }
//        return json;
//    }
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
//    @RequestMapping("/getSubTv")
//    @ResponseBody
//    public JSONObject getSubTv(int videoid){
//        JSONObject json = new JSONObject();
//        try {
//            List<TvSub> lts = tvsubmapper.getTvSub(videoid);
//            json.put("msg",lts);
//        }catch (Exception e){
//            json.put("msg","error");
//        }
//
//        return  json;
//    }

}
