package com.college.food.model;

import com.thoughtworks.xstream.annotations.XStreamAlias;

/**
 * Created by hd on 2017/1/5.
 * 畅天游短信接口返回xml对应的实体类
 */
@XStreamAlias("Root")
public class SMSChangTianYouEntity {
    @XStreamAlias("Result")
    private String result;
    @XStreamAlias("CtuId")
    private String ctuId;
    @XStreamAlias("SendNum")
    private String sendNum;
    @XStreamAlias("MobileNum")
    private String mobileNum;

    @Override
    public String toString() {
        return "SMSChangTianYouEntity{" +
                "result='" + result + '\'' +
                ", ctuId='" + ctuId + '\'' +
                ", sendNum='" + sendNum + '\'' +
                ", mobileNum='" + mobileNum + '\'' +
                '}';
    }

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }

    public String getCtuId() {
        return ctuId;
    }

    public void setCtuId(String ctuId) {
        this.ctuId = ctuId;
    }

    public String getSendNum() {
        return sendNum;
    }

    public void setSendNum(String sendNum) {
        this.sendNum = sendNum;
    }

    public String getMobileNum() {
        return mobileNum;
    }

    public void setMobileNum(String mobileNum) {
        this.mobileNum = mobileNum;
    }

    public SMSChangTianYouEntity(String result, String ctuId, String sendNum, String mobileNum) {

        this.result = result;
        this.ctuId = ctuId;
        this.sendNum = sendNum;
        this.mobileNum = mobileNum;
    }

    public SMSChangTianYouEntity() {

    }
}
