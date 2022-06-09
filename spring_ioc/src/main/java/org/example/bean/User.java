package org.example.bean;

/**
 * @author Joshua.H.Brooks
 * @description
 * @date 2022-06-06 14:28
 */

public class User {
    private Integer userid;
    private String username;
    private String password;

    public Integer getUserid() {
        return userid;
    }

    public void setUserid(Integer userid) {
        System.out.println("setting Userid");
        this.userid = userid;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        System.out.println("setting Username");
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        System.out.println("setting password");
        this.password = password;
    }

    public User() {
        System.out.println("user 无参构造");
    }

    public User(Integer userid, String username, String password) {
        System.out.println("AllArgsConstructor");
        this.userid = userid;
        this.username = username;
        this.password = password;
    }

    @Override
    public String toString() {
        return "User{" +
                "userid=" + userid +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
