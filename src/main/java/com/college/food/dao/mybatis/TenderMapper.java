package com.college.food.dao.mybatis;

import com.college.food.entity.Tender;
import com.college.food.entity.TenderExample;
import org.springframework.stereotype.Repository;
import tk.mybatis.mapper.common.Mapper;
@Repository
public interface TenderMapper extends Mapper<Tender> {
    long countByExample(TenderExample example);
}