package com.college.food.controller;

import com.college.food.common.ajax.AjaxResult;
import com.college.food.common.utils.DateUtil;
import com.college.food.common.vo.BaseVo;
import com.college.food.entity.Bid;
import com.college.food.entity.Tender;
import com.college.food.entity.User;
import com.college.food.service.BidService;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("bid")
public class BidController {
    @Autowired
    private BidService bidService;
    //我的招标公告
    @RequestMapping("/html")
    public String html(String tenderId, Model model){
         model.addAttribute("tenderId",tenderId);
         return "/bid/Frame";
    }
    @RequestMapping("/ListAjax")
    @ResponseBody
    public AjaxResult myListAjax(BaseVo vo, HttpServletRequest request,String tenderId){
        AjaxResult result=new AjaxResult();
        try {
            PageInfo<Bid> pageInfo=bidService.listAjax(vo,tenderId);
            for(Bid bid:pageInfo.getList()){
                bid.setStr1(DateUtil.DataToString_yyyyMMdd(bid.getCreateTime()));
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
    public AjaxResult insert( HttpServletRequest request,String tenderId){
        AjaxResult result=new AjaxResult();
        User user=(User)request.getSession().getAttribute("user");
        try {
            bidService.insert(tenderId,user);
            result.setCode(AjaxResult.RESULT_CODE_0000);
            result.setMessage("成功");
        }catch (Exception e){
            result.setCode(AjaxResult.RESULT_CODE_0001);
            result.setMessage(e.getMessage());
        }
        return result;
    }
}
