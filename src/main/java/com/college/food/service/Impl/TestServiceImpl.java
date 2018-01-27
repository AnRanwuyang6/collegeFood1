package com.college.food.service.Impl;

import com.college.food.dao.mybatis.AppTestMapper;
import com.college.food.entity.AppTest;
import com.college.food.service.TsetService;
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
    @Override
    public List<AppTest> findAll() {
        List<AppTest> appTestList=appTestMapper.selectAll();
        return appTestList;
    }
}
