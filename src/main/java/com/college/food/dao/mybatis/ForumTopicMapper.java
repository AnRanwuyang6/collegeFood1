package com.college.food.dao.mybatis;

import com.college.food.entity.ForumTopic;
import com.college.food.entity.ForumTopicExample;
import org.springframework.stereotype.Repository;
import tk.mybatis.mapper.common.Mapper;
@Repository
public interface ForumTopicMapper extends Mapper<ForumTopic> {
    long countByExample(ForumTopicExample example);
}