package com.stu.springcloud.mapper;

import com.stu.springcloud.model.User;
import org.apache.ibatis.annotations.*;

import java.util.List;

/**
 * Created by mikechen on 2018/9/21.
 */
@Mapper
public interface UserInfoMapper {
    @Select("SELECT * from USERINFO")
    List<User> get();
}
