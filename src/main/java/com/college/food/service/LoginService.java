package com.college.food.service;

import com.college.food.entity.User;

/**
 * Created by lizongke─=≡Σ(((つ•̀ω•́)つ) on 2018/5/18.
 */
public interface LoginService {
    //查询是否有此用户
    User findOne(String Username,String password);
}
