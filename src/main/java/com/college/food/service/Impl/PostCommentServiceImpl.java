package com.college.food.service.Impl;

import com.college.food.common.vo.BaseVo;
import com.college.food.dao.mybatis.ForumPostMapper;
import com.college.food.dao.mybatis.PostCommentMapper;
import com.college.food.entity.ForumPost;
import com.college.food.entity.ForumPostExample;
import com.college.food.entity.PostComment;
import com.college.food.entity.PostCommentExample;
import com.college.food.service.PostCommentService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PostCommentServiceImpl implements PostCommentService{
    @Autowired
    private PostCommentMapper  postCommentMapper;
    @Autowired
    private ForumPostMapper forumPostMapper;
    @Override
    public PageInfo<PostComment> listAjax(BaseVo vo, String key) {
        PostCommentExample example=new PostCommentExample();
        if(!key.equals("")){

            String content='%'+key+'%';
            example.createCriteria().andContentsLike(content);
        }else {
            example.createCriteria();
        }
        PageHelper.startPage(vo.getPage(),vo.getSize());
        List<PostComment> postCommentList=postCommentMapper.selectByExample(example);
        PageInfo<PostComment> pageInfo=new PageInfo<>(postCommentList);
        return pageInfo;
    }

    @Override
    public PostComment findOne(String id) {
        PostCommentExample  example=new PostCommentExample();
        example.createCriteria().andIdEqualTo(id);
        PostComment postComment=postCommentMapper.selectByExample(example).get(0);
        return postComment;
    }

    @Override
    public void delete(String id) {

        //跟新评论数量
        PostCommentExample  example=new PostCommentExample();
        example.createCriteria().andIdEqualTo(id);
        PostComment postComment=postCommentMapper.selectByExample(example).get(0);

        ForumPostExample example1=new ForumPostExample();
        example1.createCriteria().andIdEqualTo(postComment.getPostId());
        ForumPost forumPost=forumPostMapper.selectByExample(example1).get(0);
        forumPost.setReplyCount(forumPost.getReplyCount()-1);
        forumPostMapper.updateByPrimaryKeySelective(forumPost);
        //删除评论
        postCommentMapper.deleteByPrimaryKey(id);

    }
}
