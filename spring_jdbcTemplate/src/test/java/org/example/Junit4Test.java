package org.example;

import org.example.dao.AccountDao;
import org.example.pojo.Account;
import org.example.service.AccountService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

/**
 * @author Joshua.H.Brooks
 * @description 需要JUnit4和spring-test5的依赖
 * @date 2022-06-08 12:01
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:applicationContext.xml"})
public class Junit4Test {
    @Autowired
    private AccountDao accountDao;

    @Autowired
    private AccountService accountService;

    @Test
    public void test3(){
        System.out.println("Junit4...");
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
