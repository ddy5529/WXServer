package com.ddy.wxServer.Server.impl;

import com.ddy.wxServer.Server.WXInputInfoServer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.servlet.http.HttpServletRequest;

@Service
@Transactional
public class WXInputInfoServerImpl implements WXInputInfoServer {

    private static Logger log = LoggerFactory.getLogger(WXInputInfoServerImpl.class);

    @Override
    public String processRequest(HttpServletRequest request) {
        //在这里对request的数据进行处理
        String processInfo="success";
        log.info("------接受到数据，处理后结果为："+processInfo);
        return processInfo;
    }
}
