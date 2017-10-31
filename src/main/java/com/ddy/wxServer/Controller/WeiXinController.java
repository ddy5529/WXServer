package com.ddy.wxServer.Controller;

import com.ddy.wxServer.Server.VerifyServer;
import com.ddy.wxServer.Server.WXInputInfoServer;
import org.apache.http.HttpRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;


@RestController
@RequestMapping("")
public class WeiXinController {
    @Value("${ddy.name}")
    private String ddy_name;
    @Value("${ddy.appID}")
    private String appID;
    @Value("${ddy.appsecret}")
    private String appsecret;

    static private Logger logger = LoggerFactory.getLogger(WeiXinController.class);

    @Autowired
    private VerifyServer verifyServer;

    @Autowired
    private WXInputInfoServer wxInputInfoServer;
    @PostMapping("/click")
    public String shouMenuButtonAndControl() {

        return "click to click";
    }


    //验证是否来自微信服务器的消息
    @RequestMapping(path = "/wx", value = "", method = RequestMethod.GET)
    public String checkSignature(@RequestParam(name = "signature", required = false) String signature,
                                 @RequestParam(name = "nonce", required = false) String nonce,
                                 @RequestParam(name = "timestamp", required = false) String timestamp,
                                 @RequestParam(name = "echostr", required = false) String echostr) {
        logger.info("------微信服务器验证中");
        return verifyServer.LoginVerify(signature, timestamp, nonce, echostr);
    }

    @PostMapping("")
    public String processPostData(HttpServletRequest httpRequest){
        return wxInputInfoServer.processRequest(httpRequest);
    }
}
