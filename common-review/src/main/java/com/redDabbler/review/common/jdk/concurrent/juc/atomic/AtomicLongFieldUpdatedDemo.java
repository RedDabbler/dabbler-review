package com.redDabbler.review.common.jdk.concurrent.juc.atomic;

import java.util.concurrent.atomic.AtomicLongFieldUpdater;

/**
 * AtomicIntegerFieldUpdater,AtomicReferenceFieldUpdater
 * 这3个修改类的成员的原子类型的原理和用法相似
 * AtomicLongFieldUpdater
 * 可以对指定"类的 'volatile long'类型的成员"进行原子更新。它是基于反射原理实现的。
 */
public class AtomicLongFieldUpdatedDemo {

    static class Person {
        volatile long id;

        public Person(long id) {
            this.id = id;
        }

        public void setId(long id) {
            this.id = id;
        }

        public long getId() {
            return id;
        }
    }

    public static void main(String[] args) {
        AtomicLongFieldUpdater atomicLongFieldUpdater = AtomicLongFieldUpdater.newUpdater(Person.class,"id");
        Person p = new Person(12345678L);
        atomicLongFieldUpdater.compareAndSet(p,12345678L,123);
        System.out.println("id="+p.getId());
    }
}
