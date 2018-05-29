package com.college.food.controller;

import com.college.food.common.ajax.AjaxResult;
import com.college.food.common.utils.DateUtil;
import com.college.food.common.vo.BaseVo;
import com.college.food.entity.ForumPost;
import com.college.food.entity.PostComment;
import com.college.food.service.PostCommentService;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/comment")
public class PostCommentController {
    @Autowired
    private PostCommentService postCommentService;
    @RequestMapping("/html")
    public String html (){
        return "/comment/Frame";
    }
    @RequestMapping("listAjax")
    @ResponseBody
    public AjaxResult listAjax(BaseVo vo,String key){
        AjaxResult result=new AjaxResult();
        try {
            PageInfo<PostComment> pageInfo=postCommentService.listAjax(vo,key);
            for(PostComment postComment:pageInfo.getList()){
                postComment.setStr(DateUtil.DataToString_yyyyMMdd(postComment.getCommentTime()));
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
    @RequestMapping("/findOne/{id}")
    @ResponseBody
    public AjaxResult findOne(@PathVariable("id") String id){
        AjaxResult result=new AjaxResult();
        try {
            result.setData(postCommentService.findOne(id));
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
            postCommentService.delete(id);
            result.setCode(AjaxResult.RESULT_CODE_0000);
            result.setMessage("成功");
        }catch (Exception e){
            result.setCode(AjaxResult.RESULT_CODE_0001);
            result.setMessage(e.getMessage());
        }
        return result;
    }

}
