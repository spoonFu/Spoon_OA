/*
 * Copyright (c) 2015 by FuShaoxing. All right reserved.
 */

package com.spoon.web.msg;

import com.spoon.condition.msg.ImCondition;
import com.spoon.entity.acl.User;
import com.spoon.entity.msg.Im;
import com.spoon.service.msg.IImManager;
import com.spoon.utils.JsonBinder;
import com.spoon.web.MyBaseController;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.io.UnsupportedEncodingException;
import java.util.List;

/**
 * 即时聊天请求处理
 *
 * @Author FuShaoxing(xinyu2010@126.com)
 * @Data 2015/11/28
 */
@Controller
public class ImController extends MyBaseController {
    @Resource
    private IImManager imManager;

    @RequestMapping("getImMsg.ajax")
    @ResponseBody
    public String getMsg(@RequestParam("userId") String userId) {
        String retStr = "";
        ImCondition cond = new ImCondition();
        cond.setToUser(getCurrentUser());
        cond.setFromUser(new User(userId));
        cond.setHaveread(Boolean.valueOf(false));

        JsonBinder binder = JsonBinder.buildNormalBinder();
        List<Im> msgs = this.imManager.findByCond(cond);
        this.imManager.readMsgByCond(cond);
        try {
            retStr = new String(binder.toJson(msgs).getBytes("UTF-8"), "ISO-8859-1");
        } catch (UnsupportedEncodingException e) {
            logger.error(e.getMessage());
        }
        return retStr;
    }
}
