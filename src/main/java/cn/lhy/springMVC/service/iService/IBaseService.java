package cn.lhy.springMVC.service.iService;

import java.util.List;

/**
 * Created by Enzo Cotter on 2018/12/27.
 */
public interface IBaseService<T> {
    public void add(T t);

    public void delete(int id);

    public void update(T t);

    public T get(int id);

    public List<T> getList(String hql, Object... args);
}
