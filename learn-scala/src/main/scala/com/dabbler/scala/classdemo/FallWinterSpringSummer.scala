package com.dabbler.scala.classdemo
// Application 特质
// 特质Application声明了带有合适签名的main方法，被单例对象继承，使它可以向scala程序一样，
// 花括号之间的代码被收集进了单例对象的主构造器，并在类被初始化时执行
// 1.如果想访问命令行参数不行，因为args数组不可访问
//2.因为JVM线程模型的局限，对于多线程的程序需要自行写main方法
// 3. 某些JVM的实现没有优化被Application特质执行的对象的初始化代码
//4. 只有当程序相对简单并且是单线程的情况下才可以继承Application特质
object FallWinterSpringSummer  {//extends Application{

  for(season<-List("fall","winter","spring")){
    println(season+":"+SingletonDemo.calculate(season))
  }
}

