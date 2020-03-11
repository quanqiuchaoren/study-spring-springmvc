package cn.lhy.springMVC.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 拦截器的使用
 */
@Controller
@RequestMapping("/interceptor")
public class InterceptorController {
    @RequestMapping("/usual1")
    public String usual1(){
        return "interceptor/usual1";
    }

    @RequestMapping("/usual2")
    public String usual2(){
        return "interceptor/usual2";
    }

    @RequestMapping("/toLogin")
    public String toLogin(){
        return "interceptor/login";
    }

}
