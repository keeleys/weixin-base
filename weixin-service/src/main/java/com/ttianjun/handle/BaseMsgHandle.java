package com.ttianjun.handle;

import com.github.sd4324530.fastweixin.handle.MessageHandle;
import com.github.sd4324530.fastweixin.message.BaseMsg;
import com.github.sd4324530.fastweixin.message.TextMsg;
import com.github.sd4324530.fastweixin.message.req.BaseReqMsg;

/**
 * @user keeley
 * @date 16/1/20
 */
public class BaseMsgHandle implements MessageHandle<BaseReqMsg> {
    public BaseMsg handle(BaseReqMsg baseMsgHandle) {
        return new TextMsg("默认方法");
    }

    public boolean beforeHandle(BaseReqMsg baseMsgHandle) {
        return true;
    }
}
