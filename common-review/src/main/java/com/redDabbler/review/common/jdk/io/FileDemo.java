package com.redDabbler.review.common.jdk.io;

import java.io.File;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.Calendar;
import java.util.Date;

public class FileDemo {

    public static void main(String[]args){
        constructor();
        seldomMethod();
    }
    public static void constructor(){
        File parent = new File("E:\\");
        File file1 = new File(parent,"doc"); // 表示E:\\doc 文件
        File file2 = new File("E:\\","doc");
        File file3 = null;
        try {
            file3 = new File(new URI("file:/E:/1.txt"));
            System.out.println(file3.exists());
        } catch (URISyntaxException e) {
            e.printStackTrace();
        } catch (IllegalArgumentException e){
            e.printStackTrace();
        }
    }

    public static  void seldomMethod(){
        File file2 = new File("E:\\","1.txt");
        file2.setExecutable(false);
        // windows 下的所有文件都有可执行权限。要测试这个功能只能用 linux、unix
        System.out.println(file2.canExecute());
        //删除文件
        file2.delete();
        try {
            // 创建
            file2.createNewFile();
            System.out.println("exists:"+file2.exists());
        }catch (IOException e){
            e.printStackTrace();
        }

        File dest = new File("1.ini");
        // 重命名
        file2.renameTo(dest);
        System.out.println("fileName："+file2.getName());

       // E:\ 的上级路径是null
        System.out.println("parent："+file2.getParentFile().getParent());
        System.out.println(file2.getTotalSpace()+"--"+file2.getFreeSpace()+"--"+file2.getUsableSpace());
        try {
            System.out.println("absolutePath："+file2.getAbsolutePath());
            System.out.println("CanonicalPath："+file2.getCanonicalPath());
        } catch (IOException e) {
            e.printStackTrace();
        }

        file2.deleteOnExit();
        System.out.println("isHidden:"+dest.isHidden());
        System.out.println("isAbsolute:"+dest.isAbsolute());
        System.out.println("lastModified:"+ new Date(file2.lastModified()));
        System.out.println("length:"+file2.length());
        System.out.println("URI:"+file2.toURI());
    }
}
