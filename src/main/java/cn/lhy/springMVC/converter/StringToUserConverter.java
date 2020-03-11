package cn.lhy.springMVC.converter;

import cn.lhy.springMVC.entity.User;
import org.springframework.core.convert.converter.Converter;

/**
 * 自定义转换器，把String转换成User
 * 还要在applicationContext.xml文件里面进行配置
 * 如果要转换成功，必须要把表单中的<input>的name属性设置成User类的第一个字母小写，也就是user
 *
 */
public class StringToUserConverter implements Converter<String, User> {
    @Override
    public User convert(String source) {
        User user = null;
        if (source != null){
            String[] properties = source.split(",");
            if (properties.length > 2){
                user = new User();
                user.setId(Integer.parseInt(properties[0]));
                user.setUsername(properties[1]);
                user.setAge(Integer.parseInt(properties[2]));
            }
        }
        return user;
    }
}
