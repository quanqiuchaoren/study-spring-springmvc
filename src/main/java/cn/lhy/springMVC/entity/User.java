package cn.lhy.springMVC.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.Entity;
import javax.validation.constraints.*;
import java.util.Date;

/**
 * Created by Enzo Cotter on 2018/12/30.
 */
/*json序列化忽略的属性值和类中的属性的名字一致*/
//@JsonIgnoreProperties(value = {"business"})
@Entity
public class User {
    private int id;
    // 元素不为null，且不为空
    @NotEmpty(message = "用户名不能为空")
    private String username;
    // 元素不为null，且不为空
    @NotEmpty(message = "密码不能为空")
    private String password;

    private Integer age;

    @DecimalMin(value = "0.5", message = "身高要大于等于0.5m") // 身高最矮为1.0m
    @DecimalMax(value = "2.5", message = "身高要低于2.5m") // 身高最高为2.5m
    private Double height;

    /*在服务器和前端之间传输数据的时候，进行格式化或者解析的日期的格式*/
//    @DateTimeFormat(pattern = "yyyy-MM-dd")
    // 验证时间：只能是过去的某个时间，不能使将来的
    @Past(message = "生日只能是一个过去时间，不能是未来时间")
    private Date birthday;

    //字符串符合邮箱的正则表达式
    @Email(message = "请输入正确的格式的邮箱")
    private String email;

    @NotNull //对象不为null
    private Business business;

    public User() {
    }

    public User(String username, Integer age) {
        this.username = username;
        this.age = age;
    }

    public User(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public User(int id, String username, Integer age) {
        this.id = id;
        this.username = username;
        this.age = age;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Double getHeight() {
        return height;
    }

    public void setHeight(Double height) {
        this.height = height;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Business getBusiness() {
        return business;
    }

    public void setBusiness(Business business) {
        this.business = business;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        User user = (User) o;

        if (id != user.id) return false;
        if (username != null ? !username.equals(user.username) : user.username != null) return false;
        if (password != null ? !password.equals(user.password) : user.password != null) return false;
        if (business != null ? !business.equals(user.business) : user.business != null) return false;

        return true;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", age=" + age +
                ", height=" + height +
                ", business=" + business +
                '}';
    }
}
