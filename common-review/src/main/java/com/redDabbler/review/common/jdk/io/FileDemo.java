package com.redDabbler.review.common.jdk.io;

import java.io.File;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
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
        File file2 = new File("E:\\",".\\1.txt");
        file2.setExecutable(false);
        // windows 下的所有文件都有可执行权限。要测试这个功能只能用 linux、unix
        System.out.println("canExecute: "+file2.canExecute());
        //是否是隐藏文件
        System.out.println("isHidden:"+file2.isHidden());
        //是否允许写文件
        System.out.println("canWrite: "+file2.canWrite());
        //返回的是File构造方法里的路径，是什么就是什么，不增不减
        System.out.println("path:"+file2.getPath());
        // 绝对路径 getAbsolutePath()返回的其实是user.dir+getPath()的内容
        System.out.println("absolutePath："+file2.getAbsolutePath());

        System.out.println("Parent："+file2.getParent());

        // windows用;来隔离路径
        System.out.println("pathSeparatorChar:"+File.pathSeparatorChar);
        //C:\
        //D:\
        //E:\
        //F:\
        //G:\
        File[] files =  File.listRoots();
        for(File t:files){
            System.out.println(t);
        }
        // path分隔符
        System.out.println("separator: "+File.separator);


        try{
            //默认在C:\Users\Administrator\AppData\Local\Temp 下创建以123开头，abc结尾的临时文件
            File tmpFile = File.createTempFile("123","abc");
            System.out.println("tmpFile: "+tmpFile.getCanonicalPath());
            File tmpFile2 = File.createTempFile("123","abc",new File("E://"));
            System.out.println("tmpFile2: "+tmpFile2.getCanonicalPath());
            //CanonicalPath  才是唯一的绝对路径  与getAbsolutePath不同之处在于，它会将‘..’或者‘.’这类路径解析好
            System.out.println("path:"+file2.getCanonicalPath());
        }catch (IOException e){
            e.printStackTrace();
        }


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

        /**
         * deleteOnExit
         *  不会马上执行删除操作, 而是程序运行结束, JVM终止时才真正调用删除操作
         * 程序退出时删除
         */
      //  file2.deleteOnExit();
        System.out.println("isHidden:"+dest.isHidden());
        System.out.println("isAbsolute:"+dest.isAbsolute());
        System.out.println("lastModified:"+ new Date(file2.lastModified()));
        System.out.println("length:"+file2.length());

        System.out.println("URI:"+file2.toURI());
    }
}
