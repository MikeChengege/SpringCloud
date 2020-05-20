package com.stu.springcloud.controller;

import cn.hutool.json.JSONObject;
import com.stu.springcloud.mapper.UserInfoMapper;
import com.stu.springcloud.model.User;
import com.stu.springcloud.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


/**
 * Created by mikechen on 2018/9/21.
 */
@RestController
public class UserInfoController {
    @Autowired
    UserInfoMapper userinfomapper;
    @Autowired
    UserService userService;
    @RequestMapping("/Verification")
    @ResponseBody
    public User Verification(String username){
        User us =  userService.getUser(username);
        return us;
    }
    @RequestMapping("/IsVerification")
    @ResponseBody
    public JSONObject IsVerification(String username,String passwd){
        User us =  userService.getUser(username);
        JSONObject jsonObject = new JSONObject();
        if(us!=null){
            String rightpass =us.getPassword();
            if(passwd.equals(rightpass)){
                jsonObject.put("result", "success");
//                session.setAttribute("useInfo",us);//把值存入session
            }else {
                jsonObject.put("result", "passwordError");
            }
        } else {
            jsonObject.put("result", "NoUser");
        }
        return  jsonObject;
    }
    @RequestMapping("/getUserInfoById")
    @ResponseBody
    public User getUserInfoById(int uid){
        User us =  userService.getById(uid);
        return us;
    }
    @RequestMapping("/updateUser")
    @ResponseBody
    public void updateUser(@RequestBody User user){
        userService.updateUser(user);
    }

    @RequestMapping("/setUser")
    @ResponseBody
    public void setUser(@RequestBody User us){
        userService.setUser(us);
    }


    @RequestMapping("/destroyUser")
    @ResponseBody
    public void destroyUser(int id){
        userService.destroyUser(id);
    }

    @RequestMapping("/getAllUser")
    @ResponseBody
    public List<User> getAllUser(){
        return userService.getAllUser();
    }
//    @RequestMapping("/loginVerification/Verification")
//    @ResponseBody
//    public JSONObject loginVerification(String username){
//        String name = loginandregisterservice.findHasUserName(username);
//        JSONObject jsonObject = new JSONObject();
//        if(name.equals("N")){
//            jsonObject.put("msg", "success");
//        }
//        else{
//            jsonObject.put("msg", "error");
//        }
//        return jsonObject;
//    }
//
////    插入数据库
//    @RequestMapping("/confirmVerification")
//    @ResponseBody
//    public JSONObject rigistConfVerification(User user){
//        JSONObject jsonObject = new JSONObject();
//        User us = userinfomapper.get(user.getUsername());
//        if (us!=null){
//            jsonObject.put("msg", "error");
//            return jsonObject;
//        }else {
//            userinfomapper.setUser(user);
//        }
//        String getPs  = userinfomapper.getPs(user.getUsername());
//        if(getPs!=null){
//            jsonObject.put("msg", "success");
//        }
//        else{
//            jsonObject.put("msg", "error");
//        }
//        return jsonObject;
//    }
//    //    个人信息页面基本信息获取
//    @RequestMapping("/getBaseinfomation")
//    @ResponseBody
//    public User getBaseinfomation(String username){
//        User us  = userinfomapper.get(username);
//        return us;
//    }
//    @RequestMapping("/datagridjson")
//    @ResponseBody
//    public Map<String, Object> datagridjson(@RequestParam(name = "page", defaultValue = "1") int page, @RequestParam(name = "rows", defaultValue = "10") int rows){
//          int start = (page-1)*rows+1;
//          int size = rows;
//          PageHelper.startPage(start,size,"id desc");
//          List<Video> lv = videoinfomapper.getAll();
//          PageInfo<Video> pagev = new PageInfo<>(lv);
//          List<Video> lvs = new ArrayList<>();
//          int i=0;
//            for (Video vi:lv) {
//                i++;
//                if(i>=start&&i<start+size){
//                    lvs.add(vi);
//                }
//            }
//          Map<String, Object> map = new HashMap<>();
//          map.put("rows", lvs);
//          map.put("total", pagev.getTotal());
//          return map;
//    }
//    @RequestMapping("/getuserinfomation")
//    @ResponseBody
//    public Map<String, Object> getUserInfomation(@RequestParam(name = "page", defaultValue = "1") int page, @RequestParam(name = "rows", defaultValue = "10") int rows){
//          int size = rows;
//          int start = (page-1)*rows+1;
//          PageHelper.startPage(start,size,"id desc");
//          List<User> lus = userinfomapper.getAllUser();
//          PageInfo<User> pagev = new PageInfo<>(lus);
//          List<User> lvs = new ArrayList<>();
//          int i=0;
//            for (User vi:lus) {
//                i++;
//                if(i>=start&&i<start+size){
//                    lvs.add(vi);
//                }
//            }
//          Map<String, Object> map = new HashMap<>();
//          map.put("rows", lvs);
//          map.put("total", pagev.getTotal());
//          return map;
//    }

//    @RequestMapping("/updateUserPhoto")
//    @ResponseBody
//    public JSONObject updateUserPhoto(User us){
//        JSONObject json = new JSONObject();
//        try{
//            userinfomapper.updateUserPhoto(us);
//            json.put("msg","success");
//        }catch (Exception e){
//            json.put("msg",e);
//        }
//        return json;
//    }
//    @RequestMapping("/destroyUser")
//    @ResponseBody
//    public JSONObject destroyUser(int id){
//        JSONObject json = new JSONObject();
//        try{
//            userinfomapper.destroyUser(id);
//            json.put("success","success");
//        }catch (Exception e){
//            json.put("errorMsg",e);
//        }
//        return json;
//    }
//    @RequestMapping("/setNewUser")
//    @ResponseBody
//    public JSONObject setNewUser(User us){
//        JSONObject json = new JSONObject();
//        try{
//            JSONObject jj = loginVerification(us.getUsername());
//            if(jj.get("msg")=="success"){
//                Date dt = new Date();
//                SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
//                String nowtime = df.format(dt).toString();
//                us.setRegdate(nowtime);
//                if(us.getPhoto()==null){
//                    us.setPhoto("/images/touxiang/tou1.jpg");
//                }
//                userinfomapper.setUser(us);
//                json.put("success","success");
//            }else {
//                json.put("errorMsg","用户名已存在!");
//            }
//        }catch (Exception e){
//            json.put("errorMsg",e);
//        }
//        return json;
//    }

}
