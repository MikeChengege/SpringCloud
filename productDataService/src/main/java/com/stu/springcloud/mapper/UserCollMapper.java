package com.stu.springcloud.mapper;

import com.stu.springcloud.model.UserCollection;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * Created by mikechen on 2018/9/21.
 */
@Mapper
public interface UserCollMapper {
    @Select("SELECT * from user_collection where userid = #{userid}")
    List<UserCollection> getCollection(int userid);

    @Insert("INSERT INTO user_collection( `userid`, `videoid`) VALUES ( #{userid}, #{videoid})")
    void addCollect(UserCollection u);

    @Delete("DELETE from user_collection where userid= #{userid} and videoid=#{videoid}")
    void deleteCollect(UserCollection u);
}
