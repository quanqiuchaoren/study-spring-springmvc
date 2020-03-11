package cn.lhy.springMVC.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 测试注册页面的国际化的实现
 */
@Controller
@RequestMapping("/messageSource")
public class MessageSourceController {
    @RequestMapping("/showReg")
    public String showReg(){
        return "internal/reg";
    }

}
