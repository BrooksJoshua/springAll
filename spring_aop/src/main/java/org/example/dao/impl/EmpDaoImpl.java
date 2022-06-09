package org.example.dao.impl;

import org.example.dao.EmpDao;
import org.springframework.stereotype.Repository;

/**
 * @author Joshua.H.Brooks
 * @description
 * @date 2022-06-07 17:52
 */
@Repository
public class EmpDaoImpl implements EmpDao {
    @Override
    public int addEmp(String id, String name, String job) {
        System.out.println("emp dao add ...");
        return 2;
    }
}
