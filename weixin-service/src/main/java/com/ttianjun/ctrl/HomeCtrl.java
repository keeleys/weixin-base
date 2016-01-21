package com.ttianjun.ctrl;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @user keeley
 * @date 16/1/20
 */
@Controller
public class HomeCtrl {
    @RequestMapping("/index")
    public String index(){
        System.out.println("test");
        return "index";
    }
}
