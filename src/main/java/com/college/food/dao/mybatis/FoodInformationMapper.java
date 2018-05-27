package com.college.food.dao.mybatis;

import com.college.food.entity.FoodInformation;
import com.college.food.entity.FoodInformationExample;
import org.springframework.stereotype.Repository;
import tk.mybatis.mapper.common.Mapper;
@Repository
public interface FoodInformationMapper extends Mapper<FoodInformation> {
    long countByExample(FoodInformationExample example);
}