package com.redDabbler.review.common.jdk.modifier.accessControl;

/**
 * @author RedDabbler
 * @create 2019-02-02 11:37
 **/
public class Other {

    // 还是可以调用到 protected
    public void demo(){
        ParentDemo parentDemo = new ParentDemo();
        parentDemo.publicTest();
        parentDemo.protectedTest();
        parentDemo.defaultTest();

        ParentDemo.staticDefaultTest();
        ParentDemo.staticProtectedTest();
        ParentDemo.staticPublicTest();
    }
}
