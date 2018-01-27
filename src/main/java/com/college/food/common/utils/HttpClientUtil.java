package com.college.food.common.utils;

import org.apache.commons.httpclient.DefaultHttpMethodRetryHandler;
import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.HttpStatus;
import org.apache.commons.httpclient.NameValuePair;
import org.apache.commons.httpclient.methods.GetMethod;
import org.apache.commons.httpclient.methods.PostMethod;
import org.apache.commons.httpclient.params.HttpMethodParams;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class HttpClientUtil {
    private static final Logger log = LogManager.getLogger(HttpClientUtil.class);
    private int timeout = 5000;

    public int getTimeout() {
        return timeout;
    }

    public void setTimeout(int timeout) {
        this.timeout = timeout;
    }

    public Object executeHttpRequest(String url, Map<String, String> keyValueMap) {
        HttpClient client = new HttpClient();
        PostMethod postMethod = new PostMethod(url);
        try {
            //设置请求参数
            if (keyValueMap != null) {
                Iterator it = keyValueMap.entrySet().iterator();
                NameValuePair[] parameters = new NameValuePair[keyValueMap.size()];
                int c = 0;
                while (it.hasNext()) {
                    Map.Entry<String, String> entry = (Map.Entry<String, String>) it.next();
                    NameValuePair nvp = new NameValuePair();
                    nvp.setName(entry.getKey());
                    nvp.setValue(entry.getValue());
                    parameters[c] = nvp;
                    c++;
                }
                postMethod.addParameters(parameters);
            }
            log.debug("query uri ===============" + postMethod.getURI());
            postMethod.getParams().setParameter(HttpMethodParams.RETRY_HANDLER, new DefaultHttpMethodRetryHandler());
            postMethod.getParams().setParameter(HttpMethodParams.HTTP_CONTENT_CHARSET, "UTF-8");
            postMethod.getParams().setParameter(HttpMethodParams.SO_TIMEOUT, 200000);
            int statusCode = client.executeMethod(postMethod);
            if (statusCode != HttpStatus.SC_OK) {
                log.info("request '" + url + "' failed,the status is not 200,status:" + statusCode);
                return "";
            }
            byte[] responseBody = postMethod.getResponseBody();
            return responseBody;
        } catch (Exception e) {
            log.error("发生异常！请检查网络和参数", e);
        } finally {
            postMethod.releaseConnection();
        }
        return null;
    }


    public String executeHttpRequestString(String url, Map<String, String> keyValueMap) {
        HttpClient client = new HttpClient();
        PostMethod postMethod = new PostMethod(url);
        try {
            //设置请求参数
            if (keyValueMap != null) {
                Iterator it = keyValueMap.entrySet().iterator();
                NameValuePair[] parameters = new NameValuePair[keyValueMap.size()];
                int c = 0;
                while (it.hasNext()) {
                    Map.Entry<String, String> entry = (Map.Entry<String, String>) it.next();
                    NameValuePair nvp = new NameValuePair();
                    nvp.setName(entry.getKey());
                    nvp.setValue(entry.getValue());
                    parameters[c] = nvp;
                    c++;
                }
                postMethod.addParameters(parameters);
            }
            log.debug("query uri ===============" + postMethod.getURI());
            postMethod.getParams().setParameter(HttpMethodParams.RETRY_HANDLER, new DefaultHttpMethodRetryHandler());
            postMethod.getParams().setParameter(HttpMethodParams.HTTP_CONTENT_CHARSET, "UTF-8");
            postMethod.getParams().setParameter(HttpMethodParams.SO_TIMEOUT, timeout);
            int statusCode = client.executeMethod(postMethod);
            if (statusCode != HttpStatus.SC_OK) {
                log.info("request '" + url + "' failed,the status is not 200,status:" + statusCode);
                return "";
            }
            String responseBody = postMethod.getResponseBodyAsString();
            return responseBody;
        } catch (Exception e) {
            log.error("发生异常！请检查网络和参数", e);
        } finally {
            postMethod.releaseConnection();
        }
        return null;
    }

    public String executeHttpRequestByGetType(String url, Map<String, String> keyValueMap) {
        HttpClient client = new HttpClient();
        StringBuffer sb = new StringBuffer(url);
        PostMethod postMethod = null;
        try {
            //设置请求参数
            if (keyValueMap != null) {
                Iterator it = keyValueMap.entrySet().iterator();
                if (keyValueMap.size() > 0) {
                    sb.append("?");
                    while (it.hasNext()) {
                        Map.Entry<String, String> entry = (Map.Entry<String, String>) it.next();
                        sb.append(entry.getKey() + "=" + entry.getValue() + "&");
                    }
                    sb.deleteCharAt(sb.length() - 1);
                }

            }
            log.debug("query uri ===============" + sb.toString());
            postMethod = new PostMethod(sb.toString());
            log.debug("query uri ===============" + postMethod.getURI());
            postMethod.getParams().setParameter(HttpMethodParams.RETRY_HANDLER, new DefaultHttpMethodRetryHandler());
            postMethod.getParams().setParameter(HttpMethodParams.HTTP_CONTENT_CHARSET, "UTF-8");
            postMethod.getParams().setParameter(HttpMethodParams.SO_TIMEOUT, 200000);
            int statusCode = client.executeMethod(postMethod);
            if (statusCode != HttpStatus.SC_OK) {
                log.info("request '" + url + "' failed,the status is not 200,status:" + statusCode);
                return "";
            }
            String responseBody = postMethod.getResponseBodyAsString();
            return responseBody;
        } catch (Exception e) {
            log.error("发生异常！请检查网络和参数", e);
        } finally {
            if (postMethod != null) {
                postMethod.releaseConnection();
            }
        }
        return null;
    }

    public String executeHttpRequestStringByRealGet(String url, Map<String, String> keyValueMap) {
        HttpClient client = new HttpClient();

        StringBuffer sb = new StringBuffer(url);
        if(keyValueMap != null && !keyValueMap.equals("")) {
            sb.append("?");
            Set<String> keySet = keyValueMap.keySet();
            for (String str : keySet) {
                sb.append(str).append("=").append(keyValueMap.get(str)).append("&");
            }
            sb.deleteCharAt(sb.length() - 1);
        }
        String uri = sb.toString();

        GetMethod getMethod = new GetMethod(uri);
        try {
            int statusCode = client.executeMethod(getMethod);
            if (statusCode != HttpStatus.SC_OK) {
                log.info("request '" + url + "' failed,the status is not 200,status:" + statusCode);
                return "";
            }
            InputStream in = getMethod.getResponseBodyAsStream();
            BufferedReader buffer = new BufferedReader(new InputStreamReader(in,"UTF-8"));
            StringBuffer temp = new StringBuffer();
            for(String tempstr = ""; (tempstr = buffer.readLine()) != null;){
                temp = temp.append(tempstr);
            }
            buffer.close();
            in.close();
            String responseBody = temp.toString().trim();
            return responseBody;
        } catch (Exception e) {
            log.error("发生异常！请检查网络和参数", e);
        } finally {
            getMethod.releaseConnection();
        }
        return null;
    }

}
