package com.college.food.dao.mybatis;

import com.college.food.entity.FoodType;
import com.college.food.entity.FoodTypeExample;
import org.springframework.stereotype.Repository;
import tk.mybatis.mapper.common.Mapper;
@Repository
public interface FoodTypeMapper extends Mapper<FoodType> {
    long countByExample(FoodTypeExample example);
}