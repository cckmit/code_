package com.mika.credit.web.gugu.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;



/**
 * Created by Mike on 2017/4/16.
 */
@Controller
public class PageForwardController {


    /**
     * 跳转首页
     * @return
     */
    @RequestMapping(value = "/index")
    public String toIndex() {
        return "index";
    }

}
