package com.stu.springcloud.mapper;

import com.stu.springcloud.model.VideoComm;
import org.apache.ibatis.annotations.*;

import java.util.List;

/**
 * Created by mikechen on 2018/9/21.
 */
@Mapper
public interface VideoCommMapper {
    @Select("SELECT * from video_comment")
    List<VideoComm> getAll();

    @Select("SELECT * from video_comment where id=#{id}")
    VideoComm getById(int id);

    @Select("SELECT * from video_comment where video_id=#{id}")
    List<VideoComm> getByVId(int id);

    @Select("SELECT * from video_comment where video_id = #{id} order by id desc limit 6")
    @Results({
            @Result( id = true,property = "id",column = "id"),
            @Result(property = "user",column = "user_id",javaType= VideoComm.class ,one=@One(select = "com.stu.springcloud.mapper.UserInfoMapper.getById"))
    })
    List<VideoComm> getCommAndPeo(int id);

    @Insert("INSERT INTO video_comment (video_id, user_id, comt_content, comt_time, comt_liked) VALUES (#{video_id},#{user_id},#{comt_content},#{comt_time},#{comt_liked})")
    void insertComm(VideoComm videoComm);

    @Update("UPDATE video_comment SET comt_liked= #{comt_liked} WHERE (id=#{id})")
    void updateHadLike(VideoComm videoComm);

    @Update("UPDATE video_comment SET comt_content= #{comt_content},comt_exam= #{comt_exam},comt_liked=#{comt_liked},comt_dislike=#{comt_dislike} WHERE (id=#{id})")
    void updVideocomm(VideoComm videoComm);

    @Delete("delete from video_comment where id = #{id}")
    void delVideocomm(int id);

//
//    @Insert("INSERT INTO USERINFO (`USERNAME`, `PASSWORD`, `TELEPHONE`, `EMAIL`, `REGDATE`) VALUES ( #{username}, #{password}, #{telephone}, #{email}, #{regdate})")
//    public void setUser(User user);
}
