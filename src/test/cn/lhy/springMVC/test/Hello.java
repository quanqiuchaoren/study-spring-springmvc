package cn.lhy.springMVC.test;

import cn.lhy.springMVC.entity.Business;
import cn.lhy.springMVC.entity.User;
import cn.lhy.springMVC.service.iService.IBusinessService;
import cn.lhy.springMVC.service.iService.IUserService;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by Enzo Cotter on 2018/12/27.
 */
public class Hello {
    private ApplicationContext applicationContext = null;
    SessionFactory sessionFactory = null;
    Session session = null;
    Transaction transaction = null;
    @Before
    public void init() {
        applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");
        // Spring整合Hibernate之后，要从容器里面获取SessionFactory
        sessionFactory = applicationContext.getBean(SessionFactory.class);
        session = sessionFactory.openSession();
        transaction = session.beginTransaction();
    }
    @After
    public void destroy() {
        transaction.commit();
        session.close();
        sessionFactory.close();
    }


    @Test
    public void updateTable() {
        // 空方法update表结构
    }

    @Test
    public void sqlTypeTest() {
        User user = new User("quanqiu1", "123456");
        session.save(user);
    }

    @Test
    public void addBusiness() {
        Business business = new Business("HaiNing");
        IBusinessService businessService = applicationContext.getBean(IBusinessService.class);
        businessService.add(business);
    }

    @Test
    public void addUser() {
        Business business = session.load(Business.class, 1);
        User user = new User("quanqiu1", "123456");
        user.setHeight(1.85);
        user.setBusiness(business);
        IUserService userService = applicationContext.getBean(IUserService.class);
        session.save(user);
        userService.add(user);
    }

    @Test
    public void loadUser() {
        User user = session.load(User.class, 2);
        System.out.println("user = " + user);

    }

}
