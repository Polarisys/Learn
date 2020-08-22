package com.spring.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

/**
 * @anthor Tolaris
 * @date 2020/8/13 - 16:23
 */
@Configuration
@ComponentScan("com")
@EnableAspectJAutoProxy
public class AppConfig {


}
