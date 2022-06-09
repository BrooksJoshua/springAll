package org.example.bean;

/**
 * @author Joshua.H.Brooks
 * @description
 * @date 2022-06-06 18:24
 */
public class Cat {
    private String name;
    private Mouse mouse;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Mouse getMouse() {
        return mouse;
    }

    public void setMouse(Mouse mouse) {
        this.mouse = mouse;
    }

    public Cat() {
        System.out.println("无参构造");
    }

    public Cat(String name, Mouse mouse) {
        System.out.println("allArgsConstructor");
        this.name = name;
        this.mouse = mouse;
    }

    @Override
    public String toString() {
        return "Cat{" +
                "name='" + name + '\'' +
                ", mouse=" + mouse +
                '}';
    }
}
