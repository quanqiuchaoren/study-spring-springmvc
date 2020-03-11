package cn.lhy.springMVC.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by Enzo Cotter on 2018/12/21.
 */
@Controller
public class RequetMappingController {

    @RequestMapping(value = {"", "/", "/index"})
    public String index(){
        System.out.println("index被访问了");
        return "index";
    }

    @RequestMapping(value = "/user/{id}")
    public String pathVariable(@PathVariable("id")Integer id){
        System.out.println("index被访问了");
        System.out.println("id = " + id);
        return "index";
    }

    /**
     * 如果浏览器端提交的数据类型不是"application/json"，浏览器就会报错，HTTP Status 415 – Unsupported Media Type
     * @return
     */
    @RequestMapping(value = "/consumes", consumes = "application/json")
    public String consumes(){
        System.out.println("sonsumes被访问了");
        return "index";
    }

    /**
     * 如果浏览器端提交的方法不是POST，浏览器就会报错：Method Not Allowed
     */
    @RequestMapping(value = "/method", method = RequestMethod.POST)
    public String method(){
        System.out.println("method被访问了");
        return "index";
    }

    /**
     * produces定义返回的数据类型，仅当请求头中包含有该数据类型时，才能返回
     */
    @RequestMapping(value = "/produces", produces = "application/json")
    public String produces(){
        System.out.println("produces被访问了");
        return "index";
    }

    /**
     * params属性里面：1请求必须包含参数username，age，且age!=10才处理请求，否则返回HTTP Status 400 – Bad Request
     * 只能用!=, 不能用>, <
     */
    @RequestMapping(value = "/params", params = {"username", "age!=10"})
    public String params(){
        System.out.println("params被访问了");
        return "index";
    }

    /**
     * headers规定了发送过来的请求头必须要包含哪些内容
     */
    @RequestMapping(value = "/headers", headers = {"Accept-Language=zh-CN,zh;q=0.9"})
    public String headers(){
        System.out.println("headers被访问了");
        return "index";
    }

    /**
     * headers规定了发送过来的请求头必须要包含哪些内容
     */
    @RequestMapping(value = "/name")
    public String name(){
        System.out.println("name被访问了");
        return "name";
    }

    /**
     * headers规定了发送过来的请求头必须要包含哪些内容
     */
    @RequestMapping(value = "/nameTest")
    public String nameTransfer(String username, String password){
        System.out.println("nameTest被访问了");
        return "index";
    }

    /**
     * 精确匹配
     */
    @RequestMapping(value = "/usual0/exact")
    public String usual0(){
        System.out.println("usual-exact被访问了");
        return "index";
    }

    /**
     * 通配符：?
     * ?可以匹配一个字符
     */
    @RequestMapping(value = "/usual1/?")
    public String usual1(){
        System.out.println("usual-?被访问了");
        return "index";
    }

    /**
     * 通配符：*
     * 匹配任意字符
     */
    @RequestMapping(value = "/usual2/*")
    public String usual2(){
        System.out.println("usual-*被访问了");
        return "index";
    }

    /**
     * 通配符：**
     * 匹配多级路径，可以是1级，2级，3级
     */
    @RequestMapping(value = "/usual3/**")
    public String usual3(){
        System.out.println("usual-**被访问了");
        return "index";
    }

    /**
     * 通配符：**
     * 匹配多级路径，可以是1级，2级，3级
     */
    @RequestMapping(value = "/usual3/*")
    public String usual31(){
        System.out.println("usual3-*被访问了");
        return "index";
    }

    /**
     * 通配符：**
     * 匹配多级路径，可以是1级，2级，3级
     */
    @RequestMapping(value = "/usual3/?")
    public String usual32(){
        System.out.println("usual3-?被访问了");
        return "index";
    }

    /**
     * 匹配优先级：精确匹配>*匹配>**匹配
     */
    @RequestMapping(value = "/usual3/exact")
    public String usual30(){
        System.out.println("usual3-exact被访问了");
        return "index";
    }

}
