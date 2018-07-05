package com.dabbler.scala.classdemo

import scala.collection.mutable.Map


class SingletonDemo{
  private var sum=0
  def add(b:Byte){sum+=b}
  def checksum():Int = ~(sum&0xFF)+1

}
// scala不能定义静态成员，而是代之以定义到单例对象，
// 除了用object 关键字替换了class关键字 外，单例对象 定义上看上去与类定义一致
/**
  * 这个单例对象scalaClassDemo 与上一个例子的类同名
  * 当单例对象与某个类共享同一个名称时，它就被称为这个类的伴生对象 （companion object）
  * 类和它的伴生对象必须定义在一个源文件里，类被称为这个单例对象的伴生类
  * 类和伴生对象可以互相访问其私有成员
  * 可以把单例对象当作是java中可能用到的静态方法工具类，支持 单例对象名,点号，方法名调用
  */
object SingletonDemo {
  private val cache = Map[String,Int]()
  def calculate(s:String):Int=
    if (cache.contains(s))
      cache(s)
    else {
      val acc = new SingletonDemo
      for (c <- s) {
        acc.add(c.toByte)
      }
      var cs = acc.checksum()
      cache += (s -> cs)
      cs
    }

}

// 单例对象可以看做是贴在对象上的"名签"

// 如果只有对象的定义，就不能建立类型的变量
// 单例对象不带参数，而类可以，单例对象不是用new关键字实例化的，所以没机会传递给它实例化参数
// 单例对象在第一次被访问的似乎还才会被初始化
// 不与伴生类共享名称的单例对象被称为独立对象（standalone object）,可以作为相关功能方法的工具类，或定义scala应用的入口点

