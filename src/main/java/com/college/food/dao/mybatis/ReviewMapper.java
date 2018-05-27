package com.college.food.dao.mybatis;

import com.college.food.entity.Review;
import com.college.food.entity.ReviewExample;
import org.springframework.stereotype.Repository;
import tk.mybatis.mapper.common.Mapper;
@Repository
public interface ReviewMapper extends Mapper<Review> {
    long countByExample(ReviewExample example);
}