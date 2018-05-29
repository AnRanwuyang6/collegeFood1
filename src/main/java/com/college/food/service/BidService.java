package com.college.food.service;

import com.college.food.common.vo.BaseVo;
import com.college.food.entity.Bid;
import com.college.food.entity.User;
import com.github.pagehelper.PageInfo;

/**
 * Created by lizongke on 2018/5/9.
 */
public interface BidService {
    PageInfo<Bid> listAjax(BaseVo vo,String tenderId);

     void insert(String id, User user);
}
