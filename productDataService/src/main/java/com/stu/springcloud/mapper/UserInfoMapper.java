package com.stu.springcloud.mapper;

import com.stu.springcloud.model.User;
import org.apache.ibatis.annotations.*;

import java.util.List;

/**
 * Created by mikechen on 2018/9/21.
 */
@Mapper
public interface UserInfoMapper {
    @Select("SELECT * from USERINFO WHERE USERNAME = #{username}")
    User get(String username);
    @Select("SELECT * from USERINFO WHERE id = #{id}")
    User getById(int id);
    @Select("SELECT * from USERINFO")
    List<User> getAllUser();

    @Select("SELECT PASSWORD FROM USERINFO WHERE USERNAME = #{username}")
    String getPs(String username);

    @Insert("INSERT INTO USERINFO (`USERNAME`, `PASSWORD`, `TELEPHONE`, `EMAIL`, `REGDATE`) VALUES ( #{username}, #{password}, #{telephone}, #{email}, #{regdate})")
    void setUser(User user);

    @Update("UPDATE userinfo SET  `USERNAME`=#{username}, `PASSWORD`=#{password}, `TELEPHONE`=#{telephone}, `EMAIL`=#{email} , `PHOTO`=#{photo} WHERE (`ID`=#{id})")
    void updateUser(User user);
    @Update("UPDATE userinfo SET  `PHOTO`=#{photo}  WHERE (`ID`=#{id})")
    void updateUserPhoto(User user);
    @Delete("delete  from userinfo where id = #{id}")
    void destroyUser(int id);
}
