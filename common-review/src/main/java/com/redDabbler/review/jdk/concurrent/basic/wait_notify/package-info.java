package com.redDabbler.review.jdk.concurrent.basic.wait_notify;
/**
 * wait notify
 *
 * wait 是让当前线程进入等待状态，并释放持有该对象的锁
 *
 * notify 是唤醒单个在当前对象上等待的线程，notifyAll 是唤醒所有
 *
 * 如果是多消费者和多生产者情况，如果使用notify方法可能会出现“假死”的情况，即唤醒的是同类线程。
 * 假设当前多个生产者线程会调用wait方法阻塞等待，当其中的生产者线程获取到对象锁之后使用notify通知处于WAITTING状态的线程，
 * 如果唤醒的仍然是生产者线程，就会造成所有的生产者线程都处于等待状态。
 * 解决办法：将notify方法替换成notifyAll方法
 *
 *  wait notify 基本模型
 * // The standard idiom for calling the wait method in Java
 * synchronized (sharedObject) {
 *     while (condition) {
 *         sharedObject.wait();
 *         // (Releases lock, and reacquires on wakeup)
 *     }
 *     // do action based upon condition e.g. take or put into queue
 * }
 *

 */