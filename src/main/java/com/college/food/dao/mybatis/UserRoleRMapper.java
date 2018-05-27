package com.college.food.dao.mybatis;

import com.college.food.entity.UserRoleR;
import com.college.food.entity.UserRoleRExample;
import tk.mybatis.mapper.common.Mapper;

public interface UserRoleRMapper extends Mapper<UserRoleR> {
    long countByExample(UserRoleRExample example);
}