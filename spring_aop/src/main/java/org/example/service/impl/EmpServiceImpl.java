package org.example.service.impl;

import org.example.dao.EmpDao;
import org.example.service.EmpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author Joshua.H.Brooks
 * @description
 * @date 2022-06-07 17:54
 */
@Service
public class EmpServiceImpl implements EmpService {
    @Autowired
    private EmpDao empDao;
    @Override
    public int addEmp(String id, String name, String job) {
        empDao.addEmp(id,name,job);
        System.out.println("emp service impl add ~~");
        return 4;
    }
}
