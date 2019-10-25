package com.redDabbler.review.jdk.modifier.accessControl.testpackage;

import com.redDabbler.review.jdk.modifier.accessControl.Demo;
import com.redDabbler.review.jdk.modifier.accessControl.ParentDemo;

/**
 * @author RedDabbler
 * @create 2019-02-02 11:37
 **/
public class Other {

    // 还是可以调用到 protected
    public void demo(){
        ParentDemo parentDemo = new ParentDemo();
        parentDemo.publicTest();
       // parentDemo.protectedTest();
        // parentDemo.defaultTest();

     //   ParentDemo.staticDefaultTest();
        // 不能被非子类访问 'protectedTest()' has protected access in 'com.redDabbler.review.common.jdk.modifier.accessControl.ParentDemo'
     //   ParentDemo.staticProtectedTest();
        ParentDemo.staticPublicTest();
        com.redDabbler.review.jdk.modifier.accessControl.Demo demo = new Demo();
        // 'protectedTest()' has protected access in 'com.redDabbler.review.common.jdk.modifier.accessControl.ParentDemo'
     //   demo.protectedTest();
        demo.publicTest();
        demo.demo();


    }
}
