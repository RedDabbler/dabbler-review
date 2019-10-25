package com.redDabbler.review.jdk.io;


import java.io.*;

/**
 * 文件描述
 * in(标准输入),out(标准输出),err(标准错误输出)
 * FileDescriptor 可以被用来表示开放文件、开放套接字等。
 * 当FileDescriptor表示某文件时，我们可以通俗的将FileDescriptor看成是该文件。
 * 但是，我们不能直接通过FileDescriptor对该文件进行操作；
 * 若需要通过FileDescriptor对该文件进行操作，则需要新创建FileDescriptor对应的FileOutputStream，
 * 再对文件进行操作。
 *
 * 它就是一个类似指针的东西。函数里面就根据这个fd对这同一个文件或者已经建立的socket连接进行操作。
 */
public class FileDesciptorDemo {

    public static void main(String[]args){
        FileDescriptor fileDescriptor = new FileDescriptor();
        System.out.println(fileDescriptor.valid());
        print();
    }

    /**
     * 类似System.out.print 功能
     */
    public static void print(){

        FileDescriptor err = FileDescriptor.err;
        FileDescriptor in = FileDescriptor.in;
        FileDescriptor out = FileDescriptor.out;
        PrintStream outputStream = new PrintStream(new FileOutputStream(out)) ;
        outputStream.print("hello world");
    }

}
