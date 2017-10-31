package com.ddy.wxServer.Server;



public interface VerifyServer {
    String LoginVerify(String signature, String timestamp, String nonce,String  echostr);
}
