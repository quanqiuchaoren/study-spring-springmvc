package cn.lhy.springMVC.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Date;

/**
 * 消息转换器：@RequestBody和@ResponseBody的使用
 */
@Controller
@RequestMapping("/messageConverter")
public class MessageConverterController {

    @RequestMapping("/getForm")
    public String getForm(){
        return "httpMessage/formToUpload";
    }

    @ResponseBody
    @RequestMapping("/upload")
    public String upload(@RequestBody String uploadInfo){
        System.out.println("uploadInfo = " + uploadInfo);
        return "上传日期 = " + new Date();
    }
}
