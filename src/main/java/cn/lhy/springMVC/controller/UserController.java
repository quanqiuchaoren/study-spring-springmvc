package cn.lhy.springMVC.controller;

import cn.lhy.springMVC.entity.Business;
import cn.lhy.springMVC.entity.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

/**
 * 这个类里面的方法：实现了REST风格的四种方法来进行增删改查，且操作了数据库
 */
@Controller
@RequestMapping("/user")
public class UserController extends BaseController{
    /**
     * 如果spring容器和springMVC容器都把注视了@Controller的类纳入管理，那UserController就会被初始化两次，增加容器压力，浪费容器资源
     */
    public UserController(){
        System.out.println("UserController.constructor()");
    }
    @RequestMapping("/usual1")
    public String usual1(){
        System.out.println("usual1被访问了。。。。。。。。。。。");
        return "user/index";
    }

    /**
     *  test git
     *  test git commit part
     * @return
     */
    @RequestMapping("showPrepare")
    public String showPrepare(){
        return "user/prepareView";
    }

    /**
     * REST风格：获取所有用户
     */
    @RequestMapping(value = "/users", method = RequestMethod.GET)
    public String getAll(Model model){
        List<User> users = userService.getAll();
        model.addAttribute("users", users);
         return "user/userView";
    }

    /**
     * REST风格：获取单个用户信息
     */
    @RequestMapping(value = "/user/{id}", method = RequestMethod.GET)
    public String getOne(@PathVariable("id") Integer id, Model model){
        User user = userService.get(id);
        List<Business> businesses = businessService.getAll();
        model.addAttribute("user", user);
        model.addAttribute("businesses", businesses);
        return "user/updateView";
    }

    /*user的初始化在BaseController里面*/
    /**
     * REST风格：修改用户信息
     */
    @RequestMapping(value = "/user", method = RequestMethod.PUT)
    public String updateUser(User newUser){
        System.out.println("使用@ModelAttribute注解init之后的user = " + newUser);
        userService.update(newUser);
        return "redirect:/user/users";
    }

    /**
     * REST风格：删除用户
     */
    @RequestMapping(value = "/user/{id}", method = RequestMethod.DELETE)
    public String deleteUser(@PathVariable("id")Integer id){
        if (id != null){
            userService.delete(id);
        }
        return "redirect:/user/users";
    }

    /**
     * REST风格：准备添加用户信息
     */
    @RequestMapping(value = "/user", method = RequestMethod.GET)
    public String showAddUser(Model model){
        // spring的form标签，需要绑定一个对象，哪怕是空对象也可以
        model.addAttribute("user", new User());
        List<Business> businesses = businessService.getAll();
        model.addAttribute("businesses", businesses);
        return "user/prepareAdd";
    }

    /**
     * REST风格：添加新用户
     * 进行JSR-303数据校验：@Valid User user这个参数，要和BindingResult挨在一起，否则就不能进入方法了
     */
    @RequestMapping(value = "/user", method = RequestMethod.POST)
    public String addUser(@Valid User user, BindingResult bindingResult ,Model model){ //JSR-303数据校验
        if (bindingResult.getErrorCount() > 0){ // 如果：有属性值没有通过jsr-303校验：，则进行处理
            List<FieldError> fieldErrors = bindingResult.getFieldErrors();
            for(FieldError fieldError : fieldErrors){
                System.out.println("JSR303校验结果==》" + fieldError.getField() + ":" + fieldError.getDefaultMessage());
            }
            List<Business> businesses = businessService.getAll();
            model.addAttribute("businesses", businesses);
            // 如果要错误信息回显，这里就不要绑定user了，因为显示添加用户的额的页面已经绑定过一次user了
//            model.addAttribute("user", new User());
            return "user/prepareAdd";
        }
        userService.add(user);
        return "redirect:/user/users";
    }

}
