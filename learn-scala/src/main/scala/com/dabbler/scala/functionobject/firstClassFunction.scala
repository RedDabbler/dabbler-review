package com.dabbler.scala.functionobject

/**
  * 可以把函数写成匿名的字面量，并把它们作为值传递
  * 函数值是对象，可以将它存入变量
  * 任何函数值都是某个扩展了scala包里FunctionN特质之一的类的实例
  * 如Function0是没有参数的函数，Function1是有一个参数的函数，每个FunctionN特质有一个apply方法用来调用函数
  */
class firstClassFunction {

  /**
    * 函数字面量被编译进类，在运行实例化化为函数值
    * 函数字面量和值的区别：函数字面量存在源代码，函数值作为对象 存在于运行期，这个区别很想类和对象之间的关系
    * => 指明这个函数把左边的东西（任何整数x）转变为右边的东西（x+1）
    *
    */
  var increase = (x:Int)=>x+1

  increase =(x:Int)=>{
    println("We")
    println("are")
    println("here!")
    x+1
  }

  increase(10)

  //集合类都会用到foreach方法，它以函数作为入参，并对每个元素调用该函数
  var someNumers = List(1,2,3,-1);
  someNumers.foreach((x:Int)=>println(x))

  //集合类型的filter方法
  someNumers.filter((x:Int)=>x>0)

  /**
    * 函数字面量的短格式
    */
  someNumers.filter((x)=>x>0)
  someNumers.filter(x=>x>0)
  /**
    * 占位符
    * 每个参数在函数字面量内仅出现一次
    * 每个参数在函数字面量中最多出现一次，多个下划线表示多个参数，并不是每个参数的重复使用
    */
  someNumers.filter(_>0)
  // 有时把下划线作为参数的占位符，编译器可能无法推断
  //如 val f = _+_
  var f=(_ : Int)+(_:Int)
  f(5,10)
  // 每个参数在函数字面量中最多出现一次，多个下划线表示多个参数，并不是每个参数的重复使用

  someNumers.foreach(println(_))
  //函数名和下划线之间留一个空格，不这样编译器会认为不同的符号
  //
  someNumers.foreach(println _)

  /**
    * 部分应用函数
    * 它是一种表达式，不需要提供函数需要的所有的参数，，进提供部分或不提供
    * 编译器根据表达式sum _ 自动产生类里的apply方法
    */
  def sum(a:Int,b:Int,c:Int)=a+b+c
  val a = sum _
  a(1,2,3)
  a.apply(1,2,3)

  val b =sum(1,_: Int,3)
  // 调用了sum(1,2,3)
  b(2)
  // 如果要写一个省略所有参数的偏程序表达式，如println _ 或者sum _,而且在代码的那个地方正需要一个函数，可以去掉下划线
  someNumers.foreach(println)
  // 这种仅在需要写函数的地方才行，如foreach需要一个函数作为参数传入


  //为了避免出现出乎意料的结果，scala需要用"_"指定显示省略的函数参数，仅当需要函数类型的地方，才能省略_

}
