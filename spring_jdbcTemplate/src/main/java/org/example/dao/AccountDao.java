package org.example.dao;

import org.example.pojo.Account;

import java.util.List;

/**
 * @author Joshua.H.Brooks
 * @description
 * @date 2022-06-08 10:53
 */
public interface AccountDao {
    /**
     * @param fromOrTo
     * @param inOrOutVal 转入/出 数额为 正/负
     * @return
     */
    int transfer(String fromOrTo, Integer inOrOutVal);
    List<Account> findStakeHolders(String from, String to);
}
