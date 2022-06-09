package org.example.service;

import org.example.pojo.Episode;

/**
 * @author Joshua.H.Brooks
 * @description
 * @date 2022-06-07 21:26
 */
public interface EmpService {
    int findEmpCount();
    public Episode findByPageNum(String courseName, String pageNum);
}
