package com.college.food.service.Impl;

import com.college.food.common.utils.UUIDUtils;
import com.college.food.dao.mybatis.FoodInformationMapper;
import com.college.food.dao.mybatis.ForumPostMapper;
import com.college.food.dao.mybatis.ForumTopicMapper;
import com.college.food.entity.*;
import com.college.food.service.ForumTopicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by lizongke on 2018/5/27.
 */
@Service
public class ForumTopicServiceImpl implements ForumTopicService{
    @Autowired
    private ForumTopicMapper forumTopicMapper;
    @Autowired
    private ForumPostMapper forumPostMapper;
    @Override
    public List<ForumTopic> findList() {
        ForumTopicExample example=new ForumTopicExample();
        example.createCriteria();
        List<ForumTopic> forumTopicList=forumTopicMapper.selectByExample(example);
        return forumTopicList;
    }

    @Override
    public List<ForumTopic> findListByStatus() {
        ForumTopicExample example=new ForumTopicExample();
        example.createCriteria().andTopicStatusEqualTo("1");
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
            //将板块下的帖子上线
            ForumPostExample example1=new ForumPostExample();
            example1.createCriteria().andTypeIdEqualTo(id);
            List<ForumPost> forumPostList=forumPostMapper.selectByExample(example1);
            if(forumPostList.size()>0){
                for(ForumPost forumPost:forumPostList){
                    forumPost.setStr3("1");
                    forumPostMapper.updateByPrimaryKeySelective(forumPost);
                }
            }
        }else{
            forumTopic.setTopicStatus("0");
            forumTopicMapper.updateByPrimaryKeySelective(forumTopic);
            //将该板块下帖子下线

            ForumPostExample example1=new ForumPostExample();
            example1.createCriteria().andTypeIdEqualTo(id);
            List<ForumPost> forumPostList=forumPostMapper.selectByExample(example1);
            if(forumPostList.size()>0){
                for(ForumPost forumPost:forumPostList){
                    forumPost.setStr3("0");
                    forumPostMapper.updateByPrimaryKeySelective(forumPost);
                }
            }
        }
        return false;
    }

    @Override
    public void delete(String id) {
       forumTopicMapper.deleteByPrimaryKey(id);
       //删除板块下所有帖子
        ForumPostExample example=new ForumPostExample();
        example.createCriteria().andTypeIdEqualTo(id);
        List<ForumPost> forumPostList=forumPostMapper.selectByExample(example);
        if(forumPostList.size()>0){
            for(ForumPost forumPost:forumPostList){
                forumPostMapper.delete(forumPost);
            }
        }

    }
    @Override
    public ArrayList<MyUtil> queryCountByBank() {
        ArrayList<MyUtil> myUtils = new ArrayList<>();
        ForumTopicExample example=new ForumTopicExample();
        example.createCriteria().andTopicStatusEqualTo("1");
        List<ForumTopic> forumTopics = forumTopicMapper.selectByExample(example);
        for (ForumTopic forumTopic:forumTopics) {
            MyUtil util = new MyUtil();
            util.setName(forumTopic.getTopicName());
            util.setValue(forumTopic.getArticleCount());
            myUtils.add(util);
        }
        return myUtils;
    }
}
