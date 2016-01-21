package com.ttianjun.handle;

import com.github.sd4324530.fastweixin.handle.MessageHandle;
import com.github.sd4324530.fastweixin.message.BaseMsg;
import com.github.sd4324530.fastweixin.message.TextMsg;
import com.github.sd4324530.fastweixin.message.req.TextReqMsg;

/**
 * @user keeley
 * @date 16/1/20
 */
public class TextMsgHandle implements MessageHandle<TextReqMsg> {
    public BaseMsg handle(TextReqMsg msg) {
        String content = msg.getContent();
        System.out.println("用户发送到服务器的内容"+content);
        return new TextMsg("服务器回复用户消息!"+content);
    }

    public boolean beforeHandle(TextReqMsg textReqMsg) {
        return true;
    }
}
