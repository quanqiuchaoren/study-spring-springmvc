package cn.lhy.springMVC.controller;

import cn.lhy.springMVC.entity.User;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by Enzo Cotter on 2018/12/30.
 */
@Controller
@RequestMapping("/iniBinder")
public class InitBinderController extends BaseController {

    @RequestMapping("/prepare")
    public String toCustomDateEditor(User user){
        System.out.println("Date被解析之后的User = " + user);
        return "webDataBinder/prepareToEdit";
    }

    /*@InitBinder被放到了BaseController当中*/
    @RequestMapping("/customDateEditor")
    public String customDateEditor(User user){
        System.out.println("Date被解析之后的User = " + user);
        return "webDataBinder/success";
    }


}
