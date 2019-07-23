package com.redDabbler.review.common.pattern.strategy.compare;

public class Cat implements Comparable<Cat>{


    private Compartor compartor;
    private int age;


    public Compartor getCompartor() {
        return compartor;
    }

    public void setCompartor(Compartor compartor) {
        this.compartor = compartor;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public int compareTo(Cat cat) {
        // 比较方法固定死了
   //   return this.getAge() - cat.getAge();
        // 下面这个让用户自定义修改策略
        return compartor.compare(this,cat);
    }
}