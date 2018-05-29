package com.college.food.controller;


import com.college.food.common.ajax.AjaxResult;
import com.college.food.common.utils.DateUtil;
import com.college.food.common.vo.BaseVo;
import com.college.food.entity.FoodType;
import com.college.food.entity.MyUtil;
import com.college.food.service.AfterFoodTypeService;
import com.github.pagehelper.PageInfo;
import groovy.util.logging.Log4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;

/**
 * Created by  on 2018/5/7.
 * 统计分析图表
 */
@Controller
@RequestMapping("/afterCount")
@Log4j
public class AfterCountController {
    @Autowired
    private AfterFoodTypeService afterFoodTypeService;


    @RequestMapping("/html")
    public String html(){
        return "/afterCount/myFrame";
    }

    @RequestMapping("/count")
    public String topicCount(){
        return "/afterCount/myFrame2";
    }



    @RequestMapping("/ListAjax")
    @ResponseBody
    public AjaxResult listAjax(BaseVo vo, String status){
        AjaxResult result=new AjaxResult();
        try {
            PageInfo<FoodType> pageInfo=afterFoodTypeService.listAjax(vo,status);
            result.setData(pageInfo);
            for(FoodType foodType:pageInfo.getList()){
                foodType.setStr2(DateUtil.DateToString(foodType.getCreatTime()));
            }
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
    public  AjaxResult insert(FoodType foodType){
        AjaxResult result=new AjaxResult();
        try {
            afterFoodTypeService.insert(foodType);
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
            afterFoodTypeService.alertFlag(id);
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
    public AjaxResult delete(@PathVariable("id")String id){
        AjaxResult result=new AjaxResult();
        try {
            afterFoodTypeService.delete(id);
            result.setCode(AjaxResult.RESULT_CODE_0000);
            result.setMessage("成功");
        }catch (Exception e){
            result.setCode(AjaxResult.RESULT_CODE_0001);
            result.setMessage(e.getMessage());
        }
        return result;
    }
}
