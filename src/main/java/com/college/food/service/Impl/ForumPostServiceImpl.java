package com.college.food.service.Impl;

import com.college.food.common.utils.UUIDUtils;
import com.college.food.common.vo.BaseVo;
import com.college.food.dao.mybatis.ForumPostMapper;
import com.college.food.dao.mybatis.ForumTopicMapper;
import com.college.food.dao.mybatis.UserMapper;
import com.college.food.entity.*;
import com.college.food.service.ForumPostService;
import com.college.food.service.ForumTopicService;
import com.college.food.vo.PostVo;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/**
 * Created by lizongke on 2018/5/27.
 */
@Service
public class ForumPostServiceImpl implements ForumPostService {
    @Autowired
    private ForumPostMapper forumPostMapper;
    @Autowired
    private UserMapper userMapper;
    @Autowired
    private ForumTopicMapper forumTopicMapper;
    @Override
    public PageInfo<ForumPost> listAjax(PostVo vo) {
        ForumPostExample example=new ForumPostExample();
        if(vo.getTopicType()==null&&vo.getTitle()==null){
            example.createCriteria();
        }else if(vo.getTopicType()!=null&&vo.getTitle()==null){
         example.createCriteria().andTypeIdEqualTo(vo.getTopicType());
        }else if(vo.getTopicType()==null&&vo.getTitle()!=null){
            String likeTitle='%'+vo.getTitle()+'%';
            example.createCriteria().andPostTitleLike(likeTitle);
        }else{
            String likeTitle='%'+vo.getTitle()+'%';
            example.createCriteria().andTypeIdEqualTo(vo.getTopicType()).andPostTitleLike(likeTitle);
        }
        PageHelper.startPage(vo.getPage(),vo.getSize());
        List<ForumPost> forumPostList=forumPostMapper.selectByExample(example);
        PageInfo<ForumPost> pageInfo=new PageInfo<>(forumPostList);
        for(ForumPost forumPost:pageInfo.getList()){
            UserExample userExample=new UserExample();
            userExample.createCriteria().andIdEqualTo(forumPost.getUserId());
            forumPost.setUserId(userMapper.selectByExample(userExample).get(0).getStr2());

            ForumTopicExample forumTopicExample=new ForumTopicExample();
            forumTopicExample.createCriteria().andIdEqualTo(forumPost.getTypeId());
            forumPost.setTypeId(forumTopicMapper.selectByExample(forumTopicExample).get(0).getTopicName());
        }
        return pageInfo;
    }

    @Override
    public ForumPost findOne(String id) {
        ForumPostExample example=new ForumPostExample();
        example.createCriteria().andIdEqualTo(id);
        ForumPost forumPost=new ForumPost();
        List<ForumPost> forumPostList=forumPostMapper.selectByExample(example);
        if(forumPostList.size()>0){
            forumPost=forumPostList.get(0);
        }
        return forumPost;
    }

    @Override
    public void alertFlag(String id) {
        ForumPostExample example=new ForumPostExample();
        example.createCriteria().andIdEqualTo(id);
        List<ForumPost> forumPostList=forumPostMapper.selectByExample(example);
        if(forumPostList.size()>0){
            ForumPost forumPost=forumPostList.get(0);
            if(forumPost.getStr3().equals("1")){
                forumPost.setStr3("0");
                forumPostMapper.updateByPrimaryKeySelective(forumPost);
            }else{
                forumPost.setStr3("1");
                forumPostMapper.updateByPrimaryKeySelective(forumPost);
            }
        }
    }

    @Override
    public void toGood(String id) {
        ForumPostExample example=new ForumPostExample();
        example.createCriteria().andIdEqualTo(id);
        List<ForumPost> forumPostList=forumPostMapper.selectByExample(example);
        if(forumPostList.size()>0){
            ForumPost forumPost=forumPostList.get(0);
            if(forumPost.getStr2().equals("0")){
                forumPost.setStr2("1");
                forumPostMapper.updateByPrimaryKeySelective(forumPost);
            }else{
                forumPost.setStr2("0");
                forumPostMapper.updateByPrimaryKeySelective(forumPost);
            }
        }
    }

    @Override
    public void toTop(String id) {
        ForumPostExample example=new ForumPostExample();
        example.createCriteria().andIdEqualTo(id);
        List<ForumPost> forumPostList=forumPostMapper.selectByExample(example);
        if(forumPostList.size()>0){
            ForumPost forumPost=forumPostList.get(0);
            if(forumPost.getStr1().equals("0")){
                forumPost.setStr1("1");
                forumPostMapper.updateByPrimaryKeySelective(forumPost);
            }else{
                forumPost.setStr1("0");
                forumPostMapper.updateByPrimaryKeySelective(forumPost);
            }
        }
    }

    @Override
    public void delete(String id) {
        forumPostMapper.deleteByPrimaryKey(id);
    }

    @Override
    public void insert(ForumPost forumPost, User user) {
        forumPost.setId(UUIDUtils.generateUUID());;
        forumPost.setUserId(user.getId());
        forumPost.setCreatTime(new Date());
        forumPost.setLastUpdateTime(new Date());
        forumPost.setReplyCount(0);
        forumPost.setStr2("0");
        forumPost.setStr3("1");

        forumPostMapper.insert(forumPost);

        //更新帖子数
        ForumTopicExample forumTopicExample=new ForumTopicExample();
        forumTopicExample.createCriteria().andIdEqualTo(forumPost.getTypeId());
        ForumTopic forumTopic=forumTopicMapper.selectByExample(forumTopicExample).get(0);
        forumTopic.setArticleCount(forumTopic.getArticleCount()+1);

        forumTopicMapper.updateByPrimaryKeySelective(forumTopic);
    }
}
