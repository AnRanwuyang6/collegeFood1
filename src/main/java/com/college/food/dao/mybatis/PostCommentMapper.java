package com.college.food.dao.mybatis;

import com.college.food.entity.PostComment;
import com.college.food.entity.PostCommentExample;
import org.springframework.stereotype.Repository;
import tk.mybatis.mapper.common.Mapper;
@Repository
public interface PostCommentMapper extends Mapper<PostComment> {
    long countByExample(PostCommentExample example);
}