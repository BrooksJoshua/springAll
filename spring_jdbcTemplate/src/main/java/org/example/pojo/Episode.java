package org.example.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.io.Serializable;
import java.util.Date;

/**
 * @author Joshua.H.Brooks
 * @description
 * @date 2022-06-07 21:24
 */
@Data
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class Episode implements Serializable {
    /**
     * 课程名， 会从文件名获取
     */
    private String courseName;
    /**
     * 本集序号
     */
    private String pageNum;
    /**
     * 本集民称
     */
    private String title;
    /**
     * 本集时长 mm:SS时间格式
     */
    private String duration;

    /**
     * 本集时长 minutes
     */
    private Integer minutes;
    /**
     * 本集url后半部分
     */
    private String href;
    /**
     * 时间
     */
    private Date createTime;
}
