package com.halohoop.aoplib.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Created by Pooholah on 2017/3/29.
 */
@Retention(RetentionPolicy.CLASS)//表示存在的阶段，如果改成RUNTIME，注解就会在反编译的class中还能看到
@Target({ElementType.METHOD})//标识此注解应用在方法上面
public @interface DealingTrace {
    String value1() default "halo0";//给他一个默认值

    String value2();

    int type1();

    int type2();
}
