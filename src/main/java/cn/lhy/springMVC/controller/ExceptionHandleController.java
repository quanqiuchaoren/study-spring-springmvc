package cn.lhy.springMVC.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * SpringMVC异常处理
 * 处理异常信息的类在ExceptionHandler包中，或者在SpringMVC.xml的配置文件里面
 */
@Controller
@RequestMapping("/exceptionHandle")
public class ExceptionHandleController {

    @RequestMapping("/getView")
    public String usual1(){
        return "exceptionHandle/exceptionView";
    }

    @RequestMapping("/result")
    public String getResult(Integer figure){
        int i = 10 / figure;
        System.out.println(i);
        return "exceptionHandle/exceptionView";
    }
}
