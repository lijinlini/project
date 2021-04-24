package com.lijinlin.project.learn.annotation;

import java.lang.annotation.*;
//测试元注解

public class MyAnnotation {
    @MyAnnotation3("value可以省略")
    public void test(){

    }
}

//Target 表示我们的注解可以用在哪些地方
@Target(value = {ElementType.METHOD,ElementType.TYPE})
//Retention表示我们的注解在什么地方还有效
//runtime>class>sources
@Retention(value= RetentionPolicy.RUNTIME)
//@Documented 表示是否将我们的注解生成在JAVAdoc中
@Documented
//Inherited子类可以集成父类的注解
@Inherited
@interface MyAnnotation1{

}

@Target(value = {ElementType.METHOD,ElementType.TYPE})
@Retention(value= RetentionPolicy.RUNTIME)
@interface MyAnnotation2{
//注解的参数：参数类型+参数名();
    String name() default "";
    int age()  default 1;
    //如果默认值为-1，代表不存在。
    int id() default -1;
    String[] schools() default {"西部开源","清华大学"};
}

@Target(value = {ElementType.METHOD,ElementType.TYPE})
@Retention(value= RetentionPolicy.RUNTIME)
@interface MyAnnotation3{
    String value();
}