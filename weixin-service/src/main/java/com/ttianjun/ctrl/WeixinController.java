package com.ttianjun.ctrl;

import com.github.sd4324530.fastweixin.handle.MessageHandle;
import com.github.sd4324530.fastweixin.message.BaseMsg;
import com.github.sd4324530.fastweixin.message.TextMsg;
import com.github.sd4324530.fastweixin.message.req.BaseReqMsg;
import com.github.sd4324530.fastweixin.servlet.WeixinControllerSupport;
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



}
