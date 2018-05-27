package com.college.food.controller;

import com.college.food.common.ajax.AjaxResult;
import com.college.food.common.utils.DateUtil;
import com.college.food.common.vo.BaseVo;
import com.college.food.entity.FoodInformation;
import com.college.food.entity.User;
import com.college.food.service.FoodInformationService;
import com.github.pagehelper.PageInfo;
import org.apache.catalina.servlet4preview.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by lizongke on 2018/5/7.
 */
@Controller
@RequestMapping("/foodInfor")
public class FoodInformationController {
    @Autowired
    private FoodInformationService foodInformationService;
    @RequestMapping("/html")
    public String html(String typeId, String flag,String typeName, Model model){
        model.addAttribute("typeId",typeId);
        model.addAttribute("flag",flag);
        model.addAttribute("typeName",typeName);
        return "FoodInfor/Frame";
    }
    @RequestMapping("/listAjax")
    @ResponseBody
    public AjaxResult listAjax(BaseVo vo,String foodStatus,String typeId){
        AjaxResult result=new AjaxResult();
        try {
            PageInfo<FoodInformation> pageInfo=foodInformationService.listAjax(vo,foodStatus,typeId);
            for(FoodInformation foodInformation:pageInfo.getList()){
                foodInformation.setStr3(DateUtil.DataToString_yyyyMMdd(foodInformation.getCreatTime()));
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
    public AjaxResult insert(FoodInformation foodInformation, HttpServletRequest request){
        User user=(User)request.getSession().getAttribute("user");
        AjaxResult result=new AjaxResult();
        try {
            foodInformationService.insert(foodInformation,user.getId());
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
            foodInformationService.alertFlag(id);
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
            FoodInformation foodInformation=foodInformationService.findOne(id);
            result.setData(foodInformation);
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
    public AjaxResult update (FoodInformation foodInformation){
        AjaxResult result=new AjaxResult();
        try {
            foodInformationService.update(foodInformation);
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
            foodInformationService.delete(id);
            result.setCode(AjaxResult.RESULT_CODE_0000);
            result.setMessage("成功");
        }catch (Exception e){
            result.setCode(AjaxResult.RESULT_CODE_0001);
            result.setMessage(e.getMessage());
        }
        return result;
    }
}
