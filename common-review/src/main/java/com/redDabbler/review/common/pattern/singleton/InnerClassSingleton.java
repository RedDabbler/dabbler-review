package com.redDabbler.review.common.pattern.singleton;

/**
 * 内部类分为对象级别和类级别，
 * 类级内部类指的是，有static修饰的成员变量的内部类。
 * 如果没有static修饰的成员变量的内部类被称为对象级内部类。
 *
 * 类级内部类相当于其外部类的static成员，它的对象与外部类对象间不存在依赖关系，相互独立，因此可直接创建。
 * 而对象级内部类的实例，是必须绑定在外部对象实例上的。
 * 类级内部类只有在第一次被使用的时候才被会装载。
 *
 * 下面的单例利用这种特性，实现延迟加载
 */
public class InnerClassSingleton {
    private static InnerClassSingleton singleton;

    private InnerClassSingleton(){
    }

    public static InnerClassSingleton getInstance(){
        return Context.INSTANCE;
    }

    private static class Context{
        private static InnerClassSingleton INSTANCE = new InnerClassSingleton();
    }




}
