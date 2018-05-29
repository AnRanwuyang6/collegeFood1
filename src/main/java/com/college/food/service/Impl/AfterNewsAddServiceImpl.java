package com.college.food.service.Impl;


import com.college.food.common.utils.UUIDUtils;
import com.college.food.common.vo.BaseVo;
import com.college.food.dao.mybatis.ArticleNewsMapper;
import com.college.food.entity.ArticleNews;
import com.college.food.entity.ArticleNewsExample;
import com.college.food.service.AfterNewsAddService;
import com.college.food.vo.NewsAddVo;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
/**
 * Created by lizongke on 2018/5/7.
 */
@Service
public class AfterNewsAddServiceImpl implements AfterNewsAddService {
    @Autowired
    private ArticleNewsMapper articleNewsMapper;
    @Override
    public PageInfo<ArticleNews> ListAjax(NewsAddVo vo) {
        ArticleNewsExample example=new ArticleNewsExample();
        if(vo.getNewsType().equals("")){
            example.createCriteria().andTArticleFlagEqualTo("0");
        }else{
            example.createCriteria().andTArticleFlagEqualTo("0").andTArticleTypeEqualTo(vo.getNewsType());
        }
        example.setOrderByClause("crate_time desc");
        PageHelper.startPage(vo.getPage(),vo.getSize());
        List<ArticleNews> articleNewsList=articleNewsMapper.selectByExample(example);
        PageInfo<ArticleNews> pageInfo=new PageInfo<>(articleNewsList);
        return pageInfo;
    }

    @Override
    public void insert(ArticleNews articleNews) {
        articleNews.setId(UUIDUtils.generateUUID());
        articleNews.settArticleFlag("0");
        articleNews.setCrateTime(new Date());
        //默认不推荐
        articleNews.setStr1("0");
        //默认下线
        articleNews.setStatus("0");

        articleNewsMapper.insert(articleNews);

    }

    @Override
    public PageInfo<ArticleNews> listAjaxAnn(BaseVo vo) {
        ArticleNewsExample example=new ArticleNewsExample();
        example.createCriteria().andTArticleFlagEqualTo("1");
        PageHelper.startPage(vo.getPage(),vo.getSize());
        List<ArticleNews> articleNewsList=articleNewsMapper.selectByExample(example);
        PageInfo<ArticleNews> pageInfo=new PageInfo<>(articleNewsList);
        return pageInfo;
    }

    @Override
    public void insertAnn(ArticleNews articleNews) {
        articleNews.setId(UUIDUtils.generateUUID());
        //flag 0:新闻 1：公告
        articleNews.settArticleFlag("1");
        articleNews.setCrateTime(new Date());
        //默认不推荐
        articleNews.setStr1("0");
        //默认下线
        articleNews.setStatus("0");

        articleNewsMapper.insert(articleNews);
    }

    @Override
    public void delete(String id) {
        articleNewsMapper.deleteByPrimaryKey(id);
    }

    @Override
    public void alertFlag(String id) {
        ArticleNewsExample example=new ArticleNewsExample();
        example.createCriteria().andIdEqualTo(id);
        List<ArticleNews> articleNewsList=articleNewsMapper.selectByExample(example);
        ArticleNews articleNews=new ArticleNews();
        if(articleNewsList.size()>0){
            articleNews=articleNewsList.get(0);
        }
        if(articleNews.getStatus().equals("0")){
            articleNews.setStatus("1");
            articleNewsMapper.updateByPrimaryKeySelective(articleNews);
        }else{
            articleNews.setStatus("0");
            articleNewsMapper.updateByPrimaryKeySelective(articleNews);
        }
    }

    @Override
    public void recommend(String id) {
        ArticleNewsExample example=new ArticleNewsExample();
        example.createCriteria().andIdEqualTo(id);
        List<ArticleNews> articleNewsList=articleNewsMapper.selectByExample(example);
        ArticleNews articleNews=new ArticleNews();
        if(articleNewsList.size()>0){
            articleNews=articleNewsList.get(0);
        }
        if(articleNews.getStr1().equals("1")){
            articleNews.setStr1("0");
            articleNewsMapper.updateByPrimaryKeySelective(articleNews);
        }else{
            articleNews.setStr1("1");
            articleNewsMapper.updateByPrimaryKeySelective(articleNews);
        }

    }
}
