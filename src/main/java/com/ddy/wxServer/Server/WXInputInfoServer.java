package com.ddy.wxServer.Server;

import javax.servlet.http.HttpServletRequest;

public interface WXInputInfoServer {
    String processRequest(HttpServletRequest request);
}
