package cn.lhy.springMVC.controller;

import cn.lhy.springMVC.entity.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * REST的四种请求
 */
@Controller
@RequestMapping("/RESTFUL")
public class RESTMethod {

    @RequestMapping("/showPrepare")
    public String prepare(){
        return "rest/prepare";
    }

    /**
     * 查询用户
     */
    @RequestMapping(value = "/get/{id}", method = {RequestMethod.GET})
    public String get(@PathVariable("id")Integer id,  Model model){
        User user = new User(id, "quanqiu1", 18);
        model.addAttribute("user", user);
        return "rest/success";
    }

    /**
     * 增加用户
     */
    @RequestMapping(value = "/post", method = {RequestMethod.POST})
    public String post(User user, Model model){
        model.addAttribute("post", "添加成功");
        return "rest/success";
    }

    /**
     * REST:更新用户
     * 需要表单提交POST请求，然后再web.xml文件里面配置HttpHiddenFilter，请求方法转换
     */
    @RequestMapping(value = "/put/{id}", method = {RequestMethod.PUT})
    public String put(@PathVariable("id")Integer id,  Model model){
        System.out.println("修改用户");
        User user = new User(id, "quanqiu1", 18);
        return "redirect:/RESTFUL/showPrepare";
    }

    /**
     * REST:删除用户
     * 需要表单提交POST请求，然后再web.xml文件里面配置HttpHiddenFilter，请求方法转换
     */
    @RequestMapping(value = "/delete/{id}", method = {RequestMethod.DELETE})
    public String delete(@PathVariable("id")Integer id,  Model model){
        System.out.println("删除用户");
        return "redirect:/RESTFUL/showPrepare";
    }
}
