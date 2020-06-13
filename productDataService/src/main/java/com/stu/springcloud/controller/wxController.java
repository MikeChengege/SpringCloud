package com.stu.springcloud.controller;

import cn.hutool.json.JSONObject;
import com.stu.springcloud.mapper.UserInfoMapper;
import com.stu.springcloud.model.*;
import com.stu.springcloud.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;


/**
 * Created by mikechen on 2018/9/21.
 */
@RestController
public class wxController {
    @Autowired
    VideoInfoService videoInfoService;
    @Autowired
    UserInfoMapper userinfomapper;
    @Autowired
    UserSeeHistoryService userSeeHistoryService;
    @Autowired
    UserService userService;
    @Autowired
    UserCollService userCollService;
    @Autowired
    UserAdvService userAdvService;
    @Autowired
    VideoCommService videoCommService;
    @RequestMapping("/IsVerification")
    @ResponseBody
    public JSONObject IsVerification(String username,String passwd){
        User us =  userService.getUser(username);
        JSONObject jsonObject = new JSONObject();
        if(us!=null){
            String rightpass =us.getPassword();
            if(passwd.equals(rightpass)){
                jsonObject.put("result", "success");
                jsonObject.put("userId", us.getId());
//                session.setAttribute("useInfo",us);//把值存入session
            }else {
                jsonObject.put("result", "passwordError");
            }
        } else {
            jsonObject.put("result", "NoUser");
        }
        return  jsonObject;
    }
    @RequestMapping("/wxGetHadView")
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
        return json;
    }
    @RequestMapping("/wxGetUserCollection")
    @ResponseBody
    public JSONObject getUserCollection(int id){
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
    @RequestMapping("/wxSubmitAdvice")
    @ResponseBody
    public JSONObject submitAdvice(String uid,String advtext){
        JSONObject json = new JSONObject();
        Date day = new Date();
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String nowtime = df.format(day).toString();
        UserAdv uadv = new UserAdv();
        uadv.setUser_id(Integer.parseInt(uid));
        uadv.setAdvtext(advtext);
        uadv.setAdvtime(nowtime);
        try{
            userAdvService.submitAdvice(uadv);
            json.put("msg","success");
        }catch (Exception e){
            json.put("msg",e);
        }
        return  json;
    }
    @RequestMapping("/wxGetSearchContent")
    @ResponseBody
    public List<Video> getSearchContent(String searcon){
        JSONObject jsonObject = new JSONObject();
        List<Video> lv = new ArrayList<>();
        if(searcon!=null&&searcon!=""){
            searcon = "%"+searcon+"%";
            try {
                lv = videoInfoService.getSearchContent(searcon);
            }catch (Exception e){
                System.out.println(e);
            }
        }
        return lv;
    }
    @RequestMapping("/wxUpdateVideoAddr")
    @ResponseBody
    public String updateVideoAddr(String oldip,String newip){
        List<Video> oldvl =videoInfoService.getAll();
        for (Video vi:oldvl) {
            String newVaddr = vi.getVideo_address().replaceAll(oldip,newip);
            String newPaddr = vi.getVideo_pic().replaceAll(oldip,newip);
            vi.setVideo_address(newVaddr);
            vi.setVideo_pic(newPaddr);
            videoInfoService.magUpdate(vi);
        }
         return "yes";

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
                        json.put("msg","hadcollage");
                        break;
                    }else{
                        json.put("msg","nocollage");
                        continue;
                    }
                }
            }else {
                json.put("msg","nocollage");
            }
        }else {
            json.put("msg","error");
        }
        return json;
    }
    @RequestMapping("/changeCollect")
    @ResponseBody
    public JSONObject addCollect(String videoid,String  userid,Boolean type){
        JSONObject json = new JSONObject();
        try {
            UserCollection userCollection = new UserCollection();
            userCollection.setUserid(Integer.parseInt(userid));
            userCollection.setVideoid(Integer.parseInt(videoid));
            if(type){
                userCollService.addCollect(userCollection);
                json.put("msg","success");
            }else{
                userCollService.deleteCollect(userCollection);
                json.put("msg","success");
            }
        }catch (Exception e){
            json.put("msg","error");
        }

        return json;
    }
    @RequestMapping("/wxAddComment")
    @ResponseBody
    public JSONObject addComment(VideoComm vicm){
        JSONObject json = new JSONObject();
        if (vicm.getComt_content()==null){
            json.put("msg","error");
        }else{
            try {
                Date day = new Date();
                SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                String nowtime = df.format(day).toString();
                vicm.setComt_time(nowtime);
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
}
