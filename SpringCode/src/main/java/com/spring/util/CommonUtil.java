package com.spring.util;

import com.spring.annotation.Entity;

/**
 * @anthor Tolaris
 * @date 2020/8/14 - 15:44
 */
public class CommonUtil {

    public  static  String getSql(Object object){
        Class clazz = object.getClass();
        if(clazz.isAnnotationPresent(Entity.class)) {
            Entity entity = (Entity) clazz.getAnnotation(Entity.class);
            String value = entity.value();
        }
        return "";
    }
}
