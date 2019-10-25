package com.redDabbler.review.jdk.io;

import java.io.FileNotFoundException;
import java.io.PrintStream;

/**
 * System.out
 * System.err
 * 为其他输出流添加了功能，使它们能够方便地打印各种数据值表示形式
 * 打印的所有字符都使用平台的默认字符编码转换为字节
 */
public class PrintStreamDemo {

    public static  void main(String[]args)throws  Exception{
        print();
    }

    public static  void print()throws FileNotFoundException {
        PrintStream printStream = new PrintStream("E:\\common-cli.md");
        printStream.println("123456");
        printStream.println(1111);
        printStream.println(true);
        printStream.println(2.0f);
        printStream.print(new char[]{1,'=','q'});

        String name = "刘" ;	// 定义字符串
        int age = 23 ;				// 定义整数
        float score = 90.356f ;	// 定义小数
        char sex = 'M' ;			// 定义字符
        printStream.printf("姓名：%s；年龄：%d；成绩：%f；性别：%c",name,age,score,sex);

        printStream.checkError();

    }
}
