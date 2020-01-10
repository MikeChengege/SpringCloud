package com.stu.springcloud.mapper;


import com.stu.springcloud.model.TvSub;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * Created by mikechen on 2018/9/21.
 */
@Mapper
public interface TvSubMapper {
    @Select("SELECT * from tv_sub where videoid = #{videoid}")
    List<TvSub> getTvSub(int videoid);
}
