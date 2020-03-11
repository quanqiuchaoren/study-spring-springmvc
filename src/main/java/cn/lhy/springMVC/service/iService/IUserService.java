package cn.lhy.springMVC.service.iService;

import cn.lhy.springMVC.entity.User;

import java.util.List;

/**
 * Created by Enzo Cotter on 2018/12/27.
 */
public interface IUserService extends IBaseService<User> {
    List<User> getAll();

}
