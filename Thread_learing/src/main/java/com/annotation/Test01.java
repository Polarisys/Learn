package com.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @anthor Tolaris
 * @date 2020/4/4 - 11:39
 */

public class Test01 {

    @MyAnnotation01(name = "aaa")
    public void test() {

    }
}

//自定义注解
@Target({ElementType.ANNOTATION_TYPE, ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@interface MyAnnotation01 {
    //注解的参数：参数类型+参数名();
    String name() default "";

    int age() default 0;
}

