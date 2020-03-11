package cn.lhy.springMVC.controller;

import cn.lhy.springMVC.entity.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

import javax.servlet.http.HttpSession;

/**
 * @ModelAttribute注解的使用：
 * 在执行ModelAttributeController类中的其他请求之前，都会先执行标注了@ModelAttribute的方法
 * 如果有多个标注了@ModelAttribute的方法，则按照顺序，从上往下执行
 * 如果在@ModelAttribute标记的方法里面封装了数据，这个数据会被当做请求参数，传进前端请求的方法，前提是属性名相同
 * 如果请求方法接收的参数里面，前端已经传进来了，则会覆盖@ModelAttribute方法里封装进Model里的数据
 * 也就是根据id，从数据库里面查出来一个对象，从表单中传过来的数据，会把数据库中查出来的属性覆盖掉
 */
@SessionAttributes(value = {"user"})
@Controller
@RequestMapping("/modelAttribute")
public class ModelAttributeController {
    @ModelAttribute
    public void modelAttribute1(Integer id, Model model, HttpSession session){
        try {
            Object object = session.getAttribute("bbb");
            System.out.println("object = " + object);
        } catch (Exception e){
            e.printStackTrace();
        }
        System.out.println("modelAttribute1()执行了...............");
        if(id != null){
            // 模拟从数据库中取出一条记录
            // userService.findById(id);
            User user = new User("quanqiu2", 20);
            user.setId(2);
            System.out.println("modelAttribute1中的++++user = " + user);
            model.addAttribute("aaa", user);
        }
    }

    @ModelAttribute
    public void modelAttribute2(){
        System.out.println("modelAttribute2()执行了...............");
    }

    /**
     * @ModelAttribute如果注释在形参里面，就是给User指定被封装进Model里面的键值对的键
     * 属性binding的默认值为合并模式，如果设置为true，则为覆盖模式，Model里面封装的，覆盖从前端传过来的，甚至连id也会被覆盖
     * 如果加了@ModelAttribute注解，则没有获取到键值对的键名为user的User对象，则不会执行这个方法
     * 如果没加@ModelAttribute注解，则没有获取到键值对的键名为user的User对象，但是会执行这个方法
     */
    @RequestMapping("/usual1")
    public String usual1(@ModelAttribute(name = "user", binding = true) User user){
        System.out.println("usual1()执行了...............");
        System.out.println("usual1中的++++user = " + user);
        return "sessionAttrAndModelAttr/success";
    }

    @RequestMapping("/usual2")
    public String usual2(@ModelAttribute("aaa") User user, Model model){
        System.out.println("usual2()执行了...............");
        System.out.println("user = " + user);
        model.addAttribute("user", user);
        return "sessionAttrAndModelAttr/success";
    }

}
