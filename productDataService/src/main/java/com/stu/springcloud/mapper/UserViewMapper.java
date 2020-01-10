package com.stu.springcloud.mapper;

import com.stu.springcloud.model.UserView;
import org.apache.ibatis.annotations.*;

import java.util.List;


/**
 * Created by mikechen on 2018/9/21.
 */
@Mapper
public interface UserViewMapper {

    @Select("SELECT * from sightsee_record where userid=#{userid}")
    List<UserView> getHadSee(int userid);

    @Select("SELECT * from sightsee_record where userid=#{userid} and videoid=#{videoid}")
    UserView getSeemHadSee(UserView uv);

    @Insert("INSERT into sightsee_record (userid,videoid,vistime) values(#{userid},#{videoid},#{vistime})")
    void addUserView(UserView uv);

    @Update("update sightsee_record set  userid=#{userid},videoid=#{videoid},vistime=#{vistime}")
    void updateUseVie(UserView uv);

    @Delete("delete from sightsee_record where id = #{id}")
    void deleteHadSee(int id);
}
