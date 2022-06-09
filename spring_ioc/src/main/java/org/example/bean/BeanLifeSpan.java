package org.example.bean;

/**
 * @author Joshua.H.Brooks
 * @description
 * @date 2022-06-06 20:53
 */
public class BeanLifeSpan {
    private Integer lifeId;
    private String lifeName;

    public BeanLifeSpan() {
        System.out.println("第1: 无参构建");
    }

    public void setLifeName(String lifeName) {
        System.out.println("第2: setting赋值");
        this.lifeName = lifeName;
    }

    public void init(){
        System.out.println("第3: 自定义的初始化方法");
    }

    public BeanLifeSpan(Integer lifeId, String lifeName) {
        this.lifeId = lifeId;
        this.lifeName = lifeName;
    }

    public Integer getLifeId() {
        return lifeId;
    }

    public void setLifeId(Integer lifeId) {
        this.lifeId = lifeId;
    }

    public String getLifeName() {
        return lifeName;
    }


    private void destory() {
        System.out.println("第5: 销毁bean");
    }

    @Override
    public String toString() {
        return "BeanLifeSpan{" +
                "lifeId=" + lifeId +
                ", lifeName='" + lifeName + '\'' +
                '}';
    }
}
