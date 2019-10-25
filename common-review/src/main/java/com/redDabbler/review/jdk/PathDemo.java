package com.redDabbler.review.jdk;


import lombok.extern.slf4j.Slf4j;

import java.io.File;
import java.nio.file.FileSystems;
import java.nio.file.Path;

@Slf4j
public class PathDemo {
    // Path 是1.7 引入的接口
    public void getPath(){
        File file = new File("F:/logs/log.log4j");
        Path path = file.toPath(); // File 转为Path
        file = path.toFile(); // path 转为File
        log.info("path:{}",path.toString());
        log.info("file:{}",file);
        log.info("path root:{}",path.getRoot());
        log.info("path fileName:{}",path.getFileName());

        String localCachePath = System.getProperty("config.path");
        log.info("localCachePath:{}",localCachePath);
        Path path1  = FileSystems.getDefault().getPath("F:/logs/log.log4j");
        log.info("path:{}", path1);
        log.info("path-filename:{}",path1.getFileName());
        log.info("path-root:{}",path1.getRoot());
    }


}
