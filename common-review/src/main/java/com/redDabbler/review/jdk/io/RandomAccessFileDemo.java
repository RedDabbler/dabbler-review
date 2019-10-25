package com.redDabbler.review.jdk.io;

import java.io.FileNotFoundException;
import java.io.RandomAccessFile;

public class RandomAccessFileDemo {


    public static void main(String[]args)throws Exception{

        constructor();
    }


    private static void constructor()throws FileNotFoundException {

        // 读模式下，文件不存在会报错
      //  RandomAccessFile randomAccessFile = new RandomAccessFile("E://1.txt","r");
        //读写模式下，文件不存在会创建一个
        RandomAccessFile randomAccessFile1 = new RandomAccessFile("E://1.txt","rw");
        //
        RandomAccessFile randomAccessFile2 = new RandomAccessFile("E://1.txt","rws");
    }
}
