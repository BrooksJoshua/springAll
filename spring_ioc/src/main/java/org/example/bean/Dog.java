package org.example.bean;

/**
 * @author Joshua.H.Brooks
 * @description
 * @date 2022-06-06 14:39
 */
public class Dog {
    private String name;
    private String nickname;
    private Integer age;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        System.out.println("dog setting name");
        this.name = name;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        System.out.println("dog setting nickname");
        this.nickname = nickname;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        System.out.println("dog setting age");
        this.age = age;
    }

    public Dog() {
        System.out.println("dog 无参构造");
    }

    public Dog(String name, String nickname, Integer age) {
        this.name = name;
        this.nickname = nickname;
        this.age = age;
    }

    @Override
    public String toString() {
        return "Dog{" +
                "name='" + name + '\'' +
                ", nickname='" + nickname + '\'' +
                ", age=" + age +
                '}';
    }
}
