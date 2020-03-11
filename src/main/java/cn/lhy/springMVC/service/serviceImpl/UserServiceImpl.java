package cn.lhy.springMVC.service.serviceImpl;

import cn.lhy.springMVC.entity.User;
import cn.lhy.springMVC.repository.iRepository.IUserRepository;
import cn.lhy.springMVC.service.iService.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Enzo Cotter on 2018/12/27.
 */
@Service
public class UserServiceImpl extends BaseServiceImpl<User> implements IUserService {
    @Autowired
    private IUserRepository userRepository;

    @Override
    public List<User> getAll() {
        return userRepository.getAll();
    }
}
