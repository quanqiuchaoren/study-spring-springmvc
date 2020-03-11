package cn.lhy.springMVC.repository.repositoryImpl;

import cn.lhy.springMVC.repository.iRepository.IBaseRepository;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.List;

/**
 * Created by Enzo Cotter on 2018/12/27.
 */
@Repository
public class BaseRepositoryImpl<T> implements IBaseRepository<T> {
    private Class<T> classOfT;

    @Autowired
    private SessionFactory sessionFactory;

    /**获取当前线程绑定的Session*/
    protected Session getSession(){
        return sessionFactory.getCurrentSession();
    }

    @Override
    public void add(T t) {
        getSession().save(t);
    }

    @Override
    public void delete(int id) {
        Session session = getSession();
        T t = session.load(getClassOfT(), id);
        getSession().delete(t);
    }

    @Override
    public void update(T t) {
        getSession().update(t);
    }

    @Override
    public T get(int id) {
        return getSession().load(getClassOfT(), id);
    }

    @Override
    public List<T> getList(String hql, Object ... args) {
        Query query = getSession().createQuery(hql);
        if(args!=null && args.length>0){
            for (int i=0; i<args.length; i++){
                query.setParameter(i, args[i]);
            }
        }
        return query.list();
    }

    private Class<T> getClassOfT(){
        if (classOfT == null){// 初始化clazz
            Type genericSuperclass = this.getClass().getGenericSuperclass();
            ParameterizedType parameterizedType = (ParameterizedType) genericSuperclass;
            Type[] actualTypeArguments = parameterizedType.getActualTypeArguments();
            classOfT = (Class<T>) actualTypeArguments[0];
        }
        return classOfT;
    }
}
