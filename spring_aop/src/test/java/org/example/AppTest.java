package org.example;

import static org.junit.Assert.assertTrue;

import org.example.config.SpringConfig;
import org.example.dao.UserDao;
import org.example.service.UserService;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Unit test for simple App.
 */
public class AppTest 
{
    @Test
    public void test1()
    {
        ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
        UserDao userDao = ctx.getBean(UserDao.class);
        userDao.addUser("1","张三");
    }

    @Test
    public void test2()
    {
        AnnotationConfigApplicationContext actx = new AnnotationConfigApplicationContext(SpringConfig.class);
        UserDao userDao = actx.getBean(UserDao.class);
        userDao.addUser("2","李四");
    }
}
