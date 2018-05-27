package com.college.food.service.Impl;

import com.college.food.dao.mybatis.AppTestMapper;
import com.college.food.dao.mybatis.UserMapper;
import com.college.food.entity.AppTest;
import com.college.food.entity.AppTestExample;
import com.college.food.entity.User;
import com.college.food.entity.UserExample;
import com.college.food.service.TsetService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.sun.jmx.snmp.tasks.TaskServer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by lizongke─=≡Σ(((つ•̀ω•́)つ) on 2018/1/18.
 */
@Service
public class TestServiceImpl implements TsetService {
    @Autowired
    private AppTestMapper appTestMapper;
    @Autowired
    private UserMapper userMapper;
    @Override
    public List<AppTest> findAll() {
        List<AppTest> appTestList=appTestMapper.selectAll();
        return appTestList;
    }

    @Override
    public PageInfo<AppTest> list() {
        PageHelper.startPage(1,2);
        List<AppTest> list=appTestMapper.selectByExample(new AppTestExample());
        PageInfo<AppTest> pageInfo=new PageInfo<>(list);
        return pageInfo;
    }

    @Override
    public PageInfo<User> findUser() {
        PageHelper.startPage(1,2);
        List<User> users=userMapper.selectByExample(new UserExample());
        PageInfo<User> pageInfo=new PageInfo<>(users);
        return pageInfo;
    }
}
