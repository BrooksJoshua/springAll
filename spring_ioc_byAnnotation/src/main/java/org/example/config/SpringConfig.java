package org.example.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

/**
 * @author Joshua.H.Brooks
 * @description
 * @date 2022-06-07 11:41
 */
@ComponentScan(basePackages = {"org.example"})
@PropertySource("classpath:a.properties")
public class SpringConfig {

}
