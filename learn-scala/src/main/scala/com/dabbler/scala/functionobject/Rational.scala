package com.dabbler.scala.functionobject

/**
  * 类如果没有主体，就不需要指定一对空的花括号
  * n,d 被称为类参数，scala编辑器会收集这两个类参数并创造出带同样的两个参数的主构造器
  */
class Rational(n:Int,d:Int){
  // 把这段代码println调用放进了Rational的主构造器中
  println("created"+n+"/"+d)

  //检查先决条件
  require(d!=0) // 如果条件为false,跑出IllegalArgumentException 阻止对象被构造

  //重载override toString方法
  override def toString: String = n+"/"+d

  /**
    * 定义公开的add方法
    * 尽管类参数n,d 都在add代码可引用的范围内，但是add方法仅能访问调用对象自身的值
    * 如果要访问that的n和d，必须要把他们放在字段里，如下
    */
  var numer:Int = n
  var denom:Int = d
  def add(that:Rational):Rational={
    new Rational(
      numer*that.denom + that.numer*denom,denom*that.denom
    )
  }
  // 辅助构造器
  /**
    * 有时一个类里需要多个构造器
    * scala里主构造器之外的构造器被称为辅助构造器
    *
    * 主构造器是类的唯一入口点
    * scala的类里只有主构造器可以调用超类的构造器
    */
  def this(n:Int) = this(n,1)

  /**
    * 操作符定义
     */
  def +(that:Rational):Rational= {
    new Rational(
      numer * that.denom + that.numer * denom, denom * that.denom
    )
  }



  /**标识符
    * 字母数字标识符
    * 操作符标识符 + : ? ::: <?> ->  scala编译器内部将使用内部操作符标识符以转换合法的内嵌'$'的java标识符，->将被内部表达为$colon$minus$greater
    * 混合标识符 如 unary_+ 被用作定义一元的+ 操作符的方法名，myvar_= 被用作定义赋值操作符的方法名
    * 字面量标识符 是用`...` 包含的任意字符串  yield是Scala的保留字，java的Thread类访问静态yield方法，可以在反引号引用方法的名称 Thread.`yield`()
    *
    */

  /**
    * 方法重载
    */
  def +(i:Int):Rational= {
    new Rational(numer+i*denom,denom)
  }

  /**
    * 隐式转换
    * r +2 可以，但是 2+r 就报错
    *  加上implicit修饰符告诉编译器可以在一些情况下自动调用
    *
    */
  implicit def +(i:Int,j:Int)= {
     new Rational(numer+i*denom,denom)
  }


}


