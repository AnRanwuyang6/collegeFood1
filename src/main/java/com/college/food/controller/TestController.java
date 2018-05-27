package com.college.food.controller;

import com.college.food.common.ajax.AjaxResult;
import com.college.food.entity.AppTest;
import com.college.food.entity.User;
import com.college.food.service.TsetService;
import com.github.pagehelper.PageInfo;
import org.apache.coyote.http11.Http11AprProtocol;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
@RequestMapping("/test")
public class TestController {
    @Autowired
    private TsetService tsetService;
    @RequestMapping("/html")
    public String html(String pre, HttpServletRequest request){
        request.getSession().setAttribute("pre",pre);
        return "test/Frame";
    }



    @RequestMapping("/list")
    @ResponseBody
    public AjaxResult list(){
        AjaxResult result=new AjaxResult();
        try {
            result.setCode(AjaxResult.RESULT_CODE_0000);
           /* List<AppTest> appTestList=tsetService.findAll();*/
            PageInfo<User> pageInfo=tsetService.findUser();
            result.setData(pageInfo);
        }catch (Exception e){

        }
        return result;
    }
}
