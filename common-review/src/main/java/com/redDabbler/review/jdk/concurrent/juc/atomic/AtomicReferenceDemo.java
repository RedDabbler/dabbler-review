package com.redDabbler.review.jdk.concurrent.juc.atomic;

import java.util.concurrent.atomic.AtomicReference;

/**
 * 对对象进行原子操作
 */
public class AtomicReferenceDemo {

    static class Person{
        long id;
        public Person(long id) {
            this.id = id;
        }
        public String toString() {
            return "id:"+id;
        }
    }

    public static void main(String[]args){
        Person person = new Person(101);
        Person person1  = new Person(102);
        AtomicReference<Person> ar = new AtomicReference<>(person);
        //ar值是person时，设置为person1
        ar.compareAndSet(person,person1);
        Person pp = ar.get();
        System.out.println(pp==person1);

        System.out.println("equals: "+pp.equals(person1));

    }
}
