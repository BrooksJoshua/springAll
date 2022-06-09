package org.example.service.impl;

import org.example.dao.UserDao;
import org.example.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @author Joshua.H.Brooks
 * @description
 * @date 2022-06-06 22:41
 */
@Service
public class UserServiceImpl implements UserService {

    //@Autowired
    //@Qualifier("userDaoImplA")
    @Resource(name = "userDaoImplB")
    UserDao userDao;

    @Value("${s.name}:刘德华")
    private String name;
    @Value("${s.age}:18")
    private String age;

    @Override
    public void add() {
        System.out.println(name+" "+age);
        userDao.add();
        System.out.println("userServiceImpl add");
    }
}
