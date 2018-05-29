package com.college.food.service;

import com.college.food.entity.ForumTopic;
import com.college.food.entity.MyUtil;
import com.college.food.entity.User;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by lizongke on 2018/5/27.
 */
public interface ForumTopicService {
    List<ForumTopic> findList();
    //查询上线板块
    List<ForumTopic> findListByStatus();
    //添加板块
    void insert(ForumTopic forumTopic,User user);
    //启用停用
    boolean alertFlag(String id);

    //删除
    void delete(String id);

    //查询各版块的话题数量
    ArrayList<MyUtil> queryCountByBank();
}
