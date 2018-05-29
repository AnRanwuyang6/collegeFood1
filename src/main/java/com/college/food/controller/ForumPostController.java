package com.college.food.controller;

import com.college.food.common.ajax.AjaxResult;
import com.college.food.common.utils.DateUtil;
import com.college.food.common.vo.BaseVo;
import com.college.food.entity.ForumPost;
import com.college.food.entity.ForumTopic;
import com.college.food.entity.User;
import com.college.food.service.ForumPostService;
import com.college.food.service.ForumTopicService;
import com.college.food.vo.PostVo;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
@RequestMapping("/post")
public class ForumPostController {
    @Autowired
    private ForumPostService forumPostService;
    @Autowired
    private ForumTopicService forumTopicService;
    @RequestMapping("/html")
    public String html(Model model){
        List<ForumTopic> forumTopicList=forumTopicService.findListByStatus();
        model.addAttribute("forumTopicList",forumTopicList);
        return "/post/Frame";
    }
    @RequestMapping("/listAjax")
    @ResponseBody
    public AjaxResult listAjax(BaseVo vo,String topicType,String title){
        AjaxResult result=new AjaxResult();
        try {
            PostVo postVo=new PostVo();
            postVo.setPage(vo.getPage());
            postVo.setSize(vo.getSize());
            if(!topicType.equals("")){
                postVo.setTopicType(topicType);
            }
            if(!title.equals("")){
                postVo.setTitle(title);
            }
            PageInfo<ForumPost> pageInfo=forumPostService.listAjax(postVo);
            for(ForumPost forumPost:pageInfo.getList()){
                forumPost.setPostContent(DateUtil.DataToString_yyyyMMdd(forumPost.getCreatTime()));
            }
            result.setData(pageInfo);
            result.setCode(AjaxResult.RESULT_CODE_0000);
            result.setMessage("成功");
        }catch (Exception e){
            result.setCode(AjaxResult.RESULT_CODE_0001);
            result.setMessage(e.getMessage());
        }
        return  result;
    }
    @RequestMapping("/alertFlag/{id}")
    @ResponseBody
    public AjaxResult alertFlag(@PathVariable("id") String id){
        AjaxResult result=new AjaxResult();
        try {
            forumPostService.alertFlag(id);
            result.setCode(AjaxResult.RESULT_CODE_0000);
            result.setMessage("成功");
        }catch (Exception e){
            result.setCode(AjaxResult.RESULT_CODE_0001);
            result.setMessage(e.getMessage());
        }
        return result;
    }
    @RequestMapping("/recommend/{id}")
    @ResponseBody
    public AjaxResult recommend(@PathVariable("id") String id){
        AjaxResult result=new AjaxResult();
        try {
            forumPostService.toTop(id);
            result.setCode(AjaxResult.RESULT_CODE_0000);
            result.setMessage("成功");
        }catch (Exception e){
            result.setCode(AjaxResult.RESULT_CODE_0001);
            result.setMessage(e.getMessage());
        }
        return result;
    }
    //精华 普通
    @RequestMapping("/good/{id}")
    @ResponseBody
    public AjaxResult good(@PathVariable("id") String id){
        AjaxResult result=new AjaxResult();
        try {
            forumPostService.toGood(id);
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
            forumPostService.delete(id);
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
            ForumPost forumPost=forumPostService.findOne(id);
            result.setData(forumPost);
            result.setCode(AjaxResult.RESULT_CODE_0000);
            result.setMessage("成功");
        }catch (Exception e){
            result.setCode(AjaxResult.RESULT_CODE_0001);
            result.setMessage(e.getMessage());
        }
        return result;
    }
    @RequestMapping("/addHtml")
    public String addhtml(Model model){
        List<ForumTopic> forumTopicList=forumTopicService.findListByStatus();
        model.addAttribute("forumTopicList",forumTopicList);
        return "/postAdd/Frame";
    }
    @RequestMapping("/insert")
    @ResponseBody
    public AjaxResult insert(ForumPost forumPost, HttpServletRequest request){
        AjaxResult result=new AjaxResult();
        User user=(User)request.getSession().getAttribute("user");
        try {
            forumPostService.insert(forumPost,user);
            result.setCode(AjaxResult.RESULT_CODE_0000);
            result.setMessage("成功");
        }catch (Exception e){
            result.setCode(AjaxResult.RESULT_CODE_0001);
            result.setMessage(e.getMessage());
        }
        return result;
    }
}
