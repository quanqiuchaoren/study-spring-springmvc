package cn.lhy.springMVC.entity;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Id;
import java.util.Date;

/**
 * Created by Enzo Cotter on 2018/12/30.
 */
public class User2 {
    private Integer id;
    private String username;
    private Integer age;
    /**
     *如果要在这里配置数据的格式转换，就要在SpringMVC.xml的配置文件里面做如下配置：
     * mvc:annotation-driven的属性converssion-service不能填写ConversionServiceFactoryBean，
     *      而是要填写FormattingConversionServiceFactoryBean
     */
//    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date birthday;
    private Double height;
    private String password;
    private Integer business;
}
