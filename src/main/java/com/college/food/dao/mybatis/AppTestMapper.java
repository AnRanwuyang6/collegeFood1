package com.college.food.dao.mybatis;

import com.college.food.entity.AppTest;
import com.college.food.entity.AppTestExample;
import org.springframework.stereotype.Repository;
import tk.mybatis.mapper.common.Mapper;
@Repository
public interface AppTestMapper extends Mapper<AppTest> {
    long countByExample(AppTestExample example);
}