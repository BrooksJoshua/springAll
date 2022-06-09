package org.example.dao;

import org.example.pojo.Episode;

import java.util.List;

/**
 * @author Joshua.H.Brooks
 * @description
 * @date 2022-06-07 21:27
 */
public interface EmpDao {
    /**
     * @return 员工人数
     */
    int findEmpCount();

    /**
     *
     * @param courseName
     * @param pageNum
     * @return 根据courseName和pageNum找到Episode
     */
    public Episode findByPageNum(String courseName,String pageNum);

    /**
     *
     * @param courseName
     * @return 根据courseName和pageNum找到Episode
     */
    public List<Episode> findsByCourseName(String courseName);

    /**
     * 添加一行
     * @param episode
     * @return 受影响的行数
     */
    public int add(Episode episode);






    /**
     * 批量添加多行
     * @param episodes
     * @return 受影响的行数
     */
    public int[] batchAdd(List<Episode> episodes);

    /**
     * 批量修改多行
     * @param episodes
     * @return 受影响的行数
     */
    public int[] batchUpdate(List<Episode> episodes);
    /**
     * 批量删除多行
     * @param episodes
     * @return 受影响的行数
     */
    public int[] batchDelete(List<String> episodes);
}
