package com.ddy.wxServer.Server.impl;

import com.ddy.wxServer.Server.WXInputInfoServer;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;



@Service
@Transactional
public class WXInputInfoServerImpl implements WXInputInfoServer {



//    @Override
    public String processRequest() {
        //在这里对request的数据进行处理
        String processInfo="success";
//        log.info("------接受到数据，处理后结果为："+processInfo);
        return processInfo;
    }
}
