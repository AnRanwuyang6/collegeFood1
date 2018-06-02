package com.college.food.dao.mybatis;

import com.college.food.entity.ForumPost;
import com.college.food.entity.ForumPostExample;
import org.springframework.stereotype.Repository;
import tk.mybatis.mapper.common.Mapper;
@Repository
public interface ForumPostMapper extends Mapper<ForumPost> {
    long countByExample(ForumPostExample example);
}