package com.ttianjun.ctrl;

import com.github.sd4324530.fastweixin.handle.MessageHandle;
import com.github.sd4324530.fastweixin.message.BaseMsg;
import com.github.sd4324530.fastweixin.message.TextMsg;
import com.github.sd4324530.fastweixin.message.req.BaseReqMsg;
import com.github.sd4324530.fastweixin.servlet.WeixinControllerSupport;
import com.ttianjun.handle.BaseMsgHandle;
import com.ttianjun.handle.TextMsgHandle;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.List;

/**
 * @user keeley
 * @date 16/1/20
 */
@Controller
@RequestMapping("/weixin")
public class WeixinController extends WeixinControllerSupport {
    private static final String TOKEN = "myToken";
    public static final String APPID = "";
    public static final String AESKEY="";

    private static final Logger log = LoggerFactory.getLogger(WeixinController.class);
    @Override
    protected String getToken() {
        return TOKEN;
    }

    //使用安全模式时设置：APPID
    //不再强制重写，有加密需要时自行重写该方法
    @Override
    protected String getAppId() {
        return APPID;
    }
    //使用安全模式时设置：密钥
    //不再强制重写，有加密需要时自行重写该方法
    @Override
    protected String getAESKey() {
        return AESKEY;
    }


    /*1.1版本新增，重写父类方法，加入自定义微信消息处理器
     *不是必须的，上面的方法是统一处理所有的文本消息，如果业务觉复杂，上面的会显得比较乱
     *这个机制就是为了应对这种情况，每个MessageHandle就是一个业务，只处理指定的那部分消息
     */
    @Override
    protected List<MessageHandle> initMessageHandles() {
        List<MessageHandle> handles = new ArrayList<MessageHandle>();
        handles.add(new TextMsgHandle());
        handles.add(new BaseMsgHandle());
        return handles;
    }
}
