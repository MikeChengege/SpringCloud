package com.stu.springcloud.client;

import cn.hutool.json.JSONObject;
import com.stu.springcloud.modle.*;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

@FeignClient(value ="PRODUCT-DATA-SERVICE",fallback = ProductClientFeignHystrix.class )
public interface ProductClientRibbon {
    @GetMapping("/products")
    public List<Product> listProduct();
    @GetMapping("/userList")
    public List<User> userList();
    @GetMapping("/Verification")
    public User Verification(@RequestParam("username") String username);
    @GetMapping("/getVideoInf")
    public List<Video> getVideoInf();
    @GetMapping("/mostseeVideoInf")
    public List<Video> mostseeVideoInf();
    @GetMapping("/getRankinfo")
    public List<Video> getRankinfo();
    @GetMapping("/getAllTv")
    public List<Video> getAllTv(@RequestParam("videoType") int videoType);
    @GetMapping("/submitAdvice")
    public List<Video> submitAdvice(UserAdv uadv);
    @GetMapping("/userCollection")
    public List<UserCollection> userCollection(@RequestParam("id") int id);
    @GetMapping("/addCollect")
    public List<UserCollection> addCollect(@RequestBody UserCollection userCollection);
    @GetMapping("/deleteCollect")
    public List<UserCollection> deleteCollect(@RequestBody UserCollection userCollection);
    @GetMapping("/getVideoById")
    public Video getVideoById(@RequestParam("vid") int vid);
    @GetMapping("/getVideoByName")
    public List<Video> getVideoByName(@RequestParam("name") String name);
    @GetMapping("/getUserInfoById")
    public User getUserInfoById(@RequestParam("uid") int uid);
    @GetMapping("/updateUser")
    public User updateUser(@RequestBody User user);
    @GetMapping("/getHadView")
    public List<UserView> getHadView(@RequestParam("uid") int uid);
    @GetMapping("/updateVideo")
    public void updateVideo(@RequestBody Video vi);
    @GetMapping("/magUpdate")
    public void magUpdate(@RequestBody Video vi);
    @GetMapping("/updateHadVis")
    public void updateHadVis(@RequestBody Video vi);
    @GetMapping("/updateAll")
    public void updateAll(@RequestBody Video vi);
    @GetMapping("/deleteById")
    public void deleteById(@RequestParam("vid") int vid);
    @GetMapping("/getSeemHadSee")
    public UserView getSeemHadSee(@RequestBody UserView userView);
    @GetMapping("/deleteHadSee")
    public void deleteHadSee(@RequestParam("vid") int vid);
    @GetMapping("/addUserView")
    public void addUserView(@RequestBody UserView userView);

    @GetMapping("/getAllByType")
    public List<Video> getAllByType(@RequestParam("videotype") int videotype,@RequestParam("limit") int limit);

    @GetMapping("/getCommAndPeo")
    public List<VideoComm> getCommAndPeo(@RequestParam("id") int id);

    @GetMapping("/getCommById")
    public VideoComm getCommById(@RequestParam("id") int id);
    @GetMapping("/insertComm")
    public void insertComm(@RequestBody VideoComm vic);
    @GetMapping("/updateHadLike")
    public void updateHadLike(@RequestBody VideoComm vic);
    @GetMapping("/updateVideoComm")
    public void updateVideoComm(@RequestBody Video vi);

    @GetMapping("/getTvSub")
    public List<TvSub> getTvSub(@RequestParam("id") int id);
    @GetMapping("/updateSubTime")
    public void updateSubTime(@RequestBody VideoSub vs);
    @GetMapping("/insertVideoInfo")
    public void insertVideoInfo(@RequestBody Video vi);

    @GetMapping("/getVideoByTitle")
    public Video getVideoByTitle(@RequestBody Video vi);

    @GetMapping("/insertVidSub")
    public void insertVidSub(@RequestParam("id") int id);

    @GetMapping("/getSearchContent")
    public List<Video> getSearchContent(@RequestParam("name") String name);

    @GetMapping("/setUser")
    public void setUser(@RequestBody User us);

}
