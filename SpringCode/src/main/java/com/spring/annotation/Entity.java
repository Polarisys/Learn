package com.spring.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Target;

/**
 * @anthor Tolaris
 * @date 2020/8/14 - 15:47
 */

@Target(ElementType.TYPE)
public @interface Entity {
    String value();
}
