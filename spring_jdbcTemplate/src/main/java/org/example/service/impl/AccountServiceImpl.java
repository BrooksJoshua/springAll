package org.example.service.impl;

import org.example.dao.AccountDao;
import org.example.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author Joshua.H.Brooks
 * @description
 * @date 2022-06-08 10:58
 */
@Service
public class AccountServiceImpl implements AccountService {
    @Autowired
    private AccountDao accountDao;

    @Override
    @Transactional(propagation = Propagation.REQUIRED, timeout = -1, isolation = Isolation.READ_COMMITTED ,rollbackFor = {NullPointerException.class,ArithmeticException.class}, noRollbackFor = {StackOverflowError.class})
    public int transfer(String from, String to, Integer val) {
        int rowsInfected = 0;
        //from先转出
        rowsInfected += accountDao.transfer(from, 0 - val);
        //to再转入
        rowsInfected+= accountDao.transfer(to,val);
        return rowsInfected;
    }
}
