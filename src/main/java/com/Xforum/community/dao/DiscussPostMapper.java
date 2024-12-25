package com.Xforum.community.dao;

import com.Xforum.community.entity.DiscussPost;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface DiscussPostMapper {

    List<DiscussPost> selectDiscussPost(int userId, int offset, int limit);

    // @Param注解用于给参数取别名。
    // 如果只有一个参数，并且在if中使用，则必须使用别名。
    int selectDiscussPostRows(@Param("userId") int userId);


}
