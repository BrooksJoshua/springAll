package org.example;

import org.example.dao.AccountDao;
import org.example.dao.impl.AccountDaoImpl;
import org.example.dao.impl.EmpDaoImpl;
import org.example.pojo.Account;
import org.example.pojo.Episode;
import org.example.service.impl.AccountServiceImpl;
import org.example.service.impl.EmpServiceImpl;
import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.*;

/**
 * Unit test for simple App.
 */
public class AppTest {
    @Test
    public void test1() {
        ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
        EmpServiceImpl empService = ctx.getBean("empServiceImpl", EmpServiceImpl.class);
        System.out.println("empService.findEmpCount() = " + empService.findEmpCount());

        EmpDaoImpl empDao = ctx.getBean("empDaoImpl", EmpDaoImpl.class);
        /*增*/
        Episode episode = new Episode("尚硅谷一套快速上手spring mvc", "P998", "1.1_尚硅谷_SpringMVC_课程介绍", "03:57", 3, "/video/BV1Ry4y1574R?p=1", new Date());
        int add = empDao.add(episode);
        System.out.println("插入完再查总条数: empService.findEmpCount() = " + empService.findEmpCount());

        //删

        //改


        //查一个
        System.out.println("empDapImpl.findByPageNum(\"尚硅谷一套快速上手spring mvc\",\"P1\") = " + empDao.findByPageNum("尚硅谷一套快速上手spring mvc", "P1"));

        //查多个
        List<Episode> episodes = empDao.findsByCourseName("尚硅谷一套快速上手spring mvc");
        //episodes.stream().forEach(System.out::println);
        episodes.stream().filter(e -> Integer.parseInt(e.getPageNum().substring(1)) % 9 == 0).forEach(System.out::println);


    }

    /**
     * 测试批量操作： 增删改
     */
    @Test
    public void test2() {
        ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");

        EmpDaoImpl empDao = ctx.getBean("empDaoImpl", EmpDaoImpl.class);
        /*批量 新增
        Episode episode1 = new Episode("尚硅谷一套快速上手spring mvc","P998","1.1_尚硅谷_SpringMVC_课程介绍","03:57",3,"/video/BV1Ry4y1574R?p=1",new Date());
        Episode episode2 = new Episode("尚硅谷一套快速上手spring mvc","P997","1.1_尚硅谷_SpringMVC_课程介绍","03:57",3,"/video/BV1Ry4y1574R?p=1",new Date());
        Episode episode3 = new Episode("尚硅谷一套快速上手spring mvc","P996","1.1_尚硅谷_SpringMVC_课程介绍","03:57",3,"/video/BV1Ry4y1574R?p=1",new Date());
        Episode episode4 = new Episode("尚硅谷一套快速上手spring mvc","P995","1.1_尚硅谷_SpringMVC_课程介绍","03:57",3,"/video/BV1Ry4y1574R?p=1",new Date());
        Episode episode5 = new Episode("尚硅谷一套快速上手spring mvc","P994","1.1_尚硅谷_SpringMVC_课程介绍","03:57",3,"/video/BV1Ry4y1574R?p=1",new Date());
        LinkedList<Episode> episodes = new LinkedList<>();
        episodes.add(episode1);
        episodes.add(episode2);
        episodes.add(episode3);
        episodes.add(episode4);
        episodes.add(episode5);
        int[] add = empDao.batchAdd(episodes);
        System.out.println("插入完再查总条数: empService.findEmpCount() = " + empDao.findEmpCount());
        //显示刚刚批量插入的
        episodes.stream().filter(e->Integer.parseInt(e.getPageNum().substring(1))>990).forEach(System.out::println);
        */

        /* 批量 删除
        LinkedList<String> pageNums = new LinkedList<>();
        pageNums.add("P998");
        pageNums.add("P997");
        pageNums.add("P996");
        pageNums.add("P995");
        pageNums.add("P994");
        empDao.batchDelete(pageNums);
        List<Episode> episodes = empDao.findsByCourseName("尚硅谷一套快速上手spring mvc");
        episodes.stream().sorted(Comparator.comparing(Episode::getPageNum).reversed()).limit(10).forEach(System.out::println);
        */

        /*批量 修改
        LinkedList<Episode> episodes = new LinkedList<>();
        for (int i = 990; i < 1000; i++) {
            episodes.add(new Episode("尚硅谷一套快速上手spring mvc", "P" + i, "1.1_尚硅谷_SpringMVC_课程介绍", "03:57", 3, "/video/BV1Ry4y1574R?p=1", new Date()));
        }
        int[] rowsupdated = empDao.batchUpdate(episodes);
        System.out.println(Arrays.toString(rowsupdated));
        episodes.stream().filter(e -> Integer.parseInt(e.getPageNum().substring(1)) > 990).forEach(System.out::println);
        */
    }

    /**
     * 测试事务环境准备
     */
    @Test
    public void test3(){
        ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
        AccountServiceImpl accountService = ctx.getBean("accountServiceImpl", AccountServiceImpl.class);
        AccountDaoImpl accountDao = ctx.getBean("accountDaoImpl", AccountDaoImpl.class);
        String from = "1", to = "2";
        List<Account> stakeHolders = null;
        System.out.println("转账前");
        stakeHolders = accountDao.findStakeHolders(from, to);
        stakeHolders.stream().forEach(System.out::println);
        int rows = accountService.transfer(from, to, 100);
        System.out.println("受影响行数 = " + rows);
        System.out.println("转账后");
        stakeHolders = accountDao.findStakeHolders(from, to);
        stakeHolders.stream().forEach(System.out::println);
        
    }


}
