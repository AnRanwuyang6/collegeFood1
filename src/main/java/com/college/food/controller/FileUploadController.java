package com.college.food.controller;


;import com.college.food.common.ajax.AjaxResult;
import groovy.util.logging.Log4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.PrintWriter;
import java.util.Iterator;
import java.util.Random;

/**
 * Created by lizongke ─=≡Σ(((つ•̀ω•́)つ) on 2018/4/16.
 */
@Controller
@RequestMapping("/file")
@Log4j
public class FileUploadController {

    @RequestMapping("/upload")
    public AjaxResult upload(HttpServletRequest request, HttpServletResponse response)throws Exception{
        PrintWriter out = response.getWriter();
        response.setContentType ("text/html;charset=UTF-8");
        AjaxResult result = new AjaxResult();
        String CKEditorFuncNum = request.getParameter("CKEditorFuncNum");
        try {
            result.setCode(AjaxResult.RESULT_CODE_0000);
            //用来检测程序运行时间
            long startTime = System.currentTimeMillis();
            //将当前上下文初始化给  CommonsMutipartResolver （多部分解析器）
            CommonsMultipartResolver multipartResolver = new CommonsMultipartResolver(request.getSession().getServletContext());
            //检查form中是否有enctype="multipart/form-data"

            if (multipartResolver.isMultipart(request)) {
                //将request变成多部分request
                MultipartHttpServletRequest multiRequest = (MultipartHttpServletRequest) request;
                //获取multiRequest 中所有的文件名
                Iterator iter = multiRequest.getFileNames();
                //上传路径
                String path="D:/tomcat6/mytomcat/webapps/myssm/upload/img/";
                while (iter.hasNext()) {
                    //一次遍历所有文件
                    MultipartFile file = multiRequest.getFile(iter.next().toString());
                    if (file != null &&file.getOriginalFilename()!=null) {
                        String suffix=file.getOriginalFilename().substring(file.getOriginalFilename().lastIndexOf("."));
                        System.out.println(suffix+"-------------");
                        String imgssuffix=".png .jpg .jpeg .gif .bpm";
                        if(!imgssuffix.contains(suffix.toLowerCase())){
                            out.println("<script type=\"text/javascript\">");
                            out.println("window.parent.CKEDITOR.tools.callFunction(" + CKEditorFuncNum + ",''," + "'must be (.jpg/.gif/.bmp/.png');");
                            out.println("</script>");
                        }else{
                            //上传
                            String name = new Random().nextInt(90000000) + 10000000 + "";
                            file.transferTo(new File(path+name+suffix));
                            //回显路径
                            String url="http://localhost:8080/myssm/upload/img/"+name+suffix;

                            out.println("<script type=\"text/javascript\">");
                            out.println("window.parent.CKEDITOR.tools.callFunction(" + CKEditorFuncNum + ",'"+url+"','')");
                            out.println("</script>");
                            out.close();
                            break;
                        }

                    }
                }
            }
            long endTime = System.currentTimeMillis();
            System.out.println("上传耗时：" + String.valueOf(endTime - startTime) + "ms");
        } catch (Exception e) {
            result.setCode(AjaxResult.RESULT_CODE_0001);
            result.setMessage("上传失败！");
        }

        return null;
    }

    @RequestMapping("/uploadFile")
    @ResponseBody
    public AjaxResult uploadFile(HttpServletRequest request, HttpServletResponse response)throws Exception{
        response.setContentType ("text/html;charset=UTF-8");
        AjaxResult result = new AjaxResult();
        try {
            result.setCode(AjaxResult.RESULT_CODE_0000);
            //用来检测程序运行时间
            long startTime = System.currentTimeMillis();
            //将当前上下文初始化给  CommonsMutipartResolver （多部分解析器）
            CommonsMultipartResolver multipartResolver = new CommonsMultipartResolver(request.getSession().getServletContext());
            //检查form中是否有enctype="multipart/form-data"

            if (multipartResolver.isMultipart(request)) {
                //将request变成多部分request
                MultipartHttpServletRequest multiRequest = (MultipartHttpServletRequest) request;
                //获取multiRequest 中所有的文件名
                Iterator iter = multiRequest.getFileNames();
                //上传路径
                String path="D:/tomcat6/mytomcat/webapps/myssm/upload/img/";
                while (iter.hasNext()) {
                    //一次遍历所有文件
                    MultipartFile file = multiRequest.getFile(iter.next().toString());
                    String suffix=file.getOriginalFilename().substring(file.getOriginalFilename().lastIndexOf("."));
                            //上传
                    String name = new Random().nextInt(90000000) + 10000000 + "";
                    file.transferTo(new File(path+name+suffix));
                            //回显路径
                    String url="http://localhost:8080/myssm/upload/img/"+name+suffix;
                    result.setData(url);
                    break;


                }
            }
            long endTime = System.currentTimeMillis();
            System.out.println("上传耗时：" + String.valueOf(endTime - startTime) + "ms");
        } catch (Exception e) {
            result.setCode(AjaxResult.RESULT_CODE_0001);
            result.setMessage("上传失败！");
        }

        return result;
    }

}
