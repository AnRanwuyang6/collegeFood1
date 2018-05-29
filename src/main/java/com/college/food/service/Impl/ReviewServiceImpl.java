package com.college.food.service.Impl;

import com.college.food.common.utils.UUIDUtils;
import com.college.food.common.vo.BaseVo;
import com.college.food.dao.mybatis.ReviewMapper;
import com.college.food.dao.mybatis.UserMapper;
import com.college.food.entity.Review;
import com.college.food.entity.ReviewExample;
import com.college.food.entity.User;
import com.college.food.entity.UserExample;
import com.college.food.service.ReviewService;
import com.college.food.vo.ReviewVo;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/**
 * Created by lizongke on 2018/5/7.
 */
@Service
public class ReviewServiceImpl implements ReviewService{
    @Autowired
    private ReviewMapper reviewMapper;
    @Autowired
    private UserMapper userMapper;
    @Override
    public void insert(ReviewVo vo, User user) {
        Review review=new Review();
        review.setId(UUIDUtils.generateUUID());
        review.setUserId(user.getId());
        review.setNickName(user.getStr2());
        review.setImageUrl(vo.getImgUrl());
        review.setType(user.getStr3());
        review.setCreateTime(new Date());
        review.setStatus("0");
        review.setStr1(vo.getContent());
        reviewMapper.insert(review);
    }


    @Override
    public PageInfo<Review> listAjax(BaseVo vo, Date beginTime, Date endTime) {
        ReviewExample example=new ReviewExample();
        if(beginTime!=null&&endTime!=null){
            example.createCriteria().andCreateTimeBetween(beginTime,endTime).andStatusEqualTo("0");;
        }else if(beginTime!=null&&endTime==null){
            example.createCriteria().andCreateTimeBetween(beginTime,new Date()).andStatusEqualTo("0");;
        }else{
            example.createCriteria().andStatusEqualTo("0");
        }
        PageHelper.startPage(vo.getPage(),vo.getSize());
        List<Review> reviewList=reviewMapper.selectByExample(example);
        PageInfo<Review> pageInfo=new PageInfo<>(reviewList);
        return pageInfo;
    }

    @Override
    public void pass(String userId,String id) {
        ReviewExample reviewExample=new ReviewExample();
        reviewExample.createCriteria().andIdEqualTo(id);
        List<Review> reviewList=reviewMapper.selectByExample(reviewExample);
        Review review=new Review();
        if(reviewList.size()>0){
            review=reviewList.get(0);
        }
        review.setStatus("1");
        reviewMapper.updateByPrimaryKeySelective(review);

        //更新用户权限
        UserExample example=new UserExample();
        example.createCriteria().andIdEqualTo(userId);
        List<User> userList=userMapper.selectByExample(example);
        User user=new User();
        if(userList.size()>0){
            user=userList.get(0);
        }
        //供应商 1，采购商 2
        if(user.getStr3().equals("1")){
            //供应商通过
            user.setStr1("458");
            userMapper.updateByPrimaryKeySelective(user);
        }else{
            //采购商通过
            user.setStr1("357");
            userMapper.updateByPrimaryKeySelective(user);
        }
    }

    @Override
    public void stop(String userId,String id) {
        ReviewExample reviewExample=new ReviewExample();
        reviewExample.createCriteria().andIdEqualTo(id);
        List<Review> reviewList=reviewMapper.selectByExample(reviewExample);
        Review review=new Review();
        if(reviewList.size()>0){
            review=reviewList.get(0);
        }
        review.setStatus("2");
        reviewMapper.updateByPrimaryKeySelective(review);
    }

    @Override
    public List<Review> findUset(String userId) {
        ReviewExample example=new ReviewExample();
        example.createCriteria().andUserIdEqualTo(userId);
        List<Review> reviewList=reviewMapper.selectByExample(example);
        return reviewList;
    }
}
