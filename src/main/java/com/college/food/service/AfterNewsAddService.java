package com.college.food.service;


import com.college.food.entity.ArticleNews;
import com.college.food.vo.NewsAddVo;
import com.github.pagehelper.PageInfo;

/**
 * Created by lizongke on 2018/4/9.
 */
public interface AfterNewsAddService {
    PageInfo<ArticleNews>  ListAjax(NewsAddVo vo);

    //添加新闻
    void insert(ArticleNews articleNews);
    //删除新闻
    void delete(String id);
    //改变上下线
    void alertFlag(String id);
    //改变是否推荐
    void recommend(String id);
}
