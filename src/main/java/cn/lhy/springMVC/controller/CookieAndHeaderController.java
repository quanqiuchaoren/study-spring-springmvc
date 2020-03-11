package cn.lhy.springMVC.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by Enzo Cotter on 2018/12/23.
 */
@Controller
public class CookieAndHeaderController {
    /**
     * @param acceptEncoding 加上了@RequestHeader注解以后，就表明，Accept-Encoding这个请求头是必须要有的，否则就会出现400错误
     * @return
     */
    @RequestMapping("requestHeader")
    public String requestHeader(@RequestHeader("Accept-Encoding")String acceptEncoding){
        System.out.println("ACCEPT-ENCODING = " + acceptEncoding);
        return "success";
    }

    /**
     *
     * @param jSessionId 加上了@CookieValue，就表明，必须要有JSESSIONID这个cookie，请求才能成功，否则就会出现400错误
     * @return
     */
    @RequestMapping("cookieValue")
    public String cookieValue(@CookieValue("JSESSIONID")String jSessionId){
        System.out.println("jSessionId = " + jSessionId);
        return "success";
    }

}
