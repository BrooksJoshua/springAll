package org.example.bean;

/**
 * @author Joshua.H.Brooks
 * @description
 * @date 2022-06-06 21:37
 */
public class Emp {
    private String name;
    private Dept dept;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Dept getDept() {
        return dept;
    }

    public void setDept(Dept dept) {
        this.dept = dept;
    }

    public Emp() {
        System.out.println("Emp 无参构造");
    }
    public Emp(String name, Dept dept) {
        System.out.println("Emp AllArgsConstructor");
        this.name = name;
        this.dept = dept;
    }

    @Override
    public String toString() {
        return "Emp{" +
                "name='" + name + '\'' +
                ", dept=" + dept +
                '}';
    }
}
