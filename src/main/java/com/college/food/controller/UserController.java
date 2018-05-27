package com.college.food.controller;

import com.college.food.common.ajax.AjaxResult;
import com.college.food.common.vo.BaseVo;
import com.college.food.entity.User;
import com.college.food.service.UserService;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;

    @RequestMapping("/html")
    public String html(){
        return "/user/Frame";
    }

    @RequestMapping("/listAjax")
    @ResponseBody
    public AjaxResult listAjax(BaseVo vo,String userType){
        AjaxResult result=new AjaxResult();
        try {
            PageInfo<User> pageInfo=userService.findList(vo,userType);
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
    public AjaxResult insert(User user){
        AjaxResult result=new AjaxResult();
        try {
            userService.insert(user);
            result.setCode(AjaxResult.RESULT_CODE_0000);
            result.setMessage("成功");
        }catch (Exception e){
            result.setCode(AjaxResult.RESULT_CODE_0001);
            result.setMessage(e.getMessage());
        }
        return result;
    }
    @RequestMapping("/{id}")
    @ResponseBody
    public AjaxResult findOne(@PathVariable("id") String id){
        AjaxResult result=new AjaxResult();
        try {
            User user=userService.findOne(id);
            result.setData(user);
            result.setCode(AjaxResult.RESULT_CODE_0000);
            result.setMessage("成功");
        }catch (Exception e){
            result.setCode(AjaxResult.RESULT_CODE_0001);
            result.setMessage(e.getMessage());
        }
        return result;
    }
    @RequestMapping("/update")
    @ResponseBody
    public AjaxResult edit(User user){
        AjaxResult result=new AjaxResult();
        try {
            userService.update(user);
            result.setCode(AjaxResult.RESULT_CODE_0000);
            result.setMessage("成功");
        }catch (Exception e){
            result.setCode(AjaxResult.RESULT_CODE_0001);
            result.setMessage(e.getMessage());
        }
        return result;
    }
}
