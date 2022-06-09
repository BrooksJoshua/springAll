package org.example.dao.impl;

import org.example.dao.EmpDao;
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
 * @date 2022-06-07 21:48
 */
@Repository
public class EmpDaoImpl implements EmpDao {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public int findEmpCount() {
        String sql = "select count(1) from courses;";
        return jdbcTemplate.queryForObject(sql, Integer.class); //empDao.findEmpCount();
    }

    /**
     * BeanPropertyRowMapper: 是 RowMapper的一个实现对象，用来指定结果集用什么实体类(范型指定)进行封装。
     *
     * @param courseName
     * @param pageNum
     * @return
     */
    @Override
    public Episode findByPageNum(String courseName, String pageNum) {
        String sql = "select * from courses where course_name=? and page_num =? ;";
        BeanPropertyRowMapper<Episode> rowMapper = new BeanPropertyRowMapper<Episode>(Episode.class);
        Episode episode = jdbcTemplate.queryForObject(sql, rowMapper, courseName, pageNum);
        return episode;
    }

    @Override
    public List<Episode> findsByCourseName(String courseName) {
        String sql = "select * from courses where course_name=?;";
        BeanPropertyRowMapper<Episode> rowMapper = new BeanPropertyRowMapper<Episode>(Episode.class);
        List<Episode> episodes = jdbcTemplate.query(sql, rowMapper, courseName);
        return episodes;
    }

    /**
     * @param episode
     * @return
     */
    @Override
    public int add(Episode episode) {
        String sql = "insert into courses (`course_name`,`page_num`,`title`,`duration`,`minutes`,`href`,`create_time`) values (?,?,?,?,?,?,?);";
//        jdbcTemplate.update(sql
//                ,episode.getCourseName()
//                ,episode.getPageNum()
//                ,episode.getTitle()
//                ,episode.getDuration()
//                ,episode.getMinutes()
//                ,episode.getHref()
//                ,episode.getCreateTime()
//        );
        Object[] args = {episode.getCourseName(), episode.getPageNum(), episode.getTitle(), episode.getDuration(), episode.getMinutes(), episode.getHref(), episode.getCreateTime()};
        int rowsInserted = jdbcTemplate.update(sql, args);
        System.out.printf("插入了:\t%d条", rowsInserted);
        return rowsInserted;
    }

    @Override
    public int[] batchAdd(List<Episode> episodes) {
        String sql = "insert into courses (`course_name`,`page_num`,`title`,`duration`,`minutes`,`href`,`create_time`) values (?,?,?,?,?,?,?);";
        LinkedList<Object[]> args = new LinkedList<>();
        for (Episode e : episodes) {
            Object[] arg = {e.getCourseName(), e.getPageNum(), e.getTitle(), e.getDuration(), e.getMinutes(), e.getHref(), e.getCreateTime()};
            args.add(arg);
        }
        int[] rowsInserted = jdbcTemplate.batchUpdate(sql, args);
        return rowsInserted;
    }

    @Override
    public int[] batchUpdate(List<Episode> episodes) {
        String sql = "update courses set   `course_name` = ?,`page_num`=?, `title`=?,`duration`=?,`minutes`=?,`href`=?,`create_time`=?  where `page_num`=?;";
        List<Object[]> args = new LinkedList<Object[]>();
        for (Episode e : episodes) {
            Object[] arg = {e.getCourseName(), e.getPageNum(), e.getTitle(), e.getDuration(), e.getMinutes(), e.getHref(), e.getCreateTime(), e.getPageNum()};
            args.add(arg);
        }
        return jdbcTemplate.batchUpdate(sql, args);
    }

    @Override
    public int[] batchDelete(List<String> pageNums) {
        String sql = "delete from courses where page_num = ?;";
        LinkedList<Object[]> args = new LinkedList<>();
        for (String pageNum : pageNums) {
            String[] arg = {pageNum};
            args.add(arg);
        }
        jdbcTemplate.batchUpdate(sql, args);
        return new int[0];
    }
}
