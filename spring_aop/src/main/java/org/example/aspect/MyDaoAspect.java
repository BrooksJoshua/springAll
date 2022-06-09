package org.example.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.util.Arrays;

/**
 * @author Joshua.H.Brooks
 * @description
 * @date 2022-06-07 19:12
 */
@Aspect
@Component
@Order(3)
public class MyDaoAspect {

    @Before("execution(* org.example.dao.impl.UserDaoImpl.addUser(..))")
    public void methodBefore(JoinPoint joinPoint){
        System.out.println("UserDaoImpl.addUser 的 前置通知");
        showJointPointInfo(joinPoint);
    }

    @AfterThrowing(value = "execution(* org.example.dao.impl.UserDaoImpl.addUser(..))",throwing = "exp")
    public void methodAfterThrow(JoinPoint joinPoint,Exception exp){
        System.out.println("UserDaoImpl.addUser 的 异常通知");
        System.out.println("Exception thrown:\t"+exp.getLocalizedMessage());
    }

    @AfterReturning(value = "execution(* org.example.dao.impl.UserDaoImpl.addUser(..))",returning = "res")
    public void methodAfterReturning(JoinPoint joinPoint,Object res){
        System.out.println("UserDaoImpl.addUser 的 后置通知");
    }

    /**
     * 1. 必须接收一个ProceedingJoinPoint类型的方法参数，然后在方法体中选择一个合适的时机来调用ProceedingJoinPoint的proceed方法以触发对目标方法的调用，
     *    然后Around Advice处理方法的返回值会被当做是目标方法调用的返回值。
     * 2. 所以通过Around Advice我们可以在通过ProceedingJoinPoint调用目标方法的前后加上特定的逻辑，包括使用try…catch…finally等.
     * 3. 所以Around Advice是功能最强大的一个Advice，前面的任何一种Advice在应用的时候都可以被Around Advice替换。
     * 4. 环绕通知的返回类型必须是目标方法的返回类型极其父类型。 否则报错：
     *    org.springframework.aop.AopInvocationException: Null return value from advice does not match primitive return type for: public abstract int org.example.dao.UserDao.addUser(java.lang.String,java.lang.String)
     * @param proceedingJoinPoint
     */
    @Around("execution(* org.example.dao.impl.UserDaoImpl.addUser(..))")
    public int methodAround(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        System.out.println("进入UserDaoImpl.addUser 的环绕 通知");
        //触发切入点方法的执行
        int res = (int) proceedingJoinPoint.proceed();
        System.out.println("即将结束UserDaoImpl.addUser 的环绕 通知");
        return res;
    }

    @After("execution(* org.example.dao.impl.UserDaoImpl.addUser(..))")
    public void methodAfter(JoinPoint joinPoint){
        System.out.println("UserDaoImpl.addUser 的 最终通知");
    }


    private void showJointPointInfo(JoinPoint joinPoint) {
        System.out.println("joinPoint.getArgs() = " + Arrays.toString(joinPoint.getArgs()));
        System.out.println("joinPoint.getKind() = " + joinPoint.getKind());
        System.out.println("joinPoint.getSignature() = " + joinPoint.getSignature());
        System.out.println("joinPoint.getTarget() = " + joinPoint.getTarget());
        System.out.println("joinPoint.getSourceLocation() = " + joinPoint.getSourceLocation());
        System.out.println("joinPoint.getStaticPart() = " + joinPoint.getStaticPart());
    }


}
