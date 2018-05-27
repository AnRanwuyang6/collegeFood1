package com.college.food.dao.mybatis;

import com.college.food.entity.UserFoodR;
import com.college.food.entity.UserFoodRExample;
import org.springframework.stereotype.Repository;
import tk.mybatis.mapper.common.Mapper;
@Repository
public interface UserFoodRMapper extends Mapper<UserFoodR> {
    long countByExample(UserFoodRExample example);
}