package org.example;

import org.example.bean.*;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * 演示集合属性注入
 */
public class CollectionDITest {
    @Test
    public void test() {
        ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext7.xml");
        Student stu1 = ctx.getBean("stu1", Student.class);
        Student stu2 = ctx.getBean("stu2", Student.class);
        Student stu3 = ctx.getBean("stu3", Student.class);
        Student stu4 = ctx.getBean("stu4", Student.class);
        Student stu5 = ctx.getBean("stu5", Student.class);
        Student stu6 = ctx.getBean("stu6", Student.class);
        //Student stu5 = ctx.getBean("Stu5", Student.class);
        System.out.println("Array:\t"+stu1);
        System.out.println("List:\t"+stu2);
        System.out.println("Set:\t"+stu3);
        System.out.println("Map:\t"+stu4);
        System.out.println("List对象:\t"+stu5);
        System.out.println("公共集合:\t"+stu6);


    }


}
