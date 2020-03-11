package cn.lhy.springMVC.controller;

import cn.lhy.springMVC.entity.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 学习ModelAndViewController
 */
@RequestMapping("/modelAndView")
@Controller
public class ModelAndViewController {
    @RequestMapping("/basic")
    public ModelAndView modelAndView(){
        ModelAndView modelAndView = new ModelAndView();
        User user1 = new User("quanqiu2", 10);
        User user2 = new User("quanqiu3", 10);
        List<User> users = new ArrayList<>();
        users.add(user1);
        users.add(user2);
        // 封装要转发的数据，这些数据会被request.setAttribute()的方式注入请求域里面
        modelAndView.addObject("name", "quanqiu1");
        modelAndView.addObject("user1", user1);
        modelAndView.addObject("users", users);
        // 设置视图名
        modelAndView.setViewName("mav/modelAndView");
        return modelAndView;
    }

    @RequestMapping("/basic/map")
    public ModelAndView modelAndViewMap(){
        ModelAndView modelAndView = new ModelAndView();
        Map<String, String> userMap = new HashMap<>();
        // key：姓名   value：住址
        userMap.put("quanqiu1", "自贡");
        userMap.put("quanqiu2", "成都");

        modelAndView.addObject("userMap", userMap);
        // 设置视图名
        modelAndView.setViewName("mav/map");
        return modelAndView;
    }

    /**
     * 使用Map来进行数据的传递，java.util.map，Map要写在形参里面，这样，Map里面的数据就会被添加到请求域里面
     * @param map
     * @return
     */
    @RequestMapping("/map")
    public String map(Map<String, Object> map){
        User user1 = new User("quanqiu2", 10);
        User user2 = new User("quanqiu3", 10);
        List<User> users = new ArrayList<>();
        users.add(user1);
        users.add(user2);
        // 封装要转发的数据，这些数据会被request.setAttribute()的方式注入请求域里面
        map.put("name", "quanqiu1");
        map.put("user1", user1);
        map.put("users", users);
        return "mav/modelAndView";
    }

    @RequestMapping("/model")
    public String model(Model model){
        User user1 = new User("quanqiu2", 10);
        User user2 = new User("quanqiu3", 10);
        List<User> users = new ArrayList<>();
        users.add(user1);
        users.add(user2);
        // 封装要转发的数据，这些数据会被request.setAttribute()的方式注入请求域里面
        model.addAttribute("name", "quanqiu1");
        model.addAttribute("user1", user1);
        model.addAttribute("users", users);
        return "mav/modelAndView";
    }

    /**
     * ModelMap和Model的区别是：ModelMap是Model和Map的综合体，既可以使用addAttribute方法，也可以使用put方法
     */
    @RequestMapping("/modelMap")
    public String modelMap(ModelMap model){
        User user1 = new User("quanqiu2", 10);
        User user2 = new User("quanqiu3", 10);
        List<User> users = new ArrayList<>();
        users.add(user1);
        users.add(user2);
        // 封装要转发的数据，这些数据会被request.setAttribute()的方式注入请求域里面
        model.addAttribute("name", "quanqiu1");
        model.addAttribute("user1", user1);
        model.put("users", users);
        return "mav/modelAndView";
    }
}
