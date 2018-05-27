package com.college.food.dao.mybatis;

import com.college.food.entity.Role;
import com.college.food.entity.RoleExample;
import tk.mybatis.mapper.common.Mapper;

public interface RoleMapper extends Mapper<Role> {
    long countByExample(RoleExample example);
}