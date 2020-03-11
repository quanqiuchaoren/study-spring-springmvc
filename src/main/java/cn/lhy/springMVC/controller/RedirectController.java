package cn.lhy.springMVC.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 在Controller类里面实现重定向
 */
@Controller
@RequestMapping("/redire")
public class RedirectController {

    @RequestMapping("/usual1")
    public String usual1(){
        return "redirectView/index1";
    }

    @RequestMapping("/usual2")
    public String usual2(){
        // 返回时，在返回的字符串的前缀上，加上redirect：+路径，就是实现重定向
        // 重定向的路径，要写除了项目部署路径以外的全部路径
        return "redirect:/redire/usual1";
    }
}
