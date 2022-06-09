package org.example;

import static org.junit.Assert.assertTrue;

import org.example.bean.User;
import org.example.config.SpringConfig;
import org.example.service.UserService;
import org.example.service.impl.UserServiceImpl;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Unit test for simple App.
 */
public class AppTest 
{

    @Test
    public void test_1()
    {
        ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
        User user = ctx.getBean("user", User.class);
        System.out.println("user = " + user);
        //UserService service = ctx.getBean("userServiceImpl", UserServiceImpl.class);
        //System.out.println("service = " + service);
    }


    @Test
    public void test_2()
    {
        ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
        //如果两个daoImpl类都加上@Repository注解， 则会报错 expected single matching bean but found 2: userDaoImplA,userDaoImplB,
        //在UserServiceImpl类原来@Autowired的地方再加一个注解指明注入bean的名称@Qualifier("userDaoImplA") 即可解决。
        //也可以直接使用@Resource()一个注解就能实现上面@Autowired和@Qualifier组合的功能
        UserServiceImpl userServiceImpl = ctx.getBean("userServiceImpl", UserServiceImpl.class);
        System.out.println("userServiceImpl = " + userServiceImpl);
        userServiceImpl.add();
    }
    @Test
    public void test_3()
    {
        AnnotationConfigApplicationContext actx = new AnnotationConfigApplicationContext(SpringConfig.class);
        UserServiceImpl userServiceImpl = actx.getBean("userServiceImpl", UserServiceImpl.class);
        System.out.println("userServiceImpl = " + userServiceImpl);
        userServiceImpl.add();
    }
}
