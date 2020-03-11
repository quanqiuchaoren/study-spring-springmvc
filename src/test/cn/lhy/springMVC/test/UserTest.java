package cn.lhy.springMVC.test;

import cn.lhy.springMVC.entity.User;
import cn.lhy.springMVC.service.iService.IUserService;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by Enzo Cotter on 2018/12/30.
 */
public class UserTest {
    private ApplicationContext applicationContext = null;
    SessionFactory sessionFactory = null;
    Session session = null;
    Transaction transaction = null;
    @Before
    public void init() {
        applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");
//        sessionFactory = applicationContext.getBean(SessionFactory.class);
//        session = sessionFactory.openSession();
//        transaction = session.beginTransaction();
    }
//    @After
    public void destroy() {
        transaction.commit();
        session.close();
        sessionFactory.close();
    }

    @Test
    public void updateUserByUserService() {
        IUserService userService = applicationContext.getBean(IUserService.class);
        User user = userService.get(1);
        user.setUsername("quanqiu22222222222222222");
        userService.update(user);
    }
}
