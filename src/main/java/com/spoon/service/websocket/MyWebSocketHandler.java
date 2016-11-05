/*
 * Copyright (c) 2015 by FuShaoxing. All right reserved.
 */

package com.spoon.service.websocket;

import com.spoon.condition.msg.ImCondition;
import com.spoon.dict.SessionProps;
import com.spoon.entity.acl.User;
import com.spoon.entity.msg.Im;
import com.spoon.service.msg.IImManager;
import com.spoon.utils.JsonBinder;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.socket.CloseStatus;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketHandler;
import org.springframework.web.socket.WebSocketMessage;
import org.springframework.web.socket.WebSocketSession;

/**
 * @Author FuShaoxing(xinyu2010@126.com)
 * @Data 2015/11/29
 */
public class MyWebSocketHandler implements WebSocketHandler {
    private Logger logger = LoggerFactory.getLogger(MyWebSocketHandler.class);
    private JsonBinder jsonBinder = JsonBinder.buildNormalBinder();
    private static final Map<String, WebSocketSession> sessionMap = new ConcurrentHashMap();
    @Autowired
    private IImManager imManager;

    public void afterConnectionEstablished(WebSocketSession session)
            throws Exception {
        logger.debug("connect to the websocket success......");
        String userId = (String) session.getAttributes().get(SessionProps.LOGIN_USERID);
        if (userId != null) {
            sessionMap.put(userId, session);
            ImCondition cond = new ImCondition();
            cond.setToUser(new User(userId));
            cond.setHaveread(false);

            List<Im> msgs = imManager.findByCond(cond);
            session.sendMessage(new TextMessage(jsonBinder.toJson(msgs)));
        }
    }

    public void handleMessage(WebSocketSession session, WebSocketMessage<?> message)
            throws Exception {
        String userId = (String) session.getAttributes().get(SessionProps.LOGIN_USERID);
        Im im = jsonBinder.fromJson(message.getPayload().toString(), Im.class);
        im.setFromUser(new User(userId));
        String toUserId = im.getToUser().getId();

        WebSocketSession ss = (WebSocketSession) sessionMap.get(toUserId);
        if ((ss != null) && (ss.isOpen())) {
            im.setHaveread(true);

            ss.sendMessage(getMessage(im));
        }
        imManager.save(im);
    }

    public void handleTransportError(WebSocketSession session, Throwable exception)
            throws Exception {
        if (session.isOpen()) {
            session.close();
        }
        String userId = (String) session.getAttributes().get(SessionProps.LOGIN_USERID);
        logger.debug("websocket connection closed......");
        sessionMap.remove(userId);
    }

    public void afterConnectionClosed(WebSocketSession session, CloseStatus closeStatus)
            throws Exception {
        logger.debug("websocket connection closed......");
        String userId = (String) session.getAttributes().get(SessionProps.LOGIN_USERID);
        sessionMap.remove(userId);
    }

    public boolean supportsPartialMessages() {
        return false;
    }

    private TextMessage getMessage(Im im) {
        List<Im> msgs = new ArrayList();
        msgs.add(im);
        return new TextMessage(this.jsonBinder.toJson(msgs));
    }
}