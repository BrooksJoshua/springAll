package org.example.dao.impl;

import org.example.dao.UserDao;
import org.springframework.stereotype.Repository;

/**
 * @author Joshua.H.Brooks
 * @description
 * @date 2022-06-06 23:05
 */
@Repository
public class UserDaoImplB implements UserDao {
    @Override
    public void add() {
        System.out.println("userDaoImplB add");
    }
}
