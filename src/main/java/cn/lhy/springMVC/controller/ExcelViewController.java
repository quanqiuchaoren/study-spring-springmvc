package cn.lhy.springMVC.controller;

import cn.lhy.springMVC.entity.User;
import cn.lhy.springMVC.view.ExcelView;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 测试自定义视图的功能
 */
@Controller
@RequestMapping(value = {"/excelView"})
public class ExcelViewController {
    @RequestMapping(path = {"/download1"})
    public ModelAndView download1(){
        Map<String, Object> map = new HashMap<>();
        List<User> userList = new ArrayList<>();
        User user1 = new User(1, "quanqiu1", 18);
        User user2 = new User(2, "quanqiu2", 19);
        User user3 = new User(3, "quanqiu3", 20);
        userList.add(user1);
        userList.add(user2);
        userList.add(user3);
        map.put("userList", userList);
        ModelAndView modelAndView = new ModelAndView(new ExcelView(), map);
        return modelAndView;
    }

    @RequestMapping(path = {"/download2"})
    public String download2(Model model){
        Map<String, Object> map = new HashMap<>();
        List<User> userList = new ArrayList<>();
        User user1 = new User(1, "quanqiu1", 18);
        User user2 = new User(2, "quanqiu2", 19);
        User user3 = new User(3, "quanqiu3", 20);
        userList.add(user1);
        userList.add(user2);
        userList.add(user3);
        model.addAttribute("userList", userList);
        return "excelView";
    }
}
