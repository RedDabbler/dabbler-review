package com.redDabbler.review.jdk.collection;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

/**
 *  fast-fail事件产生的条件：当多个线程对Collection进行操作时，若其中某一个线程通过iterator去遍历集合时，
 *  该集合的内容被其他线程所改变；则会抛出ConcurrentModificationException异常。
 *
 *  fast-fail解决办法：通过util.concurrent集合包下的相应类去处理，则不会产生fast-fail事件。
 *
 *  fail-fast机制，是一种错误检测机制。它只能被用来检测错误，因为JDK并不保证fail-fast机制一定会发生。
 *  若在多线程环境下使用fail-fast机制的集合，建议使用“java.util.concurrent包下的类”去取代“java.util包下的类”。
 */
public class FailFastDemo {

    //private static List<String> list = new ArrayList<String>();
    private static List<String> list = new CopyOnWriteArrayList<>();

    public static void main(String[]args){
        new ThreadOne().start();
        new ThreadTwo().start();


    }

    private static  void print(){
        System.out.println("");
        Iterator<String> iterator = list.iterator();
        while(iterator.hasNext()){
            String value = iterator.next();
            System.out.print(value+",");

        }
    }

    private static class ThreadOne extends Thread{

        public void run(){
            int i =0;
            while(i<6){
                list.add(String.valueOf(i));
                print();
                i++;
            }
        }

    }

    private static class ThreadTwo extends Thread{

        public void run(){
            int i =0;
            while(i<16){
                list.add(String.valueOf(i));
                print();
                i++;
            }
        }

    }
}
