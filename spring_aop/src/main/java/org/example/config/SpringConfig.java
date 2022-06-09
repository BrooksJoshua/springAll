package org.example.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

/**
 * @author Joshua.H.Brooks
 * @description
 * @date 2022-06-07 21:08
 */
@Configuration
@ComponentScan(basePackages = {"org.example"})
@EnableAspectJAutoProxy(proxyTargetClass = true)
public class SpringConfig {

}
