package com.college.food.dao.mybatis;

import com.college.food.entity.User;
import com.college.food.entity.UserExample;
import org.springframework.stereotype.Repository;
import tk.mybatis.mapper.common.Mapper;
@Repository
public interface UserMapper extends Mapper<User> {
    long countByExample(UserExample example);
}