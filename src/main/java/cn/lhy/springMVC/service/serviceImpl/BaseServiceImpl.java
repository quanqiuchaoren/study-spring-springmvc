package cn.lhy.springMVC.service.serviceImpl;

import cn.lhy.springMVC.repository.iRepository.IBaseRepository;
import cn.lhy.springMVC.service.iService.IBaseService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * Created by Enzo Cotter on 2018/12/27.
 */
public class BaseServiceImpl<T> implements IBaseService<T> {
    @Autowired
    private IBaseRepository<T> baseRepository;

    @Override
    public void add(T t) {
        baseRepository.add(t);
    }

    @Override
    public void delete(int id) {
        baseRepository.delete(id);
    }

    @Override
    public void update(T t) {
        baseRepository.update(t);
    }

    @Override
    public T get(int id) {
        return baseRepository.get(id);
    }

    @Override
    public List<T> getList(String hql, Object... args) {
        return baseRepository.getList(hql, args);
    }
}
