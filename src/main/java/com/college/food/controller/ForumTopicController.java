package com.college.food.controller;

import com.college.food.common.ajax.AjaxResult;
import com.college.food.common.utils.DateUtil;
import com.college.food.entity.ForumTopic;
import com.college.food.entity.User;
import com.college.food.service.ForumTopicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * Created by lizongke on 2018/5/7.
 */
@Controller
@RequestMapping("/forumTopic")
public class ForumTopicController {
    @Autowired
    private ForumTopicService forumTopicService;
    @RequestMapping("/html")
    public String html(){
        return "/forumTopic/Frame";
    }
    @RequestMapping("/listAjax")
    @ResponseBody
    public AjaxResult listAjax(){
        AjaxResult result=new AjaxResult();
        try {
            List<ForumTopic> forumTopicList=forumTopicService.findList();
            for(ForumTopic forumTopic:forumTopicList){
                forumTopic.setTopicDescribe(DateUtil.DataToString_yyyyMMdd(forumTopic.getCreatTime()));
            }
            result.setData(forumTopicList);
            result.setCode(AjaxResult.RESULT_CODE_0000);
            result.setMessage("成功");
        }catch (Exception e){
            result.setCode(AjaxResult.RESULT_CODE_0001);
            result.setMessage(e.getMessage());
        }
        return  result;
    }
    @RequestMapping("/insert")
    @ResponseBody
    public AjaxResult insert(ForumTopic forumTopic, HttpServletRequest request){
        AjaxResult result=new AjaxResult();
        User user=(User)request.getSession().getAttribute("user");
        try {
            forumTopicService.insert(forumTopic,user);
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
          forumTopicService.alertFlag(id);
          result.setCode(AjaxResult.RESULT_CODE_0000);
          result.setMessage("成功");
      }catch (Exception e){
          result.setCode(AjaxResult.RESULT_CODE_0001);
          result.setMessage(e.getMessage());
      }
      return result;
    }
}
