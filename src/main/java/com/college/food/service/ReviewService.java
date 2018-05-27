package com.college.food.service;

import com.college.food.common.vo.BaseVo;
import com.college.food.entity.Review;
import com.college.food.entity.User;
import com.college.food.vo.ReviewVo;
import com.github.pagehelper.PageInfo;

import java.util.Date;
import java.util.List;

/**
 * Created by lizongke on 2018/5/7.
 */
public interface ReviewService {
    //审核申请
    void insert(ReviewVo reviewVo, User user);
    //我的审核
    List<Review> findUset(String userId);

    //审核
    PageInfo<Review> listAjax(BaseVo vo,Date beginTime,Date endime);

}
