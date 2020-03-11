package cn.lhy.springMVC.repository.iRepository;

import cn.lhy.springMVC.entity.User;

import java.util.List;

/**
 * Created by Enzo Cotter on 2018/12/27.
 */
public interface IUserRepository extends IBaseRepository<User> {
    List<User> getAll();
}
