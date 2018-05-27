package com.college.food.controller;

import com.college.food.common.ajax.AjaxResult;
import com.college.food.common.utils.DateUtil;
import com.college.food.common.utils.JpaUtils;
import com.college.food.common.vo.BaseVo;
import com.college.food.entity.Review;
import com.college.food.entity.User;
import com.college.food.service.ReviewService;
import com.college.food.vo.ReviewVo;
import com.github.pagehelper.PageInfo;
import com.sun.prism.shader.Solid_TextureYV12_AlphaTest_Loader;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * Created by lizongke on 2018/5/7.
 */
@Controller
@RequestMapping("/Review")
public class ReviewController {
    @Autowired
    private ReviewService reviewService;
    @RequestMapping("/html")
    public String html(){
        return "/review/Frame";
    }
    @RequestMapping("/insert")
    @ResponseBody
    public AjaxResult insert(ReviewVo vo, HttpServletRequest request){
        AjaxResult result=new AjaxResult();
        User  user=(User)request.getSession().getAttribute("user");
        try {
            reviewService.insert(vo,user);
            result.setCode(AjaxResult.RESULT_CODE_0000);
            result.setMessage("成功");
        }catch (Exception e){
            result.setCode(AjaxResult.RESULT_CODE_0001);
            result.setMessage(e.getMessage());
        }
        return result;
    }
    @RequestMapping("/list")
    public String list(){
        return "/review/userFrame";
    }
    @RequestMapping("/findByUser")
    @ResponseBody
    public AjaxResult findByUser(HttpServletRequest request){
        AjaxResult result=new AjaxResult();
        User  user=(User)request.getSession().getAttribute("user");
        try {
            List<Review> reviewList=reviewService.findUset(user.getId());
            for(Review review:reviewList){
                review.setStr2(DateUtil.DataToString_yyyyMMdd(review.getCreateTime()));
            }
            result.setData(reviewList);
            result.setCode(AjaxResult.RESULT_CODE_0000);
            result.setMessage("成功");
        }catch (Exception e){
            result.setCode(AjaxResult.RESULT_CODE_0001);
            result.setMessage(e.getMessage());
        }
        return result;
    }
    @RequestMapping("/Mhtml")
    public String Mhtml(){
        return "/reviewM/Frame";
    }
    @RequestMapping("/listAjax")
    @ResponseBody
    public AjaxResult listAjax(BaseVo vo,String beginTime,String endTime){
        AjaxResult result=new AjaxResult();
        try {
            Date btime=null;
            Date etime=null;
            if(!beginTime.equals("")){
                btime=JpaUtils.toDate(beginTime);
            }
            if(!endTime.equals("")){
                etime=JpaUtils.toDate(endTime);
            }
            PageInfo<Review> pageInfo=reviewService.listAjax(vo,btime,etime);
            for(Review review:pageInfo.getList()){
                review.setStr2(DateUtil.DateToString(review.getCreateTime()));
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
}
