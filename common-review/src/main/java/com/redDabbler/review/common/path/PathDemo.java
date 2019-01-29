package com.redDabbler.review.common.path;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class PathDemo {

    public static void get(){
        //获取classpath路径 也就是类加载器的路径
        String classLoaderPath = PathDemo.class.getClassLoader().getResource(".").getPath();
        log.info("classLoaderPath:{}",classLoaderPath);
        //获取当前类的加载路径
        String classPath = PathDemo.class.getClass().getResource(".").getPath();
        log.info("class path:{}",classPath);
    }




}
