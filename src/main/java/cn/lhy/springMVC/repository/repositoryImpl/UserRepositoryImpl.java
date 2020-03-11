package cn.lhy.springMVC.repository.repositoryImpl;

import cn.lhy.springMVC.entity.User;
import cn.lhy.springMVC.repository.iRepository.IUserRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by Enzo Cotter on 2018/12/27.
 */
@Repository
public class UserRepositoryImpl extends BaseRepositoryImpl<User> implements IUserRepository {

    @Override
    public List<User> getAll() {
        String hql = "from User";
        return super.getList(hql);
    }
}
