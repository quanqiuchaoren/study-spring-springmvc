package cn.lhy.springMVC.controller;

import cn.lhy.springMVC.customEditor.MyDoubleEditor;
import cn.lhy.springMVC.entity.Business;
import cn.lhy.springMVC.entity.User;
import cn.lhy.springMVC.service.iService.IBusinessService;
import cn.lhy.springMVC.service.iService.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestParam;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by Enzo Cotter on 2018/12/30.
 */
public abstract class BaseController {
    @Autowired
    protected IUserService userService;
    @Autowired
    IBusinessService businessService;

    /**
     * 使用@InitBinder来绑定表单数据
     */
    @InitBinder
    public void initBinder(WebDataBinder webDataBinder){
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        // 设置是否宽松解析字符串
        simpleDateFormat.setLenient(false);
        // 新建定制的日期编辑器，并传入格式化的格式对象
        // 第二个参数是设置：是否允许提交的属性值为空，设置之后，表单中不填写生日的属性，也可以提交表单
        CustomDateEditor customDateEditor = new CustomDateEditor(simpleDateFormat, true);
        // 把新建的日期定制的日期编辑器，注册到网络数据绑定器里面
        webDataBinder.registerCustomEditor(Date.class, customDateEditor);
        // allowEmpty设置为false之后，如果表单中提交的属性为空，则会发生400错误，如果不设置下面一行代码，默认是true
//        CustomNumberEditor customNumberEditor = new CustomNumberEditor(Double.class, false);
//        webDataBinder.registerCustomEditor(Double.class, customNumberEditor);
        // 新建自定义的Double编辑器
        MyDoubleEditor myDoubleEditor = new MyDoubleEditor();
        webDataBinder.registerCustomEditor(Double.class, myDoubleEditor);
    }

    @ModelAttribute
    public void initUser(@RequestParam(name = "id", required = false) Integer id
            , @RequestParam(name = "business.id", required = false) Integer businessId
            , Model model){
        if (id != null && businessId != null) {
            Business business = businessService.get(businessId);
            User user = userService.get(id);
            user.setBusiness(business);
            model.addAttribute("user", user);
        }
    }
}
