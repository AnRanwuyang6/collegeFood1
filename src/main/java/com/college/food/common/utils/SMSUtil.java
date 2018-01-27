package com.college.food.common.utils;

import com.college.food.model.SMSChangTianYouEntity;
import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.DomDriver;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

/**
 * Created by yichen ─=≡Σ(((つ•̀ω•́)つ) on 2017/9/25.
 */
public class SMSUtil {

    //测试地址
//    public static String smsUrl = "http://sms.800617.com:4400/sms/SendSMS.aspx?un=ctyswse-9&pwd=0080c9&mobile=${mobileNum}&msg=${msg}";
    //生产地址
    public static String smsUrl = "http://sms.800617.com:4400/sms/SendSMS.aspx?un=gggjzx-1&pwd=79f066&mobile=${mobileNum}&msg=${msg}";
    public static String charset = "GB2312";

    /**
     * 发短信
     */
    public static SMSChangTianYouEntity sendSMS(String mobileNum, String msg){
        SMSChangTianYouEntity result = null;
        try {
            String sendUrl = smsUrl.replace("${mobileNum}", mobileNum).replace("${msg}", URLEncoder.encode(msg, charset));
            String xml = new HttpClientUtil().executeHttpRequestStringByRealGet(sendUrl, null);
            result = parseSendSMS(xml);
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        return result;
    }


    /**
     * 解析发送短信后返回的xml内容
     * @param xml
     * @return
     */
    public static SMSChangTianYouEntity parseSendSMS(String xml){
        SMSChangTianYouEntity smsChangTianYouEntity = null;
        XStream xstream=new XStream(new DomDriver());
        xstream.processAnnotations(SMSChangTianYouEntity.class);
        smsChangTianYouEntity =  (SMSChangTianYouEntity)xstream.fromXML(xml);
        return smsChangTianYouEntity;
    }

    public static void main(String[] args) {
//        String xml="<?xml version=\"1.0\" encoding=\"gb2312\"?>\n" +
//                "<Root>\n" +
//                "    <Result>1</Result>\n" +
//                "    <CtuId>01701050914280004290</CtuId>\n" +
//                "    <SendNum>1</SendNum>\n" +
//                "    <MobileNum>1</MobileNum>\n" +
//                "</Root>";
//        System.out.println(parseSendSMS(xml));
//        sendSMS("18613818559","test");
        System.out.println(" a string".split("/.").toString());
    }

}
