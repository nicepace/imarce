package com.imarce.dao;
 
import java.security.MessageDigest;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;
 
import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.NameValuePair;
import org.apache.commons.httpclient.methods.PostMethod;
 
public class TaobaoOpenApiDemo {
 
    /**
     * 调用淘宝的taobao.trade.get demo，
     * 运行该示例时，你需要将appId,appSecret,tid
     * 这三个参数替换为你自己的，就可以运行该demo
     *
     * 在第一次运行时 会提醒你登录淘宝进行授权，
     * 授权成功后 再次运行该demo就可以获取指定交易的信息 呵呵
     *
     * 这只是一个简单的demo，只是为初学者提供方便
     * 有了这个原型 大家就可以各显自己的神通了
     */
    public static void main(String[] args) {
      
       // 淘宝Open API平台即SIP平台的入口
       String sipRequestUrl = "http://sip.alisoft.com/sip/rest";
       String appId = "****"; // 在阿里软件平台注册的应用ID,请使用你自己的应用ID
       String appSecret = "******"; // 注册的应用的密钥，请使用你自己应用的密钥
       String taobaoApiName = "taobao.trade.get"; // 交易类api
       String sessionId = "1234567";//sessionId是isv应用自己生成的字符串
//确保每个使用该应用的用户各自的sessionId各不相同
       SimpleDateFormat formater = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
 
       Map<String, String> params = new HashMap<String, String>();
       params.put("sip_appkey", appId);
       params.put("sip_apiname", taobaoApiName);
       params.put("sip_timestamp", formater.format(new Date()));
       params.put("sip_sessionid", sessionId);
       params.put("fields", "seller_nick,buyer_nick,title,type,created,sid");
       params.put("tid", "******"); //请设置你要查询的交易号
       params.put("format", "xml");
       params.put("v", "1.0");
       params.put("sip_sign", getSign(appSecret, params));
 
       String result = requestOpenApi(sipRequestUrl, params);
       if (result != null && result.startsWith("sip_isp_loginurl:")) {
           result = result.replaceAll("&amp;", "&");
           System.out.println("打开浏览器，访问下面的URL进行用户授权，授权成功后" +
                  "，再次运行该类就可以调用api获取交易信息");
           System.out.println(result.substring("sip_isp_loginurl:".length()));
       } else if (result != null)
           System.out.println(result);
 
    }
 
    /**
     * 请求淘宝Open API服务
     * @param url 服务集群平台入口
     * @param params 请求参数
     * @return 请求结果
     */
    public static String requestOpenApi(String url, Map<String, String> params) {
       HttpClient client = new HttpClient();
       PostMethod postMethod = new PostMethod(url);
 
       try {
           NameValuePair[] postData = new NameValuePair[params.size()];
 
           Iterator<String> iters = params.keySet().iterator();
           int i = 0;
 
           while (iters.hasNext()) {
              String key = (String) iters.next();
              postData[i] = new NameValuePair(key, params.get(key).toString());
              i++;
           }
 
           postMethod.setRequestBody(postData);
           client.executeMethod(postMethod);
           String resultCode = postMethod.getResponseHeader("sip_status")
                  .getValue();
           if (resultCode == null || ("".equals(resultCode)))
              return null;
           else if ("1004".equals(resultCode))
              return "sip_isp_loginurl:"
                     + postMethod.getResponseHeader("sip_isp_loginurl")
                            .getValue();
           else if (!"9999".equals(resultCode))
              return resultCode
                     + ":"
                     + postMethod.getResponseHeader("sip_errormessage")
                            .getValue();
 
           return postMethod.getResponseBodyAsString();
 
       } catch (Exception ex) {
           ex.printStackTrace();
       } finally {
           if (postMethod != null)
              postMethod.releaseConnection();
       }
 
       return null;
 
    }
 
    /**
     * 对所有参数进行签名
     * @param secret APP ID对应的密钥
     * @param params 请求中所有的参数
     * @return 签名
     */
    public static String getSign(String secret, Map<String, String> params) {
       if (secret == null || "".equals(secret) || params == null)
           throw new RuntimeException(
                  "secret or params is null or blank, please check...");
 
       StringBuilder sb = new StringBuilder().append(secret);
       String result = null;
 
       try {
           Set<String> sortedKeys = new TreeSet<String>();
           sortedKeys.addAll(params.keySet());
           for (String key : sortedKeys)
              sb.append(key).append(params.get(key));
 
           MessageDigest md = MessageDigest.getInstance("MD5");
           result = byteTohex(md.digest(sb.toString().getBytes("utf-8")));
 
       } catch (Exception e) {
           throw new RuntimeException(e);
       }
 
       return result;
    }
 
    public static String byteTohex(byte[] b) {
       StringBuffer sb = new StringBuffer();
       String stmp = "";
 
       for (int n = 0; n < b.length; n++) {
           stmp = (java.lang.Integer.toHexString(b[n] & 0XFF));
 
           if (stmp.length() == 1)
              sb.append("0").append(stmp);
           else
              sb.append(stmp);
       }
 
       return sb.toString().toUpperCase();
    }
 
}