package org.example;

import org.springframework.cglib.proxy.Enhancer;
import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * @author Joshua.H.Brooks
 * @description
 * @date 2022-06-07 17:02
 */
public class DynamicProxy_CGLib_Test {
    public static void main(String[] args) {
        //1. 获取要被代理的target对象
        Person2 p = new Person2("张三");
        //2. 获取一个enhancer对象
        Enhancer enhancer = new Enhancer();
        //3. 设置父类字节码
        enhancer.setSuperclass(p.getClass());
        //4. 获取MethodInterceptor对象 用于定义增强规则 （类似jdkproxy里的invocationhandler对象的功能）
        MethodInterceptor methodInterceptor = new MethodInterceptor() {
            /**
             *
             * @param o 生成之后的代理对象 proxiedPerson
             * @param method 父类原本要执行的方法    Person2的eat 方法
             * @param objects 方法在调用时传入的实参数组
             * @param methodProxy 子类中重写的方法  Son的eat方法
             * @return
             * @throws Throwable
             */
            @Override
            public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
                Object res = null;
                if("eat".equals(method.getName())){ //如果是目标方法则增强
                    System.out.println("enhance before") ;
                   res = methodProxy.invokeSuper(o,objects);
                    System.out.println("enhance after") ;
                }else{ // 否则正常执行
                    res = methodProxy.invokeSuper(o,objects); //子类对象的方法在执行，默认会调用父类被重写的方法
                }
                return res;
            }
        };
        //5. 设置回调方法
        enhancer.setCallback(methodInterceptor);
        //6. 获取代理对象
        Person2 proxiedPerson =(Person2) enhancer.create();
        proxiedPerson.eat("煎饼果子");
    }
}

 class Person2{
    private String name;
     public Person2(){
     }
    public Person2(String name){
        this.name = name;
    }
    public void eat(String foodName){
        System.out.println(name+" eats "+ foodName);
    }
 }

 class Son extends Person2{
    public Son(String name){
        super(name);
    }

     @Override
     public void eat(String foodName) {
         System.out.println("wash hands before dinner");
         super.eat(foodName);
         System.out.println("wash dishes after dinner");
     }
 }