package org.example.dao.impl;

import org.example.dao.UserDao;
import org.springframework.stereotype.Repository;

/**
 * @author Joshua.H.Brooks
 * @description
 * @date 2022-06-07 17:51
 */
@Repository
public class UserDaoImpl implements UserDao {
    @Override
    public int addUser(String id, String name) {
        System.out.println("user dao add ...");
        //int a = 1/0;
        return 1;
    }
}
