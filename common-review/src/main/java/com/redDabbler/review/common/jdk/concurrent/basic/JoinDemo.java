package com.redDabbler.review.common.jdk.concurrent.basic;

/**
 * 让“主线程”等待“子线程”结束之后才能继续运行
 * join底层调用的wait()
 */
public class JoinDemo {

    // 主线程
    static class Father extends Thread {
        public void run(){
            System.out.println("Father Thread run ");
            Son s = new Son();
            s.start();
            try {
                s.join();
            }catch (InterruptedException e){
                e.printStackTrace();
            }
            System.out.println("Father Thread finish");
        }
    }
    // 子线程
    static class Son extends Thread {
        public void run() {
            System.out.println("Son Thread run");
            try{

                Thread.sleep(10000);
            }catch (InterruptedException e){
                e.printStackTrace();

            }
            System.out.println("Son Thread finish");
        }
    }

    public static void main(String[]args){
        Father father = new Father();
        father.start();


    }


}
