package com.redDabbler.review.common.jdk.io;

import java.io.IOException;
import java.io.PipedInputStream;
import java.io.PipedOutputStream;

/**
 * 管道流 用于将数据从一个线程传输给另一个线程
 * 两个线程之间的同步由阻塞读和写来处理。
 * 如果使用同一个线程处理两个相关联的管道流时，read()方法和write()方法调用时会导致流阻塞，
 * 可能会导致线程死锁
 */
public class PipeThreadDemo {

    public static void main(String[]args){

        try {
            connect();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    public static void connect()throws IOException {
        final PipedInputStream pis = new PipedInputStream();
        final PipedOutputStream pos = new PipedOutputStream();
        //pos.connect(pis);
        //PipedInputStream和PipedOutputStream都拥有一个可以互相关联的connect()方法。
        pis.connect(pos);
        Runnable produce = new Runnable(){
            public void run(){
                produce(pos);
            }
        };

        Runnable consumer = new Runnable(){
            public void run(){
                consume(pis);
            }
        };

        new Thread(produce).start();
        new Thread(consumer).start();

    }


    public static void produce(PipedOutputStream pos){

        try{
            for (int i=0;i<20;i++){
                pos.write(i);
                System.out.println("produce "+i);
                Thread.sleep(1000);
            }

        }catch (IOException | InterruptedException e){
            e.printStackTrace();
        }finally {
            if(pos!=null){
                try {
                    pos.close();
                    pos = null;
                }catch (IOException e){
                    e.printStackTrace();
                }

            }

        }

    }

    public static void consume(PipedInputStream pis){
        try{
            int j =0;
            while((j=pis.read())!=-1){
                System.out.println("consume "+j);
            }
        }catch (IOException e){
            e.printStackTrace();
        }finally {
            if(pis!=null){
                try {
                    pis.close();
                    pis = null;
                }catch (IOException e){
                    e.printStackTrace();
                }

            }

        }


    }
}
