package com.redDabbler.review.jdk.concurrent.juc.atomic;
/**
 * 目的是对相应的数据进行原子操作。所谓原子操作，是指操作过程不会被中断，
 * 保证数据操作是以原子方式进行的。
 *
 * 1. 基本类型: AtomicInteger, AtomicLong, AtomicBoolean ;
 * 2. 数组类型: AtomicIntegerArray, AtomicLongArray, AtomicReferenceArray ;
 * 3. 引用类型: AtomicReference, AtomicStampedRerence, AtomicMarkableReference ;
 * 4. 对象的属性修改类型: AtomicIntegerFieldUpdater, AtomicLongFieldUpdater, AtomicReferenceFieldUpdater 。
 */