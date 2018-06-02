package com.college.food.dao.mybatis;

import com.college.food.entity.Bid;
import com.college.food.entity.BidExample;
import org.springframework.stereotype.Repository;
import tk.mybatis.mapper.common.Mapper;
@Repository
public interface BidMapper extends Mapper<Bid> {
    long countByExample(BidExample example);
}