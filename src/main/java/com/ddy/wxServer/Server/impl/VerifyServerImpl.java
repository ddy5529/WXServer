package com.ddy.wxServer.Server.impl;

import com.ddy.wxServer.Server.VerifyServer;
import com.ddy.wxServer.Utils.WeiXinInterface.WeiXInLoginVerify;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class VerifyServerImpl implements VerifyServer {

    static private Logger logger= LoggerFactory.getLogger(VerifyServerImpl.class);

    @Override
    public String LoginVerify(String signature, String timestamp, String nonce, String echostr) {
        String info= WeiXInLoginVerify.LoginVerify(signature,  timestamp,  nonce,  echostr)?echostr:"error!";
        logger.info("------校验的后的数据是："+info);
        return info;
    }
}
