package com.college.food.controller;

import com.college.food.common.ajax.AjaxResult;
import com.college.food.common.utils.DateUtil;
import com.college.food.common.vo.BaseVo;
import com.college.food.entity.Tender;
import com.college.food.entity.User;
import com.college.food.service.TenderService;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by lizongke ─=≡Σ(((つ•̀ω•́)つ) on 2018/5/16.
 */
@Controller
@RequestMapping("/tender")
public class TenderController {
    @Autowired
    private TenderService tenderService;
    //我的招标公告
    @RequestMapping("/myhtml")
    public String myhtml(){
        return "/tender/Frame";
    }
    @RequestMapping("/html")
    public String html(){
        return "/tender/allFrame";
    }
    @RequestMapping("myListAjax")
    @ResponseBody
    public AjaxResult myListAjax(BaseVo vo, HttpServletRequest request){
        AjaxResult result=new AjaxResult();
        User user=(User)request.getSession().getAttribute("user");
        try {
            PageInfo<Tender> pageInfo=tenderService.listAjax(vo,user.getId());
            for(Tender tender:pageInfo.getList()){
                tender.setStr1(DateUtil.DataToString_yyyyMMdd(tender.getCreateTime()));
            }
            result.setData(pageInfo);
            result.setCode(AjaxResult.RESULT_CODE_0000);
            result.setMessage("成功");
        }catch (Exception e){
            result.setCode(AjaxResult.RESULT_CODE_0001);
            result.setMessage(e.getMessage());
        }
        return result;
    }
    @RequestMapping("ListAjax")
    @ResponseBody
    public AjaxResult ListAjax(BaseVo vo){
        AjaxResult result=new AjaxResult();
        try {
            PageInfo<Tender> pageInfo=tenderService.allListAjax(vo);
            for(Tender tender:pageInfo.getList()){
                tender.setStr1(DateUtil.DataToString_yyyyMMdd(tender.getCreateTime()));
            }
            result.setData(pageInfo);
            result.setCode(AjaxResult.RESULT_CODE_0000);
            result.setMessage("成功");
        }catch (Exception e){
            result.setCode(AjaxResult.RESULT_CODE_0001);
            result.setMessage(e.getMessage());
        }
        return result;
    }
    @RequestMapping("/insert")
    @ResponseBody
    public AjaxResult insert(Tender tender,HttpServletRequest request){
        User user=(User)request.getSession().getAttribute("user");
        AjaxResult result=new AjaxResult();
        try {
            tenderService.insert(tender,user);
            result.setCode(AjaxResult.RESULT_CODE_0000);
            result.setMessage("成功");
        }catch (Exception e){
            result.setCode(AjaxResult.RESULT_CODE_0001);
            result.setMessage(e.getMessage());
        }
        return result;
    }
}
