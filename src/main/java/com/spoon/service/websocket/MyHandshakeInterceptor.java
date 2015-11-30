/*
 * Copyright (c) 2015 by FuShaoxing. All right reserved.
 */

package com.spoon.service.websocket;

import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import com.spoon.dict.SessionProps;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.server.ServerHttpRequest;
import org.springframework.http.server.ServerHttpResponse;
import org.springframework.http.server.ServletServerHttpRequest;
import org.springframework.web.socket.WebSocketHandler;
import org.springframework.web.socket.server.HandshakeInterceptor;

/**
 * @Author FuShaoxing(xinyu2010@126.com)
 * @Data 2015/11/29
 */
public class MyHandshakeInterceptor implements HandshakeInterceptor {
    private Logger logger = LoggerFactory.getLogger(MyHandshakeInterceptor.class);

    public boolean beforeHandshake(ServerHttpRequest request, ServerHttpResponse response, WebSocketHandler wsHandler, Map<String, Object> attributes)
            throws Exception {
        if ((request instanceof ServletServerHttpRequest)) {
            ServletServerHttpRequest servletRequest = (ServletServerHttpRequest) request;
            HttpSession session = servletRequest.getServletRequest().getSession(false);
            if (session != null) {
                String userId = (String) session.getAttribute(SessionProps.LOGIN_USERID);
                attributes.put(SessionProps.LOGIN_USERID, userId);
            }
        }
        return true;
    }

    public void afterHandshake(ServerHttpRequest request, ServerHttpResponse response, WebSocketHandler wsHandler, Exception exception) {
        logger.info("Handshake is finished!");
    }
}
