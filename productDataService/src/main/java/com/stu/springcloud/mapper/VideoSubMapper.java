package com.stu.springcloud.mapper;

import com.stu.springcloud.model.VideoSub;
import org.apache.ibatis.annotations.*;

import java.util.List;

/**
 * Created by mikechen on 2018/9/21.
 */
@Mapper
public interface VideoSubMapper {
    @Select("SELECT * from video_subsidiary where video_id = #{video_id}")
    VideoSub getSubAll(@Param("id") int video_id);

    @Select("SELECT * from video_subsidiary where id = #{id}")
    VideoSub getSubById(int id);

    @Select("SELECT * from video_subsidiary")
    List<VideoSub> getSub();

    @Select("SELECT * from video_subsidiary where video_id = #{video_id} and video_hot=0")
    VideoSub getTv(@Param("id") int video_id);

    @Update("UPDATE video_subsidiary set video_hot=#{video_hot},video_score=#{video_score},video_playtype=#{video_playtype},video_updatetiem=#{video_updatetiem},video_backtime=#{video_backtime},video_videotype=#{video_videotype} where id = #{id}")
    void updateSub(VideoSub vs);

    @Update("UPDATE video_subsidiary set video_duration=#{video_duration} where video_id = #{video_id}")
    void updateSubTime(VideoSub vs);

    @Insert("INSERT INTO video_subsidiary (`video_id`) VALUES (#{vid})")
    void insertVidSub(int vid);
}
