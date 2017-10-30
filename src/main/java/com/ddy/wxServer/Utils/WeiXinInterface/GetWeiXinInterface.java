package com.ddy.wxServer.Utils.WeiXinInterface;

import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.Constants;
import org.springframework.core.annotation.Order;
import org.springframework.http.*;
import org.springframework.web.client.RestTemplate;

public class GetWeiXinInterface {
    @Value("${ddy.appID}")
    static private String appID;
    @Value("${ddy.appsecret}")
    static private String appsecret;

    public String POSTToken() {
        RestTemplate restTemplate = new RestTemplate();
        String url = "https://api.weixin.qq.com/cgi-bin/token?grant_type=client_credential&appid=" + appID + "&secret=" + appsecret;
/* 注意：必须 http、https……开头，不然报错，浏览器地址栏不加 http 之类不出错是因为浏览器自动帮你补全了 */
        HttpHeaders headers = new HttpHeaders();
/* 这个对象有add()方法，可往请求头存入信息 */
        headers.setContentType(MediaType.APPLICATION_JSON_UTF8);
/* 解决中文乱码的关键 , 还有更深层次的问题 关系到 StringHttpMessageConverter，先占位，以后补全*/
        HttpEntity<String> entity = new HttpEntity<String>("", headers);
/* body是Http消息体例如json串 */
        restTemplate.exchange(url, HttpMethod.POST, entity, String.class);
/*上面这句返回的是往 url发送 post请求 请求携带信息为entity时返回的结果信息
String.class 是可以修改的，例如User.class，这样你就可以有 User resultUser接返回结果了*/
        return null;
    }

    static public String GetToken()  {
        appID="wxd5db089fcb11393f";
        appsecret="9a7dbdbaa4f1363a3b4c6852f4b57176";
        String token;
        RestTemplate restTemplate = new RestTemplate();
        String url = "https://api.weixin.qq.com/cgi-bin/token?grant_type=client_credential&appid=" + appID + "&secret=" + appsecret;
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON_UTF8);
        HttpEntity<String> entity = new HttpEntity<String>("", headers);
        ResponseEntity<String> results = restTemplate.exchange(url, HttpMethod.GET, entity, String.class);
        try {
            JSONObject jsonObject=  new JSONObject(results.getBody().toString());
            token=(String)jsonObject.get("access_token");
        }catch (Exception e){
            token="error";
        }
        return token;
    }

    public String getWeiXinServerIPAddress(){
        String ACCESS_TOKEN=GetToken();
        String url = "https://api.weixin.qq.com/cgi-bin/getcallbackip?access_token="+ACCESS_TOKEN;
        RestTemplate restTemplate = new RestTemplate();
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON_UTF8);
        HttpEntity<String> entity = new HttpEntity<String>("", headers);
        ResponseEntity<String> results = restTemplate.exchange(url, HttpMethod.GET, entity, String.class);
        return results.getBody().toString();
    }
}
