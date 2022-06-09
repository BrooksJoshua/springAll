package org.example.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

/**
 * @author Joshua.H.Brooks
 * @description
 * @date 2022-06-07 20:33
 */
@Aspect
@Component
@Order(2) // 数字越小越先执行
public class AspectBestPractice {
    /**
     * 向上提取定义公共的切入点，公式：
     * execution(modifiers-pattern? ret-type-pattern declaring-type-pattern?name-pattern(param-pattern) throws-pattern?)
     * modifiers-pattern表示方法的访问类型,public等;
     * ret-type-pattern表示方法的返回值类型,如String表示返回类型是String，“”表示所有的返回类型;
     * declaring-type-pattern表示方法的声明类,如“org.example..”表示该包及其子包下面的所有类型;
     * name-pattern表示方法的名称,如“add”表示所有以add开头的方法名;
     * param-pattern表示方法参数的类型,
     * name-pattern(param-pattern)其实是一起的表示的方法集对应的参数类型，
     * 如“add()”表示不带参数的add方法，“add(*)”表示带一个任意类型的参数的add方法，“add(*,String)”则表示带两个参数，且第二个参数是String类型的add方法；
     * throws-pattern表示异常类型；其中以问号结束的部分都是可以省略的。
     */
    @Pointcut("execution(* org.example.dao.UserDao.addUser(..))")
    public void addUserPointCut(){}


    @Before("addUserPointCut()")
    public void beforeAdvice(JoinPoint joinPoint){
        System.out.println("user dao 的前置通知， 加在dao接口上的");
    }


}
