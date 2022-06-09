package org.example;

import org.example.dao.AccountDao;
import org.example.pojo.Account;
import org.example.service.AccountService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

import java.util.List;

/**
 * @author Joshua.H.Brooks
 * @description 需要JUnit5的依赖
 * @date 2022-06-08 12:01
 */
//@ExtendWith(SpringExtension.class) // 注意此行代替了4的 @RunWith(SpringJUnit4ClassRunner.class)
//@ContextConfiguration(locations = {"classpath:applicationContext.xml"})
@SpringJUnitConfig(locations = {"classpath:applicationContext.xml"}) //这一行代替了上面两行
public class Junit5Test {
    @Autowired
    private AccountDao accountDao;

    @Autowired
    private AccountService accountService;

    @Test //注意import的是junit5包下的
    public void test3(){
        System.out.println("Junit5...");
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
