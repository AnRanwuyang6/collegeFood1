package com.college.food.controller;

import com.college.food.common.ajax.AjaxResult;
import com.college.food.common.utils.DateUtil;
import com.college.food.entity.ArticleNews;
import com.college.food.entity.User;
import com.college.food.service.AfterNewsAddService;
import com.college.food.vo.NewsAddVo;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("/afterNews")
public class AfterNewsAddController {
    @Autowired
    private AfterNewsAddService afterNewsAddService;
    @RequestMapping("/html")
    public String html(){
        return "/news/Frame";
    }
    @RequestMapping("/listAjax")
    @ResponseBody
    public AjaxResult listAjax(NewsAddVo vo){
        AjaxResult result=new AjaxResult();
        try {
            PageInfo<ArticleNews> pageInfo=afterNewsAddService.ListAjax(vo);
            for(ArticleNews articleNews:pageInfo.getList()){
                articleNews.setStr2(DateUtil.DataToString_yyyyMMdd(articleNews.getCrateTime()));
            }
            result.setData(pageInfo);
            result.setCode(AjaxResult.RESULT_CODE_0000);
            result.setMessage("成功");
        }catch (Exception e){
            result.setCode(AjaxResult.RESULT_CODE_0001);
            result.setMessage(e.getMessage());
        }
        return  result;
    }
    @RequestMapping("/toAdd")
    public String toAdd(){
        return "afterNewsAdd/Frame";
    }

    @RequestMapping("/insert")
    @ResponseBody
    public AjaxResult insert(ArticleNews articleNews, HttpServletRequest request){
        AjaxResult result=new AjaxResult();
        try {
            User user=(User)request.getSession().getAttribute("user");
            articleNews.setUserId(user.getId());
            articleNews.setUserName(user.getStr2());
            afterNewsAddService.insert(articleNews);
            result.setCode(AjaxResult.RESULT_CODE_0000);
            result.setMessage("成功");
        }catch (Exception e){
            result.setCode(AjaxResult.RESULT_CODE_0001);
            result.setMessage(e.getMessage());
        }
        return result;
    }

    @RequestMapping("/delete/{id}")
    @ResponseBody
    public AjaxResult delete(@PathVariable("id") String id){
        AjaxResult result=new AjaxResult();
        try {
            afterNewsAddService.delete(id);
            result.setCode(AjaxResult.RESULT_CODE_0000);
            result.setMessage("成功");
        }catch (Exception e){
            result.setCode(AjaxResult.RESULT_CODE_0001);
            result.setMessage(e.getMessage());
        }
        return result;
    }
    @RequestMapping("/alertFlag/{id}")
    @ResponseBody
    public AjaxResult alertFlag(@PathVariable("id") String id){
        AjaxResult result=new AjaxResult();
        try {
            afterNewsAddService.alertFlag(id);
            result.setCode(AjaxResult.RESULT_CODE_0000);
            result.setMessage("成功");
        }catch (Exception e){
            result.setCode(AjaxResult.RESULT_CODE_0001);
            result.setMessage(e.getMessage());
        }
        return result;
    }
    @RequestMapping("/recommend/{id}")
    @ResponseBody
    public AjaxResult recommend(@PathVariable("id") String id){
        AjaxResult result=new AjaxResult();
        try {
            afterNewsAddService.recommend(id);
            result.setCode(AjaxResult.RESULT_CODE_0000);
            result.setMessage("成功");
        }catch (Exception e){
            result.setCode(AjaxResult.RESULT_CODE_0001);
            result.setMessage(e.getMessage());
        }
        return result;
    }
}
