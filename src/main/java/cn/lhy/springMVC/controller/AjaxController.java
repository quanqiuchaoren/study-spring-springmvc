package cn.lhy.springMVC.controller;

import cn.lhy.springMVC.entity.User;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

/**
 * Ajax请求，返回json格式的数据
 */
@Controller
@RequestMapping("/ajax")
public class AjaxController extends BaseController{

    @RequestMapping("/toView")
    public String showView(){
        return "json/jsonView";
    }

    /**
     * 老方法传输json穿到页面上：不用
     */
    @RequestMapping("/getUsersJson1")
    public void getJson1(HttpServletResponse response, HttpServletRequest request) throws IOException {
        response.setContentType("application/json;charset=utf-8");
        response.setHeader("pragma", "no-cache");
        response.setHeader("cache-control", "no-cache");

        PrintWriter out = response.getWriter();
        // 获取users前需要设置级联的对象在Json序列化时被忽略，
        // 或者设置User的映射文件的business属性的懒加载为false
        List<User> users = userService.getAll();
        ObjectMapper objectMapper = new ObjectMapper();
        String usersJsonString = objectMapper.writeValueAsString(users);
        System.out.println(usersJsonString);
        out.write(usersJsonString);
    }

    /**
     * 新式方法传输json穿到页面上：以后都用这种
     */
    @ResponseBody
    @RequestMapping("/getUsersJson2")
    public List<User> getJson2(HttpServletResponse response, HttpServletRequest request) throws IOException {
        List<User> users = userService.getAll();
        return users;
    }

}
