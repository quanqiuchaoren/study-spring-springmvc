package cn.lhy.springMVC.controller;

import cn.lhy.springMVC.entity.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

/**
 * 学习@SessionAttributes注解，这个注解是实现的是监控功能，检测到Model.addAttribute(key, value)执行了，
 * 则执行：HttpSession.setAttribute(key, value)，添加到HttpSession域中的键值对，和Model.addAttribute(key, value)一样
 * :@SessionAttributes中的names的属性，监控的是键值对中的键，types监控的是键值对中的值的类型
 */
@Controller
@RequestMapping("/sessionAttribute")
//@SessionAttributes(names = {"id", "username", "user1"})
@SessionAttributes(types = {User.class, String.class})
//@SessionAttributes(names = {"id"}, types = {User.class, String.class})
public class SessionAttribtesController {

    @RequestMapping("/usual1")
    public String sessionAttribute(Model model){
        model.addAttribute("id", 1);
        model.addAttribute("username", "quanqiu");
        User user1 = new User("quanqiu2", 18);
        User user2 = new User("quanqiu3", 19);
        model.addAttribute("user1", user1);
        model.addAttribute("user2", user2);
        return "sessionAttrAndModelAttr/sessionAttribute";
    }

    @RequestMapping("/usual2")
    public String sessionAttribute2(){
        // 不往Model里面封装数据
        return "sessionAttrAndModelAttr/sessionAttribute";

    }

}
