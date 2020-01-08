package com.stu.springcloud.mapper;


import com.stu.springcloud.model.Video;
import com.stu.springcloud.model.VideoSub;
import org.apache.ibatis.annotations.*;

import java.util.List;

/**
 * Created by mikechen on 2018/9/21.
 */
@Mapper
public interface VideoInfoMapper {
    @Select("SELECT * from video_info")
    List<Video> getAll();

    @Select("SELECT * from video_info order by video_hadvisit DESC")
    @Results({
        @Result( id = true,property = "id",column = "id"),
        @Result(property = "lvs",column = "id",javaType= VideoSub.class ,one=@One(select = "com.stu.springcloud.mapper.VideoSubMapper.getSubAll"))
    })
    List<Video> getBothAll();

    @Select("SELECT * from video_info where video_title like #{searcon}")
    @Results({
        @Result( id = true,property = "id",column = "id"),
        @Result(property = "lvs",column = "id",javaType= VideoSub.class ,one=@One(select = "com.stu.springcloud.mapper.VideoSubMapper.getSubAll"))
    })
    List<Video> getSearchContent(String searcon);
    @Select("SELECT * from video_info order by video_hadvisit DESC limit 3")
    @Results({
        @Result( id = true,property = "id",column = "id"),
        @Result(property = "lvs",column = "id",javaType= VideoSub.class ,one=@One(select = "com.stu.springcloud.mapper.VideoSubMapper.getSubAll"))
    })
    List<Video> getRankBothAll();

    @Select("SELECT * from video_info order by video_hadvisit DESC limit 6")
    List<Video> getMostseeInfoAll();



    @Select("SELECT * from video_info where video_type = #{videotype} order by rand() limit #{limit}")
    List<Video> getAllByType(@Param("videotype") int videotype, @Param("limit") int limit);

    @Select("SELECT video_upople FROM video_info WHERE id = #{id}")
    String getById(int id);

    @Select("SELECT * FROM video_info WHERE id = #{id}")
    Video getVideoById(int id);

    @Select("SELECT * FROM video_info WHERE video_peop = #{username}")
    List<Video> getVideoByUser(String username);

    @Select("SELECT * FROM video_info WHERE video_peop = #{video_peop} and video_time=#{video_time} ")
    Video getVideoByTitle(Video video);

    @Select("SELECT * FROM video_info WHERE video_type = #{video_type} order by video_hadvisit DESC")
    @Results({
            @Result( id = true,property = "id",column = "id"),
            @Result(property = "lvs",column = "id",javaType= VideoSub.class ,one=@One(select = "com.stu.springcloud.mapper.VideoSubMapper.getTv"))
    })
    List<Video> getVideoByType(int video_type);

//    @Update("UPDATE video_info SET id=#{video.id}, video_title=#{video.video_title}, video_address=#{video.video_address}, video_type=#{video.video_type}, video_pic=#{video.video_pic}, video_descript=#{video.video_descript}, video_hadvisit=#{video.video_hadvisit}, video_like=#{video.video_like}, video_dislike=#{video.video_dislike}, video_comment=#{video.video_comment},video_download=#{video.video_download}, video_peop=#{video.video_peop}, video_time=#{video.video_time} WHERE id=#{video.id}")
//    void updateAll(Video video);
    @Update("UPDATE video_info SET  video_like=#{video_like}, video_dislike=#{video_dislike}  WHERE id=#{id}")
    void updateAll(Video video);

    @Update("UPDATE video_info SET  video_hadvisit=#{video_hadvisit} WHERE id=#{id}")
    void updateHadVis(Video video);

    @Update("UPDATE video_info SET  video_type = #{video_type}, video_address = #{video_address}, video_pic = #{video_pic}, video_descript=#{video_descript},video_exam=#{video_exam} WHERE id=#{id}")
    void magUpdate(Video video);

    @Update("UPDATE video_info SET  video_title=#{video_title} WHERE id=#{id}")
    void updateVideoTitle(Video video);

    @Update("UPDATE video_info SET  video_comment=#{video_comment} WHERE id=#{id}")
    void updateVideoComm(Video video);

    @Delete("delete  from video_info where id = #{id}")
    void deleteById(int id);

    @Insert("insert into video_info( video_address,video_type,video_pic,video_descript,video_peop,video_time,video_title,video_exam)VALUES(#{video_address},#{video_type},#{video_pic},#{video_descript},#{video_peop},#{video_time},#{video_title},#{video_exam})")
    void insertVideoInfo(Video video);

//    @Insert("INSERT INTO USERINFO (`USERNAME`, `PASSWORD`, `TELEPHONE`, `EMAIL`, `REGDATE`) VALUES ( #{username}, #{password}, #{telephone}, #{email}, #{regdate})")
//    public void setUser(User user);
}
