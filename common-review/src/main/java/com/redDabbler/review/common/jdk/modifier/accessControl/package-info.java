package com.redDabbler.review.common.jdk.modifier.accessControl;
/**
 * 访问控制符
 * 类只有public和default修饰。
 *
 * 使用protected修饰，表示该类的成员可以被类的内部、同包下的其它类以及该类的子类访问。
 * protected  protected修饰，是指子类可以继承，重写，访问 ，是相当于在子类定义了该方法
 * 【包外访问】protected 修饰的成员 只是在类的定义时候，对子类可见，不在一个包内，类的对象不能调用到protected修饰的方法
 * 包外子类有权访问超类成员，它指子类继承该成员，然而，这并不意味着包外子类能够使用超类实例的引用访问该成员。
 */