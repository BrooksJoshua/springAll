package org.example;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.Arrays;

/**
 * @author Joshua.H.Brooks
 * @description JDKProxy的底层逻辑的代码演示。总结其特点如下
 * 1。 面向接口。 JDKProxy实现动态代理一定要有接口和实现类的存在。 代理对象增强的是实现类在实现接口的方法重写的方法。
 * 2。 生成的代理对象只能转换成接口的实现类 不能转换成被代理类。如本例中：(Dinner) Proxy.newProxyInstance(classLoader, interfaces, ih);
 * 3。 代理对象只能增强接口中定义的方法， 实现类中的其他扩展的和接口无关的方法是无法增强的。
 * 4。 代理对象只能读取到接口中方法上的注解 不能读取到实现类方法上的注解。
 * @date 2022-06-07 16:18
 */
public class DynamicProxy_JDK_Test {

    public static void main(String[] args) {
        final Dinner dinner = new Student("李四");
        //被代理对象的类加载器
        ClassLoader classLoader = dinner.getClass().getClassLoader();
        //被代理对象所实现的所有接口
        Class<?>[] interfaces = dinner.getClass().getInterfaces();
        //执行处理器对象，专门用于定义增强的规则具体逻辑
        InvocationHandler ih = new InvocationHandler() {
            /**
             * 当我们让代理对象调用任何方法时都会触发该invoke方法的执行
             * @param proxy  代理对象，
             * @param method 被代理对象要调用的具体方法
             * @param args 被代理方法运行时的实参
             * @return
             * @throws Throwable
             */
            @Override
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                Object res = null;
                System.out.println("invoke method invoked");
                //System.out.println("proxy = " + proxy);
                System.out.println("method = " + method);
                System.out.println("args = " + Arrays.toString(args));
                if("eat".equals(method.getName())){
                    System.out.println("饭前洗手");
                    //如果是eat方法，则先让原有方法正常执行
                    res = method.invoke(dinner,args);
                    //然后做增强
                    System.out.println("饭后刷碗");
                }else{
                    res = method.invoke(dinner,args);
                }
                return res;
            }
        };
        Dinner proxiedDinner = (Dinner) Proxy.newProxyInstance(classLoader, interfaces, ih);
        proxiedDinner.eat("五谷渔粉");

    }


}

interface Dinner{
    void eat(String foodName);
}

class Person implements Dinner{
    private String name;

    public Person(String name) {
        this.name = name;
    }

    @Override
    public void eat(String foodName) {
        System.out.println(name+"喜欢吃"+foodName);
    }
}

class Student implements Dinner{
    private String name;

    public Student(String name) {
        this.name = name;
    }

    @Override
    public void eat(String foodName) {
        System.out.println("学生:\t"+name+"在食堂吃\t"+foodName);
    }
}