package cn.lhy.springMVC.controller;

import cn.lhy.springMVC.entity.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 转换器，在表单提交字符串的时候，把变量名为use字符串转换为User对象
 */
@Controller
@RequestMapping("/modifyConverterController")
public class ModifyConverterController {

    @RequestMapping("/showStringToUser")
    public String showStringToUser(){
        return "converter/stringToUserView";
    }

    @RequestMapping("/stringToUser")
    public String stringToUser(User userConverred){
        System.out.println("String转换成的User = " + userConverred);
        return "redirect:/modifyConverterController/success";
    }

    @RequestMapping("/success")
    public String success(){
        return "converter/success";
    }

}
