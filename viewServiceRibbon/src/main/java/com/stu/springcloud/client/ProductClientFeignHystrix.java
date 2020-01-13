package com.stu.springcloud.client;

import cn.hutool.json.JSONObject;
import com.stu.springcloud.modle.*;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.List;

/**
 * 数据微服务无法连接后回调类
 */
@Component
public class ProductClientFeignHystrix  implements ProductClientRibbon{
    public List<Product> listProduct() {
        List<Product> lp = new ArrayList<>();
        lp.add(new Product(0,"产品不可用",0));
        return lp;
    }

    @Override
    public List<User> userList() {
        List<User> lp = new ArrayList<>();
        lp.add(new User());
        return lp;
    }

    @Override
    public User Verification(String username) {
        return null;
    }

    @Override
    public List<Video> getVideoInf() {
        return null;
    }

    @Override
    public List<Video> mostseeVideoInf() {
        return null;
    }

    @Override
    public List<Video> getRankinfo() {
        return null;
    }

    @Override
    public List<Video> getAllTv(int videoType) {
        return null;
    }

    @Override
    public List<Video> submitAdvice(UserAdv uadv) {
        return null;
    }

    @Override
    public List<UserCollection> userCollection(int uid) {
        return null;
    }

    @Override
    public Video getVideoById(int vid) {
        return null;
    }

    @Override
    public User getUserInfoById(int uid) {
        return null;
    }

    @Override
    public User updateUser(User user) {
        return null;
    }

    @Override
    public List<Video> getVideoByName(String name) {
        return null;
    }

    @Override
    public List<UserView> getHadView(int id) {
        return null;
    }

    @Override
    public void updateVideo(Video vi) {
    }

    @Override
    public void deleteById(int vid) {
    }

    @Override
    public UserView getSeemHadSee(UserView userView) {
        return null;
    }

    @Override
    public void addUserView(UserView userView) {
    }

    @Override
    public void deleteHadSee(int vid) {
    }

    @Override
    public List<Video> getAllByType(int videotype, int limit) {
        return null;
    }

    @Override
    public void updateAll(Video vi) {

    }

    @Override
    public List<VideoComm> getCommAndPeo(int id) {
        return null;
    }

    @Override
    public void insertComm(VideoComm vic) {

    }

    @Override
    public void updateVideoComm(Video vi) {

    }

    @Override
    public List<UserCollection> addCollect(UserCollection userCollection) {
        return null;
    }

    @Override
    public List<UserCollection> deleteCollect(UserCollection userCollection) {
        return null;
    }

    @Override
    public VideoComm getCommById(int id) {
        return null;
    }

    @Override
    public void updateHadLike(VideoComm vic) {

    }

    @Override
    public void updateHadVis(Video vi) {

    }

    @Override
    public List<TvSub> getTvSub(int id) {
        return null;
    }

    @Override
    public Video getVideoByTitle(Video vi) {
        return null;
    }

    @Override
    public void insertVideoInfo(Video vi) {

    }

    @Override
    public void insertVidSub(int id) {

    }

    @Override
    public void magUpdate(Video vi) {

    }

    @Override
    public void updateSubTime(VideoSub vs) {

    }

    @Override
    public List<Video> getSearchContent(String name) {
        return null;
    }

    @Override
    public void setUser(User us) {

    }

    @Override
    public Manager getMangByName(String name) {
        return null;
    }

    @Override
    public List<VideoSub> getSub() {
        return null;
    }

    @Override
    public VideoSub getSubById(int id) {
        return null;
    }

    @Override
    public void updateSub(VideoSub vs) {

    }

    @Override
    public List<User> getAllUser() {
        return null;
    }

    @Override
    public void destroyUser(int id) {

    }

    @Override
    public List<VideoComm> getAllComm() {
        return null;
    }

    @Override
    public void updVideocomm(VideoComm vic) {

    }

    @Override
    public void delVideocomm(int id) {

    }

    @Override
    public List<UserAdv> getAdv() {
        return null;
    }

    @Override
    public UserAdv getAdvById(int id) {
        return null;
    }

    @Override
    public void deleteUserAdv(int id) {

    }

    @Override
    public void updateUserAdv(UserAdv uadv) {

    }
}
