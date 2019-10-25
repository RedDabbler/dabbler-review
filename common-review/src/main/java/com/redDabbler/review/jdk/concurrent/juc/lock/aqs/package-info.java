package com.redDabbler.review.jdk.concurrent.juc.lock.aqs;
/**
 * AQS AbstractQueueSynchronizer
 * 是管理锁的抽象类，锁的许多公共方法都在该类中实现，AQS是独占锁和共享锁的父类
 *
 * 独占锁： 锁在一个时间点只能被一个线程锁占有，根据锁的获取机制，分为公平锁和非公平锁。
 * 共享锁：能被多个线程同时拥有，能被共享的锁。ReentrantReadWriteLock.ReadLock，CyclicBarrier， CountDownLatch和Semaphore都是共享锁。
 *
 * 公平锁和非公平锁的区别，是在获取锁的机制上的区别。表现在，在尝试获取锁时
 * 公平锁，只有在当前线程是CLH等待队列的表头时，才获取锁；
 * 而非公平锁，只要当前锁处于空闲状态，则直接获取锁，而不管CLH等待队列中的顺序。
 * 只有当非公平锁尝试获取锁失败的时候，它才会像公平锁一样，进入CLH等待队列排序等待
 *
 *
 *
 *
 */