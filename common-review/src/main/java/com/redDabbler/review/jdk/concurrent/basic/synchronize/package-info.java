package com.redDabbler.review.jdk.concurrent.basic.synchronize;
/***
 **   * 基本规则
 *  * 第一条: 当一个线程访问“某对象”的“synchronized方法”或者“synchronized代码块”时，
 *  * 其他线程对“该对象”的该“synchronized方法”或者“synchronized代码块”的访问将被阻塞。
 *  * 第二条: 当一个线程访问“某对象”的“synchronized方法”或者“synchronized代码块”时，
 *  * 其他线程仍然可以访问“该对象”的非同步代码块。
 *  * 第三条: 当一个线程访问“某对象”的“synchronized方法”或者“synchronized代码块”时，
 *  * 其他线程对“该对象”的其他的“synchronized方法”或者“synchronized代码块”的访问将被阻塞。
 *
 *  实例锁：锁在某一个实例对象上，如果该类是单例的，那么这锁也具有全局锁的概念，实例锁对应的是synchronized关键字
 *
 *  全局锁：锁在类上，无论实例多少个对象，那线程都共享该锁，全局锁对应的是 static synchronized（或锁在该类的class或ClassLoader对象上）
 *
 **
 */