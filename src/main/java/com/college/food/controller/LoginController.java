package com.college.food.controller;

import com.college.food.common.ajax.AjaxResult;
import com.college.food.entity.User;
import com.college.food.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by lizongke─=≡Σ(((つ•̀ω•́)つ) on 2018/5/18.
 */
@Controller
@RequestMapping("/login")
public class LoginController {
    @Autowired
    private LoginService loginService;
    @RequestMapping("/in")
    @ResponseBody
    public AjaxResult loginIn(String username, String password, HttpServletRequest request){
        AjaxResult result=new AjaxResult();
        try {
            String msg;
            User user=loginService.findOne(username,password);
            if(user.getUsername()!=null&&user.getPassword()!=null){
                request.getSession().setAttribute("user",user);
                //说明存在用户
                //用户角色
                msg=user.getStr1();
            }else{
                msg="用户不存在";
            }
            result.setCode(AjaxResult.RESULT_CODE_0000);
            result.setMessage(msg);
        }catch (Exception e){
            result.setCode(AjaxResult.RESULT_CODE_0001);
            result.setMessage(e.getMessage());
        }
        return result;
    }

}
