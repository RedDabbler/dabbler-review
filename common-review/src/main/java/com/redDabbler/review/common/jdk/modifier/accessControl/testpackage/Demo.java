package com.redDabbler.review.common.jdk.modifier.accessControl.testpackage;

import com.redDabbler.review.common.jdk.modifier.accessControl.ParentDemo;

/** 对比 外面的DEMO类
 *  访问控制符
 * @author RedDabbler
 * @create 2019-02-02 11:09
 **/
public class Demo extends ParentDemo {

    // 可以访问到的方法，只有public,protected
    public void testMethod(){
       protectedTest();
       publicTest();
    }

    // 还是这些，因此 和static 没关系
    public void staticMethod(){
        staticPublicTest();
        staticProtectedTest();
    }

    //在碰到涉及protected成员的调用时，首先要确定出该protected成员来自何方，其可见性范围是什么，
    //然后判断出当前用法是否可用
    // protected 修饰的成员 只是在类的定义时候，对子类可见，不在一个包内，类的对象不能调用到protected修饰的方法
    protected void demo(){
        ParentDemo parentDemo = new ParentDemo();
        parentDemo.publicTest();
        //NOTICE: protect 方法不可见

       //parentDemo.protectedTest(); 编译出错
        ParentDemo.staticPublicTest();
        ParentDemo.staticProtectedTest();

        Demo demo = new Demo();
        demo.protectedTest();
        Demo.staticProtectedTest();
        Demo.staticPublicTest();
        this.protectedTest();
    }




}
