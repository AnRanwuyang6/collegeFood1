package com.college.food.service;

import com.college.food.common.vo.BaseVo;
import com.college.food.entity.User;
import com.github.pagehelper.PageInfo;

/**
 * Created by lizongke─=≡Σ(((つ•̀ω•́)つ) on 2018/5/18.
 */
public interface UserService {

    //分页查询
    PageInfo<User> findList(BaseVo vo,String userType);
    //添加用户

    void insert(User user);

    //查询单个用户
    User findOne(String id);
    //更新单个用户
    void update(User user);
}
