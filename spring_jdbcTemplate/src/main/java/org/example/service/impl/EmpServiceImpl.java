package org.example.service.impl;

import org.example.dao.EmpDao;
import org.example.pojo.Episode;
import org.example.service.EmpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

/**
 * @author Joshua.H.Brooks
 * @description
 * @date 2022-06-07 21:27
 */
@Service
public class EmpServiceImpl implements EmpService {
    @Autowired
    private EmpDao empDao;


    @Override
    public int findEmpCount() {
        return empDao.findEmpCount();
    }

    @Override
    public Episode findByPageNum(String courseName, String pageNum) {
        return empDao.findByPageNum(courseName,pageNum);
    }

}
