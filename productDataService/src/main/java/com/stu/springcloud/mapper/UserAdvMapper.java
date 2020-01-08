package com.stu.springcloud.mapper;

import com.stu.springcloud.model.UserAdv;
import org.apache.ibatis.annotations.*;

import java.util.List;

/**
 * Created by mikechen on 2018/9/21.
 */
@Mapper
public interface UserAdvMapper {
    @Select("SELECT * from usr_adv ")
    List<UserAdv> getAdv();

    @Select("SELECT * from usr_adv where id=#{id}")
    UserAdv getAdvById(int id);

    @Insert("INSERT INTO usr_adv (`user_id`, `advtext`, `advtime`) VALUES (#{user_id},#{advtext},#{advtime})")
    void insertAdv(UserAdv uadv);

    @Update("update usr_adv set advtype=#{advtype} where id=#{id}")
    void updateUserAdv(UserAdv uadv);

    @Delete("delete from usr_adv where id=#{id}")
    void deleteUserAdv(int id);
}
