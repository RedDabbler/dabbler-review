package com.redDabbler.review.jdk;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;


@Slf4j
public class ReflectDemoTest {

    @Test
    public void getClassGenericParameter() {
        // 匿名内部类
        ReflectDemo reflectDemo = new ReflectDemo<Long>(){};
        Class cls = reflectDemo.getActualClassGenericParameter();
        log.info(cls.getName());
        cls = reflectDemo.getClassGenericParameter();
        log.info(cls.getName());
    }
}