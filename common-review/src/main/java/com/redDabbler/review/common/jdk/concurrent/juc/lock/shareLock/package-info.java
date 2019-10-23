package com.redDabbler.review.common.jdk.concurrent.juc.lock.shareLock;
/**
 *
 * 共享锁
 *
 * ReadWriteLock，顾名思义，是读写锁。它维护了一对相关的锁 — — “读取锁”和“写入锁”，一个用于读取操作，另一个用于写入操作。
 * “读取锁”用于只读操作，它是“共享锁”，能同时被多个线程获取。
 * “写入锁”用于写入操作，它是“独占锁”，写入锁只能被一个线程锁获取。
 * 注意：不能同时存在读取锁和写入锁！
 *
 * ReentrantReadWriteLock 源码
 *
 * CountDownLatch
 */