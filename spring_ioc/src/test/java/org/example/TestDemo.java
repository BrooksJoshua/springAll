package org.example;

import com.alibaba.druid.pool.DruidDataSource;
import org.example.bean.BeanLifeSpan;
import org.example.bean.Emp;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import javax.sql.DataSource;

/**
 * @author Joshua.H.Brooks
 * @description
 * @date 2022-06-06 20:5d
 */
public class TestDemo {
    /**
     *测试声明周期的7（5）个阶段
     */
    @Test
    public void test1(){
        ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext9.xml");
        BeanLifeSpan life = ctx.getBean("life", BeanLifeSpan.class);
        System.out.println("第4: 获取bean");
        System.out.println(life);
        ctx.close();
    }

    /**
     * 测试自动装配
     */
    @Test
    public void test2(){
        ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext10.xml");
        Emp emp = ctx.getBean("emp", Emp.class);
        Emp emp2 = ctx.getBean("emp2", Emp.class);
        Emp emp3 = ctx.getBean("emp3", Emp.class);
        System.out.println("emp = " + emp);
        System.out.println("emp2 = " + emp2);
        System.out.println("emp3 = " + emp3);
    }

    /**
     * 外部属性配置文件读取
     */
    @Test
    public void test3(){
        ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext11.xml");
        DataSource ds = ctx.getBean("dataSource", DruidDataSource.class);
        DataSource ds2 = ctx.getBean("dataSource2", DruidDataSource.class);
        System.out.println("ds = " + ds);
        System.out.println("ds2 = " + ds2);
    }


}
