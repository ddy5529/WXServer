package com.ddy.wxServer.Controller;

import org.apache.commons.codec.digest.DigestUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Collections;

@RestController
@RequestMapping("/wx")
public class WeiXinController {
    @Value("${ddy.name}")
    private String ddy_name;
    @Value("${ddy.appID}")
    private String appID;
    @Value("${ddy.appsecret}")
    private String appsecret;
    //发送请求，获取token值
//https://api.weixin.qq.com/cgi-bin/token?grant_type=client_credential&appid=wxd5db089fcb11393f&secret=9a7dbdbaa4f1363a3b4c6852f4b57176
    @GetMapping()
    public String getMessage(@PathVariable String signature,@PathVariable String timestamp,@PathVariable String nonce,@PathVariable String echostr){
        System.out.println("发送的请求：");
        String token="DVRHMk__qgIrdGLrzSjEIk-1ZuojcNIG4gfmVwA_qRZRCD_Tm1rXWMNRzMWVr7ObnN7tzGHSm1fMPJX1hLQJAKcuP5D_t40Fvut2f1xyBr5IBHHHLRJ8dcoJhrDZeFw2TYIfAGAEJT";
        ArrayList<String> list=new ArrayList<String>();
        list.add(nonce);
        list.add(timestamp);
        list.add(token);

        Collections.sort(list);


        System.out.println(DigestUtils.shaHex(list.get(0)+list.get(1)+list.get(2)));
        return "hello,word";
    }
}
