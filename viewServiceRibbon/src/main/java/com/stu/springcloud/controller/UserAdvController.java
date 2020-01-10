package com.stu.springcloud.controller;


import cn.hutool.json.JSONObject;
import com.stu.springcloud.modle.UserView;
import com.stu.springcloud.modle.Video;
import com.stu.springcloud.service.UserSeeHistoryService;
import com.stu.springcloud.service.VideoInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;


import java.text.SimpleDateFormat;
import java.util.*;

/**
 * Created by mikechen on 2018/9/21.
 */
@Controller
public class UserAdvController {

    @Autowired
    UserSeeHistoryService userSeeHistoryService;
    @Autowired
    VideoInfoService videoInfoService;
    @RequestMapping("/getHadView")
    @ResponseBody
    public JSONObject getHadView(int id){
        JSONObject json = new JSONObject();
        List<UserView> luv = userSeeHistoryService.getHadSee(id);
        List<Video> lv = new ArrayList<>();
        for (UserView uv: luv) {
            Video v = videoInfoService.getVideoById(uv.getVideoid());
            if(v!=null){
                lv.add(v);
            }
        }
        json.put("msg",lv);
        return  json;
    }
//    @RequestMapping("/getUserAdv")
//    @ResponseBody
//    public Map<String, Object> getUserInfomation(@RequestParam(name = "page", defaultValue = "1") int page, @RequestParam(name = "rows", defaultValue = "10") int rows){
//        int start = (page-1)*rows+1;
//        int size = rows;
//        PageHelper.startPage(start,size,"id desc");
//        List<UserAdv> lus = useradvmapper.getAdv();
//        PageInfo<UserAdv> pagev = new PageInfo<>(lus);
//        List<UserAdv> lvs = new ArrayList<>();
//        int i=0;
//        for (UserAdv vi:lus) {
//            i++;
//            if(i>=start&&i<start+size){
//                lvs.add(vi);
//            }
//        }
//        Map<String, Object> map = new HashMap<>();
//        map.put("rows", lvs);
//        map.put("total", pagev.getTotal());
//        return map;
//    }
//    @RequestMapping("/updateUserAdv")
//    @ResponseBody
//    public JSONObject updateUserAdv(UserAdv uav){
//        JSONObject json = new JSONObject();
//        try{
//            useradvmapper.updateUserAdv(uav);
//            json.put("msg","success");
//        }catch (Exception e){
//            json.put("errorMsg",e);
//        }
//        return  json;
//    }
//    @RequestMapping("/deleteUserAdv")
//    @ResponseBody
//    public JSONObject deleteUserAdv(int id){
//        JSONObject json = new JSONObject();
//        try {
//            UserAdv uav = useradvmapper.getAdvById(id);
//            if(uav!=null){
//                useradvmapper.deleteUserAdv(id);
//                json.put("success","success");
//            }else {
//                json.put("errorMsg","此用户不存在");
//            }
//        }catch (Exception e){
//            json.put("errorMsg",e);
//        }
//        return  json;
//    }
//
    @RequestMapping("/addHadView")
    @ResponseBody
    public  JSONObject addHadView(UserView uv){
        JSONObject json = new JSONObject();
        Date day = new Date();
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String nowtime = df.format(day).toString();
        try{
           List<UserView> luv = userSeeHistoryService.getHadSee(uv.getUserid());
            UserView uu = userSeeHistoryService.getSeemHadSee(uv);
            if(uu!=null){
                userSeeHistoryService.deleteHadSee(uu.getId());
            }else if(luv.size()==8){
               UserView lastv = luv.get(luv.size()-1);
               userSeeHistoryService.deleteHadSee(lastv.getId());
           }
            uv.setVistime(nowtime);
            userSeeHistoryService.addUserView(uv);
            json.put("msg","success");
        }catch (Exception e){
            json.put("msg",e);
        }
        return json;
    }




}
