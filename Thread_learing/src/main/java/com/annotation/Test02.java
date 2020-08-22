package com.annotation;

import java.lang.annotation.*;
import java.lang.reflect.Field;

/**
 * @anthor Tolaris
 * @date 2020/4/4 - 16:18
 */

//反射操作注解
public class Test02 {

    public static void main(String[] args) throws ClassNotFoundException, NoSuchFieldException {
        Class c1 = Class.forName("com.annotation.Student");

        //通过反射获得注解
        Annotation[] annotations = c1.getAnnotations();
        for (Annotation annotation : annotations) {
            System.out.println(annotation);
        }

        //获得注解的value值
        TableStu tableStu = (TableStu) c1.getAnnotation(TableStu.class);
        String value = tableStu.value();
        System.out.println(value);

        //获得类指定的注解
        Field name = c1.getDeclaredField("name");
        FiledStu annotation = name.getAnnotation(FiledStu.class);
        System.out.println(annotation.columnName());
        System.out.println(annotation.type());
        System.out.println(annotation.length());
    }
}


@TableStu("student")
class Student {
    @FiledStu(columnName = "id", type = "int", length = 10)
    private int id;
    @FiledStu(columnName = "age", type = "int", length = 10)
    private int age;
    @FiledStu(columnName = "name", type = "varchar", length = 10)
    private String name;

    public Student(int id, int age, String name) {
        this.id = id;
        this.age = age;
        this.name = name;
    }

    public Student() {

    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", age=" + age +
                ", name='" + name + '\'' +
                '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}

//类名的注解
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@interface TableStu {
    String value();
}

//属性的注解
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
@interface FiledStu {
    String columnName();

    String type();

    int length();
}
