package com.redDabbler.review.jdk.modifier.accessControl;

/**
 * @author RedDabbler
 * @create 2019-02-02 11:18
 **/
public class Demo extends ParentDemo{

    // 可以访问到的方法，有public,protected,还有default
    public void testMethod(){
        protectedTest();
        publicTest();
        defaultTest();
    }

    // 可以访问到的静态方法，有public,protected,还有default
    public void staticMethod(){
        staticPublicTest();
        staticProtectedTest();
        staticDefaultTest();
    }

    public void demo(){
        ParentDemo parentDemo = new ParentDemo();
        parentDemo.publicTest();
        parentDemo.defaultTest();
        parentDemo.protectedTest();

        this.protectedTest();
    }
}
