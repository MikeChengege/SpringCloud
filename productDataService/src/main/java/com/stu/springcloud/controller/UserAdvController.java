package com.stu.springcloud.controller;

import com.stu.springcloud.model.UserView;
import com.stu.springcloud.service.UserSeeHistoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class UserAdvController {
    @Autowired
    UserSeeHistoryService userSeeHistoryService;
    @RequestMapping("/getHadView")
    @ResponseBody
    public List<UserView> getHadView(int uid){
        return userSeeHistoryService.getHadSee(uid);
    }
    @RequestMapping("/getSeemHadSee")
    @ResponseBody
    public UserView getSeemHadSee(@RequestBody UserView userView){
        return userSeeHistoryService.getSeemHadSee(userView);
    }
    @RequestMapping("/deleteHadSee")
    @ResponseBody
    public void deleteHadSee(int vid){
        userSeeHistoryService.deleteHadSee(vid);
    }
    @RequestMapping("/addUserView")
    @ResponseBody
    public void addUserView(@RequestBody UserView userView){
        userSeeHistoryService.addUserView(userView);
    }
}
