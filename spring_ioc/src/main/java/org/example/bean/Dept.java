package org.example.bean;

/**
 * @author Joshua.H.Brooks
 * @description
 * @date 2022-06-06 21:36
 */
public class Dept {
    private String dName;
    private String dLeader;

    public String getdName() {
        return dName;
    }

    public void setdName(String dName) {
        this.dName = dName;
    }

    public String getdLeader() {
        return dLeader;
    }

    public void setdLeader(String dLeader) {
        this.dLeader = dLeader;
    }

    public Dept() {
        System.out.println("dept 无参构造");
    }
    public Dept(String dName, String dLeader) {
        System.out.println("dept allArgsConstructor");
        this.dName = dName;
        this.dLeader = dLeader;
    }

    @Override
    public String toString() {
        return "Dept{" +
                "dName='" + dName + '\'' +
                ", dLeader='" + dLeader + '\'' +
                '}';
    }
}
