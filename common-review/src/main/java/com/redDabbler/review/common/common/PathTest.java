package com.redDabbler.review.common.common;

import org.junit.Test;

import java.io.File;
import java.nio.file.FileSystems;
import java.nio.file.Path;

public class PathTest {

    // Path 是1.7 引入的接口
    @Test
    public void testResolve(){
        File file = new File("");
        Path path = file.toPath(); // File 转为Path
        file = path.toFile(); // path 转为File

        String localCachePath = System.getProperty("config.path");
        System.out.println("localCachePath:"+localCachePath);
        Path path1  = FileSystems.getDefault().getPath(".");
        System.out.println("path:"+ path1);
        System.out.println("path-filename:"+path1.getFileName());
        System.out.println("path-root:"+path1.getRoot());
    }
}
