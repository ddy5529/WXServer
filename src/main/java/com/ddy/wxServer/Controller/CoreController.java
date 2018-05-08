package com.ddy.wxServer.Controller;

import com.ddy.wxServer.Server.CoreService;
import com.ddy.wxServer.Utils.fastwebutils.SignUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;
import javax.servlet.http.HttpServletRequest;

/*
*
官方文档：
@RestController is a stereotype annotation that combines @ResponseBody and @Controller.
意思是：
@RestController注解相当于@ResponseBody ＋ @Controller合在一起的作用。

1)如果只是使用@RestController注解Controller，则Controller中的方法无法返回jsp页面，配置的视图解析器InternalResourceViewResolver不起作用，返回的内容就是Return 里的内容。
例如：本来应该到success.jsp页面的，则其显示success.

2)如果需要返回到指定页面，则需要用 @Controller配合视图解析器InternalResourceViewResolver才行。
3)如果需要返回JSON，XML或自定义mediaType内容到页面，则需要在对应的方法上加上@ResponseBody注解。
* */
/*http://localhost/swagger-ui.html*/
@Controller
public class CoreController {
    @Autowired
    private CoreService coreService;

    //增加日志
    private static Logger log = LoggerFactory.getLogger(CoreController.class);

    //验证是否来自微信服务器的消息,通过签名，临时签名，时间戳，响应文字
    @RequestMapping(value = "", method = RequestMethod.GET)
    public String checkSignature(@RequestParam(name = "signature", required = false) String signature,
                                 @RequestParam(name = "nonce", required = false) String nonce,
                                 @RequestParam(name = "timestamp", required = false) String timestamp,
                                 @RequestParam(name = "echostr", required = false) String echostr) {
        // 通过检验signature对请求进行校验，若校验成功则原样返回echostr，表示接入成功，否则接入失败
        if (StringUtils.isEmpty(signature) || StringUtils.isEmpty(timestamp) || StringUtils.isEmpty(nonce)) {
            log.info("参数空了，这是在访问域名首页吧。");
            //可以在这里写返回模板
//            Model mode;
//            Person person=new Person();
//            mode.addAllAttributes("person",person);
            return "mainpage";
        } else {
            if (SignUtil.checkSignature(signature, timestamp, nonce)) {
                log.info("接入成功");
                return echostr;
            }
        }
        log.error("接入失败");
        return echostr;
    }

    // 调用核心业务类接收消息、处理消息跟推送消息
    @RequestMapping(value = "", method = RequestMethod.POST)
    public String post(HttpServletRequest req) {
        String respMessage = coreService.processRequest(req);
        return respMessage;
    }



}
