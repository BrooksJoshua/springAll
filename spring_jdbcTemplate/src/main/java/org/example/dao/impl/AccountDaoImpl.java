package org.example.dao.impl;

import org.example.dao.AccountDao;
import org.example.pojo.Account;
import org.example.pojo.Episode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.LinkedList;
import java.util.List;

/**
 * @author Joshua.H.Brooks
 * @description
 * @date 2022-06-08 10:54
 */
@Repository
public class AccountDaoImpl implements AccountDao {

    @Autowired
    private JdbcTemplate jdbcTemplate;


    @Override
    public int transfer(String fromOrTo, Integer inOrOutVal) {
        //默认准入，转出时 inOrOutVal 应为负数
        String sql = "update account set money = (money+?) where id = ?;";
        int i = jdbcTemplate.update(sql,inOrOutVal,fromOrTo);
        return i;
    }

    @Override
    public List<Account> findStakeHolders(String from, String to) {
        String sql = "select * from `account` where id in (?,?);";
        BeanPropertyRowMapper<Account> rowMapper = new BeanPropertyRowMapper<Account>(Account.class);
        return jdbcTemplate.query(sql,rowMapper,from,to);
    }
}
