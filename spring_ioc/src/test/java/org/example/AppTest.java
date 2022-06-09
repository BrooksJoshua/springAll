package org.example;

import static org.junit.Assert.assertTrue;

import org.example.bean.Cat;
import org.example.bean.Dog;
import org.example.bean.Mouse;
import org.example.bean.User;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Unit test for simple App.
 */
public class AppTest {
    /**
     * 测试getBean是通过无参构造初始化
     */
    @Test
    public void shouldAnswerWithTrue() {
        ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
        User user1 = ctx.getBean("user1", User.class);
        System.out.println(user1);

    }

    /**
     * 测试懒加载
     */
    @Test
    public void test2() {
        ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
    }

    /**
     * 测试scope
     */
    @Test
    public void test_scope() {
        ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
        User user1 = ctx.getBean("user1", User.class);
        User user2 = ctx.getBean("user1", User.class);
        Dog dog1 = ctx.getBean("dog1", Dog.class);
        Dog dog2 = ctx.getBean("dog1", Dog.class);
        System.out.println(user1 == user2);
        System.out.println(dog1 == dog2);
    }

    @Test
    public void testSettingNoArgConstructor_1() {
        ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
        /**
         * 输出：
         * user 无参构造
         * user 无参构造
         * setting Userid
         * setting Username
         * setting password
         */
    }
    @Test
    public void testSettingNoArgConstructor_2() {
        ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
        User user1 = ctx.getBean("user1", User.class);
        System.out.println(user1);
        /**
         * user 无参构造
         * user 无参构造
         * setting Userid
         * setting Username
         * setting password
         * User{userid=null, username='null', password='null'}
         */
    }
    @Test
    public void testSettingNoArgConstructor_3() {
        ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
        User user2 = ctx.getBean("user2", User.class);
        System.out.println(user2);
        /**
         * user 无参构造
         * user 无参构造
         * setting Userid
         * setting Username
         * setting password
         * User{userid=1, username='alex', password='123'}
         */

    }
    @Test
    public void testSettingNoArgConstructor_4() {
        ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
        User user1 = ctx.getBean("user1", User.class);
        User user2 = ctx.getBean("user2", User.class);
        System.out.println(user1);
        System.out.println(user2);
        /**
         * user 无参构造
         * user 无参构造
         * setting Userid
         * setting Username
         * setting password
         * User{userid=null, username='null', password='null'}
         * User{userid=1, username='alex', password='123'}
         */
    }
    /**
     * testSettingNoArgConstructor_1 ～ testSettingNoArgConstructor_4
     * 通过四个test的输出对比可以发现
     * 1. spring property属性赋值底层是调用的setting方法
     * 2. bean默认初始化是调用了无参构造
     * 3. 如果注释掉User类的无参构造，编译就会报： No matching constructor found in class 'User
     * 4. 如果注释掉某个属性（比如name的）的setting方法， 则会报错如下：
     *      org.springframework.beans.factory.BeanCreationException: Error creating bean with name 'user2' defined in class path resource [applicationContext.xml]: Error setting property values; nested exception is org.springframework.beans.NotWritablePropertyException: Invalid property 'username' of bean class [org.example.bean.User]: Bean property 'username' is not writable or has an invalid setter method. Does the parameter type of the setter match the return type of the getter?
     */


    /**
     * 构造赋值。
     * 注意 ⚠️：
     *  如果<bean>标签里的构造参数的个数和pojo里定义的构造函数的参数列表个数不一致会报编译错： No matching constructor found in class 'Dog'
     *  constructor-arg 标签的 index 属性 和 name属性只用一个就可以。同时存在如果是一致的也可以，但是没必要。
     *  如果不一致可能会报错：Ambiguous argument values for parameter of type [java.lang.String] - did you specify the correct bean references as arguments?
     */
    @Test
    public void testConstructor_1() {
        ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext2.xml");
        User user2 = ctx.getBean("user2", User.class); //User{userid=2, username='brux', password='123'}
        User user3 = ctx.getBean("user3", User.class); //User{userid=3, username='Cc', password='123'}
        User user4 = ctx.getBean("user4", User.class); //User{userid=4, username='Dickie', password='123'}
        User user5 = ctx.getBean("user5", User.class);

        System.out.println(user2);
        System.out.println(user3);
        System.out.println(user4);
        System.out.println(user5); //报错 Unsatisfied dependency expressed through constructor parameter 0: Ambiguous argument values for parameter of type [java.lang.Integer]
    }


    /**
     * p命名空间和c命名空间赋值
     */
    @Test
    public void test_pTag_cTag() {
        ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext3.xml");
        User user1 = ctx.getBean("user1", User.class);
        User user2 = ctx.getBean("user2", User.class);
        System.out.println(user1);
        System.out.println(user2);
    }

    /**
     * 特殊符号的转义符写法和CDATA写法
     */
    @Test
    public void test_specialSymbols() {
        ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext4.xml");
        User user1 = ctx.getBean("user1", User.class);
        System.out.println(user1); //User{userid=null, username='&haha', password='!@#$%^'}
    }

    /**
     * 测试日期赋值的写法
     */
    @Test
    public void test_Date() {
        ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext5.xml");
        Mouse mouse1 = ctx.getBean("mouse1", Mouse.class);
        System.out.println(mouse1);//Mouse{name='Jerry', birthdate=Sun Nov 01 22:11:11 CST 2020}
    }

    /**
     * 测试内外部引用写法， 最常见的还是外部引用的写法， 各自定义好自己的属性， 然后一个ref进行引用。
     * 如果第三种方式引用， 因为其底层是通过getter方法获取被引用对象实体的属性值的，所以属性的getter方法必须存在， 否则报错。
     */
    @Test
    public void test_internal_external_reference() {
        ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext6.xml");
        Cat cat1 = ctx.getBean("cat1", Cat.class);
        Cat cat2 = ctx.getBean("cat2", Cat.class);
        Cat cat3 = ctx.getBean("cat3", Cat.class);
        System.out.println(cat1);//Cat{name='Tom', mouse=Mouse{name='Jerry', birthdate=Sun Nov 01 22:11:11 CST 2020}}
        System.out.println(cat2);//Cat{name='Tom', mouse=Mouse{name='Jerry2', birthdate=Sun Nov 01 22:11:11 CST 2020}}
        System.out.println(cat3);//Cat{name='Tom3', mouse=Mouse{name='Jerry3', birthdate=Sun Nov 01 22:11:11 CST 2020}}
    }






}
