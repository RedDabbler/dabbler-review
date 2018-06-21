package com.dabbler.scala.classdemo
// public 是scala的默认访问级别，什么都不写，表示public
class scalaClassDemo {

  private var sum=0
  // 方法参数都是val，不是var，如果要重新赋值，会编译失败
  def add(b:Byte):Unit={
   // b =1 // 编译不过，因为b是val
    sum+=b
  }

  // 尽量避免使用返回语句，尤其是多条返回语句
  // 代之以每个方法作为创建返回值的表达式，即把较大的方法分解为更小的方法
  def checksum():Int={
    // return 语句是多余的可以去掉，如果没有发现任何显示的返回语句，将返回方法中最后一次计算得到的值
    return ~(sum &0xFF)+1
  }

}

//假如某个方法仅计算单个结果表达式，则可以去掉花括号
class scalaClassDemo1{
  private var sum=0
  def add(b:Byte):Unit= sum+=b
  def checksum():Int = ~(sum&0xFF)+1

}

//add 方法 执行的目的就是为了它的副作用
// 通常我们定义副作用为能够改变方法之外的某些状态或执行I/0活动的方法
// 比如在add方法里，副作用就是sum被重新赋值了
// 另一种表达式是去掉结果类型和等号，把方法体放在花括号里，一种仅仅为了副作用而执行的方法
class scalaClassDemo2{
  private var sum=0
  def add(b:Byte){sum+=b}
  def checksum():Int = ~(sum&0xFF)+1

}

// scala编译器可以把任何类型转化为Unit，如果方法的最后结果是String，但结果类型声明为Unit，那么String将被转为Unit并丢弃原值
//def f():Unit="this is String"

//def f(){"this is String"}

//def f()={"this is String"}
// 实际是 f: ()String

// if ...else 语句认为是一条语句

/** 分号推断的规则
  * 除非以下情况的一种成立，否则认为行尾是一个分号
  * 1.疑问行由一个不能合法行为语句结尾的字符串 结束，如句点或中缀操作符
  * 2.下一行开始于不能 作为语句开始的词
  * 3.行结束于 括号（...）或 [...] 内部，因为这些符号不可能容纳多个语句
  *
  *
 */