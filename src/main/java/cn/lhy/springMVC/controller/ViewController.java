package cn.lhy.springMVC.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by Enzo Cotter on 2018/12/24.
 */
@Controller
@RequestMapping(value = {"/viewController"})
public class ViewController {
    @RequestMapping("/usual3")
    public String usual1(HttpServletRequest request, HttpServletResponse response){
        return "view/view";
    }


}
