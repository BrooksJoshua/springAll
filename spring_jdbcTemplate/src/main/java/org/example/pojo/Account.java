package org.example.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * @author Joshua.H.Brooks
 * @description
 * @date 2022-06-08 10:51
 */
@Data
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class Account {
    /**
     * 唯一主键
     */
    private String id;
    /**
     * 姓名
     */
    private String name;
    /**
     * 财富值
     */
    private Integer money;
}
