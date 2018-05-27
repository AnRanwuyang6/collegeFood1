package com.college.food.service;

import com.college.food.entity.AppTest;
import com.college.food.entity.User;
import com.github.pagehelper.PageInfo;

import java.util.List;

/**
 * Created by lizongke─=≡Σ(((つ•̀ω•́)つ) on 2018/1/18.
 */
public interface TsetService {
    //测试
    List<AppTest> findAll();
    PageInfo<AppTest> list();
    PageInfo<User> findUser();

}
