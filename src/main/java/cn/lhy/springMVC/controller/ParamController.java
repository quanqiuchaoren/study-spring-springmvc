package cn.lhy.springMVC.controller;

import cn.lhy.springMVC.entity.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.UnsupportedEncodingException;

/**
 * 获取页面向后台传输的数据
 */
@Controller
public class ParamController {

    /**
     * 使用HttpServletRequest的方式接收请求参数，可以接收GET和POST请求的参数
     * 但是获取POST请求的参数的时候，当表单提交数据的编码方式是(application/x- www-form-urlencoded)，才能获取到
     * 当POST请求的编码方式不是上面的方式的时候，就必须要用getInputStream（）或者getReader（）的方式才能拿读取到
     * multipart/form-data这种编码方式就不行，这是提交大批量数据的方法
     */
    @RequestMapping("httpServletRequest")
    public String httpServletRequest(HttpServletRequest request) throws UnsupportedEncodingException {
        request.setCharacterEncoding("utf-8");
        // 以下这种方式获取GET请求方式的参数可以
        String username = request.getParameter("username");
//        int age = Integer.parseInt(request.getParameter("age"));
        System.out.println("username = " + username);
//        System.out.println("age = " + age);
        return "success";

    }

    /**
     * 通过HttpServletResponse，可以直接向页面输出数据
     * 测试失败了，最终没有输出到页面上
     */
    @RequestMapping("httpServletResponse")
    public String httpServletResponse(HttpServletResponse response) throws IOException {
        // 结局输出乱码问题
        response.setContentType("html/text;charset=utf-8");
        response.getWriter().println("通过response向页面输出值");
        return "success";
    }

    /**
     * 使用形参的方式，可以接收GET的请求参数，POST的请求参数
     * 但是获取POST请求的参数的时候，当表单提交数据的编码方式是(application/x- www-form-urlencoded)，才能获取到
     * multipart/form-data这种编码方式就不行，这是提交大批量数据的方法
     */
    @RequestMapping("requestParam")
    public String requestParam(String username, Integer age){
        System.out.println("username = " + username);
        System.out.println("age = " + age);
        return "success";
    }

    /**
     * 使用pojo的方式，可以接收GET的请求参数，POST的请求参数
     * 但是获取POST请求的参数的时候，当表单提交数据的编码方式是(application/x- www-form-urlencoded)，才能获取到
     * multipart/form-data这种编码方式就不行，这是提交大批量数据的方法
     */
    @RequestMapping("pojo")
    public String pojo(User user){
        System.out.println("user = " + user);
        return "success";
    }


}
