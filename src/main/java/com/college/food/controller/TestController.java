package com.college.food.controller;

import com.college.food.common.ajax.AjaxResult;
import com.college.food.entity.AppTest;
import com.college.food.service.TsetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping("/test")
public class TestController {
    @Autowired
    private TsetService tsetService;
    @RequestMapping("/list")
    @ResponseBody
    public AjaxResult list(){
        AjaxResult result=new AjaxResult();
        try {
            result.setCode(AjaxResult.RESULT_CODE_0000);
            List<AppTest> appTestList=tsetService.findAll();
            result.setData(appTestList);
        }catch (Exception e){

        }
        return result;
    }
}
