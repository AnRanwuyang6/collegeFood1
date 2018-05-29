package com.college.food.dao.mybatis;

import com.college.food.entity.ForumTopic;
import com.college.food.entity.ForumTopicExample;
import com.college.food.entity.MyUtil;
import org.springframework.stereotype.Repository;
import tk.mybatis.mapper.common.Mapper;

import java.util.ArrayList;

@Repository
public interface ForumTopicMapper extends Mapper<ForumTopic> {
    long countByExample(ForumTopicExample example);
    ArrayList<MyUtil> queryCountByBank(ForumTopicExample example);
}