package com.stu.springcloud.mapper;

import com.stu.springcloud.model.Manager;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * Created by mikechen on 2018/9/21.
 */
@Mapper
public interface MagInfoMapper {
    @Select("SELECT * from maginfo")
    List<Manager> getAll();

    @Select("SELECT * from maginfo WHERE USERNAME = #{username}")
    Manager get(String username);

//
//    @Insert("INSERT INTO USERINFO (`USERNAME`, `PASSWORD`, `TELEPHONE`, `EMAIL`, `REGDATE`) VALUES ( #{username}, #{password}, #{telephone}, #{email}, #{regdate})")
//    public void setUser(User user);
}
