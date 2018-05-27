package com.college.food.service.Impl;

import com.college.food.common.utils.UUIDUtils;
import com.college.food.dao.mybatis.FoodInformationMapper;
import com.college.food.dao.mybatis.ForumTopicMapper;
import com.college.food.entity.ForumTopic;
import com.college.food.entity.ForumTopicExample;
import com.college.food.entity.User;
import com.college.food.service.ForumTopicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/**
 * Created by lizongke on 2018/5/27.
 */
@Service
public class ForumTopicServiceImpl implements ForumTopicService{
    @Autowired
    private ForumTopicMapper forumTopicMapper;
    @Override
    public List<ForumTopic> findList() {
        ForumTopicExample example=new ForumTopicExample();
        example.createCriteria();
        List<ForumTopic> forumTopicList=forumTopicMapper.selectByExample(example);
        return forumTopicList;
    }

    @Override
    public void insert(ForumTopic forumTopic, User user) {
        forumTopic.setId(UUIDUtils.generateUUID());
        forumTopic.setCreater(user.getStr2());
        forumTopic.setCreatTime(new Date());
        forumTopic.setTopicStatus("0");
        forumTopic.setArticleCount(0);
        forumTopicMapper.insert(forumTopic);
    }

    @Override
    public boolean alertFlag(String id) {
        ForumTopicExample example=new ForumTopicExample();
        example.createCriteria().andIdEqualTo(id);
        List<ForumTopic> forumTopicList=forumTopicMapper.selectByExample(example);
        ForumTopic forumTopic=new ForumTopic();
        if(forumTopicList.size()>0){
            forumTopic=forumTopicList.get(0);
        }
        if(forumTopic.getTopicStatus().equals("0")){
            forumTopic.setTopicStatus("1");
            forumTopicMapper.updateByPrimaryKeySelective(forumTopic);
        }else{
            forumTopic.setTopicStatus("0");
            forumTopicMapper.updateByPrimaryKeySelective(forumTopic);
        }
        return false;
    }
}
