package com.college.food.dao.mybatis;

import com.college.food.entity.ArticleNews;
import com.college.food.entity.ArticleNewsExample;
import org.springframework.stereotype.Repository;
import tk.mybatis.mapper.common.Mapper;
@Repository
public interface ArticleNewsMapper extends Mapper<ArticleNews> {
    long countByExample(ArticleNewsExample example);
}