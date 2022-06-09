package org.example.bean;

import java.util.Date;

/**
 * @author Joshua.H.Brooks
 * @description
 * @date 2022-06-06 18:09
 */
public class Mouse {
    private String name;
    private Date birthdate;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getBirthdate() {
        return birthdate;
    }

    public void setBirthdate(Date birthdate) {
        this.birthdate = birthdate;
    }

    public Mouse() {
        System.out.println("Mouse 无参构造");
    }

    public Mouse(String name, Date birthdate) {
        this.name = name;
        this.birthdate = birthdate;
    }

    @Override
    public String toString() {
        return "Mouse{" +
                "name='" + name + '\'' +
                ", birthdate=" + birthdate +
                '}';
    }
}
