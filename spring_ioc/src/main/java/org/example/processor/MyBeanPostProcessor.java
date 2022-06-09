package org.example.processor;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;

/**
 * @author Joshua.H.Brooks
 * @description 注意⚠️ 后置处理器是对所有bean的处理。
 * @date 2022-06-06 21:21
 */
public class MyBeanPostProcessor implements BeanPostProcessor {
    /**
     *
     * @param bean 要干预的bean
     * @param beanName bean id
     * @return
     * @throws BeansException
     */
    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        //干预处理逻辑
        System.out.println("bean 初始化之**前**要进行的干预处理");
        return BeanPostProcessor.super.postProcessBeforeInitialization(bean, beanName);
    }

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        System.out.println("bean 初始化之**后**要进行的干预处理");
        return BeanPostProcessor.super.postProcessAfterInitialization(bean, beanName);
    }
}
