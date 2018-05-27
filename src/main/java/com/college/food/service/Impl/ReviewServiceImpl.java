package com.college.food.service.Impl;

import com.college.food.common.utils.UUIDUtils;
import com.college.food.common.vo.BaseVo;
import com.college.food.dao.mybatis.ReviewMapper;
import com.college.food.entity.Review;
import com.college.food.entity.ReviewExample;
import com.college.food.entity.User;
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
            example.createCriteria().andCreateTimeBetween(beginTime,endTime);
        }else if(beginTime!=null&&endTime==null){
            example.createCriteria().andCreateTimeBetween(beginTime,new Date());
        }else{
            example.createCriteria().andStatusEqualTo("0");
        }
        PageHelper.startPage(vo.getPage(),vo.getSize());
        List<Review> reviewList=reviewMapper.selectByExample(example);
        PageInfo<Review> pageInfo=new PageInfo<>(reviewList);
        return pageInfo;
    }

    @Override
    public List<Review> findUset(String userId) {
        ReviewExample example=new ReviewExample();
        example.createCriteria().andUserIdEqualTo(userId);
        List<Review> reviewList=reviewMapper.selectByExample(example);
        return reviewList;
    }
}
